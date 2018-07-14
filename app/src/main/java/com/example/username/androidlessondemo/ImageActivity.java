package com.example.username.androidlessondemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        getComponent();

        initList();

        setTitle("头像选择");

    }

    private void getComponent(){

        recyclerView=findViewById(R.id.image_list);

    }


    private void initList(){

        gridLayoutManager=new GridLayoutManager(this,4);

        ImageAdapter adapter=new ImageAdapter();

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(gridLayoutManager);

        try {
            String files[]=getAssets().list("image");

            List<String> stringList = new ArrayList<>(Arrays.asList(files));

            adapter.setFiles(stringList);

        } catch (IOException e) {
            e.printStackTrace();
        }




    }


    class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder>{


        private List<String> files;


        public void setFiles(List<String> files) {
            this.files = files;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {

            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item,parent,false);

            final ViewHolder viewHolder=new ViewHolder(view);

            viewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String s=files.get(viewHolder.getAdapterPosition());

                    Intent intent=new Intent();
                    intent.putExtra("image",s);

                    setResult(2000,intent);

                    finish();

                }
            });

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            if (files==null){
                return;
            }

            String s=files.get(position);

            String path="image/"+s;

            try {
                InputStream inputStream=getAssets().open(path);

                Bitmap bitmap=BitmapFactory.decodeStream(inputStream);

                holder.imageView.setImageBitmap(bitmap);

                Log.d("in------>>>",inputStream.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }



//            Glide.with(holder.view.getContext()).load(path).into(holder.imageView);

        }

        @Override
        public int getItemCount() {

            if (files!=null){
                return files.size();
            }

            return 0;
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            private View view;
            private ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);

                view=itemView;

                imageView=itemView.findViewById(R.id.item_image);

                reDraw();
            }

            private void reDraw(){

                GridLayoutManager.LayoutParams params = (GridLayoutManager.LayoutParams) view.getLayoutParams();

                int space=this.view.getResources().getDimensionPixelSize(R.dimen.album_item_space)*2;

                int w = (ImageActivity.this.getResources().getDisplayMetrics().widthPixels-space) / 4;

                params.width = w;
                params.height = w;

                view.setLayoutParams(params);

            }
        }

    }

}
