package id.rsc.popupdialoglibrary.contract;

import id.rsc.popupdialoglibrary.listener.OnSubmitListener;

public interface InformationDialogComponent {
    public void setDialogTitle(String text);
    public void setDialogMessage(String text);
    public void setButtonText(String text);
    public void setOnClickListener(OnSubmitListener listener);
}
