package exam_minjeong.mapper;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import exam_minjeong.config.ContextRoot;
import exam_minjeong.dto.Department;
import exam_minjeong.dto.Employee;
import exam_minjeong.dto.Title;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeMapperTest {
	protected static final Log log = LogFactory.getLog(EmployeeMapperTest.class);
	
	@Autowired
	private EmployeeMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectEmployeeAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Employee> list = mapper.selectEmployeeAll();
		Assert.assertNotNull(list);
		
		list.forEach(s->log.debug(s.toString()));
	}

	@Test
	public void test02SelectByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Employee employee = mapper.selectByNo(1003);
		Assert.assertNotNull(employee);
		
		log.debug(employee.toString());
	}

	@Test
	public void test03InsertEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Employee newEmp = new Employee(1004, "천사", new Title(5), new Employee(1003), 1000000, new Department(1));
		
		int res = mapper.insertEmployee(newEmp);
		Assert.assertEquals(1, res);
		log.debug(newEmp.toString());
	}

	@Test
	public void test04UpdateEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Employee newEmp = new Employee(1004, "천사2", new Title(4), new Employee(4377), 2000000, new Department(2));
		
		int res = mapper.updateEmployee(newEmp);
		Assert.assertEquals(1, res);
		log.debug(newEmp.toString());
	}

	@Test
	public void test05DeleteEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Employee newEmp = new Employee(1004);
		
		int res = mapper.deleteEmployee(newEmp);
		Assert.assertEquals(1, res);
	}

}
