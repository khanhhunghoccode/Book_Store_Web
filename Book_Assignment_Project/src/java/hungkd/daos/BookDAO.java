/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.daos;

import hungkd.dtos.BookDTO;
import hungkd.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class BookDAO implements Serializable {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<BookDTO> list = null;

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
    
    public List<BookDTO> getListBook(String find) throws SQLException, ClassNotFoundException {
        list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "select ProductID, ProductName, Price, Quantity, Status from "
                        + "tblProducts where ProductName like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%" + find + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("ProductID");
                    String productName = rs.getNString("ProductName");
                    float price = rs.getFloat("Price");
                    int quantity = rs.getInt("Quantity");
                    String status = rs.getNString("Status");
                    list.add(new BookDTO(productID, productName, status, price, quantity));
                }
            }
        } finally {
            closeAll();
        }
        return list;
    }
}
