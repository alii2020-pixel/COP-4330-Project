package frontend.ShipmentScreen;

import common.Customer;

public class ShipmentScreenModel {
    private String shipmentInfo;
    private Customer customer;

    public ShipmentScreenModel(Customer customer) {
        this.shipmentInfo = ""; // Empty shipping information
        this.customer = customer;
    }

    public void loadShipmentInfo() {
        // Simulate shipment information
        this.shipmentInfo = "Shipment ID: \nStatus: ";
    }

    public String getShipmentInfo() {
        return shipmentInfo;
    }
    
    public Customer getCustomer() {
    	return customer;
    }
}
