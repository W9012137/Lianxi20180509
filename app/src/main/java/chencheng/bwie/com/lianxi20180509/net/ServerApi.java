package chencheng.bwie.com.lianxi20180509.net;

import java.util.Map;

import chencheng.bwie.com.lianxi20180509.bean.BaseBean;
import io.reactivex.Flowable;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by dell on 2018/5/9.
 */

public interface ServerApi {
   @POST
    Flowable<BaseBean> baseBean(@Url String url, @QueryMap Map<String,String> map);
}
