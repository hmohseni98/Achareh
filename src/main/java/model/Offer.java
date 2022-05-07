package model;

import lombok.experimental.SuperBuilder;
import model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table( name = "offer",
        uniqueConstraints = { @UniqueConstraint( columnNames = { "expert_id", "order_id" } ) } )
@Entity
public class Offer extends BaseEntity<Integer> {
    @ManyToOne
    @JoinColumn(name = "expert_id")
    private Expert expert;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @CreationTimestamp
    @Column(name = "submit_date_time")
    private LocalDateTime submitDateTime;
    @Column(name = "suggestion_price")
    private Integer suggestionPrice;
    @Column(name = "duration_of_work")
    private Integer durationOfWork;
    @CreationTimestamp
    @Column(name = "start_work_date_time")
    private LocalDateTime startWorkDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Offer offer = (Offer) o;
        return Objects.equals(expert, offer.expert) && Objects.equals(order, offer.order) && Objects.equals(submitDateTime, offer.submitDateTime) && Objects.equals(suggestionPrice, offer.suggestionPrice) && Objects.equals(durationOfWork, offer.durationOfWork) && Objects.equals(startWorkDateTime, offer.startWorkDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expert, order, submitDateTime, suggestionPrice, durationOfWork, startWorkDateTime);
    }
}
