package edu.estu.ovs.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "candidate", uniqueConstraints = @UniqueConstraint(columnNames = "nationality_id", name = "uk_candidate_nationality_id"))
@PrimaryKeyJoinColumn(name = "uid", referencedColumnName = "uid", foreignKey = @ForeignKey(name = "fk_candidate_uid"))
@OnDelete(action = OnDeleteAction.CASCADE)
public class Candidate extends User {

    @Column(name = "introduction", length = 1000)
    private String intro;

    @Column(name = "address", nullable = false, length = 400)
    private String address;

    @Column(name = "nationality_id", nullable = false, length = 11)
    @JsonIgnore
    private String natId;

    @Column(name = "verified", nullable = false, columnDefinition = "boolean default false")
    private Boolean verified;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private List<Certification> certs;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private List<School> schools;

}
