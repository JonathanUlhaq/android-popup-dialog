# Version 1.1.1 - Update Highlights

## 🔰 Summary

In this update, we add **Confirmation Dialog** feature which it support two button text action, such as positive button and negative button
## ✨ What's New
- ✅ Confirmation Button with two button action ( positive and negative button text )

# Version 1.1.0 - Update Highlights

## 🔰 Summary

This update introduces a more flexible and expressive way to create dialogs using the Fluent Builder pattern, along with several customization options to enhance your UI/UX.

## ✨ What's New
- ✅ Fluent Builder Pattern
- 🎨 Dialog Customizations
  - Change dialog background drawable
  - Change title and message text color
  - Customize button text color
  - Change dialog icon with:
    - **Lottie animation** via `string` json asset name
    - **Drawable Resource** via `int`

# Initial Release - v1.0.0

## 🔰 Summary
The initial release of `AndroidPopUp`, is an Android library that provides Pop Up UI components, such as Pop Up for Success, Failure, and Warning. In addition, in this library, you can freely control the customization of the action when the dialog is dismissed or interact with the button on the dialog with the listener provided.

## 📦 Implementation
- Add jitpack.io to your settings.gradle:
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = "https://jitpack.io"
        }
    }
}
```
- Add dependency to your build.gradle:
```groovy
...
implementation "com.github.JonathanUlhaq:android-popup-dialog:1.1.0"
```

- Code implementation:

[Or you can check here ](https://github.com/saadahmedscse/Android-Popup-Dialog/blob/master/BRIEF.md)

<table>
<tr>
<th> Success Dialog </th>
<th> Demo </th>
</tr>
<tr>
<td>

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
        dialogSuccess.show()
```
</td>
<td>
<img src="https://github.com/JonathanUlhaq/android-popup-dialog/raw/main/Demo%20Success%20Dialog.gif" width="300"/>
</td>
</tr>
</table>

<table>
<tr>
<th>  Failure Dialog </th>
<th> Demo </th>
</tr>
<tr>
<td>

```java
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
        dialogFailure.show()
```
</td>
<td>
<img src="https://github.com/JonathanUlhaq/android-popup-dialog/raw/main/Demo%20Failure%20Dialog.gif" width="300"/>
</td>
</tr>
</table>

<table>
<tr>
<th> Warning Dialog </th>
<th> Demo </th>
</tr>
<tr>
<td>

```java
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
        dialogWarning.show()
```
</td>
<td>
<img src="https://github.com/JonathanUlhaq/android-popup-dialog/raw/main/Demo%20Warning.gif" width="300"/>
</td>
</tr>
</table>

<table>
<tr>
<th> Confirmation Dialog </th>
<th> Demo </th>
</tr>
<tr>
<td>

```java
ConfirmationDialog confirmationDialog = new ConfirmationDialog.Builder()
                .setDialogMessage("Are you sure to delete this data ?")
                .setDialogTitle("Confirmation")
                .setNegativeText("No")
                .setPositiveText("Yes")
                .setOnClickListener(new OnConfirmationSubmitListener() {
                    @Override
                    public void onPositiveClick() {}

                    @Override
                    public void onNegativeClick() {}
                })
                .build(this);
 confirmationDialog.show();
```
</td>
<td>
<img src="https://github.com/JonathanUlhaq/android-popup-dialog/raw/main/Dialog%20Confirmation.gif" width="300"/>
</td>
</tr>
</table>
