package com.aresix.eudemoniabackend.controller;

import com.aresix.eudemoniabackend.dao.CounsellorMapper;
import com.aresix.eudemoniabackend.service.ICounsellorService;
import com.aresix.eudemoniabackend.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/back/counsellor/")
public class CounsellorController {
    @Autowired
    ICounsellorService counsellorService;

    @RequestMapping(value = "login.do")
    public ServerResponse login(String username, String password, HttpSession session){
        ServerResponse serverResponse=counsellorService.CLoginLogic(username, password);
    }
}
