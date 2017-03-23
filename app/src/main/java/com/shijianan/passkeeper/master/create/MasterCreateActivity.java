package com.shijianan.passkeeper.master.create;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.shijianan.passkeeper.R;
import com.shijianan.passkeeper.config.AppConfig;
import com.shijianan.passkeeper.eventbus.MasterConfirmEvent;
import com.shijianan.passkeeper.master.confirm.MasterConfirmActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MasterCreateActivity extends AppCompatActivity implements MasterCreateView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edit_master)
    TextInputEditText editMaster;
    @BindView(R.id.submit)
    Button submit;
    @BindView(R.id.til_master)
    TextInputLayout tilMaster;

    private MasterCreatePresenter presenter;
    public static final String EXTRA_MASTER = "master";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_create);
        ButterKnife.bind(this);
        initView();
        initListener();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onConfirmMasterSuccess(MasterConfirmEvent masterConfirmEvent){
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initView() {
        setSupportActionBar(toolbar);

        presenter = new MasterCreatePresenterImpl(this);
    }

    private void initListener() {
        editMaster.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.changeMasterText(s);
            }
        });
    }

    @OnClick(R.id.submit)
    void onSubmitCLick() {
        String master = editMaster.getText().toString().trim();
        Intent intent = new Intent(this, MasterConfirmActivity.class);
        intent.putExtra(EXTRA_MASTER, master);
        startActivity(intent);
    }

    @Override
    public void onMasterTextChangeLegal() {
        tilMaster.setErrorEnabled(false);
        submit.setEnabled(true);
        submit.setClickable(true);
    }

    @Override
    public void onMasterTextChangeIllegal(String msg) {
        tilMaster.setErrorEnabled(true);
        tilMaster.setError(msg);
        submit.setEnabled(false);
        submit.setClickable(false);
    }
}
