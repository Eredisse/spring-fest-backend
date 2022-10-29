package com.dev.springfestbackend.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fest_performances")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "singer_id", referencedColumnName = "id")
    private Singer singer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stage_id", referencedColumnName = "id")
    private Stage stage;

    private LocalDateTime startTime;

    private LocalDateTime endTime;


}
