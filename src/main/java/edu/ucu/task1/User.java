package edu.ucu.task1;

import edu.ucu.Gender;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String name;
    private int age;
    private Gender gender;
    private double weight;
    private double height;
}