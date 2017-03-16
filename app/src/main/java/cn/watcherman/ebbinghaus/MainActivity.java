package cn.watcherman.ebbinghaus;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.EditText;
import cn.watcherman.ebbinghaus.data.InterfaceDatabase;
import cn.watcherman.ebbinghaus.lib.ContentAdapter;
import cn.watcherman.ebbinghaus.lib.ItemTouchHelperCallback;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private InterfaceDatabase database;
    private RecyclerView recyclerView;
    private ContentAdapter contentAdapter;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = new InterfaceDatabase(this,"r");
        setRecyclerView();
        SharedPreferences.Editor ebbinghausMemoryDay = getSharedPreferences(getString(R.string.ebbinghausMemoryDay_kel_file), MODE_PRIVATE).edit();
        ebbinghausMemoryDay.putInt("1",1);
        ebbinghausMemoryDay.apply();
    }

    private void setRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.content_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        List<String[]> list = database.getList();
        contentAdapter = new ContentAdapter(list);
        recyclerView.setAdapter(contentAdapter);
        //添加滑动删除处理
        itemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(contentAdapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public void addNewRecord(View view){
        EditText editText = (EditText) findViewById(R.id.content_input);
        String content = editText.getText().toString();
        if (!content.equals("")) {
            //提交至数据库
            if(new InterfaceDatabase(this,"w").putNewData(content)) {
                editText.setText("");
                //刷新卡片布局
                setRecyclerView();
                //设置滚动至底部
                int position = contentAdapter.getItemCount()-1;
                recyclerView.scrollToPosition(position);
            }
            else {
                addNewRecord(view);
            }
        }
    }
}
