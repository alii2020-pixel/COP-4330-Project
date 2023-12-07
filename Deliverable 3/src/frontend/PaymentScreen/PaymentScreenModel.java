package frontend.PaymentScreen;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.YearMonth;

public class PaymentScreenModel {
    public boolean verifyPaymentDetails(String cardNumber, String expiryDate, String cvv) {
        // Verify card number (must be 16 digits)
        if (!isValidCardNumber(cardNumber)) {
            return false;
        }
        // Verify expiration date (must be in "MM/YY" format and between 2023 and 2026)
        if (!isValidExpiryDate(expiryDate)) {
            return false;
        }
        // Verify CVV (must be 3 digits)
        if (!isValidCVV(cvv)) {
            return false;
        }
        // Payment details are considered valid
        return true;
    }
    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.matches("\\d{16}");
    }
    private boolean isValidExpiryDate(String expiryDate) {
        if (expiryDate == null || !expiryDate.matches("\\d{2}/\\d{2}")) {
            return false;
        }
        String[] parts = expiryDate.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);
        YearMonth currentYearMonth = YearMonth.now();
        YearMonth inputYearMonth = YearMonth.of(year, month);
        return inputYearMonth.isAfter(currentYearMonth) && inputYearMonth.isBefore(currentYearMonth.plusYears(3));
    }
    private boolean isValidCVV(String cvv) {
        return cvv != null && cvv.matches("\\d{3}");
    }
    public boolean processTransaction(String cardNumber) {
        // Check if cardNumber has 16 unique integers
        if (!hasUniqueIntegers(cardNumber)) {
            System.out.println("Transaction failed. Card must have 16 unique integers.");
            return false;
        }
        // Couldn't think of a fail state so I figured the 16 integers for a card need to be different and not just the same number repeating 
        System.out.println("Transaction successful.");
        return true;
    }
    private boolean hasUniqueIntegers(String cardNumber) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char digit : cardNumber.toCharArray()) {
            if (!Character.isDigit(digit) || !uniqueDigits.add(digit)) {
                return false; // Not a digit or not unique
            }
        }
        return true;
    }
    public boolean processTransaction() {
        return false;
    }
}

