// FinancialReportsScreenModel.java
// Ethan Curtis

package frontend.FinancialReportsScreen;

import common.Seller;

/**
 * Represents the model containing data for the Financial Reports screen.
 */
public class FinancialReportsScreenModel {
    private Seller seller;

    /**
     * Constructs a FinancialReportsScreenModel with the associated Seller.
     *
     * @param seller The Seller associated with the financial reports.
     */
    public FinancialReportsScreenModel(Seller seller) {
        this.seller = seller;
    }

    /**
     * Retrieves the Seller associated with the financial reports.
     *
     * @return The Seller associated with the financial reports.
     */
    public Seller getSeller() {
        return seller;
    }

    /**
     * Simulates and retrieves the total sales for the financial reports.
     *
     * @return The total sales for the financial reports.
     */
    public int getTotalSales() {
        return 50000; // Simulated sales retrieved from the server
    }

    /**
     * Simulates and retrieves the total profit calculated for the financial reports.
     *
     * @return The total profit for the financial reports.
     */
    public double getTotalProfit() {
        return 123456.78; // Simulated profit calculation retrieved from the server
    }
}
