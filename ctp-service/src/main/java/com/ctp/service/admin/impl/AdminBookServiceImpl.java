package com.ctp.service.admin.impl;

import com.ctp.dao.base.impl.ListPage;
import com.ctp.dao.config.DaoName;
import com.ctp.dao.inter.IBookDao;
import com.ctp.model.po.TBook;
import com.ctp.model.po.TBookList;
import com.ctp.model.po.TBookReview;
import com.ctp.model.po.TUser;
import com.ctp.model.vo.BookVO;
import com.ctp.model.vo.PageParam;
import com.ctp.service.admin.inter.IAdminBookService;
import com.ctp.service.config.ReturnMsg;
import com.ctp.service.config.ServiceName;
import com.ctp.service.config.SessionEnum;
import com.ctp.utils.ContextUtils;
import com.ctp.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zyy on 2017/3/12 0012.
 */
@Service(ServiceName.ADMIN_BOOK)
public class AdminBookServiceImpl implements IAdminBookService{

    @Resource(name = DaoName.BOOK)
    private IBookDao bookDao;

    @Override
    public ListPage queryBookByPage(BookVO book) {
        PageParam page = new PageParam();
        StringBuilder query = new StringBuilder();
        StringBuilder count = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        query.append("SELECT b FROM TBook b WHERE 1=1 ");
        count.append("SELECT COUNT(b.fid) FROM TBook b WHERE 1=1 ");

        if(!StringUtils.isEmpty(book.getName())){
            String filter = " AND b.fname LIKE :name ";
            query.append(filter);
            count.append(filter);
            params.put("name", "%" + book.getName() + "%");
        }
        if(book.isSort()) {
            query.append("  ORDER BY b.fcreatedate desc ");
        }
        page.setPageNo(book.getPageNo());
        page.setPageSize(book.getPageSize());
        page.setQuery(query.toString());
        page.setCount(count.toString());
        page.setParams(params);

        return bookDao.queryByPage(page);
    }

    @Override
    public TBook getBook(String bookId) {
        return bookDao.getBook(bookId);
    }

    @Override
    public void saveBook(TBook book) {
        String year = book.getFpublishyearstr();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        try {
            book.setFpublishyear(sdf.parse(year).getTime()/1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(book.getImagefile() != null){
            book.setFimage(book.getImagefile().getBytes());
        }

        book.setFcreatedate(new Date().getTime()/1000);
        if(StringUtils.isEmpty(book.getFid())){
            bookDao.saveBook(book);
        }else{
            bookDao.update(book);
        }

    }



    @Override
    public String deleteBook(BookVO book) {
        String delBook = " DELETE TBook b where b.fid in ( "+ book.getIdsStr()+" )";
        bookDao.deleteBook(delBook, null);
        return ReturnMsg.DEL_SUCCESS.toString();
    }

    @Override
    public ListPage getMyBooks(String userId) {

        PageParam page = new PageParam();
        StringBuilder query = new StringBuilder();
        StringBuilder count = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        query.append("SELECT b FROM TBook b WHERE  b.fid in ( ")
                .append("SELECT bl.fbookID FROM TBookList bl WHERE bl.fuserID = '").append(userId).append(" ') ");
        count.append("SELECT COUNT(b.fid) FROM TBook b WHERE b.fid in ( ")
                .append("SELECT bl.fbookID FROM TBookList bl WHERE bl.fuserID = '").append(userId).append(" ') ");

        page.setPageNo(1);
        page.setPageSize(10);
        page.setQuery(query.toString());
        page.setCount(count.toString());
        page.setParams(params);

        return bookDao.queryByPage(page);
    }

    @Override
    public void addMyBook(TBookList bookList) {
        TUser user = (TUser) ContextUtils.getRequest().getSession().getAttribute(SessionEnum.APPUSER.toString());
        if (user != null) {
            bookList.setFuserID(user.getFid());
        }
        bookDao.saveBookList(bookList);
    }

    @Override
    public void addBookReview(TBookReview bookReview) {
        TUser user = (TUser) ContextUtils.getRequest().getSession().getAttribute(SessionEnum.APPUSER.toString());
        if (user != null) {
            bookReview.setFuserID(user.getFid());
        }
        bookDao.saveBookReview(bookReview);
    }

    @Override
    public ListPage getBookReviews(String bookId) {

        PageParam page = new PageParam();
        StringBuilder query = new StringBuilder();
        StringBuilder count = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        query.append("SELECT br,u FROM TBookReview br,TUser u WHERE  b.fuserID = u.fid AND  br.fbookID = :bookId ");
        count.append("SELECT COUNT(br.fid) FROM TBookReview br,TUser u WHERE  b.fuserID = u.fid AND  br.fbookID = :bookId ");
        params.put("bookId",bookId);
        page.setPageNo(1);
        page.setPageSize(10);
        page.setQuery(query.toString());
        page.setCount(count.toString());
        page.setParams(params);

        return bookDao.queryByPage(page);
    }
}
