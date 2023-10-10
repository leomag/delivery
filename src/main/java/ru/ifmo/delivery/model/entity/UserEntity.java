package ru.ifmo.delivery.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public UserEntity(String username, String email) {
        this.username = username;
        this.email = email;
    }

    private String username;
    private String email;

}
