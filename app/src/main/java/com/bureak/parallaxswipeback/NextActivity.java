package com.bureak.parallaxswipeback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * Created by bushijie33@gmail.com on 2015/7/5.
 */
public class NextActivity extends ParallaxSwipeBackActivity {
    private int[] images = new int[]{R.drawable.pic1, R.drawable.pic3, R.drawable.pic4, R.drawable.pic7};
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_next);
        index = getIntent().getIntExtra("index",0);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(images[index]);
        TextView textView = (TextView) findViewById(R.id.next);
        textView.setText(textView.getText().toString()+index);

        final Intent intent = new Intent(this,NextActivity.class);
        intent.putExtra("index",++index);
        if(index==images.length){
            textView.setText("FINISH ACTIVITY");
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index==images.length){
                    finish();
                    NextActivity.this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                }else
                startParallaxSwipeBackActivty(NextActivity.this,intent);
            }
        });

    }
}
