package com.task.CDQTask.task.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int base;
    private int exponent;
    private Integer result;
    private String status;
    private int progress;

    @Override
    public String toString() {

        if (result == null) {
            return "id: " + id + ", status: " + status + ", progress: " + progress + "%";
        } else {
            return "id: " + id + ", status: " + status + ", progress: " + progress + "%, result: " + result;
        }
    }
}
