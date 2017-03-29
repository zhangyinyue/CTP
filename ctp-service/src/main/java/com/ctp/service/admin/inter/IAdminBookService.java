package com.ctp.service.admin.inter;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TBook;
import com.ctp.model.po.TBookList;
import com.ctp.model.po.TBookReview;
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

    /**
     * 删除书籍
     * @param book
     * @return
     */
    String deleteBook(BookVO book);

    /**
     * 获取我的书架书籍
     * @param userId
     * @return
     */
    ListPage getMyBooks(String userId);

    /**
     * 添加书籍到我的书架
     * @param bookList
     */
    void addMyBook(TBookList bookList);

    /**
     * 添加书评
     * @param bookReview
     */
    void addBookReview(TBookReview bookReview);

    /**
     * 获取书箱相关书评
     * @param bookId
     * @return
     */
    ListPage getBookReviews(String bookId);


}
