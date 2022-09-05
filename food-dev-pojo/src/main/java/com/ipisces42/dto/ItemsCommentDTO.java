package com.ipisces42.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author fuhaixin
 * @date 2022/9/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemsCommentDTO {
    private Integer commentLevel;
    private String content;
    private String specName;
    private LocalDateTime createdTime;
    private String userFace;
    private String nickname;
}
