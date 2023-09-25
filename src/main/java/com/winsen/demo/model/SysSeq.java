package com.winsen.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSeq {

    private String id;
    private String seqKey;
    private long value;

}
