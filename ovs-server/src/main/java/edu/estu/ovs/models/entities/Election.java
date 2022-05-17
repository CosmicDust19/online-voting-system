package edu.estu.ovs.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.ovs.core.utilities.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "election")
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid", nullable = false, columnDefinition = "integer")
    private Integer eid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_admin_id", columnDefinition = "integer", updatable = false,
            foreignKey = @ForeignKey(name = "fk_election_creator_admin_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Admin creator;

    @Column(name = "title", nullable = false, length = Constants.MaxLength.ELECTION_TITLE)
    private String title;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "start", nullable = false, columnDefinition = "timestamp(0) default current_timestamp")
    private LocalDateTime start;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "end", nullable = false, columnDefinition = "timestamp(0) default current_timestamp")
    private LocalDateTime end;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "creation_date", nullable = false, updatable = false, columnDefinition = "date")
    private LocalDate creationDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "election_attenders",
            joinColumns = @JoinColumn(name = "election_id", nullable = false), foreignKey = @ForeignKey(name = "fk_election_attenders_election_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id", nullable = false), inverseForeignKey = @ForeignKey(name = "fk_election_attenders_candidate_id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Candidate> attenders;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "election_executives",
            joinColumns = @JoinColumn(name = "election_id", nullable = false), foreignKey = @ForeignKey(name = "fk_election_executives_election_id"),
            inverseJoinColumns = @JoinColumn(name = "admin_id", nullable = false), inverseForeignKey = @ForeignKey(name = "fk_election_executives_admin_id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Admin> executives;

    @PrePersist
    public void onPrePersist() {
        this.creationDate = LocalDate.now();
    }

}
