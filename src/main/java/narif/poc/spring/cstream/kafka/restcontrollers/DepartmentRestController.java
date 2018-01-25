package narif.poc.spring.cstream.kafka.restcontrollers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import narif.poc.spring.cstream.kafka.businessService.DepartmentsService;
import narif.poc.spring.cstream.kafka.entities.Department;

@RestController
@RequestMapping(value="/v1/departments")
public class DepartmentRestController {
	
	@Autowired
	private DepartmentsService service;
	
	@RequestMapping
	public List<Department> getAllDepartment(@RequestParam(value = "deptName",required=false) Optional<String> deptNameOp){
		return deptNameOp.isPresent()?
				Arrays.asList(service.findDepartmentForDepartmentName(deptNameOp.get()))
				:service.getAllDepartment();
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public Department createDepartment(@RequestBody Department dept) {
		return service.createDepartment(dept);
	}
	
	@RequestMapping(value="{deptId}")
	public Department getDepartment(@PathVariable("deptId") Department dept) {
		return dept;
	}
	
	@RequestMapping(value="{deptId}",method=RequestMethod.PUT)
	public Department updateDepartment(@PathVariable("deptId")Long deptId, @RequestBody Department dept) {
		return service.updateDepartment(dept);
	}
	
	@RequestMapping(value="{deptId}",method=RequestMethod.DELETE)
	public Department deleteDepartment(@PathVariable("deptId") Department dept) {
		return service.deleteDepartment(dept);
	}

}
