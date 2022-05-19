package edu.estu.ovs.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.ovs.core.utilities.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "candidate_certifications", uniqueConstraints = @UniqueConstraint(columnNames = {"candidate_id", "name"}, name = "uk_candidate_certifications_candidate_id_name"))
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cert_id", nullable = false, columnDefinition = "integer")
    private Integer certId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false, columnDefinition = "integer", foreignKey = @ForeignKey(name = "fk_candidate_certifications_candidate_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Candidate candidate;

    @Column(name = "name", nullable = false, length = Constants.MaxLength.CERT_NAME)
    private String name;

    @Column(name = "description", length = Constants.MaxLength.CERT_DESC)
    private String desc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certification that = (Certification) o;
        return Objects.equals(certId, that.certId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(certId);
    }
}
