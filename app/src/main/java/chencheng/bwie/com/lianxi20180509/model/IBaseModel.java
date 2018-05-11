package chencheng.bwie.com.lianxi20180509.model;

import chencheng.bwie.com.lianxi20180509.bean.BaseBean;
import chencheng.bwie.com.lianxi20180509.net.NetListenter;

/**
 * Created by dell on 2018/5/9.
 */

public interface IBaseModel {
    void getView(String pscid,String page,NetListenter<BaseBean> netListenter);
}
