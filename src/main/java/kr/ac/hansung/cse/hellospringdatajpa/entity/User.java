package kr.ac.hansung.cse.hellospringdatajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String role; // 예: ROLE_USER, ROLE_ADMIN

    private String name;
}