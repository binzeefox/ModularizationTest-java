package com.binzee.commonlib;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * @author 狐彻
 * 2020/11/13 16:05
 */
@Interceptor(priority = 1, name = "测试")
public class TestARouterInterceptor implements IInterceptor {
    private static final String TAG = "TestARouterInterceptor";

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (!postcard.getExtras().getBoolean("check", false)) {
            callback.onInterrupt(new RuntimeException("检查失败"));
            Log.d(TAG, "process: 错误");
        } else callback.onContinue(postcard);
    }

    @Override
    public void init(Context context) {

    }
}
