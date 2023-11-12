package com.karley.courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal CoursesApplication
 */
@SpringBootApplication
public class CoursesApplication {

	/**
	 * Método principal del micro servicio de cursos
	 *
	 * @param args string array
	 */
	public static void main(String[] args) {
		SpringApplication.run(CoursesApplication.class, args);
	}

}
