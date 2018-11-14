package com.nit.cs161.lost_and_found.controller;


import com.nit.cs161.lost_and_found.constant.general.ProjectConstants;
import com.nit.cs161.lost_and_found.dto.UserDTO;
import com.nit.cs161.lost_and_found.dto.general.AjaxMsgDTO;
import com.nit.cs161.lost_and_found.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Descriptions: 用户控制<p>
 *
 * @author SailHe
 * @date 2018/10/1 15:42
 */
@RestController
@RequestMapping("user/")
public class UserController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Resource
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Descriptions: 注册<p>
     *
     * @author SailHe
     * @date 2018/10/1 15:46
     */
    @RequestMapping(value = "/signUp")
    public AjaxMsgDTO signUpSystem(UserDTO userDTO) {
        AjaxMsgDTO ajaxMsgDTO = new AjaxMsgDTO();
        try {
            ajaxMsgDTO.setMsg(userService.signUpSystem(userDTO));
            ajaxMsgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            ajaxMsgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("用户注册失败", e);
        }
        return ajaxMsgDTO;
    }
}

