package api.proyect.manager.models.subscription;

import api.proyect.manager.models.enums.Status;
import api.proyect.manager.models.enums.SubscriptionType;
import api.proyect.manager.models.payment.Payment;
import api.proyect.manager.models.user.User;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private SubscriptionType type;

    private Date startDate;
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "subscription")
    private List<Payment> payments;
}