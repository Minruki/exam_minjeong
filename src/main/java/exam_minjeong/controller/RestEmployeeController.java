package exam_minjeong.controller;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exam_minjeong.dto.Employee;
import exam_minjeong.exception.DuplicateEmployeeException;
import exam_minjeong.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class RestEmployeeController {

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	public ResponseEntity<Object> employees(){
		System.out.println("employees()");
		return ResponseEntity.ok(service.getLists());
	}
	
	@GetMapping("/employees/{no}")
	public ResponseEntity<Object> employee(@PathVariable int no, HttpServletResponse response){
		Employee emp = service.getEmployee(no);
		if (emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(emp);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Object> newEmployee(@RequestBody Employee employee) {
		System.out.println("newEmployee > " + employee);
		
		try {
			service.registerEmployee(employee);
			
			URI uri = URI.create("/api/employees/" + employee.getNo());
			return ResponseEntity.created(uri).body(employee.getNo());
		} catch (DuplicateEmployeeException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PatchMapping("employees/{no}")
	public ResponseEntity<Object> updateEmployee(@PathVariable int no, @RequestBody Employee employee) {
		System.out.println("updateEmployee > " + employee);
		return ResponseEntity.ok(service.modifyEmployee(employee));
	}
	
	@DeleteMapping("/employees/{no}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable int no) {
		System.out.println("deleteEmployee > " + no);
		return ResponseEntity.ok(service.removeEmployee(new Employee(no)));
	}
}
