package com.example.servlet_example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CalculatorServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        calculate(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        calculate(request, response);
    }

    private void calculate(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {
        Integer a = Integer.valueOf(request.getParameter("a"));
        Integer b = Integer.valueOf(request.getParameter("b"));
        String operation = request.getParameter("operation");
        switch (operation) {
            case "plus":
                response.getWriter().println("<H1>" + (5 + 5) + "</H1>");
                break;
        }
    }
}