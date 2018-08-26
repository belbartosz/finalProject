package SDA.FinalProject.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Carriers")
@Data
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(min = 2, max = 20, message = "Carrier name should have min 2 & max 20 signs")
    private String name;

    @Column(unique = true)
    @Size(min = 5, max = 12)
    private String password;
}
