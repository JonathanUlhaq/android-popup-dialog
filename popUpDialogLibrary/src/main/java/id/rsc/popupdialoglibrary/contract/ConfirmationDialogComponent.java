package id.rsc.popupdialoglibrary.contract;

import id.rsc.popupdialoglibrary.listener.OnConfirmationSubmitListener;
import id.rsc.popupdialoglibrary.listener.OnDialogDismissListener;

public interface ConfirmationDialogComponent<T extends ConfirmationDialogComponent> {
    public T setDialogBackground(Integer drawable);

    public T setDialogIcon(Integer drawable);

    public T setDialogIcon(String lottieAnimationView);

    public T setDialogTitle(String text);

    public T setDialogTitleColor(Integer color);

    public T setDialogMessage(String text);

    public T setDialogMessageColor(Integer color);

    public T setPositiveText(String text);

    public T setPositiveTextColor(Integer color);

    public T setNegativeText(String text);

    public T setNegativeTextColor(Integer color);

    public T setOnClickListener(OnConfirmationSubmitListener listener);

    public T setOnDialogDismissListener(OnDialogDismissListener listener);
}
