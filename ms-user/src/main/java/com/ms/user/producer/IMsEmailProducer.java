package com.ms.user.producer;

import com.ms.user.dto.jms.JmsEmailDto;

public interface IMsEmailProducer {
    void generateTransactionEmail(JmsEmailDto jmsEmailDto);
}
