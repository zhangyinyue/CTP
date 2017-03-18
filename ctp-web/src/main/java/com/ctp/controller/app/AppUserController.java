package com.ctp.controller.app;

import com.ctp.controller.admin.AdminUserController;
import com.ctp.controller.config.ControllerName;
import com.ctp.controller.config.ControllerReturnMsg;
import com.ctp.controller.config.PagePath;
import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TUser;
import com.ctp.model.vo.BookVO;
import com.ctp.model.vo.UserVO;
import com.ctp.service.admin.inter.IAdminUserService;
import com.ctp.service.config.LoginEnum;
import com.ctp.service.config.ServiceName;
import com.ctp.service.config.SessionEnum;
import com.ctp.utils.ContextUtils;
import com.ctp.utils.StringUtils;
import com.ctp.utils.URequest;
import com.ctp.utils.UResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/3/18 0018.
 */
@Controller
@RequestMapping(ControllerName.APP_USER)
public class AppUserController {

    private Logger logger = Logger.getLogger(AdminUserController.class);
    @Resource(name=ServiceName.ADMIN_USER)
    private IAdminUserService userService;
    /**
     * @param request
     * @param response
     * @param user
     * @return
     */
    @RequestMapping(value=ControllerName.APP_USER_LOGIN,method={RequestMethod.GET,RequestMethod.POST})
    public String toLogin(HttpServletRequest request, HttpServletResponse response, TUser user){
        String result = userService.appLogin(user);
        if(LoginEnum.LOGIN_SUCCESS.getStrVal().equals(result)){
            return "redirect:/appBook/book/list";
        }else {
            request.setAttribute("error",result);
            return PagePath.APP_LOGIN.toString();
        }
    }

    /**
     * 保存用户
     * @param user
     */
    @RequestMapping(value=ControllerName.APP_USER_ADD,method=RequestMethod.GET)
    public String toUserSave(TUser user,HttpServletResponse response){
        userService.saveUser(user);
        return  "redirect:/appBook/book/login";
    }
    /**
     * 登出操作
     */
    @RequestMapping(value=ControllerName.APP_USER_LOGOUT,method=RequestMethod.GET)
    public String logout(){
        HttpServletRequest requset = ContextUtils.getRequest();
        URequest.removeSession(requset, SessionEnum.APPUSER.toString());
        return "redirect:/appBook/book/list";
    }
}
