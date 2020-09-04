package com.example.cfdatademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.stream.Stream;


@SpringBootApplication
public class CfDataDemoApplication implements CommandLineRunner {

    private final CatRepository catRepository;

    @Autowired
    public CfDataDemoApplication(CatRepository catRepository) {
        this.catRepository = catRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(CfDataDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Stream.of("Felix","Garfield","Tuppins")
                .forEach(name-> catRepository.save(new Cat(name)));

    }
}

@Entity
class Cat{
    @Id
    @GeneratedValue
    private Long Id;
    private String reservationName;

    public Cat() {
    }

    public Cat(String reservationName){
        this.reservationName = reservationName;
    }

    public Long getId() {
        return Id;
    }

    public String getReservationName() {
        return reservationName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "Id=" + Id +
                ", reservationName='" + reservationName + '\'' +
                '}';
    }
}