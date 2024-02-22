package com.gl.controller;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import com.gl.dbmodel.Employee;

@Controller
public class EmployeeController 
{
	@RequestMapping("/home")
	public String home() 
	{
		return "home";
	}

	@RequestMapping("/showrecords")
	public String record(Model data)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Query q2 = session.createQuery("from Employee");
		List<Employee> employee = q2.getResultList();
		data.addAttribute("employee", employee);
		return "show-record";
	}

	@RequestMapping("/AddRecordForm")
	public String addform() 
	{
		return "addRecord";
	}

	@PostMapping("/LinkRecord")
	public String link(@RequestParam int id,@RequestParam String employeeName, @RequestParam String employeeAddress,
			@RequestParam int employeePhone, @RequestParam double employeeSalary, Model data) 
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		try 
		{
			Transaction trans = session.beginTransaction();
			Employee employee = new Employee(id,employeeName, employeeAddress, employeePhone, employeeSalary);
			session.save(employee);
			trans.commit();
		} 
		catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
		Query q1 = session.createQuery("from Employee");
		List<Employee> employee = q1.getResultList();
		data.addAttribute("employee", employee);
		return "show-record";
	}

	@GetMapping("/updateEmployee")
	public String update(@RequestParam int id, Model data)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		try 
		{
			Employee employee = session.get(Employee.class, id);
			data.addAttribute("employee", employee);
		} 
		catch (Exception ex) 
		{
			System.out.println(ex.getMessage());
		}
		return "updateEmployee";
	}
	

	@GetMapping("/DeleteEmployee")
	public String delete(@RequestParam int id, Model data) 
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		try 
		{
			Transaction trans = session.beginTransaction();
			Employee employee = new Employee(id, null, null, 0, 0);
			session.delete(employee); 
			trans.commit();
		} 
		catch (Exception ex) 
		
		{
			System.out.println(ex.getMessage());
		}
		Query q2 = session.createQuery("from Employee");
		List<Employee> employee = q2.getResultList();
		data.addAttribute("employee", employee);
		return "show-record";
	}
	@GetMapping("/updated")
	public String afterupdate(@RequestParam int id, @RequestParam String employeeName,
			@RequestParam String employeeAddress, @RequestParam int employeePhone, @RequestParam double employeeSalary,
			Model data)
	{
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		try 
		{
			Transaction trans = session.beginTransaction();
			Employee employee = new Employee(id, employeeName, employeeAddress, employeePhone, employeeSalary);
			session.update(employee);
			
			Query q3 = session.createQuery("from Employee");
			List<Employee> employee1 = q3.getResultList();
			data.addAttribute("employee", employee1);
			trans.commit();
		} 
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return "show-record";
	}
	
	
}