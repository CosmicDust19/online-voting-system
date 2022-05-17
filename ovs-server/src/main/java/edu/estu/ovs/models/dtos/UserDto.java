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

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Exists(column = "uid", table = "user", groups = {OnUpdate.class})
    @NotExists(column = "uid", table = "user", groups = {OnCreate.class})
    @NotNull(message = Msg.REQUIRED, groups = {OnUpdate.class})
    private Integer uid;

    @Exists(column = "email", table = "user", groups = {OnUpdate.class})
    @NotExists(column = "email", table = "user", groups = {OnCreate.class})
    @NotBlank(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    @Pattern(regexp = Constants.RegExp.EMAIL, message = Msg.PATTERN, groups = {OnUpdate.class, OnCreate.class})
    protected String email;

    @NotBlank(message = Msg.REQUIRED, groups = {OnCreate.class})
    @Size(min = Constants.MinLength.PW, max = Constants.MaxLength.PW, message = Msg.SIZE, groups = {OnUpdate.class, OnCreate.class})
    protected String password;

    @NotBlank(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    @Size(min = Constants.MinLength.F_NAME, max = Constants.MaxLength.F_NAME, message = Msg.SIZE, groups = {OnUpdate.class, OnCreate.class})
    protected String firstName;

    @Size(min = Constants.MinLength.M_NAME, max = Constants.MaxLength.M_NAME, message = Msg.SIZE, groups = {OnUpdate.class, OnCreate.class})
    protected String middleName;

    @NotBlank(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    @Size(min = Constants.MinLength.L_NAME, max = Constants.MaxLength.L_NAME, message = Msg.SIZE, groups = {OnUpdate.class, OnCreate.class})
    protected String lastName;

    @NotNull(message = Msg.REQUIRED, groups = {OnUpdate.class, OnCreate.class})
    @Past(message = Msg.PAST, groups = {OnUpdate.class, OnCreate.class})
    protected LocalDate birthDate;

}
