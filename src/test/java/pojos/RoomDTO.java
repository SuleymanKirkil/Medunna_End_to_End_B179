package pojos;

import java.io.Serializable;

public class RoomDTO implements Serializable {
	private String createdBy;
	private String createdDate;
	private int id;
	private int roomNumber;
	private String roomType;
	private boolean status;
	private Object price;
	private String description;

	public RoomDTO() {
	}

	public RoomDTO(int roomNumber, String roomType, boolean status, Object price, String description) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.status = status;
		this.price = price;
		this.description = description;
	}

	public RoomDTO(String createdBy, String createdDate, int id, int roomNumber, String roomType, boolean status, Object price, String description) {
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.id = id;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.status = status;
		this.price = price;
		this.description = description;
	}


	public void setCreatedBy(String createdBy){
		this.createdBy = createdBy;
	}

	public String getCreatedBy(){
		return createdBy;
	}

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
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
			"RoomDTO{" + 
			"createdBy = '" + createdBy + '\'' + 
			",createdDate = '" + createdDate + '\'' + 
			",id = '" + id + '\'' + 
			",roomNumber = '" + roomNumber + '\'' + 
			",roomType = '" + roomType + '\'' + 
			",status = '" + status + '\'' + 
			",price = '" + price + '\'' + 
			",description = '" + description + '\'' + 
			"}";
		}
}