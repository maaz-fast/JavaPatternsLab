package lab.adapter;
/**
* Adapter that converts dollars to cents and calls the legacy service.
* Also supports multi-currency payments with conversion.
*/
public class PaymentAdapter implements PaymentGateway {
private final LegacyPaymentService legacy;
public PaymentAdapter(LegacyPaymentService legacy) {
this.legacy = legacy;
}
@Override
public void pay(double dollars) {
// Convert dollars to cents safely: round to nearest cent
int cents = (int) Math.round(dollars * 100);
System.out.println("[PaymentAdapter] Converting $" + dollars + " -> " + cents + "cents");
legacy.makePayment(cents);
}

@Override
public void refund(double dollars) {
// Convert dollars to cents safely: round to nearest cent
int cents = (int) Math.round(dollars * 100);
System.out.println("[PaymentAdapter] Converting $" + dollars + " -> " + cents + "cents for refund");
legacy.refundPayment(cents);
}

/**
* Pay with currency conversion.
* @param amount the amount in the specified currency
* @param currencyCode the currency code (e.g., "EUR", "PKR", "USD")
*/
public void pay(double amount, String currencyCode) {
// Convert to USD first
double usd = CurrencyConverter.toUSD(amount, currencyCode);
// Then pay in USD
pay(usd);
}

/**
* Refund with currency conversion.
* @param amount the amount in the specified currency
* @param currencyCode the currency code (e.g., "EUR", "PKR", "USD")
*/
public void refund(double amount, String currencyCode) {
// Convert to USD first
double usd = CurrencyConverter.toUSD(amount, currencyCode);
// Then refund in USD
refund(usd);
}
}