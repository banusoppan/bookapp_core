package test.com.bookapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.dao.BookDAO;
import com.bookapp.model.Book;



public class TestBookDAO {
	public void insert()
	{
		Book book = new Book();      
		
		book.setName("html");
		book.setPrice(1000);
		BookDAO bookdao=new BookDAO();
		try {
			bookdao.addBook(book);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
	public void Display(){
	
		BookDAO bookdao=new BookDAO();
		
		try {
			List <Book> books = new ArrayList<>();
			books=bookdao.findAll();
			for(Book k: books)
			{
				System.out.println(k);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void BookPrice(){
		Book book = new Book();
		book.setId(1);
		book.setName("html");
		book.setPrice(1500);
		BookDAO bookdao = new BookDAO();
		try {
			bookdao.updateBookPrice(book);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void DeleteBook(){
		Book book = new Book();
		book.setId(2);
		BookDAO bookdao = new BookDAO();
		try {
			bookdao.deleteBook(book.getId());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void FindByPrice(){
		Book book = new Book();
		book.setPrice(1000);
		BookDAO bookdao=new BookDAO();
		try {
			List <Book> books = new ArrayList<>();
			books=bookdao.findByPrice(book.getPrice());
			for(Book k: books)
			{
				System.out.println(k);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	
	
	
	
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		TestBookDAO testbookdao = new TestBookDAO();
		//testbookdao.insert();
		//testbookdao.Display();
		//testbookdao.BookPrice();
		//testbookdao.DeleteBook();
		testbookdao.FindByPrice();
	}

}
