package com.example.demo.model;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min= 2,max = 10, message="must be 2 to 10 character")
    private String name;
    @Email(message="Email is not valid")
    private String email;
    @Size(min= 2,max = 10, message="must be 2 to 10 character")
    @NotNull(message=" Password is mandatory")
    private String password;
    private String role;
    private LocalDateTime createdAt;

    
   
}











       
         


        



