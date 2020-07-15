package tacos.data;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import tacos.Ingredient;
//import tacos.IngredientType;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
@Deprecated
public class JdbcIngredientRepository {

}
//@Repository
//public class JdbcIngredientRepository implements IngredientRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public Iterable<Ingredient> findAll() {
//        return jdbcTemplate.query("select id, name, ingredientType from Ingredient", this::mapRowToIngredient);
//    }
//
//    @Override
//    public Ingredient findById(String id) {
//        return jdbcTemplate.queryForObject("select id, name, ingredientType from Ingredient where id=?", this::mapRowToIngredient, id);
//    }
//
//    @Override
//    public Ingredient save(Ingredient ingredient) {
//        jdbcTemplate.update(
//                "insert into ingredient (id, name, ingredientType) values (?, ?, ?)",
//                ingredient.getId(),
//                ingredient.getName(),
//                ingredient.getIngredientType().toString()
//        );
//
//        return ingredient;
//    }
//
//    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
//        return new Ingredient(
//                rs.getString("id"),
//                rs.getString("name"),
//                IngredientType.valueOf(rs.getString("ingredientType"))
//        );
//    }
//}
