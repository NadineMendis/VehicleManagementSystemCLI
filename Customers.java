public class Customers extends Records{
    
    @Override
    public Customer find(int id)
    {
        return (Customer)super.find(id);
    }
    
    public void add()
    {
        super.add(new Customer(++id, In.readName("Customer Name: ")));
    }

    @Override
    public String toString()
    {
        return "Customers\n" + super.toString();
    }
}
