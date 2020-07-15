package tacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class RedesignTacoController {

    @GetMapping("/redesign")
    public String showRedesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("wrap", "wrap" ,IngredientType.WRAP));
        ingredients.add(new Ingredient("protein", "protein", IngredientType.PROTEIN));
        ingredients.add(new Ingredient("cheese", "cheese", IngredientType.CHEESE));
        ingredients.add(new Ingredient("sauce", "sauce", IngredientType.SAUCE));
        ingredients.add(new Ingredient("veggies", "veggies", IngredientType.VEGGIES));

        final IngredientType[] ingredientTypes = IngredientType.values();
        for(IngredientType type : ingredientTypes) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("taco", new Taco());

        return "redesign";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, IngredientType type) {
        return ingredients.stream()
                .filter(x -> x.getIngredientType().equals(type))
                .collect(Collectors.toList());
    }
}
