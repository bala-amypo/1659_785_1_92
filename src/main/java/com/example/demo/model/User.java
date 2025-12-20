package com.example.demo.model;


@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    public User(Long id,String name, String email,String password, String role, String createdAt){
           
        this.id=id;
       
        this.name=name;
        this.email=email;
        this.password=password;
        this.role=role;
        this.createdAt=createdAt;
    }

   
}





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
public class Validationentity{

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;
        @NotNull
        @Size(min= 2,max = 10, message="must be 2 to 10 character")
        private String name;
        @Email(message="Email is not valid")
        private String email;
        @Size(min= 2,max = 10, message="must be 2 to 10 character")
        @NotNull(message=" Password is mandatory")
        private String password;
        @Max(30)
        @Positive(message="Age  must be positive")
        private int age;
         


        



}