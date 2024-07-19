package com.ms.user.dto.jms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JmsEmailDto {

    private String recipient;

    private String msgBody;

    private String subject;

}
