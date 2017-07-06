#   spring
##  AOP APIS
### Pointcut
>Pointcut是JoinPoint的集合，它是程序中需要注入Advice 的位置的集合，指明Advice要在什么样的条件下才能被触发。
1.  Pointcut接口
    1.1.  ClassFilter
    1.2.  MethodMatcher
2.  操作
    2.1.    union 组合
    2.2.    intersection 正交
    2.3.    静态使用`Pointcuts`,否则使用`ComposablePointcut`
    2.4.    静态是指匹配pointcut在执行前就已经确认匹配的方法
    2.5.    静态切入点只限于给定的方法和目标类，而不考虑方法的参数。Spring在调用静态切入点时只在第一次的时候计算静态切入点的位置，然后把它缓存起来
    2.6.     动态切入点与静态切入点的区别是，它不仅限定于给点的方法和类，动态切入点还可以指定方法的参数
3.  AspectJ表达式
    参考AspectJ语法
4.  实现
    4.1.    JdkRegexpMethodPointcut
    4.2.    RegexpMethodPointcutAdvisor
5.  pointcut类型
    5.1.    Attribute-driven
    5.2.    Dynamic pointcuts
    5.3.    Control flow
    5.4.    Custom
6.  超类
    6.1.    StaticMethodMatcherPointcut
7.  自定义
7.  其他
    7.1.    尽量使用静态pointcut
    
### Advice
>   它是某个连接点所采用的处理逻辑，也就是向连接点注入的代码。例如：输出的日志信息   就是一个Advice
1.  生命周期
    1.1.    Per-class advice
    1.2.    Per-instance
2.  类型
    2.1.    Around advice
    >   MethodInterceptor
    
    2.2.    Before advice
    >   MethodBeforeAdvice
    
    2.3.    Throws advice
    >   ThrowsAdvice
    
    2.4.    After Returning advice
    >   AfterReturningAdvice
    
    2.5.    Introduction advice(增强型 Around advice)
    >   IntroductionInterceptor
    >   IntroductionAdvisor

### Advisor
>Advisor是Pointcut和Advice的配置器，它包括Pointcut和Advice，是将Advice注入程序中Pointcut位置的代码
1.  常用处理
    1.1.    DefaultPointcutAdvisor
    
### AOP proxies
1.  ProxyFactoryBean
    1.1.    通过ProxyFactoryBean创建的代理,advice和pointcut都可以被IOC管理
    1.2.    属性可以用来指定代理的目标和是否使用CGLIB进行代理
    1.3.    proxyTargetClass=true表示代理类,而不是代理类锁实现的接口,从而使用CGLIB进行代理
    1.4.    optimize    是否使用AOP优化属性
    1.5.    frozen      不再允许配置变更
    1.6.    exposeProxy 是否把当前代理放入threadlocal,通过AopContext.currentProxy()获取
2.  通过程序创建
    ```
    ProxyFactory factory = new ProxyFactory(myBusinessInterfaceImpl);
    factory.addAdvice(myMethodInterceptor);
    factory.addAdvisor(myAdvisor);
    MyBusinessInterface tb = (MyBusinessInterface) factory.getProxy();
    ```
    
3.  Advised
    3.1.    所有的代理都可以被转换为Advised接口实现
    3.2.    实现代码
    ```
    Advised advised = (Advised) myObject;
    Advisor[] advisors = advised.getAdvisors();
    int oldAdvisorCount = advisors.length;
    System.out.println(oldAdvisorCount + " advisors");
    advised.addAdvice(new DebugInterceptor());
    // Add selective advice using a pointcut
    advised.addAdvisor(new DefaultPointcutAdvisor(mySpecialPointcut, myAdvice));
    assertEquals("Added two advisors", oldAdvisorCount + 2, advised.getAdvisors().length);
    ```

4.  auto-proxy
    4.1 作用
    >   这种方式是用户getBean的时候始终是代理后的类
    
    4.2 实现方式
    >   通过在context指定特殊的bean来使用auto-proxy creator
    >   通过source-level metadata attributes
    
    4.3.    BeanNameAutoProxyCreator
    4.4.    DefaultAdvisorAutoProxyCreator
    >   方便在多出业务逻辑处应用advice
    >   可以过滤和排序
    
5.  TargetSources
    5.1.    HotSwappableTargetSource
        ```
        HotSwappableTargetSource swapper = (HotSwappableTargetSource) beanFactory.getBean("swapper");
        Object oldTarget = swapper.swap(newTarget);
        ```
    5.2.    Pooling target sources
    5.3.    Prototype target sources
    5.4.    ThreadLocal target sources
    
### 定义新 Advice types


##  其他
### 异常
1.  Bean named 'aopDemo' is expected to be of type 'com.lance.demo.spring.aop.AopDemo' but was actually of type 'com.sun.proxy.$Proxy29'
    >设置 proxyFactoryBean.setProxyTargetClass(true);
    

    
    
