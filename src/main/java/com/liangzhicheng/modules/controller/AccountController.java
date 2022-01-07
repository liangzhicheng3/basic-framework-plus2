package com.liangzhicheng.modules.controller;

import com.liangzhicheng.common.basic.BaseController;
import com.liangzhicheng.common.constant.ApiConstant;
import com.liangzhicheng.common.response.ResponseResult;
import com.liangzhicheng.config.mvc.interceptor.annotation.LoginValidate;
import com.liangzhicheng.modules.entity.dto.SysUserDTO;
import com.liangzhicheng.modules.entity.vo.SysPersonInfoVO;
import com.liangzhicheng.modules.entity.vo.SysUserDescVO;
import com.liangzhicheng.modules.entity.vo.SysUserVO;
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

@Api(value="AccountController", tags={"账号相关控制器"})
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {

    @Resource
    private ISysUserService sysUserService;

    /**
     * 更新当前登录用户头像
     * @param userDTO
     * @return ResponseResult
     */
    @LoginValidate
    @ApiOperation(value = "更新头像")
    @PostMapping(value = "/updateAvatar")
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "成功", response = SysPersonInfoVO.class)})
    public ResponseResult updateAvatar(@RequestBody SysUserDTO userDTO, HttpServletRequest request){
        return buildSuccessInfo(sysUserService.updateAvatar(userDTO, request));
    }

    /**
     * 更新当前登录用户密码
     * @param userDTO
     * @return ResponseResult
     */
    @LoginValidate
    @ApiOperation(value = "更新密码")
    @PostMapping(value = "/updatePassword")
    public ResponseResult updatePassword(@RequestBody SysUserDTO userDTO, HttpServletRequest request){
        sysUserService.updatePassword(userDTO, request);
        return buildSuccessInfo();
    }

    @LoginValidate
    @ApiOperation(value = "账号管理")
    @PostMapping(value = "/listAccount")
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "成功", response = SysUserVO.class)})
    public ResponseResult listAccount(@RequestBody SysUserDTO userDTO){
        return buildSuccessInfo(sysUserService.listAccount(userDTO));
    }

    @LoginValidate
    @ApiOperation(value = "获取账号")
    @PostMapping(value = "/getAccount")
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "成功", response = SysUserDescVO.class)})
    public ResponseResult getAccount(@RequestBody SysUserDTO userDTO){
        return buildSuccessInfo(sysUserService.getAccount(userDTO));
    }

    @LoginValidate
    @ApiOperation(value = "保存账号")
    @PostMapping(value = "/saveAccount")
    public ResponseResult saveAccount(@RequestBody SysUserDTO userDTO){
        sysUserService.saveAccount(userDTO);
        return buildSuccessInfo();
    }

    @LoginValidate
    @ApiOperation(value = "重置密码")
    @PostMapping(value = "/resetPassword")
    public ResponseResult resetPassword(@RequestBody SysUserDTO userDTO){
        sysUserService.resetPassword(userDTO);
        return buildSuccessInfo();
    }

    @LoginValidate
    @ApiOperation(value = "删除账号")
    @PostMapping(value = "/deleteAccount")
    public ResponseResult deleteAccount(@RequestBody SysUserDTO userDTO){
        sysUserService.deleteAccount(userDTO);
        return buildSuccessInfo();
    }

}
