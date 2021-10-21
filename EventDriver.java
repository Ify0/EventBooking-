import java.util.Scanner;
import java.util.ArrayList;
/**
 * This is the event Driver 
 *Name:Ifeoma Aniekwena
 * Student Year 2
 */
public class EventDriver
{
    ArrayList<Events>eventsBooked;
    final int EVENT_SIZE = 3;

    ArrayList<CustomerBooking>bookingEvents;
    final int BOOKING_SIZE = 50;
    public EventDriver()
    {
        Scanner scan = new Scanner(System.in);
        int option; 
        System.out.print("\f");

        //Creating the  3 events 
        eventsBooked = new ArrayList<Events>();
        createEvents();
        System.out.print("\f");

        //Creating a blank customer booking list
        bookingEvents = new ArrayList<CustomerBooking>();

        //Menu
        do
        {
            menu();
            option = processMenu();
            if (option == 1)
            {
                //buy ticktes
                buyingTickets();
            }
            else  if (option == 2)
            {
                //cancel tickets
                cancelBooking();
            }
            if (option == 3)
            {
                //display events
                displayEvents();
            }
            else if (option == 4)
            {
                //e-gift card - event
                eGifts();
            }
            if (option == 5)
            {
                //party snack box - booking
                Snack();
            }

            System.out.println("Press return to continue...");
            scan.nextLine();
        }while (option !=6);

        System.out.println("Exit option chosen - good bye");

    }

    public void createEvents()
    {
        Scanner scan = new Scanner(System.in);
        String name;
        String day;
        String time;
        int ticketsB;
        int amount = 0;
        Events aEvent;
        //3.)Input 3 Events
        for (int count = 0; count < EVENT_SIZE; count++)
        {
            System.out.println("Creating events....");

            System.out.print("The name of the comedian is: ");
            name = scan.nextLine();
            System.out.print("The day of  performace: ");
            day = scan.nextLine();
            System.out.print("The time the of performace(either 'eveing' or 'late night': ");
            time = scan.nextLine();
            System.out.print("The number of tickets bought: ");
            ticketsB = scan.nextInt();
            scan.nextLine();
            System.out.print("\n\n");

            //create a progam for the details
            aEvent = new Events(name, day, time, ticketsB, amount);

            //3.1)add into arraylists
            eventsBooked.add(aEvent);

        }

    }

    public void menu()
    {
        //4.)Show menu 
        System.out.print("\f");
        System.out.println("\nDisplaying menu options....");
        System.out.println("1.) Buy ticket for an event");
        System.out.println("2.) Cancel ticket for an event");
        System.out.println("3.) Display full event schedule");
        System.out.println("4.) Buy a e-gift card for an event");
        System.out.println("5.) Buy a party snack box for your event");
        System.out.println("6.) Exit System");

    }

    public int processMenu()
    {
        Scanner scan = new Scanner(System.in);
        int option = 0;
        do
        {
            System.out.print("Please input a menu option: ");
            option = scan.nextInt();
            scan.nextLine();

        }while (option < 0 || option >6);

        return option;
    }

    public void buyingTickets()
    {
        String name , email ,eName , cName, eDay;
        int boughtTickets , total = 50;
        int search, bookedTickets;
        Scanner scan = new Scanner(System.in);

        //5.)Buy a ticket
        //5.1)Input comedian name and day
        System.out.println("\nBuying a ticket....");
        System.out.print("\nEnter comedian's name: ");
        eName = scan.nextLine();
        System.out.print("Enter the day you wish to attend event: ");
        eDay = scan.nextLine();
        //5.2)Search for event
        search = getEventBooking(eName , eDay);
        if (search == 99)
        {
            System.out.println("We are not able to process this order because there is no event on this day and there is no comedian by this name");

        }
        else
        {
            //Buying tickets 
            System.out.print("How many tickets do you want to purchase");
            bookedTickets = scan.nextInt();
            scan.nextLine();

            if (bookedTickets > eventsBooked.get(search).unsoldTickets())
            {
                System.out.println("There is not enough tickets left for this event");
                System.out.println("We can offer a 20% discount using the (code:ASK20) on your next purchase");

            }
            else
            {

                //5.3 Add customer details
                System.out.print("\nThere are tickets available for this event!");
                System.out.print("\n\nInput booking details below");

                System.out.println("\nEnter your  name: ");
                name = scan.nextLine(); 

                System.out.println("Enter your  email:");
                email = scan.nextLine();

                System.out.println("Enter the comedian's name: ");
                cName = scan.nextLine();

                System.out.println("Enter the amount you want to buy: ");
                boughtTickets = scan.nextInt();
                scan.nextLine();

                //5.4)Create new customer and store in customer booking ArrayList
                CustomerBooking Booking1;

                //new customer booking
                Booking1 = new CustomerBooking(name , email,cName,boughtTickets,true );
                //store in ArryLists
                bookingEvents.add(Booking1);

                //5.5)Updating the number of tickets booked
                int tickets = 0;
                tickets = eventsBooked.get(search).getNumberOfTicketsBooked();
                tickets = boughtTickets + tickets;
                eventsBooked.get(search).setNumberOfTicketsBooked(tickets);
            }

        }
    }

    //Searching for event 
    public int getEventBooking(String eName , String eDay)
    {
        int search = 99;
        for (int count = 0; count < eventsBooked.size(); count++)
        {
            if (eName.equalsIgnoreCase(eventsBooked.get(count).getName()))
            {
                search = count; 
            }
            if (eDay.equalsIgnoreCase(eventsBooked.get(count).getDay()))
            {
                search = count;
            } 
        }
        return search;
    }
    
    public void cancelBooking()
    {
        Scanner scan = new Scanner(System.in);
        String name , comedian; 
        int search;
        CustomerBooking save = null;
        boolean found = false;
        
        //6.)Cancel a booking
        System.out.println("\nCanceling a booking...");
        //6.1)Input customer name
        System.out.println("\nInput your name: ");
        name = scan.nextLine();

        for ( CustomerBooking Booking1 : bookingEvents)
        {
            if (name.equalsIgnoreCase(Booking1.getName()))
            {
                save = Booking1;//save to customers name here to be deleted later
                found = true;

            }
        }
        //6.2)Search customer
        if (found) // found == true
        {
            System.out.print("Input name of comedian you were going to attend:");
            comedian = scan.nextLine();

            search = getComedianName(comedian);
            if(comedian.equalsIgnoreCase(save.getComedianName()))
            {
                //6.3 if match , delete customer from arraylists booking
                System.out.println("The customer " + save.getName() + " will now be cancelled from the event");
                bookingEvents.remove(save);

                if (search == 99)
                {
                    System.out.println("Sorry there is no comedian by this name");
                }
                else
                {
                    System.out.println("Removing purchased ticketed");
                    //6.4)Decrease the amount of tickets booked in the events ArrayList
                    int tickets = 0;
                    tickets = eventsBooked.get(search).getNumberOfTicketsBooked();
                    tickets =  tickets - save.getBoughtTickets();
                    eventsBooked.get(search).setNumberOfTicketsBooked(tickets);
                }
            }
            else
            {
                System.out.println("There is no customer with this name");
            }

        }
    }

    public int getComedianName(String comedian)
    {
        int search = 99;
        for (int count = 0; count < eventsBooked.size(); count++)
        {
            if (comedian.equalsIgnoreCase(eventsBooked.get(count).getName()))
            {
                search = count; 
            }

        }
        return search;
    }

    //Personal events 
    public void eGifts()
    {
        Scanner scan = new Scanner(System.in); 
        String to , from , email , message , name;
        int amount = 0 , search , discount;
        
        //7.)Buy a eGift voucher
        System.out.println("Buy an e-Gift voucher  for a family of friend");
        System.out.println("Any amount up to €250 sent directly to them via email");
        System.out.println("This e-Gift voucher can be used for any event !");

        //7.1)Input details
        System.out.print("\nTo (recipient): ");
        to = scan.nextLine();

        System.out.print("From (sender): ");
        from = scan.nextLine();

        System.out.print("Email (sender): ");
        email = scan.nextLine();

        System.out.print("Message: ");
        message = scan.nextLine(); 

        System.out.print("Enter amount: ");
        amount = scan.nextInt();
        scan.nextLine();

        if ( amount < 250 )
        {
            System.out.print("You have exceed the total amount");
            System.out.print(" Please re-enter the amount: ");
            amount = scan.nextInt();
        }

        System.out.println("If your attending an event tonight input your name: ");
        name = scan.nextLine();

        //7.2)Search if attending event
        search = getTopUp(name);
        if (search == 99)
        {
            System.out.println("The total amount is" + amount );

        }
        else 
        {
            //7.3)Add a €20 top up
            System.out.println("Congradulations" + name + "you have recevied an extra 20 top up on your gift voucher");
            discount = eventsBooked.get(search).topUpeGift();
            System.out.println(discount);

        }

    }

    public int getTopUp(String name)
    {
        int search = 99;
        for (int count = 0; count < bookingEvents.size(); count++)
        {
            if (name.equalsIgnoreCase(bookingEvents.get(count).getName()))
            {
                search = count; 
            }

        }
        return search;
    }

    //Personal customer 
    public void Snack()
    {
        Scanner scan = new Scanner(System.in); 
        int input , search; 
        double discount;
        String name;

        //8.)Buy a snack box
        System.out.print("Choose from a selection of 3 party snack boxes including a drink,sweet and a pack of crisps for only €10!");

        System.out.println("\nSelection: 1");
        System.out.println("Drink: Coca Cola");
        System.out.println("Sweet: Haribo's");
        System.out.println("Crisps: Doritos");

        System.out.println("\nSelection: 2");
        System.out.println("Drink: Fanta");
        System.out.println("Sweet: Squashies");
        System.out.println("Crisps: Pringles");

        System.out.println("\nSelection: 3");
        System.out.println("Drink: 7up");
        System.out.println("Sweet: Maltesers");
        System.out.println("Crisps: Tayto");

        //8.1)Input a selection number
        System.out.print("Input a selection number: ");
        input = scan.nextInt();
        scan.nextLine();

        System.out.println("\nDisplaying summary of order.....");
        if (input == 1)
        {
            System.out.println("You have chosen Selection 1");
            System.out.println("Drink: Coca Cola");
            System.out.println("Sweet: Haribo's");
            System.out.println("Crisps: Doritos");
            System.out.println("The total price is : €10");
        }
        if(input == 2)
        {
            System.out.println("You have chosen Selection 2");
            System.out.println("Drink: Fanta");
            System.out.println("Sweet: Squashies");
            System.out.println("Crisps: Pringles");
            System.out.println("The total price is : €10");
        }
        if(input ==3)
        {
            System.out.println("You have chosen Selection 3");
            System.out.println("Drink: 7up");
            System.out.println("Sweet: Maltesers");
            System.out.println("Crisps: Tayto");
            System.out.println("The total price is : €10");
        }

        System.out.println("If your attending an event tonight input your name: ");
        name = scan.nextLine();
        
        //8.2)Search for customer name
        search = getTopUp(name);
        if (search == 99 )
        {
            System.out.println("Sorry there is no customer by this name ");
        }
        else
        {
            //8.3)Apply discount 20%
            System.out.println("Congrats you have recevied a 20% discount on your order");
            System.out.println("Thank you for shopping with us , enjoy your show !");
            discount = bookingEvents.get(search).discount();
            System.out.println(discount);
        }
    }

    public void displayEvents()
    {
        System.out.println("\n\nDisplay the event schedule for the week");

        for (int count = 0; count < EVENT_SIZE; count++)
        {
            eventsBooked.get(count).display();
        }
    }

    public static void main(String[] args){
        new EventDriver();

    }
}
