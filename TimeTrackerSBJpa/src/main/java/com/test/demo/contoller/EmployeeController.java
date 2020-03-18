

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.test.demo.exception.UserNotFoundException;
import com.test.demo.model.Employee;
import com.test.demo.service.EmployeeService;



	@RestController
	public class EmployeeController {

		@Autowired
		private EmployeeService service;
		
		@PostMapping("/save")
		public void saveEmployee(Employee emp) {
			service.saveEmployee(emp);
		
		
	}
		
		
		  @GetMapping("empl/{id}")
		  public Employee getEmployeeById(@PathVariable("id") Long id) throws UserNotFoundException {
		  Employee entity = service.getEmployeeById(id);
		  
		 // return new EmployeeEntity(entity, new HttpHeaders(), HttpStatus.OK);
		  return entity;
		  }
		 
		

	}


