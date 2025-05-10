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
<table>
    <tr>
         <th>
        Success Dialog
    </th>
        <th>
       Demo
    </th>
    </tr>
<tr>
  <td>

<pre>
<code class="language-java">
SuccessDialog successDialog = new SuccessDialog(this);
successDialog.setDialogTitle("Success");
successDialog.setDialogMessage("Data Updated");
successDialog.setButtonText("Close");
successDialog.setOnClickListener(() -> dialogg.dismiss());
successDialog.show();
</code>
</pre>

  </td>
  <td>
    <img src="https://github.com/JonathanUlhaq/android-popup-dialog/raw/main/Demo%20Success%20Dialog.gif" width="300"/>
  </td>
</tr>
</table>

<table >
    <tr>
         <th>
        Failure Dialog
    </th>
        <th>
       Demo
    </th>
    </tr>
<tr>
  <td>

<pre>
<code class="language-java">
FailureDialog failureDialog = new FailureDialog(this);
failureDialog.setDialogTitle("Data Error");
failureDialog.setDialogMessage("Data cannot update");
failureDialog.setButtonText("Close");
failureDialog.setOnClickListener(() -> dialogg.dismiss());
failureDialog.show();
</code>
</pre>

  </td>
  <td>
    <img src="https://github.com/JonathanUlhaq/android-popup-dialog/raw/main/Demo%20Failure%20Dialog.gif" width="300"/>
  </td>
</tr>
</table>

<table >
    <tr>
         <th>
        Warning Dialog
    </th>
        <th>
       Demo
    </th>
    </tr>
<tr>
  <td>

<pre>
<code class="language-java">
 WarningDialog warningDialog = new WarningDialog(this);
warningDialog.setDialogTitle("Check Your Profile");
warningDialog.setDialogMessage("Update your profile");
warningDialog.setButtonText("Understand !");
warningDialog.setOnClickListener(() -> dialogg.dismiss());
warningDialog.show();
</code>
</pre>

  </td>
  <td>
    <img src="https://github.com/JonathanUlhaq/android-popup-dialog/raw/main/Demo%20Warning.gif" width="300"/>
  </td>
</tr>
</table>

