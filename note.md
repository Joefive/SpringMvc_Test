#springMvc配置文件：
##原始WEB.XML
```xml
<servlet>
	<servlet-name>spring</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<init-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/spring-servlet.xml</param-value>
	</init-param>
	<load-on-startup>1</load-on-startup>
</servlet>
 
<servlet-mapping>
	<servlet-name>spring</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>
```
##原始spingmvc-servlet.xml
```xml
    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>
    <!--处理器适配器-->
    <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>
    <!--添加视图解析器，都是spring原装类进行操作，简化流程，可以学习模板引擎thymeleaf-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="InternalResourceViewResolver">
        <!--从定向前缀-->
        <property name="prefix" value="/WEB-INF/page/"/>
        <!--后缀路径-->
        <property name="suffix" value=".jsp"/>
    </bean>
    <!--配置spring Handle-->
    <bean name="/test" class="com.sunrise.controller.MyTest"/>
```
###注解方式WEB.XML
```xml
    <servlet>
        <servlet-name>smvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!--绑定springmvc配置文件-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:smvc-servlet.xml</param-value>
        </init-param>
        <!--加载顺序，数字越小启动越早-->
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>smvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```

###注解方式springmvc-servlet.xml
```xml
    <!--自动扫描包，在制定位置下生效，由IOC容器统一管理-->
    <context:component-scan base-package="com.sunrise.controller"/>
    <!--让springmvc不处理静态资源-->
    <mvc:default-servlet-handler/>
    <!--让springmvc支持注解驱动-->
    <mvc:annotation-driven/>
    <!--添加视图解析器，都是spring原装类进行操作，简化流程，可以学习模板引擎thymeleaf-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="InternalResourceViewResolver">
        <!--从定向前缀-->
        <property name="prefix" value="/WEB-INF/page/"/>
        <!--后缀路径-->
        <property name="suffix" value=".jsp"/>
    </bean>
```

