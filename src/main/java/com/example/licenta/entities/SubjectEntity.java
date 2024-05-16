package com.example.licenta.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subject_entity", schema = "lucrare_lic")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String professor;
    private String description;
    private int availableSeats;

    public SubjectEntity(String title, String professor, String description, int availableSeats) {
        this.title = title;
        this.professor = professor;
        this.description = description;
        this.availableSeats = availableSeats;
    }
}
