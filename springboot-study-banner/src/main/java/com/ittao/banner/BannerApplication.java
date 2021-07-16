package com.ittao.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BannerApplication.class, args);

//        SpringApplication app = new SpringApplication(BannerApplication.class);
//        // 关闭 Banner，可选值 CONSOLE、LOG、OFF
//        app.setBannerMode(Banner.Mode.OFF);
//        app.run(args);
    }
}
