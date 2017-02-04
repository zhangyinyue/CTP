package com.ctp.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctp.service.admin.inter.IAdminAuthService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ctp.controller.config.ControllerName;
import com.ctp.controller.config.ControllerReturnMsg;
import com.ctp.controller.config.PagePath;
import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TRole;
import com.ctp.model.po.TUser;
import com.ctp.model.vo.AuthTreeVO;
import com.ctp.model.vo.RoleVO;
import com.ctp.model.vo.UserVO;
import com.ctp.service.admin.inter.IAdminUserService;
import com.ctp.service.config.LoginEnum;
import com.ctp.service.config.ServiceName;
import com.ctp.service.config.SessionEnum;
import com.ctp.utils.ContextUtils;
import com.ctp.utils.StringUtils;
import com.ctp.utils.URequest;
import com.ctp.utils.UResponse;

/**
 *  用户controller
 *	@auther zyy
 *	@date 2016年11月7日下午8:53:03
 */
@Controller
@RequestMapping(ControllerName.ADMIN_USER)
public class AdminUserController {

	private Logger logger = Logger.getLogger(AdminUserController.class);
	
	@Resource(name=ServiceName.ADMIN_USER)
    private IAdminUserService adminUserService;

    @Resource(name=ServiceName.ADMIN_AUTH)
    private IAdminAuthService adminAuthService;
	/**
	 * 跳转到登陆界面
	 * @return
	 */
	@RequestMapping(value=ControllerName.ADMIN_TOLOGIN,method=RequestMethod.GET)
	public String toLogin(){
		TUser user = adminUserService.toLogin();
		ContextUtils.getRequest().setAttribute("user", user);
		return PagePath.LOGIN.toString();
	}
	
	/**
	 * 登陆操作
	 * @param user
	 * @param response
	 */
	@RequestMapping(value=ControllerName.ADMIN_LOGIN,method=RequestMethod.POST)
	public void login(TUser user,HttpServletResponse response){
		String result = adminUserService.login(user);
		ContextUtils.getRequest().setAttribute("loginInfo", result);
		//ResponseEntity<String> responseEntity = new ResponseEntity<String>(HttpStatus.OK);
		if(LoginEnum.LOGIN_SUCCESS.getStrVal().equals(result)){
			UResponse.writeSuccess(response, true);
		}else{
			UResponse.writeSuccess(response, result);
		}
	}
	
	/**
	 * 登出操作
	 */
	@RequestMapping(value=ControllerName.ADMIN_LOGOUT,method=RequestMethod.GET)
	public String logout(){
		HttpServletRequest requset = ContextUtils.getRequest();
		URequest.removeSession(requset, SessionEnum.USER.toString());
		URequest.removeSession(requset, SessionEnum.AUTH_TREE.toString());
		return "redirect:loginPage";
	}
	
	/**
	 * 跳转到首页
	 * @return
	 */
	@RequestMapping(value=ControllerName.ADMIN_HOME,method=RequestMethod.GET)
	public String toHome(){
		HttpServletRequest request = ContextUtils.getRequest();
		TUser user = (TUser) URequest.getSession(request, SessionEnum.USER.toString());
		AuthTreeVO authTree = adminUserService.getAuthTreeByUser(user);
		URequest.setSession(request, SessionEnum.AUTH_TREE.toString(), authTree);
		URequest.setSession(request, "pid", null);
		URequest.setSession(request, "cid", null);
		URequest.setSession(request, "pname", null);
		URequest.setSession(request, "cname", null);
		return PagePath.HOME.toString();
	}
	
	
	/**
	 * 跳转到用户列表
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 */
	@RequestMapping(value=ControllerName.ADMIN_USER_LIST,method={RequestMethod.GET,RequestMethod.POST})
	public String toUserPage(HttpServletRequest request,HttpServletResponse response,UserVO user){
		ListPage listPage = adminUserService.queryUserByPage(user);
		request.setAttribute("listPage", listPage);
		request.setAttribute("user",user);
		return PagePath.USER_LIST.toString();
	}

    /**
     * 跳转到角色列表
     * @param request
     * @param response
     * @param role
     * @return
     */
    @RequestMapping(value=ControllerName.ADMIN_ROLE_LIST,method={RequestMethod.GET,RequestMethod.POST})
    public String toRolePage(HttpServletRequest request,HttpServletResponse response,RoleVO role){
        ListPage listPage = adminAuthService.queryRoleByPage(role);
        request.setAttribute("listPage", listPage);
        request.setAttribute("role",role);
        return PagePath.ROLE_SELECT_LIST.toString();
    }
	
	/**
	 * 用户编辑界面
	 * @param user
	 * @return
	 */
	@RequestMapping(value=ControllerName.ADMIN_USER_EDIT,method=RequestMethod.POST)
	public String toUserEditPage(UserVO user){
		HttpServletRequest request = ContextUtils.getRequest();
		TUser tuser = adminUserService.getUser(user.getId());
		tuser = tuser == null ? tuser = new TUser() : tuser;
		request.setAttribute("user",tuser);
		return PagePath.USER_EDIT.toString();
	}
	
	
	/**
	 * 保存用户
	 * @param user
	 */
	@RequestMapping(value=ControllerName.ADMIN_USER_SAVE,method=RequestMethod.POST)
	public void toUserSave(TUser user,HttpServletResponse response){
		if(StringUtils.isEmpty(user.getFname())){
			logger.error("用户名不能为空！");
			UResponse.writeFail(response, ControllerReturnMsg.NAME_NOT_NULL.toString());
			return;
		}
		try{
			adminUserService.saveUser(user);
			UResponse.writeSuccess(response, ControllerReturnMsg.OPERATOR_SUCCESS.toString());
		}catch(Exception e){
			logger.error(e.getMessage());
			UResponse.writeFail(response,  ControllerReturnMsg.EXCEPTION_ERROR.toString());
		}
	}
	/**
	 * 删除用户
	 * @param user
	 */
	@RequestMapping(value=ControllerName.ADMIN_USER_DEL,method=RequestMethod.POST)
	public void toUserDelete(UserVO user,HttpServletResponse response){
		try{
			user.setIdsStr(user.getIdsStr().replace("[", "").replace("]", "").replace("\"", "'"));
			adminUserService.deleteUser(user);
			UResponse.writeSuccess(response, ControllerReturnMsg.DELETE_SUCCESS.toString());
		}catch(Exception e){
			logger.error(e.getMessage());
			UResponse.writeFail(response,  ControllerReturnMsg.EXCEPTION_ERROR.toString());
		}
	}
}
