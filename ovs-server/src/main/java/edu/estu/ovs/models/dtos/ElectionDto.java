package edu.estu.ovs.models.dtos;

import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.validation.abstracts.SchedulableDateTime;
import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.annotations.NoScheduleConflict;
import edu.estu.ovs.core.validation.annotations.NotExists;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.core.validation.groups.OnUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NoScheduleConflict(groups = {OnUpdate.class, OnCreate.class})
public class ElectionDto implements SchedulableDateTime {

    @Exists(column = "eid", table = "election", groups = {OnUpdate.class})
    @NotExists(column = "eid", table = "election", groups = {OnCreate.class})
    private Integer eid;

    @Exists(column = "uid", table = "admin", groups = {OnUpdate.class, OnCreate.class})
    private Integer creatorAdminId;

    @NotBlank(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    @Size(min = Constants.MinLength.ELECTION_TITLE, max = Constants.MaxLength.ELECTION_TITLE, message = Msg.SIZE, groups = {OnUpdate.class, OnCreate.class})
    private String title;

    @NotNull(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    @Future(message = Msg.FUTURE, groups = {OnUpdate.class, OnCreate.class})
    private LocalDateTime startDate;

    @NotNull(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    private LocalDateTime endDate;

}
