package chencheng.bwie.com.lianxi20180509.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import chencheng.bwie.com.lianxi20180509.R;
import chencheng.bwie.com.lianxi20180509.adapter.MyAdapter;
import chencheng.bwie.com.lianxi20180509.bean.BaseBean;
import chencheng.bwie.com.lianxi20180509.presenter.BasePresenter;

public class MainActivity extends AppCompatActivity implements IMainView {

    private XRecyclerView mXrView;
    BasePresenter presenter;
    String pscid="39";
    int page=1;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter=new BasePresenter(this);
        presenter.Showrx(pscid,page+"");

    }


    private void initView() {
        mXrView = (XRecyclerView) findViewById(R.id.xr_view);
        mXrView.setLayoutManager(new LinearLayoutManager(this));
        mXrView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page--;
                presenter.Showrx(pscid,page+"");
                adapter.notifyDataSetChanged();
              mXrView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                presenter.Showrx(pscid,page+"");
                adapter.notifyDataSetChanged();
                mXrView.loadMoreComplete();
            }
        });
    }

    @Override
    public void show(BaseBean baseBean,String pscid,String page) {
        adapter = new MyAdapter(MainActivity.this,baseBean.getData());
        mXrView.setAdapter(adapter);
    }
}
