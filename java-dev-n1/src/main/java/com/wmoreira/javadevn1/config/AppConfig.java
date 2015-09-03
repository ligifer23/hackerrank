package com.wmoreira.javadevn1.config;

import com.wmoreira.javadevn1.business.validator.DefaultValidator;
import com.wmoreira.javadevn1.business.validator.ValidatorResolver;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author wellington.362@gmail.com
 */
@Configuration
@ComponentScan(basePackages = "com.wmoreira.javadevn1")
@EnableJpaRepositories(basePackages = "com.wmoreira.javadevn1.integration")
public class AppConfig extends WebMvcConfigurerAdapter {

    private static final String SCRIPTS_BASE = "classpath:db/scripts/";

    @Bean(name = "validatorFactory")
    public ValidatorFactory validatorFactory() {
        return Validation.byProvider(HibernateValidator.class).configure().buildValidatorFactory();
    }

    @Bean(name = "validator")
    public Validator validator() {
        return validatorFactory().getValidator();
    }

    @Bean
    public ValidatorResolver defaultValidator() {
        return new DefaultValidator();
    }

    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
	    return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .setName("zipcode")
                .addScripts(SCRIPTS_BASE.concat("schema.sql"), SCRIPTS_BASE.concat("uf.sql"),
                            SCRIPTS_BASE.concat("cidades.sql"), SCRIPTS_BASE.concat("bairros.sql"),
                            SCRIPTS_BASE.concat("rua.sql"))
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setPackagesToScan("com.wmoreira.javadevn1.business");
        entityManagerFactory.setJpaDialect(new HibernateJpaDialect());

        return entityManagerFactory;
    }
}
