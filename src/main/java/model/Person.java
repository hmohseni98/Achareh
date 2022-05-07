package model;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import model.base.BaseEntity;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@MappedSuperclass
public abstract class Person extends BaseEntity<Integer> {
    @Column(name = "first_name", columnDefinition = "varchar(30)")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "varchar(50)")
    private String lastName;
    @Column(name = "email", unique = true, columnDefinition = "varchar(50)")
    private String email;
    @Column(name = "password", columnDefinition = "varchar(12)")
    private String password;
    @CreationTimestamp
    @Column(name = "register_date_time")
    private LocalDateTime registerDataTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email) && Objects.equals(password, person.password) && Objects.equals(registerDataTime, person.registerDataTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, email, password, registerDataTime);
    }
}
