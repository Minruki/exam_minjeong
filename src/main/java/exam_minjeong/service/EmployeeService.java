package exam_minjeong.service;

import java.util.List;

import org.springframework.stereotype.Service;

import exam_minjeong.dto.Employee;

@Service
public interface EmployeeService {

	List<Employee> getLists();
	Employee getEmployee(int empNo);
	int registerEmployee(Employee employee);
	int modifyEmployee(Employee employee);
	int removeEmployee(Employee employee);
}
