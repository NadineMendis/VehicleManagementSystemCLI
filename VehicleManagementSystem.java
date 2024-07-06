public class VehicleManagementSystem
{
    private final String NAME = "Fleet Wave";
    private final char YES = 'Y';
    private Customers customers = new Customers();
    private Vehicles vehicles = new Vehicles();
    private double balance = 10000;   
    private double income;
    
    public VehicleManagementSystem()
    {
        display(true, NAME + " is open for business");
        menu(); 
    }

    private void menu()
    {
        char action = readAction();
        switch (action)
        {
            case '?': help(); break;
            case 'A': addCustomer(); break;
            case 'B': addRentVehicle(); break;
            case 'C': addSellVehicle(); break;
            case 'R': rent(); break;
            case 'S': sell(); break;
            case 'D': report(); break;
            case 'X': exit(); break;
            default: error();
        }
    }

    private void addCustomer()
    {
        display(true, "--- Add Customer ---");
        customers.add();
        display(true, "Success - customer added");
        menu();
    }

    private void addRentVehicle()
    {
        display(true, "--- Add Vehicle for rent ---");
        vehicles.addRentVehicle();
        display(true, "Success - Vehicle for rent was added");
        menu();
    }

    private void addSellVehicle()
    {
        display(true, "--- Add Vehicle for sale ---");
        vehicles.addSellVehicle();
        display(true, "Success - Vehicle for sale was added");
        menu();
    }

    private void rent()
    {
        display(true, "--- Rent a Vehicle ---");
        Vehicle vehicle = vehicles.find(In.readInt("Rental Vehicle ID"));
        if (vehicle != null && vehicle.getVehicleType() == VehicleType.RENT)
        {
            if (vehicle.getStatus() == Status.AVAILABLE)
            {
                Customer customer = customers.find(In.readInt("Customer ID"));
                if (customer != null)
                {
                    income += ((RentVehicle)vehicle).rent(customer);
                    display(true, "Success - Vehicle has been Rented by " + customer.getCustomerName());
                }
                else
                {
                    display(true, "Error - No customer with such ID");
                }
            }
            else
            {
                display(true, "Error - Vehicle already RENTED");
            }
        }
        else
        {
            display(true, "Error - No vehicle for rented with such ID");
        }
        menu();
    }

    private void sell()
    {
        display(true, "--- Buy a Vehicle ---");
        Vehicle vehicle = vehicles.find(In.readInt("Sales Vehicle ID"));
        if (vehicle != null && vehicle.getVehicleType() ==  VehicleType.SELL)
        {
            if (vehicle.getStatus() == Status.AVAILABLE)
            {
                Customer customer = customers.find(In.readInt("Customer ID"));
                if (customer != null)
                {
                    income += ((SellVehicle)vehicle).sell(customer);
                    display(true, "Success - Vehicle Sold to " + customer.getCustomerName());
                }
                else
                {
                    display(true, "Error - No customer with such ID");
                }
            }
            else
            {
                display(true, "Error - Vehicle already SOLD");
            }
        }
        else
        {
            display(true, "Error - No sales vehicle with such ID");
        }
        menu();
    }

    private void report()
    {
        display(true, "--- " + NAME + " Report ---");
        show();
        vehicles.show();
        customers.show();
        menu();
    }

    private char readAction()
    {
        System.out.println("\nPlease enter your choice (A,B,C,R,S,D,X,?): ");
        return In.nextUpperChar();
    }

    private void display (boolean lineBreak, String message)
    {
        if (lineBreak)
            System.out.println(message); 
        else
            System.out.print(message);
    }

    private void exit()
    {
        if (!confirm())
            menu();
        System.out.println("Thank you for visiting " + NAME);
    }

    private boolean confirm()
    {
        System.out.println("Are you sure you want to exit (y/n)?: ");
        return In.nextUpperChar() == YES;
    }

    private void help()
    {
        System.out.println("Welcome to " + NAME +" menu: Enter");
        System.out.println("A to Add Customer");
        System.out.println("B to Add Vehicle for Rent");
        System.out.println("C to Add a Vehicle for Sale");
        System.out.println("R to Rent a Vehicle");
        System.out.println("S to Buy a Vehicle");
        System.out.println("D to Display a Report");
        System.out.println("X to exit");
        menu();
    }

    private void error()
    {
        System.out.println("No action found!! Please try again.");
        menu();
    }
    
    public void show()
    {
        display(true, toString());
    }
    
    @Override
     public String toString()
    {
        String s = NAME + ":";
        s += "\n\t Month = " + Util.getCurrentMonth();
        s += "\n\t Income = $" + Util.format(income);
        s += "\n\t Opening balance = $" + Util.format(balance);
        s += "\n\t Total Worth = $" + Util.format(balance + income) + "\n";
        return s;
    }   
}
