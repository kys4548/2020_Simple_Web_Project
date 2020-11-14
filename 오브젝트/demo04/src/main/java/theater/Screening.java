package theater;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(User user, int userCount) {
        //요금 계산
        Money fee = calculateFee(userCount);

        //결제
        user.calculateFee(fee);

        //표 구입
        return new Reservation(user, this, fee, userCount);
    }

    private Money calculateFee(int userCount) {
        return movie.calculateFee(this).times(userCount);
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }
}
