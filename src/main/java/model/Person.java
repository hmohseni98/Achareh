package model;

import lombok.*;
import model.base.BaseEntity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @Column(name = "register_date")
    private Date registerData;
    @Column(name = "register_time")
    private Time registerTime;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
