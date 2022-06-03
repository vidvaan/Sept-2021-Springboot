package com.createiq.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.createiq.demo.model.UserDTO;
@Repository

public class UserDAOImpl implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	@Transactional
	public void addUser(UserDTO userDTO) {

		jdbcTemplate.update("INSERT INTO USERS VALUES(?,?,?)",
				new Object[] { userDTO.getUsername(), userDTO.getPassword(), userDTO.isEnabled() });

		userDTO.getAuthorities().forEach(authority -> {
			jdbcTemplate.update("INSERT INTO authorities VALUES(?,?)",
					new Object[] { userDTO.getUsername(), authority });
		});

	}

}
