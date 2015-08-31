package com.wmoreira.javadevn1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by welingtonmoreira on 31/08/15.
 */
public class AppConfig {
    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
	return new EmbeddedDatabaseBuilder()
			       .setType(EmbeddedDatabaseType.H2)
			       .build();
    }
}
