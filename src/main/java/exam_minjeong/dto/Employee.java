package exam_minjeong.dto;

public class Employee {
	private int no;
	private String name;
	private Title title;
	private Employee manager;
	private int salary;
	private Department dept;

	public Employee() {
	}

	public Employee(int no) {
		this.no = no;
	}

	public Employee(int no, String name, Title title, Employee manager, int salary, Department dept) {
		this.no = no;
		this.name = name;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dept = dept;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return String.format("Employee [no=%s, name=%s, title=%s, manager=%s, salary=%s, dept=%s]", no, name, title,
				manager, salary, dept);
	}

}
