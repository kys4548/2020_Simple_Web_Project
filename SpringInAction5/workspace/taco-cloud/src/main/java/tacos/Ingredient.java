package tacos;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Ingredient {

    @Id
    private String id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private IngredientType ingredientType;
}
