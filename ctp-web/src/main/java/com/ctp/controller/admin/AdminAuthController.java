package com.ctp.controller.admin;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ctp.controller.config.ControllerName;
import com.ctp.controller.config.ControllerReturnMsg;
import com.ctp.controller.config.PagePath;
import com.ctp.dao.base.impl.ListPage;
import com.ctp.model.po.TAuth;
import com.ctp.model.po.TRole;
import com.ctp.model.vo.AuthTreeVO;
import com.ctp.model.vo.AuthVO;
import com.ctp.model.vo.RoleVO;
import com.ctp.service.admin.inter.IAdminAuthService;
import com.ctp.service.config.ServiceName;
import com.ctp.service.config.ReturnMsg;
import com.ctp.utils.ContextUtils;
import com.ctp.utils.StringUtils;
import com.ctp.utils.UResponse;

/**
 * 权限管制器
 * @author zyy
 * @date 2016年11月24日 下午21:31:15
 */
@Controller
@RequestMapping(ControllerName.ADMIN_AUTH)
public class AdminAuthController {

	private Logger logger = Logger.getLogger(AdminAuthController.class);
	
	@Resource(name=ServiceName.ADMIN_AUTH)
	private IAdminAuthService authService;
	
	/**
	 * 跳转到角色列表
	 * @param request
	 * @param response
	 * @param role
	 * @return
	 */
	@RequestMapping(value=ControllerName.ADMIN_ROLE_LIST,method={RequestMethod.GET,RequestMethod.POST})
	public String toRolePage(HttpServletRequest request,HttpServletResponse response,RoleVO role){
		ListPage listPage = authService.queryRoleByPage(role);
		request.setAttribute("listPage", listPage);
		request.setAttribute("role",role);
		return PagePath.ROLE_LIST.toString();
	}

	/**
	 * 角色编辑界面
	 * @param role
	 * @return
	 */
	@RequestMapping(value=ControllerName.ADMIN_ROLE_EDIT,method=RequestMethod.POST)
	public String toRoleEditPage(RoleVO role){
		HttpServletRequest request = ContextUtils.getRequest();
		AuthTreeVO authTree = authService.queryRole2Auth(role);
		request.setAttribute("authTree", authTree);
		if(!StringUtils.isEmpty(role.getId())){
			TRole ro = authService.getRole(role.getId());
			role.setName(ro.getFname());
		}
		request.setAttribute("role",role);
		return PagePath.ROLE_AUTH_EDIT.toString();
	}
	
	/**
	 * 保存角色
	 * @param role
	 */
	@RequestMapping(value=ControllerName.ADMIN_ROLE_SAVE,method=RequestMethod.POST)
	public void toRoleSave(RoleVO role,HttpServletResponse response){
		//HttpServletResponse response = ContextUtils.getResponse();
		if(StringUtils.isEmpty(role.getName())){
			logger.error("角色名不能为空！");
			UResponse.writeFail(response, ControllerReturnMsg.NAME_NOT_NULL.toString());
			return;
		}
		try{
			authService.saveRoleAndAuths(role);
			UResponse.writeSuccess(response, ControllerReturnMsg.OPERATOR_SUCCESS.toString());
		}catch(Exception e){
			logger.error(e.getMessage());
			UResponse.writeFail(response,  ControllerReturnMsg.EXCEPTION_ERROR.toString());
		}
	}
	/**
	 * 删除角色
	 * @param role
	 */
	@RequestMapping(value=ControllerName.ADMIN_ROLE_DEL,method=RequestMethod.POST)
	public void toRoleDelete(RoleVO role,HttpServletResponse response){
		//HttpServletResponse response = ContextUtils.getResponse();
		try{
			role.setIdsStr(role.getIdsStr().replace("[", "").replace("]", "").replace("\"", "'"));
			authService.deleteAuthByRoleIds(role);
			UResponse.writeSuccess(response, ControllerReturnMsg.DELETE_SUCCESS.toString());
		}catch(Exception e){
			logger.error(e.getMessage());
			UResponse.writeFail(response,  ControllerReturnMsg.EXCEPTION_ERROR.toString());
		}
	}
	

	/**
	 * 跳转到权限项列表
	 * @param auth
	 * @return
	 */
	@RequestMapping(value=ControllerName.ADMIN_AUTH_LIST,method={RequestMethod.GET,RequestMethod.POST})
	public String toAuthPage(AuthVO auth){
		HttpServletRequest request = ContextUtils.getRequest();
		ListPage listPage = authService.queryAuthByPage(auth);
		request.setAttribute("listPage", listPage);
		request.setAttribute("auth",auth);
		return PagePath.AUTH_LISE.toString();
	}

	/**
	 * 跳转到父权限项列表
	 * @param auth
	 * @return
	 */
	@RequestMapping(value=ControllerName.ADMIN_AUTH_PARENT_LIST,method={RequestMethod.GET,RequestMethod.POST})
	public String toAuthParentPage(AuthVO auth){
		HttpServletRequest request = ContextUtils.getRequest();
		ListPage listPage = authService.queryAuthParentByPage(auth);
		request.setAttribute("listPage", listPage);
		request.setAttribute("auth",auth);
		return PagePath.AUTH_PARENT_LISE.toString();
	}
	
	/**
	 * 权限项编辑界面
	 * @param auth
	 * @return
	 */
	@RequestMapping(value=ControllerName.ADMIN_AUTH_EDIT,method=RequestMethod.POST)
	public String toAuthEditPage(AuthVO auth){
		HttpServletRequest request = ContextUtils.getRequest();
		request.setAttribute("auth", authService.getAuth(auth.getId()));
		return PagePath.AUTH_EDIT.toString();
	}
	
	/**
	 * 保存权限项
	 * @param role
	 */
	@RequestMapping(value=ControllerName.ADMIN_AUTH_SAVE,method=RequestMethod.POST)
	public void toAuthSave(TAuth auth,HttpServletResponse response){
		//HttpServletResponse response = ContextUtils.getResponse();
		if(StringUtils.isEmpty(auth.getFname())){
			logger.error("权限项名称不能为空！");
			UResponse.writeFail(response, ControllerReturnMsg.NAME_NOT_NULL.toString());
			return;
		}
		try{
			authService.saveAuth(auth);
			UResponse.writeSuccess(response, ControllerReturnMsg.OPERATOR_SUCCESS.toString());
		}catch(Exception e){
			logger.error(e.getMessage());
			UResponse.writeFail(response, ControllerReturnMsg.EXCEPTION_ERROR.toString());
		}
	}
	/**
	 * 删除权限项
	 * @param auth
	 */
	@RequestMapping(value=ControllerName.ADMIN_AUTH_DEL,method=RequestMethod.POST)
	public void toAuthDelete(AuthVO auth,HttpServletResponse response){
		//HttpServletResponse response = ContextUtils.getResponse();
		String result = null;
		try{
			auth.setIdsStr(auth.getIdsStr().replace("[", "").replace("]", "").replace("\"", "'"));
			result = authService.deleteAuth(auth);
			if(ReturnMsg.DEL_AUTH_FAIL.toString().equals(result)){
				UResponse.writeFail(response, result);
			}else{
				UResponse.writeSuccess(response, result);
			}
		}catch(Exception e){
			logger.error(e.getMessage());
			UResponse.writeFail(response, e.getMessage());
		}
	}
	
	
}
