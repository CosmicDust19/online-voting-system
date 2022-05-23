package edu.estu.ovs.models.dtos;

import edu.estu.ovs.core.utilities.Msg;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotBlank(message = Msg.REQUIRED)
    private String username;

    @NotBlank(message = Msg.REQUIRED)
    private String password;

}
