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

public class InformationDialog extends BaseCustomDialog {

    private DialogLayoutBinding binding;
    private final OnSubmitListener clickListener;
    private final OnDialogDismissListener dismissListener;
    private final String dialogTitle;
    private final String dialogMessage;
    private final String buttonText;
    private final Integer buttonTextColor;
    private final DialogType dialogType;
    private final Integer dialogTitleColor;
    private final Integer dialogMessageColor;
    private final Integer buttonBackground;
    private final String dialogLottieIcon;
    private final Integer dialogIcon;
    private final Integer dialogBackground;


    private InformationDialog(Builder builder) {
        super(builder.context);
        this.clickListener = builder.clickListener;
        this.dialogTitle = builder.dialogTitle;
        this.dialogMessage = builder.dialogMessage;
        this.buttonText = builder.buttonText;
        this.dialogType = builder.dialogType;
        this.dismissListener = builder.dismissListener;
        this.dialogMessageColor = builder.dialogMessageColor;
        this.buttonBackground = builder.buttonBackground;
        this.dialogLottieIcon = builder.dialogLottieIcon;
        this.dialogIcon = builder.dialogIcon;
        this.dialogTitleColor = builder.dialogTitleColor;
        this.buttonTextColor = builder.buttonTextColor;
        this.dialogBackground = builder.dialogBackground;
        initComponent(builder.context);
    }

    public static class Builder implements InformationDialogComponent<Builder> {
        private OnSubmitListener clickListener;
        private OnDialogDismissListener dismissListener;
        private Context context;
        private String dialogTitle;
        private String dialogMessage;
        private String buttonText;
        private Integer buttonTextColor;
        private DialogType dialogType;
        private Integer dialogTitleColor;
        private Integer dialogMessageColor;
        private Integer buttonBackground;
        private String dialogLottieIcon;
        private Integer dialogIcon;
        private Integer dialogBackground;

        @Override
        public Builder setDialogType(DialogType dialogType) {
            this.dialogType = dialogType;
            return this;
        }

        @Override
        public Builder setDialogBackground(Integer drawable) {
            this.dialogBackground = drawable;
            return this;
        }

        @Override
        public Builder setDialogIcon(Integer drawable) {
            this.dialogIcon = drawable;
            return this;
        }

        @Override
        public Builder setDialogIcon(String lottieAnimationView) {
            this.dialogLottieIcon = lottieAnimationView;
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
        public Builder setButtonText(String text) {
            this.buttonText = text;
            return this;
        }

        @Override
        public Builder setButtonTextColor(Integer color) {
            this.buttonTextColor = color;
            return this;
        }

        @Override
        public Builder setButtonBackground(Integer drawable) {
            this.buttonBackground = drawable;
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

        public InformationDialog build(Context context) {
            this.context = context;
            return new InformationDialog(this);
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
        binding.llContainer.setBackground(ContextCompat.getDrawable(context, safeInteger(dialogBackground, R.drawable.bg_rounded_dialog)));
        binding.tvTitle.setText(safeString(dialogTitle, "Dialog Title"));
        binding.tvDesc.setText(safeString(dialogMessage, "Dialog Description"));
        binding.btnSubmit.setText(safeString(buttonText, "Dismiss"));
        binding.btnSubmit.setTextColor(ContextCompat.getColor(context, safeInteger(buttonTextColor, R.color.white)));
        setViewColorByCustom(context);
    }

    private void setViewColorByCustom(Context context) {
        setTextDescriptionColor(context);
        setTextTitleColor(context);
        setButtonBackgroundColor(context);
        setDialogIcon(context);

    }

    private void setDialogIcon(Context context) {
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
            if (dialogType != null) {
                switch (dialogType) {
                    case SUCCESS:
                        binding.lottieView.setVisibility(View.VISIBLE);
                        binding.ivIcon.setVisibility(View.GONE);
                        binding.lottieView.setAnimation("ic_success_lottie.json");
                        binding.lottieView.playAnimation();
                        break;
                    case FAILURE:
                        binding.lottieView.setVisibility(View.VISIBLE);
                        binding.ivIcon.setVisibility(View.GONE);
                        binding.lottieView.setAnimation("ic_failure_lottie.json");
                        binding.lottieView.playAnimation();
                        break;
                    case WARNING:
                        binding.lottieView.setVisibility(View.VISIBLE);
                        binding.ivIcon.setVisibility(View.GONE);
                        binding.lottieView.setAnimation("ic_warning_lottie.json");
                        binding.lottieView.playAnimation();
                        break;
                }
            }
        }
    }

    private void setTextTitleColor(Context context) {
        if (dialogTitleColor != null) {
            binding.tvTitle.setTextColor(ContextCompat.getColor(context, dialogTitleColor));
        } else {
            if (dialogType != null) {
                switch (dialogType) {
                    case SUCCESS:
                        binding.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.green_shade));
                        break;
                    case FAILURE:
                        binding.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.dark_red));
                        break;
                    case WARNING:
                        binding.tvTitle.setTextColor(ContextCompat.getColor(context, R.color.dark_yellow));
                        break;
                }
            }
        }
    }

    private void setTextDescriptionColor(Context context) {
        if (dialogMessageColor != null) {
            binding.tvDesc.setTextColor(ContextCompat.getColor(context, dialogMessageColor));
        } else {
            if (dialogType != null) {
                switch (dialogType) {
                    case SUCCESS:
                        binding.tvDesc.setTextColor(ContextCompat.getColor(context, R.color.green_shade));
                        break;
                    case FAILURE:
                        binding.tvDesc.setTextColor(ContextCompat.getColor(context, R.color.dark_red));
                        break;
                    case WARNING:
                        binding.tvDesc.setTextColor(ContextCompat.getColor(context, R.color.dark_yellow));
                        break;
                }
            }
        }
    }

    private void setButtonBackgroundColor(Context context) {
        if (buttonBackground != null) {
            binding.btnSubmit.setBackground(Objects.requireNonNull(ContextCompat.getDrawable(context, buttonBackground)));
        } else {
            if (dialogType != null) {
                switch (dialogType) {
                    case SUCCESS:
                        binding.btnSubmit.setBackground(Objects.requireNonNull(ContextCompat.getDrawable(context, R.drawable.bg_button_success)));
                        break;
                    case FAILURE:
                        binding.btnSubmit.setBackground(Objects.requireNonNull(ContextCompat.getDrawable(context, R.drawable.bg_button_failure)));
                        break;
                    case WARNING:
                        binding.btnSubmit.setBackground(Objects.requireNonNull(ContextCompat.getDrawable(context, R.drawable.bg_button_warning)));
                        break;
                }
            }
        }
    }

    private String safeString(String inputText, String defaultText) {
        return inputText != null ? inputText : defaultText;
    }

    private Integer safeInteger(Integer inputInt, Integer defaultInt) {
        return inputInt != null ? inputInt : defaultInt;
    }

    @Override
    protected void onDismissDialog() {
        if (dismissListener != null) {
            dismissListener.onDismiss();
        }
    }
}
