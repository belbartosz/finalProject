package SDA.FinalProject.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Ports")
@Data
public class Port {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(min = 2, max = 20, message = "Port name should have min 2 & max 20 signs")
    private String name;

}
