package tacos.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.Ingredient;
import tacos.IngredientType;
import tacos.Order;
import tacos.Taco;
import tacos.data.IngredientRepository;
import tacos.data.TacoRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;
    private final TacoRepository tacoRepository;

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @PostMapping("/design")
    public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order) {
        if(errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: " + design);

        final Taco saved = tacoRepository.save(design);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    @GetMapping("/design")
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
//        ingredients.add(new Ingredient("wrapId1", "wrap1" , IngredientType.WRAP));
//        ingredients.add(new Ingredient("wrapId2", "wrap2" ,IngredientType.WRAP));
//        ingredients.add(new Ingredient("wrapId3", "wrap3" ,IngredientType.WRAP));
//        ingredients.add(new Ingredient("proteinId", "protein1", IngredientType.PROTEIN));
//        ingredients.add(new Ingredient("cheeseId", "cheese1", IngredientType.CHEESE));
//        ingredients.add(new Ingredient("sauceId", "sauce1", IngredientType.SAUCE));
//        ingredients.add(new Ingredient("veggiesId", "veggies1", IngredientType.VEGGIES));

        ingredientRepository.findAll().forEach(i -> ingredients.add(i));

        final IngredientType[] ingredientTypes = IngredientType.values();
        for(IngredientType type : ingredientTypes) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("taco", new Taco());

        return "design";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, IngredientType type) {
        return ingredients.stream()
                .filter(x -> x.getIngredientType().equals(type))
                .collect(Collectors.toList());
    }
}
