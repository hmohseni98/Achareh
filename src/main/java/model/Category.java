package model;

import lombok.*;
import model.base.BaseEntity;
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
public class Category extends BaseEntity<Integer> {
    @Column(columnDefinition = "varchar(50)")
    private String name;
    @ManyToOne
    @JoinColumn(nullable = true , name = "category_id")
    private Category category;

    public Category(String name) {
        this.name = name;
    }
}
