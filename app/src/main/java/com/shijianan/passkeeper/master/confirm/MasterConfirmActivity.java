package com.shijianan.passkeeper.master.confirm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.shijianan.passkeeper.R;
import com.shijianan.passkeeper.eventbus.MasterConfirmEvent;
import com.shijianan.passkeeper.main.MainActivity;
import com.shijianan.passkeeper.master.create.MasterCreateActivity;
import com.shijianan.passkeeper.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MasterConfirmActivity extends AppCompatActivity implements MasterConfirmView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edit_master)
    TextInputEditText editMaster;
    @BindView(R.id.til_master)
    TextInputLayout tilMaster;
    @BindView(R.id.submit)
    Button submit;

    private String extraMaster;
    private MasterConfirmPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_confirm);
        ButterKnife.bind(this);
        initView(savedInstanceState);
        initListener();
    }

    private void initView(Bundle savedInstanceState) {
        presenter = new MasterConfirmPresenterImpl(this);
        presenter.initUI(getIntent(), savedInstanceState);
    }

    private void initListener() {
        editMaster.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilMaster.setErrorEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick(R.id.submit)
    void onSubmitClick() {
        String text = editMaster.getText().toString().trim();
        presenter.onSubmitClick(extraMaster, text);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MasterCreateActivity.EXTRA_MASTER, extraMaster);
    }

    @Override
    public void onSubmitError(String msg) {
        tilMaster.setErrorEnabled(true);
        tilMaster.setError(msg);
    }

    @Override
    public void onSubmitSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
        EventBus.getDefault().post(new MasterConfirmEvent());
    }

    @Override
    public void onUIInitSuccess(String extraMaster) {
        this.extraMaster = extraMaster;
    }

    @Override
    public void onUIInitError(String msg) {
        ToastUtils.showShort(msg);
        finish();
    }
}
