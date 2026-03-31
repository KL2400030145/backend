package com.klu.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Student;
import com.klu.service.StudentManager;

@RestController
@RequestMapping("/dbcrud")
@ResponseBody
@CrossOrigin(origins = "*")
public class StudentController 
{
	@Autowired
   StudentManager sm;
	//http://localhost:8080/dbcrud/insert
	@PostMapping("/insert")
	@ResponseBody
	public String insert(@RequestBody Student s2)
	{
		return sm.insertData(s2);
	}
	@GetMapping("/getall")
	@ResponseBody
	public List<Student>getAll(){
		return sm.getAllData();
	}
	// http://localhost:8080/dbcrud/getbyId/1
	@GetMapping("/getbyId/{sid}")
	@ResponseBody
	public Student getById(@PathVariable Long sid)
	{
	    return sm.getDataById(sid);
	}
	// http://localhost:8080/dbcrud/updateAll/1
	@PutMapping("/updateAll/{sid}")
	@ResponseBody
	public String updateAllData(@PathVariable Long sid, @RequestBody Student s2)
	{
	    return sm.updateAllData(sid, s2);
	}
	
	
	// http://localhost:8080/dbcrud/updatename/1?sname=pavan
	@PatchMapping("/updatename/{sid}")
	 @ResponseBody
	 public String updateName(@PathVariable Long sid,@RequestParam String sname) 
	 {
	  return sm.updateName(sid, sname);
	 }
	
	 // http://localhost:8080/dbcrud/updatedept/1?sdept=CSE-A
	@PatchMapping("updateDept/{sid}")
	 @ResponseBody
	 public String updateDept(@PathVariable Long sid,@RequestParam String sdept)
	 {
	  return sm.updateDept(sid, sdept);
	 }
	
	
	//http://localhost:8080/dbcrud/delete/1
	@DeleteMapping("/delete/{sid}")
	@ResponseBody
	public String delete(@PathVariable Long sid)
	{
	    return sm.deleteData(sid);
	}
}

