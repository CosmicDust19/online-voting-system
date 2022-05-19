package edu.estu.ovs.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "uid", referencedColumnName = "uid", foreignKey = @ForeignKey(name = "fk_admin_uid"))
@OnDelete(action = OnDeleteAction.CASCADE)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Admin extends User {

    @Column(name = "verified", nullable = false, columnDefinition = "boolean default false")
    private Boolean verified;

    @Override
    public void onPrePersist() {
        super.onPrePersist();
        this.verified = false;
    }

}
