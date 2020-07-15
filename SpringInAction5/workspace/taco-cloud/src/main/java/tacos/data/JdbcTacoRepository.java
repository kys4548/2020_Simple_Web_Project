package tacos.data;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import tacos.Ingredient;
//import tacos.Taco;
//
//import java.sql.PreparedStatement;
//import java.util.Date;
@Deprecated
public class JdbcTacoRepository {

}
//@Repository
//@RequiredArgsConstructor
//public class JdbcTacoRepository implements TacoRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    private static long singletonId = 1;
//
//    @Override
//    public Taco save(Taco taco) {
//        long tacoId = saveTacoInfo(taco);
//        taco.setId(tacoId);
//        for(Ingredient ingredient : taco.getIngredients()) {
//            saveIngredientToTaco(ingredient.getId(), tacoId);
//        }
//        return taco;
//    }
//
//    private void saveIngredientToTaco(String ingredientId, long tacoId) {
//        jdbcTemplate.update(
//          "insert into taco_ingredients (taco, ingredient) values (?, ?)",
//          tacoId, ingredientId
//        );
//    }
//
//
//    private long saveTacoInfo(Taco taco) {
//        taco.setCreateAt(new Date());
//        taco.setId(singletonId);
//        jdbcTemplate.update(
//                "insert into taco (id, name, createAt) values (? ,? ,?)",
//                taco.getId(),
//                taco.getName(),
//                taco.getCreateAt().getTime()
//        );
//
//        return singletonId++;
//    }
//}
