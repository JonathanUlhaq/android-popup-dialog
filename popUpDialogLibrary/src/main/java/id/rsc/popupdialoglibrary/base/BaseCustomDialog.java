package id.rsc.popupdialoglibrary.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public abstract class BaseCustomDialog extends Dialog {

    public BaseCustomDialog(@NonNull Context context) {
        super(context);
        initSetting(context);
        setLottieView();
        initListener();
        initCompoenent(context);
    }

    private void initSetting(Context context) {
        setContentView(getContentView(context));

        if (getWindow() != null) {
            getWindow().setLayout(
                    (int) (context.getResources().getDisplayMetrics().widthPixels * 0.80),
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    abstract protected View getContentView(Context context);

    abstract protected void setLottieView();

    abstract protected void initListener();

    abstract protected void initCompoenent(Context context);
}
