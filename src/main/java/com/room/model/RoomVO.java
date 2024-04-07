package com.room.model;


public class RoomVO implements java.io.Serializable{
	private Integer roomId;
	private Integer roomTypeId;
	private Boolean roomTypeSaleState;
	private Boolean roomSaleState;
	
	public Integer getRoomId() {
		return roomId;
	}
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	public Integer getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public Boolean getRoomTypeSaleState() {
		return roomTypeSaleState;
	}
	public void setRoomTypeSaleState(Boolean roomTypeSaleState) {
		this.roomTypeSaleState = roomTypeSaleState;
	}
	public Boolean getRoomSaleState() {
		return roomSaleState;
	}
	public void setRoomSaleState(Boolean roomSaleState) {
		this.roomSaleState = roomSaleState;
	}
	
	
	
}
	
	
	

	