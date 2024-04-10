package com.roomtypephoto.model;

import java.util.List;

public class RoomTypePhotoService {

	private RoomTypePhotoDAO_interface dao;

	public RoomTypePhotoService() {
		dao = new RoomTypePhotoJDBCDAO();
	}

	public RoomTypePhotoVO addEmp(Integer roomTypePhotoId, Integer roomTypeId,
			byte[] roomTypePhoto, Boolean roomTypePhotoState) {

		RoomTypePhotoVO roomTypePhotoVO = new RoomTypePhotoVO();

		roomTypePhotoVO.setRoomTypePhotoId(roomTypePhotoId);
		roomTypePhotoVO.setRoomTypeId(roomTypeId);
		roomTypePhotoVO.setRoomTypePhoto(roomTypePhoto);
		roomTypePhotoVO.setRoomTypePhotoState(roomTypePhotoState);
		dao.insert(roomTypePhotoVO);

		return roomTypePhotoVO;
	}


	public void addRoomtypephoto(RoomTypePhotoVO roomTypePhotoVO) {
		dao.insert(roomTypePhotoVO);
	}
	
	public RoomTypePhotoVO updateRoomtypephoto(Integer roomTypePhotoId, Integer roomTypeId,
			byte[] roomTypePhoto, Boolean roomTypePhotoState) {

		RoomTypePhotoVO roomTypePhotoVO = new RoomTypePhotoVO();

		roomTypePhotoVO.setRoomTypePhotoId(roomTypePhotoId);
		roomTypePhotoVO.setRoomTypeId(roomTypeId);
		roomTypePhotoVO.setRoomTypePhoto(roomTypePhoto);
		roomTypePhotoVO.setRoomTypePhotoState(roomTypePhotoState);
		dao.update(roomTypePhotoVO);

		return dao.findByPrimaryKey(roomTypePhotoId);
	}
	

	public void updateRoomtypephoto(RoomTypePhotoVO roomTypePhotoVO) {
		dao.update(roomTypePhotoVO);
	}


	public RoomTypePhotoVO getOneRoomtypephoto(Integer empno) {
		return dao.findByPrimaryKey(empno);
	}

	public List<RoomTypePhotoVO> getAll() {
		return dao.getAll();
	}
}
