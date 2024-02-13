import javax.naming.Name;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner in=new Scanner(System.in);
    private static CustomerService customerService=new CustomerService();

    private static admin admin = new admin("Admin", "Admin");
    public static void main(String[] agrs){



        ArrayList<room> lst = new ArrayList<>();
        ArrayList<Customer> cus=new ArrayList<>();
        ArrayList<Customer> customerDetails=new ArrayList<>();
        room r=new room();
        Customer cu=new Customer();
        lst.add(new room("Room 1","Normal",1, 100, "Free", 100));
        lst.add(new room("Room 2", "VIP",2, 150, "Free", 150));
        lst.add(new room("Room 3", "VVIP", 3,200, "Free", 200));
        lst.add(new room("Room 4", "Normal",4, 100, "Free", 100));
        lst.add(new room("Room 5", "VIP", 5,150, "Free", 150));
        lst.add(new room("Room 6",  "VVIP",6 ,200, "Free", 200));
        lst.add(new room("Room 7",  "Normal",7, 100, "Free", 100));
        lst.add(new room("Room 8",  "VIP", 8,150, "Free", 150));
        lst.add(new room("Room 9",  "VVIP",9, 200, "Free", 200));
        lst.add(new room("Room 10" , "Normal",10, 100, "Free", 100));
        login();
        byte op;
        do{
            System.out.println("[1]. Display Room Detail");
            System.out.println("[2]. Add Customer");
            System.out.println("[3]. Booking");
            System.out.println("[4]. Cancel Booking");
            System.out.println("[5]. Exit");
            System.out.print("Option: "); op=in.nextByte();
            switch(op){
                case 1:
                    r.displayRoomDetails(lst);
                    break;
                case 2:
                    AddNewCustomer();
                    break;
                case 3:
                    booking(lst,customerDetails);
                    for(var cd : customerDetails){
                        System.out.println("Customer's Name: "+cd.getName());
                        System.out.println("Customer's Tel: "+cd.getTel());
                        System.out.println("Room type: "+cd.getRoomType());
                        System.out.println("Room Capacity: "+cd.getCapacity());
                        System.out.println("Room ID: "+cd.getRoomId());
                        System.out.println("Room Name: "+cd.getRoomName());
                        System.out.println("Room Price: "+cd.getroomprice());
                        System.out.println("Room Availability Schedule: "+cd.getAvailabilitySchedule());
                    }
                    break;
                case 4:
                    cancel(lst,customerDetails);
                    for(var cd : customerDetails){
                        System.out.println("Customer's Name: "+cd.getName());
                        System.out.println("Customer's Tel: "+cd.getTel());
                        System.out.println("Room type: "+cd.getRoomType());
                        System.out.println("Room Capacity: "+cd.getCapacity());
                        System.out.println("Room ID: "+cd.getRoomId());
                        System.out.println("Room Name: "+cd.getRoomName());
                        System.out.println("Room Price: "+cd.getroomprice());
                        System.out.println("Room Availability Schedule: "+cd.getAvailabilitySchedule());
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please choose again");
            }
        }while(op!=6);





        cu.show_cus_information(cus);




    }

    public static void booking(ArrayList<room> rooms,List<Customer> customerDetails){
        in.nextLine();
        System.out.printf("\nEnter Room ID: "); int id=in.nextInt();
        in.nextLine();
        System.out.printf("\nEnter CustomerName : ");String name=in.nextLine();
        for(var rm: rooms){
            if(rm.getRoomId()==id) {
                rm.setAvailabilitySchedule("Busy");
                rooms.set(rooms.indexOf(rm), rm);
                customerDetails.add(new Customer(name,customerService.getCustomerByName(name).getTel(),rm.getRoomName(), rm.roomType,rm.roomId,rm.getCapacity(),rm.availabilitySchedule,rm.getroomprice()));
                break;
            }
        }
    }

    public static void AddNewCustomer(){

        System.out.print("Enter Customer Name : ");
        String name=in.nextLine();
        in.nextLine();
        System.out.print("Enter PhoneNumber : ");
        String phone=in.nextLine();
        in.nextLine();
        System.out.println("CustomerName : " + name);
        System.out.println("PhoneNumber : " + phone);
        customerService.AddCustomer(new Customer(name,phone));
    }
    public static void showCustomerDetail(){

    }
    public static void cancel(ArrayList<room> rooms,ArrayList<Customer> customers){
        in.nextLine();
        System.out.printf("\nEnter RoomId: "); int roomid=in.nextInt();
        for(var rm: rooms){
            if(rm.getRoomId()==roomid) {
                rm.setAvailabilitySchedule("Free");
                rooms.set(rooms.indexOf(rm), rm);
                customers.remove(customers.indexOf(getCustomerDetailByRoomId(customers,rm.getRoomId())));
                break;
            }
        }
    }

    public static Customer getCustomerDetailByRoomId(ArrayList<Customer> customers,int roomid){
        for(var cs: customers){
            if(cs.getRoomId()==roomid){
                return cs;
            }
        }
        return null;
    }

    public static void login(){
        System.out.print("\n--------login--------");
        System.out.print("\nUsername: "); String username=in.nextLine();
        System.out.print("\nPassword: "); String password=in.nextLine();
        System.out.println("---------------------");
        int attemp=3;
        while(true){
            if (admin.authenticate(password)) {
                System.out.println("Login successful!");
                break;
            } else {
                attemp-=1;
                System.out.println("Login failed. Incorrect password, you got"+attemp+"attemp");
            }
        }
    }
}

