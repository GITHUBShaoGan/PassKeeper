package com.shijianan.passkeeper.password.category;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.shijianan.passkeeper.R;
import com.shijianan.passkeeper.base.BaseOnItemClickListener;
import com.shijianan.passkeeper.password.website.edit.WebEditActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PassCatActivity extends AppCompatActivity implements BaseOnItemClickListener<PassCatHolder, PassCat>, PassCatView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private PassCatAdapter passCatAdapter;
    private PassCatPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_cat);
        ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new PassCatPresenterImpl(this);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        passCatAdapter = new PassCatAdapter(new ArrayList<PassCat>(), this);
        recyclerview.setAdapter(passCatAdapter);

        presenter.initUI();
    }

    private void initListener() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public void onItemClick(PassCatHolder passCatHolder, PassCat passCat, int position) {
        presenter.clickItem(passCat.getType());
    }

    @Override
    public void onInitSuccess(List<PassCat> passCatList) {
        passCatAdapter.appendList(passCatList);
    }

    @Override
    public void onInitError(String msg) {
    }

    @Override
    public void onClick2WebsiteEdit() {
        startActivity(new Intent(this, WebEditActivity.class));
    }

    @Override
    public void onClick2BankEdit() {

    }

    @Override
    public void onClick2ServerEdit() {

    }

    @Override
    public void onClick2WifiEdit() {

    }

    @Override
    public void onClick2OtherEdit() {

    }
}
