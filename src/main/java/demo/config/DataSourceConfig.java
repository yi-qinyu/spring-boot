package demo.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String driverUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean("dataSource")
    public DataSource dataSource(){
        DruidDataSource dts = new DruidDataSource();
        dts.setUrl(driverUrl);
        dts.setDriverClassName(driverClassName);
        dts.setUsername(username);
        dts.setPassword(password);
        dts.setInitialSize(1);
        dts.setMinIdle(1);
        dts.setMaxActive(30);
        dts.setMaxWait(60000);
        return dts;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

}
