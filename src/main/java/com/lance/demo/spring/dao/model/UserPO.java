package com.lance.demo.spring.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {
    private Integer id;

    private Integer classId;

    private Integer userNo;

    private String userName;

    private Integer userAge;

}