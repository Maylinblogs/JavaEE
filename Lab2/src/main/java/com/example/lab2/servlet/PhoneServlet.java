package com.example.lab2.servlet;

import com.example.lab2.dao.PhoneDao;
import com.example.lab2.model.Phone;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PhoneService", value = "/phone")
public class PhoneServlet extends HttpServlet {

    @EJB(beanName = "phoneDao")
    private PhoneDao phoneDao;

    public void init() {
        System.out.println("Start");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("phones", phoneDao.allPhone());
        request.setAttribute("search", new Phone());
        request.getRequestDispatcher("/WEB-INF/phone.jsp")
                .forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nmodel = req.getParameter("nmodel");
        String ncategory = req.getParameter("ncategory");
        if (nmodel.isEmpty() || ncategory.isEmpty()) {
            req.setAttribute("errorMessage", "Заполните все поля");
        } else {
            phoneDao.delete(nmodel,ncategory);
        }
        req.setAttribute("phones", phoneDao.allPhone());
        req.setAttribute("search", new Phone());
        req.getRequestDispatcher("/WEB-INF/phone.jsp")
                .forward(req, resp);

    }


    public void destroy() {
        System.out.println("End");
    }
}