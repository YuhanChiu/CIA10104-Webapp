package com.room.model;

import java.util.*;

public interface RoomDAO_interface {
          public void insert(RoomVO roomVO);
          public void update(RoomVO roomVO);
          public RoomVO findByPrimaryKey(Integer roomId);
          public List<RoomVO> getAll();
        //萬用複合查詢(傳入參數型態Map)(回傳 List)
        //public List<RoomVO> getAll(Map<String, String[]> map); 
}
