package model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import model.CommodityType;
import model.PaymentType;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private String id;

    @Column(name = "time", columnDefinition = "TIMESTAMP")
    private LocalDateTime time;

    @ManyToMany
    @JoinTable(
            name = "partner_joined_transaction",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "partner_id")
    )
    private Set<Partner> partners = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "commodity_type")
    private CommodityType commodityType;

    @Column(name = "gross_weight")
    private BigDecimal grossWeight;

    @Column(name = "allowance_weight")
    private BigDecimal allowanceWeight;

    @Column(name = "net_weight")
    private BigDecimal netWeight;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "amount_tobe_paid")
    private BigDecimal amountTobePaid;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "amount_paid")
    private BigDecimal amountPaid;

    @Column(name = "note")
    private String note;

}
