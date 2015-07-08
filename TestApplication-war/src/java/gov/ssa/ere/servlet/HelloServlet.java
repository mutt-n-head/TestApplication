/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gov.ssa.ere.servlet;

import gov.ssa.ere.bean.NewSessionBeanRemote;
import gov.ssa.ere.bean.NoInterfaceBean;
import gov.ssa.ere.bean.TestBeanLocal;
import gov.ssa.ere.model.EREFile;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lisner
 */
public class HelloServlet extends HttpServlet {
    @EJB (lookup="java:global/TestApplication/TestApplication-ejb/TestBean!gov.ssa.ere.bean.TestBeanLocal") TestBeanLocal myBean;
    // @EJB (lookup="java:global/TestApplication/TestApplication-war/TestService!gov.ssa.ere.service.TestServiceLocal") TestServiceLocal tstServ;
    @EJB (lookup="java:global/TestApplication/TestApplication-ejb/NewSessionBean!gov.ssa.ere.bean.NewSessionBeanRemote") NewSessionBeanRemote myRemoteBean;
    @EJB protected NoInterfaceBean noIntBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get output
        //EREFile root = myRemoteBean.getTree();
        //root.display();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            // out.println("<p>" + myBean.helloThere() + "</p>");
            out.println(
                    "Calling the no interface bean returned "
                    + noIntBean.ping("Joe Sixpack")
                    + "<br />");
            out.println("The call seems successful");
            out.println("Calling TestBean");
            // out.println(myBean.doSomethingFor30Seconds());
            myBean.doesSomethingAsynchronusFor45Seconds();
            myBean.doesSomethingAsynchronusFor45Seconds();
            myBean.doesSomethingAsynchronusFor45Seconds();
            out.println("</body>");
            out.println("</html>");
        }
        
        /*
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet myGet = new HttpGet("http://www.cnet.com");
        CloseableHttpResponse myResponse = httpclient.execute(myGet);

        System.out.println(EntityUtils.toString(myResponse.getEntity()));
        System.out.println(myBean.helloThere());
        */
        // System.out.println(tstServ.hello());
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
