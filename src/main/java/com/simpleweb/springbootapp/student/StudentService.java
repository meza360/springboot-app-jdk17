package com.simpleweb.springbootapp.student;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(String.format("Student with id %id doesnt exists", id));
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Student not found"));

        if (name != null && name.length() > 0) {
            student.setName(name);
        }
        if (email != null && email.length() > 0) {
            Optional<Student> _student = studentRepository.findStudentByEmail(email);
            if (_student.isPresent()) {
                throw new IllegalStateException("Email already exists");
            }
            student.setEmail(email);
        }
        //studentRepository.save(student);
    }
}
