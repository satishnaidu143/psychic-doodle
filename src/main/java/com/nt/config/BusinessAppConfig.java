package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;import lombok.val;

@Configuration
@Import(value= { ServicesConfig.class,DAOConfig.class})
public class BusinessAppConfig {

}
