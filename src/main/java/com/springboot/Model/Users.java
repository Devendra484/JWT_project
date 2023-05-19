package com.springboot.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "villageMart_Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user"
    )
    @SequenceGenerator(
            name = "user",
            sequenceName = "user_seq",
            allocationSize = 1,
            initialValue = 1
    )
    private  Long id;
    private String userName;
    private  Long phnNumber;
    private  String password;

    @CreationTimestamp
    private LocalDateTime     createdDate;

    @UpdateTimestamp
    private  LocalDateTime updatedDate;
    public boolean isValidPassword(String password) {
        return this.password.equals(password);
    }
}
