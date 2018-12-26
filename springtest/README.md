1.分析XmlBeanFactory和ClassPathXmlApplicationContext解析 xml区别
   XmlBeanFactory能实例化@Component，不能实例化@Bean，已过时
   xml中可以用<context:component-scan base-package="com.github"/>替换<context:annotation-config/>，启动注解

   XmlBeanFactory容器启动不会执行BeanFactoryAware和ApplicationContextAware的方法


2.可以通过beanFactory.getBeanDefinitionNames()获取所有bean

3.SimpleMetadataReaderFactory类可以获取class的类元数据和注解元数据
获取class的类型信息 接口信息，注解信息

4.手动向spring容器中注册BeanDefinition
    BeanDefinition listenBeanDefinition = new RootBeanDefinition("com.github.model.User");
    beanFactory.registerBeanDefinition("User", listenBeanDefinition);

5.parent标签使用时，子bean不需要在代码中继承父bean，共用父bean，子bean注入不同的属性

 <bean id="user3" parent="user1">
    <properties   />
 </>

6.对象当map的key时要重写equals()和hashCode()方法