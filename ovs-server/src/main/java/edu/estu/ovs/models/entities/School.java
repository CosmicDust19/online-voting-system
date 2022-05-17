package edu.estu.ovs.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.utilities.Degree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "candidate_schools", uniqueConstraints = @UniqueConstraint(columnNames = {"candidate_id", "name", "degree"}, name = "uk_candidate_schools_candidate_id_name"))
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sch_id", nullable = false, columnDefinition = "integer")
    private Integer schId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false, columnDefinition = "integer", foreignKey = @ForeignKey(name = "fk_candidate_schools_candidate_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Candidate candidate;

    @Column(name = "name",nullable = false, length = Constants.MaxLength.SCH_NAME)
    private String name;

    @Column(name = "degree", nullable = false, length = Constants.MaxLength.SCH_DEG)
    private Degree degree;

}
