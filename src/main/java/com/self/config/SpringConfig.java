package com.self.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 作者：boys
 * 创建时间：2017-08-23 16:59
 * 类描述：
 * 修改人：
 * 修改时间：
 */

@Configuration
@ComponentScan(basePackages = {"com.self"})
@Import({MyBatisConfig.class})
@PropertySource("classpath:/application.properties")
public class SpringConfig {
}
