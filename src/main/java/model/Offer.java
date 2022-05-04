package model;

import model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Offer extends BaseEntity<Integer> {
    @ManyToOne
    @JoinColumn(name = "expert_id")
    private Expert expert;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "submit_date")
    private Date submitDate;
    @Column(name = "submit_time")
    private Time submitTime;
    @Column(name = "suggestion_price")
    private Integer suggestionPrice;
    @Column(name = "duration_of_work")
    private Float durationOfWork;
    @Column(name = "start_work_time")   // check beshe ke time va date mikhad ya na.
    private Time startWorkTime;

}
