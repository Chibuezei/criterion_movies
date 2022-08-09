package com.project.criterion;

import com.project.criterion.business.Movie;
import com.project.criterion.persistence.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CriterionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CriterionApplication.class, args);
    }

    @Component
    public class Runner implements CommandLineRunner {

        private MovieRepository repository;

        public Runner(MovieRepository repository) {
            this.repository = repository;
        }

        @Override
        public void run(String... args) {
            System.out.println("Before save:");
            Movie movie = new Movie();

            repository.save(new Movie(1L, "hello", 2, "2020", 50, true, "nice")
            );
            System.out.println("Saving...");
        }
    }


}

