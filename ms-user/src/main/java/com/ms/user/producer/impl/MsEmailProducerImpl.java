package com.ms.user.producer.impl;

import com.ms.user.dto.jms.JmsEmailDto;
import com.ms.user.producer.IMsEmailProducer;
import com.ms.user.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component // TODO modificar a @Service
public class MsEmailProducerImpl implements IMsEmailProducer {

    private final JmsTemplate jmsTemplate;

    public MsEmailProducerImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void generateTransactionEmail(JmsEmailDto jmsEmailDto) {
        try{
            final String messageBody = JsonUtil.convertJson(jmsEmailDto);

            //true =(topico)  que va a ir a un topico ( Pub/Sub)
            //false =(queue ) Que va a una cola de mensajeria  queue (esta escuchando )
            jmsTemplate.setPubSubDomain(false);

            //assert messageBody != null;
            jmsTemplate.convertAndSend(
                    "queue.msemail.generate_email",
                    messageBody
            );
        }catch (JmsException e){
            log.error(e.getMessage(),e);
        }
    }
}
