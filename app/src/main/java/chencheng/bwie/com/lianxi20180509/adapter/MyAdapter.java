package chencheng.bwie.com.lianxi20180509.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import chencheng.bwie.com.lianxi20180509.R;
import chencheng.bwie.com.lianxi20180509.bean.BaseBean;

/**
 * Created by dell on 2018/5/9.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private Context context;
private List<BaseBean.DataBean> list;
    private static int TYPE1=0;
    private static int TYPE2=1;

    public MyAdapter(Context context, List<BaseBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
//多条目判断
    @Override
    public int getItemViewType(int position) {
        return position%2==0?TYPE1:TYPE2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        if (viewType==TYPE1){
            View view= LayoutInflater.from(context).inflate(R.layout.item1,null);
            viewHolder=new ViewHoldeone(view);
        }else{
            View view= LayoutInflater.from(context).inflate(R.layout.item2,null);
            viewHolder=new ViewHoldetwo(view);
        }
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
          if (holder instanceof ViewHoldeone){
              ViewHoldeone viewHoldeone= (ViewHoldeone) holder;

              viewHoldeone.title.setText(list.get(position).getTitle());
              //设置图片显示
              String uri = list.get(position).getImages().split("\\|")[0];
              DraweeController controller = Fresco.newDraweeControllerBuilder()
                      .setUri(uri)
                      .setAutoPlayAnimations(true)
                      .build();
              viewHoldeone.item1_iv.setController(controller);
          }else {
              ViewHoldetwo viewHoldetwo= (ViewHoldetwo) holder;
              //设置图片显示
              String uri = list.get(position).getImages().split("\\|")[0];
              DraweeController controller = Fresco.newDraweeControllerBuilder()
                      .setUri(uri)
                      .setAutoPlayAnimations(true)
                      .build();
              viewHoldetwo.item2_iv.setController(controller);
              viewHoldetwo.name.setText(list.get(position).getTitle());
          }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHoldeone extends RecyclerView.ViewHolder {
        SimpleDraweeView item1_iv;
        TextView title;
        public ViewHoldeone(View itemView) {
            super(itemView);
            item1_iv=itemView.findViewById(R.id.item1_iv);
            title=itemView.findViewById(R.id.title);
        }
    }
    class ViewHoldetwo extends RecyclerView.ViewHolder {
        SimpleDraweeView item2_iv;
        TextView name;
        public ViewHoldetwo(View itemView) {
            super(itemView);
            item2_iv=itemView.findViewById(R.id.item2_iv);
            name=itemView.findViewById(R.id.name);
        }
    }
}
