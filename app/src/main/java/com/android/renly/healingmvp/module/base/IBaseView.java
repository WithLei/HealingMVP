package com.android.renly.healingmvp.module.base;

import com.trello.rxlifecycle3.LifecycleTransformer;

public interface IBaseView {
    /**
     * 显示建在动画
     */
    void showLoading();

    /**
     * 隐藏加载动画
     */
    void hideLoading();

    /**
     * 显示网络错误。modify 对网络异常在BaseActivity 和 BaseFragment 统一处理
     */
    void showNetError();

    /**
     * 绑定生命周期
     */
    <T>LifecycleTransformer<T> bindeToLife();

    /**
     * 完成刷新，新增控制刷新
     */
    void finishRefresh();
}
