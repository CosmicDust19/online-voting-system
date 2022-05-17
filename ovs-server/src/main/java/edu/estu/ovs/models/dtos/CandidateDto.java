package edu.estu.ovs.models.dtos;

import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.annotations.NotExists;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.core.validation.groups.OnUpdate;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.utilities.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto extends UserDto {

    @NotBlank(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    @Size(min = Constants.MinLength.ADDR, max = Constants.MaxLength.ADDR, message = Msg.SIZE, groups = {OnUpdate.class, OnCreate.class})
    private String address;

    @Exists(column = "nationality_id", table = "candidate", groups = {OnUpdate.class})
    @NotExists(column = "nationality_id", table = "candidate", groups = {OnCreate.class})
    @NotBlank(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    @Pattern(regexp = Constants.RegExp.NAT_ID, message = Msg.PATTERN, groups = {OnUpdate.class, OnCreate.class})
    private String nationalityId;

}
