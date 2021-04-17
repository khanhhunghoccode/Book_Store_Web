/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private static final String ERROR_PAGE="error.jsp";
    private static final String LOGIN="LoginController";
    private static final String REGISTER_PAGE = "register.jsp";
    private static final String REGISTER = "RegisterController";
    private static final String FIND = "FindController";
    private static final String LOGOUT = "LogoutController";
    private static final String SEARCH = "SearchController";
    private static final String DELETE = "DeleteController";
    private static final String UPDATE = "UpdateController";
    private static final String ADD = "CartController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url=ERROR_PAGE;
        try {
            String action=request.getParameter("btnAction");
            if(null == action){
                request.setAttribute("ERROR", "Your action is not supported");
            } else switch (action) {
                case "Login":
                    url=LOGIN;
                    break;
                case "Logout":
                    url = LOGOUT;
                    break;
                case "Search":
                    url = SEARCH;
                    break;
                case "Delete":
                    url = DELETE;
                    break;
                case "Update":
                    url = UPDATE;
                    break;
                case "RegisterPage":
                    url = REGISTER_PAGE;
                    break;
                case "Register":
                    url = REGISTER;
                    break;
                case "Choose":
                    url = ADD;
                    break;
                case "Find":
                    url = FIND;
                    break;
                default:
                    request.setAttribute("ERROR", "Your action is not supported");
                    break;
            }
        } catch (Exception e) {
            log("error at MainController "+e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
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
