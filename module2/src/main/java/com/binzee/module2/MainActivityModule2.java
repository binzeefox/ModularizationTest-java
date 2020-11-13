package com.binzee.module2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.binzee.commonlib.BaseActivity;

@Route(path = "/module2/main")
public class MainActivityModule2 extends BaseActivity {

    @Autowired
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_module2);
        setTitle("Module2");
        new AlertDialog.Builder(this)
                .setMessage(text)
                .setCancelable(true)
                .show();
    }
}