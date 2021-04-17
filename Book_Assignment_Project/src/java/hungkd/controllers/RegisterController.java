/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.controllers;

import hungkd.daos.UserDAO;
import hungkd.dtos.UserDTO;
import hungkd.dtos.UserErrorDTO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {
    private static final String ERROR = "register.jsp";
    private static final String SUCCESS = "index.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserErrorDTO errorUser = new UserErrorDTO();
        try {
            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String fullName = request.getParameter("txtFullName");
            String address = request.getParameter("txtAddress");
            String email = request.getParameter("txtEmail");
            String phone = request.getParameter("txtPhone");
            String roleID = request.getParameter("txtRoleID");
            boolean check = true;
            if(!password.equals(confirm)) {
                errorUser.setConfirmError("Password and Confirm fields must be the same");
                check = false;
            }
            if(!email.matches("([a-zA-Z0-9_.-])+@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+")) {
                errorUser.setEmailError("Your email is invalid [Ex: abcd@xyz.ef...]");
                check = false;
            }
            if(!phone.matches("\\d{8,12}")) {
                errorUser.setPhoneNumberError("Phone number can not be letters, and longer than 7 but shorter than 13");
                check = false;
            }
            if(!roleID.matches("[a-zA-Z]{2}")) {
                errorUser.setRoleIdError("Role ID are 2 letters in length [Ex: AD, US...]");
                check = false;
            }
            if(check == true) {
                UserDAO dao = new UserDAO();
                UserDTO user = new UserDTO(userID, password, fullName, address, email, phone, roleID);
                boolean checkInsert = dao.insertUser(user);
                if(checkInsert == true) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("ERROR", errorUser);
            }
        } catch (ClassNotFoundException | SQLException e) {
            String str = e.toString();
            if(str.contains("duplicate")){
                errorUser.setUserIdError("User ID duplicated. Try again");
                request.setAttribute("ERROR", errorUser);
            }
        } finally {
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
