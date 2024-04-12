package com.roomtypephoto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomTypePhotoJDBCDAO implements RoomTypePhotoDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cia101g3?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "pk397rd321";

	private static final String INSERT_STMT = "INSERT INTO roomTypePhoto (roomTypeId, roomTypePhoto) VALUES (?, ?)";
	private static final String GET_ALL_STMT = "SELECT roomTypePhotoId,roomTypeId,roomTypePhoto,roomTypePhotoState FROM roomTypePhoto order by roomTypePhotoId";
	private static final String GET_ONE_STMT = "SELECT roomTypePhotoId,roomTypeId,roomTypePhoto,roomTypePhotoState FROM roomTypePhoto where roomTypePhotoId = ?";
	private static final String UPDATE = "UPDATE roomTypePhoto set roomTypePhotoId=?,roomTypeId=?, roomTypePhoto=?, roomTypePhotoState=? where roomTypePhotoId = ?";

	@Override
	public void insert(RoomTypePhotoVO roomTypePhotoVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, roomTypePhotoVO.getRoomTypeId());
			pstmt.setBytes(2, roomTypePhotoVO.getRoomTypePhoto());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(RoomTypePhotoVO roomTypePhotoVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, roomTypePhotoVO.getRoomTypePhotoId());
			pstmt.setInt(2, roomTypePhotoVO.getRoomTypeId());
			pstmt.setBytes(3, roomTypePhotoVO.getRoomTypePhoto());
			pstmt.setBoolean(4, roomTypePhotoVO.getRoomTypePhotoState());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public RoomTypePhotoVO findByPrimaryKey(Integer roomTypePhotoId) {

		RoomTypePhotoVO roomTypePhotoVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, roomTypePhotoId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// roomTypePhoto 也稱為 Domain objects
				roomTypePhotoVO = new RoomTypePhotoVO();
				roomTypePhotoVO.setRoomTypePhotoId(rs.getInt("roomTypePhotoId"));
				roomTypePhotoVO.setRoomTypeId(rs.getInt("roomTypeId"));
				roomTypePhotoVO.setRoomTypePhoto(rs.getBytes("roomTypePhoto"));
				roomTypePhotoVO.setRoomTypePhotoState(rs.getBoolean("roomTypePhotoState"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return roomTypePhotoVO;
	}

	@Override
	public List<RoomTypePhotoVO> getAll() {
		List<RoomTypePhotoVO> list = new ArrayList<RoomTypePhotoVO>();
		RoomTypePhotoVO roomTypePhotoVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// roomVO 也稱為 Domain objects
				roomTypePhotoVO = new RoomTypePhotoVO();
				roomTypePhotoVO.setRoomTypePhotoId(rs.getInt("roomTypePhotoId"));
				roomTypePhotoVO.setRoomTypeId(rs.getInt("roomTypeId"));
				roomTypePhotoVO.setRoomTypePhoto(rs.getBytes("roomTypePhoto"));
				roomTypePhotoVO.setRoomTypePhotoState(rs.getBoolean("roomTypePhotoState"));

				list.add(roomTypePhotoVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static byte[] getPicByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}

	public static void main(String[] args) throws IOException {

		RoomTypePhotoJDBCDAO dao = new RoomTypePhotoJDBCDAO();

		// 新增
		RoomTypePhotoVO roomTypePhotoVO1 = new RoomTypePhotoVO();
		roomTypePhotoVO1.setRoomTypeId(1);

		byte[] pic = getPicByteArray("src/main/webapp/images/image1.jpg");
		roomTypePhotoVO1.setRoomTypePhoto(pic);
		dao.insert(roomTypePhotoVO1);

//		//修改
//		RoomTypePhotoVO roomTypePhotoVO2 = new RoomTypePhotoVO();
//		roomTypePhotoVO2.setRoomTypePhotoId(1);
//		roomTypePhotoVO2.setRoomTypeId(1);
//		byte[] pic1 = setPicByteArray("image1.jpg");
//		roomTypePhotoVO2.setRoomTypePhoto(pic1);
//		roomTypePhotoVO2.setRoomTypePhotoState(false);
//		dao.update(roomTypePhotoVO2);

//		// 查詢
//		RoomTypePhotoVO roomTypePhotoVO3 = dao.findByPrimaryKey(1);
//		System.out.print(roomTypePhotoVO3.getRoomTypePhotoId() + ",");
//		System.out.print(roomTypePhotoVO3.getRoomTypeId() + ",");
//		System.out.print(roomTypePhotoVO3.getRoomTypePhoto() + ",");
//		System.out.print(roomTypePhotoVO3.getRoomTypePhotoState() + ",");
//		System.out.println("---------------------");

//		// 查詢
//		List<RoomTypePhotoVO> list = dao.getAll();
//		for (RoomTypePhotoVO aroom : list) {
//			System.out.print(aroom.getRoomTypePhotoId() + ",");
//			System.out.print(aroom.getRoomTypeId() + ",");
//			System.out.print(aroom.getRoomTypePhoto() + ",");
//			System.out.print(aroom.getRoomTypePhotoState() + ",");
//			System.out.println();
//		}
	}
}