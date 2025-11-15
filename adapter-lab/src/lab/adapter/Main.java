package lab.adapter;
public class Main {
public static void main(String[] args) {
System.out.println("=== Adapter Pattern Demo: Payment Integration ===");
// legacy service
LegacyPaymentService legacyService = new LegacyPaymentService("MERCHANT-123");
// adapter
PaymentAdapter adapter = new PaymentAdapter(legacyService);
// decorator with logging
PaymentGateway gateway = new LoggingPaymentGateway(adapter);

System.out.println("\n--- Basic USD Payments ---");
gateway.pay(19.99);
gateway.pay(5.0);

System.out.println("\n--- Testing Refund ---");
gateway.refund(9.50);

System.out.println("\n--- Multi-Currency Payments ---");
System.out.println("\nPaying 10 EUR:");
adapter.pay(10, "EUR");

System.out.println("\nPaying 100 PKR:");
adapter.pay(100, "PKR");

System.out.println("\nRefunding 50 GBP:");
adapter.refund(50, "GBP");
}
}