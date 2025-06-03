package com.nicoletti.store.dtos;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PaymentBoletoDTO.class, name = "pagamentoComBoleto"),
        @JsonSubTypes.Type(value = PaymentCartaoDTO.class, name = "pagamentoComCartao")
})
public abstract class PaymentDTO {
}