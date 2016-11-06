package org.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.jdbc.entity.User;
import org.jdbc.jdbc.DBUtils;

public class UserDaoJdbcImpl implements UserDao {

	public User findById(String uid) throws Exception {
		String sql = "select uid, uname, password from user where uid = ?";
		try (Connection conn = DBUtils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, uid);
			try (ResultSet rs = pstmt.executeQuery()) {
				// if (rs.next()) {
				//   User user = new User();
				//   user.setUid(rs.getString("uid"));
				//   user.setUname(rs.getString("uname"));
				//   user.setPassword(rs.getString("password"));
				//   return user;
				// }
				// return null;

				return DBUtils.convertResultSetToInstance(rs, User.class);
			}
		}
	}

	public List<User> findAll() throws Exception {
		String sql = "select uid, uname, password from user";
		try (Connection conn = DBUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			return DBUtils.convertResultSetToInstanceList(rs, User.class);
		}
	}

	public User findByUidAndPassword(String uid, String password) throws Exception {
		String sql = "select uid, uname, password from user where uid = ? and password = ?";
		try (Connection conn = DBUtils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, uid);
			pstmt.setString(2, password);
			try (ResultSet rs = pstmt.executeQuery()) {
				return DBUtils.convertResultSetToInstance(rs, User.class);
			}
		}
	}

	public void insert(User user) throws Exception {
		String sql = "insert into user(uid, uname, password) values(?, ?, ?)";
		try (Connection conn = DBUtils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getUid());
			pstmt.setString(2, user.getUname());
			pstmt.setString(3, user.getPassword());
			pstmt.executeUpdate();
		}
	}

	public void update(User user) throws Exception {
		String sql = "update user set uname = ?, password = ? where uid = ?";
		try (Connection conn = DBUtils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getUid());
			pstmt.executeUpdate();
		}
	}

	@Override
	public void deleteAll() throws Exception {
		try (Connection conn = DBUtils.getConnection(); Statement stmt = conn.createStatement()) {
			String sql = "delete from user";
			stmt.executeUpdate(sql);
		}
	}

	@Override
	public void delete(String uid) throws Exception {
		String sql = "delete from user where uid = ?";
		try (Connection conn = DBUtils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, uid);
		}
	}

}
