package com.oudedemo.recycleview;

import android.app.*;
import android.os.*;
import android.support.v7.widget.*;
import java.util.*;

public class MainActivity extends Activity 
{
    private List<MyList> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initMylist();
        RecyclerView recycleView = (RecyclerView) findViewById(R.id.mainRecyclerView1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycleView.setLayoutManager(layoutManager);
        MyListAdapter adapter =new MyListAdapter(list);
        recycleView.setAdapter(adapter);
    }
    
    
    private void initMylist()
    {
        
            MyList  list1 = new MyList("RecycleView实现Activity跳转",R.drawable.ic_launcher);
            list.add(list1);
            MyList  list2 = new MyList("另一种实现点击和移除的方式",R.drawable.ic_launcher);
            list.add(list2);
            MyList  list3 = new MyList("List3",R.drawable.ic_launcher);
            list.add(list3);
            MyList  list4 = new MyList("List4",R.drawable.ic_launcher);            list.add(list4);
            MyList  list5 = new MyList("List5",R.drawable.ic_launcher);
            list.add(list5);
            MyList  list6 = new MyList("List6",R.drawable.ic_launcher);
            list.add(list6);
            MyList  list7 = new MyList("List7",R.drawable.ic_launcher);
            list.add(list7);
    }
    
}
