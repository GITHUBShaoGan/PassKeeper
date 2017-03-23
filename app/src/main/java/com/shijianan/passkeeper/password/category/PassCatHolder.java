package com.shijianan.passkeeper.password.category;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shijianan.passkeeper.R;
import com.shijianan.passkeeper.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shijianan on 2017/3/23.
 */

public class PassCatHolder extends BaseViewHolder<PassCat> {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.description)
    TextView description;

    public PassCatHolder(ViewGroup parent, @LayoutRes int resId) {
        super(parent, resId);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(PassCat data) {
        Picasso.with(getContext()).load(data.getImageResId()).into(image);
        title.setText(data.getName());
        description.setText(data.getDescriptionResId());
    }

}
