package com.ctp.controller.admin;

import com.ctp.controller.config.ControllerName;
import com.ctp.controller.config.PagePath;
import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TBook;
import com.ctp.model.po.TUser;
import com.ctp.model.vo.BookVO;
import com.ctp.model.vo.UserVO;
import com.ctp.service.admin.inter.IAdminBookService;
import com.ctp.service.config.ServiceName;
import com.ctp.utils.ContextUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zyy on 2017/3/12 0012.
 */
@Controller
@RequestMapping(ControllerName.ADMIN_BOOK)
public class AdminBookController {

    private Logger logger = Logger.getLogger(AdminUserController.class);
    @Resource(name = ServiceName.ADMIN_BOOK)
    private IAdminBookService adminBookService;

    /**
     * 跳转到书籍列表
     * @param request
     * @param response
     * @param book
     * @return
     */
    @RequestMapping(value=ControllerName.ADMIN_BOOK_LIST,method={RequestMethod.GET,RequestMethod.POST})
    public String toUserPage(HttpServletRequest request, HttpServletResponse response, BookVO book){
        ListPage listPage = adminBookService.queryBookByPage(book);
        request.setAttribute("listPage", listPage);
        request.setAttribute("book",book);
        return PagePath.BOOK_LIST.toString();
    }

    /**
     * 书籍编辑界面
     * @param book
     * @return
     */
    @RequestMapping(value=ControllerName.ADMIN_BOOK_EDIT,method=RequestMethod.POST)
    public String toBookEditPage(BookVO book){
        HttpServletRequest request = ContextUtils.getRequest();
        TBook tBook = adminBookService.getBook(book.getId());
        tBook = tBook == null ? tBook = new TBook() : tBook;
        request.setAttribute("book",tBook);
        return PagePath.BOOK_EDIT.toString();
    }
}
