package org.jsp.crud_demo.repository;

import org.jsp.crud_demo.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
