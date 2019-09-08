package com.yuan.testappbar.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yuan.testappbar.R;
import com.yuan.testappbar.bean.RResult;
import com.yuan.testappbar.conns.IdiyMessage;
import com.yuan.testappbar.controller.LoginController;
import com.yuan.testappbar.listener.IModeChangeListener;

public class AsyncActivity extends AppCompatActivity implements IModeChangeListener {

    private LoginController mController;
    private Handler mHander = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case IdiyMessage.LOGIN_ACTION_RESULT:
                    handlerLoginResult(msg);
                    break;
            }
        }
    };

    private void handlerLoginResult(Message msg) {
        RResult rResult = (RResult) msg.obj;
        if (rResult.isSuccess()) {
            //TODO 登录成功 跳转操作
        } else {
            // 登录失败
            Toast.makeText(AsyncActivity.this, rResult.getErrorMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        mController = new LoginController();
        mController.setIModeChangeListener(this);
    }

    public void loginClick(View view) {
        String name ="";
        String pwd = "";
        mController.sendAsyncMessage(IdiyMessage.LOGIN_ACTION, name, pwd);
    }

    @Override
    public void onModeChanged(int action, Object... values) {
        //子线程
//        mHander.sendMessage(mHander.obtainMessage());
        mHander.obtainMessage(action, values[0]).sendToTarget();
    }
}
