package id.rsc.popupdialoglibrary.contract;

import id.rsc.popupdialoglibrary.listener.OnDialogDismissListener;
import id.rsc.popupdialoglibrary.listener.OnSubmitListener;
import id.rsc.popupdialoglibrary.utils.DialogType;

public interface InformationDialogComponent<T extends InformationDialogComponent> {
    public T setDialogType(DialogType dialogType);
    public T setDialogBackground(Integer drawable);
    public T setDialogIcon(Integer drawable);
    public T setDialogIcon(String lottieAnimationView);

    public T setDialogTitle(String text);

    public T setDialogTitleColor(Integer color);

    public T setDialogMessage(String text);

    public T setDialogMessageColor(Integer color);


    public T setButtonText(String text);
    public T setButtonTextColor(Integer color);

    public T setButtonBackground(Integer drawable);


    public T setOnClickListener(OnSubmitListener listener);

    public T setOnDialogDismissListener(OnDialogDismissListener listener);
}
