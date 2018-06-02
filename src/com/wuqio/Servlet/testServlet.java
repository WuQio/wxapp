package com.wuqio.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "testServlet", urlPatterns = {"/test"})
public class testServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String line, str = "";
        while ((line=br.readLine())!=null){
            str+=line;
        }
        str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        Process process = Runtime.getRuntime().exec("python3 /opt/apache-tomcat-7.0.85/pyscripts/py.py  "+str);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.getWriter().write("test response");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
