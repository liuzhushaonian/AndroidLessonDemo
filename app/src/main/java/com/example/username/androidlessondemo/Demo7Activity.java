package com.example.username.androidlessondemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Demo7Activity extends AppCompatActivity {


    private EditText word,trans,sear;
    private Button add,search;

    private DataBase database;

    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo7);

        getComponent();

        database=new DataBase(this,"demo7",null,1);

        sqLiteDatabase=database.getReadableDatabase();

        event();

        setTitle("生词本");
    }

    private void getComponent(){

        word=findViewById(R.id.editText11);
        trans=findViewById(R.id.editText12);
        sear=findViewById(R.id.editText13);

        add=findViewById(R.id.button4);

        search=findViewById(R.id.button5);

    }

    private void event(){

        /**
         * 插入事件
         */
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String w=word.getText().toString();

                String tran=trans.getText().toString();

                if (TextUtils.isEmpty(w)||TextUtils.isEmpty(tran)){

                    Toast.makeText(Demo7Activity.this, "输入不可为空", Toast.LENGTH_SHORT).show();

                    return;
                }

                String sql="insert into words (word,trans)values('"+w+"','"+tran+"')";

                sqLiteDatabase.execSQL(sql);

                Toast.makeText(Demo7Activity.this, "添加生词成功！", Toast.LENGTH_SHORT).show();

                word.setText("");

                trans.setText("");

            }
        });

        /**
         * 查询事件
         */
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s=sear.getText().toString();

                if (TextUtils.isEmpty(s)){
                    return;
                }

                String sql="select * from words where word like '%"+s+"%'";

                Cursor cursor=sqLiteDatabase.rawQuery(sql,null);

                if (cursor==null||cursor.getCount()==0){

                    Toast.makeText(Demo7Activity.this, "未找到任何单词", Toast.LENGTH_SHORT).show();

                    return;
                }

                if (cursor.moveToFirst()){

                    String word=cursor.getString(cursor.getColumnIndex("word"));

                    String tran=cursor.getString(cursor.getColumnIndex("trans"));

                    show(word,tran);
                }

                cursor.close();


            }
        });



    }

    private void show(String word,String trans){

        if (TextUtils.isEmpty(word)){

            Toast.makeText(this, "未找到任何单词", Toast.LENGTH_SHORT).show();

            return;
        }

        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        View view= LayoutInflater.from(this).inflate(R.layout.result,null,false);

        TextView wordText=view.findViewById(R.id.word_text);

        TextView tr=view.findViewById(R.id.translation);

        wordText.setText(word);

        tr.setText(trans);

        builder.setView(view).setTitle("找到的单词").show();



    }



}
