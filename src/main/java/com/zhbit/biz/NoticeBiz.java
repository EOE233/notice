package com.zhbit.biz;

import com.zhbit.bean.Notice;
import com.zhbit.mapper.NoticeMapper;
import com.zhbit.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Yanea
 * 2022/3/27 23:58
 */
public class NoticeBiz {
    SqlSession session = SqlSessionUtil.creat();
    NoticeMapper mapper = session.getMapper(NoticeMapper.class);

    /**
     * 显示所有通知
     */
    public List<Notice> getAllNotice() {
        return mapper.getAllNoticeList();
    }

    /**
     * 通过通知编号获取通知
     */
    public Notice getNoticeById(int noticeId) {
        return mapper.getNoticeById(noticeId);
    }

    /**
     * 通过公告类型获取通知
     */
    public List<Notice> getNoticeByTypeId(int typeId) {
        return mapper.getNoticeByType(typeId);
    }

    /**
     * 添加通知
     */
    public boolean addNotice(Notice notice) {
        return mapper.addNotice(notice);
    }

    /**
     * 更新通知
     */
    public boolean updateNotice(Notice notice) {
        return mapper.updateNotice(notice);
    }

    /**
     * 删除通知
     */
    public boolean deleteNotice(int noticeId) {
        return mapper.deleteNotice(noticeId);
    }

    /**
     * 模糊查询通知
     */
    public List<Notice> getNoticeByNameM(String nTitle) {
        return mapper.getNoticeByNameM(nTitle);
    }
}
