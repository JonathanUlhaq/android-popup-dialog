# Version 1.1.0 - Update Highlights

## 🔰 Summary

This update introduces a more flexible and expressive way to create dialogs using the Fluent Builder pattern, along with several customization options to enhance your UI/UX.

## ✨ What's New
- ✅ Fluent Builder Pattern
- 🎨 Dialog Customizations
- - Change dialog background drawable
  - Change title and message text color
  - Customize button text color
  - Change dialog icon with:
  - - **Lottie animation** via `string` json asset name
    - **Drawable Resource** via `int`

## 📦 Implementation
- New Customization:
```java
.setDialogBackground(Integer drawable)
.setDialogIcon(Integer drawable)
.setDialogIcon(String lottieAnimationView)
.setDialogTitleColor(Integer color)
.setDialogMessageColor(Integer color)
.setButtonTextColor(Integer color)
.setButtonBackground(Integer drawable)
```
```java
InformationDialog dialogCustom = new InformationDialog
                .Builder()
                .setDialogBackground(R.drawable.bg_rounded_dialog)
                .setDialogIcon(R.drawable.ic_launcher_foreground)
                .setDialogTitle("Trust Success")
                .setDialogTitleColor(R.color.red)
                .setDialogMessage("Trust for success")
                .setDialogMessageColor(R.color.black)
                .setButtonTextColor(R.color.white)
                .setButtonBackground(R.drawable.bg_button_warning)
                .setButtonText("Confirm")
                .setOnClickListener(() -> {
                })
                .setOnDialogDismissListener(() -> {
                })
                .build(this);
dialogCustom.show();
```

# Initial Release - v1.0.0

## 🔰 Summary
The initial release of `AndroidPopUp`, is an Android library that provides Pop Up UI components, such as Pop Ups for Success, Failure and Warning.

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
