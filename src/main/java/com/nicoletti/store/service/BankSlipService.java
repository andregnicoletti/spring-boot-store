package com.nicoletti.store.service;

import com.nicoletti.store.entities.PaymentBankSlip;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class BankSlipService {

    public Date generatePayment(Date instant) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(instant);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        return calendar.getTime();
    }

}
