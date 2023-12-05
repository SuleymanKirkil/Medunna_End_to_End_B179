package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoomPojo implements Serializable {
	private int roomNumber;
	private String roomType;
	private boolean status;
	private Object price;
	private String description;

	public RoomPojo() {
	}

	public RoomPojo(int roomNumber, String roomType, boolean status, Object price, String description) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.status = status;
		this.price = price;
		this.description = description;
	}

	public void setRoomNumber(int roomNumber){
		this.roomNumber = roomNumber;
	}

	public int getRoomNumber(){
		return roomNumber;
	}

	public void setRoomType(String roomType){
		this.roomType = roomType;
	}

	public String getRoomType(){
		return roomType;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	public void setPrice(Object price){
		this.price = price;
	}

	public Object getPrice(){
		return price;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	@Override
 	public String toString(){
		return 
			"RoomPojo{" + 
			"roomNumber = '" + roomNumber + '\'' + 
			",roomType = '" + roomType + '\'' + 
			",status = '" + status + '\'' + 
			",price = '" + price + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}