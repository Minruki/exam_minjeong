package exam_minjeong.service.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam_minjeong.dto.Employee;
import exam_minjeong.exception.DuplicateEmployeeException;
import exam_minjeong.mapper.EmployeeMapper;
import exam_minjeong.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	static final Log log= LogFactory.getLog(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeMapper mapper;
	
	@Override
	public List<Employee> getLists() {
		List<Employee> list = mapper.selectEmployeeAll();
		log.debug("service - getLists() > "+ list.size());
		return list;
	}

	@Override
	public Employee getEmployee(int empNo) {
		log.debug("service - getEmployee() > " + empNo);
		return mapper.selectByNo(empNo);
	}

	@Override
	public int registerEmployee(Employee employee) {
		log.debug("service - regiseterEmployee() > " + employee);
		Employee emp = mapper.selectByNo(employee.getNo());
		if (emp != null) {
			throw new DuplicateEmployeeException("dup no " + employee.getNo());
		}
		
		return mapper.insertEmployee(employee);
	}

	@Override
	public int modifyEmployee(Employee employee) {
		log.debug("service - modifyEmployee() > " + employee);
		return mapper.updateEmployee(employee);
	}

	@Override
	public int removeEmployee(Employee employee) {
		log.debug("service - removeEmployee() > " + employee);
		return mapper.deleteEmployee(employee);
	}

}
