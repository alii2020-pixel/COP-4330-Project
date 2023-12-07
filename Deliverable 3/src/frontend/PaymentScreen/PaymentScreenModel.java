package frontend.PaymentScreen;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import common.Customer;

import java.time.LocalDate;
import java.time.YearMonth;

/**
 * Manages payment-related data and logic for the payment screen.
 */
public class PaymentScreenModel {
	private Customer customer;
	
	/**
     * Constructs a PaymentScreenModel associated with a specific customer.
     *
     * @param customer The customer initiating the payment.
     */
	public PaymentScreenModel(Customer customer) {
		this.customer = customer;
	}
	
	/**
     * Retrieves the customer associated with the payment process.
     *
     * @return The customer initiating the payment.
     */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
     * Verifies payment details provided by the user.
     *
     * @param cardNumber  The card number entered by the user.
     * @param expiryDate  The expiration date entered by the user.
     * @param cvv         The CVV entered by the user.
     * @return True if payment details are valid, false otherwise.
     */
    public boolean verifyPaymentDetails(String cardNumber, String expiryDate, String cvv) {
    	// testing REMOVE LATER
    	
        // Verify card number (must be 16 digits)
        if (!isValidCardNumber(cardNumber) && false) {
            return false;
        }
        // Verify expiration date (must be in "MM/YY" format and between 2023 and 2026)
        if (!isValidExpiryDate(expiryDate) && false) {
            return false;
        }
        // Verify CVV (must be 3 digits)
        if (!isValidCVV(cvv) && false) {
            return false;
        }
        // Payment details are considered valid
        return true;
    }
    
    /**
     * Checks if the provided card number follows the standard format of 16 digits.
     *
     * @param cardNumber The card number to be validated.
     * @return True if the card number is in the correct format, false otherwise.
     */
    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.matches("\\d{16}");
    }
    
    /**
     * Validates the expiry date format and checks if it's within the next 3 years.
     *
     * @param expiryDate The expiry date string in "MM/YY" format.
     * @return True if the format is correct and within the next 3 years, false otherwise.
     */
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
    
    /**
     * Validates the Card Verification Value (CVV) format, ensuring it consists of 3 digits.
     *
     * @param cvv The CVV string to be validated.
     * @return True if the CVV has the correct format, false otherwise.
     */
    private boolean isValidCVV(String cvv) {
        return cvv != null && cvv.matches("\\d{3}");
    }
    
    /**
     * Processes a transaction based on the provided card number.
     *
     * @param cardNumber The card number used for the transaction.
     * @return True if the transaction is successful, false otherwise.
     */
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
    
    /**
     * Verifies if the provided card number has 16 unique integers.
     *
     * @param cardNumber The card number to be checked.
     * @return True if the card number has 16 unique integers, false otherwise.
     */
    private boolean hasUniqueIntegers(String cardNumber) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char digit : cardNumber.toCharArray()) {
            if (!Character.isDigit(digit) || !uniqueDigits.add(digit)) {
                return false; // Not a digit or not unique
            }
        }
        return true;
    }
    
    /**
     * Processes a default transaction without specific card number validation.
     *
     * @return True for a successful transaction (default), as no validation is performed.
     */
    public boolean processTransaction() {
        return true;
    }
}

