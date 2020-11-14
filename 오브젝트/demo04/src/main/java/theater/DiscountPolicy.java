package theater;

public interface DiscountPolicy {
    public Money calculateDiscountAmount(Screening screening);
}
