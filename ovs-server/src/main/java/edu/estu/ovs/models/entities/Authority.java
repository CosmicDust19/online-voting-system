package edu.estu.ovs.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.models.enums.RoleName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "authority")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id", nullable = false, columnDefinition = "integer")
    private Integer aid;

    @Column(name = "name", nullable = false, length = Constants.MaxLength.AUTHORITY_NAME)
    private String name;

    public Authority(Integer aid, RoleName roleName) {
        this.aid = aid;
        this.name = roleName.toString();
    }

    public Authority(Integer aid) {
        this.aid = aid;
    }

    public void setName(RoleName roleName) {
        this.name = roleName.toString();
    }

}
