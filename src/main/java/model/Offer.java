package model;

import model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @Column(name = "submit_date")
    private LocalDate submitDate;
    @Column(name = "submit_time")
    private LocalTime submitTime;
    @Column(name = "suggestion_price")
    private Integer suggestionPrice;
    @Column(name = "duration_of_work")
    private Integer durationOfWork;        // check
    @Column(name = "start_work_time")   // check beshe ke time va date mikhad ya na.
    private LocalTime startWorkTime;

}
