package edu.estu.ovs.models.dtos;

import edu.estu.ovs.core.utilities.Constants;
import edu.estu.ovs.core.utilities.Msg;
import edu.estu.ovs.core.validation.annotations.Exists;
import edu.estu.ovs.core.validation.annotations.NotExists;
import edu.estu.ovs.core.validation.groups.OnCreate;
import edu.estu.ovs.core.validation.groups.OnUpdate;
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
public class CertificationDto {

    @Exists(column = "cert_id", table = "candidate_certifications", groups = {OnUpdate.class})
    @NotExists(column = "cert_id", table = "candidate_certifications", groups = {OnCreate.class})
    @NotNull(message = Msg.REQUIRED, groups = {OnUpdate.class})
    private Integer certId;

    @Exists(column = "uid", table = "candidate", groups = {OnCreate.class, OnUpdate.class})
    @NotNull(message = Msg.REQUIRED, groups = {OnCreate.class, OnUpdate.class})
    private Integer candidateId;

    @NotBlank(message = Msg.REQUIRED, groups = {OnCreate.class, OnUpdate.class})
    @Size(min = Constants.MinLength.CERT_NAME, max = Constants.MaxLength.CERT_NAME, message = Msg.SIZE, groups = {OnUpdate.class, OnCreate.class})
    private String name;

    @Size(min = Constants.MinLength.CERT_DESC, max = Constants.MaxLength.CERT_DESC, message = Msg.SIZE, groups = {OnUpdate.class, OnCreate.class})
    private String desc;

}
