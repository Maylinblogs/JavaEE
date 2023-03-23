package com.example.pruduser;

import com.example.pruduser.config.JMSResource;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class MessageServlet extends HttpServlet {

    @Inject
    private JMSResource jmsResource;

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Integer> list = new ArrayList<>();
        Integer first = Integer.valueOf(req.getParameter("first"));
        Integer second = Integer.valueOf(req.getParameter("second"));
        Integer third = Integer.valueOf(req.getParameter("third"));
        list.add(first);
        list.add(second);
        list.add(third);
        jmsResource.sendMessage(list);
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }

    public void destroy() {
    }
}