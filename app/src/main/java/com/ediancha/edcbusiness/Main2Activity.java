package com.ediancha.edcbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv = findViewById(R.id.textView);
        tv.setText("倒海翻江卡顿浩丰科技德哈卡就浩丰科技");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "aaa", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main2Activity.this, Main4Activity.class));
            }
        });
        Toast.makeText(this, "ddddddd", Toast.LENGTH_SHORT).show();

    }

    private void a() {
//        Toast.makeText(this, "啊啊啊aaaaaa", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "bbbbbb", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "cccccc", Toast.LENGTH_SHORT).show();
    }
}
