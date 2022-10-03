package pl.poznachowski.tracingbaggagebug;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import brave.baggage.BaggageField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class BaggageListener {

    private final BaggageField sampleBaggage;

    @Bean
    Consumer<Message<String>> onBaggageEvent() {
        return msg -> {
            log.info("HEADERS: {}", msg.getHeaders());
            log.info("BAGGAGE: {}", sampleBaggage.getValue());
        };
    }
}
