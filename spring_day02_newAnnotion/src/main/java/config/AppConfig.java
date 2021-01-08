package config;

import com.hongyi.dao.UserDao;
import com.hongyi.dao.impl.UserDaoImpl;
import com.hongyi.service.UserService;
import com.hongyi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

/*
  本类主要用来替换applicationContext.xml
  @Configuration注解，声明本类是一个配置类
  @Bean注解，修饰方法用于配置创建对象
    1. 方法的返回值就是创建的对象
    2. 默认情况下，方法的名字就是创建对象的id,也可以通过@Bean中的属性，value或name
        手动指定对象的id
    3. 方法的参数表示当前对象所依赖的对象
        参数的使用相当于@Autowired,首先根据参数的类型到当前配置查找是否存在这样的对象类型，
        如果有一个唯一就依赖该唯一的对象，如果有多个对象就根据参数的名字再到配置类中查找是否
        有和参数名字相同的对象的id，如果有就使用，没有就抛异常

   @ComponentScan注解和<context:component-scan base-package="com.hongyi"></context:component-scan>
   功能一致，用于扫描注解（组件）
   @PropertySource类似与mybatis中的properties标签，读取配置文件信息
        value="classpath:文件名"
        classpath类路径
   @Import导入其他配置类，使用该注解的配置类就是主配置类
 */
@Configuration
@ComponentScan(basePackages = {"com.hongyi"})
@Import(JDBCConfig.class)
public class AppConfig {
    /*
      <bean id="userDao" class="com.hongyi.dao.impl.UserDaoImpl" scope="singleton"
     init-method="init" destroy-method="destory" lazy-init="true">
    </bean>
     */
    @Bean(name = "userDao",initMethod = "init",destroyMethod = "destory")
    @Scope(value="singleton")
    @Lazy
    public UserDaoImpl getUserDao(){
        return new UserDaoImpl();
    }
//   @Bean(name="userDao1",initMethod = "init",destroyMethod = "destory")
//    public UserDaoImpl getUserDao1(){
//        return new UserDaoImpl();
//    }
    /*
    <bean id="userService" class="com.hongyi.service.impl.UserServiceImpl">
        <constructor-arg name="userDao" ref="userDao"></constructor-arg>
    </bean>
     */
    @Bean(name = "userService")
    public UserService getUserService(@Qualifier("userDao") UserDao u){
        return new UserServiceImpl(u);
    }
}
