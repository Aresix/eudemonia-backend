package com.aresix.eudemoniabackend.service;

import com.aresix.eudemoniabackend.pojo.Counsellor;
import com.aresix.eudemoniabackend.utils.ServerResponse;

public interface ICounsellorService {
    /**
     * 咨询师登陆
     */
    public ServerResponse CLoginLogic(String username,String password);

    /**
     * 咨询师注册
     */
    public ServerResponse CRegisterLogic(Counsellor counsellor);
}
