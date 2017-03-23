package com.shijianan.passkeeper.master.check;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

import com.shijianan.passkeeper.R;
import com.shijianan.passkeeper.main.MainActivity;
import com.shijianan.passkeeper.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MasterCheckActivity extends AppCompatActivity implements MasterCheckView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edit_master)
    TextInputEditText editMaster;
    @BindView(R.id.til_master)
    TextInputLayout tilMaster;
    @BindView(R.id.submit)
    Button submit;

    private MasterCheckPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_check);
        ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initView() {
        presenter = new MasterCheckPresenterImpl(this);
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
        presenter.checkMaster(text);
    }

    @Override
    public void onCheckSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onCheckFailed() {
        tilMaster.setErrorEnabled(true);
        tilMaster.setError(StringUtils.getStrFromRes(R.string.error_validate_master));
    }

    @Override
    public void onCheckError(String msg) {
        tilMaster.setErrorEnabled(true);
        tilMaster.setError(msg);
    }
}
