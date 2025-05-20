package com.db.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.catalina.LifecycleState;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper=false) // need to use when using inheritance
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Author_Tbl", schema = "public")
@SuperBuilder
public class Author extends BaseEntity {

//    @Id
//    @GeneratedValue
//            (
//            strategy = GenerationType.TABLE,
//            generator = "author_id_gen"
//    )
//    @TableGenerator(
//            name = "author_id_gen",
//            table = "id_generator",
//            pkColumnName = "id_name",
//            valueColumnName = "id_value",
//            allocationSize = 1
//    )
//    @SequenceGenerator(
//            name = "author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize = 1
//    )
//    private Integer id;

    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;

    // for mappedby we pass the name of attribute in the linked class which is "authors" in the Author class
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;





//    @Column(
//            updatable = false,
//            nullable = false
//    )
//    private LocalDateTime createdAt;
//    @Column(
//            insertable = false
//    )
//    private LocalDateTime lastModified;

}
