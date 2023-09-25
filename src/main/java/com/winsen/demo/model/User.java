package com.winsen.demo.model;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String id;
    private String code;
    private String name;
    private Short status;
    private String remark;
    private Short deleted;
    private String creator;
    private Long createTime;

}