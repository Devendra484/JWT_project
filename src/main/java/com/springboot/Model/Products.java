package com.springboot.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "villageMart_Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String productName;
    private  Double price;
    private  Long quantity;
    private  String measuringUnits;
    private  String Description;
    private  Boolean isPresent;
}
