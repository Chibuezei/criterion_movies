# CRITERION_MOVIES
![Alt text](https://github.com/Chibuezei/criterion_movies/blob/main/moviedb.jpg?raw=true "Database design")

Spring MVC Movie editing website  using Spring Boot, Spring MVC, Spring Security, JPA, and MySQL as a database.
The Service also provides RESTful endpoints.


## Tools and Technologies Used

Spring Boot - 2.7.2.RELEASE
FreeMaker template engine
Gradle 
Spring Data JPA 
MYSQL - 8
Spring Security


## Endpoints

```java
   @PostMapping("/api/movie/new")
   //Post new movie

    @GetMapping("/api/movie")
    //filters by movie title

    @GetMapping("/api/movie/search")
//Filters movie by search parameters

    @GetMapping("/api/movie/latest")
	//lastest 20


    @GetMapping("/api/genre")
    // all genre

    @GetMapping("/api/actor")
   //filters actor by name

```

## Contributing
Pull requests are welcome. 

## License
None