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

@WebServlet(name = "PhoneServiceSearch", value = "/phoneSearch")
public class PhoneSearchServlet extends HttpServlet {

    @EJB(beanName = "phoneDao")
    private PhoneDao phoneDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Phone phone = new Phone();
        String nmodel = req.getParameter("nmodel");
        Boolean nyes = Boolean.valueOf(req.getParameter("nyes"));
        System.out.println(nyes);
        if (nmodel.isEmpty()) {
            req.setAttribute("errorMessage", "Заполните все поля");
        } else {
            phone = phoneDao.search(nmodel, nyes);
        }
        req.setAttribute("phones", phoneDao.allPhone());
        req.setAttribute("search", phone);
        req.getRequestDispatcher("/WEB-INF/phone.jsp")
                .forward(req, resp);
    }
}
