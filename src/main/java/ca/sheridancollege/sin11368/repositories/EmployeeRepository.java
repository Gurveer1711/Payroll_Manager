package ca.sheridancollege.sin11368.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.sin11368.beans.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public void addEmployee(Employee employee) {

		MapSqlParameterSource parameters=new MapSqlParameterSource();
		String query="INSERT INTO employees(name,emp_id,su_hr,mo_hr,tu_hr,we_hr,th_hr,fr_hr,sa_hr,wage) VALUES "
				+ "(:name, :emp_id, :su_hr, :mo_hr, :tu_hr, :we_hr, :th_hr, :fr_hr, :sa_hr, :wage)";
		parameters.addValue("name", employee.getName());
		parameters.addValue("emp_id", employee.getEmp_id());
		parameters.addValue("su_hr", employee.getSu_hr());
		parameters.addValue("mo_hr", employee.getMo_hr());
		parameters.addValue("tu_hr", employee.getTu_hr());
		parameters.addValue("we_hr", employee.getWe_hr());
		parameters.addValue("th_hr", employee.getTh_hr());
		parameters.addValue("fr_hr", employee.getFr_hr());
		parameters.addValue("sa_hr", employee.getSa_hr());
		parameters.addValue("wage", employee.getWage());
		
		jdbc.update(query, parameters);
	}
	
	
	
	
	public ArrayList<Employee> getEmployees(){
		String query="SELECT * FROM employees";

		ArrayList<Employee> employees=new ArrayList<Employee>();
		List<Map<String,Object>>rows =jdbc.queryForList(query, new HashMap<String,Object>());
		for(Map<String,Object>row:rows)
		{
			Employee e=new Employee();
			e.setId((int)row.get("id"));
			e.setName((String)row.get("name"));
			e.setEmp_id((String)row.get("emp_id"));
			BigDecimal b = (BigDecimal)row.get("su_hr");
			e.setSu_hr(b.doubleValue());
		    b = (BigDecimal)row.get("mo_hr");
			e.setMo_hr(b.doubleValue());
			b = (BigDecimal)row.get("tu_hr");
			e.setTu_hr(b.doubleValue());
			b = (BigDecimal)row.get("we_hr");
			e.setWe_hr(b.doubleValue());
			b = (BigDecimal)row.get("th_hr");
			e.setTh_hr(b.doubleValue());
			b = (BigDecimal)row.get("fr_hr");
			e.setFr_hr(b.doubleValue());
			b = (BigDecimal)row.get("sa_hr");
			e.setSa_hr(b.doubleValue());
			b = (BigDecimal)row.get("wage");
			e.setWage(b.doubleValue());
			
			employees.add(e);
		}
		return employees;
	}
	
	public Employee getEmployeeByID(int id)
	{
		MapSqlParameterSource parameters=new MapSqlParameterSource();

		String query="SELECT * FROM employees WHERE id=:id";
		parameters.addValue("id", id);
		ArrayList<Employee> employees=new ArrayList<Employee>();
		List<Map<String,Object>>rows =jdbc.queryForList(query,parameters);
		for(Map<String,Object>row:rows)
		{
			Employee e=new Employee();
			e.setId((int)row.get("id"));
			e.setName((String)row.get("name"));
			e.setEmp_id((String)row.get("emp_id"));
			BigDecimal b = (BigDecimal)row.get("su_hr");
			e.setSu_hr(b.doubleValue());
		    b = (BigDecimal)row.get("mo_hr");
			e.setMo_hr(b.doubleValue());
			b = (BigDecimal)row.get("tu_hr");
			e.setTu_hr(b.doubleValue());
			b = (BigDecimal)row.get("we_hr");
			e.setWe_hr(b.doubleValue());
			b = (BigDecimal)row.get("th_hr");
			e.setTh_hr(b.doubleValue());
			b = (BigDecimal)row.get("fr_hr");
			e.setFr_hr(b.doubleValue());
			b = (BigDecimal)row.get("sa_hr");
			e.setSa_hr(b.doubleValue());
			b = (BigDecimal)row.get("wage");
			e.setWage(b.doubleValue());
			
			employees.add(e);
		}
		if (employees.isEmpty()) {
			return null;
		}else {
		return employees.get(0);
		}
	}
	
	public void editEmployee(Employee employee)
	{
			MapSqlParameterSource parameters=new MapSqlParameterSource();
			String query="UPDATE employees SET name=:name, emp_id=:emp_id, su_hr=:su_hr, mo_hr=:mo_hr, tu_hr=:tu_hr,"
					+ " we_hr=:we_hr, th_hr=:th_hr, fr_hr=:fr_hr, sa_hr=:sa_hr, wage=:wage WHERE id=:id";
			parameters.addValue("id", employee.getId());
			parameters.addValue("name", employee.getName());
			parameters.addValue("emp_id", employee.getEmp_id());
			parameters.addValue("su_hr", employee.getSu_hr());
			parameters.addValue("mo_hr", employee.getMo_hr());
			parameters.addValue("tu_hr", employee.getTu_hr());
			parameters.addValue("we_hr", employee.getWe_hr());
			parameters.addValue("th_hr", employee.getTh_hr());
			parameters.addValue("fr_hr", employee.getFr_hr());
			parameters.addValue("sa_hr", employee.getSa_hr());
			parameters.addValue("wage", employee.getWage());
			
			
	jdbc.update(query, parameters);
	}
	
	public void deleteEmployee(int id)
	{
		MapSqlParameterSource parameters=new MapSqlParameterSource();
		String query="DELETE FROM employees WHERE id=:id";
		parameters.addValue("id", id);
		jdbc.update(query,parameters);
	}
	
	public Employee getEmployee(String username){
		MapSqlParameterSource parameters=new MapSqlParameterSource();
		String query="SELECT * FROM employees WHERE name=:name";
		parameters.addValue("name", username);
		ArrayList<Employee> employees=new ArrayList<Employee>();
		List<Map<String,Object>>rows =jdbc.queryForList(query,parameters);
		for(Map<String,Object>row:rows)
		{
			Employee e=new Employee();
			e.setId((int)row.get("id"));
			e.setName((String)row.get("name"));
			e.setEmp_id((String)row.get("emp_id"));
			BigDecimal b = (BigDecimal)row.get("su_hr");
			e.setSu_hr(b.doubleValue());
		    b = (BigDecimal)row.get("mo_hr");
			e.setMo_hr(b.doubleValue());
			b = (BigDecimal)row.get("tu_hr");
			e.setTu_hr(b.doubleValue());
			b = (BigDecimal)row.get("we_hr");
			e.setWe_hr(b.doubleValue());
			b = (BigDecimal)row.get("th_hr");
			e.setTh_hr(b.doubleValue());
			b = (BigDecimal)row.get("fr_hr");
			e.setFr_hr(b.doubleValue());
			b = (BigDecimal)row.get("sa_hr");
			e.setSa_hr(b.doubleValue());
			b = (BigDecimal)row.get("wage");
			e.setWage(b.doubleValue());
			
			employees.add(e);
		}
		if (employees.isEmpty()) {
			return null;
		}else {
		return employees.get(0);
		}
		
	}
	
	
}
