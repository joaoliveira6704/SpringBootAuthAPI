package com.joaooliveira.crudProject.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

//Imports
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="users")
@Entity

public class User {
    // Auto Generate ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //Create Columns
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "name")
    private String name;
}
