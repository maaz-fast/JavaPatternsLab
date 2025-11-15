package lab.adapter;

/**
 * Simple utility to convert foreign currencies to USD.
 */
public class CurrencyConverter {
    
    /**
     * Converts amount from a currency to USD using simple exchange rates.
     * @param amount the amount in the foreign currency
     * @param currencyCode the currency (e.g., "EUR", "PKR")
     * @return the equivalent in USD
     */
    public static double toUSD(double amount, String currencyCode) {
        double rate;
        
        if (currencyCode.equalsIgnoreCase("USD")) {
            rate = 1.0;
        } else if (currencyCode.equalsIgnoreCase("EUR")) {
            rate = 1.10;  // 1 EUR = 1.10 USD
        } else if (currencyCode.equalsIgnoreCase("PKR")) {
            rate = 0.0036;  // 1 PKR = 0.0036 USD
        } else if (currencyCode.equalsIgnoreCase("GBP")) {
            rate = 1.27;  // 1 GBP = 1.27 USD
        } else {
            throw new IllegalArgumentException("Currency not supported: " + currencyCode);
        }
        
        double usdAmount = amount * rate;
        System.out.println("[CurrencyConverter] " + amount + " " + currencyCode + " = $" + String.format("%.2f", usdAmount) + " USD");
        return usdAmount;
    }
}

