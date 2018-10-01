package com.nit.cs161.lost_and_found.constant.general;

import com.nit.cs161.lost_and_found.constant.EnumPlatform;

/**
 * Description: 枚举示例<p>
 *
 * @Package: com.nit.cs161.lost_and_found.constant
 * @author: SailHe
 * @date: 2018/7/25 10:52
 */
public class DemoForEnum {
    public static void main(String[] args) {
        //前后端逻辑处理时尽量使用英文名或value; 储存时使用value; 中文名name仅在显示的时候使用(如果需要显示的话)
        System.out.println("controller处理前端传来的参数: " + EnumPlatform.valueOf("WEB"));
        System.out.println("前端显示时: " + EnumPlatform.WEB.getName());
        System.out.println("数据库存储时: " + EnumPlatform.WEB.getValue());
        //这个会报异常
        System.out.println("error示范: " + EnumPlatform.valueOf("wEB"));
    }
}
/**
 * 使用枚举的(除去----XXX----的)
 * order_state 订单状态：CANCEL(已取消); INIT(默认):未付款; PAYED:已付款; DELIVE:已发货; RECEIVE:已收货;
 * ----XXX----order_refund_state 退款状态:NO_REFUND是无退款,PART_REFUND是部分退款,ALL_REFUND是全部退款
 * order_comment_state 买家评价状态 NO未评价，YES已评价
 * order_payment_way 支付方式WX,ALIPAY,CARD (暂未使用)
 * order_origin  订单来源: WEB, APP, WORKER
 * order_is_lock 锁定状态:0是正常,1是锁定,默认是0
 * order_is_del  删除状态NO未删除YES放入回收站FOREVER彻底删除
 */
