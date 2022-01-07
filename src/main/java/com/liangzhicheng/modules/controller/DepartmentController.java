package com.liangzhicheng.modules.controller;

import com.liangzhicheng.common.basic.BaseController;
import com.liangzhicheng.common.constant.ApiConstant;
import com.liangzhicheng.common.response.ResponseResult;
import com.liangzhicheng.config.mvc.interceptor.annotation.LoginValidate;
import com.liangzhicheng.modules.entity.dto.SysDeptDTO;
import com.liangzhicheng.modules.entity.vo.SysDeptDescVO;
import com.liangzhicheng.modules.entity.vo.SysDeptVO;
import com.liangzhicheng.modules.service.ISysDeptService;
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

@Api(value="DepartmentController", tags={"部门相关控制器"})
@RestController
@RequestMapping("/dept")
public class DepartmentController extends BaseController {

    @Resource
    private ISysDeptService deptService;

    @LoginValidate
    @ApiOperation(value = "部门列表")
    @PostMapping(value = "/listDept")
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "成功", response = SysDeptVO.class)})
    public ResponseResult listDept(@RequestBody SysDeptDTO deptDTO,
                                   Pageable pageable){
        return buildSuccessInfo(deptService.listDept(deptDTO, pageable));
    }

    @LoginValidate
    @ApiOperation(value = "获取部门")
    @PostMapping(value = "/getDept")
    @ApiResponses({@ApiResponse(code = ApiConstant.BASE_SUCCESS_CODE,
            message = "成功", response = SysDeptDescVO.class)})
    public ResponseResult getDept(@RequestBody SysDeptDTO deptDTO){
        return buildSuccessInfo(deptService.getDept(deptDTO));
    }

    @LoginValidate
    @ApiOperation(value = "保存部门")
    @PostMapping(value = "/saveDept")
    public ResponseResult saveDept(@RequestBody SysDeptDTO deptDTO){
        deptService.saveDept(deptDTO);
        return buildSuccessInfo();
    }

    @LoginValidate
    @ApiOperation(value = "删除部门")
    @PostMapping(value = "/deleteDept")
    public ResponseResult deleteDept(@RequestBody SysDeptDTO deptDTO){
        deptService.deleteDept(deptDTO);
        return buildSuccessInfo();
    }

}
