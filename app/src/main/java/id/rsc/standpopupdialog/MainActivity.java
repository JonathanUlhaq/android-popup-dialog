package id.rsc.standpopupdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import id.rsc.popupdialoglibrary.dialog.default_dialog.DefaultSingleDialog;
import id.rsc.popupdialoglibrary.utils.DialogType;
import id.rsc.standpopupdialog.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DefaultSingleDialog dialogSuccess;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dialogSuccess = new DefaultSingleDialog
                .Builder()
                .setDialogType(DialogType.SUCCESS)
                .setDialogTitle("Trust Me")
                .setDialogMessage("Trust for success")
                .setButtonText("Dismiss")
                .setOnClickListener(() -> {
                })
                .setOnDialogDismissListener(() -> {
                })
                .build(this);

        DefaultSingleDialog dialogFailure = new DefaultSingleDialog
                .Builder()
                .setDialogType(DialogType.FAILURE)
                .setDialogTitle("Trust Me")
                .setDialogMessage("Trust for failure")
                .setButtonText("Dismiss")
                .setOnClickListener(() -> {
                })
                .setOnDialogDismissListener(() -> {
                })
                .build(this);

        DefaultSingleDialog dialogWarning = new DefaultSingleDialog
                .Builder()
                .setDialogType(DialogType.WARNING)
                .setDialogTitle("Warning Title")
                .setDialogMessage("Warning Desc")
                .setButtonText("Dismiss")
                .setOnClickListener(() -> {
                })
                .setOnDialogDismissListener(() -> {
                })
                .build(this);

        binding.btnSuccess.setOnClickListener(v -> dialogSuccess.show());
        binding.btnFailure.setOnClickListener(v -> dialogFailure.show());
        binding.btnWarning.setOnClickListener(v -> dialogWarning.show());
    }
}