##   Spring事务管理器实现类

>org.springframework.orm.jpa.JpaTransactionManager  JPA事务管理类

>org.springframework.orm.hibernate3.HibernateTransactionManager Hibernate3.0事务管理类

>org.springframework.orm.jdbc.datasource.DataSourceTransactionManager 使用JDBC、MyBatis等基于数据源的持久化技术的事务管理类

>org.springframework.orm.jdo.JdoTransactionManager 使用JDO进行持久化时，使用该事务管理器

>org.springframework.transaction.jta.JtaTransactionManager 需要跨数据源时使用该事务管理类


##   Spring事务传播类型

> PROPAGATION_REQUIRED 如果当前没有事务，就创建一个事务，如果已经存在一个事务中。就加入这个事务

> PROPAGATION_SUPPORTS 如果当前没有事务就以非事务方式执行

> PROPAGATION_MANDATORY 使用当前事务，如果没有就抛出异常

> PROPAGATION_REQUIRES_NEW 新建事务，如果当前存在事务，就挂起当前事务

> PROPAGATION_NOT_SUPPORTED 以非事务方式执行，如果当前存在事务，就挂起事

> PROPAGATION_NEVER 以非事务方式执行，如果当前存在事务，就抛出异常

> PROPAGATION_NESTED   如果当前存在事务，则在嵌套事务内执行。如果没有，就执行PROPAGATION_REQUIRED类似的操作

##  Spring事务管理的配置

### 传统Spring事务配置

传统的Spring事务管理配置，一般根据不同持久化技术，先声明一个DataSource，再声明一个SessionFactory或EntityManagerFactory之类的工厂Bean引用DataSource（JDBC|MyBatis不需要），
再声明一个对应持久化技术的TransactionManager引用Factory或者DataSource。
最后都使用`TransactionProxyFactory`引用TransactionManager，创建代理
```
<bean id="proxy" class="org.springframework.transaction.intercepter.TransactionProxyFactoryBean"
    p:transactionManager-ref="p:transactionManager"
    p:target-ref="target">
    <property name="transactionAttributes">
        <props>
            <prop key="get*">PROPAGATION_REQUIRED,readOnly</prop>
            <prop key="*">PROPAGATION_REQUIRED</prop>
        </props>
    </property>
</bean>
```
如上所示，我们可以发现TransactionProxyFactoryBean其实就是根据指定类的静态方法签名匹配，为代理类织入事务管理的代码，
Spring的事务管理其实就是对Spring AOP的一个很好的应用。

### 基于tx/aop命名空间的配置

配置Spring事务管理和配置Spring AOP的切面其实是一样的当然也可以使用tx/aop命名空间，有需要请自行学习

使用注解配置声明式事务

直接在需要加入事务的方法上面使用`@Transactional`注解，
再在配置文件中加入
`<tx:annotation-driven transaction-manager="transactionManager"/>`
或者在配置类上加上`@EnableTransactionManagement`即可，
当然`@Transactional`注解也可以用在类上，
类上表示类中的所有public的方法都会织入事务代码。

@Transactional属性如下：
1.  propagation 设定事务传播行为，值为Propagation的枚举值
2.  isolation 设置事务的隔离级别，值为Isolation的枚举值
3.  readOnly 设置是否为只读事务，值为boolean
4.  timeout 设置超时时间，值为int型，单位为秒
5.  rollbackFor 设定遇到时需要回滚的异常，值为Class<? extends Exception>[]
6.  rollbackForClassName 设定遇到时需要回滚的异常，值为String[]，异常名称数组
7.  noRollbackFor 设定遇到时不需要回滚的异常，值同上rollbackFor
8.  noRollbackForClassName ......



#   Spring 单元测试回滚总结

##  目的方法
```
    @Transactional
    public void insertFooAndThrowException(){
        // 先插入 然后抛出异常
        mapper.insertFoo(RandomStringUtils.randomAlphanumeric(20)); 
        throw new RuntimeException("Mock throw exception after insert foo");
    }
```
##  测试类
```
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ApplicationContextTest.xml" })
public class TransactionRollbackTest{
    @Autowired
    private FooService fooService;
    @Test
    public void test_insertFooAndThrowException(){
        fooService.insertFooAndThrowException();
    }
}
```
1、 目的方法不含事务注解（//@Transactional） 执行过程中抛出异常 此时会插入成功

对应sql为：
```
2016-06-18T09:26:47.905229Z   33 Query    SET autocommit=1
2016-06-18T09:26:47.939430Z   33 Query    select @@session.tx_read_only
2016-06-18T09:26:47.939875Z   33 Query    insert into foo(a) values('OXrJKEkGCnnyH010ZkTv')
```
2、 目的方法含事务注解 若执行过程中抛了异常 会自动回滚
```
2016-06-18T09:19:05.766030Z   31 Query    SET autocommit=0
2016-06-18T09:19:05.829996Z   31 Query    select @@session.tx_read_only
2016-06-18T09:19:05.830454Z   31 Query    insert into foo(a) values('oH2AgMnkrScpf4fGccIo')
2016-06-18T09:19:05.831384Z   31 Query    rollback
```
3、 目的方法含事务注解 但测试类显式指定不回滚 如下所示
```
@TransactionConfiguration(defaultRollback = false)
public class TransactionRollbackTest
```
此时实际仍会回滚
```
2016-06-18T09:29:51.509882Z   35 Query    SET autocommit=0
2016-06-18T09:29:51.575956Z   35 Query    select @@session.tx_read_only
2016-06-18T09:29:51.576327Z   35 Query    insert into foo(a) values('RN2pujPfOA03MbxIkgjI')
2016-06-18T09:29:51.577155Z   35 Query    rollback
```
此种情形 与2类似

4、 目的方法含事务注解 测试类也有事务注解且显式指定不回滚 如下所示
```
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class TransactionRollbackTest
```
执行测试 会有如下的异常
```
org.springframework.transaction.UnexpectedRollbackException: Transaction rolled back because it has been marked as rollback-only

    at org.springframework.transaction.support.AbstractPlatformTransactionManager.commit(AbstractPlatformTransactionManager.java:720)
    at org.springframework.test.context.transaction.TransactionalTestExecutionListener$TransactionContext.endTransaction(TransactionalTestExecutionListener.java:597)
```
但实际仍会回滚
```
2016-06-18T09:32:42.072941Z   37 Query    SET autocommit=0
2016-06-18T09:32:42.134612Z   37 Query    select @@session.tx_read_only
2016-06-18T09:32:42.135024Z   37 Query    insert into foo(a) values('SeLtrEiQdkTRmcnjNNAy')
2016-06-18T09:32:42.136505Z   37 Query    rollback
```
为什么在测试类中添加了事务注解就会报上述异常呢？ 事务注解放在测试类与目的方法中的区别是？
下面代码处加上断点 比较调用链

doRollback:284, DataSourceTransactionManager (org.springframework.jdbc.datasource)
仅在目的方法中有事务注解 测试类无事务注解
```
at org.springframework.jdbc.datasource.DataSourceTransactionManager.doRollback(DataSourceTransactionManager.java:284)
at org.springframework.transaction.support.AbstractPlatformTransactionManager.processRollback(AbstractPlatformTransactionManager.java:849)
at org.springframework.transaction.support.AbstractPlatformTransactionManager.rollback(AbstractPlatformTransactionManager.java:826)
at org.springframework.transaction.interceptor.TransactionAspectSupport.completeTransactionAfterThrowing(TransactionAspectSupport.java:496)
at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:266)
at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:644)
at com.foo.service.FooService$$EnhancerBySpringCGLIB$$58f57234.insertFooAndThrowException(<generated>:-1)
at com.foo.service.TransactionRollbackTest.test_insertFooAndThrowException(TransactionRollbackTest.java:26)
```
目的方法与测试类均有事务注解
```
at org.springframework.jdbc.datasource.DataSourceTransactionManager.doRollback(DataSourceTransactionManager.java:284)
at org.springframework.transaction.support.AbstractPlatformTransactionManager.processRollback(AbstractPlatformTransactionManager.java:849)
at org.springframework.transaction.support.AbstractPlatformTransactionManager.commit(AbstractPlatformTransactionManager.java:716)
at org.springframework.test.context.transaction.TransactionalTestExecutionListener$TransactionContext.endTransaction(TransactionalTestExecutionListener.java:597)
at org.springframework.test.context.transaction.TransactionalTestExecutionListener.endTransaction(TransactionalTestExecutionListener.java:296)
at org.springframework.test.context.transaction.TransactionalTestExecutionListener.afterTestMethod(TransactionalTestExecutionListener.java:189)
at org.springframework.test.context.TestContextManager.afterTestMethod(TestContextManager.java:416)
at org.springframework.test.context.junit4.statements.RunAfterTestMethodCallbacks.evaluate(RunAfterTestMethodCallbacks.java:91)
```
5、目的方法含事务注解 测试类含事务注解且设置默认回滚
```
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class TransactionRollbackTest
```
没有上述异常 且多了如下的日志输出
```
016-06-18 17:55:15,644 - org.springframework.test.context.transaction.TransactionalTestExecutionListener -2126 [main] INFO - Rolled back transaction after test execution for test context [DefaultTestContext@3310ce7b testClass = TransactionRollbackTest, testInstance = com.foo.service.TransactionRollbackTest@1464076e, testMethod = test_insertFooAndThrowException@TransactionRollbackTest, testException = java.lang.RuntimeException: Mock throw exception after insert foo, mergedContextConfiguration = [MergedContextConfiguration@3323d137 testClass = TransactionRollbackTest, locations = '{classpath:spring/ApplicationContextTest.xml}', classes = '{}', contextInitializerClasses = '[]', activeProfiles = '{}', contextLoader = 'org.springframework.test.context.support.DelegatingSmartContextLoader', parent = [null]]]
```
sql为
```
2016-06-18T09:55:15.578650Z   41 Query    SET autocommit=0
2016-06-18T09:55:15.641818Z   41 Query    select @@session.tx_read_only
2016-06-18T09:55:15.642228Z   41 Query    insert into foo(a) values('1HlH0xmi5bJL01GlEucm')
2016-06-18T09:55:15.643248Z   41 Query    rollback
```
