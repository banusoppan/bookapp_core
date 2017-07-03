package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.util.ConnectionUtil;

public class BookDAO {

	public List<Book> findByPrice(int price) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "select id,name,price from book where price>=?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, price);

		ResultSet rs = pst.executeQuery();
		List<Book> books = new ArrayList<>();
		
		while (rs.next()) {
			Book u = new Book();
			u.setName(rs.getString("name"));
			u.setId(rs.getInt("id"));
			u.setPrice(rs.getInt("price"));
			books.add(u);
		}

		return books;
	}

	public List<Book> findAll() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "select * from book";
		PreparedStatement pst = connection.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		List<Book> books = new ArrayList<>();
		
		while (rs.next()) {
			Book u = new Book();
			u.setName(rs.getString("name"));
			u.setId(rs.getInt("id"));
			u.setPrice(rs.getInt("price"));
			books.add(u);
		}

		return books;

	}

	public int addBook(Book book) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "insert into book(id,name,price) values(?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);

		pst.setInt(1, book.getId());
		pst.setString(2, book.getName());
		pst.setInt(3, book.getPrice());

		int rows = pst.executeUpdate();
		System.out.println("Number of Rows Inserted : " + rows);
		return rows;
	}

	public int updateBookPrice(Book book) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "update book set price=? where id=? and name=?";
		PreparedStatement pst = connection.prepareStatement(sql);

		pst.setInt(2, book.getId());
		pst.setString(3, book.getName());
		pst.setInt(1, book.getPrice());

		int rows = pst.executeUpdate();
		if (rows > 0) {
			System.out.println("Rows updated: " + rows);
		}
		return rows;

	}

	public int deleteBook(int id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getconnection();
		String sql = "delete from book where id=?";
		PreparedStatement pst = connection.prepareStatement(sql);

		pst.setInt(1, id);

		int rows = pst.executeUpdate();
		if (rows > 0) {
			System.out.println("Rows deleted");
		}
		return rows;
	}

}
