package mobileshop.edu.huatec.com.mobileshop2.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import mobileshop.edu.huatec.com.mobileshop2.R;
import mobileshop.edu.huatec.com.mobileshop2.http.entity.CategoryEntity;

public class CategroyLeftAdapter extends RecyclerView.Adapter<CategroyLeftAdapter.LeftViewHolder> implements View.OnClickListener {

    private final List<CategoryEntity> datas;
    private final Activity mContext;
    private OnItemClickListener onItemClickListener;
    private int select=0;
    public CategroyLeftAdapter(Activity activity,List<CategoryEntity> data){
        this.datas=data;
        this.mContext=activity;
    }


    public void setOnItemClickListener(OnItemClickListener l){
        this.onItemClickListener =l;
    }
    @NonNull
    @Override
    public LeftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_categroy_left,parent,false);
        view.setOnClickListener(this);
        return new LeftViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategroyLeftAdapter.LeftViewHolder holder, int position) {
        if (select==position){
            holder.ll_item.setBackgroundResource(android.R.color.white);
        }else{
            holder.ll_item.setBackgroundColor(Color.parseColor("#fff3f4f6"));
        }
        CategoryEntity entity=datas.get(position);
        holder.itemView.setTag(position);
        holder.tv_name.setText(entity.getName());
    }
    @Override
    public int getItemCount() {
        if(datas!=null){
            return datas.size();
        }
        return 0;
    }

    public void setSelect(int select){
        this.select=select;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener!=null){
            int position=(int)view.getTag();
            CategoryEntity entity=datas.get(position);
            onItemClickListener.onItemClick(view,position,entity);
        }
    }

    public class LeftViewHolder extends RecyclerView.ViewHolder{
        public final TextView tv_name;
        public final LinearLayout ll_item;

        public LeftViewHolder(View view){
            super(view);
            ll_item=view.findViewById(R.id.ll_item);
            tv_name=view.findViewById(R.id.tv_name);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position,CategoryEntity entity);
    }
}