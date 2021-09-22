package com.xk.sign.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.xk.sign.bean.Root;
import com.xk.sign.bean.User;
import com.xk.sign.mapper.RootMapper;
import com.xk.sign.mapper.UserMapper;
import com.xk.sign.token.LoginToken;
import com.xk.sign.token.PassToken;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class TokenInterceptor implements HandlerInterceptor {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Resource(name = "rootMapper")
    private RootMapper rootMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        if (method.isAnnotationPresent(LoginToken.class)) {
            LoginToken loginToken = method.getAnnotation(LoginToken.class);
            if (loginToken.required()) {
                if (token == null) {
                    throw new RuntimeException("无Token,请重新登录");
                }
                if (request.getServletPath().contains("/user")){
                    int userId;
                    try {
                        userId = Integer.parseInt(JWT.decode(token).getAudience().get(0));
                    } catch (JWTDecodeException e) {
                        throw new RuntimeException("解码错误");
                    }

                    User user = userMapper.getUserById(userId);
                    if (user == null) {
                        throw new RuntimeException("用户不存在,请重新登录");
                    }
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                    try {
                        jwtVerifier.verify(token);
                    } catch (JWTVerificationException e) {
                        throw new RuntimeException("验证token错误");
                    }
                    return true;
                }
                if (request.getServletPath().contains("/root")){
                    int rootId;
                    try {
                        rootId = Integer.parseInt(JWT.decode(token).getAudience().get(0));
                    } catch (JWTDecodeException e) {
                        throw new RuntimeException("解码错误");
                    }

                    Root root = rootMapper.getRootById(rootId);
                    if (root == null) {
                        throw new RuntimeException("用户不存在,请重新登录");
                    }
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(root.getPassword())).build();
                    try {
                        jwtVerifier.verify(token);
                    } catch (JWTVerificationException e) {
                        throw new RuntimeException("验证token错误");
                    }
                    return true;
                }

            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}
