package ua.com.univerpulse.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Danny Briskin (DBriskin@qaconsultants.com)
 * for ForTests project.
 */

@Entity
@Table(name = "Payments")
@Component
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer identification;

    @Column(name = "PAYMENTDATE", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "PAYMENTAMOUNT")
    private Double paymentAmount;

    @Column(name = "CHANNEL")
    private String channel;

    @ManyToOne
    @JoinColumn(name = "CUSTOMERID")
    private Customer customer;

    @Override
    public String toString() {
        return "\n Payment{" +
                "identification=" + identification +
                ", paymentDate=" + paymentDate +
                ", paymentAmount=" + paymentAmount +
                ", channel='" + channel;
    }
}



