package com.oudedemo.recycleview;

import android.app.Activity;
import android.os.Bundle;
import java.util.List;
import java.util.ArrayList;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.SearchView.OnCloseListener;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.Adapter;
import android.content.Intent;
import android.widget.Toast;

public class OtherActivity extends Activity 
{

    private List<OtherList> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);
        initOtherlist();
        RecyclerView recycleView = (RecyclerView) findViewById(R.id.otherRecyclerView1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);
        final OtherListAdapter adapter =new OtherListAdapter(OtherActivity.this,list);
        recycleView.setAdapter(adapter);
        //点击
        adapter.setOnItemClickListener(new OtherListAdapter.OnItemClickListener(){

                @Override
                public void onClick(int position)
                {
                    OtherList mylist = list.get(position);
                    switch(position){
                        default:
                            Toast.makeText(OtherActivity.this, "你点击了" + mylist.getName(), Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

                @Override
                public void onLongClick(int position)
                {
                    OtherList mylist = list.get(position);
                    switch(position){
                        default:
                            adapter.removeItem(position);
                            Toast.makeText(OtherActivity.this, "你删除了" + mylist.getName(), Toast.LENGTH_SHORT).show();
                            
                            break;
                    }
                }
            });
    }


    private void initOtherlist()
    {

        OtherList  list1 = new OtherList("List1",R.drawable.ic_launcher);
        list.add(list1);
        OtherList  list2 = new OtherList("List2",R.drawable.ic_launcher);
        list.add(list2);
        OtherList  list3 = new OtherList("List3",R.drawable.ic_launcher);
        list.add(list3);
        OtherList  list4 = new OtherList("List4",R.drawable.ic_launcher);            
        list.add(list4);
        OtherList  list5 = new OtherList("List5",R.drawable.ic_launcher);
        list.add(list5);
        OtherList  list6 = new OtherList("List6",R.drawable.ic_launcher);
        list.add(list6);
        OtherList  list7 = new OtherList("List7",R.drawable.ic_launcher);
        list.add(list7);
    }
}
