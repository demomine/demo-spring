#   spring
##  标准事件
1.  标准事件分类

|名称|解释|备注|
|---|---|---|

| ContextRefreshedEvent | Published when the ApplicationContext is initialized or refreshed, for example, using the refresh() method on the ConfigurableApplicationContext interface. "Initialized" here means that all beans are loaded, post-processor beans are detected and activated, singletons are pre-instantiated, and the ApplicationContext object is ready for use. As long as the context has not been closed, a refresh can be triggered multiple times, provided that the chosen ApplicationContext actually supports such "hot" refreshes. For example, XmlWebApplicationContext supports hot refreshes, but GenericApplicationContext does not.|-|
|ContextStartedEvent|
|ContextStoppedEvent|
|ContextClosedEvent|
|RequestHandledEvent|
##  客户化事件

##  其他