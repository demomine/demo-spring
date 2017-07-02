#   spring
##  validation 
1.  使用Validator进行数据校验
2.  常用类
    2.1 Validator
    2.2 Errors
    2.3 ValidationUtils
    2.4 BindingResult
    2.5 DefaultMessageCodesResolver 
##  data bind
1.  dataBind和BeanWrapper使用PropertyEditors 来转换和格式化属性值
2.  BeanWrapper和BeanWrapperImpl
    *   提供属性设置
    *   判断属性的读写权限
    *   获取描述符
    *   添加监听`PropertyChangeListeners`,`VetoableChangeListeners`  
3.  PropertyEditor ，PropertyEditorSupport ，和 PropertyEditorManager 
    3.1 用来转换string和object
    3.2 spring内建的转换器
        *   ByteArrayPropertyEditor
        *   ClassEditor
        *   CustomBooleanEditor
        *   CustomCollectionEditor
        *   CustomDateEditor
        *   CustomNumberEditor
        *   FileEditor
        *   InputStreamEditor
        *   LocaleEditor
        *   PatternEditor
        *   PropertiesEditor
        *   StringTrimmerEditor
        *   URLEditor
        
    3.3 注册方法
        *   CustomPropertyEditorRegistrar .registerCustomEditor
        *   使用CustomEditorConfigurer(参考示例)
        *   使用PropertyEditorRegistrars
        *   和bean放在同一级目录并将名字设置为BeanNameEditor  其中BeanName是bean类的名称
    3.4 PropertyEditor非线程安全
        
###  Type Conversion
1.  Converter   
    *   类型转换 T convert(S source)
2.  ConverterFactory
    *   进行集中式的类型转换
3.  GenericConverter
    *   进行负责类型的转换
4.  ConversionService 
    *   对外提供一些值转换服务接口
5,  ConverterRegistry
    *   注册器
### Formatting
1.  Formatter
2.  FormatterRegistry 
3.  FormatterRegistrar 


### other
1.  BeanWrapper
    `http://blog.csdn.net/zhiweianran/article/details/7919129`
2.  PropertyEditor
    `http://blog.csdn.net/pentiumchen/article/details/44026575`
3.  convention
    `http://blog.csdn.net/pentiumchen/article/details/44066173`