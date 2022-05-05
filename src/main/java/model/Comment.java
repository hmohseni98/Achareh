package model;

import model.base.BaseEntity;
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
@Table( name = "comment",
        uniqueConstraints = { @UniqueConstraint( columnNames = { "customer_id", "order_id" } ) } )
@Entity
public class Comment extends BaseEntity<Integer> {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "expert_id")
    private Expert expert;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "score" , columnDefinition = "int")
    private Integer score;
    @Column(name = "description" , columnDefinition = "varchar(255)")
    private String description;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "time")
    private LocalTime time;

}
