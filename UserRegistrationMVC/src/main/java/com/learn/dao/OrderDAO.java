package com.learn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learn.bean.OrderBean;

public class OrderDAO {

	public static List<OrderBean> getAllOrders() {
		List<OrderBean> orders = new ArrayList<>();
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root@123");

			PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderDetails");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				OrderBean orderBean = new OrderBean();
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
