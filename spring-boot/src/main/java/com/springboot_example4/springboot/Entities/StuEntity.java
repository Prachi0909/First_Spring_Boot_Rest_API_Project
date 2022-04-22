package com.springboot_example4.springboot.Entities;

//import java.util.Objects;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data             //It is from the lombok (getters, setters, hashcode, tostring)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

  public class StuEntity {
	
	public long getStuId() {
		return stuId;
	}
	public void setStuId(long stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long stuId;
	//Validations for the json data(input data)
	//@NotBlank(message="Please add student name")
	//@Length(max = 5, min = 6)
	//@Size(max=4,min=8)
	private String stuName;
	private int stuAge;
	
}
