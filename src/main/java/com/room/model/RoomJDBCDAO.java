package com.room.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomJDBCDAO implements RoomDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cia101g3?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "pk397rd321";

	private static final String INSERT_STMT = 
		"INSERT INTO room (roomId, roomTypeId, roomTypeSaleState, roomSaleState) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT roomId,roomTypeId,roomTypeSaleState,roomSaleState FROM room order by roomId";
	private static final String GET_ONE_STMT = 
		"SELECT roomId,roomTypeId,roomTypeSaleState,roomSaleState FROM room where roomId = ?";
	private static final String UPDATE = 
		"UPDATE room set roomId=?, roomTypeId=?, roomTypeSaleState=?, roomSaleState=? where roomId = ?";

	@Override
	public void insert(RoomVO roomVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, roomVO.getRoomId());
			pstmt.setInt(2, roomVO.getRoomTypeId());
			pstmt.setBoolean(3, roomVO.getRoomTypeSaleState());
			pstmt.setBoolean(4, roomVO.getRoomSaleState());


			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void update(RoomVO roomVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, roomVO.getRoomId());
			pstmt.setInt(2, roomVO.getRoomTypeId());
			pstmt.setBoolean(3, roomVO.getRoomTypeSaleState());
			pstmt.setBoolean(4, roomVO.getRoomSaleState());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public RoomVO findByPrimaryKey(Integer roomId) {

		RoomVO roomVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, roomId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// roomVo 也稱為 Domain objects
				roomVO = new RoomVO();
				roomVO.setRoomId(rs.getInt("roomId"));
				roomVO.setRoomTypeId(rs.getInt("roomTypeId"));
				roomVO.setRoomTypeSaleState(rs.getBoolean("roomTypeSaleState"));
				roomVO.setRoomSaleState(rs.getBoolean("roomSaleState"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return roomVO;
	}

	@Override
	public List<RoomVO> getAll() {
		List<RoomVO> list = new ArrayList<RoomVO>();
		RoomVO roomVO = null;

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
				roomVO = new RoomVO();
				roomVO.setRoomId(rs.getInt("roomId"));
				roomVO.setRoomTypeId(rs.getInt("roomTypeId"));
				roomVO.setRoomTypeSaleState(rs.getBoolean("roomTypeSaleState"));
				roomVO.setRoomSaleState(rs.getBoolean("roomSaleState"));

				list.add(roomVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

	public static void main(String[] args) {

		RoomJDBCDAO dao = new RoomJDBCDAO();

		// 新增
		RoomVO roomVO1 = new RoomVO();
		roomVO1.setRoomId(1);
		roomVO1.setRoomTypeId(1);
		roomVO1.setRoomTypeSaleState(true);
		roomVO1.setRoomSaleState(false);
		dao.insert(roomVO1);

		//修改
		RoomVO roomVO2 = new RoomVO();
		roomVO2.setRoomId(1);
		roomVO2.setRoomTypeId(1);
		roomVO2.setRoomTypeSaleState(true);
		roomVO2.setRoomSaleState(false);
		dao.update(roomVO2);

		
		
		// 查詢
		RoomVO roomVO3 = dao.findByPrimaryKey(1);
		System.out.print(roomVO3.getRoomId() + ",");
		System.out.print(roomVO3.getRoomTypeId() + ",");
		System.out.print(roomVO3.getRoomTypeSaleState() + ",");
		System.out.print(roomVO3.getRoomSaleState() + ",");
		System.out.println("---------------------");

		// 查詢
		List<RoomVO> list = dao.getAll();
		for (RoomVO aroom : list) {
			System.out.print(aroom.getRoomId() + ",");
			System.out.print(aroom.getRoomTypeId() + ",");
			System.out.print(aroom.getRoomTypeSaleState() + ",");
			System.out.print(aroom.getRoomSaleState() + ",");
			System.out.println();
		}
	}
}