/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.daos;

import hungkd.dtos.UserDTO;
import hungkd.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class UserDAO implements Serializable {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<UserDTO> list = null;

    public void closeAll() throws SQLException {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
    }

    public UserDTO login(String userID, String password) throws ClassNotFoundException, SQLException {
        UserDTO user = null;
        conn = DBUtils.getConnection();
        try {
            String sql = "select FullName, Address, Email, PhoneNumber, RoleID from "
                    + "tblUsers where UserID=? and UserPassword=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                String FullName = rs.getNString("FullName");
                String Address = rs.getNString("Address");
                String Email = rs.getString("Email");
                String PhoneNumber = rs.getString("PhoneNumber");
                String RoleID = rs.getString("RoleID");
                user = new UserDTO(userID, password, FullName, Address, Email, PhoneNumber, RoleID);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            closeAll();
        }
        return user;
    }

    public List<UserDTO> getListUser(String search) throws SQLException, ClassNotFoundException {
        list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select UserID, FullName, Address, Email, PhoneNumber, RoleID from "
                        + "tblUsers where FullName like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + search + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("UserID");
                    String FullName = rs.getNString("FullName");
                    String Address = rs.getNString("Address");
                    String Email = rs.getString("Email");
                    String PhoneNumber = rs.getString("PhoneNumber");
                    String RoleID = rs.getString("RoleID");
                    String password = "******";
                    list.add(new UserDTO(userID, password, FullName, Address, Email, PhoneNumber, RoleID));
                }
            }
        } finally {
            closeAll();
        }
        return list;
    }

    public void deleteUser(String userID) throws SQLException, ClassNotFoundException {
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "delete tblUsers where UserID = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, userID);
                ps.executeUpdate();
            }
        } finally {
            closeAll();
        }
    }

    public boolean updateUser(UserDTO user) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "update tblUsers set FullName=?, Address=?, Email=?, PhoneNumber=?, RoleID=? "
                        + "where UserID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getFullName());
                ps.setString(2, user.getAddress());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPhoneNumber());
                ps.setString(5, user.getRoleID());
                ps.setString(6, user.getUserID());
                int i = ps.executeUpdate();
                if (i != 0) {
                    check = true;
                }
            }
        } finally {
            closeAll();
        }
        return check;
    }

    public boolean insertUser(UserDTO user) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "insert into tblUsers(UserID, UserPassword, FullName, Address, Email, PhoneNumber, RoleID) "
                        + "values(?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUserID());
                ps.setString(2, user.getUserPassword());
                ps.setString(3, user.getFullName());
                ps.setString(4, user.getAddress());
                ps.setString(5, user.getEmail());
                ps.setString(6, user.getPhoneNumber());
                ps.setString(7, user.getRoleID());
                int i = ps.executeUpdate();
                if (i != 0) {
                    check = true;
                }
            }
        } finally {
            closeAll();
        }
        return check;
    }

}
