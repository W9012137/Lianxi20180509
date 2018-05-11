package chencheng.bwie.com.lianxi20180509.presenter;

import chencheng.bwie.com.lianxi20180509.bean.BaseBean;
import chencheng.bwie.com.lianxi20180509.model.BaseModel;
import chencheng.bwie.com.lianxi20180509.model.IBaseModel;
import chencheng.bwie.com.lianxi20180509.net.NetListenter;
import chencheng.bwie.com.lianxi20180509.view.IMainView;

/**
 * Created by dell on 2018/5/9.
 */

public class BasePresenter {
    private IMainView iMainView;
    private IBaseModel iBaseModel;

    public BasePresenter(IMainView iMainView) {
        this.iMainView = iMainView;
        iBaseModel=new BaseModel();
    }
    public void Showrx(final String pscid, final String page){
        iBaseModel.getView( pscid, page,new NetListenter<BaseBean>() {
            @Override
            public void onSccess(BaseBean baseBean) {
                iMainView.show(baseBean,pscid,page);
            }

            @Override
            public void onFailuer(Exception e) {

            }
        });
    }
}
