package com.sun.helloworld.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Resultset;
import com.sun.helloworld.bean.User;
import com.sun.helloworld.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(User user) {
		String sql = "insert into user (name,date) value (?,?)";
		return jdbcTemplate.update(sql, user.getName(), user.getDate());
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from user where id=?";
		return jdbcTemplate.update(sql, id);
	}

	@Override
	public int updateById(User user) {
		String sql = "update user set name=?,date=?,where id=?";
		return jdbcTemplate.update(sql, user.getName(), user.getDate(), user.getId());
	}

	@Override
	public User selectById(int id) {
		String sql = "select * from from user where id=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setDate(rs.getDate("time"));
				
				return user;
			}
		}, id);
	}

}
