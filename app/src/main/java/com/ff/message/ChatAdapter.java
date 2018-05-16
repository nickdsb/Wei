package com.ff.message;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ff.Bean.Message;
import com.ff.ThisAPP;
import com.ff.wei.R;

import java.util.List;

/**
 * Created by Kr on 2018/5/15.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatAdapterViewHolder> {
    private List<Message> datalist;


    public ChatAdapter(List<Message> datalist)
    {
        this.datalist=datalist;
    }

    @Override
    //1表示自己发送的信息，2表示其他人的信息
    public ChatAdapter.ChatAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       switch (viewType){
           case 1:
               return new ChatAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_self,parent,false));
           case 2:
               return new ChatAdapterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item_other,parent,false));
       }
        return null;
    }

    @Override
    public void onBindViewHolder(ChatAdapter.ChatAdapterViewHolder holder, int position) {
        holder.setData(datalist.get(position).getAvatarURL(),datalist.get(position).getContent());
    }


    public int getItemViewType(int position)
    {
        if(datalist.get(position).getFrom() == ThisAPP.getSelfID())
            return 1;
        else
            return 2;
    }

    @Override
    public int getItemCount() { return datalist != null ? datalist.size() : 0;}


    public static class ChatAdapterViewHolder extends RecyclerView.ViewHolder{

        private RelativeLayout item;
        private ImageView avatar;
        private TextView content;

        public ChatAdapterViewHolder(View itemView) {
            super(itemView);
            item = (RelativeLayout) itemView;
            Log.d("***************** ", " "+itemView+" "+item.getChildAt(0)+item.getChildAt(1));
            avatar = (ImageView)item.getChildAt(0);
            content = (TextView)item.getChildAt(1);
        }

        public void setData(String imgURL,String str)
        {
            this.content.setText(str);
            //this.avatar.setBackground("");
        }

    }
}
