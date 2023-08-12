package com.learning.socialmediaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq" )
    @Schema(name = "id", example = "1", required = true)
    int id;
    @Schema(name = "name", example = "adam", required = true)
    @Size(min=2, message = "name should be atleast 2 charecters")
    String name;

    @Schema(name = "birthDate", example = "2023-08-09", required = true)
    @PastOrPresent(message = "birthDate should be a present or past date")
    @NotNull
    LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Post> posts;
}


