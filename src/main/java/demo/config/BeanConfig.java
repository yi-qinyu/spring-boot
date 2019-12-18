package demo.config;

import demo.dao.IBlogDao;
import demo.dao.impl.BlogDaoImpl;
import demo.model.Quote;
import demo.service.IBlogService;
import demo.service.impl.BlogServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    private static final Logger logger = LoggerFactory.getLogger(BeanConfig.class);

    @Bean(name="restTemplate")
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean(name="run")
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            logger.info(quote.toString());
        };
    }

    @Bean(name = "blogDao")
    public IBlogDao blogDao(){
        IBlogDao blogDao = new BlogDaoImpl();
        return blogDao;
    }

    @Bean(name="blogService")
    public IBlogService blogService(){
        IBlogService blogService = new BlogServiceImpl();
        return blogService;
    }

}
