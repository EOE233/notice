package com.zhbit.web.controller;


import com.zhbit.bean.Notice;
import com.zhbit.bean.Type;
import com.zhbit.bean.User;
import com.zhbit.biz.NoticeBiz;
import com.zhbit.biz.TypeBiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class NoticeServlet extends HttpServlet {

    private static final long serialVersionUID = 2884006783308811985L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        if ("showNotice".equals(method)) {
            doShowNotice(request, response);
        } else if ("showNoticeDetail".equals(method)) {
            doShowNoticeDetail(request, response);
        } else if ("showAllNotice".equals(method)) {
            doShowAllNotice(request, response);
        } else if ("showAddNotice".equals(method)) {
            doShowAddNotice(request, response);
        } else if ("addNotice".equals(method)) {
            doAddNotice(request, response);
        } else if ("deleteNotice".equals(method)) {
            doDeleteNotice(request, response);
        } else if ("showNoticeDetailForModify".equals(method)) {
            doShowNoticeDetailForModify(request, response);
        } else if ("updateNotice".equals(method)) {
            doUpdateNotice(request, response);
        } else if ("getNoticeByNameM".equals(method)) {
            getNoticeByNameM(request, response);
        } else if ("getNoticeByTime".equals(method)) {
            getNoticeByTime(request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    /**
     * 通过公告类型显示通知
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doShowNotice(HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        NoticeBiz noticeBiz = new NoticeBiz();
        List<Notice> list = noticeBiz.getNoticeByTypeId(typeId);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/page/portal/showNoticeByType.jsp").forward(request, response);
    }

    /**
     * 显示公告详细信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doShowNoticeDetail(HttpServletRequest request,
                                    HttpServletResponse response) throws ServletException, IOException {
        int noticeId = Integer.parseInt(request.getParameter("noticeId"));
        NoticeBiz noticeBiz = new NoticeBiz();
        Notice notice = noticeBiz.getNoticeById(noticeId);
        request.setAttribute("notice", notice);
        request.getRequestDispatcher("/page/portal/showNoticeDetailByID.jsp").forward(request, response);
    }

    /**
     * 跳转到修改页面前获取通知信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doShowNoticeDetailForModify(HttpServletRequest request,
                                             HttpServletResponse response) throws ServletException, IOException {
        int noticeId = Integer.parseInt(request.getParameter("noticeId"));
        TypeBiz typeBiz = new TypeBiz();
        List<Type> typeList = typeBiz.getAllType();
        request.setAttribute("list", typeList);
        NoticeBiz noticeBiz = new NoticeBiz();
        Notice notice = noticeBiz.getNoticeById(noticeId);
        request.setAttribute("notice", notice);
        request.getRequestDispatcher("page/system/noticeEdit.jsp").forward(request, response);
    }

    /**
     * 修改通知
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doUpdateNotice(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String editor = request.getParameter("editor");
        String content = request.getParameter("content");
        int type = Integer.parseInt(request.getParameter("type"));
        int noticeId = Integer.parseInt(request.getParameter("noticeId"));
        //测试
        java.sql.Date date = new java.sql.Date(new Date().getTime());
        Notice notice = new Notice();
        notice.setnNo(noticeId);
        notice.setnContent(content);
        notice.setnEditor(editor);
        notice.setnTitle(title);
        notice.setnType(type);
        //测试
        notice.setnCreateTime(date);
        NoticeBiz noticeBiz = new NoticeBiz();
        if (noticeBiz.updateNotice(notice)) {
            List<Notice> list = noticeBiz.getAllNotice();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/page/system/showAllNoticeList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/page/system/error.jsp").forward(request, response);
        }
    }

    /**
     * 删除通知
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doDeleteNotice(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        int noticeId = Integer.parseInt(request.getParameter("noticeId"));
        NoticeBiz noticeBiz = new NoticeBiz();
        if (noticeBiz.deleteNotice(noticeId)) {
            List<Notice> list = noticeBiz.getAllNotice();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/page/system/showAllNoticeList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/page/system/error.jsp").forward(request, response);
        }
    }

    /**
     * 跳转到添加通知页面前获取信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doShowAddNotice(HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException {
        TypeBiz typeBiz = new TypeBiz();
        List<Type> typeList = typeBiz.getAllType();
        request.setAttribute("list", typeList);
        request.getRequestDispatcher("page/system/noticeAdd.jsp").forward(request, response);
    }

    /**
     * 添加通知
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doAddNotice(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String editor = request.getParameter("editor");
        String content = request.getParameter("content");
        int type = Integer.parseInt(request.getParameter("type"));

        //测试
        java.sql.Date date = new java.sql.Date(new Date().getTime());

        Notice notice = new Notice();
        User user = (User) request.getSession().getAttribute("LOGINED_USER");
        notice.setnContent(content);
        notice.setnEditor(editor);
        notice.setnTitle(title);
        notice.setnType(type);
        notice.setnCreateTime(date);
        notice.setuNo(user.getuNo());
        NoticeBiz noticeBiz = new NoticeBiz();
        if (noticeBiz.addNotice(notice)) {
            List<Notice> list = noticeBiz.getAllNotice();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/page/system/showAllNoticeList.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/page/system/error.jsp").forward(request, response);
        }
    }

    /**
     * 显示所有通知
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doShowAllNotice(HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException {
        NoticeBiz noticeBiz = new NoticeBiz();
        List<Notice> list = noticeBiz.getAllNotice();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/page/system/showAllNoticeList.jsp").forward(request, response);
    }

    /**
     * 根据通知名称模糊查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void getNoticeByNameM (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("测试");
        String Ntitle = request.getParameter("Ntitle");
        NoticeBiz noticeBiz = new NoticeBiz();
        List<Notice> list = noticeBiz.getNoticeByNameM(Ntitle);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/page/portal/showNoticeM.jsp").forward(request, response);
    }

    /**
     * 根据时间区间获取通知
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void getNoticeByTime (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sTime = request.getParameter("startTime");
        String eTime = request.getParameter("endTime");
        NoticeBiz noticeBiz = new NoticeBiz();
        List<Notice> list = noticeBiz.getNoticeByTime(sTime, eTime);
        request.setAttribute("list", list);
        request.getRequestDispatcher("page/portal/showNoticeByTime.jsp").forward(request, response);
    }
}
