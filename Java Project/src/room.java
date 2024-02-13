import java.util.ArrayList;
public class room{
    public String roomName;
    public String roomType;
    public int roomId;
    public int capacity;
    public String availabilitySchedule;
    public double roomPrice;


public room (){
    
}
    public room(String roomName, String roomType, int roomId, int capacity, String availabilitySchedule,double roomPrice) {
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomId = roomId;
        this.capacity = capacity;
        this.availabilitySchedule = availabilitySchedule;
        this.roomPrice=roomPrice;
    }


    public String getRoomName() {
        return roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getAvailabilitySchedule() {
        return availabilitySchedule;
    }

    public double getroomprice(){
        return roomPrice;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAvailabilitySchedule(String availabilitySchedule) {
        this.availabilitySchedule = availabilitySchedule;
    }
    public void setroomprice(double roomprice){
        this.roomPrice=roomprice;
    }
    
    public void displayRoomDetails(ArrayList<room> lst) {
        System.out.printf("%-20s %-20s %-20s %-11s %-12s %-13s", "[Room Name]", "[Room Id]", "[Room Type]","[Capacity]","[Avalibity]","[Price]");
       for(room r : lst){
            System.out.printf("\n|%-20s |%-17s |%-18s |%-10s |%-12s |%-15s", r.getRoomName(), r.getRoomId(), r.getRoomType(), r.getCapacity(),r.getAvailabilitySchedule(),r.getroomprice());
       }
    }

}