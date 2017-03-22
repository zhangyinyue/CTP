package com.ctp.controller.admin;

import com.ctp.controller.config.ControllerName;
import com.ctp.controller.config.ControllerReturnMsg;
import com.ctp.controller.config.PagePath;
import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TBook;
import com.ctp.model.vo.BookVO;
import com.ctp.service.admin.inter.IAdminBookService;
import com.ctp.service.config.ServiceName;
import com.ctp.utils.ContextUtils;
import com.ctp.utils.StringUtils;
import com.ctp.utils.UResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;

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
    public String toBookPage(HttpServletRequest request, HttpServletResponse response, BookVO book){
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
    public String toBookEditPage(BookVO book,HttpServletResponse response){
        HttpServletRequest request = ContextUtils.getRequest();
        TBook tBook = adminBookService.getBook(book.getId());
        if(tBook != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            tBook.setFpublishyearstr(sdf.format(tBook.getFpublishyear()*1000));
        }
        tBook = tBook == null ? tBook = new TBook() : tBook;
        request.setAttribute("book",tBook);
        return PagePath.BOOK_EDIT.toString();
    }
    @RequestMapping(value=ControllerName.ADMIN_BOOK_VIEW_IMAGE,method=RequestMethod.GET)
    public void viewPic(String bookId, HttpServletResponse response) throws IOException {
        TBook book = adminBookService.getBook(bookId);
        byte[] datas = book.getFimage();
        InputStream buffin = new ByteArrayInputStream(datas);// 业务逻辑取得图片的byte[]
        OutputStream sos = response.getOutputStream();
        try {
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            int len;
            byte[] buf = new byte[1024];
            while ((len = buffin.read(buf, 0, 1024)) != -1) {
                sos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            buffin.close();
            sos.close();
        }

    }
    /**
     * 保存书籍
     * @param book
     */
    @RequestMapping(value=ControllerName.ADMIN_BOOK_SAVE,method=RequestMethod.POST)
    public void toBookSave(TBook book,HttpServletResponse response,HttpServletRequest request){
        if(StringUtils.isEmpty(book.getFname())){
            logger.error("书名不能为空！");
            UResponse.writeFail(response, ControllerReturnMsg.NAME_NOT_NULL.toString());
            return;
        }
        try{
            adminBookService.saveBook(book);
            if(book.getFile() != null){
                //book.setFcontent(book.getFile().getBytes());
                CommonsMultipartFile file = book.getFile();
                if(!file.isEmpty()){
                    try {

                        File books = new File(request.getContextPath()+"/ctp-web/src/main/webapp/web/books/");
                        if(!books.exists()){
                            books.mkdir();
                        }
                        //定义输出流 将文件保存在D盘    file.getOriginalFilename()为获得文件的名字
                        FileOutputStream os = new FileOutputStream(request.getContextPath()+"/ctp-web/src/main/webapp/web/books/"+book.getFid()+".pdf");
                        InputStream in = file.getInputStream();
                        int b = 0;
                        while((b=in.read())!=-1){ //读取文件
                            os.write(b);
                        }
                        os.flush(); //关闭流
                        in.close();
                        os.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
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
