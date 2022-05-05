package model;

import lombok.*;
import model.enumration.AccountStatus;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class Expert extends Person {
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private byte[] image;
    @ManyToMany
    @JoinTable(
            name = "expert_service",
            joinColumns = { @JoinColumn(name = "expert_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") }
    )
    private Set<Service> services;
    @Column(name = "balance" , columnDefinition = "int")
    private Integer balance;

    public Expert(String firstName, String lastName, String email, String password, Date registerData, Time registerTime, AccountStatus status, byte[] image, Set<Service> services, Integer balance) {
        super(firstName, lastName, email, password, registerData, registerTime);
        this.status = status;
        this.image = image;
        this.services = services;
        this.balance = balance;
    }
}
