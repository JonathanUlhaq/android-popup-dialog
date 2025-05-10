📦 # Initial Release - v1.0.0

🔰 ## Summary
The initial release of `AndroidPopUp`, is an Android library that provides Pop Up UI components, such as Pop Ups for Success, Failure and Warning.

📦 ## Implementation
- Add jitpack.io to your settings.gradle:
```
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
```
...
implementation "com.github.JonathanUlhaq:android-popup-dialog:1.0.0"
```
### Success Dialog
 ```
SuccessDialog successDialog = new SuccessDialog(this);
        successDialog.setDialogTitle("Success");
        successDialog.setDialogMessage("Data Updated");
        successDialog.setButtonText("Close");
        successDialog.setOnClickListener(() -> dialogg.dismiss());
        successDialog.show();
```
(![]https://github.com/JonathanUlhaq/android-popup-dialog/blob/main/Demo%20Success%20ct.mp4)
