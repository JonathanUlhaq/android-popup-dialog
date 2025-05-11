package id.rsc.popupdialoglibrary.contract;

import id.rsc.popupdialoglibrary.listener.OnDialogDismissListener;
import id.rsc.popupdialoglibrary.listener.OnSubmitListener;
import id.rsc.popupdialoglibrary.utils.DialogType;

public interface InformationDialogComponent<T extends InformationDialogComponent> {
    public T setDialogType(DialogType dialogType);

    public T setDialogTitle(String text);

    public T setDialogMessage(String text);

    public T setButtonText(String text);

    public T setOnClickListener(OnSubmitListener listener);

    public T setOnDialogDismissListener(OnDialogDismissListener listener);
}
