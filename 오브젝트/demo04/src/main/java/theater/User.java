package theater;

public class User {
    private Money money;

    public void calculateFee(Money fee) {
        money = money.minus(fee);
    }
}
