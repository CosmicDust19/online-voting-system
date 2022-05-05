package edu.estu.ovs.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElectionCreateDto {

    private Integer creatorAdminId;

    private LocalDateTime start;

    private LocalDateTime end;

}
