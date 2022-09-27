package com.hexiaofei.dubbo.provider;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import java.io.IOException;

@ComponentScan(value = {"com.hexiaofei.dubbo.provider"})
public class DubboProviderApplication {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DubboProviderApplication.class);
        context.refresh();
        System.out.println("Provider is starting...");
        System.in.read();

    }

}
