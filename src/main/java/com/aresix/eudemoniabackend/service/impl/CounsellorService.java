package com.aresix.eudemoniabackend.service.impl;

import com.aresix.eudemoniabackend.dao.CounsellorMapper;
import com.aresix.eudemoniabackend.pojo.Counsellor;
import com.aresix.eudemoniabackend.service.ICounsellorService;
import com.aresix.eudemoniabackend.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class CounsellorService implements ICounsellorService {
    @Autowired
    CounsellorMapper counsellorMapper;

    @Override
    public ServerResponse CLoginLogic(String username, String password) {
        return null;
    }

    @Override
    public ServerResponse CRegisterLogic(Counsellor counsellor) {
        return null;
    }
}
