package com.example.demo.domain;


import com.example.demo.domain.enumeration.TransferStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss", timezone = "Turkey")
    @NotNull(message = "Please enter the pick up time of the reservation")
    @Column(nullable = false)
    private LocalDateTime pickUpTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss", timezone = "Turkey")
    @NotNull(message = "Please enter the drop off time of the reservation")
    @Column(nullable = false)
    private LocalDateTime dropOffTime;

    @Size(max = 150)
    @NotNull(message = "Please enter the pick up location of the reservation")
    @Column(length = 150, nullable = false)
    private String pickUpLocation;

    @Size(max = 150)
    @NotNull(message = "Please enter the drop off location of the reservation")
    @Column(length = 150, nullable = false)
    private String dropOffLocation;

    @Size(max = 20)
    @NotNull(message = "Please enter the flight number")
    @Column(length = 150, nullable = false)
    private String flightNo;


    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private TransferStatus status;

    @Column(nullable = false)
    private Double totalPrice;

}
