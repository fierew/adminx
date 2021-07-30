package com.fierew.adminx.api;

import com.fierew.adminx.dto.AdminUserDTO;
import com.fierew.adminx.dto.TableDTO;
import com.fierew.adminx.vo.AdminUserVO;
import com.fierew.adminx.vo.ResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "AdminUserControllerApi", description = "管理员用户的增删改查")
public interface AdminUserControllerApi {
    @Operation(summary = "获取用户列表",
            description = "获取用户列表",
            responses = {
                    @ApiResponse(description = "返回用户列表",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(anyOf = {ResultVO.class, AdminUserVO.class}))),
                    @ApiResponse(responseCode = "400", description = "返回400时候错误的原因")}
    )
    ResultVO getList(@Validated TableDTO tableDTO, @Validated AdminUserDTO adminUserDTO);

    @Operation(summary = "添加用户",
            description = "添加用户并返回",
            parameters = {

            },
            responses = {
                    @ApiResponse(description = "返回添加的用户",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ResultVO.class))),
                    @ApiResponse(responseCode = "400", description = "返回400时候错误的原因")}
    )
    ResultVO add(@Validated @RequestBody AdminUserDTO adminUserDTO);

    ResultVO modify(@PathVariable Integer id, @Validated @RequestBody AdminUserDTO adminUserDTO);

    ResultVO del(@PathVariable Integer id);
}
