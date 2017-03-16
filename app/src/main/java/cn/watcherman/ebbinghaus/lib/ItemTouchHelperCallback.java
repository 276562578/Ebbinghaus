package cn.watcherman.ebbinghaus.lib;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import cn.watcherman.ebbinghaus.MainActivity;
import cn.watcherman.ebbinghaus.data.InterfaceDatabase;
import java.text.ParseException;

/**
 * Created by minecraft on 17-3-15.
 */
public class ItemTouchHelperCallback extends ItemTouchHelper.Callback{
    ContentAdapter adapter;
    public ItemTouchHelperCallback (ContentAdapter mAdapter){
        adapter = mAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder){
        int dragFlags = 0,swipeFlags = ItemTouchHelper.END;
        return makeMovementFlags(dragFlags,swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        String _id = adapter.list.get(position)[0];
//        try {
//            boolean result =  new InterfaceDatabase("w").markHaveDone(_id);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        adapter.list.remove(position);
        adapter.notifyItemRemoved(position);

    }

    @Override
    public boolean isItemViewSwipeEnabled(){
        return true;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

}
