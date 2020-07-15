package tacos.data;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Required;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//import tacos.Order;
//
//import java.util.Date;
//import java.util.Map;
@Deprecated
public class JdbcOrderRepository {

}
//@Repository
//public class JdbcOrderRepository implements OrderRepository {
//
//    private static long singletonId = 1;
//
//    private ObjectMapper objectMapper;
//    private JdbcTemplate jdbcTemplate;
//    private SimpleJdbcInsert orderTacoInserter;
//
//
//    public JdbcOrderRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//
//        orderTacoInserter = new SimpleJdbcInsert(jdbcTemplate)
//                .withTableName("taco_order_tacos");
//
//        objectMapper = new ObjectMapper();
//    }
//
//    @Override
//    public Order save(Order order) {
//        order.setPlacedAt(new Date());
//        order.setId(singletonId);
//        saveOrderDetail(order);
//        return null;
//    }
//
//    private void saveOrderDetail(Order order) {
//        jdbcTemplate.update(
//                "insert into order "
//        );
//    }
//}
