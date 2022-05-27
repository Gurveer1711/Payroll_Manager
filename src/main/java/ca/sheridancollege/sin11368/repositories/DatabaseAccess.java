package ca.sheridancollege.sin11368.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.sin11368.beans.Users;

@Repository
public class DatabaseAccess {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void addUser(String username, String password) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "insert into SEC_User "
				+ "(userName, encryptedPassword, ENABLED)"
				+ " values(:username, :encryptedPassword, 1)";
		parameters.addValue("username", username);
		parameters.addValue("encryptedPassword", passwordEncoder.encode(password));
		jdbc.update(query, parameters);
	}
	
	public Users findUserAccount(String userName) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "SELECT * FROM sec_user where userName=:userName";
		parameters.addValue("userName", userName);
		ArrayList<Users> users = (ArrayList<Users>)jdbc.query(query, parameters,new BeanPropertyRowMapper<Users>(Users.class));
		if(users.size()>0) {
			return users.get(0);
		}
		else return null;
	}
	
	public List<String> getRolesById(long userId) {
		ArrayList<String> roles = new ArrayList<String>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "select user_role.userId, sec_role.roleName "+ "FROM user_role, sec_role "+ "WHERE user_role.roleId=sec_role.roleId "+ "and userId=:userId";
		parameters.addValue("userId", userId);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for (Map<String, Object> row : rows) {
			roles.add((String)row.get("roleName"));
		}
		return roles;
	}
	
	public void addRole(long userId, long roleId) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "insert into user_role (userId, roleId) "
				+ "values (:userId, :roleId)";
		parameters.addValue("userId", userId);
		parameters.addValue("roleId", roleId);
		jdbc.update(query, parameters);
	}
	
	
	
}
