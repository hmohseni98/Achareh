package model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import model.base.BaseEntity;
import net.bytebuddy.implementation.bind.annotation.Super;
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
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@ToString
@Entity
public class Service extends BaseEntity<Integer> {
    @Column(unique = true, columnDefinition = "varchar(100)")
    private String name;
    @Column(columnDefinition = "varchar(1000)")
    private String description;
    @Column(name = "base_price", columnDefinition = "int")
    private Integer basePrice;
    @ManyToOne
    @JoinColumn(name = "category_id", columnDefinition = "int")
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(name, service.name) && Objects.equals(description, service.description) && Objects.equals(basePrice, service.basePrice) && Objects.equals(category, service.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, basePrice, category);
    }
}
