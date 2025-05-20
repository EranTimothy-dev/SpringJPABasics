package com.db;

import com.db.models.Author;
import com.db.models.Video;
import com.db.models.specifications.AuthorSpecification;
import com.db.repositories.AuthorRepo;
import com.db.repositories.VideoRepo;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
    }

    // method to test repository layer, which will run at application start
    @Bean
    @Transactional
    public CommandLineRunner commandLineRunner(AuthorRepo repo, VideoRepo videoRepo){
        // use lambda expression to test repo
        return args -> {
//            Faker faker = new Faker();
//            for (int i = 0; i < 10; i++) {
//                var author = Author.builder()
//                        .firstName(faker.name().firstName())
//                        .lastName(faker.name().lastName())
//                        .age(faker.number().numberBetween(16,50))
//                        .email(faker.internet().emailAddress())
//                        .createdAt(LocalDateTime.now())
//                        .createdBy(faker.name().name())
//                        .build();
//                repo.save(author);
//            }
//            repo.updateAllAuthorsAges(35);

//            var video = Video.builder()
//                    .name("Abc")
//                    .length(5)
//                    .build();
//
//            videoRepo.save(video);

            Specification<Author> spec = Specification
                    .where(AuthorSpecification.hasAge(34))
                    .or(AuthorSpecification.firstNameContains("an"));

            List<Author> authors = repo.findAll(spec);
            for (Author author : authors) {
                System.out.println(author.toString());
            }
        };
    }

}
