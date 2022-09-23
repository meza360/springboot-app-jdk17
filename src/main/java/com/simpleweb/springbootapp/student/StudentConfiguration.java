package com.simpleweb.springbootapp.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfiguration {

        @Bean
        CommandLineRunner commandLineRunner(StudentRepository repository) {
                return args -> {
                        Student Gio = new Student(
                                        1L,
                                        "Giovani",
                                        "gio@test.com",
                                        LocalDate.of(1999, 3, 3));

                        Student Mariam = new Student(
                                        2L,
                                        "Mariam",
                                        "mariam@test.com",
                                        LocalDate.of(2005, 12, 2));

                        Student Bobby = new Student(
                                        3L,
                                        "Bobby",
                                        "bobby@test.com",
                                        LocalDate.of(2003, 1, 20));
                        repository.saveAll(
                                        List.of(Gio, Mariam, Bobby));
                };
        }
}
