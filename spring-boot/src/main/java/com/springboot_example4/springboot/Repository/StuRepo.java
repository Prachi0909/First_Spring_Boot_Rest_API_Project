package com.springboot_example4.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.springboot_example4.springboot.Entities.StuEntity;

@Repository
public interface StuRepo extends JpaRepository<StuEntity, Long>{

	@Query(value=" ", nativeQuery = true)
	public StuEntity findBystuName(String stuName);
    public StuEntity findBystuAge(int stuAge);
    
    //Hibernate Validation
    
}

