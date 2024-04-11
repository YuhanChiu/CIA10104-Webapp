package com.roomtypephoto.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.roomtypephoto.model.RoomTypePhotoJDBCDAO;
import com.roomtypephoto.model.RoomTypePhotoVO;

@WebServlet("/roomtypephoto.do")
@MultipartConfig
public class RoomTypePhotoServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("getAll".equals(action)) {
            /***************************開始查詢資料 ****************************************/
        	RoomTypePhotoJDBCDAO dao = new RoomTypePhotoJDBCDAO();
            List<RoomTypePhotoVO> list = dao.getAll();

            /***************************查詢完成,準備轉交(Send the Success view)*************/
            HttpSession session = req.getSession();
            session.setAttribute("list", list);    // 資料庫取出的list物件,存入session
            // Send the Success view
            String url = "/roomtypephoto/listAllEmp2_getFromSession.jsp";
            RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交listAllEmp2_getFromSession.jsp
            successView.forward(req, res);
            return;
        }


        if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

            List<String> errorMsgs = new LinkedList<String>();
            // Store this set in the request scope, in case we need to
            // send the ErrorPage view.
            req.setAttribute("errorMsgs", errorMsgs);

                /***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
                String str = req.getParameter("roomTypePhotoId");
                if (str == null || (str.trim()).length() == 0) {
                //上方code是為防呆用的，p.64驗證的部分/防止空值 || 驗證
                    errorMsgs.add("請輸入房型圖片編號");
                }
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    RequestDispatcher failureView = req
                            .getRequestDispatcher("select_page.jsp");
                    failureView.forward(req, res);
                    return;//程式中斷
                }
                
                Integer roomTypePhotoId = null;
                try {
                	roomTypePhotoId = Integer.valueOf(str); //把字串轉成integer
                } catch (Exception e) {
                    errorMsgs.add("房型圖片編號格式不正確"); //字串轉不過
                }
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    RequestDispatcher failureView = req
                            .getRequestDispatcher("select_page.jsp");
                    failureView.forward(req, res);
                    return;//程式中斷
                }
                
                /***************************2.開始查詢資料*****************************************/
                RoomTypePhotoJDBCDAO dao = new RoomTypePhotoJDBCDAO();
                RoomTypePhotoVO roomtypephotoVO = dao.findByPrimaryKey(Integer.valueOf(req.getParameter("roomTypePhotoId")));
                if (roomtypephotoVO == null) {
                    errorMsgs.add("查無資料");
                }
                // Send the use back to the form, if there were errors
                if (!errorMsgs.isEmpty()) {
                    RequestDispatcher failureView = req
                            .getRequestDispatcher("select_page.jsp");
                    failureView.forward(req, res);
                    return;//程式中斷
                }
                
                /***************************3.查詢完成,準備轉交(Send the Success view)*************/
                req.setAttribute("roomtypephotoVO", roomtypephotoVO); // 資料庫取出的empVO物件,存入req
                String url = "listOneRoomTypePhoto.jsp";
                RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneRoomTypePhoto.jsp
                successView.forward(req, res);
        }
    }
}