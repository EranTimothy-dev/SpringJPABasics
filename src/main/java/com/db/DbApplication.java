package com.db;

import com.db.models.Author;
import com.db.repositories.AuthorRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
    }

    // method to test repository layer, which will run at application start
    @Bean
    public CommandLineRunner commandLineRunner(AuthorRepo repo){
        // use lambda expression to test repo
        return args -> {
            var author = Author.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .age(34)
                    .email("john@doe.com")
                    .build();

            repo.save(author);
        };
    }

}
