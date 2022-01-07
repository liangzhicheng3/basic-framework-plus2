package com.liangzhicheng.modules.controller;

import com.liangzhicheng.common.basic.BaseController;
import com.liangzhicheng.common.constant.ApiConstant;
import com.liangzhicheng.common.response.ResponseResult;
import com.liangzhicheng.config.mvc.interceptor.annotation.LoginValidate;
import com.liangzhicheng.modules.entity.dto.SysRoleDTO;
import com.liangzhicheng.modules.entity.vo.SysRoleDescVO;
import com.liangzhicheng.modules.entity.vo.SysRoleVO;
import com.liangzhicheng.modules.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value="RoleController", tags={"角色相关控制器"})
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Resource
    private ISysRoleService roleService;

    @LoginValidate
    @ApiOperation(value = "角色管理")
    @PostMapping(value = "/listRole")
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "成功", response = SysRoleVO.class)})
    public ResponseResult listRole(@RequestBody SysRoleDTO roleDTO,
                                   Pageable pageable){
        return buildSuccessInfo(roleService.listRole(roleDTO, pageable));
    }

    @LoginValidate
    @ApiOperation(value = "获取角色")
    @PostMapping(value = "/getRole")
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "成功", response = SysRoleDescVO.class)})
    public ResponseResult getRole(@RequestBody SysRoleDTO roleDTO){
        return buildSuccessInfo(roleService.getRole(roleDTO));
    }

    @LoginValidate
    @ApiOperation(value = "保存角色")
    @PostMapping(value = "/saveRole")
    public ResponseResult saveRole(@RequestBody SysRoleDTO roleDTO){
        roleService.saveRole(roleDTO);
        return buildSuccessInfo();
    }

    @LoginValidate
    @ApiOperation(value = "删除角色")
    @PostMapping(value = "/deleteRole")
    public ResponseResult deleteRole(@RequestBody SysRoleDTO roleDTO){
        roleService.deleteRole(roleDTO);
        return buildSuccessInfo();
    }

}
