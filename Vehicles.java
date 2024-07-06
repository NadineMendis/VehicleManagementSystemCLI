public class Vehicles extends Records {

    @Override
    public Vehicle find(int id)
    {
        return (Vehicle)super.find(id);
    }
    
    public void addRentVehicle()
    {
        super.add(new RentVehicle(++id, In.readName("Rental Vehicle Owner's Name: "),
                        In.readName("Type of Vehicle: "), In.readName("Rental Period: "),
                        In.readDouble("Vehicle Rental Price")));
    }
    
    public void addSellVehicle()
    {
        super.add(new SellVehicle(++id, In.readName("Vehicle Owners Name: "),
                        In.readName("Type of Vehicle: "), In.readDouble("Vehicle Sell Price")));
    }
    
    @Override
    public String toString()
    {
        return "Vehicles\n" + super.toString();
    }
}
