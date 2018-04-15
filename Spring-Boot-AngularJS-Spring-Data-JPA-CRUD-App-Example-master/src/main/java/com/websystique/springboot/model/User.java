package com.websystique.springboot.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity /*Entity : thực thể. Cho biết lớp này ánh xạ tới bảng trong Database*/
@Table(name="APP_USER") // Tên table
public class User implements Serializable{
	/* Viết trên 1 dòng sẽ dễ hiểu hơn*/
	@Id //Chú thích đây là Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotEmpty // Chú thích các trường không được để trống
	@Column(name="NAME", nullable=false) // Chú thích tên trường và không được để trống
	private String name;

	@Column(name="AGE", nullable=false)
	private Integer age;

	@Column(name="SALARY", nullable=false)
	private double salary;

	/* Getter và setter */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override /*Nạp chồng phương thức so sánh đối tượng*/
	public boolean equals(Object o) {
		if (this == o) 
		    return true;
		if (o == null || getClass() != o.getClass())
		    return false;

		User user = (User) o; // ép kiểu

		if (Double.compare(user.salary, salary) != 0) 
		    return false;
		if (id != null ? !id.equals(user.id) : user.id != null)
		    return false;
		if (name != null ? !name.equals(user.name) : user.name != null) 
			return false;
		return age != null ? age.equals(user.age) : user.age == null;
	}

	@Override /*Nạp chồng phương thức hashCode */
	public int hashCode() {
		/*
			- Hai đối tượng giống nhau phải có cùng hashCode
			- Hai đối tượng khác nhau thì phải khác hashCode >> Khi đó sử dụng tới equals() để so sánh
		*/
		int result;
		long temp;
		result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (age != null ? age.hashCode() : 0);
		temp = Double.doubleToLongBits(salary);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override /*Nạp chồng phương thức toString*/
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + "]";
	}


}
