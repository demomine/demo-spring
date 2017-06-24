#   spring

##  Resource
1.  Resource 接口
    *   InputStream getInputStream() throws IOException
    *   boolean exists();    
    *   boolean isOpen();   
    *   URL getURL() throws IOException;    
    *   File getFile() throws IOException;    
    *   Resource createRelative(String relativePath) throws IOException;    
    *   String getFilename();    
    *   String getDescription();
    
2.  Resource的实现
    *   UrlResource
    *   ClassPathResource
    *   FileSystemResource
    *   ServletContextResource
    *   InputStreamResource
    *   ByteArrayResource
    
3.  ResourceLoader 接口
    *   接口方法Resource getResource(String location)
    *   所有的SpringContext均实现了此接口
    *   如果context.getResource(location) 中location没有前缀则默认和context类型保持一致
    *   可以使用前缀限定资源的类型
    
4.  资源前缀和使用的加载类列表
    |Prefix|Example|Explanation|
    |---|---|---|
    |classpath:| classpath:com/myapp/config.xml| Loaded from the classpath.|
    |file:|file:///data/config.xml|Loaded as a URL, from the filesystem|
    |http:|http://myserver/logo.png|Loaded as a URL.|
    |(none)|/data/config.xml|Depends on the underlying ApplicationContext.|
    
5.  ResourceLoaderAware 接口
    *   接口方法void setResourceLoader(ResourceLoader resourceLoader)
    *   也可以通过Autowired的方式注入ResourceLoader 
    
6.  通配符的使用
    *   如果spring的bean需要注入Resource，可以直接注入string，spring内部会转换为Resource
    *   支持以通配符的方式加载context资源
    *   通配符的使用只在构建context的时候才能使用，直接构建Resource不支持
    *   如果资源的解析是Jar方式则使用JarURLConnection 否则使用File 
    *   如果以Jar的方式解析，有可能产生环境依赖，需要仔细测试操作系统环境的影响
    *   通配符的使用通过ResourceLoader.getResources方法获得
    *   由于ClassLoader.getResources()的限制，除非目标文件存在于文件系统中，否则不会以根路径查找资源而是根路径的扩展路径开始
    *   spring可以通过指定classpath*:与classpath:前缀加路径的方式从classpath加载文件,如bean的定义文件.
    *   classpath*:的出现是为了从多个jar文件中加载相同的文件.classpath:只能加载找到的第一个文件.
    *   如果是在不同的J2EE服务器上运行,由于应用服务器提供自己的classloader实现，它们在处理jar文件时的行为也许会有所不同。 
    *   要测试classpath*: 是否有效，可以用classloader从classpath中的jar文件里加载文件来进行测试：getClass().getClassLoader().getResources("<someFileInsideTheJar>")
    *   FileSystemXmlApplicationContext 仅使用相对路径进行文件加载，如果想使用绝对路径，请使用file前缀，例如file:///conf/context.xml