package com.oudedemo.recycleview;
import android.support.v7.widget.RecyclerView;
import java.util.List;
import android.view.View;
import android.widget.*;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Context;

public class OtherListAdapter extends RecyclerView.Adapter<OtherListAdapter.ViewHolder>
{
    private List<OtherList> mOtherList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener)
    {
        
        this.mOnItemClickListener = onItemClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View OtherListView;
        ImageView OtherListImage;
        TextView OtherListName;

        public ViewHolder(View view) {
            super(view);
            OtherListView = view;
            OtherListImage = (ImageView) view.findViewById(R.id.list_image);
            OtherListName = (TextView) view.findViewById(R.id.list_name);
        }
    }

    public OtherListAdapter(Context context,List<OtherList> otherList) {
        mOtherList = otherList;
        mContext = context;
    }
    //点击接口
    public interface OnItemClickListener {
        void onClick(int position);
        void onLongClick(int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mylist, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        OtherList otherList = mOtherList.get(position);
        holder.OtherListImage.setImageResource(otherList.getImageId());
        holder.OtherListName.setText(otherList.getName());
        if( mOnItemClickListener!= null){
            holder.itemView.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickListener.onClick(position);
                    }
                });
            holder. itemView.setOnLongClickListener( new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        mOnItemClickListener.onLongClick(position);
                        return true;
                    }
                });
      }
    }
    
    @Override
    public int getItemCount() {
        return mOtherList.size();
    }

    //自定义删除操作
    public void removeItem(int pos)
    {
        mOtherList.remove(pos);
        notifyItemRemoved(pos);
        notifyItemRangeChanged(pos,getItemCount());
    }      

}
