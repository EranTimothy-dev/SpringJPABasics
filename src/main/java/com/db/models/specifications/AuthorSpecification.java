package com.db.models.specifications;

import com.db.models.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;



// can be used to pass query statements programmatically instead of writing queries
public class AuthorSpecification {

    public static Specification<Author> hasAge(int age) {
        return (Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if (age < 0) {
                return null;
            }
            return builder.equal(root.get("age"), age); // value passed top get should be identical to the entity attribute name
        };
    }

    public static Specification<Author> firstNameContains(String firstname) {
         return (Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
             if (firstname == null) {
                 return null;
             }
             return builder.like(root.get("firstName"), "%" + firstname + "%");
         };
    }
}
