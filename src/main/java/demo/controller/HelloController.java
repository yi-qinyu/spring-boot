package demo.controller;

import demo.model.Hello;
import demo.model.Quote;
import demo.service.IBlogService;
import demo.utils.CommonUtils;
import demo.utils.SpringUtil;
import demo.utils.TokenUtil;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private static final String stringtemp = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IBlogService blogService;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/hello")
    public Hello greeting(@RequestParam(value="name", defaultValue="World") String name) {
        RestTemplate restTemplate= (RestTemplate)SpringUtil.getBean("restTemplate");
        Quote quote = restTemplate.getForObject(
                "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        logger.info(quote.toString());
        return new Hello(counter.incrementAndGet(),
                String.format(stringtemp, name));
    }

    @RequestMapping("/getData")
    public Object getdata(){
        String sql="select * from t_area";
        List<Map<String, Object>> ls = jdbcTemplate.queryForList(sql);
        return "<html><body><h1>hello spring boot!<h1></body></html>";
    }

    @PostMapping("/dologin")
    public Map<String,Object> doLogin(String user,String pwd){
        logger.info(user+pwd);
        Map<String,Object> tokenparam = new HashMap<String,Object>();
        tokenparam.put("id", TokenUtil.getTokenId());
        tokenparam.put("user",user);
        String token = TokenUtil.getTokenString(tokenparam);
        redisTemplate.opsForValue().set(user,token);
        Map<String,Object> res=new HashMap<String,Object>();
        res.put("token",token);
        return res;
    }

    @PostMapping("/addCustomer")
    public boolean addCustomer(String name,String age,String address,String token){
        logger.info(name+"\r\n"+age+"\r\n"+address+"\r\n"+token);
        String[] tokens =token.split("\\.");
        Object serverToken =redisTemplate.opsForValue().get(tokens[2]);
        if(null!=serverToken){
            String stoken = (String)serverToken;
            if(stoken.equals(token)){//处于登录有效状态
                return true;
            }
        }
        return false;
    }

    @PostMapping("/editBlog")
    public boolean editBlog(String bwbt,String content,String token,String userid){

        return false;
    }

    @RequestMapping("/initBwfl")
    public Object initBwfl(){
        List<Map<String,Object>> data = (List<Map<String,Object>>) blogService.queryAddBlogParam().get("bwfl");
        return data;
    }


}
