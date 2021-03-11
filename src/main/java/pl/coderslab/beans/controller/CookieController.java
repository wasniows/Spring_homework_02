package pl.coderslab.beans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CookieController {

@RequestMapping ("/add-cookies")
    @ResponseBody
    public String addCookies(HttpServletResponse response){
    Cookie cookie1 = new Cookie("user", "Jan");
    Cookie cookie2 = new Cookie("uid","ccb1b154-c4ff");
    Cookie cookie3 = new Cookie("IDE", "IntelliJ");
    cookie1.setPath("/");
    cookie2.setPath("/");
    cookie3.setPath("/");
    cookie1.setMaxAge(600);
    cookie2.setMaxAge(864000);
    cookie3.setMaxAge(2592000);
    response.addCookie(cookie1);
    response.addCookie(cookie2);
    response.addCookie(cookie3);
    return "";
}

    @RequestMapping("/all-cookies")
    public String allCookies(HttpServletRequest request){

    List<Cookie> cookieList = new ArrayList<>();
    Cookie user = WebUtils.getCookie(request, "user");
    Cookie uid = WebUtils.getCookie(request, "uid");
    Cookie ide = WebUtils.getCookie(request, "IDE");
    cookieList.add(user);
    cookieList.add(uid);
    cookieList.add(ide);
    request.setAttribute("cookieList", cookieList);
    Cookie[] cookies = request.getCookies();
    request.setAttribute("cookies",cookies);
    return "cookies.jsp";
    }
}
