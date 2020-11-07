package com.candelalab.assignment.spring.r2dbcpostgresqlexample.service;

import com.candelalab.assignment.r2dbcpostgresqlexample.domain.Course;
import com.candelalab.assignment.spring.r2dbcpostgresqlexample.repository.CourseRepository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseService {

  private final CourseRepository courseRepository;

  public CourseService(
      CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public Mono<Course> createCourse(Course course) {
    System.out.println("create Course in Service");
    return courseRepository.save(course);
  }

  public Flux<Course> getCourses() {
    return courseRepository.findAll();
  }

  public Mono<Course> getCourse(Integer id) {
    return courseRepository.findById(id);
  }

  public Mono<Void> deleteCourse(Integer id) {
    return courseRepository.deleteById(id);
  }
}
