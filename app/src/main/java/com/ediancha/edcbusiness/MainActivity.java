package com.ediancha.edcbusiness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnHotUpdateRelaunch {
    TextView viewById;
    private HotUpdatePresenter hotUpdatePresenter;
    private EditText etContent;
    private View btStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewById = findViewById(R.id.tvContent);
        btStart = findViewById(R.id.btStart);
        etContent = findViewById(R.id.etContent);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aa();
            }
        });

        findViewById(R.id.btContent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hotUpdatePresenter.checkUpdate(Integer.parseInt(etContent.getText().toString()));
            }
        });
        hotUpdatePresenter = new HotUpdatePresenter(this);
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hotUpdatePresenter.kill();
            }
        });

    }

    public void aa() {
        Log.d("aa", "aaa");
    }

    public void ccc() {
        startActivity(new Intent(this, Main2Activity.class));
    }


    @Override
    public void onRelaunch(final int count) {
        etContent.post(new Runnable() {
            @Override
            public void run() {
                btStart.setVisibility(View.VISIBLE);
                viewById.setText("app修复了一些bug，建议您重启app原始版" + count);
            }
        });
    }
}
