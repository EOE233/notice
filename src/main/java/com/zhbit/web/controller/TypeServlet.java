package com.zhbit.web.controller;


import com.zhbit.bean.Notice;
import com.zhbit.bean.Type;
import com.zhbit.biz.NoticeBiz;
import com.zhbit.biz.TypeBiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TypeServlet extends HttpServlet {
    private static final long serialVersionUID = 3874739343783059139L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("method");
        if ("doShowAllType".equals(method)) {
            doShowAllType(request, response);
        } else if ("doDelTypeByID".equals(method)) {
            doDelTypeByID(request, response);
        } else if ("doUpdateType".equals(method)) {
            doUpdateType(request, response);
        } else if ("login".equals(method)){
            doLogin(request, response);
            request.getRequestDispatcher("/page/portal/index.jsp").forward(request, response);
        } else if ("doShowDetailForModify".equals(method)) {
            doShowDetailForModify(request, response);
        } else if ("addType".equals(method))
            addType(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    /**
     * 显示所有通知类型
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doShowAllType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypeBiz typeBiz = new TypeBiz();
        List<Type> list = typeBiz.getAllType();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/page/system/type_info.jsp").forward(request, response);
    }

    /**
     * 通过通知类型编号删除通知类型
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public void doDelTypeByID(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("测试");
        TypeBiz typeBiz = new TypeBiz();
        int Tno = Integer.parseInt(request.getParameter("Tno"));
        int result = typeBiz.delTypeByID(Tno);
        if (result == 1) {
            System.out.println("删除成功");
            doShowAllType(request, response);
        } else {
            System.out.println("删除失败");
            doShowAllType(request, response);
        }
    }

    /**
     * 通过类型编号修改通知类型
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    public void doUpdateType(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        TypeBiz typeBiz = new TypeBiz();
        int Tno = Integer.parseInt(request.getParameter("Tno"));
        String TtypeName = request.getParameter("TtypeName");
        int result = typeBiz.updateTypeByID(Tno, TtypeName);
        if (result == 1) {
            System.out.println("修改成功");
            doShowAllType(request, response);
        } else {
            System.out.println("修改失败");
            doShowAllType(request, response);
        }
    }

    /**
     * 跳转到后台主页前获取数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doLogin (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypeBiz typeBiz = new TypeBiz();
        List<Type> typeList = typeBiz.getAllType();
        request.setAttribute("list", typeList);
    }

    /**
     * 获取公告类型的详细信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doShowDetailForModify (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("测试");
//        String tno = request.getParameter("Tno");
//        System.out.println(tno);
        int Tno = Integer.parseInt(request.getParameter("Tno"));
        TypeBiz typeBiz = new TypeBiz();

        Type type = typeBiz.getTypeByID(Tno);
        request.setAttribute("type", type);
        request.getRequestDispatcher("page/system/typeEdit.jsp").forward(request, response);
    }

    /**
     * 添加公告类型
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addType (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("测试");
        String TtypeName = request.getParameter("TtypeName");
        TypeBiz typeBiz = new TypeBiz();
        int result = typeBiz.addType(TtypeName);
        if (result == 1) {
            System.out.println("成功");
            doShowAllType(request, response);
        } else {
            System.out.println("失败");
            doShowAllType(request, response);
        }
    }

}
