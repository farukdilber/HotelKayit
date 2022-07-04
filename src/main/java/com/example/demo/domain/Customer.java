package com.example.demo.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;



    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "customers")
    public class Customer {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @OneToMany(mappedBy = "customer")
        private Set<Transfer> transferRequests;

        @Size(max= 15)
        @NotNull(message = "Please enter your first name")
        @Column(nullable = false, length = 15)
        private String firstName;

        @Size(max= 15)
        @NotNull(message = "Please enter your first name")
        @Column(nullable = false, length = 15)
        private String lastName;


        @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
                message = "Please enter valid phone number")
        @Size(min = 14 , max = 14,message = "Please enter validate number")
        @NotNull(message = "Please enter your phone number")
        @Column(nullable = false, length = 14)
        private String phoneNumber;

    }
