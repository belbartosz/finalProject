package SDA.FinalProject.model;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Containers")
@Data
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "This field cannot be empty")
    @Enumerated(EnumType.STRING)
    private ContainerStatus containerStatus;

    @Column
    @NotNull(message = "This field cannot be empty")
    @Pattern(regexp = "[a-zA-Z]{4}+[0-9]{7}", message = "Container number should contain 4 letters + 7 digits only")
    private String containerNumber;

    @Column
    @NotNull(message = "This field cannot be empty")
    @Enumerated(EnumType.STRING)
    private ContainerType containerType;

    @ManyToOne
    @JoinColumn
    @NotNull(message = "This field cannot be empty")
    private Carrier carrier;

    @ManyToOne
    @JoinColumn(name = "port_of_loading")
    @NotNull(message = "This field cannot be empty")
    private Port portOfLoading;

    @Column
    @NotNull(message = "This field cannot be empty")
    private LocalDate dateOfLoading;

    @ManyToOne
    @JoinColumn(name = "port_of_discharge")
    @NotNull(message = "This field cannot be empty")
    private Port portOfDischarge;

    @Column
    @NotNull(message = "This field cannot be empty")
    private LocalDate dateOfDischarge;

    @Column
    @Size(max = 20, message = "Max 20 signs for this field")
    private String shipperName_purchaseOrder;

    @Column
    @Size(max = 200, message = "Max 200 signs for this field")
    private String importantNotice;

    @Column
    @Size(max = 200, message = "Max 200 signs for this field")
    private String customerNotice;

    @ManyToMany
    @JoinTable(name = "customers_containers",
    joinColumns = @JoinColumn(name = "container_id"),
    inverseJoinColumns = @JoinColumn(name = "customer_id"))
    @NotNull(message = "This field cannot be empty")
    private List<Customer> customers;

}
