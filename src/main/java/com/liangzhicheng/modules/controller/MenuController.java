package com.liangzhicheng.modules.controller;

import com.liangzhicheng.common.basic.BaseController;
import com.liangzhicheng.common.bean.RedisBean;
import com.liangzhicheng.common.constant.ApiConstant;
import com.liangzhicheng.common.response.ResponseResult;
import com.liangzhicheng.config.mvc.interceptor.annotation.LoginValidate;
import com.liangzhicheng.modules.entity.dto.SysMenuDTO;
import com.liangzhicheng.modules.entity.vo.SysMenuDescVO;
import com.liangzhicheng.modules.entity.vo.SysMenuVO;
import com.liangzhicheng.modules.service.ISysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value="MenuController", tags={"菜单相关控制器"})
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Resource
    private ISysMenuService menuService;
    @Resource
    private RedisBean redisBean;

    @LoginValidate
    @ApiOperation(value = "菜单列表")
    @PostMapping(value = "/listMenu")
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "成功", response = SysMenuVO.class)})
    public ResponseResult listMenu(){
        return buildSuccessInfo(redisBean.getPermMenuList());
    }

    @LoginValidate
    @ApiOperation(value = "获取菜单")
    @PostMapping(value = "/getMenu")
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "成功", response = SysMenuDescVO.class)})
    public ResponseResult getMenu(@RequestBody SysMenuDTO menuDTO){
        return buildSuccessInfo(menuService.getMenu(menuDTO));
    }

    @LoginValidate
    @ApiOperation(value = "新增菜单")
    @PostMapping(value = "/insertMenu")
    public ResponseResult insertMenu(@RequestBody SysMenuDTO menuDTO){
        menuService.insertMenu(menuDTO);
        return buildSuccessInfo();
    }

    @LoginValidate
    @ApiOperation(value = "更新菜单")
    @PostMapping(value = "/updateMenu")
    public ResponseResult updateMenu(@RequestBody SysMenuDTO menuDTO){
        menuService.updateMenu(menuDTO);
        return buildSuccessInfo();
    }

    @LoginValidate
    @ApiOperation(value = "删除菜单")
    @PostMapping(value = "/deleteMenu")
    public ResponseResult deleteMenu(@RequestBody SysMenuDTO menuDTO){
        menuService.deleteMenu(menuDTO);
        return buildSuccessInfo();
    }

}
