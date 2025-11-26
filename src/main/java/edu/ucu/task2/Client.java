package edu.ucu.task2;

import edu.ucu.Gender;
import lombok.Builder;
import lombok.Getter;


@Getter
public class Client {
    private final int id;
    private static int count = 0;
    private final String name;
    private final int age;
    private final Gender sex;
    
    @Builder
    public Client(String name, int age, Gender sex){
        this.id = count++;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    
}
