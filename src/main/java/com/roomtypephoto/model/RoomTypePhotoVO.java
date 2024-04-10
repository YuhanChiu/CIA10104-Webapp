package com.roomtypephoto.model;


import java.util.Arrays;


public class RoomTypePhotoVO implements java.io.Serializable{
	private Integer roomTypePhotoId;
	private Integer roomTypeId;
	private byte[] roomTypePhoto;
	private Boolean roomTypePhotoState;
	
	
	public Integer getRoomTypePhotoId() {
		return roomTypePhotoId;
	}
	public void setRoomTypePhotoId(Integer roomTypePhotoId) {
		this.roomTypePhotoId = roomTypePhotoId;
	}

	public Integer getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public byte[] getRoomTypePhoto() {
		return roomTypePhoto;
	}

	public void setRoomTypePhoto(byte[] roomTypePhoto) {
		this.roomTypePhoto = roomTypePhoto;
	}

	public Boolean getRoomTypePhotoState() {
		return roomTypePhotoState;
	}

	public void setRoomTypePhotoState(Boolean roomTypePhotoState) {
		this.roomTypePhotoState = roomTypePhotoState;
	}


	@Override
	public String toString() {
		return "RoomTypePhotoVO [roomTypePhotoId=" + roomTypePhotoId + ", roomTypeId=" + roomTypeId + ", roomTypePhoto="
				+ Arrays.toString(roomTypePhoto) + ", roomTypePhotoState=" + roomTypePhotoState + "]";

	}
}