package SDA.FinalProject.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(min = 2, max = 20, message = "Customer name should have min 2 & max 20 signs")
    private String name;

    @Column
    @Size(min = 8, max = 20, message = "Customer password should have min 8 & max 20 signs")
    private String password;

}
