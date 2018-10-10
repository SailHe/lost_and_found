package com.nit.cs161.lost_and_found.controller;


import com.nit.cs161.lost_and_found.constant.general.ProjectConstants;
import com.nit.cs161.lost_and_found.dto.ItemDTO;
import com.nit.cs161.lost_and_found.dto.MessageDTO;
import com.nit.cs161.lost_and_found.dto.general.AjaxMsgDTO;
import com.nit.cs161.lost_and_found.dto.general.DtRequestDTO;
import com.nit.cs161.lost_and_found.dto.general.DtResponseDTO;
import com.nit.cs161.lost_and_found.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * Descriptions: 路由控制<p>
 *
 * @author SailHe
 * @date 2018/10/1 15:42
 */
@RestController
@RequestMapping("subject/")
public class SubjectController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SubjectController.class);

    @Resource
    private SubjectService subjectService;

    @RequestMapping(value = "/queryPage")
    public DtResponseDTO getPageResponse(DtRequestDTO dtRequestDTO) {
        DtResponseDTO dtResponseDTO = new DtResponseDTO();
        try {
            dtResponseDTO = subjectService.getPageResponse(dtRequestDTO);
        } catch (Exception e) {
            LOGGER.error("消息页面获取失败", e);
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
    public AjaxMsgDTO querySubject(Integer primaryKey) {
        AjaxMsgDTO msgDTO = new AjaxMsgDTO();
        try {
            msgDTO.setData(subjectService.getRecord(primaryKey));
            msgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            msgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("获取主题失败", e);
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
    public AjaxMsgDTO deleteSubject(Integer primaryKey) {
        AjaxMsgDTO msgDTO = new AjaxMsgDTO();
        try {
            msgDTO.setData(subjectService.deleteRecord(primaryKey));
            msgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            msgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("删除主题失败", e);
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
    public AjaxMsgDTO updateSubject(MessageDTO record) {
        AjaxMsgDTO msgDTO = new AjaxMsgDTO();
        try {
            msgDTO.setData(subjectService.updateRecord(record));
            msgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            msgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("更新主题失败", e);
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
    public AjaxMsgDTO saveSubject(MessageDTO record, ItemDTO itemRecord) {
        AjaxMsgDTO jsonMsgDTO = new AjaxMsgDTO();
        try {
            jsonMsgDTO.setData(subjectService.saveRecord(record, itemRecord));
            jsonMsgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            jsonMsgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("保存主题失败", e);
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
    public AjaxMsgDTO insertSubject(MessageDTO record) {
        AjaxMsgDTO jsonMsgDTO = new AjaxMsgDTO();
        try {
            jsonMsgDTO.setData(subjectService.insertRecord(record));
            jsonMsgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            jsonMsgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("插入主题失败", e);
        }
        return jsonMsgDTO;
    }

    @RequestMapping(value = "listSubjectType")
    @ResponseBody
    public AjaxMsgDTO listSubjectType() {
        AjaxMsgDTO msgDTO = new AjaxMsgDTO();
        try {
            msgDTO.setData(subjectService.listSubjectType());
            msgDTO.setSuccess(ProjectConstants.SUCCESS);
        } catch (Exception e) {
            msgDTO.setSuccess(ProjectConstants.FAILURE);
            LOGGER.error("获取主题类型列表失败", e);
        }
        return msgDTO;
    }
}

