package cn.watcherman.ebbinghaus.lib;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.watcherman.ebbinghaus.R;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by minecraft on 17-3-13.
 */
public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ContentViewHolder> {
    List<String[]> list;

    public ContentAdapter(List<String[]> mList) {
        list = mList;
    }

    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.content_list, viewGroup, false);
        ContentViewHolder viewHolder = new ContentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContentViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView contentView, timesView, idView;

        ContentViewHolder(View itemView) {
            super(itemView);
            contentView = (TextView) itemView.findViewById(R.id.textView_content);
            timesView = (TextView) itemView.findViewById(R.id.textView_exec_times);
            idView = (TextView) itemView.findViewById(R.id.textView__ID);


        }

        void bind(String[] mList) {
            String _id = mList[0];
            String content = mList[1];
            String exec_times = mList[2];

            contentView.setText(content);
            timesView.setText(exec_times);
            idView.setText(_id);
        }


    }


}
