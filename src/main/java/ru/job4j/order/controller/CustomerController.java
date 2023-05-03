package ru.job4j.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.order.dto.CustomerDto;
import ru.job4j.order.model.Card;
import ru.job4j.order.model.Customer;
import ru.job4j.order.service.CardService;
import ru.job4j.order.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CardService cardService;

    @PutMapping("/buy-card/{cardId}")
    public ResponseEntity<?> buyCard(@RequestBody CustomerDto customerDto, @PathVariable Integer cardId) {
        Customer customerFromDb = customerService.findByPhone(customerDto.getPhone()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found")
        );
        Card card = cardService.findById(cardId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found")
        );
        customerFromDb.setMoney(customerFromDb.getMoney() - card.getCost());
        customerFromDb.setCard(card);
        customerService.save(customerFromDb);
        return ResponseEntity.ok("The client has successfully purchased the card");
    }

}
