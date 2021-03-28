springMvc配置-WEB.XML：
```xml
<!-- Spring MVC配置 -->
<!-- ====================================== -->
<servlet>
	<servlet-name>spring</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<!-- 可以自定义servlet.xml配置文件的位置和名称，默认为WEB-INF目录下，名称为[<servlet-name>]-servlet.xml，如spring-servlet.xml
	<init-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/spring-servlet.xml</param-value>  默认
	</init-param>
	-->
	<load-on-startup>1</load-on-startup>
</servlet>
 
<servlet-mapping>
	<servlet-name>spring</servlet-name>
	<url-pattern>*.do</url-pattern>
</servlet-mapping>
  
 
 
<!-- Spring配置 -->
<!-- ====================================== -->
<listener>
	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
  
 
<!-- 指定Spring Bean的配置文件所在目录。默认配置在WEB-INF目录下 -->
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>classpath:config/applicationContext.xml</param-value>
</context-param>

SPRING配置文件：

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"     
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"     
        xmlns:context="http://www.springframework.org/schema/context"     
   xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd   
       http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd   
       http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.0.xsd   
       http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd">
 
	<!-- 启用spring mvc 注解 -->
	<context:annotation-config />
 
	<!-- 设置使用注解的类所在的jar包 -->
	<context:component-scan base-package="controller"></context:component-scan>
 
	<!-- 完成请求和注解POJO的映射 -->
	<bean class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter" />
 
	<!-- 对转向页面的路径解析。prefix：前缀， suffix：后缀 -->
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" p:prefix="/jsp/" p:suffix=".jsp" />

APPLICATIONCONTEXT.XML配置：

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:aop="http://www.springframework.org/schema/aop"
		xmlns:tx="http://www.springframework.org/schema/tx"
		xsi:schemaLocation="
			http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
			http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.5.xsd
			http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-2.5.xsd">
 
	<!-- 采用hibernate.cfg.xml方式配置数据源 -->
	<bean id="sessionFactory" class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
		<property name="configLocation">
			<value>classpath:config/hibernate.cfg.xml</value>
		</property>
	</bean>
	
	<!-- 将事务与Hibernate关联 -->
	<bean id="transactionManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager">
		<property name="sessionFactory">
			<ref local="sessionFactory"/>
		</property>
	</bean>
	
	<!-- 事务（注解 ）-->
	<tx:annotation-driven transaction-manager="transactionManager" proxy-target-class="true"/>
 
 	<!-- 测试Service -->
 	<bean id="loginService" class="service.LoginService"></bean>
 
	<!-- 测试Dao -->
	<bean id="hibernateDao" class="dao.HibernateDao">
		<property name="sessionFactory" ref="sessionFactory"></property>
	</bean>
</beans>
