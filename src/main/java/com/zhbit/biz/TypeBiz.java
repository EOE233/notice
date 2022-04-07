package com.zhbit.biz;

import com.zhbit.bean.Type;
import com.zhbit.mapper.TypeMapper;
import com.zhbit.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yanea
 * 2022/3/28 0:00
 */
@Service
public class TypeBiz {
    SqlSession session = SqlSessionUtil.creat();

    TypeMapper mapper = session.getMapper(TypeMapper.class);

    /**
     * 获取所有通知类型
     */
    public List<Type> getAllType() {
        return mapper.getAllTypeList();
    }

    /**
     * 通过通知类型编号删除通知类型
     */
    public int delTypeByID(int tNo) {
        return mapper.deleteType(tNo);
    }

    /**
     * 通过公告类型编号修改公告
     */
    public int updateTypeByID(int tNo, String tTypeName) {
        return mapper.alterType(tNo, tTypeName);
    }

    /**
     * 通过公告类型编号获取公告类型
     */
    public Type getTypeByID(int tNo) {
        return mapper.getTypeByID(tNo);
    }

    /**
     * 添加公告类型
     */
    public int addType(String tTypeName) {
        return mapper.addType(tTypeName);
    }
}
