package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
@PropertySource("classpath:com/nt/commons/jdbc.properties")
public class DAOConfig {

	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.user}")
	private String user;
	@Value("${jdbc.password}")
	private String password;
	
	@Autowired
	private Environment env;
	@Bean("hikariDS")
	public DataSource createDataSource()
	{
		HikariDataSource ds=null;
		
		ds=new HikariDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driver"));
		ds.setJdbcUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.user"));
		ds.setPassword(env.getProperty("jdbc.password"));
		/*ds.setDriverClassName(driver);
		ds.setJdbcUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);*/
		System.out.println(env.getProperty("JAVA_HOME"));
		System.out.println(env.getProperty("Path"));
		return ds;
	}
}
