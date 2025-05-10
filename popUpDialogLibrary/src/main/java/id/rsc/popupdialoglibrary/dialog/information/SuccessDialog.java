package id.rsc.popupdialoglibrary.dialog.information;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import id.rsc.popupdialoglibrary.base.BaseCustomDialog;
import id.rsc.popupdialoglibrary.contract.InformationDialogComponent;
import id.rsc.popupdialoglibrary.databinding.DialogLayoutBinding;
import id.rsc.popupdialoglibrary.listener.OnSubmitListener;

public class SuccessDialog extends BaseCustomDialog implements InformationDialogComponent {

    private DialogLayoutBinding  binding;
    private OnSubmitListener listener;

    public SuccessDialog(@NonNull Context context) {
        super(context);
    }


    @Override
    protected View getContentView(Context context) {
        binding = DialogLayoutBinding.inflate(LayoutInflater.from(context));
        return binding.getRoot();
    }

    @Override
    protected void setLottieView() {
        binding.lottieView.setAnimation("ic_success_lottie.json");
        binding.lottieView.playAnimation();
    }

    @Override
    protected void initListener() {
        binding.btnSubmit.setOnClickListener(v -> {
            hide();
            if (listener != null) listener.onClickListener();
        });
    }

    @Override
    protected void initCompoenent(Context context) {

    }

    @Override
    public void setDialogTitle(String text) {
        binding.tvTitle.setText(text);
    }

    @Override
    public void setDialogMessage(String text) {
        binding.tvDesc.setText(text);
    }

    @Override
    public void setButtonText(String text) {
        binding.btnSubmit.setText(text);
    }

    @Override
    public void setOnClickListener(OnSubmitListener listener) {
        this.listener = listener;
    }
}
