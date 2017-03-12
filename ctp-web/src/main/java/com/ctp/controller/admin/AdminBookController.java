package com.ctp.controller.admin;

import com.ctp.controller.config.ControllerName;
import com.ctp.controller.config.ControllerReturnMsg;
import com.ctp.controller.config.PagePath;
import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TBook;
import com.ctp.model.po.TUser;
import com.ctp.model.vo.BookVO;
import com.ctp.model.vo.UserVO;
import com.ctp.service.admin.inter.IAdminBookService;
import com.ctp.service.config.ServiceName;
import com.ctp.utils.ContextUtils;
import com.ctp.utils.StringUtils;
import com.ctp.utils.UResponse;
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
    /**
     * 保存用户
     * @param book
     */
    @RequestMapping(value=ControllerName.ADMIN_BOOK_SAVE,method=RequestMethod.POST)
    public void toBookSave(TBook book,HttpServletResponse response){
        if(StringUtils.isEmpty(book.getFname())){
            logger.error("书名不能为空！");
            UResponse.writeFail(response, ControllerReturnMsg.NAME_NOT_NULL.toString());
            return;
        }
        try{
            adminBookService.saveBook(book);
            UResponse.writeSuccess(response, ControllerReturnMsg.OPERATOR_SUCCESS.toString());
        }catch(Exception e){
            logger.error(e.getMessage());
            UResponse.writeFail(response,  ControllerReturnMsg.EXCEPTION_ERROR.toString());
        }
    }
    /**
     * 删除书籍
     * @param book
     */
    @RequestMapping(value=ControllerName.ADMIN_BOOK_DEL,method=RequestMethod.POST)
    public void toUserDelete(BookVO book,HttpServletResponse response){
        try{
            book.setIdsStr(book.getIdsStr().replace("[", "").replace("]", "").replace("\"", "'"));
            adminBookService.deleteBook(book);
            UResponse.writeSuccess(response, ControllerReturnMsg.DELETE_SUCCESS.toString());
        }catch(Exception e){
            logger.error(e.getMessage());
            UResponse.writeFail(response,  ControllerReturnMsg.EXCEPTION_ERROR.toString());
        }
    }

}