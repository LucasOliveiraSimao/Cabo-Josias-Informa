# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Manter classes do Conscrypt
-keep class org.conscrypt.** { *; }

# Manter classes do OkHttp relacionadas ao Conscrypt
-keep class okhttp3.internal.platform.ConscryptPlatform { *; }

# Manter classes usadas pelo Firebase
-keep class com.google.firebase.** { *; }
-keep class com.google.android.gms.** { *; }

-ignorewarnings

# Preserve ViewBinding classes
-keep class **ViewBinding { *; }

# Preserve specific inflate methods
-keepclassmembers class * {
    public static ** inflate(android.view.LayoutInflater, android.view.ViewGroup, boolean);
    public static ** inflate(android.view.LayoutInflater);
}
