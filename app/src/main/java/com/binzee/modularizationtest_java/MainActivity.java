package com.binzee.modularizationtest_java;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.binzee.commonlib.BaseActivity;

@Route(path = "/app/main")
public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button0).setOnClickListener(this::onClick);
        findViewById(R.id.button1).setOnClickListener(this::onClick);
        findViewById(R.id.button2).setOnClickListener(this::onClick);
    }

    private void onClick(View v) {
        final int buttonId0 = R.id.button0;
        final int buttonId1 = R.id.button1;
        final int buttonId2 = R.id.button2;
        switch (v.getId()) {
            case buttonId0:
                navigate("/module0/main", "你刚刚在主Module点了进入Module0");
                break;
            case buttonId1:
                navigate("/module1/main", "你刚刚在主Module点了进入Module1");
                break;
            case buttonId2:
                navigate("/module2/main", "你刚刚在主Module点了进入Module2");
                break;
        }
    }

    private void navigate(String path, String msg) {
        ARouter.getInstance().build(path)
                .withBoolean("check", true)
                .withString("text", msg)
                .navigation(this, new NavigationCallback() {
                    @Override
                    public void onFound(Postcard postcard) {
                        Log.d(TAG, "onFound: " + postcard);
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        Log.d(TAG, "onLost: " + postcard);
                    }

                    @Override
                    public void onArrival(Postcard postcard) {
                        Log.d(TAG, "onArrival: " + postcard);
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        Log.d(TAG, "onInterrupt: " + postcard);
                    }
                });
    }
}