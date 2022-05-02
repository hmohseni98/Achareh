package entity;

import entity.base.BaseEntity;
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
public class Category extends BaseEntity<Integer> {
    @Column(columnDefinition = "varchar(50)")
    private String name;
    @ManyToOne
    @JoinColumn(nullable = true , name = "category_id")
    private Category category;
}
