/**
 * 
 */
package narif.poc.spring.cstream.kafka.businessService;

import java.util.List;

import narif.poc.spring.cstream.kafka.entities.Department;

/**
 * @author narif
 *Business service which has the business methods
 */
public interface DepartmentsService {
	
	public List<Department> getAllDepartment();
	
	public Department createDepartment(Department dept);
	
	public Department deleteDepartment(Department dept);
	
	public Department updateDepartment(Department dept);
	
	public Department findDepartmentForDepartmentName(String deptName);
	
	public List<Department> updateListOfDepartments(List<Department> deptList);

}
