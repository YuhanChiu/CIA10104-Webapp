package com.roomtypephoto.model;

import java.util.*;


public interface RoomTypePhotoDAO_interface {
          public void insert(RoomTypePhotoVO roomTypePhoto);
          public void update(RoomTypePhotoVO roomTypePhoto);
          public RoomTypePhotoVO findByPrimaryKey(Integer roomTypePhotoId);
          public List<RoomTypePhotoVO> getAll();
        //萬用複合查詢(傳入參數型態Map)(回傳 List)
        //public List<RoomTypePhotoVO> getAll(Map<String, String[]> map); 

}