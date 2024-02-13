import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Customer extends room{
    public String name;
    public String tel;
    public Customer(String name, String tel, String roomName, String roomType, int roomId, int capacity, String availabilitySchedule,double roomPrice){
        super(roomName,roomType,roomId,capacity,availabilitySchedule,roomPrice);
        this.name=name;
        this.tel=tel;
    }

    public Customer(String name,String tel){
        this.name=name;
        this.tel=tel;
    }
    public Customer(){

    }

    public String getName(){
        return name;
    }
    public String getTel(){
        return tel;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setTel(String tel){
        this.tel=tel;
    }

    public void show_cus_information(ArrayList<Customer> cus) {
        for (Customer c : cus) {
            System.out.printf("\n|%-19s |%-19s |%-19s |%-27s |%-16s |%-17s |%-18s |%-10s |%-15s", c.getName(), c.getTel(), c.getName(), c.getTel(), c.getRoomName(), c.getRoomId(), c.getRoomType(), c.getCapacity(), c.getAvailabilitySchedule(), c.getroomprice());
        }
    }
}