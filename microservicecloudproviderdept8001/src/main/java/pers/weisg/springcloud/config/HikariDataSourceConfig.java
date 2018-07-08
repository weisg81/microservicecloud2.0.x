package pers.weisg.springcloud.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/** 
 * @Description: TODO(用一句话描述该文件做什么)
 * @author WEISANGNG   
 * @date 2018年5月14日   
 */
@Configuration
public class HikariDataSourceConfig {

	@Bean(name = "hikariDataSource")
	@Qualifier("hikariDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public DataSource hikariDataSource() {
	    System.out.println("Building hikariDataSource......");
	    DataSourceBuilder<HikariDataSource> type = DataSourceBuilder.create().type(HikariDataSource.class);
	    type.password("root");
	    return type.build();
	}
}
