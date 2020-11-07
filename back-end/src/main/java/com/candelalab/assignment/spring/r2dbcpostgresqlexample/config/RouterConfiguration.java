package com.candelalab.assignment.spring.r2dbcpostgresqlexample.config;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.candelalab.assignment.spring.r2dbcpostgresqlexample.api.CourseHandler;
//import com.candelalab.assignment.spring.r2dbcpostgresqlexample.api.UserHandler;

@Configuration
@EnableWebFlux
public class RouterConfiguration {

//  @Bean
//  //@CrossOrigin
//  public RouterFunction<ServerResponse> userRouterFunction(UserHandler userHandler) {
//    return route()
//        .POST("/users", userHandler::createUser)
//        .GET("/users", userHandler::getUsers)
//        .GET("/users/{id}", userHandler::getUser)
//        .build();
//  }

  
  @Bean
 // @CrossOrigin
  public RouterFunction<ServerResponse> courseRouterFunction(CourseHandler courseHandler) {
       System.out.println("Router called"); 
    return route()
        .POST("/course", courseHandler::createCourse)
        .GET("/course", courseHandler::getCourses)
        .GET("/course/{id}", courseHandler::getCourse)
        .build();
  }
}
