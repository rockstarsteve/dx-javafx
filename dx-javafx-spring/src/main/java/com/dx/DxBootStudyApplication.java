package com.dx;

import javafx.application.Application;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DxBootStudyApplication implements CommandLineRunner {


    //定义fx是否启动
    private static boolean fxLaunch = false;

    public static void main(String[] args) {
        SpringApplication.run(DxBootStudyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (fxLaunch) {
//            sentUpgradeRegister();
        } else {
            fxLaunch = true;
            Application.launch(NodeApp.class, args);
        }
    }
}
