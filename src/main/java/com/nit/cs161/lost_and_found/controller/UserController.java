package com.nit.cs161.lost_and_found.controller;


import com.nit.cs161.lost_and_found.constant.general.ProjectConstants;
import com.nit.cs161.lost_and_found.dto.UserDTO;
import com.nit.cs161.lost_and_found.dto.general.AjaxMsgDTO;
import com.nit.cs161.lost_and_found.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * Descriptions: 登录接口<p>
     *
     * @author SailHe
     * @date 2018/10/1 15:42
     */
    @RequestMapping(value = "/signIn")
    public AjaxMsgDTO signInSystem(String username, String signInPassword) {
        AjaxMsgDTO ajaxMsgDto = new AjaxMsgDTO();
        try {
            String token = userService.signIn(username, signInPassword);
            ajaxMsgDto.setData(token);
            if (ajaxMsgDto.getData() != null) {
                ajaxMsgDto.setData(userService.getTokenRecord(token));
                ajaxMsgDto.setSuccess(ProjectConstants.SUCCESS);
                ajaxMsgDto.setMsg("登录成功");
            } else {
                ajaxMsgDto.setSuccess(ProjectConstants.FAILURE);
                ajaxMsgDto.setMsg("登录失败");
            }
        } catch (Exception e) {
            ajaxMsgDto.setSuccess(ProjectConstants.FAILURE);
            ajaxMsgDto.setMsg("Token生成失败");
            LOGGER.error("Token生成失败", e);
        }
        return ajaxMsgDto;
    }

    /**
     * Descriptions: 注册<p>
     *
     * @author SailHe
     * @date 2018/10/1 15:46
     */
    @RequestMapping(value = "/register")
    public AjaxMsgDTO register(String userPhone) {
        AjaxMsgDTO ajaxMsgDTO = new AjaxMsgDTO();
        try {
            ajaxMsgDTO.setData(userService.registerToApp(userPhone));
            ajaxMsgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            ajaxMsgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("注册失败", e);
        }
        return ajaxMsgDTO;
    }

    /**
     * Descriptions: 获取primaryKey对应的那条记录<p>
     *
     * @author SailHe
     * @date 2018/1/28 20:44
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public AjaxMsgDTO queryUser(Integer primaryKey) {
        AjaxMsgDTO msgDTO = new AjaxMsgDTO();
        try {
            msgDTO.setData(userService.getRecord(primaryKey));
            msgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            msgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("获取用户失败", e);
        }
        return msgDTO;
    }

    /**
     * Descriptions: 删除primaryKey对应的那条记录<p>
     *
     * @author SailHe
     * @date 2018/1/28 13:52
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public AjaxMsgDTO deleteUser(Integer primaryKey) {
        AjaxMsgDTO msgDTO = new AjaxMsgDTO();
        try {
            msgDTO.setData(userService.deleteRecord(primaryKey));
            msgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            msgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("删除用户失败", e);
        }
        return msgDTO;
    }

    /**
     * Descriptions: 凭借主键分辨记录 更新该记录的非空内容<p>
     *
     * @author SailHe
     * @date 2018/1/28 15:10
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public AjaxMsgDTO updateUser(UserDTO record) {
        AjaxMsgDTO msgDTO = new AjaxMsgDTO();
        try {
            msgDTO.setData(userService.updateRecord(record));
            msgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            msgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("更新用户失败", e);
        }
        return msgDTO;
    }

    /**
     * Descriptions: 插入新增记录内的所有内容<p>
     *
     * @author SailHe
     * @date 2018/1/28 20:44
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public AjaxMsgDTO saveUser(UserDTO record) {
        AjaxMsgDTO jsonMsgDTO = new AjaxMsgDTO();
        try {
            jsonMsgDTO.setData(userService.saveRecord(record));
            jsonMsgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            jsonMsgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("保存用户失败", e);
        }
        return jsonMsgDTO;
    }

    /**
     * Descriptions: 插入新增记录内的非空内容<p>
     *
     * @author SailHe
     * @date 2018/1/28 20:44
     */
    @RequestMapping(value = "insert")
    @ResponseBody
    public AjaxMsgDTO insertUser(UserDTO record) {
        AjaxMsgDTO jsonMsgDTO = new AjaxMsgDTO();
        try {
            jsonMsgDTO.setData(userService.insertRecord(record));
            jsonMsgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            jsonMsgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("插入用户失败", e);
        }
        return jsonMsgDTO;
    }


    /**
     * Descriptions: 用户模糊查询接口<p>
     *
     * @author SailHe
     * @date 2018/10/1 21:54
     */
    @RequestMapping(value = "/fuzzyQuery")
    public AjaxMsgDTO fuzzyQuery(String search) {
        AjaxMsgDTO ajaxMsgDTO = new AjaxMsgDTO();
        try {
            ajaxMsgDTO.setData(userService.listFuzzyUser(search));
            ajaxMsgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            ajaxMsgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("用户模糊查询失败", e);
        }
        return ajaxMsgDTO;
    }
}

