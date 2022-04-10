package models;

public class OrderModel {
    public OrderModel(long id, long petId, int quantity, String shipDate, String status, boolean complete) {
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    public long id;
    public long petId;
    public int quantity;
    public String shipDate;
    public String status;
    public boolean  complete;
}
