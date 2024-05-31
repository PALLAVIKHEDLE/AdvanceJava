package com.apex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.apex.beans.Order;

@Repository
public class OrderDAO {

	public static List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root@123");

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderDetails");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Order orderBean = new Order();
				orderBean.setOrderID(resultSet.getString("orderID"));
				orderBean.setItemName(resultSet.getString("itemName"));
				orderBean.setPurchaseDate(resultSet.getString("purchaseDate"));
				orderBean.setAmount(resultSet.getString("amount"));
				orders.add(orderBean);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return orders;
	}
}