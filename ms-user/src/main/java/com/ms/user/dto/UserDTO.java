package com.ms.user.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank
    @NotEmpty
    @Size(min = 6 ,max = 16)
    @Pattern(regexp = "^[0-9]*$",message = "the document should be just letters")
    private String document;

//    @Pattern(regexp = "^(?:TI|CC|CE)$")
//    private String typeDocumet;

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "^[^0-9]*$",message = "the document should be just letters")
    private String name;

    @Email
    private String email;

    @NotEmpty
    @NotBlank
    private  String information;

}
