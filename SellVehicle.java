public class SellVehicle extends Vehicle {

    private double sellPrice;
    
    public SellVehicle(int id, Customer customer, String owner, String typeOfVehicle, double price)
    {
        super(id, customer, owner, typeOfVehicle, price, VehicleType.SELL);
        setSeller(owner);
    }
    
    public SellVehicle(int id, String owner, String typeOfVehicle, double price)
    {
        super(id, null, owner, typeOfVehicle, price, VehicleType.SELL);
    }
    
    public double sell(Customer customer)
    {
        status = Status.SOLD;
        customer = customer;        
        setSeller(owner);
        this.sellPrice = sellPrice;
        return sellPrice;                         
    }
    
    private void setSeller(String owner)
    {
        this.owner = owner;
    }
    
    @Override
    public String toString()
    {
        if (owner != null)
        {
            return "• Vehicle for Sale " + super.toString();
        }        
        return "• Vehicle for Sale " + super.toString();
    }
}
