package id.rsc.popupdialoglibrary.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

public abstract class BaseCustomDialog extends Dialog {

    protected BaseCustomDialog(@NonNull Context context) {
        super(context);
        initSetting(context);
        initListener();
        this.setOnDismissListener(v -> onDismissDialog());
    }

    private void initSetting(Context context) {
        setContentView(getContentView(context));

        if (getWindow() != null) {
            getWindow().setLayout(
                    (int) (context.getResources().getDisplayMetrics().widthPixels * 0.90),
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }

    protected abstract View getContentView(Context context);

    protected abstract void initListener();

    protected abstract void onDismissDialog();

    protected String safeString(String inputText, String defaultText) {
        return inputText != null ? inputText : defaultText;
    }

    protected Integer safeInteger(Integer inputInt, Integer defaultInt) {
        return inputInt != null ? inputInt : defaultInt;
    }
}
