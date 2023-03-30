package org.echo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@Import({ SecurityConfig.class})
public class AppConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.second-datasource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

/*
    So we can call hen you can use it like

      @Transactional //this will use the first datasource because it is @primary
       or
      @Transactional("tm2")

    @Bean(name = "tm1")
    @Autowired
    @Primary
    DataSourceTransactionManager tm1(@Qualifier("datasource1") DataSource datasource) {
        DataSourceTransactionManager txm = new DataSourceTransactionManager(datasource);
        return txm;
    }

    @Bean(name = "tm2")
    @Autowired
    DataSourceTransactionManager tm2(@Qualifier("datasource2") DataSource datasource) {
        DataSourceTransactionManager txm = new DataSourceTransactionManager(datasource);
        return txm;
    }*/
}
