package com.db.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper=true)
public class Course extends BaseEntity{

//    @Id
//    @GeneratedValue
//    private Integer id;
    private String name;
    private String description;

    // we want the course to be the owner of the relationship
    @ManyToMany
    // create the jointable from the owner side of the relationship
    @JoinTable(
            name = "authors_courses",
            joinColumns = {
                    // name will hold the name of th PK of the owner
                    @JoinColumn(name = "course_id")
            },
            // the PK column of the other table in the relationship
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;

    @OneToMany(mappedBy = "course") // pass the attribute name of the entity that matches the related column
    private List<Section> sections;
}
