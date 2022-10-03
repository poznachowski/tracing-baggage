package pl.poznachowski.tracingbaggagebug;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.baggage.BaggageField;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class BaggageTestController {

    private static final String OUTPUT = "baggage-assigned-out-0";

    private final BaggageField sampleBaggage;
    private final StreamBridge streamBridge;

    @GetMapping
    public String baggageTest() {
        log.info("Show me traceId");
        sampleBaggage.updateValue("HERE");
        streamBridge.send(OUTPUT, "test-data");
        return "Ok";
    }
}
