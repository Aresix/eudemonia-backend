package com.aresix.eudemoniabackend.service.impl;

import com.aresix.eudemoniabackend.common.Const;
import com.aresix.eudemoniabackend.common.ResponseCode;
import com.aresix.eudemoniabackend.dao.UserMapper;
import com.aresix.eudemoniabackend.pojo.User;
import com.aresix.eudemoniabackend.service.IUserService;
import com.aresix.eudemoniabackend.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.aresix.eudemoniabackend.utils.ServerResponse.getFailServerResponse;

@Service
public class UserService implements IUserService {

    private static final String TAG = "UserService";

    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse loginLogic(String username, String password) {

        // 用户名、密码非空判断
        // TODO: 密码前端加密！
        if (username == null || username.equals(""))
            return getFailServerResponse(ResponseCode.USERNAME_EMPTY);

        if (password == null || password.equals(""))
            return getFailServerResponse(ResponseCode.PASSWORD_EMPTY);


        // 用户名是否存在
        Integer count = userMapper.findByUsername(username);
        if (count == null || count == 0)
            return getFailServerResponse(ResponseCode.USERNAME_NOT_EXIST);

        // 判断用户名密码是否匹配
        User user = userMapper.findByUsernameAndPassword(username, password);
        if (user == null)
            return getFailServerResponse(ResponseCode.PASSWORD_ERROR);
        // 返回结果
        return ServerResponse.createServerResponseBySuccess(user);
    }

    @Override
    public ServerResponse registerLogic(User user) {
        if (user == null) return getFailServerResponse(ResponseCode.PARAMETER_EMPTY);
        // TODO: 密码前端加密！
        String username = user.getUsername();
        String password = user.getPassword();
        String gender = user.getGender();
//        String user_img_path = user.getUserImgPath();
        Integer age = user.getAge();
        // TODO： 记得删掉
        user.setId(Const.uid++);

        // 以上信息注册时不能为空
        // 头像有默认值
        if (username == null || username.equals(""))
            return getFailServerResponse(ResponseCode.USERNAME_EMPTY);

        if (password == null || password.equals(""))
            return getFailServerResponse(ResponseCode.PASSWORD_EMPTY);

        if (gender == null || gender.equals(""))
            return getFailServerResponse(ResponseCode.USER_GENDER_EMPTY);

        if (age < 0)
            return getFailServerResponse(ResponseCode.USER_AGE_INVALID);

        // 判断用户名是否存在
        Integer u1 = userMapper.findByUsername(username);
        if (u1 > 0) return getFailServerResponse(ResponseCode.USERNAME_REGISTERED);

        // TODO: 这边暂时不加密了
        int result = userMapper.insert(user);
        if (result == 0) return getFailServerResponse(ResponseCode.REGISTER_FAIL);
        else return ServerResponse.createServerResponseBySuccess();
    }

    @Override
    public ServerResponse updateUserLogic(User user) {
        int count = userMapper.updateByPrimaryKey(user);
        if (count==0) // 修改失败
            return getFailServerResponse(ResponseCode.USERINFO_UPDATE_FAIL);

        // 将修改后的信息返回给前端
        // 根据id查询
        User user1 = userMapper.selectByPrimaryKey(user.getId());
        return ServerResponse.createServerResponseBySuccess(user1);
    }

    @Override
    public ServerResponse getUserInfoLogic(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (user==null) return getFailServerResponse(ResponseCode.USER_NOT_EXIST);
        return ServerResponse.createServerResponseBySuccess(user);
    }

    @Override
    public ServerResponse logoutLogic(Integer userId) {
        if (userId==null) return getFailServerResponse(ResponseCode.PARAMETER_EMPTY);
        User user=userMapper.selectByPrimaryKey(userId);
        if (null==user) return getFailServerResponse(ResponseCode.USER_NOT_EXIST);
        return ServerResponse.createServerResponseBySuccess();
    }
}
