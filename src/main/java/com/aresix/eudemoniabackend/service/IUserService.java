package com.aresix.eudemoniabackend.service;

import com.aresix.eudemoniabackend.pojo.User;
import com.aresix.eudemoniabackend.utils.ServerResponse;

public interface IUserService {
    /**
     * 登陆
     */
    public ServerResponse loginLogic(String username, String password);

    /**
     * 注册
     */
    public ServerResponse registerLogic(User user);

    /**
     * 修改用户信息
     */
    public ServerResponse updateUserLogic(User user);

    /**
     * 获取当前用户个人信息
     */
    public ServerResponse getUserInfoLogic(Integer userId);

    /**
     * 退出登录
     */
    public ServerResponse logoutLogic(Integer userId);
}
