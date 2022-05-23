package edu.estu.ovs.models.dtos;

import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.annotations.NotExists;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.core.validation.groups.OnUpdate;
import edu.estu.ovs.models.enums.Degree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {

    @Exists(column = "sch_id", table = "candidate_schools", groups = {OnUpdate.class})
    @NotExists(column = "sch_id", table = "candidate_schools", groups = {OnCreate.class})
    @NotNull(message = Msg.REQUIRED, groups = {OnUpdate.class})
    private Integer schId;

    @Exists(column = "uid", table = "candidate", groups = {OnCreate.class, OnUpdate.class})
    @NotNull(message = Msg.REQUIRED, groups = {OnCreate.class, OnUpdate.class})
    private Integer candidateId;

    @NotBlank(message = Msg.REQUIRED, groups = {OnCreate.class, OnUpdate.class})
    @Size(min = Constants.MinLength.SCH_NAME, max = Constants.MaxLength.SCH_NAME, message = Msg.SIZE, groups = {OnUpdate.class, OnCreate.class})
    private String name;

    @NotNull(message = Msg.REQUIRED, groups = {OnCreate.class, OnUpdate.class})
    private Degree degree;

}
