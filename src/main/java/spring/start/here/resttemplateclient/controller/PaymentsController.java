package spring.start.here.resttemplateclient.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.start.here.resttemplateclient.model.Payment;
import spring.start.here.resttemplateclient.proxy.PaymentsProxy;

@RestController
public class PaymentsController {
    private final PaymentsProxy paymentsProxy;

    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    @PostMapping("/payment")
    public Payment payment(@RequestBody Payment payment) {
        return paymentsProxy.createPayment(payment);
    }
}
