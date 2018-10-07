package com.nit.cs161.lost_and_found.service;

import com.nit.cs161.lost_and_found.dto.MessageDTO;
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
    List<SubjectType> listSubjectType();
}

