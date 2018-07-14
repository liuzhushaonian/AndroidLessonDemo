package com.example.username.androidlessondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Demo2Activity extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);

        getComponent();

        initList();

        setTitle("列表测试");
    }

    private void getComponent(){

        listView=findViewById(R.id.list);

    }

    /**
     * 实例化列表
     */
    private void initList(){

        adapter=new ListViewAdapter();

        List<String> stringList=new ArrayList<>();

        for (int i=0;i<100;i++){

            int d=i+1;

            String s="这是第"+d+"个怂";

            stringList.add(s);

        }
        listView.setAdapter(adapter);
        adapter.setStringList(stringList);

    }


    class ListViewAdapter extends BaseAdapter{

        List<String> stringList;

        public void setStringList(List<String> stringList) {
            this.stringList = stringList;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {

            if (this.stringList!=null){
                return this.stringList.size();
            }

            return 0;
        }

        @Override
        public Object getItem(int position) {
            return this.stringList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (this.stringList==null){
                return null;
            }

            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
            }

            TextView textView=convertView.findViewById(R.id.item_text);

            textView.setText(this.stringList.get(position));

            return convertView;

        }
    }

}
