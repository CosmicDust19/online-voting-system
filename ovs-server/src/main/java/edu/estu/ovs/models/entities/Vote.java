package edu.estu.ovs.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vote", uniqueConstraints = @UniqueConstraint(columnNames = {"voter_id", "election_id"}, name = "uk_vote_voter_id_election_id"))
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
    private Election election;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false, columnDefinition = "integer", foreignKey = @ForeignKey(name = "fk_vote_candidate_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Candidate candidate;

    @Column(name = "vote_date", nullable = false, columnDefinition = "timestamp(0) default current_timestamp")
    private LocalDateTime voteDate;

    @PrePersist
    public void onPrePersist() {
        voteDate = LocalDateTime.now();
    }

}
