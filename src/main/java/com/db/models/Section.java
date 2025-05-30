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
@EqualsAndHashCode(callSuper = true)
public class Section extends BaseEntity{

//    @Id
//    @GeneratedValue
//    private Integer id;
    private String name;
    private int sectionOrder;

    @ManyToOne
    @JoinColumn(name = "course_id") // enter the name of the foreign key column
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;

}
