package com.yuan.testappbar.controller;

public abstract class BaseController {

    /**
     *
     * @param action 一个页面可能有多个网络请求，用来区别这些请求
     * @param values 请求数据
     */
    public void sendAsyncMessage(final int action, final Object... values){
        new Thread() {
            @Override
            public void run() {
                handlerMessage(action, values);
            }
        }.start();
    }

    /**
     * 子类处理具体的业务需求代码
     */
    protected abstract void handlerMessage(int action, Object... values);
}
