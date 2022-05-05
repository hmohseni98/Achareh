package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import java.sql.Date;
import java.sql.Time;


@AllArgsConstructor
@Getter
@Setter
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
public class Admin extends Person {

    public Admin(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }
}
