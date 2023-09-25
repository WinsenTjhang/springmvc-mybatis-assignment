package com.winsen.demo.service;

import com.winsen.demo.model.SysSeq;
import com.winsen.demo.repository.SysSeqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SysSeqService {

    private final SysSeqRepository sysSeqRepository;

    @Autowired
    public SysSeqService(SysSeqRepository sysSeqRepository) {
        this.sysSeqRepository = sysSeqRepository;
    }

    public Long getSeq(String key) {
        SysSeq sysSeq = sysSeqRepository.findByKey(key);
        if(sysSeq == null) {
            sysSeq = new SysSeq();
            sysSeq.setId(UUID.randomUUID().toString().replace("-", ""));
            sysSeq.setSeqKey(key);
            sysSeq.setValue(sysSeq.getValue() + 1);
            sysSeqRepository.insert(sysSeq);
        } else {
            sysSeq.setValue(sysSeq.getValue() + 1);
            sysSeqRepository.updateValue(sysSeq);
        }
        return sysSeq.getValue();
    }
}
