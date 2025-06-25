package com.velogexport.nicesqlpractice.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JdbcProperty {
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/nice_db";
	public static final String USERNAME = "sa";
	public static final String PASSWORD = "";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			log.error("connection error");
			throw new RuntimeException(e);
		}
		return connection;
	}

	public static Statement getStatement(Connection connection) {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			log.error("statement error");
			throw new RuntimeException(e);
		}
	}
}
