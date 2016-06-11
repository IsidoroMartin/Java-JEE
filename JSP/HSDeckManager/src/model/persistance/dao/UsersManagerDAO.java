package model.persistance.dao;

import static model.persistance.querys.users.UMQuerys.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.beans.User;

public class UsersManagerDAO {
	Pool pool = null;

	public UsersManagerDAO() {
		pool = Pool.getInstance();
	}

	private User buildSimpleUser(ResultSet rs) throws SQLException {
		return new User(rs.getInt("ID"), rs.getInt("ADMIN_LVL"),
				rs.getString("USERNAME"), rs.getString("PASSWORD"),
				rs.getString("NAME"), rs.getString("FIRSTNAME"));
	}

	public User getUser(String username, String password) {
		User user = null;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = pool.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(buildGetUserQuery(username, password));
			if (rs.next()) {
				try {
					user = buildSimpleUser(rs);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ((null != conn) && (null != st) && (null != rs)) {
				pool.liberarRecursos(conn, st, rs);
			}
		}

		return user;
	}

}
