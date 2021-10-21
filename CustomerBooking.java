
/**
 * Ifeoma Aniekwena 
 *Student: Year 2 
 *The customer booking program
 */
//2.)Define Customer Booking
public class CustomerBooking
{
    private String name;
    private String email;
    private String comedianName;
    private int boughtTickets;
    private boolean booked;
    //2.1)Create Standard operations
    public CustomerBooking()
    {
        this.name = "";
        this.email = "";
        this.comedianName = "";
        this.boughtTickets = 0;
        this.booked = false;
    }

    public CustomerBooking (String custName , String email , String cName , int bTickets , boolean booked)
    {
        this.name = custName;
        this.email = email;
        this.comedianName = cName;
        this.boughtTickets = bTickets;
        this.booked = booked;
    }
    //getter methods
    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getComedianName()
    {
        return this.comedianName;
    }

    public int getBoughtTickets()
    {
        return this.boughtTickets;
    }

    public boolean getBooked()
    {
        return this.booked;
    }
    //setter methods
    public void setName(String custName)
    {
        this.name = custName; 
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public void setComedianName (String cName)
    {
        this.comedianName = cName;
    }

    public void setBoughtTickets (int bTickets)
    {
        this.boughtTickets = bTickets;
    }

    public void setBooked(boolean booked)
    {
        this.booked = booked;
    }
    //2.2)Indicate if customer booked event or not 
    public boolean EventBooked ()
    {

        if ( this.comedianName!= "")
        {
            booked = true;
            System.out.print("You have booked an event ");
        }
        else
        {
            booked = false;
            System.out.print("You have not booked an event");

        }
        return this.booked;
    }

    //Personal feature
    //2.3)Create a discount method for the party snack box
    public double discount()
    {
        double total = 10;
        total = total * 0.02;
        total = 10 - total;
        System.out.println("Your total amount is now" + total);
        return total;
        
    }
    
    
    public void display()
    {

        System.out.println("Enter your  name:" + this.name);
        System.out.println("Enter your  email:" +this.email);
        System.out.println("Enter the comedians name: " + this.comedianName);
        System.out.println("Enter you amount of tickets bought ( max 1 per person ) " + this.boughtTickets);
        System.out.println(EventBooked());
    }
}

