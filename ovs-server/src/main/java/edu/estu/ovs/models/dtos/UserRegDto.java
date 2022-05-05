package edu.estu.ovs.models.dtos;

import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.utilities.ValidationConstants;
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
public class UserRegDto {

    @NotBlank(message = Msg.REQUIRED)
    @Pattern(regexp = ValidationConstants.RegExp.EMAIL, message = Msg.PATTERN)
    protected String email;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = ValidationConstants.MinLength.PASSWORD, max = ValidationConstants.MaxLength.PASSWORD, message = Msg.SIZE)
    protected String password;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = ValidationConstants.MinLength.F_NAME, max = ValidationConstants.MaxLength.F_NAME, message = Msg.SIZE)
    protected String fName;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = ValidationConstants.MinLength.M_NAME, max = ValidationConstants.MaxLength.M_NAME, message = Msg.SIZE)
    protected String mName;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = ValidationConstants.MinLength.L_NAME, max = ValidationConstants.MaxLength.L_NAME, message = Msg.SIZE)
    protected String lName;

    @NotNull(message = Msg.REQUIRED)
    @Past
    protected LocalDate birthDate;

}
