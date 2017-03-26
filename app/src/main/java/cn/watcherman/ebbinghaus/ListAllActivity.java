package cn.watcherman.ebbinghaus;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.EditText;
import cn.watcherman.ebbinghaus.data.InterfaceDatabase;
import cn.watcherman.ebbinghaus.lib.ContentAdapter;
import cn.watcherman.ebbinghaus.lib.ContentAdapterOfAllRecord;
import cn.watcherman.ebbinghaus.lib.ItemTouchHelperCallback;

import java.util.List;

public class ListAllActivity extends AppCompatActivity {
    private InterfaceDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_of_all);
        database = new InterfaceDatabase(this,"r");
        setRecyclerView();
    }

    private void setRecyclerView(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.content_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        List<String[]> list = database.getList("all");
        ContentAdapterOfAllRecord contentAdapter = new ContentAdapterOfAllRecord(list);
        recyclerView.setAdapter(contentAdapter);
    }


}
