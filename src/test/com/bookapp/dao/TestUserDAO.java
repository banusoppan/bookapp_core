package test.com.bookapp.dao;

import java.sql.SQLException;

import com.bookapp.dao.UserDAO;
import com.bookapp.model.User;

public class TestUserDAO {

	public void reg() throws ClassNotFoundException, SQLException
	{
		User user = new User();
		
		user.setEmail("a@gmail.com");
		user.setName("abi");
		user.setPassword("abi");
		
		
		UserDAO userdao=new UserDAO();
		userdao.register(user);
		System.out.println(user);
	}
	
	public void login() throws ClassNotFoundException, SQLException
	{
		User user = new User();
		user.setEmail("a@gmail.com");
		
		user.setPassword("abi");
		UserDAO userdao=new UserDAO();
		user=userdao.login(user);
		System.out.println(user);
	}
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		TestUserDAO t = new TestUserDAO();
		try {
			t.login();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
