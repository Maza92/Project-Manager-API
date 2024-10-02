package api.proyect.manager.models.payment;

import api.proyect.manager.models.enums.PaymentMethod;
import api.proyect.manager.models.enums.Status;
import api.proyect.manager.models.subscription.Subscription;
import api.proyect.manager.models.user.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal amount;
    private Date date;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
}