package com.example.springsecurity.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoginFailedHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        //request.getRequestDispatcher("/toLogin").forward(request,response);
        response.setContentType("application/json;charset:utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = null;
        pw = response.getWriter();
        pw.write("{\"code\":500,\"msg\":\""+e.getMessage()+"\"}");
        pw.flush();
        pw.close();
    }
}
