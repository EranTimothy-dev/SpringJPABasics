package com.db.repositories;

import com.db.models.Author;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author, Integer>, JpaSpecificationExecutor<Author> {


    @EntityGraph(attributePaths = "courses") // eagerly load courses
    List<Author> findAll(Specification<Author> spec);

    // select * from author where first_name = firstName
    List<Author> findAllByFirstName(String firstName);
    // when we want to ignore the case of the string passed
    List<Author> findAllByFirstNameIgnoreCase(String firstName);
    // select * from author where first_name like '%al%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String lastName);
    // select * from author where first_name like 'al%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String lastName);
    // select * from author where first_name like '%al'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String lastName);
    // select * from author where first_name in ('ali', 'bou', 'coding')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

    @Modifying // to let JPA know that this is an update query
    @Transactional // to make the query transactional, handled in the current session
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    @Modifying // to let JPA know that this is an update query
    @Transactional // to make the query transactional, handled in the current session
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAges(int age);

    // using named query listed at the entity level
    List<Author> findByNameQuery(@Param("age") int age);
}
