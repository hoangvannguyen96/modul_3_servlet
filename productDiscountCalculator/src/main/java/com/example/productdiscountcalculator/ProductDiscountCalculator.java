package com.example.productdiscountcalculator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductDiscountCalculator", value = "/productDiscountCalculator")
public class ProductDiscountCalculator extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        float price = Float.parseFloat(request.getParameter("price"));
        float Discount = Float.parseFloat(request.getParameter("Discount"));
        String description = request.getParameter("description");
        float DiscountAmount = (float) (price * Discount * 0.01);

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Mô tả sản phẩm: " + description + "</h1>");
        writer.println("<h1>Giá sản phẩm: " + price + "</h1>");
        writer.println("<h1>Phần trăm (%) chiết khấu: " + Discount + "</h1>");
        writer.println("<h1>Chiết khấu: " + DiscountAmount + "</h1>");
        writer.println("</html>");
    }
}