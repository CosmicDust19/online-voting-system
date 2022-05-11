package edu.estu.ovs.models.dtos;

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
public class UserCrDto {

    @Email
    @NotBlank(message = Msg.REQUIRED)
    @Pattern(regexp = Constants.RegExp.EMAIL, message = Msg.PATTERN)
    protected String email;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = Constants.MinLength.PASSWORD, max = Constants.MaxLength.PASSWORD, message = Msg.SIZE)
    protected String password;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = Constants.MinLength.F_NAME, max = Constants.MaxLength.F_NAME, message = Msg.SIZE)
    protected String fName;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = Constants.MinLength.M_NAME, max = Constants.MaxLength.M_NAME, message = Msg.SIZE)
    protected String mName;

    @NotBlank(message = Msg.REQUIRED)
    @Size(min = Constants.MinLength.L_NAME, max = Constants.MaxLength.L_NAME, message = Msg.SIZE)
    protected String lName;

    @NotNull(message = Msg.REQUIRED)
    @Past
    protected LocalDate birthDate;

}
