package id.rsc.popupdialoglibrary.dialog.default_dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.core.content.ContextCompat;

import java.util.Objects;

import id.rsc.popupdialoglibrary.R;
import id.rsc.popupdialoglibrary.base.BaseCustomDialog;
import id.rsc.popupdialoglibrary.contract.InformationDialogComponent;
import id.rsc.popupdialoglibrary.databinding.DialogLayoutBinding;
import id.rsc.popupdialoglibrary.listener.OnDialogDismissListener;
import id.rsc.popupdialoglibrary.listener.OnSubmitListener;
import id.rsc.popupdialoglibrary.utils.DialogType;

public class DefaultSingleDialog extends BaseCustomDialog {

    private DialogLayoutBinding binding;
    private final OnSubmitListener clickListener;
    private final OnDialogDismissListener dismissListener;
    private final String dialogTitle;
    private final String dialogMessage;
    private final String buttonText;
    private final DialogType dialogType;


    private DefaultSingleDialog(Builder builder) {
        super(builder.context);
        this.clickListener = builder.clickListener;
        this.dialogTitle = builder.dialogTitle;
        this.dialogMessage = builder.dialogMessage;
        this.buttonText = builder.buttonText;
        this.dialogType = builder.dialogType;
        this.dismissListener = builder.dismissListener;
        initComponent(builder.context);
    }

    public static class Builder implements InformationDialogComponent<Builder> {
        private OnSubmitListener clickListener;
        private OnDialogDismissListener dismissListener;
        private Context context;
        private String dialogTitle;
        private String dialogMessage;
        private String buttonText;
        private DialogType dialogType;

        @Override
        public Builder setDialogType(DialogType dialogType) {
            this.dialogType = dialogType;
            return this;
        }

        @Override
        public Builder setDialogTitle(String text) {
            this.dialogTitle = text;
            return this;
        }

        @Override
        public Builder setDialogMessage(String text) {
            this.dialogMessage = text;
            return this;
        }

        @Override
        public Builder setButtonText(String text) {
            this.buttonText = text;
            return this;
        }

        @Override
        public Builder setOnClickListener(OnSubmitListener clickListener) {
            this.clickListener = clickListener;
            return this;
        }

        @Override
        public Builder setOnDialogDismissListener(OnDialogDismissListener listener) {
            this.dismissListener = listener;
            return this;
        }

        public DefaultSingleDialog build(Context context) {
            this.context = context;
            return new DefaultSingleDialog(this);
        }
    }

    @Override
    protected View getContentView(Context context) {
        binding = DialogLayoutBinding.inflate(LayoutInflater.from(context));
        return binding.getRoot();
    }

    @Override
    protected void initListener() {
        binding.btnSubmit.setOnClickListener(v -> {
            if (clickListener != null) clickListener.onClickListener();
        });
    }

    private void initComponent(Context context) {
        binding.tvTitle.setText(dialogTitle != null ? dialogTitle : "Dialog Title");
        binding.tvDesc.setText(dialogMessage != null ? dialogMessage : "Dialog Description");
        binding.btnSubmit.setText(buttonText != null ? buttonText : "Dismiss");

        if (dialogType != null) {
            switch (dialogType) {
                case SUCCESS:
                    binding.tvDesc.setTextColor(ContextCompat.getColor(context, R.color.green_shade));
                    binding.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.green_shade));
                    binding.btnSubmit.setBackground(Objects.requireNonNull(ContextCompat.getDrawable(context, R.drawable.bg_button_success)));

                    binding.lottieView.setAnimation("ic_success_lottie.json");
                    binding.lottieView.playAnimation();
                    break;
                case FAILURE:
                    binding.tvDesc.setTextColor(ContextCompat.getColor(context, R.color.dark_red));
                    binding.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.dark_red));
                    binding.btnSubmit.setBackground(Objects.requireNonNull(ContextCompat.getDrawable(context, R.drawable.bg_button_failure)));

                    binding.lottieView.setAnimation("ic_failure_lottie.json");
                    binding.lottieView.playAnimation();
                    break;
                case WARNING:
                    binding.tvDesc.setTextColor(ContextCompat.getColor(context, R.color.dark_yellow));
                    binding.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.dark_yellow));
                    binding.btnSubmit.setBackground(Objects.requireNonNull(ContextCompat.getDrawable(context, R.drawable.bg_button_warning)));

                    binding.lottieView.setAnimation("ic_warning_lottie.json");
                    binding.lottieView.playAnimation();
                    break;
            }
        }
    }

    @Override
    protected void onDismissDialog() {
        if (dismissListener != null) {
            dismissListener.onDismiss();
        }
    }
}
