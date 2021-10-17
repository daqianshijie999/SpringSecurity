package com.example.springsecurity.config;

import com.example.springsecurity.handler.LoginFailedHandler;
import com.example.springsecurity.handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailedHandler loginFailedHandler;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        //关闭跨域访问限制
//        http.csrf().disable();
//     //自定义登录表单页面
//     http.formLogin()
//             //登录的页面
//             .loginPage("/login.html")
//             //后端处理登录方法
//             .loginProcessingUrl("/login")
//             //登录成功后转发地址
//             .successForwardUrl("/toMain");
//     //权限配置
//        http.authorizeRequests()
//                //登录页面执行放行
//                .antMatchers("/login.html").permitAll()
//                //其他资源均需登录才可访问
//                .anyRequest().authenticated();
        http.csrf().disable();
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
//                .successForwardUrl("/toMain")
//                .failureForwardUrl("/toLogin")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailedHandler)
        .and()
           .authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .anyRequest().authenticated();
        http.csrf().disable();
    }
}
