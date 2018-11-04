package com.android.renly.healingmvp.module.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.android.renly.healingmvp.R;

import butterknife.ButterKnife;

public class EmptyLayout extends FrameLayout {
    public static final int STATUS_HIDE = 1001;
    public static final int STATUS_LOADING = 1002;
    public static final int STATUS_NO_NET = 1003;
    public static final int STATUS_NO_DATA = 1004;
    private Context mContext;
    private int mBgColor;

    public EmptyLayout(Context context){
        this(context, null);
    }

    public EmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray array = mContext.obtainStyledAttributes(attrs, R.styleable.EmptyLayout);
        try {
            mBgColor = array.getColor(R.styleable.EmptyLayout_background_color, Color.WHITE);
        }finally {
            array.recycle();
        }
    }


}
