package com.springboot.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.user.model.User;

@RestController
@RequestMapping("userspring")
public class UserController {
	@Autowired
	UserDAO userdao;
	//@Autowired
	//UserBusiness userbusiness;
	@DeleteMapping("/user/{userid}")  
	private @ResponseBody String deleteUser( @PathVariable("userid") int userid )	{ 
		
		System.out.println("Passed in User id: " + userid);
		return "deleted user";	
		
	}
	
	@PostMapping("/userid/{userid}/name/{uname}/email/{uemail}")
	public @ResponseBody String insertUser(@PathVariable("userid") int userid,@PathVariable("uname")String uname,@PathVariable("uemail")String uemail) {
		User u= new User() ;
		u.setUser_id(userid);
		u.setName(uname);
		u.setEmail_id(uemail);
		userdao.createUser(u);
		//userdao.updateUser(u);
		System.out.println(" User ID:" + userid + "\n User Name:" + uname + "\n User Email:" + uemail);
		
		return "inserted user";
		//return "updated user";
	}
	@PutMapping("/userid/{userid}/name/{uname}/email/{uemail}")
	public @ResponseBody String updateUser(@PathVariable("userid") int userid,@PathVariable("uname")String uname,@PathVariable("uemail")String uemail) {
		User u= new User() ;
		u.setUser_id(userid);
		u.setName(uname);
		u.setEmail_id(uemail);
		//userdao.createUser(u);
		userdao.updateUser(u);
		System.out.println(" User ID:" + userid + "\n User Name:" + uname + "\n User Email:" + uemail);
		
		//return "inserted user";
		return "updated user";
	}
	 @GetMapping("/userid/{userid}") 
	 public @ResponseBody String readUser(@PathVariable("userid") int userid) { 
		 User u= new User() ;
		 u.setUser_id(userid); //u.setName(uname); //u.setEmail_id(uemail);
		 userdao.readUser(u);
		 System.out.println(" User ID:" + userid );
	 
		 return "read user"; 
	 }
}
	/*
	 * @RequestMapping(value="/method0",method = RequestMethod.GET) public String
	 * displayLogonPage(ModelMap model) { String output=userbusiness.getMessage();
	 * model.addAttribute("message", output); return "showlogon"; }
	 */
	

