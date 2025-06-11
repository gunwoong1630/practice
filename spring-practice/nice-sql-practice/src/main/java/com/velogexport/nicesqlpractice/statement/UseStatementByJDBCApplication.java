package com.velogexport.nicesqlpractice.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.extern.slf4j.Slf4j;

/**
 * Statement vs PreparedStatement
 * - Statement: SQL 쿼리를 직접 작성하여 실행하는 방식, 정적 쿼리에 사용
 * - PreparedStatement: 미리 컴파일된 SQL 쿼리를 사용하여 실행하는 방식, 동적 쿼리에 사용
 *
 * PreparedStatement는 성능과 보안 측면에서 더 우수합니다(like SQL injection).
 *
 * > Task :com.velogexport.nicesqlpractice.statement.JdbcApplication.main()
 * 21:28:02.012 [main] INFO com.velogexport.nicesqlpractice.statement.JdbcApplication -- activateStatement
 * 21:28:03.802 [main] INFO com.velogexport.nicesqlpractice.statement.JdbcApplication -- createCar(resultSet) = Car[id=1, brand=HYUNDAI, name=HYUNDAI, type=avante]
 * 21:28:03.884 [main] INFO com.velogexport.nicesqlpractice.statement.JdbcApplication -- activatePreparedStatement
 * 21:28:03.982 [main] INFO com.velogexport.nicesqlpractice.statement.JdbcApplication -- createCar(resultSet) = Car[id=1, brand=HYUNDAI, name=HYUNDAI, type=avante]
 */
@Slf4j
public class UseStatementByJDBCApplication {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/nice_db";
		String username = "";
		String password = "";

		activateStatement(jdbcUrl, username, password);
		activatePreparedStatement(jdbcUrl, username, password);
	}

	public static void activateStatement(String jdbcUrl, String username, String password) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			log.info("activateStatement");
			connection = DriverManager.getConnection(jdbcUrl, username, password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM car WHERE car_id = 1");
			while (resultSet.next()) {
				log.info("createCar(resultSet) = {}", createCar(resultSet));
			}
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			return;
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				log.error(e.getMessage(), e);
			}

		}
	}

	public static void activatePreparedStatement(String jdbcUrl, String username, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			log.info("activatePreparedStatement");
			connection = DriverManager.getConnection(jdbcUrl, username, password);
			preparedStatement = connection.prepareStatement("SELECT * FROM car WHERE car_id = ?");
			preparedStatement.setLong(1, 1L);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				log.info("createCar(resultSet) = {}", createCar(resultSet));
			}
		} catch (SQLException e) {
			log.error("Connection failed: " + e.getMessage());
			return;
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				log.error("Connection failed: " + e.getMessage());
				return;
			}
		}
	}

	private static Car createCar(ResultSet resultSet) throws SQLException {
		return new Car(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(2), resultSet.getString(3));
	}

	private record Car(Long id, String brand, String name, String type) {

	}
}
