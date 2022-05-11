package edu.estu.ovs.models.dtos;

import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.utilities.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCrDto extends UserCrDto {

    @NotBlank(message = Msg.REQUIRED)
    private String address;

    @NotBlank(message = Msg.REQUIRED)
    @Pattern(regexp = Constants.RegExp.NAT_ID, message = Msg.PATTERN + " (It must consist of 11 digits)")
    private String natId;

}
