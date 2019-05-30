package com.revature.ERSProject1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ERSServlet extends HttpServlet{

    @Override
    public void init(ServletConfig config) {
        System.out.println("TestServlet.init() invoked");
    }
    
    @Override
    public void destroy() {
        System.out.println("TestServlet.destroy() invoked");
    }
    
    @Override // will process any GET response that hits the uri /test
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter pw = response.getWriter();
        pw.write("<h1>Applicaccion deployed mucho bueno!</h1>");
    }
    
}
