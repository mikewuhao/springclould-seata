package com.servera.utils;

import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.stereotype.Repository;
import org.springframework.util.ReflectionUtils;

import com.servera.mapper.po.BasePo;

@Repository
public class InjectCommonParam {
    /**
     * 插入前触发，填充公用参数
     *
     * @param obj 待设置公共参数的对象
     */
    public void insertFills(Object obj){

        //实际情况得从token中获取用户信息,先打个桩
        BasePo basePo = new BasePo();
        basePo.setCreateId("123456");
        basePo.setUpdateId("234567");
        basePo.setTenantId("345678");

        setField(obj, "setCreateId", basePo.getCreateId());
        setField(obj, "setUpdateId", basePo.getUpdateId());
        setField(obj, "setTenantId", basePo.getTenantId());

        setField(obj, "setCreateTime", new Date());
        setField(obj, "setUpdateTime", new Date());
        setField(obj, "setDeleteFlag", 0);
    }

    /**
     * 插入前触发，填充公用参数
     *
     * @param obj 待设置公共参数的对象
     */
    public void updateFills(Object obj){

        //实际情况得从token中获取用户信息,先打个桩
        BasePo basePo = new BasePo();
        basePo.setUpdateId("234567");

        setField(obj, "setUpdateId", basePo.getUpdateId());
        setField(obj, "setUpdateTime", new Date());
    }

    /**
     * @param obj 对象
     * @param methodName 方法名
     * @param value 待设置的值
     */
    private void setField(Object obj, String methodName, Object value){
        Method method = ReflectionUtils.findMethod(obj.getClass(), methodName, value == null ? String.class : value.getClass());
        if (method != null) {
            ReflectionUtils.invokeMethod(method, obj, value);
        }
    }
}