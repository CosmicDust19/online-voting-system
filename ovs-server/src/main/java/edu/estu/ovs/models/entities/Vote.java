package edu.estu.ovs.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vote", uniqueConstraints = @UniqueConstraint(columnNames = {"voter_id", "election_id"}, name = "uk_vote_voter_id_election_id"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id", nullable = false, columnDefinition = "integer")
    private Integer voteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voter_id", nullable = false, columnDefinition = "integer", foreignKey = @ForeignKey(name = "fk_vote_voter_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Voter voter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "election_id", nullable = false, columnDefinition = "integer", foreignKey = @ForeignKey(name = "fk_vote_election_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"attenders", "executives"})
    private Election election;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false, columnDefinition = "integer", foreignKey = @ForeignKey(name = "fk_vote_candidate_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"certs", "schools"})
    private Candidate candidate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "vote_date", nullable = false, columnDefinition = "timestamp(0) default current_timestamp")
    private LocalDateTime voteDate;

    @PrePersist
    public void onPrePersist() {
        voteDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(voteId, vote.voteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voteId);
    }
}
