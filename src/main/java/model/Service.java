package model;

import model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
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
