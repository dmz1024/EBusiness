package com.ediancha.edcbusiness.helper.pay;

/**
 * Created by dengmingzhi on 2017/10/11.
 */

public interface IPayResultInterface {

    void onSuccess();//支付成功

    void onCancel();//用户取消

    void onFaile(String msg);//支付失败


}
