package chencheng.bwie.com.lianxi20180509.model;

import java.util.HashMap;

import chencheng.bwie.com.lianxi20180509.bean.BaseBean;
import chencheng.bwie.com.lianxi20180509.net.NetListenter;
import chencheng.bwie.com.lianxi20180509.net.RetrofitUtils;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/5/9.
 */

public class BaseModel implements IBaseModel {
    @Override
    public void getView(String pscid,String page,final NetListenter<BaseBean> netListenter) {
         HashMap<String, String> map = new HashMap<>();
     map.put("pscid",pscid);
        map.put("page",page);

        Flowable flowable= RetrofitUtils.getServerApi().baseBean("product/getProducts",map);
        flowable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<BaseBean>() {

                    @Override
                    public void accept(BaseBean baseBean) throws Exception {
                        netListenter.onSccess(baseBean);
                    }

                });
    }
}
