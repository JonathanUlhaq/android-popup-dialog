```java
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
dialogSuccess.show();

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
dialogFailure.show();

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
dialogWarning.show();

InformationDialog dialogCustom = new InformationDialog
                .Builder()
                .setDialogIcon(R.drawable.ic_checked) // set dialog icon by drawable (int)
                .setDialogIcon("lottie.json") // or set dialog icon by lotie.json ("string")
                .setDialogBackground(R.drawable.grey_background)
                .setDialogTitle("Custom Dialog")
                .setDialogTitleColor(R.color.red)
                .setDialogMessage("Custom Dialog Message")
                .setDialogMessageColor(R.color.red)
                .setOnClickListener(() -> {
                })
                .setOnDialogDismissListener(() -> {
                })
                .build(this);
dialogCustom.show();

ConfirmationDialog confirmationDialog = new ConfirmationDialog.Builder()
                .setDialogMessage("Are you sure to delete this data ?")
                .setDialogTitle("Confirmation")
                .setNegativeText("No")
                .setPositiveText("Yes")
                .setOnClickListener(new OnConfirmationSubmitListener() {
                    @Override
                    public void onPositiveClick() {
                    }

                    @Override
                    public void onNegativeClick() {
                    }
                })
                .setOnDialogDismissListener(() -> {})
                .build(this);
confirmationDialog.show();

 ConfirmationDialog customConfirmationDialog = new ConfirmationDialog.Builder()
                .setDialogBackground(R.drawable.bg_confirmation) 
                .setDialogIcon("lottie.json") // set dialog icon by lotie.json ("string")
                .setDialogIcon(R.drawable.bg_icon_confirmation) // or set dialog icon by drawable (int)
                .setDialogMessage("Are you sure to delete this data ?")
                .setDialogMessageColor(R.color.black)
                .setDialogTitle("Confirmation")
                .setDialogTitleColor(R.color.black)
                .setNegativeText("No")
                .setNegativeTextColor(R.color.grey)
                .setPositiveText("Yes")
                .setPositiveTextColor(R.color.black)
                .setOnClickListener(new OnConfirmationSubmitListener() {
                    @Override
                    public void onPositiveClick() {
                    }

                    @Override
                    public void onNegativeClick() {
                    }
                })
                .setOnDialogDismissListener(() -> {})
                .build(this);


```
