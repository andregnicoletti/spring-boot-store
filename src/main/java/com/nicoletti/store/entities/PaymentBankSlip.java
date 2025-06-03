package com.nicoletti.store.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.nicoletti.store.enums.PaymentStateType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pagamento_boleto")
public class PaymentBankSlip extends Payment {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date paymentDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dueDate;

}
