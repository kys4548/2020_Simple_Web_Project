package hellojpa;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


//@Table(name = "Account")
@Entity
@SequenceGenerator(name ="member_seq_generator", sequenceName = "member_seq")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;

    @Column(unique = true, length = 10)
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifieDate;

    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    @Lob
    private String description;

    public Member() {

    }
}
