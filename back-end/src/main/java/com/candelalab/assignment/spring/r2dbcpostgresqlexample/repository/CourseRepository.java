package com.candelalab.assignment.spring.r2dbcpostgresqlexample.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.candelalab.assignment.r2dbcpostgresqlexample.domain.Course;

public interface CourseRepository extends ReactiveCrudRepository<Course, Integer> {

}
