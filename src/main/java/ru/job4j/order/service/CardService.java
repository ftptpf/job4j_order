package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.order.model.Card;
import ru.job4j.order.repository.CardRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService {

    private CardRepository cardRepository;

    public Optional<Card> findById(Integer id) {
        return cardRepository.findById(id);
    }
}
