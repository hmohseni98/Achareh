package model;

import model.base.BaseEntity;
import model.enumration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "orders")
public class Order extends BaseEntity<Integer> {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
    @ManyToOne
    @JoinColumn(name = "accept_expert_id")
    private Expert acceptExpert;
    @Column(columnDefinition = "varchar(250)")
    private String description;
    @Column(name = "suggestion_price", columnDefinition = "int")
    private Integer suggestionPrice;
    @Column(name = "submit_date")
    private LocalDate submitDate;
    @Column(name = "submit_time")
    private LocalTime submitTime;
    @Column(name = "work_date")
    private LocalDate workDate;
    @Column(name = "work_time")
    private LocalTime workTime;
    @Column(name = "address", columnDefinition = "varchar(250)")
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

}
