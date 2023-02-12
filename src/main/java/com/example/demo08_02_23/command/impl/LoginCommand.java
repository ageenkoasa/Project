package com.example.demo08_02_23.command.impl;

import com.example.demo08_02_23.command.Command;
import com.example.demo08_02_23.service.UserService;
import com.example.demo08_02_23.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");
        UserService userService = UserServiceImpl.getInstance();
        String page;
        boolean match = userService.authenticate(login, password);
        if (match) {
            request.setAttribute("user", login);
            page = "pages/main.jsp";
        } else {
            request.setAttribute("login_msg", "incorrect login or password");
            page = "index.jsp";
        }
        return page;
    }
}
