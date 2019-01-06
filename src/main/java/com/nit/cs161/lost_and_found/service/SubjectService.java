package com.nit.cs161.lost_and_found.service;

import com.nit.cs161.lost_and_found.dto.ItemDTO;
import com.nit.cs161.lost_and_found.dto.MessageDTO;
import com.nit.cs161.lost_and_found.dto.UserDTO;
import com.nit.cs161.lost_and_found.service.general.PageService;

import java.util.List;

/**
 * Descriptions: 业务逻辑<p>
 *
 * @author SailHe
 * @date 2018/10/1 15:43
 */
public interface SubjectService extends PageService<MessageDTO, Integer> {
    class SubjectType{
        private Byte value;
        private String name;

        public SubjectType(Byte value, String name){
            this.value = value;
            this.name = name;
        }

        public Byte getValue() {
            return value;
        }

        public void setValue(Byte value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * Descriptions: 列举所有的主题类型<p>
     *
     * @author SailHe
     * @date 2018/10/9 20:55
     */
    List<SubjectType> listSubjectType();

    /**
     * Descriptions: 依据传入消息主键返回该消息对应主题的消息列表<p>
     *
     * @author SailHe
     * @date 2018/12/13 16:34
     */
    List<MessageDTO> listSubjectMessage(Integer messageId) throws Exception;

    /**
     * Descriptions: 保存一个主题 或是保存一个普通消息<p>
     *
     * @author SailHe
     * @date 2018/10/9 21:04
     */
    Integer saveRecord(MessageDTO record, ItemDTO itemRecord) throws Exception;

    /**
     * Descriptions: 更新一个主题 或是一个普通消息<p>
     *
     * @author SailHe
     * @date 2019/1/6 10:44
     */
    Integer updateRecord(MessageDTO record, ItemDTO itemRecord) throws Exception;

}

