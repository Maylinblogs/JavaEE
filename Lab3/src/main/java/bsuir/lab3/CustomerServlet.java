package bsuir.lab3;

import bsuir.lab3.dao.CustomerDao;
import bsuir.lab3.model.Customer;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {

    @EJB(beanName = "customerDao")
    private CustomerDao customerDao ;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        String customerNr = request.getParameter("customer_nr");
        if (customerNr != null) {
            Customer customer = customerDao.findCustomerById(Long.valueOf(customerNr));
            out.println("<p>"+customer.getCustomerId()+"</p>");
            out.println("<p>"+customer.getName()+"</p>");
            out.println("<p>"+customer.getCity()+"</p>");
            out.println("<p>"+customer.getEmail()+"</p>");
        }
        out.println("<form>");
        out.println("Customer number: <input type='text' name='customer_nr'/>");
        out.println("<input type=submit value=Select />");
        out.println("</form>");
        out.println("</body></html>");
    }



    public void destroy() {
    }
}