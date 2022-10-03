package pl.poznachowski.tracingbaggagebug;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import brave.baggage.BaggageField;

@Configuration(proxyBeanMethods = false)
public class BaggageConfiguration {

    @Bean
    BaggageField sampleBaggage() {
        return BaggageField.create("test_baggage");
    }
}
