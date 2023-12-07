package frontend.ShipmentScreen;

import common.Customer;

/**
 * Manages the shipment-related data for the shipment screen view.
 * Provides methods to load shipment information and retrieve customer data.
 */
public class ShipmentScreenModel {
    private String shipmentInfo;
    private Customer customer;

    /**
     * Constructs a ShipmentScreenModel object.
     * Initializes the shipment information as an empty string and sets the associated customer.
     *
     * @param customer The customer associated with the shipment.
     */
    public ShipmentScreenModel(Customer customer) {
        this.shipmentInfo = ""; // Empty shipping information
        this.customer = customer;
    }

    /**
     * Simulates loading shipment information.
     * Updates the shipment information data within the model.
     * (In a real application, this method would fetch data from an external source.)
     */
    public void loadShipmentInfo() {
        // Simulate shipment information
        this.shipmentInfo = "Shipment ID: \nStatus: ";
    }

    /**
     * Retrieves the current shipment information.
     *
     * @return The shipment information as a string.
     */
    public String getShipmentInfo() {
        return shipmentInfo;
    }
    
    /**
     * Retrieves the associated customer.
     *
     * @return The customer associated with the shipment.
     */
    public Customer getCustomer() {
    	return customer;
    }
}
