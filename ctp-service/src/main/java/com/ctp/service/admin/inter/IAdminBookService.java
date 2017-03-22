package com.ctp.service.admin.inter;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TBook;
import com.ctp.model.po.TUser;
import com.ctp.model.vo.BookVO;

/**
 * Created by Administrator on 2017/3/12 0012.
 */
public interface IAdminBookService {
    /**
     * 分页按条件获取书籍
     * @param book
     * @return
     */
    ListPage queryBookByPage(BookVO book);
    /**
     * 获取书籍
     * @param bookId
     * @return
     */
    TBook getBook(String bookId);

    /**
     * 保存书籍
     * @param book
     */
    void saveBook(TBook book);

    String deleteBook(BookVO book);

    ListPage getMyBooks(String userId);
}
