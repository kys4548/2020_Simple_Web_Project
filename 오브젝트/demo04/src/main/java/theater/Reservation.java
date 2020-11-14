package theater;

public class Reservation {
    private User user;
    private Screening screening;
    private Money fee;
    private int userCount;

    public Reservation(User user, Screening screening, Money fee, int userCount) {
        this.user = user;
        this.screening = screening;
        this.fee = fee;
        this.userCount = userCount;
    }
}
