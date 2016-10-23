package com.feedback.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Divakaran Jeyachandran - djeyachandran@expedia.com
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.feedback"})
@EnableJpaRepositories(basePackages = {"com.feedback.repository"})
@EnableTransactionManagement
public class PersistentConfiguration {

}
