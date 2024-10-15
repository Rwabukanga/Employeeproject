package com.EmployeeManagementSystem.employeemanagementsystem.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Employee;
import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Position;
import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Status;
import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Systemuser;
import com.EmployeeManagementSystem.employeemanagementsystem.Exception.EmailException;
import com.EmployeeManagementSystem.employeemanagementsystem.Exception.NameException;
import com.EmployeeManagementSystem.employeemanagementsystem.Service.EmployeeService;
import com.EmployeeManagementSystem.employeemanagementsystem.Service.SystemuserService;
import com.EmployeeManagementSystem.employeemanagementsystem.Utility.Msg;
import com.EmployeeManagementSystem.employeemanagementsystem.Utility.ResponseBean;
import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
@CrossOrigin
@RequestMapping(value="/employ")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;
	
	@Autowired
	private SystemuserService userservice;
	
//	@Autowired
//	private JavaMailSender MailSender;
//	
	
	@CrossOrigin
	@RequestMapping(value="/saveemployee", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> createEmployee(HttpServletRequest request, @RequestBody innerEmployee employee){
		
		ResponseBean rb = new ResponseBean();
		
//		try {
			Employee em = new Employee();
			
			
			
			    if(employee.getName().isEmpty()) {
			    	throw new NameException("Complete Names");
			    }else {
			    	em.setName(employee.getName());
			    }
			    
			    if(employee.getEmail().isEmpty()) {
			    	throw new EmailException("Invalid Email");
			    }else {
			    	em.setEmail(employee.getEmail());
			    }
				
			    if(employee.getPhonenumber().isEmpty()) {
			    	throw new EmailException("Invalid Phone Numbers");
			    }else {
			    	em.setPhonenumber(employee.getPhonenumber());
			    }
				
				em.setPhonenumber(employee.getPhonenumber());
				em.setStatus(Status.Active);
				em.setDateofbirth(employee.getDateofbirth());
				em.setPosition(Position.Pending);
				em.setUsername(employee.getUsername());
				em.setPassword(employee.getPassword());
				em.setNationalid(employee.getNationalid());
				em.setCode(employee.getCode());
				employeeservice.createEmployee(em);
				
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription(Msg.save);
				rb.setObject(em);	
				
				Systemuser user = new Systemuser();
				user.setName(em.getName());
				user.setEmail(em.getEmail());
				user.setPhonenumber(em.getPhonenumber());
				user.setStatus(Status.Active);
				user.setDateofbirth(em.getDateofbirth());
				user.setPosition(Position.Pending);
				user.setUsername(em.getUsername());
				user.setPassword(em.getPassword());
				user.setNationalid(em.getNationalid());
				user.setCode(em.getCode());
				user.setEmp(em);
				userservice.create(user);
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription(Msg.save);
				rb.setObject(user);
			
//				SimpleMailMessage message = new SimpleMailMessage();
//			  message.setFrom("sethfils2016@gmail.com"); 
//			  message.setTo(user.getEmail());
//			  message.setSubject("this is your username and Password");
//			  message.setText(user.getPassword()); 
//			  
//			  MailSender.send(message);
			  
			
			
//		}catch(Exception ex) {
//			ex.printStackTrace();
//			rb.setCode(Msg.ERROR_CODE);
//			rb.setDescription("fail to save");
//		}
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
		
		
	}
	
	@CrossOrigin
	@RequestMapping(value="/savemanager", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> createEmployeeMnanager(HttpServletRequest request, @RequestBody innerEmployee employee){
		
		ResponseBean rb = new ResponseBean();
		
//		try {
			Employee em = new Employee();
			
			
				em.setName(employee.getName());
				em.setEmail(employee.getEmail());
				em.setPhonenumber(employee.getPhonenumber());
				em.setStatus(Status.Active);
				em.setDateofbirth(employee.getDateofbirth());
				em.setPosition(Position.Manager);
				em.setUsername(employee.getUsername());
				em.setPassword(employee.getPassword());
				em.setNationalid(employee.getNationalid());
				employeeservice.createEmployee(em);
				
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription(Msg.save);
				rb.setObject(em);	
				
//				Systemuser user = new Systemuser();
//				user.setName(em.getName());
//				user.setEmail(em.getEmail());
//				user.setPhonenumber(em.getPhonenumber());
//				user.setStatus(Status.Active);
//				user.setDateofbirth(em.getDateofbirth());
//				user.setPosition(Position.Manager);
//				user.setUsername(em.getUsername());
//				user.setPassword(em.getPassword());
//				user.setNationalid(em.getNationalid());
//				user.setNationalid(em.getNationalid());
//				user.setEmp(em);
//				userservice.create(user);
//				rb.setCode(Msg.SUCCESS_CODE);
//				rb.setDescription(Msg.save);
//				rb.setObject(user);
//			
//			  SimpleMailMessage message = new SimpleMailMessage();
//			  message.setFrom("sethfils2016@gmail.com"); message.setTo(user.getEmail());
//			  message.setSubject("this is your username and Password");
//			  message.setText(user.getPassword()); 
//			  MailSender.send(message);
			 
			
			
//		}catch(Exception ex) {
//			ex.printStackTrace();
//			rb.setCode(Msg.ERROR_CODE);
//			rb.setDescription("fail to save");
//		}
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
		
		
	}
	
	@CrossOrigin
	@RequestMapping(value= "/all", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> alluser(){
		
		ResponseBean rb = new ResponseBean();
		try {
			List<Employee> list = employeeservice.findAll(Employee.class);
			
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("get all");
			rb.setObject(list);
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to retrieve it");
		}
		
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@RequestMapping(value="/update/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateuser(HttpServletRequest request, @PathVariable int id, @RequestBody innerEmployee employee){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Employee> rg= employeeservice.findByid(id);
			Employee em = rg.get();
			
			em.setName(employee.getName());
			em.setEmail(employee.getEmail());
			em.setPhonenumber(employee.getPhonenumber());
			em.setStatus(employee.getStatus());
			em.setDateofbirth(employee.getDateofbirth());
			//em.setPosition(Position.Manager);
			
			
			
			
			employeeservice.updateRegistrar(em);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription("Success Updated");
			rb.setObject(em);
		}catch(Exception ex) {
			ex.printStackTrace();
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Failed to Update");
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/find/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findOne(HttpServletRequest request, @PathVariable int id){
		
		ResponseBean rb = new ResponseBean();
		try {
			Optional<Employee> reg = employeeservice.findByid(id);
			Employee regg = reg.get();
			
			if(regg == null) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to found it");
			}else {
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("Employee Found it");
				rb.setObject(regg);
			}
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to found it");
		}
		
		return new ResponseEntity<Object>(rb,HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{email}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findEmail(HttpServletRequest request,@PathVariable String email){
		
		ResponseBean rb = new ResponseBean();
		
		try {
			Optional<Employee> reg = employeeservice.findByEmail(email);
			Employee regg= reg.get();
			
			if(regg == null) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to found it");
			}else {
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("get all");
				rb.setObject(regg);
			}
			
		}catch(Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to found it");
		}
		return new ResponseEntity<Object>(rb,HttpStatus.OK);
	}
		@CrossOrigin
		@RequestMapping(value="/name", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Object> findname(HttpServletRequest request,@PathVariable String name){
			
			ResponseBean rb = new ResponseBean();
			
			try {
				Optional<Employee> reg = employeeservice.findByName(name);
				Employee regg= reg.get();
				
				if(regg == null) {
					rb.setCode(Msg.ERROR_CODE);
					rb.setDescription("failed to found it");
				}else {
					rb.setCode(Msg.SUCCESS_CODE);
					rb.setDescription("get all");
					rb.setObject(regg);
				}
				
			}catch(Exception ex) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to found it");
			}
		
		return new ResponseEntity<Object>(rb,HttpStatus.OK);
	}
	
	/*
	 * @CrossOrigin
	 * 
	 * @RequestMapping(value="/{phonenumber}", method= RequestMethod.GET, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Object>
	 * findphonenumber(HttpServletRequest request,@PathVariable String phonenumber){
	 * 
	 * ResponseBean rb = new ResponseBean();
	 * 
	 * try { Optional<Employee> reg =
	 * employeeservice.findByPhonenumber(phonenumber); Employee regg= reg.get();
	 * 
	 * if(regg == null) { rb.setCode(Msg.ERROR_CODE);
	 * rb.setDescription("failed to found it"); }else {
	 * rb.setCode(Msg.SUCCESS_CODE); rb.setDescription("get all");
	 * rb.setObject(regg); }
	 * 
	 * }catch(Exception ex) { rb.setCode(Msg.ERROR_CODE);
	 * rb.setDescription("failed to found it"); }
	 * 
	 * return new ResponseEntity<Object>(rb,HttpStatus.OK); }
	 */
	
	    @CrossOrigin
	    @RequestMapping(method = RequestMethod.PUT, value = "/active/{uuid}", consumes = MediaType.APPLICATION_JSON_VALUE)
	   	public ResponseEntity<Object> ActivateEmployee(HttpServletRequest request, @PathVariable String uuid,@RequestBody innerEmployee employee) {

	   		ResponseBean rb = new ResponseBean();
	   		try {
	   			Optional<Employee> reg = employeeservice.findByUuid(uuid);
	   			Employee employe = reg.get();
	   			employe.setName(employee.getName());
	   			employe.setEmail(employee.getEmail());
	   			employe.setPhonenumber(employee.getPhonenumber());
	   			employe.setStatus(employee.getStatus());
	   			employe.setDateofbirth(employee.getDateofbirth());
	   			employe.setPosition(employee.getPosition());
	   			employe.setStatus(Status.Active);
	                  
	   			employeeservice.updateRegistrar(employe);
	   			rb.setCode(Msg.SUCCESS_CODE);
	   			rb.setDescription("Employee Activated");
                rb.setObject(employe);
	   				
	   		} catch (Exception e) {
	   			rb.setCode(Msg.ERROR_CODE);
	   			rb.setDescription("Employee not well Updated");
	   		}
	   		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	   	}	
	    
	    @CrossOrigin
	    @RequestMapping(method = RequestMethod.PUT, value = "/suspended/{uuid}", consumes = MediaType.APPLICATION_JSON_VALUE)
	   	public ResponseEntity<Object> suspendedEmployee(HttpServletRequest request, @PathVariable String uuid,@RequestBody innerEmployee employee) {

	   		ResponseBean rb = new ResponseBean();
	   		try {
	   			Optional<Employee> reg = employeeservice.findByUuid(uuid);
	   			Employee employe = reg.get();
	   			employe.setName(employee.getName());
	   			employe.setEmail(employee.getEmail());
	   			employe.setPhonenumber(employee.getPhonenumber());
	   			employe.setStatus(employee.getStatus());
	   			employe.setDateofbirth(employee.getDateofbirth());
	   			employe.setPosition(employee.getPosition());
	   			employee.setStatus(Status.Suspended);
	                  
	   			employeeservice.updateRegistrar(employe);
	   			rb.setCode(Msg.SUCCESS_CODE);
	   			rb.setDescription("Employee Activated");
                rb.setObject(employee);
	   				
	   		} catch (Exception e) {
	   			rb.setCode(Msg.ERROR_CODE);
	   			rb.setDescription("Employee not well Suspended");
	   		}
	   		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	   	}
	    
	    @CrossOrigin
		@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
		public ResponseEntity<Object> deleteRequest(HttpServletRequest request, @PathVariable int id){
			ResponseBean rb= new ResponseBean();
			try {
				Optional<Employee> inst= employeeservice.findByid(id);
				Employee ins = inst.get();
				if(ins == null) {
					rb.setCode(Msg.NULLS_FOUND);
					rb.setDescription("not deleted");
					
				}else {
					employeeservice.deleteEmployee(id);
					rb.setCode(Msg.SUCCESS_CODE);
					rb.setDescription(Msg.delete);
					rb.setObject(ins);		
				}
			}catch(Exception ex) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to delete Institution");
				
			}
			return new ResponseEntity<Object>(rb,HttpStatus.OK);
		}
	    
	
	public static class innerEmployee{
		
		private int id;
		private String uuid = UUID.randomUUID().toString();
		private String name;
		private String phonenumber;
		private String email;
		private String nationalid;
		private String code;
		
		@JsonFormat(pattern="yyyy-MM-dd")
		private Date dateofbirth;
		
		@Enumerated(EnumType.STRING)
		private Status status;
		
		@Enumerated(EnumType.STRING)
		private Position position;
		
		private String username;
		
		private String password;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUuid() {
			return uuid;
		}

		public void setUuid(String uuid) {
			this.uuid = uuid;
		}

		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhonenumber() {
			return phonenumber;
		}

		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Date getDateofbirth() {
			return dateofbirth;
		}

		public void setDateofbirth(Date dateofbirth) {
			this.dateofbirth = dateofbirth;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public Position getPosition() {
			return position;
		}

		public void setPosition(Position position) {
			this.position = position;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getNationalid() {
			return nationalid;
		}

		public void setNationalid(String nationalid) {
			this.nationalid = nationalid;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}
		
		
	}
	
}
