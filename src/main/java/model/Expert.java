package model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import model.enumration.AccountStatus;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
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
    @Column(name = "balance" , columnDefinition = "int default 0")
    private Integer balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Expert expert = (Expert) o;
        return status == expert.status && Arrays.equals(image, expert.image) && Objects.equals(services, expert.services) && Objects.equals(balance, expert.balance);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), status, services, balance);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
