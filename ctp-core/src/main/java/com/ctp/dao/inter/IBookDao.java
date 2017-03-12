package com.ctp.dao.inter;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TBook;
import com.ctp.model.vo.PageParam;

/**
 * Created by Administrator on 2017/3/12 0012.
 */
public interface IBookDao {

    /**
     * 分页查询
     * @param page
     * @return
     */
    ListPage queryByPage(PageParam page);

    /**
     * 获取书籍
     * @param bookId
     * @return
     */
    TBook getBook(String bookId);
}
