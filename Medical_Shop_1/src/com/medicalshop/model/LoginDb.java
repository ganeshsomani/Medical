package com.medicalshop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.medicalshop.Form.Login;
import com.medicalshop.config.DatabaseConnection;

public class LoginDb {
	DatabaseConnection db = new DatabaseConnection();

	public LoginDb() {
		Login log = new Login();
		log.main(null);
		Connection conn = db.getConnection();
		try {
			Long dataCount = 0L;
			// DatabaseMetaData dbm = conn.getMetaData();
			// ResultSet rs = dbm.getTables(null, null, "users", null);
			PreparedStatement ps = null;
			Statement stmt = conn.createStatement();
			String sql1 = "SELECT COUNT(*) as counts FROM information_schema.tables  WHERE table_schema = 'medical_shop'  AND table_name = 'users'";
			ps = conn.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PreparedStatement ps1 = null;
				dataCount = rs.getLong("counts");
				String sql2 = "SELECT column_name FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA= 'medical_shop' AND TABLE_NAME='users'";
				ps1 = conn.prepareStatement(sql2);
				ResultSet rs2 = ps1.executeQuery();
				while (rs2.next()) {
					if (rs2.getString("column_name") != "test") {
						String sql3 = "ALTER TABLE users ADD COLUMN test VARCHAR(255);";
						stmt.executeUpdate(sql3);
						 break;
					}
				}
				rs2.close();
				ps1.close();
			}
			rs.close();
			ps.close();
			if (dataCount == 0) {
				String sql = "CREATE TABLE users " + "(id int NOT NULL AUTO_INCREMENT, " + " user_name VARCHAR(255), "
						+ " password VARCHAR(255), " + " PRIMARY KEY ( id )," + "pwd_salt VARCHAR(255),"
						+ "status VARCHAR(255)," + " mobile_no VARCHAR(255)," + "email VARCHAR(255), "
						+ " otp VARCHAR(255), " + " otp_expire Long )";
				stmt.executeUpdate(sql);
			} else {
				System.out.println("Table exists");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
