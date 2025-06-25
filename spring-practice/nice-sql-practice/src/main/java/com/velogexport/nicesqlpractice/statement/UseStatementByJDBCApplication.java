package com.velogexport.nicesqlpractice.statement;

import static com.velogexport.nicesqlpractice.statement.JdbcProperty.*;

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
		Car.createTable();
		activateStatement();
		activatePreparedStatement();
	}

	public static void activateStatement() {
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			log.info("activateStatement");
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

	public static void activatePreparedStatement() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			log.info("activatePreparedStatement");
			connection = getConnection();
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
		public static void createTable() {
			String createTableSQL = """
				CREATE TABLE IF NOT EXISTS car (
				    car_id BIGINT PRIMARY KEY,
				    brand VARCHAR(50),
				    name VARCHAR(50),
				    type VARCHAR(50)
				)
				""";

			try (Connection connection = getConnection();
				 Statement statement = connection.createStatement()) {

				statement.executeUpdate(createTableSQL);
				log.info("Table 'car' created or already exists.");

			} catch (SQLException e) {
				log.error("Failed to create table 'car': " + e.getMessage(), e);
			}
		}
	}
}
