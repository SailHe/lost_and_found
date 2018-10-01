package com.nit.cs161.lost_and_found.utility;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 泛型
 * @Author: 卫超越
 * @Date: 2018/4/10 下午9:17
 * @return:
 */
public abstract class EntityU {

    public <Dto, Entity> Entity toBean(Dto dto, Entity entity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] entityField = entity.getClass().getDeclaredFields();
        Field[] dtoField = dto.getClass().getDeclaredFields();
        for (Field dtoF : dtoField
                ) {
            String dtoName = dtoF.getName();
            String dtoUpName = dtoName.substring(0, 1).toUpperCase() + dtoName.substring(1);
            Method dtoMethod = dto.getClass().getMethod("get" + dtoUpName);
            for (Field enF : entityField
                    ) {
                String enName = enF.getName();
                String enUpName = enName.substring(0, 1).toUpperCase() + enName.substring(1);
                if (dtoUpName.equals(enUpName)) {
                    Method enMethod = entity.getClass().getMethod("set" + enUpName, enF.getType());
                    dtoMethod.invoke(dto);
                    enMethod.invoke(entity, dtoMethod.invoke(dto));
                }
            }
        }
        return entity;
    }



//    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
//        AdminDTO adminDTO = new AdminDTO("name",1,"real");
////        SysAdmin entityU = EntityU.getEntity(adminDTO, new SysAdmin());
//        adminDTO.toBean(adminDTO,new SysAdmin());
//
//    }


}
