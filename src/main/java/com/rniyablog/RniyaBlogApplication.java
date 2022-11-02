package com.rniyablog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author: Rniya
 * @date: 2022年09月04日 16:03
 * @Description: 启动类
 */

@SpringBootApplication
@EnableCaching //注解配置启用缓存
public class RniyaBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(RniyaBlogApplication.class, args);
	}

}
