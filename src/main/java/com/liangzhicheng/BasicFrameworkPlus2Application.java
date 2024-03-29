package com.liangzhicheng;

import com.liangzhicheng.modules.controller.WebSocketManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BasicFrameworkPlus2Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(BasicFrameworkPlus2Application.class);
        ConfigurableApplicationContext applicationContext = application.run(args);
        //处理启动，WebSocket注入问题
        WebSocketManager.setApplicationContext(applicationContext);
    }

}
