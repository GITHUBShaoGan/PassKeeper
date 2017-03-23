package com.shijianan.passkeeper.eventbus;

/**
 * Created by shijianan on 2017/3/22.
 */

public class MasterConfirmEvent {

    private int errorCode;

    public MasterConfirmEvent() {
    }

    public MasterConfirmEvent(int errorCode) {
        this.errorCode = errorCode;
    }
}
