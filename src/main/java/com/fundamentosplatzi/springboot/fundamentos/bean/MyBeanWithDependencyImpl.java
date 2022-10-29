package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import java.util.logging.LogManager;

public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

    private MyOperation myOperation;

    private Log log = LogFactory.getLog(MyBeanWithDependencyImpl.class);

    public MyBeanWithDependencyImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        try{
            int number = 1;
            System.out.println(myOperation.sum(number));
            System.out.println("Hello from MyBeanWithDependencyImpl");
            log.info( "Hello from MyBeanWithDependencyImpl" );
            log.info( "Operation Sum:" + myOperation.sum(number) );

            //double a = number / 0;

        }catch (Exception e){
            log.error(e.getMessage(), e);
        }

    }
}
