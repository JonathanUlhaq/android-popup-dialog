package id.rsc.standpopupdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import id.rsc.popupdialoglibrary.dialog.default_dialog.InformationDialog;
import id.rsc.popupdialoglibrary.utils.DialogType;
import id.rsc.standpopupdialog.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        InformationDialog dialogSuccess = new InformationDialog
                .Builder()
                .setDialogType(DialogType.SUCCESS)
                .setDialogTitle("Trust Success")
                .setDialogMessage("Trust for success")
                .setOnClickListener(() -> {
                })
                .setOnDialogDismissListener(() -> {
                })
                .build(this);

        InformationDialog dialogFailure = new InformationDialog
                .Builder()
                .setDialogType(DialogType.FAILURE)
                .setDialogTitle("Failure")
                .setDialogMessage("Failure can't get data")
                .setOnClickListener(() -> {
                })
                .setOnDialogDismissListener(() -> {
                })
                .build(this);

        InformationDialog dialogWarning = new InformationDialog
                .Builder()
                .setDialogType(DialogType.WARNING)
                .setDialogTitle("Warning Title")
                .setDialogMessage("Warning Desc")
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