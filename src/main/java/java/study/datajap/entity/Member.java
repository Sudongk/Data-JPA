package java.study.datajap.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private Integer age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public Member(String username, Integer age, Team team) {
        this(username, age);
        this.team = team;
    }

    public Member(String username) {
        this(username, null);
    }

    public void changeTeam(Team team) {
        if (this.team != null) {
            this.team.getMembers().remove(this);
        }
        team.getMembers().add(this);
        this.team = team;
    }

}
