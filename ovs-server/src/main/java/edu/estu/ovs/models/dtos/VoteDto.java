package edu.estu.ovs.models.dtos;

import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.core.validation.groups.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto {

    @NotNull(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    @Exists(column = "uid", table = "voter", groups = {OnUpdate.class, OnCreate.class})
    private Integer voterId;

    @NotNull(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    @Exists(column = "eid", table = "election", groups = {OnUpdate.class, OnCreate.class})
    private Integer electionId;

    @NotNull(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    @Exists(column = "uid", table = "candidate", groups = {OnUpdate.class, OnCreate.class})
    private Integer candidateId;

}
