package com.ipisces42.bo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author fuhaixin
 * @date 2022/8/17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
@Schema(name = "用户对象BO", description = "从客户端,由用户传入的数据封装在此entity中")
public class UserLoginBO {

    @NotBlank(message = "用户名不能为空")
    @Schema(required = true, description = "用户名", name = "username", title = "用户名", example = "ipisces42")
    private String username;
    @NotBlank(message = "密码不能为空")
    @Min(value = 6, message = "密码不能小于6位")
    @Schema(required = true, description = "密码", name = "password", title = "密码", example = "123456")
    private String password;
}
