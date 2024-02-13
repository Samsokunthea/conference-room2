import java.util.ArrayList;

public class CustomerService {

    private ArrayList<Customer> customers;

    public CustomerService(){
        customers=new ArrayList<>();
    }

    public void AddCustomer(Customer customer){
        customers.add(customer);
    }

    public Customer getCustomerByRoomId(int roomId){
        for(var cu : customers){
            if(cu.getRoomId()==roomId){
                return cu;
            }
        }
        return null;
    }
    public Customer getCustomerByName(String customerName){
        for(var cu : customers){
            if(cu.getName().equals(customerName)){
                return cu;
            }
        }
        return null;
    }
}
