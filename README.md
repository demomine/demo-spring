#   spring web
##  spring web 特性
1.  角色分离,包括 controller, validator, command object, form object,model object
2.  强大易用的配置
3.  灵活 @RequestParam, @RequestHeader, @PathVariable
4.  可重用的业务代码
5.  可定制化的绑定和校验
6.  可定制化的错误映射和视图
7.  灵活的类型转换
8.  可定制化的locale, time zone and theme resolution
9.  简单强大的jsp标签
10. request和session生命周期管理

##  WebApplicationInitializer
1.  AbstractAnnotationConfigDispatcherServletInitializer
2.  ServletRegistration
3.

##  常用注解
### `@ModelAttribute`
1.  绑定请求参数到命令对象：放在功能处理方法的入参上时，用于将多个请求参数绑定到一个命令对象，从而简化绑
定流程，而且自动暴露为模型数据用于视图页面展示时使用；
2.  暴露表单引用对象为模型数据：放在处理器的一般方法（非功能处理方法）上时，是为表单准备要展示的表单引用
对象，如注册时需要选择的所在城市等，而且在执行功能处理方法（@RequestMapping 注解的方法）之前，自动添加
到模型对象中，用于视图页面展示时使用；
3.  暴露@RequestMapping 方法返回值为模型数据：放在功能处理方法的返回值上时，是暴露功能处理方法的返回值为

### `@RequestParam`

### `@ExceptionHandler`
1.  @controller内的异常处理只针对当前controller
2.  类上注明@ControllerAdvice则标识是全局的
##  DispatcherServlet

##  Interceptor
1.  第一种方式是要定义的Interceptor类要实现了Spring 的HandlerInterceptor 接口，或者是这个类继承实现了HandlerInterceptor 接口的类，比如Spring 已经提供的实现了HandlerInterceptor 接口的抽象类HandlerInterceptorAdapter ；
2.  第二种方式是实现Spring的WebRequestInterceptor接口，或者是继承实现了WebRequestInterceptor的类。
##  RequestContextUtils

##  DispatcherServlet
1.  HandlerMapping
2.  HandlerAdapter
3.  HandlerExceptionResolver
4.  ViewResolver
5.  LocaleResolver & LocaleContextResolver
6.  ThemeResolver
7.  MultipartResolver
8.  FlashMapManager

##  创建URI
1.  创建使用的类`UriComponentsBuilder`和`UriComponents`
2.  UriComponentsBuilder来创建UriComponents
3.  使用UriComponents床架URI

##  CORS
### CORS配置的三种方式
1.  在controller类或者方法上
2.  在继承WebMvcConfigurer后的方法中
3.  使用继承CorsFilter