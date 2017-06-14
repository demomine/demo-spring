#spring
##IOC
### 生命周期管理
1.  实现`InitializingBean`, `DisposableBean`接口
2.  使用`@PostConstruct`, `@PreDestroy`注解
3.  使用`@Bean`会自动调用bean的`close`,`shutdown`方法
4.  调用顺序    
    *   @PostConstruct
    *   InitializingBean 的 afterPropertiesSet 
    *   客户化的 init() 方法
    *   BeanPostProcessor的postProcessBeforeInitialization
    *   BeanPostProcessor的postProcessAfterInitialization
    *   @PreDestroy
    *   DisposableBean 的 destroy()方法
    *   客户化的 destroy() 方法
    
5.  `Lifecycle`接口

### 生命周期内的回调
1.  initialization的回调会在依赖注入之后,拦截器之前进行调用
2.  BeanFactoryAware
    声明BeanFactory
3.  BeanNameAware
    设置Bean名称
4.  MessageSourceAware
5.  ApplicationContextAware
    通过注入ApplicationContext可以进行ApplicationContext
    file resources, publishing application events, 和 accessing a MessageSource
    也可以通过`@Autowire`进行注入
6.  ApplicationEventPublisherAware
    时间发布
    
### 客户化Bean 
参考`http://www.iteye.com/topic/1122859` \
`http://jinnianshilongnian.iteye.com/blog/1492424`
1.  BeanPostProcessor
    *   使用这个processor就不能再使用auto-proxy
2.  BeanFactoryPostProcessor
    *   操作bean的元数据
    *   在任何bean初始化前进行处理
    *   可以添加多个并安排顺序
    *   此时bean还未被示例化,因此获取不到bean的属性
3.  InstantiationAwareBeanPostProcessor
4.  MergedBeanDefinitionPostProcessor
5.  SmartInstantiationAwareBeanPostProcessor
    