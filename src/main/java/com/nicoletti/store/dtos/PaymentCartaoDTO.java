package com.nicoletti.store.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCartaoDTO extends PaymentDTO {

    private Integer numberOfInstallments;

}
