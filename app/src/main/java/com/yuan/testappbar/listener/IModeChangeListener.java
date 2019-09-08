package com.yuan.testappbar.listener;

public interface IModeChangeListener {

    /**
     * @param action 返回处理不同的action
     */
    public void onModeChanged(int action, Object... values);
}
