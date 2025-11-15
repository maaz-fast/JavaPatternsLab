package lab.adapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Decorator that adds logging to any PaymentGateway implementation.
 * Logs timestamps and amounts before and after each operation.
 */
public class LoggingPaymentGateway implements PaymentGateway {
    private final PaymentGateway wrapped;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LoggingPaymentGateway(PaymentGateway wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void pay(double dollars) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[LoggingPaymentGateway] " + timestamp + " | BEFORE pay() called with: $" + dollars);
        try {
            wrapped.pay(dollars);
            System.out.println("[LoggingPaymentGateway] " + timestamp + " | AFTER pay() succeeded for: $" + dollars);
        } catch (Exception e) {
            System.out.println("[LoggingPaymentGateway] " + timestamp + " | AFTER pay() failed with error: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void refund(double dollars) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[LoggingPaymentGateway] " + timestamp + " | BEFORE refund() called with: $" + dollars);
        try {
            wrapped.refund(dollars);
            System.out.println("[LoggingPaymentGateway] " + timestamp + " | AFTER refund() succeeded for: $" + dollars);
        } catch (Exception e) {
            System.out.println("[LoggingPaymentGateway] " + timestamp + " | AFTER refund() failed with error: " + e.getMessage());
            throw e;
        }
    }
}
