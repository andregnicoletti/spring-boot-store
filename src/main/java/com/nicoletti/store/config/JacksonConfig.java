package com.nicoletti.store.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicoletti.store.entities.PaymentBankSlip;
import com.nicoletti.store.entities.PaymentCard;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
            public void configure(ObjectMapper objectMapper) {
                objectMapper.registerSubtypes(PaymentBankSlip.class);
                objectMapper.registerSubtypes(PaymentCard.class);
                super.configure(objectMapper);
            }
        };
        return builder;
    }

}
