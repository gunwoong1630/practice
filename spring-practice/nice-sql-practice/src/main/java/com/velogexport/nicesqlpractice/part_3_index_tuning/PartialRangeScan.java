package com.velogexport.nicesqlpractice.part_3_index_tuning;

import static com.velogexport.nicesqlpractice.statement.JdbcProperty.*;

import java.sql.Connection;
import java.sql.Statement;

public class PartialRangeScan {
	public static void main(String[] args) {

	}

	private static void activatePartialRangeScan() {
		Connection connection = getConnection();

		int arraySize = 10;
		Statement statement = getStatement(connection);


	}

}
