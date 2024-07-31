package org.jsp.crud_demo.controller;

import java.util.List;

import org.jsp.crud_demo.dto.Student;
import org.jsp.crud_demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;import jakarta.websocket.server.PathParam;

@Controller
public class StudentController {

	@Autowired
	StudentRepository repository;

	@GetMapping("/")
	public String loadMain(ModelMap map) {
		List<Student> students=repository.findAll();
		if(students.isEmpty()) {
			map.put("failure", "No Records Found");	
			return "main.html";
		}else {
			map.put("list", students);
			return "main.html";
		}
	}

	@GetMapping("/insert")
	public String loadInsert(ModelMap map) {
		map.put("insert", "insert");
		return loadMain(map);
	}

	@PostMapping("/insert")
	public String insert(Student student, ModelMap map) {
		repository.save(student);
		map.put("success", "Record Saved Success");
		return loadMain(map);
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,ModelMap map) {
		repository.deleteById(id);
		map.put("success", "Record deleted Success");
		return loadMain(map);
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,ModelMap map) {
		Student student=repository.findById(id).orElseThrow();
		map.put("student", student);
		map.put("update", "update");
		return loadMain(map);
	}
	
	@PostMapping("/update")
	public String update(Student student, ModelMap map) {
		repository.save(student);
		map.put("success", "Record Updated Success");
		return loadMain(map);
	}
	
}
