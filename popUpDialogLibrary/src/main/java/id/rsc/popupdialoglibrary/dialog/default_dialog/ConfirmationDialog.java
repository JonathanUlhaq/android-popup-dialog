package id.rsc.popupdialoglibrary.dialog.default_dialog;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import id.rsc.popupdialoglibrary.R;
import id.rsc.popupdialoglibrary.base.BaseCustomDialog;
import id.rsc.popupdialoglibrary.contract.ConfirmationDialogComponent;
import id.rsc.popupdialoglibrary.databinding.DialogConfirmationLayoutBinding;
import id.rsc.popupdialoglibrary.listener.OnConfirmationSubmitListener;
import id.rsc.popupdialoglibrary.listener.OnDialogDismissListener;

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
public class ConfirmationDialog extends BaseCustomDialog {

    private DialogConfirmationLayoutBinding binding;
    private final OnConfirmationSubmitListener clickListener;
    private final OnDialogDismissListener dismissListener;
    private final Integer dialogBackground;
    private final Integer dialogIcon;
    private final String dialogLottieIcon;
    private final String dialogTitle;
    private final Integer dialogTitleColor;
    private final String dialogMessage;
    private final Integer dialogMessageColor;
    private final String positiveText;
    private final Integer positiveTextColor;
    private final String negativeText;
    private final Integer negativeTextColor;

    private ConfirmationDialog(Builder builder) {
        super(builder.context);
        this.clickListener = builder.clickListener;
        this.dismissListener = builder.dismissListener;
        this.dialogBackground = builder.dialogBackground;
        this.dialogIcon = builder.dialogIcon;
        this.dialogLottieIcon = builder.dialogLottieIcon;
        this.dialogTitle = builder.dialogTitle;
        this.dialogTitleColor = builder.dialogTitleColor;
        this.dialogMessage = builder.dialogMessage;
        this.dialogMessageColor = builder.dialogMessageColor;
        this.positiveText = builder.positiveText;
        this.positiveTextColor = builder.positiveTextColor;
        this.negativeText = builder.negativeText;
        this.negativeTextColor = builder.negativeTextColor;
        setCancelable(false);
        initComponent(builder.context);
    }

    public static class Builder implements ConfirmationDialogComponent<Builder> {
        private OnConfirmationSubmitListener clickListener;
        private OnDialogDismissListener dismissListener;
        private Context context;
        private Integer dialogBackground;
        private Integer dialogIcon;
        private String dialogLottieIcon;
        private String dialogTitle;
        private Integer dialogTitleColor;
        private String dialogMessage;
        private Integer dialogMessageColor;
        private String positiveText;
        private Integer positiveTextColor;
        private String negativeText;
        private Integer negativeTextColor;

        @Override
        public Builder setDialogBackground(Integer drawable) {
            this.dialogBackground = drawable;
            return this;
        }

        @Override
        public Builder setDialogIcon(Integer drawable) {
            this.dialogIcon = drawable;
            this.dialogLottieIcon = null;
            return this;
        }

        @Override
        public Builder setDialogIcon(String lottieAnimationView) {
            this.dialogLottieIcon = lottieAnimationView;
            this.dialogIcon = null;
            return this;
        }

        @Override
        public Builder setDialogTitle(String text) {
            this.dialogTitle = text;
            return this;
        }

        @Override
        public Builder setDialogTitleColor(Integer color) {
            this.dialogTitleColor = color;
            return this;
        }

        @Override
        public Builder setDialogMessage(String text) {
            this.dialogMessage = text;
            return this;
        }

        @Override
        public Builder setDialogMessageColor(Integer color) {
            this.dialogMessageColor = color;
            return this;
        }

        @Override
        public Builder setPositiveText(String text) {
            this.positiveText = text;
            return this;
        }

        @Override
        public Builder setPositiveTextColor(Integer color) {
            this.positiveTextColor = color;
            return this;
        }

        @Override
        public Builder setNegativeText(String text) {
            this.negativeText = text;
            return this;
        }

        @Override
        public Builder setNegativeTextColor(Integer color) {
            this.negativeTextColor = color;
            return null;
        }

        @Override
        public Builder setOnClickListener(OnConfirmationSubmitListener listener) {
            this.clickListener = listener;
            return this;
        }

        @Override
        public Builder setOnDialogDismissListener(OnDialogDismissListener listener) {
            this.dismissListener = listener;
            return this;
        }

        public ConfirmationDialog build(Context context) {
            this.context = context;
            return new ConfirmationDialog(this);
        }

    }

    @Override
    protected View getContentView(Context context) {
        binding = DialogConfirmationLayoutBinding.inflate(LayoutInflater.from(context));
        return binding.getRoot();
    }

    @Override
    protected void initListener() {
        binding.tvPositive.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onPositiveClick();
            }
            dismiss();
        });

        binding.tvNegative.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onNegativeClick();
            }
            dismiss();
        });

    }

    private void initComponent(Context context) {

        binding.llContainer.setBackground(ContextCompat.getDrawable(context, safeInteger(dialogBackground, R.drawable.bg_rounded_dialog)));

        binding.tvConfirmationTitle.setText(safeString(dialogTitle, "Confirmation"));
        binding.tvConfirmationTitle.setTextColor(ContextCompat.getColor(context, safeInteger(dialogTitleColor, R.color.black)));

        binding.tvConfirmationMessage.setText(safeString(dialogMessage, "Confirmation Message"));
        binding.tvConfirmationMessage.setTextColor(ContextCompat.getColor(context, safeInteger(dialogMessageColor, R.color.black)));

        binding.tvPositive.setText(safeString(positiveText, "Ok"));
        binding.tvPositive.setTextColor(ContextCompat.getColor(context, safeInteger(positiveTextColor, R.color.black)));

        binding.tvNegative.setText(safeString(negativeText, "Cancel"));
        binding.tvNegative.setTextColor(ContextCompat.getColor(context, safeInteger(negativeTextColor, R.color.grey)));


        if (dialogLottieIcon != null) {
            binding.lottieView.setVisibility(View.VISIBLE);
            binding.ivIcon.setVisibility(View.GONE);
            binding.lottieView.setAnimation(dialogLottieIcon);
            binding.lottieView.playAnimation();
        } else if (dialogIcon != null) {
            binding.lottieView.setVisibility(View.GONE);
            binding.ivIcon.setVisibility(View.VISIBLE);
            binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(context, dialogIcon));
        } else {
            binding.lottieView.setVisibility(View.VISIBLE);
            binding.ivIcon.setVisibility(View.GONE);
            binding.lottieView.setAnimation("ic_information_lottie.json");
            binding.lottieView.playAnimation();
        }

    }

    @Override
    protected void onDismissDialog() {
        if (dismissListener != null) {
            dismissListener.onDismiss();
        }
    }
}
