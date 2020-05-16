package com.zhang.config;

import com.zhang.pojo.Books;
import com.zhang.service.BooksService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.util.StringUtils;

/**
 * 自定义的realm
 */
public class UserRealm extends AuthorizingRealm {
    //改用数据库查询用户信息
    @Autowired
    BooksService booksService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进行授权==AuthorizationInfo");
        //为用户授权
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        Books books = (Books) subject.getPrincipal();
        authorizationInfo.addStringPermission(books.getPerms());
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证==AuthenticationInfo");
        String name = "root";
        String pwd = "0000";
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        if(StringUtils.isEmpty(username)){
            return null;
        }
        Books books = booksService.quertByNm(token.getUsername());
        if(books == null){
            return null;
        }
        /*if(!StringUtils.equals(token.getUsername(),name)){
            return null;
        }*/
        //密码认证
        return new SimpleAuthenticationInfo(books,books.getBookCounts(),"");
    }

}
