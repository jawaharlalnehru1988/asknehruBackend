package com.crud.askenehru.AskNehru;

import com.crud.askenehru.AskNehru.Entities.Laptop;
import com.crud.askenehru.AskNehru.Entities.Student;
import com.crud.askenehru.AskNehru.Repositories.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AskNehruApplication {

	public static void main(String[] args) {
		SpringApplication.run(AskNehruApplication.class, args);
	}

}
