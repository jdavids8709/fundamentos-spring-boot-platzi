package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public MyBean myBeanOperation(){
        return new MyBean2Impl();
    }

    @Bean
    public MyOperation myBeanOperation2(){
        return new MyOperationImpl();
    }

    @Bean
    public MyBeanWithDependency myBeanOperationWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImpl(myOperation);
    }
}
