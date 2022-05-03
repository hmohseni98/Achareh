package model;

import model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Service extends BaseEntity<Integer> {
    @Column(unique = true , columnDefinition = "varchar(100)")
    private String name;
    @Column(columnDefinition = "varchar(1000)")
    private String description;
    @Column(columnDefinition = "int")
    private Integer basePrice;
    @ManyToOne
    @JoinColumn(name = "category_id" , columnDefinition = "int")
    private Category category;
}
