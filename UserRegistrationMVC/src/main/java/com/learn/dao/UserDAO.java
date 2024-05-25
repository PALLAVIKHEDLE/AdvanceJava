package com.learn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learn.bean.UserBean;

public class UserDAO {

	public static UserBean getUserBean(UserBean userBean) {

		Connection connection;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "root@123");

			PreparedStatement statement = connection
					.prepareStatement("select * from registration where userName=? and password=?");
			statement.setString(1, userBean.getUserName());
			statement.setString(2, userBean.getPassword());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userBean.setFirstName(resultSet.getString(1));
				userBean.setLastName(resultSet.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return userBean;
	}
}
