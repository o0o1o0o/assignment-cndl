package com.candelalab.assignment.spring.r2dbcpostgresqlexample.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.server.ServerResponse.status;
import static reactor.core.publisher.Mono.from;

import com.candelalab.assignment.r2dbcpostgresqlexample.domain.Course;
import com.candelalab.assignment.spring.r2dbcpostgresqlexample.service.CourseService;

import javax.jws.soap.SOAPBinding.Use;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CourseHandler {

  private CourseService courseService;

  public CourseHandler(CourseService courseService) {
    this.courseService = courseService;
  }

  public Mono<ServerResponse> createCourse(ServerRequest serverRequest) {
       System.out.println("create Course in Handler");
    return serverRequest.bodyToMono(Course.class)
        .flatMap(c -> status(CREATED)
            .contentType(APPLICATION_JSON)
            .body(courseService.createCourse(c), Course.class));
  }

  public Mono<ServerResponse> getCourses(ServerRequest serverRequest) {
    return ServerResponse.ok()
        .contentType(APPLICATION_JSON)
        .body(courseService.getCourses(), Course.class)
        .switchIfEmpty(ServerResponse.noContent().build());
  }

  public Mono<ServerResponse> getCourse(ServerRequest serverRequest) {
    return from(courseService.getCourse(Integer.valueOf(serverRequest.pathVariable("id"))))
        .flatMap(c -> ok()
            .contentType(APPLICATION_JSON)
            .body(fromObject(c)))
        .switchIfEmpty(notFound().build());
  }

  public Mono<ServerResponse> deleteCourse(ServerRequest serverRequest) {
    return from(courseService.deleteCourse(Integer.valueOf(serverRequest.pathVariable("id"))))
        .flatMap(c -> ok()
            .contentType(APPLICATION_JSON)
            .build());
  }
}
