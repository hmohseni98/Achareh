package model;

import lombok.experimental.SuperBuilder;
import model.base.BaseEntity;
import model.enumration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
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
    @JoinColumn(name = "accept_offer_id")
    private Offer acceptOrder;
    @Column(columnDefinition = "varchar(250)")
    private String description;
    @Column(name = "suggestion_price", columnDefinition = "int")
    private Integer suggestionPrice;
    @CreationTimestamp
    @Column(name = "submit_date_time")
    private LocalDateTime submitDateTime;
    @CreationTimestamp
    @Column(name = "work_date_time")
    private LocalDateTime workDateTime;
    @Column(name = "address", columnDefinition = "varchar(250)")
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return Objects.equals(customer, order.customer) && Objects.equals(service, order.service) && Objects.equals(acceptOrder, order.acceptOrder) && Objects.equals(description, order.description) && Objects.equals(suggestionPrice, order.suggestionPrice) && Objects.equals(submitDateTime, order.submitDateTime) && Objects.equals(workDateTime, order.workDateTime) && Objects.equals(address, order.address) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customer, service, acceptOrder, description, suggestionPrice, submitDateTime, workDateTime, address, status);
    }
}
