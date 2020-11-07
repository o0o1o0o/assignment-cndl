package com.candelalab.assignment.spring.r2dbcpostgresqlexample;

import static org.springframework.test.context.support.TestPropertySourceUtils.addInlinedPropertiesToEnvironment;

import com.candelalab.assignment.r2dbcpostgresqlexample.domain.Course;
import com.candelalab.assignment.spring.r2dbcpostgresqlexample.R2dbcPostgresqlExampleApplicationTests.TestEnvInitializer;
import com.candelalab.assignment.spring.r2dbcpostgresqlexample.service.CourseService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import reactor.core.publisher.Hooks;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(initializers = TestEnvInitializer.class)
@Testcontainers
public class R2dbcPostgresqlExampleApplicationTests {

	@Autowired
	private CourseService courseService;

	@Container
	public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer();

	@BeforeEach
	public void before() {
		Hooks.onOperatorDebug();
		Course course = new Course(1, "title","slug","author_id","category");
		courseService.createCourse(course);
	}
	@Test
	public void getCourses() {
		courseService.getCourses().as(StepVerifier::create)
				.thenConsumeWhile(course -> course.getTitle().equals("title"))
				.verifyComplete();
	}


	public static class TestEnvInitializer implements
			ApplicationContextInitializer<ConfigurableApplicationContext> {

		@Override
		public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
			addInlinedPropertiesToEnvironment(configurableApplicationContext, "datasource.host=localhost");
			addInlinedPropertiesToEnvironment(configurableApplicationContext, "datasource.username=" + postgreSQLContainer.getUsername());
			addInlinedPropertiesToEnvironment(configurableApplicationContext, "datasource.password=" + postgreSQLContainer.getPassword());
			addInlinedPropertiesToEnvironment(configurableApplicationContext, "datasource.database=" + postgreSQLContainer.getDatabaseName());
			addInlinedPropertiesToEnvironment(configurableApplicationContext, "datasource.port=" + postgreSQLContainer.getFirstMappedPort());

		}
	}

}
