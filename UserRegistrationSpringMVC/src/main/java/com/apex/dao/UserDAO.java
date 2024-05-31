package com.apex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.apex.beans.User;

@Repository
public class UserDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/training";
	private static final String USER = "root";
	private static final String PASSWORD = "root@123";

	static {
		try {
			// Load the MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load MySQL JDBC driver");
		}
	}

	public User getUserBean(User userBean) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM registration WHERE userName=? AND password=?");
			statement.setString(1, userBean.getUserName());
			statement.setString(2, userBean.getPassword());
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				userBean.setFirstName(resultSet.getString("firstName"));
				userBean.setLastName(resultSet.getString("lastName"));
			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userBean;
	}

	public boolean isUserExists(String userName) throws SQLException {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			PreparedStatement checkStatement = connection
					.prepareStatement("SELECT * FROM registration WHERE userName = ?");
			checkStatement.setString(1, userName);
			ResultSet resultSet = checkStatement.executeQuery();
			boolean exists = resultSet.next();
			resultSet.close();
			checkStatement.close();
			return exists;
		}
	}

	public boolean registerUser(User userBean) throws SQLException {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO registration (firstName, lastName, userName, password) VALUES (?, ?, ?, ?)");
			statement.setString(1, userBean.getFirstName());
			statement.setString(2, userBean.getLastName());
			statement.setString(3, userBean.getUserName());
			statement.setString(4, userBean.getPassword());
			int rowsInserted = statement.executeUpdate();
			statement.close();
			return rowsInserted > 0;
		}
	}
}