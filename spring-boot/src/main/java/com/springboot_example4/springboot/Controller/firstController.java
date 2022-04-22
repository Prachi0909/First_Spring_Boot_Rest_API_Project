package com.springboot_example4.springboot.Controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot_example4.springboot.Entities.StuEntity;
import com.springboot_example4.springboot.MyException.IdException;
import com.springboot_example4.springboot.MyException.depException;
import com.springboot_example4.springboot.Service.StuService;

@RequestMapping
@RestController                //default annotations
public class firstController {

	@Autowired
	private StuService service;

	//private final logger LOGGER = loggerFactory.getLogger(name firstController.class);
	
	
	@PostMapping("/Student")
	public StuEntity saveEntity(@Valid @RequestBody StuEntity en) throws IdException {
		return service.saveEntity(en);
	}
	@GetMapping("/Student")
	public List<StuEntity> fetchStudent(){
		return service.fetchStudent();
	}
	@GetMapping("/Student/{Id}")
	public StuEntity fetchStudentById(@PathVariable("Id") Long stuId) throws depException {
		return service.fetchStudentById(stuId);
	}
	@DeleteMapping("/Student/{Id}")
	public String deleteStudentById(@PathVariable("Id") Long stuId) {
		service.deleteStudentById(stuId);
		return "Department deleted Successfully!";
	}
	@PutMapping("/Student/{Id}")
	public StuEntity updateStudent(@PathVariable("Id") Long stuId, @RequestBody StuEntity entity ) {
		return service.updateStudent(stuId,entity);
	}
	@GetMapping("/Student/name/{name}")
	public StuEntity FetchStudentByName(@PathVariable("name") String stuName) {
		return service.fetchStudentByName(stuName);
	}
	@GetMapping("/Student/age/{age}")
	public StuEntity FetchStudentByAge(@PathVariable("age") int stuAge) {
		return service.fetchStudentByAge(stuAge);
	}
	@GetMapping("/Student/sortByName")
	public List<StuEntity> findAllNameBySorting( String stuName) {
		return service.findAllSorting(stuName);
	}
}
