package com.food.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.food.models.Item;
import com.food.models.User;

public class UserAuthenticationDaoImpl {
	
	public Boolean authenticate() {
		
		try {
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			String driver="com.mysql.jdbc.Driver";
			String myUrl="jdbc:mysql://localhost:3306/usercrud?autoReconnect=true&useSSL=false";
			String username="root";
			String password="linuxconfig.org";
			conn = DriverManager.getConnection(myUrl, username, password);
			try {
				st = conn.createStatement();
				rs = st.executeQuery("select * from menu" );
				while (rs.next()) {
//					  int i = rs.getInt("id");
//					  String title = rs.getString("title");
//					  String link = rs.getString("link");
//					  int price = rs.getInt("price");
//					  Item item = new Item(i,title,link,price);
//
//					  tempItem.add(item);
					}
//				   return tempItem;
				}
				catch(Exception e)
				{
					System.out.println("error1");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	

}
