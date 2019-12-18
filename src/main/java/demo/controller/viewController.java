package demo.controller;

import demo.service.IBlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class viewController {

    private static final Logger logger = LoggerFactory.getLogger(viewController.class);
    @Autowired
    private IBlogService blogService;


    @RequestMapping("/indexpage")
    public String index(){
        return "index";
    }

    @RequestMapping("/")
    public String defaultPage(){
        return "redirect:login";
    }

    @RequestMapping("/login")
    public String login(){
        logger.info("login access!");
        return "login";
    }

    @RequestMapping("/addBlog")
    public String addBlog(String token){
        return "editBlog";
    }

}
