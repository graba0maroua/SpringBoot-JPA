package com.gb.springdatajpatutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tnl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "email_address_unique",
                columnNames = "email_address"
        )
)

/*When we annotate an entity class with @Entity, JPA uses the class name as the default name for the table. However,
 if the actual table name is different from the entity class name, we can use the @Table annotation to specify the correct name of the table.
 */
public class Student {
    @Column(name="id")
    @Id //this annotation shows that the studentId is the primary key
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long studentId ;
    @Column(name="first_name")
    private  String firstName;
    @Column(name="last_name")
    private String lastName ;
    @Column(name="email_address",
            nullable = false
    )
    private String guardianEmail ;
    @Column(name="name")
    private String guardianName ;
    @Column(name="mobile_number")
    private String guardianMobile ;
}
