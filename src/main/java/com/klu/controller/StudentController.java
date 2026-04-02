package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Student;
import com.klu.service.StudentManager;

@RestController
@RequestMapping("/dbcrud")
@CrossOrigin(
    origins = "https://frontend-wlje.onrender.com",
    allowedHeaders = "*",
    methods = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.DELETE,
        RequestMethod.PATCH,
        RequestMethod.OPTIONS
    }
)
public class StudentController 
{
    @Autowired
    StudentManager sm;

    // 🔹 Insert
    @PostMapping("/insert")
    public String insert(@RequestBody Student s2)
    {
        return sm.insertData(s2);
    }

    // 🔹 Get All
    @GetMapping("/getall")
    public List<Student> getAll()
    {
        return sm.getAllData();
    }

    // 🔹 Get By ID
    @GetMapping("/getbyId/{sid}")
    public Student getById(@PathVariable Long sid)
    {
        return sm.getDataById(sid);
    }

    // 🔹 Update All
    @PutMapping("/updateAll/{sid}")
    public String updateAllData(@PathVariable Long sid, @RequestBody Student s2)
    {
        return sm.updateAllData(sid, s2);
    }

    // 🔹 Update Name
    @PatchMapping("/updatename/{sid}")
    public String updateName(@PathVariable Long sid, @RequestParam String sname) 
    {
        return sm.updateName(sid, sname);
    }

    // 🔹 Update Dept
    @PatchMapping("/updateDept/{sid}")
    public String updateDept(@PathVariable Long sid, @RequestParam String sdept)
    {
        return sm.updateDept(sid, sdept);
    }

    // 🔹 Delete
    @DeleteMapping("/delete/{sid}")
    public String delete(@PathVariable Long sid)
    {
        return sm.deleteData(sid);
    }
}