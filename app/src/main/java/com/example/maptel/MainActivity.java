package com.example.maptel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //地図連携メソッド
    public void map(View view){
    //文字列取得
        Resources res = getResources();
        String address = res.getString(R.string.map_address);
    //地図インテント
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q="+address));
        startActivity(intent);
    }

    //電話連携のメソッド
    public void call(View view){
    //電話番号取得
        EditText textInput = (EditText)findViewById(R.id.editText1);
        String call= textInput.getText().toString();
    //電話インテント
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+call));
        startActivity(intent);
    }
}