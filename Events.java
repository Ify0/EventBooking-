
/**
 * Name:Ifeoma Aniewkena 
 * Student ID:C20390733
 *The events program
 */
//1.)Define Event
public class Events
{
    private String name;
    private String day;
    private String time;
    private int numberOfTicketsBooked;
    private int amount;
    //1.1)Create standard operations 
    public Events()
    {
        this.name = "";
        this.day = "";
        this.time = "";
        this.numberOfTicketsBooked = 0;
        this.amount = 0;
    }
    
    public Events( String name ,String day, String time, int ticketsBooked , int amount) 
    {
        this.name = name;
        this.day = day;
        this.time = time;
        this.numberOfTicketsBooked = ticketsBooked;
        this.amount = amount;
    }
    //getter methods
    public String getName()
    {
        return this.name;
    }

    public String getDay()
    {
        return this.day;
    }

    public String getTime()
    {
        return this.time;
    }

    public int getNumberOfTicketsBooked()
    {
        return this.numberOfTicketsBooked;
    }

    public int getamount()
    {
        return this.amount;
    }
    //setter methods
    public void setName(String name)
    {
        this.name = name;
    }

    public void setDay(String day)
    {
        this.day = day;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public void setNumberOfTicketsBooked(int ticketsBooked)
    {
        this.numberOfTicketsBooked = ticketsBooked;
    }
    
    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    //1.2)Calculating tickets unsold 
    public int unsoldTickets()
    {
        int total = 50;
        total = total - this.numberOfTicketsBooked;
        return total;
    }
    
    public void display()
    {
        System.out.println("The name of the comedian is: " + this.name);
        System.out.println("The day of  performace is: " + this.day);
        System.out.println("The time the of performace: " + this.time);
        System.out.println("The number of tickets bought: " + this.numberOfTicketsBooked);
        System.out.print("\n");
    }
    // personal feature
    //1.3)Create an eGift voucher method to add 20 top up
    public int topUpeGift ()
    {
        int topUp = 20;
         topUp = topUp + this.amount;
        System.out.print("The total amount is now: " + topUp );
        return topUp;
    }
}
