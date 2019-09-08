package com.yuan.testappbar.controller;

import com.alibaba.fastjson.JSON;
import com.yuan.testappbar.bean.RResult;
import com.yuan.testappbar.conns.IdiyMessage;
import com.yuan.testappbar.conns.NetWorkConns;
import com.yuan.testappbar.listener.IModeChangeListener;
import com.yuan.testappbar.utils.NetWorkUtil;

import java.util.HashMap;

public class LoginController extends BaseController {

    private IModeChangeListener mListener;

    public void setIModeChangeListener(IModeChangeListener listener) {
        this.mListener = listener;
    }

    @Override
    protected void handlerMessage(int action, Object... values) {
        switch (action) {
            case IdiyMessage.LOGIN_ACTION:
                RResult rResult = login((String) values[0], (String) values[1]);
                //通知activity  数据加载完毕了
                mListener.onModeChanged(IdiyMessage.LOGIN_ACTION_RESULT, rResult);
                break;
        }
    }

    private RResult login(String name, String pwd) {
        HashMap<String, String> params = new HashMap<>();
        // username pwd 接口中的key
        params.put("username", name);
        params.put("pwd", pwd);
        String jsonStr = NetWorkUtil.doPost(NetWorkConns.LOGIN_URL, params);
        // fastJSon 使用
        return JSON.parseObject(jsonStr, RResult.class);
    }


}
