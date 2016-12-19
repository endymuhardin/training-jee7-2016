package com.brainmatics.aplikasi.pendaftaran.servlet;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HaloServlet", urlPatterns = {"/halo"})
public class HaloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date sekarang = new Date();
        
        resp.setContentType("text/html");
        resp.getWriter().println("<b>"+sekarang.toString()+"</b>");
        resp.getWriter().flush();
    }
    
}
