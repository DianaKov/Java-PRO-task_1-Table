package com.example.servlet_example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CustomerViewServlet extends HttpServlet {

    private List<Customer> customers
            = Arrays.asList(new Customer("Alex", "Kyiv"),
                            new Customer("Misha", "Kyiv"));

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customersList", customers);
        request.setAttribute("customers", getCustomerTable());
        request.getRequestDispatcher("/customers.jsp").forward(request, response);
    }

    public String getCustomerTable() {
        StringBuilder sb = new StringBuilder();
        for (Customer customer : customers) {
            sb.append("<tr><td>")
                    .append(customer.getName())
                    .append("</td><td>")
                    .append(customer.getAddress())
                    .append("</td></tr>");
        }
        return sb.toString();

    }

}
