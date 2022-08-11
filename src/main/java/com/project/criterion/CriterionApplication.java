package com.project.criterion;

import com.project.criterion.business.*;
import com.project.criterion.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
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

        @Autowired
        private ActorRepository actorRepository;
        @Autowired
        private CastRepository castRepository;
        @Autowired
        private InternalRepository internalRepository;
        @Autowired
        private RatingRepository ratingRepository;
        private MovieRepository repository;

        public Runner(MovieRepository repository) {
            this.repository = repository;
        }

        @Override
        public void run(String... args) {
            System.out.println("Before save:");
//            Movie movie =repository.save(new Movie("hello", 3, "2020", 50, true, "nice")
//            );
//            Actor actor = new Actor("hello", "hi", "pls");
////            Genre genre = new Genre(1, "musical");
//            Cast cast = new Cast(movie.getMId(), 2, 3, 4);
//            Internal internal = new Internal(movie.getMId(), 3);
//            Rating rating = new Rating(movie.getMId(), 2, 3, 4);
//            ratingRepository.save(rating);
//            internalRepository.save(internal);
//            castRepository.save(cast);
//
////            actorRepository.save(actor);
//
//
//            System.out.println(movie.getMId());
            System.out.println("Saving...");
        }
    }


}

