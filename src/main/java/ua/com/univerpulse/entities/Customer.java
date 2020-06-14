package ua.com.univerpulse.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */
@Entity
@Table(name = "Customers")
@Component
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer identification;
    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "customer")
    List<Payment> payments = new ArrayList<>();

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "BILLINGADDRESS")
    private String billingAddress;

    @Column(name = "CUSTOMERBALANCE")
    private Double customerBalance;

    @Column(name = "CUSTOMERACTIVATED", nullable = false)
    private LocalDateTime customerActivited;

    @Column(name = "CUSTOMERDEACTIVATED")
    private LocalDateTime customerDeactivited;
}


