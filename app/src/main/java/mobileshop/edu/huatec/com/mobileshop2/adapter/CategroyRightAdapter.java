package mobileshop.edu.huatec.com.mobileshop2.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import mobileshop.edu.huatec.com.mobileshop2.R;
import mobileshop.edu.huatec.com.mobileshop2.http.entity.CategoryEntity;

public class CategroyRightAdapter extends RecyclerView.Adapter<CategroyRightAdapter.RightViewHolder> implements View.OnClickListener{
    private final List<CategoryEntity> datas;
    private final Activity mContext;
    private OnItemClickListener onItemClickListener;

    public CategroyRightAdapter(Activity activity,List<CategoryEntity>data){
        this.datas=data;
        this.mContext=activity;
    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_categroy_right,parent,false);
        view.setOnClickListener(this);
        return new RightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolder holder, int position) {
        CategoryEntity entity=datas.get(position);
        holder.itemView.setTag(position);
        ImageLoader.getInstance().displayImage(entity.getImage(),holder.iv_image);
        holder.tv_name.setText(entity.getName());
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
            CategoryEntity entity=datas.get(position);
            onItemClickListener.onItemClick(view,position,entity);
        }
    }
    //sssss32
    public class RightViewHolder extends RecyclerView.ViewHolder{
        public final TextView tv_name;
        public final ImageView iv_image;

        public RightViewHolder(View view){
            super(view);
            tv_name=view.findViewById(R.id.tv_name);
            iv_image=view.findViewById(R.id.iv_image);
        }
    }

    public void setOnItemClickListener(OnItemClickListener l){
        this.onItemClickListener=l;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position,CategoryEntity entity);
    }

}
