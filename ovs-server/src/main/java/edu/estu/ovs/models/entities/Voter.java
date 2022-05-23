package edu.estu.ovs.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "voter")
@PrimaryKeyJoinColumn(name = "uid", referencedColumnName = "uid", foreignKey = @ForeignKey(name = "fk_voter_uid"))
@OnDelete(action = OnDeleteAction.CASCADE)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Voter extends User {

    @Override
    public void onPrePersist() {
        super.onPrePersist();
        this.enabled = true;
    }

}
