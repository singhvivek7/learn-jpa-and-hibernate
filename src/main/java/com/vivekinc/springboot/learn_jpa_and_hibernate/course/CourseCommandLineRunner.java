package com.vivekinc.springboot.learn_jpa_and_hibernate.course;

import com.vivekinc.springboot.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.vivekinc.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.vivekinc.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Java Course 1", "Vivek 1"));
        repository.save(new Course(2, "Java Course 2", "Vivek 2"));
        repository.save(new Course(3, "Java Course 3", "Vivek 3"));
        repository.save(new Course(4, "Java Course 4", "Vivek 4"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));
        System.out.println(repository.findAll());
        System.out.println("Count: " + repository.count());
        System.out.println(repository.findByAuthor("Vivek 2"));
        System.out.println(repository.findByAuthor("Vivek"));
        System.out.println(repository.findByName("Java Course 3"));
        System.out.println(repository.findByName("Java Course 11"));

    }
}
