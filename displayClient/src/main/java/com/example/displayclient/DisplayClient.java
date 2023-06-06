package com.example.displayclient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DisplayClient", value = "/displayClient")

public class DisplayClient extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Mai Văn Hoàn", "20/08/83", "Hà Nội", "https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2020/8/17/828712/Lay-Danh-Nghia-Nguoi-05.jpg"));
        clients.add(new Client("Nguyễn Văn Nam", "20/08/83", "Hà Nội", "https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2020/8/17/828712/Lay-Danh-Nghia-Nguoi-05.jpg"));
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void destroy() {
    }
}

