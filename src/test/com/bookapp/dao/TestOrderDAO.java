package test.com.bookapp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.dao.OrderDAO;
import com.bookapp.model.Order;

public class TestOrderDAO {
	public void insert()
	{
		Order order = new Order();      
		
		order.setUser_id(1001);
		order.setBook_id(1);
		order.setQuantity(1);
		OrderDAO orderdao=new OrderDAO();
		
			try {
				orderdao.ordering(order);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void Display(){
		
		OrderDAO orderdao=new OrderDAO();
		
		try {
			List <Order> orders = new ArrayList<>();
			orders=orderdao.findAll();
			for(Order k: orders)
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
		TestOrderDAO testorderdao = new TestOrderDAO();
		//testorderdao.insert();
		testorderdao.Display();
		
	}

}
