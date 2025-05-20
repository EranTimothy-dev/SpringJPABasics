package com.db.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper=true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Resource extends BaseEntity{

//    @Id
//    @GeneratedValue
//    private Integer id;
    private String name;
    private String url;
    private int size;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
