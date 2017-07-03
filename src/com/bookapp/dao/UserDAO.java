package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookapp.model.User;
import com.bookapp.util.ConnectionUtil;

public class UserDAO {

	public User login(User user) throws ClassNotFoundException, SQLException{
		Connection  connection=ConnectionUtil.getconnection();
		String sql="select * from Users where email=? and password=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		
		pst.setString(1, user.getEmail());
		pst.setString(2, user.getPassword());
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
		}
	   
	    
	    return user;
	}
	
	
	
	public User register(User user) throws ClassNotFoundException, SQLException {
		Connection  connection=ConnectionUtil.getconnection();
		String sql = "insert into Users(id,name,email,password) values(?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, user.getId());
		pst.setString(2, user.getName());
		pst.setString(3,user.getEmail());
		pst.setString(4, user.getPassword());
		int rows = pst.executeUpdate();
		System.out.println("Number of Rows Inserted : " + rows);
		return user;
	}
	
	
}
