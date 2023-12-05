package frontend.ShipmentScreen;

public class ShipmentScreenModel {
    private String shipmentInfo;

    public ShipmentScreenModel() {
        this.shipmentInfo = ""; // Empty shipping information
    }

    public void loadShipmentInfo() {
        // Simulate shipment information
        this.shipmentInfo = "Shipment ID: \nStatus: ";
    }

    public String getShipmentInfo() {
        return shipmentInfo;
    }
}
