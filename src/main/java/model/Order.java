package model;

import model.base.BaseEntity;
import model.enumration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order extends BaseEntity<Integer> {
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
    @Column(columnDefinition = "varchar(250)")
    private String description;
    @Column(columnDefinition = "int")
    private Integer ProposedPrice;
    @Column(name = "submit_date")
    private Date submitDate;
    @Column(name = "submit_time")
    private Time submitTime;
    @Column(name = "work_date")
    private Date workDate;
    @Column(name = "work_time")
    private Time workTime;
    @Column(name = "address" , columnDefinition = "varchar(250)")
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

}