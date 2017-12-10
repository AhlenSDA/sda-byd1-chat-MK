package com.sda.chat.servlets;

import com.sda.chat.hibernate.dao.MessagesDAO;
import com.sda.chat.hibernate.dao.UsersDAO;
import com.sda.chat.hibernate.model.Messages;
import com.sda.chat.hibernate.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "messageBoxServlet", value = "/messageBoxServlet")
public class MessageBoxServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String message = req.getParameter("message");

        UsersDAO usersDAO = new UsersDAO();

        Users loggedInUser = null;

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user_id")) {
                    loggedInUser = usersDAO.getUser(Integer.parseInt(cookie.getValue()));
                }
            }
        }

        if (loggedInUser != null) {
            MessagesDAO messagesDAO = new MessagesDAO();
            messagesDAO.createMessage(new Messages(System.currentTimeMillis(), message, loggedInUser));
            resp.sendRedirect("index.jsp");
        }
    }
}