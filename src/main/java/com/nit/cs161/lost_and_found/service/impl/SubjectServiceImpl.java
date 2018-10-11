package com.nit.cs161.lost_and_found.service.impl;

import com.nit.cs161.lost_and_found.constant.EnumMessageType;
import com.nit.cs161.lost_and_found.dto.ItemDTO;
import com.nit.cs161.lost_and_found.dto.MessageDTO;
import com.nit.cs161.lost_and_found.dto.SubjectDTO;
import com.nit.cs161.lost_and_found.dto.UserDTO;
import com.nit.cs161.lost_and_found.dto.general.DtRequestDTO;
import com.nit.cs161.lost_and_found.dto.general.DtResponseDTO;
import com.nit.cs161.lost_and_found.entity.SysUser;
import com.nit.cs161.lost_and_found.entity.laf.LafItem;
import com.nit.cs161.lost_and_found.entity.laf.LafMessage;
import com.nit.cs161.lost_and_found.repository.ItemRepository;
import com.nit.cs161.lost_and_found.repository.MessageRepository;
import com.nit.cs161.lost_and_found.repository.UserRepository;
import com.nit.cs161.lost_and_found.service.SubjectService;
import com.nit.cs161.lost_and_found.utility.Tools;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Descriptions: 业务逻辑实现<p>
 *
 * @author SailHe
 * @date 2018/10/6 13:53
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private ItemRepository itemRepository;

    @Resource
    private MessageRepository messageRepository;

    @Resource
    private UserRepository userRepository;

    @Override
    public DtResponseDTO getPageResponse(DtRequestDTO dtRequestDTO) throws Exception {
        // dtRequestDTO.start / dtRequestDTO.length 表示页数(从0开始); start表示这一页的起始元素的num-1
        Pageable pageable
                = new PageRequest(dtRequestDTO.start / dtRequestDTO.length, dtRequestDTO.length, new Sort(Sort.Direction.DESC, "createTime"));
        Page<LafMessage> page;
        String search = dtRequestDTO.getSearch();
        boolean needSearch = search != null && search != "";
        List<Integer> itemIdList = new LinkedList<>();
        List<LafItem> itemList = itemRepository.findAll();
        Map<Integer, LafItem> itemIdMapItem = new HashMap<>(50);
        Tools.calcKeyMapBean(itemList, itemIdMapItem, bean -> bean.getItemId());
        // 显示时以item为主 然后是message
        itemList.forEach(bean -> itemIdList.add(bean.getItemId()));
        Specification<LafMessage> specification = (root, criteriaQuery, criteriaBuilder) -> {
            //过滤条件
            Predicate filter;
            //搜索处理
            if (needSearch) {
                filter = criteriaBuilder.or(
                        criteriaBuilder.equal(root.get("itemId"), "%" + search + "%")
                        /*, criteriaBuilder.equal(root.get("userId"), "%" + search + "%")*/
                );
            } else {
                // 显示所有主题(不是普通消息就视为主题)
                filter = criteriaBuilder.and(
                        root.get("itemId").in(itemIdList)
                        , criteriaBuilder.notEqual(root.get("messageType"), EnumMessageType.ORDINARY.getValue())
                );
            }
            return filter;
        };
        page = messageRepository.findAll(specification, pageable);

        List<Integer> userIdList = new LinkedList<>();
        page.getContent().forEach(bean -> userIdList.add(bean.getUserId()));
        List<SysUser> userList = userRepository.findAll(userIdList);
        Map<Integer, SysUser> userIdMapUser = new HashMap<>(50);
        Tools.calcKeyMapBean(userList, userIdMapUser, bean -> bean.getUserId());

        List<SubjectDTO> pageList = new LinkedList<>();
        for (LafMessage bean : page.getContent()) {
            pageList.add(new SubjectDTO(bean, itemIdMapItem.get(bean.getItemId()), userIdMapUser.get(bean.getUserId())));
        }
        DtResponseDTO dtResponseDTO = new DtResponseDTO(dtRequestDTO.getDraw(), page.getNumberOfElements(), (int) page.getTotalElements(), pageList);
        return dtResponseDTO;
    }

    @Override
    public MessageDTO getRecord(Integer integer) throws Exception {
        return null;
    }

    @Override
    public Integer deleteRecord(Integer integer) throws Exception {
        return null;
    }

    @Override
    public Integer updateRecord(MessageDTO record) throws Exception {
        return null;
    }

    @Override
    public Integer saveRecord(MessageDTO record) throws Exception {
        return null;
    }

    @Override
    public List<MessageDTO> listSubjectMessage(Integer itemId) {
        List<MessageDTO> messageDTOList = new LinkedList<>();
        messageRepository.findAllByItemId(itemId).forEach(bean -> messageDTOList.add(new MessageDTO(bean)));
        return messageDTOList;
    }

    @Override
    public Integer saveRecord(MessageDTO record, ItemDTO itemRecord) throws Exception {
        if (record.getMessageType().equals(EnumMessageType.ORDINARY.getValue())) {
            // 普通消息: 直接保存message即可
        } else {
            // 创建一个主题: 先创建一个item 再创建message
            itemRecord.setItemId(itemRepository.save(itemRecord.toBean()).getItemId());
            record.setItemId(itemRecord.getItemId());
        }
        return messageRepository.save(record.toBean()).getMessageId();
    }

    @Override
    public Integer insertRecord(MessageDTO record) throws Exception {
        return null;
    }

    @Override
    public List<SubjectType> listSubjectType() {
        List<SubjectType> subjectTypeList = new LinkedList<>();
        for (EnumMessageType e : EnumMessageType.values()) {
            subjectTypeList.add(new SubjectType(e.getValue(), e.getName()));
        }
        return subjectTypeList;
    }
}
