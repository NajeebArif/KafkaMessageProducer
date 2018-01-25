/**
 * 
 */
package narif.poc.spring.cstream.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import narif.poc.spring.cstream.kafka.entities.Department;

/**
 * @author narif
 * Departments repo extends the JpaRepository
 */
@Repository
public interface DepartmentJpaRepo extends JpaRepository<Department, Long> {
	
	/**
	 * @param departmentName
	 * @return Department instance
	 * method returns a single department instance for given Department name
	 */
	public Department findByDepartmentName(String departmentName);

}
