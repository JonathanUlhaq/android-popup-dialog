package id.rsc.popupdialoglibrary.dialog.information;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.Objects;

import id.rsc.popupdialoglibrary.R;
import id.rsc.popupdialoglibrary.base.BaseCustomDialog;
import id.rsc.popupdialoglibrary.contract.InformationDialogComponent;
import id.rsc.popupdialoglibrary.databinding.DialogLayoutBinding;
import id.rsc.popupdialoglibrary.listener.OnSubmitListener;

public class FailureDialog extends BaseCustomDialog implements InformationDialogComponent {

    private DialogLayoutBinding binding;
    private OnSubmitListener listener;

    public FailureDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected View getContentView(Context context) {
        binding = DialogLayoutBinding.inflate(LayoutInflater.from(context));
        return binding.getRoot();
    }

    @Override
    protected void setLottieView() {
        binding.lottieView.setAnimation("ic_failure_lottie.json");
        binding.lottieView.playAnimation();
    }

    @Override
    protected void initListener() {
        binding.btnSubmit.setOnClickListener(v -> {
            if (listener != null) listener.onClickListener();
        });
    }

    @Override
    protected void initCompoenent(Context context) {
        binding.tvDesc.setTextColor(ContextCompat.getColor(context, R.color.dark_red));
        binding.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.dark_red));
        binding.btnSubmit.setBackground(Objects.requireNonNull(ContextCompat.getDrawable(context, R.drawable.bg_button_failure)));
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
