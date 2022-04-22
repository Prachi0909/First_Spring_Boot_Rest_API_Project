package com.springboot_example4.springboot.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.springboot_example4.springboot.Entities.StuEntity;
import com.springboot_example4.springboot.MyException.IdException;
import com.springboot_example4.springboot.MyException.depException;
import com.springboot_example4.springboot.Repository.StuRepo;

@Service
public class StuService {

	@Autowired
	private StuRepo rep;

	public StuEntity saveEntity(StuEntity en) throws IdException  {
		// TODO Auto-generated method stub
		//try {
			for(StuEntity e: rep.findAll()) {
				if(e.getStuId() == en.getStuId() ) {
					throw new IdException("Your Id is already exists");
				}
			}
		//}
		//catch(IdException ex) {
			//ex.printStackTrace();
		//}
		return rep.save(en);
	}

	public List<StuEntity> fetchStudent() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}

	public StuEntity fetchStudentById(Long id) throws depException {
		// TODO Auto-generated method stub
		Optional<StuEntity> dep = 
				rep.findById(id);
		if(!dep.isPresent()) {
			throw new depException("Department not available!");
		}
		return dep.get();
		//return rep.findById(id).get();
	}

	public void deleteStudentById(Long id) {
		rep.deleteById(id);
	}

	public StuEntity updateStudent(Long stuId, StuEntity entity) {
		// TODO Auto-generated method stub
		StuEntity dep = rep.findById(stuId).get();
		if(Objects.nonNull(entity.getStuName()) && 
				!"".equalsIgnoreCase(entity.getStuName())) {
			dep.setStuName(entity.getStuName());
		}
		if(Objects.nonNull(entity.getStuAge()) && 
				!"".equals(entity.getStuAge())) {
			dep.setStuAge(entity.getStuAge());
		}
		return rep.save(dep);
	}

	public StuEntity fetchStudentByName(String stuName) {
		 //TODO Auto-generated method stub
		return rep.findBystuName(stuName);
	}

	public StuEntity fetchStudentByAge(int stuAge) {
		// TODO Auto-generated method stub
		return rep.findBystuAge(stuAge);
	}

	public List<StuEntity> findAllSorting(String stuName) {
		// TODO Auto-generated method stub
		Pageable sortByName = PageRequest.of(0, 20, Sort.by("stuName"));
		Pageable sortByCreditAsc = PageRequest.of(0, 20, Sort.by("credit").ascending());
	
		Pageable sortByNameAndCreditAsc = PageRequest.of(0, 20,Sort.by("stuName").ascending().and(Sort.by("credit")));
	
		//List<StuEntity> stu = rep.findAll(sortByName).getContent();
		return rep.findAll(sortByName).getContent();
	}
	//public List<StuEntity> SortingByName(String name){
		//return rep.findAll(Sort.by(Sort.Direction.ASC, name));
	//}
}
