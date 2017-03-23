package com.shijianan.passkeeper.password.category;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.shijianan.passkeeper.R;
import com.shijianan.passkeeper.base.BaseAdapter;
import com.shijianan.passkeeper.base.BaseOnItemClickListener;

import java.util.List;

/**
 * Created by shijianan on 2017/3/23.
 */

public class PassCatAdapter extends BaseAdapter<PassCat, PassCatHolder> {


    /**
     * 设置数据,并设置点击回调接口
     *
     * @param list     数据集合
     * @param listener 回调接口
     */
    public PassCatAdapter(@Nullable List<PassCat> list, @Nullable BaseOnItemClickListener<PassCatHolder,PassCat> listener) {
        super(list, listener);
    }

    @Override
    public PassCatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PassCatHolder(parent, R.layout.item_pass_cat);
    }

    @Override
    public void onBindViewHolder(final PassCatHolder holder, final int position) {
        super.onBindViewHolder(holder, position);
    }
}
