package com.nit.cs161.lost_and_found.controller;


import com.nit.cs161.lost_and_found.constant.general.ProjectConstants;
import com.nit.cs161.lost_and_found.dto.general.AjaxMsgDTO;
import com.nit.cs161.lost_and_found.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;


/**
 * Descriptions: API控制<p>
 *
 * @author SailHe
 * @date 2018/10/1 15:42
 */
@RestController
@RequestMapping("api/")
public class ApiController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ApiController.class);

    @Resource
    private final UserService userService;

    public ApiController(UserService userService){
        this.userService = userService;
    }

    /**
     * Descriptions: 返回菜单<p>
     *
     * @author SailHe
     * @date 2018/10/1 18:58
     */
    @RequestMapping(value = "menu/listMenu")
    public AjaxMsgDTO listMenu(){
        AjaxMsgDTO ajaxMsgDTO = new AjaxMsgDTO();
        try {
            List<String> menuList = new LinkedList<>();
            menuList.add("菜单1");
            ajaxMsgDTO.setData(menuList);
            ajaxMsgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e){
            ajaxMsgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("获取菜单列表失败", e);
        }
        return ajaxMsgDTO;
    }
}

