package com.ctp.dao.impl;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.dao.base.inter.IBaseDao;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IBookDao;
import com.ctp.model.po.TBook;
import com.ctp.model.po.TUser;
import com.ctp.model.vo.PageParam;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by zyy on 2017/3/12 0012.
 */
@Repository(DaoName.BOOK)
public class BookDaoImpl implements IBookDao{

    @Resource(name= DaoName.BASE)
    private IBaseDao baseDao;

    @Override
    public ListPage queryByPage(PageParam page) {
        return baseDao.queryByHql(page.getPageNo(), page.getPageSize(), page.getCount(), page.getQuery(),page.getParams());
    }

    @Override
    public TBook getBook(String bookId) {
        return baseDao.get(TBook.class, bookId);
    }
}
