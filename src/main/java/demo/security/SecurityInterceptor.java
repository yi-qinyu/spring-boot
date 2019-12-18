package demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        HttpSession session = request.getSession();
        if (session.getAttribute(WebSecurity.SESSION_KEY) != null)
            return true;

        // 跳转登录
        String url = "/login";
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

}