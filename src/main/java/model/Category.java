package model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import model.base.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Category extends BaseEntity<Integer> {
    @Column(columnDefinition = "varchar(50)")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category1 = (Category) o;
        return Objects.equals(name, category1.name) && Objects.equals(category, category1.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, category);
    }
}
