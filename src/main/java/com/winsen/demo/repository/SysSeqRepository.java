package com.winsen.demo.repository;

import com.winsen.demo.model.SysSeq;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SysSeqRepository {

    SysSeq findByKey(String seqKey);

    Integer insert(SysSeq sysSeq);

    Integer updateValue(SysSeq sysSeq);

}

