package org.jsp.crud_demo.repository;

import java.util.List;

import org.jsp.crud_demo.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);

	List<Student> findByMobile(long mobile);

	List<Student> findByGender(String gender);

	List<Student> findByMathsGreaterThanAndScienceGreaterThanAndEnglishGreaterThan(int marks, int marks2, int marks3);

}
