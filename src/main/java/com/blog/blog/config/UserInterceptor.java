package com.blog.blog.config;

import com.blog.blog.entity.UserEntity;
import com.blog.blog.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Optional;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        if(session != null && session.getAttribute("user_session_id") != null){
            Integer userId = Integer.parseInt(session.getAttribute("user_session_id").toString());
            Optional<UserEntity> optionalUser = userService.getuserBYId(userId);
            if(optionalUser.isPresent()){
                request.setAttribute("user", optionalUser.get());
            }else{
                return false;
            }
        }

        return true;
    }
}
