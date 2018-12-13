package com.nit.cs161.lost_and_found.service.impl;

import com.nit.cs161.lost_and_found.dto.ItemDTO;
import com.nit.cs161.lost_and_found.dto.general.DtRequestDTO;
import com.nit.cs161.lost_and_found.dto.general.DtResponseDTO;
import com.nit.cs161.lost_and_found.entity.laf.LafItem;
import com.nit.cs161.lost_and_found.repository.ItemRepository;
import com.nit.cs161.lost_and_found.repository.MessageRepository;
import com.nit.cs161.lost_and_found.service.ItemService;
import com.nit.cs161.lost_and_found.utility.Tools;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.LinkedList;
import java.util.List;

/**
 * Descriptions: 业务逻辑实现<p>
 *
 * @author SailHe
 * @date 2018/10/6 13:53
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemRepository itemRepository;

    @Resource
    private MessageRepository messageRepository;

    @Override
    public ItemDTO getRecord(String itemName) throws Exception {
        return new ItemDTO(Tools.uniqueList(itemRepository.findAllByItemName(itemName)));
    }

    @Override
    public List<ItemDTO> listFuzzyItem(String search) {
        return null;
    }

    @Override
    public DtResponseDTO getPageResponse(DtRequestDTO dtRequestDTO) throws Exception {
        Pageable pageable
                = new PageRequest(dtRequestDTO.start, dtRequestDTO.length, new Sort(Sort.Direction.DESC, "itemPickUpTime"));
        Page<LafItem> page;

        String search = dtRequestDTO.getSearch();
        boolean needSearch = search != null && search != "";
        List<Integer> itemIdList = new LinkedList<>();
        messageRepository.findAll().forEach(msgBean -> itemIdList.add(msgBean.getItemId()));
        Specification<LafItem> specification = (root, criteriaQuery, criteriaBuilder) -> {
            //过滤条件
            Predicate filter;
            //搜索处理
            if (needSearch) {
                filter = criteriaBuilder.or(
                        criteriaBuilder.like(root.get("itemName"), "%" + search + "%"),
                        criteriaBuilder.like(root.get("itemDesc"), "%" + search + "%")
                );
            } else {
                //itemState
                filter = root.get("itemId").in(itemIdList);
            }
            return filter;
        };
        page = itemRepository.findAll(specification, pageable);
        List<ItemDTO> pageList = new LinkedList<>();
        for (LafItem bean : page.getContent()) {
            pageList.add(new ItemDTO(bean));
        }
        DtResponseDTO dtResponseDTO = new DtResponseDTO(dtRequestDTO.getDraw(), page.getNumberOfElements(), (int) page.getTotalElements(), pageList);
        return dtResponseDTO;
    }

    @Override
    public ItemDTO getRecord(Integer integer) throws Exception {
        return new ItemDTO(itemRepository.findOne(integer));
    }

    @Override
    public Integer deleteRecord(Integer integer) throws Exception {
        return null;
    }

    @Override
    public Integer updateRecord(ItemDTO record) throws Exception {
        return null;
    }

    @Override
    public Integer saveRecord(ItemDTO record) throws Exception {
        return null;
    }

    @Override
    public Integer insertRecord(ItemDTO record) throws Exception {
        return null;
    }
}
