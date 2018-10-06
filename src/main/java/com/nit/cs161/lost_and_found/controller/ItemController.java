package com.nit.cs161.lost_and_found.controller;


import com.nit.cs161.lost_and_found.constant.general.ProjectConstants;
import com.nit.cs161.lost_and_found.dto.ItemDTO;
import com.nit.cs161.lost_and_found.dto.general.AjaxMsgDTO;
import com.nit.cs161.lost_and_found.dto.general.DtRequestDTO;
import com.nit.cs161.lost_and_found.dto.general.DtResponseDTO;
import com.nit.cs161.lost_and_found.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Descriptions: 物品路由控制<p>
 *
 * @author SailHe
 * @date 2018/10/1 15:42
 */
@RestController
@RequestMapping("item/")
public class ItemController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Resource
    private ItemService itemService;

    @RequestMapping(value = "/queryPage")
    public DtResponseDTO getPageResponse(DtRequestDTO dtRequestDTO) {
        DtResponseDTO dtResponseDTO = new DtResponseDTO();
        try {
            dtResponseDTO = itemService.getPageResponse(dtRequestDTO);
        } catch (Exception e) {
            LOGGER.error("物品页面获取失败", e);
        }
        return dtResponseDTO;
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
            msgDTO.setData(itemService.getRecord(primaryKey));
            msgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            msgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("获取物品失败", e);
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
            msgDTO.setData(itemService.deleteRecord(primaryKey));
            msgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            msgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("删除物品失败", e);
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
    public AjaxMsgDTO updateUser(ItemDTO record) {
        AjaxMsgDTO msgDTO = new AjaxMsgDTO();
        try {
            msgDTO.setData(itemService.updateRecord(record));
            msgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            msgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("更新物品失败", e);
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
    public AjaxMsgDTO saveUser(ItemDTO record) {
        AjaxMsgDTO jsonMsgDTO = new AjaxMsgDTO();
        try {
            jsonMsgDTO.setData(itemService.saveRecord(record));
            jsonMsgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            jsonMsgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("保存物品失败", e);
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
    public AjaxMsgDTO insertUser(ItemDTO record) {
        AjaxMsgDTO jsonMsgDTO = new AjaxMsgDTO();
        try {
            jsonMsgDTO.setData(itemService.insertRecord(record));
            jsonMsgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            jsonMsgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("插入物品失败", e);
        }
        return jsonMsgDTO;
    }


    /**
     * Descriptions: 物品模糊查询接口<p>
     *
     * @author SailHe
     * @date 2018/10/1 21:54
     */
    @RequestMapping(value = "/fuzzyQuery")
    public AjaxMsgDTO fuzzyQuery(String search) {
        AjaxMsgDTO ajaxMsgDTO = new AjaxMsgDTO();
        try {
            ajaxMsgDTO.setData(itemService.listFuzzyItem(search));
            ajaxMsgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            ajaxMsgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("物品模糊查询失败", e);
        }
        return ajaxMsgDTO;
    }
}

