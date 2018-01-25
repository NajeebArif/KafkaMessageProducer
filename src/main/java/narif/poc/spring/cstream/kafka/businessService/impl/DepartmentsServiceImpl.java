/**
 * 
 */
package narif.poc.spring.cstream.kafka.businessService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import narif.poc.spring.cstream.kafka.businessService.DepartmentsService;
import narif.poc.spring.cstream.kafka.entities.Department;
import narif.poc.spring.cstream.kafka.events.EventsSourceBean;
import narif.poc.spring.cstream.kafka.repository.DepartmentJpaRepo;

/**
 * @author narif
 *
 */
@Service
public class DepartmentsServiceImpl implements DepartmentsService {
	
	@Autowired
	private DepartmentJpaRepo repo;
	
	@Autowired
	private EventsSourceBean eventsPublisher;

	/* (non-Javadoc)
	 * @see narif.poc.spring.cstream.kafka.businessService.DepartmentsService#getAllDepartment()
	 */
	@Override
	public List<Department> getAllDepartment() {
		List<Department> depts = repo.findAll(); 
		eventsPublisher.publishCustomMessage("FIND_ALL", "SUCCESS", "All department Details found");
		return depts;
	}

	/* (non-Javadoc)
	 * @see narif.poc.spring.cstream.kafka.businessService.DepartmentsService#createDepartment(narif.poc.spring.cstream.kafka.entities.Department)
	 */
	@Override
	public Department createDepartment(Department dept) {
		try {
			repo.saveAndFlush(dept);
			eventsPublisher.publishCustomMessage("CREATE_DEPARTMENT", "SUCCESS", "Department Created. Department_id: "+dept.getDepartmentId());
		}catch(Exception e) {
			eventsPublisher.publishCustomMessage("CREATE_DEPARTMENT", "FAILURE", "Department creation failed: "+e.getMessage());
			return null;
		}
		return dept;
	}

	/* (non-Javadoc)
	 * @see narif.poc.spring.cstream.kafka.businessService.DepartmentsService#deleteDepartment(narif.poc.spring.cstream.kafka.entities.Department)
	 */
	@Override
	public Department deleteDepartment(Department dept) {
		try{
			repo.delete(dept);
			eventsPublisher.publishCustomMessage("DELETE_DEPARTMENT", "SUCCESS", "Department deletion complete: "+dept.getDepartmentId());
		}catch(Exception e) {
			eventsPublisher.publishCustomMessage("DELETE_DEPARTMENT", "FAILURE", "Department deletion failed: "+e.getMessage());
			return null;
		}
		return dept;
	}

	/* (non-Javadoc)
	 * @see narif.poc.spring.cstream.kafka.businessService.DepartmentsService#updateDepartment(narif.poc.spring.cstream.kafka.entities.Department)
	 */
	@Override
	public Department updateDepartment(Department dept) {
		try {
			repo.saveAndFlush(dept);
			eventsPublisher.publishCustomMessage("UPDATE_DEPARTMENT", "SUCCESS", "Department updated. Department_id: "+dept.getDepartmentId());
		}catch(Exception e) {
			eventsPublisher.publishCustomMessage("UPDATE_DEPARTMENT", "FAILURE", "Department updation failed: "+e.getMessage());
			return null;
		}
		return dept;
	}

	/* (non-Javadoc)
	 * @see narif.poc.spring.cstream.kafka.businessService.DepartmentsService#findDepartmentForDepartmentName(java.lang.String)
	 */
	@Override
	public Department findDepartmentForDepartmentName(String deptName) {
		Department dept = repo.findByDepartmentName(deptName);
		eventsPublisher.publishCustomMessage("FIND_DEPARTMENT", "SUCCESS", "Department Found for department name: "+deptName);
		return dept;
	}

	/* (non-Javadoc)
	 * @see narif.poc.spring.cstream.kafka.businessService.DepartmentsService#updateListOfDepartments(java.util.List)
	 */
	@Override
	public List<Department> updateListOfDepartments(List<Department> deptList) {
		return repo.save(deptList);
	}

}
