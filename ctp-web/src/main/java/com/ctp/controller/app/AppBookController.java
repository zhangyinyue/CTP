package com.ctp.controller.app;

import com.ctp.controller.admin.AdminUserController;
import com.ctp.controller.config.ControllerName;
import com.ctp.controller.config.ControllerReturnMsg;
import com.ctp.controller.config.PagePath;
import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.*;
import com.ctp.model.vo.BookVO;
import com.ctp.model.vo.UserVO;
import com.ctp.service.admin.inter.IAdminBookService;
import com.ctp.service.admin.inter.IAdminUserService;
import com.ctp.service.config.ServiceName;
import com.ctp.service.config.SessionEnum;
import com.ctp.utils.ContextUtils;
import com.ctp.utils.StringUtils;
import com.ctp.utils.URequest;
import com.ctp.utils.UResponse;
import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zyy on 2017/3/12 0012.
 */
@Controller
@RequestMapping(ControllerName.APP_BOOK)
public class AppBookController {

    private Logger logger = Logger.getLogger(AdminUserController.class);
    @Resource(name = ServiceName.ADMIN_BOOK)
    private IAdminBookService adminBookService;
    @Resource(name = ServiceName.ADMIN_USER)
    private IAdminUserService userService;
    @Resource(name="dataSource")
    private DataSource dataSource;

    /**
     * 跳转到书籍列表
     * @param request
     * @param response
     * @param book
     * @return
     */
    @RequestMapping(value=ControllerName.APP_BOOK_LIST,method={RequestMethod.GET,RequestMethod.POST})
    public String toUserPage(HttpServletRequest request, HttpServletResponse response, BookVO book) throws IOException, TasteException {
        book.setPageSize(4);
        book.setSort(true);
        ListPage newBooks = adminBookService.queryBookByPage(book);
        request.setAttribute("newBooks", newBooks);
        book.setSort(false);
        ListPage listPage = adminBookService.queryBookByPage(book);
        request.setAttribute("listPage", listPage);

        UserVO user = new UserVO();
        user.setPageSize(10);
        TUser tUser = (TUser) URequest.getSession(request,SessionEnum.APPUSER.toString());
        if (tUser != null) {
            user.setId(tUser.getFid());
        }
        ListPage userPage = userService.getFriends(user);
        request.setAttribute("userPage", userPage);


        DataModel model = new MySQLJDBCDataModel(dataSource,"t_book_review","fuser_id","fbook_id","fscore","fdate");
        UserSimilarity userSim = new EuclideanDistanceSimilarity(model);
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(2, userSim, model);
        Recommender r = new GenericUserBasedRecommender(model, neighbor, userSim);
        //LongPrimitiveIterator iter = model.getUserIDs();
        List<RecommendedItem> list = r.recommend(tUser == null ? 0:tUser.getFid(), 3);
       List<TBook> books = new ArrayList<>();
       for(RecommendedItem item : list){
           books.add(adminBookService.getBook(String.valueOf(item.getItemID())));
       }
        request.setAttribute("reviewBooks", books);
        return PagePath.APP_BOOK_LIST.toString();
    }

    /**
     * 跳转到书籍列表
     * @param request
     * @param response
     * @param book
     * @return
     */
    @RequestMapping(value=ControllerName.APP_BOOK_MYFACTORY,method={RequestMethod.GET,RequestMethod.POST})
    public String toMyfactoryPage(HttpServletRequest request, HttpServletResponse response, BookVO book) throws IOException, TasteException {

        DataModel model = new MySQLJDBCDataModel(dataSource,"t_book_review","fuser_id","fbook_id","fscore","fdate");
        UserSimilarity userSim = new EuclideanDistanceSimilarity(model);
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(2, userSim, model);
        Recommender r = new GenericUserBasedRecommender(model, neighbor, userSim);
        //LongPrimitiveIterator iter = model.getUserIDs();
        TUser tUser = (TUser) URequest.getSession(request,SessionEnum.APPUSER.toString());
        List<RecommendedItem> list = r.recommend(tUser == null ? 0:tUser.getFid(), 3);
        List<TBook> books = new ArrayList<>();
        for(RecommendedItem item : list){
            books.add(adminBookService.getBook(String.valueOf(item.getItemID())));
        }
        request.setAttribute("reviewBooks", books);
        return PagePath.APP_BOOK_MYFACTORY.toString();
    }

    @RequestMapping(value=ControllerName.APP_LOGIN,method={RequestMethod.GET,RequestMethod.POST})
    public String toLoginPage(HttpServletRequest request, HttpServletResponse response, BookVO book){

        return PagePath.APP_LOGIN.toString();
    }

    @RequestMapping(value=ControllerName.APP_ACCOUNT,method={RequestMethod.GET,RequestMethod.POST})
    public String toAccountPage(HttpServletRequest request, HttpServletResponse response, BookVO book){

        return PagePath.APP_ACCOUNT.toString();
    }

    @RequestMapping(value=ControllerName.APP_REGISTER,method={RequestMethod.GET,RequestMethod.POST})
    public String toRegisterPage(HttpServletRequest request, HttpServletResponse response, BookVO book){

        return PagePath.APP_REGISTER.toString();
    }

    @RequestMapping(value=ControllerName.APP_BOOKS,method={RequestMethod.GET,RequestMethod.POST})
    public String toBooksPage(HttpServletRequest request, HttpServletResponse response, BookVO book){
        book.setPageSize(4);
        book.setSort(false);
        ListPage listPage = adminBookService.queryBookByPage(book);
        request.setAttribute("listPage", listPage);
        return PagePath.APP_BOOKS.toString();
    }

    @RequestMapping(value=ControllerName.APP_NEW_BOOKS,method={RequestMethod.GET,RequestMethod.POST})
    public String toNewBooksPage(HttpServletRequest request, HttpServletResponse response, BookVO book){
        book.setPageSize(4);
        book.setSort(true);
        ListPage newBooks = adminBookService.queryBookByPage(book);
        request.setAttribute("newBooks", newBooks);
        return PagePath.APP_NEW_BOOKS.toString();
    }

    @RequestMapping(value=ControllerName.APP_MY_BOOKS,method={RequestMethod.GET,RequestMethod.POST})
    public String toMyBooksPage(HttpServletRequest request, HttpServletResponse response, UserVO user){
        if (URequest.getSession(request, SessionEnum.APPUSER.toString()) == null ) {
            return PagePath.APP_LOGIN.toString();
        }

        user.setPageSize(10);
        TUser tUser = (TUser) URequest.getSession(request,SessionEnum.APPUSER.toString());
        if (tUser != null && (user.getId() == 0 || "".equals(user.getId()))) {
            user.setId(tUser.getFid());
            URequest.removeSession(request,"friend");
        }else{//好友的书架
            TUser friend = userService.getUser(String.valueOf(user.getId()));
            URequest.setSession(request,"friend",friend);
        }
        ListPage bookPage = adminBookService.getMyBooks(String.valueOf(user.getId()));
        if (tUser != null ) {
            user.setId(tUser.getFid());
        }
        ListPage userPage = userService.getFriends(user);
        request.setAttribute("userPage", userPage);
        request.setAttribute("bookPage", bookPage);
        return PagePath.APP_MY_BOOKS.toString();
    }

    @RequestMapping(value=ControllerName.APP_MY_FRIENDS,method={RequestMethod.GET,RequestMethod.POST})
    public String toMyFriendsPage(HttpServletRequest request, HttpServletResponse response, BookVO book){
        if (URequest.getSession(request, SessionEnum.APPUSER.toString()) == null ) {
            return PagePath.APP_LOGIN.toString();
        }
        TUser tUser = (TUser) URequest.getSession(request,SessionEnum.APPUSER.toString());
        UserVO user = new UserVO();
        if (tUser != null) {
            user.setId(tUser.getFid());
        }
        ListPage friendPage = userService.getFriends(user);
        request.setAttribute("friendPage", friendPage);
        return PagePath.APP_MY_FRIENDS.toString();
    }

    @RequestMapping(value=ControllerName.APP_BOOK_DETAIL,method={RequestMethod.GET,RequestMethod.POST})
    public String toSubPage(HttpServletRequest request, HttpServletResponse response, BookVO book) throws TasteException {
       TBook tBook = adminBookService.getBook(book.getId());
        request.setAttribute("book",tBook);
        UserVO user = new UserVO();
        user.setPageSize(10);
        TUser tUser = (TUser) URequest.getSession(request,SessionEnum.APPUSER.toString());
        if (tUser != null) {
            user.setId(tUser.getFid());
        }
        ListPage userPage = userService.getFriends(user);
        request.setAttribute("userPage", userPage);
        ListPage bookReviews =  adminBookService.getBookReviews(book.getId());
        request.setAttribute("bookReviews", bookReviews);

        DataModel model = new MySQLJDBCDataModel(dataSource,"t_book_review","fuser_id","fbook_id","fscore","fdate");
        UserSimilarity userSim = new EuclideanDistanceSimilarity(model);
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(2, userSim, model);
        Recommender r = new GenericUserBasedRecommender(model, neighbor, userSim);
        //LongPrimitiveIterator iter = model.getUserIDs();
        List<RecommendedItem> list = r.recommend(tUser == null ? 0:tUser.getFid(), 3);
        List<TBook> books = new ArrayList<>();
        for(RecommendedItem item : list){
            books.add(adminBookService.getBook(String.valueOf(item.getItemID())));
        }
        request.setAttribute("reviewBooks", books);
        //推荐相关书籍
       /* List<RecommendedItem> items = recommendItems(tUser == null ? 0:tUser.getFid());
        List<TBook> xgbooks = new ArrayList<>();
        for(RecommendedItem item : items){
            xgbooks.add(adminBookService.getBook(String.valueOf(item.getItemID())));
        }
        request.setAttribute("xgbooks", xgbooks);*/
        return PagePath.APP_BOOK_DETAIL.toString();
    }

    private List<RecommendedItem> recommendItems(Long userId) throws TasteException {
        DataModel model = new MySQLJDBCDataModel(dataSource,"t_book_review","fuser_id","fbook_id","fscore","fdate");
// Build the same recommender for testing that we did last time:
        RecommenderBuilder recommenderBuilder = new RecommenderBuilder() {
            @Override
            public Recommender buildRecommender(DataModel model) throws TasteException {
                ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
                return new GenericItemBasedRecommender(model, similarity);
            }
        };
        //获取推荐结果
        List<RecommendedItem> recommendations = new ArrayList<>();
        if(userId != 0){
            recommendations = recommenderBuilder.buildRecommender(model).recommend(userId, 4);
        }
        return recommendations;
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
     * 加入书架
     * @param bookList
     * @return
     */
    @RequestMapping(value=ControllerName.APP_ADD_MYBOOK,method=RequestMethod.GET)
    public String toAddMyBooks(TBookList bookList,HttpServletRequest request,HttpServletResponse response){
        adminBookService.addMyBook(bookList);

        return "redirect:/appBook/book/myBooks";
    }

    /**
     * 添加书评
     * @param bookReview
     * @return
     */
    @RequestMapping(value=ControllerName.APP_ADD_BOOKREVIEW,method=RequestMethod.POST)
    public void toAddBookReview(TBookReview bookReview,HttpServletRequest request,HttpServletResponse response){
        adminBookService.addBookReview(bookReview);
        UResponse.writeSuccess(response, "评分成功");

    }
}
