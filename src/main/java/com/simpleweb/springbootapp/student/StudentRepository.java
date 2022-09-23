package com.simpleweb.springbootapp.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // @Query("SELECT s FROM Student WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

}
