package com.hf.springbootfund.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,unique = true)
    private Integer id;
    @Column(columnDefinition = "varchar(100)")
    private String FirstName;
    @Column(columnDefinition = "varchar(100)")
    private String LastName;
    @Column(columnDefinition = "varchar(255)")
    private String Email;

}
