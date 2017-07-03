package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.model.Order;
import com.bookapp.util.ConnectionUtil;

public class OrderDAO {

	public List<Order> findAll() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "select * from orders";
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		List<Order> order = new ArrayList<>();
		Order u = new Order();
		while (rs.next()) {
			u.setUser_id(rs.getInt("user_id"));
			u.setBook_id(rs.getInt("book_id"));
			u.setId(rs.getInt("id"));
			u.setQuantity(rs.getInt("quantity"));
			order.add(u);
		}

		return order;
	}

	
	public int ordering(Order order) throws ClassNotFoundException, SQLException
	{
		Connection connection = ConnectionUtil.getconnection();
		String sql = "insert into orders(quantity,book_id,user_id) values(?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setInt(1,order.getQuantity() );
		pst.setInt(2, order.getBook_id());
		pst.setInt(3, order.getUser_id());
		
		int rows = pst.executeUpdate();
		System.out.println("Number of Rows Inserted : " + rows);
		return rows;
	}
}