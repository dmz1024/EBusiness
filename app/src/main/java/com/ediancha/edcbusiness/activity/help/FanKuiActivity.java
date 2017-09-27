package com.ediancha.edcbusiness.activity.help;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.dmz.library.dmzapi.api.LogUtil;
import com.dmz.library.dmzapi.view.activity.ToobarBaseActivity;
import com.ediancha.edcbusiness.R;
import com.ediancha.edcbusiness.helper.FilePathUtils;

import java.util.ArrayList;


/**
 * Created by Admin on 2017/9/27.
 */
@Route(path = "/activity/help/fankui")
public class FanKuiActivity extends ToobarBaseActivity {

    private static final int REQUEST_CODE_PICK_IMAGE=3;

    private Spinner mSpChose;
    private EditText mEtContent;
    private ImageView mIvImage;
    private LinearLayout mLnImage;
    private TextView mTvSubmit;

    @Override
    protected void initView() {
        super.initView();
        mSpChose=findViewById(R.id.sp_chose);
        mTvSubmit=findViewById(R.id.tv_submit);
        mLnImage=findViewById(R.id.ln_image);
        mIvImage=findViewById(R.id.iv_image);

        initSpinner();

        click();
    }

    private void click() {
        mIvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPhoto();
            }
        });
    }

    private void initSpinner() {
        final ArrayList<String> mList = new ArrayList();
        mList.add("门锁损坏");
        mList.add("设备损坏");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.item_spinner_show, mList) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
//                    设置spinner展开的Item布局
                    convertView = getLayoutInflater().inflate(R.layout.item_spinner_textview, parent, false);
                }
                TextView spinnerText = (TextView) convertView.findViewById(R.id.spinner_textView);
                spinnerText.setText(getItem(position));
                return convertView;
            }
        };
        mSpChose.setAdapter(arrayAdapter);
//        spinner设置监听
        mSpChose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FanKuiActivity.this,"你选的是的是第"+position,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    protected void initBarView() {
        super.initBarView();
        dmzBar.setText("在线反馈");
    }


    @Override
    protected int getRid() {
        return R.layout.activity_fankui;
    }

    private void openPhoto(){
        /**
         * 打开选择图片的界面
         */
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       switch (requestCode){
           case REQUEST_CODE_PICK_IMAGE:
               if (resultCode == RESULT_OK) {
                   try {
                       /**
                        * 该uri是上一个Activity返回的
                        */
                       Uri uri = data.getData();
                       Bitmap bit = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                       String realPathFromUri = FilePathUtils.getRealFilePath(FanKuiActivity.this, uri);
                       LogUtil.e("图片路径"+ realPathFromUri);
                       mIvImage.setImageBitmap(bit);
                   } catch (Exception e) {
                       e.printStackTrace();
                       Log.d("tag",e.getMessage());
                       Toast.makeText(this,"程序崩溃",Toast.LENGTH_SHORT).show();
                   }
               }
               else{
                   Log.i("liang", "失败");
               }

               break;
       }
    }
}
