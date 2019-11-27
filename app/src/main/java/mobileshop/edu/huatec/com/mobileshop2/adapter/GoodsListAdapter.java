package mobileshop.edu.huatec.com.mobileshop2.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import mobileshop.edu.huatec.com.mobileshop2.R;
import mobileshop.edu.huatec.com.mobileshop2.http.entity.GoodsEntity;

public class GoodsListAdapter extends RecyclerView.Adapter<GoodsListAdapter.LeftViewHolder> implements View.OnClickListener {
    private final List<GoodsEntity> datas;
    private final Activity mContext;
    private OnItemClickListener onItemClickListener;

    public GoodsListAdapter(Activity activity,List<GoodsEntity> data){
        this.datas=data;
        this.mContext=activity;
    }
    @NonNull
    @Override
    public LeftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_goods_list,parent,false);
        view.setOnClickListener(this);
        return new LeftViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull LeftViewHolder holder, int position) {
        GoodsEntity entity=datas.get(position);
        holder.itemView.setTag(position);
        ImageLoader.getInstance().displayImage(entity.getSmall(),holder.goodslist_img);
        holder.goodslist_name.setText(entity.getName());
        holder.goodslist_price.setText("￥"+String.format("%.2f",entity.getPrice()));
    }

    @Override
    public int getItemCount() {
        if(datas!=null){
            return datas.size();
        }
        return 0;
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener!=null){
            int position=(int)view.getTag();
            GoodsEntity entity=datas.get(position);
            onItemClickListener.onItemClick(view,position,entity);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class LeftViewHolder extends RecyclerView.ViewHolder{
        public final ImageView goodslist_img;
        public final TextView goodslist_name,goodslist_price,goodslist_comments,goodslist_goodstype;



        public LeftViewHolder(View view){
            super(view);
            goodslist_img=itemView.findViewById(R.id.goodslist_img);
            goodslist_name=itemView.findViewById(R.id.goodslist_name);
            goodslist_price=itemView.findViewById(R.id.goodslist_price);
            goodslist_comments=itemView.findViewById(R.id.goodslist_comments);
            goodslist_goodstype=itemView.findViewById(R.id.goodslist_goodstype);

        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position,GoodsEntity entity);
    }
}
