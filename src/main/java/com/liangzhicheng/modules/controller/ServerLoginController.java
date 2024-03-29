package com.liangzhicheng.modules.controller;

import com.liangzhicheng.common.basic.BaseController;
import com.liangzhicheng.common.constant.ApiConstant;
import com.liangzhicheng.common.response.ResponseResult;
import com.liangzhicheng.config.mvc.interceptor.annotation.LoginValidate;
import com.liangzhicheng.modules.entity.dto.SysUserDTO;
import com.liangzhicheng.modules.entity.vo.SysUserLoginVO;
import com.liangzhicheng.modules.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Api(value="ServerLoginController", tags={"登录相关控制器"})
@RestController
@RequestMapping(value = "/server")
public class ServerLoginController extends BaseController {

    @Resource
    private ISysUserService sysUserService;

    @ApiOperation(value = "登录")
    @PostMapping(value = "/login")
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "成功", response = SysUserLoginVO.class)})
    public ResponseResult login(@RequestBody SysUserDTO userDTO,
                                HttpServletRequest request){
        return buildSuccessInfo(sysUserService.login(userDTO, request));
    }

    @LoginValidate
    @ApiOperation(value = "退出登录")
    @PostMapping(value = "/logOut")
    public ResponseResult logOut(HttpServletRequest request){
        sysUserService.logOut(request);
        return buildSuccessInfo();
    }

}

