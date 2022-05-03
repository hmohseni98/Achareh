package model;

import model.enumration.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Expert extends Person {
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private String image;
    @ManyToMany
    @JoinTable(
            name = "expert_service",
            joinColumns = { @JoinColumn(name = "expert_id") },
            inverseJoinColumns = { @JoinColumn(name = "service_id") }
    )
    private Set<Service> services;
    @Column(name = "balance" , columnDefinition = "int")
    private Integer balance;

}
