package com.zhonghua.newLib.view.dialog;

import android.app.Dialog;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by shidawei on 16/1/24.
 */
public interface DialogLinstener{

    void confirm(Dialog dialog);

    void cancel(Dialog dialog);

}
