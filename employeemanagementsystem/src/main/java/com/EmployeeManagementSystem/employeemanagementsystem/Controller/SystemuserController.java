package com.EmployeeManagementSystem.employeemanagementsystem.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeManagementSystem.employeemanagementsystem.Domain.Systemuser;
import com.EmployeeManagementSystem.employeemanagementsystem.Service.SystemuserService;
import com.EmployeeManagementSystem.employeemanagementsystem.Utility.Msg;
import com.EmployeeManagementSystem.employeemanagementsystem.Utility.ResponseBean;

@RestController
@CrossOrigin
@RequestMapping("/syst")
public class SystemuserController {

	@Autowired
	private SystemuserService sysservice;

	@CrossOrigin
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(HttpRequest request, @RequestBody Systemuser user) {

		ResponseBean rb = new ResponseBean();

		try {
			
//			 final String hashedPassword = BCrypt.hashpw(user.getPassword(),
//			 BCrypt.gensalt()); user.setPassword(hashedPassword);
			 
			sysservice.create(user);
			rb.setCode(Msg.SUCCESS_CODE);
			rb.setDescription(Msg.save);
			rb.setObject(user);
		} catch (Exception ex) {

			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("Fail to save");

			ex.printStackTrace();
		}

		return new ResponseEntity<Object>(rb, HttpStatus.OK);

	}

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Object> login(@RequestBody Userr user) {

		ResponseBean rb = new ResponseBean();
		try {

			if (user != null) {
				Map<String, Object> map = new HashMap<String, Object>();

				
//				  final String hashedPassword = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
//				 

				
				 /* if((sysservice.findByUsernameAndPassword(user.getUsername(),
				  Encryption.md5(user.getPassword())) != null)) {*/
				 
				if ((sysservice.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null)) {

					Systemuser systemuser = sysservice.findByUsernameAndPassword(user.getUsername(),
							user.getPassword());
					System.out.println("user login");
					rb.setCode(Msg.SUCCESS_CODE);
					rb.setDescription("User login");
					map.put("user", systemuser);
					rb.setObject(map);

				} /*
					 * else { rb.setCode(Msg.ERROR_CODE);
					 * rb.setDescription("Failed to match username and password1");
					 * rb.setObject(null); } }
					 */ else {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("Failed to match it");
				rb.setObject(null);
			}

		} 
		}catch (Exception ex) {
			rb.setDescription("failed to pass it");
			rb.setObject(null);

			ex.printStackTrace();
		}
		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/changepassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> resetpassword(@RequestBody Userlogin user) {

		ResponseBean rs = new ResponseBean();

		if (user != null) {
			Map<String, Object> map = new HashMap();

			if (user.getPassword().equalsIgnoreCase(user.getConfirmPassword())) {
				Systemuser sys = sysservice.findByUsername(user.getUsername());

				
				
//				  final String hashedPassword =
////				  BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
//				 
//				 user.setPassword(hashedPassword); 
				if (sysservice.update(sys).equalsIgnoreCase(Msg.update)) {
					rs.setCode(Msg.SUCCESS_CODE);
					rs.setDescription("Password successfully changed");
					map.put("user", map);
					rs.setObject(map);

				} else {
					rs.setCode(Msg.ERROR_CODE);
					rs.setDescription("Password not  successfully changed1");
					rs.setObject(null);
				}

			} else {
				rs.setCode(Msg.ERROR_CODE);
				rs.setDescription("Password not successfully changed2");
				rs.setObject(null);
			}
		} else {
			rs.setCode(Msg.ERROR_CODE);
			rs.setDescription("Password not successfully changed3");
			rs.setObject(null);
		}

		return new ResponseEntity<Object>(rs, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> findOne(HttpServletRequest request, @PathVariable int id) {

		ResponseBean rb = new ResponseBean();
		try {
			Optional<Systemuser> reg = sysservice.findById(id);
			Systemuser regg = reg.get();

			if (regg == null) {
				rb.setCode(Msg.ERROR_CODE);
				rb.setDescription("failed to found it");
			} else {
				rb.setCode(Msg.SUCCESS_CODE);
				rb.setDescription("User Found it");
				rb.setObject(regg);
			}

		} catch (Exception ex) {
			rb.setCode(Msg.ERROR_CODE);
			rb.setDescription("failed to found it");
		}

		return new ResponseEntity<Object>(rb, HttpStatus.OK);
	}

	
	  @CrossOrigin
	  @RequestMapping(value="/getuser", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
	  public ResponseEntity<Object> getUserDetails(Authentication auth){ 
		  
		  
	ResponseBean rb = new ResponseBean();
	 
	try { 
		  
		  
	Systemuser user= (Systemuser) auth.getPrincipal();
	  
	System.out.println("userfound"); 
	  
	  rb.setCode(Msg.SUCCESS_CODE); 
	  rb.setDescription("User Found it");
	  rb.setObject(auth); 
	  
	  return new ResponseEntity<>(rb, HttpStatus.OK);
	  
	  }catch(Exception ex) {
	  
	  return new ResponseEntity<Object>(rb,HttpStatus.BAD_REQUEST);
	  
	  }
	  
	  
	  }
	 

	public static class Userr {

		private String username;
		private String password;

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

	}

	public static class Userlogin {
		private String username;
		private String password;
		private String applicationName;
		private String confirmPassword;

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

		public String getApplicationName() {
			return applicationName;
		}

		public void setApplicationName(String applicationName) {
			this.applicationName = applicationName;
		}

		public String getConfirmPassword() {
			return confirmPassword;
		}

		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}

	}
}
