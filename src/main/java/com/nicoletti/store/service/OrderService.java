package com.nicoletti.store.service;

import com.nicoletti.store.dtos.OrderInsertDTO;
import com.nicoletti.store.dtos.OrderItemDTO;
import com.nicoletti.store.dtos.PaymentBoletoDTO;
import com.nicoletti.store.dtos.PaymentCartaoDTO;
import com.nicoletti.store.entities.*;
import com.nicoletti.store.enums.PaymentStateType;
import com.nicoletti.store.exceptions.GenericException;
import com.nicoletti.store.repositories.*;
import com.nicoletti.store.utils.ExceptionsErrors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final BankSlipService bankSlipService;
    private final PaymentRepository paymentRepository;
    private final ProductRepository productRepository;
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public List<Order> listAll() {
        return this.orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Order findById(long id) {
        return this.orderRepository.findById(id).orElseThrow(
                () -> new GenericException(ExceptionsErrors.ORDER_ID_DOES_NOT_EXISTS, id));
    }

    @Transactional
    public Order insert(OrderInsertDTO dto) {
        Order order = new Order();
        order.setInstant(new Date());

        // Buscar client e address existentes
        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Address address = addressRepository.findById(dto.addressId())
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        order.setClient(client);
        order.setAddress(address);

        // Instancia o tipo correto de Payment
        Payment payment;
        if (dto.payment() instanceof PaymentBoletoDTO) {
            PaymentBankSlip boleto = new PaymentBankSlip();
            boleto.setDueDate(bankSlipService.generatePayment(new Date()));
            boleto.setState(PaymentStateType.PENDING);
            boleto.setOrder(order);
            payment = boleto;
        } else if (dto.payment() instanceof PaymentCartaoDTO cardDTO) {
            PaymentCard card = new PaymentCard();
            card.setPlotsNumber(cardDTO.getNumberOfInstallments());
            card.setState(PaymentStateType.PENDING);
            card.setOrder(order);
            payment = card;
        } else {
            throw new IllegalArgumentException("Tipo de pagamento inválido: " + dto.payment().getClass().getSimpleName());
        }

        order.setPayment(payment);

        // Salvar pedido e pagamento
        order = orderRepository.save(order);
        paymentRepository.save(payment);

        // Processar itens
        Set<OrderItem> itens = new HashSet<>();
        for (OrderItemDTO itemDTO : dto.itens()) {
            Product product = productRepository.findById(itemDTO.productId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            OrderItemId itemId = new OrderItemId(order, product);
            OrderItem item = new OrderItem();
            item.setId(itemId);
            item.setOrder(order);
            item.setProduct(product);
            item.setDiscount(0.0);
            item.setQuantity(itemDTO.quantity());
            item.setPrice(product.getPrice());

            itens.add(item);
        }

        orderItemRepository.saveAll(itens);
        order.setItens(itens);

        return order;
    }


}
