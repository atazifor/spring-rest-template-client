package spring.start.here.resttemplateclient.proxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import spring.start.here.resttemplateclient.model.Payment;

import java.util.UUID;

@Component
public class PaymentsProxy {
    private final RestTemplate restTemplate;

    @Value("${name.service.url}")
    private String paymentServiceUrl;

    public PaymentsProxy(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Payment createPayment(Payment payment) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, httpHeaders);

        ResponseEntity<Payment> response = restTemplate.exchange(
                paymentServiceUrl+"/payment",
                HttpMethod.POST,
                httpEntity,
                Payment.class
        );
        return response.getBody();
    }

}
