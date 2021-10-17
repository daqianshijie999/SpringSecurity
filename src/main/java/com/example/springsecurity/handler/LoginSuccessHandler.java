package com.example.springsecurity.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
//request.getRequestDispatcher("/toMain").forward(request,response);
    response.setContentType("application/json;charset:utf-8");
    response.setCharacterEncoding("utf-8");
        PrintWriter pw = null;
    pw = response.getWriter();
    pw.write("{\"code\":200,\"msg\":\"登陆成功\"}");
//        Map<String,Object> map=new HashMap<>();
//        map.put("code",200);
//        map.put("msg","登陆成功");
//        pw.write(JSON.toJSONString(map));
    pw.flush();
    pw.close();
    }
}
