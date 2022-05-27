package ca.sheridancollege.sin11368.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.sin11368.beans.Employee;
import ca.sheridancollege.sin11368.beans.Users;
import ca.sheridancollege.sin11368.repositories.DatabaseAccess;
import ca.sheridancollege.sin11368.repositories.EmployeeRepository;

@Controller
public class HomeController {

	@Autowired
	private EmployeeRepository EmployeeRepo;
	
	@Autowired
	@Lazy
	private DatabaseAccess da;
	
	
	@GetMapping("/")
	public String goRoot()
	{
		return "rootpage.html";
	}
	
@GetMapping("/addEmployee")
public String goToAddDrink(Model model)
{
	model.addAttribute("employee",new Employee());
	return "addEmployees.html";
}

@PostMapping("/addEmployee")
public String addDrinkToDatabase(@ModelAttribute Employee employee)
{ 
	
	EmployeeRepo.addEmployee(employee);
	da.addUser(employee.getName(), employee.getEmp_id());
	da.addRole(da.findUserAccount(employee.getName()).getUserID(), 2);
	  
	return "redirect:/addEmployee";
}

@GetMapping("/login")
public String goLogin() {
	return "login.html";
}

@GetMapping("/viewEmployees")
public String viewEmployees(HttpSession session,HttpServletRequest request, Model model)
{
	ArrayList<Employee> employees = new ArrayList<>();
	employees.addAll(EmployeeRepo.getEmployees());
	
	model.addAttribute("employees",employees);
	return "viewEmployees.html";
}

@GetMapping("/viewEmployee")
public String viewEmployeePerson(HttpSession session,HttpServletRequest request, Model model) {
	ArrayList<Employee> employees = new ArrayList<>();
	String name = request.getUserPrincipal().getName();
	employees.add(EmployeeRepo.getEmployee(name));
	model.addAttribute("employees",employees);
	return "viewEmployee.html";
	
}

@GetMapping("/edit/{id}")
public String editEmployee(@PathVariable int id,Model model)
{
	Employee employee= EmployeeRepo.getEmployeeByID(id);
	model.addAttribute("employee",employee);
	return "EditEmployees.html";
}

@PostMapping("/EditEmployee")
public String modifyEmployee(@ModelAttribute Employee employee)
{
	EmployeeRepo.editEmployee(employee);
	return "redirect:/viewEmployees";
}

@GetMapping("/delete/{id}")
public String deleteDrink(@PathVariable int id, Model model)
{
	EmployeeRepo.deleteEmployee(id);
	return "redirect:/viewEmployees";
}

@GetMapping("/?logout")
public String goLogout() {
	return "root.html";
}

@GetMapping("/access-denied")
public String goAccess() {
	return "access-denied.html";
}

}
