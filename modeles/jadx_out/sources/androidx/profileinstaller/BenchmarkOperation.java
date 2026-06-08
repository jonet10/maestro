package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class BenchmarkOperation {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(api = 21)
    public static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        public static File getCodeCacheDir(Context context) {
            return context.getCodeCacheDir();
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(api = 24)
    public static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        public static Context createDeviceProtectedStorageContext(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    private BenchmarkOperation() {
    }

    public static boolean deleteFilesRecursively(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z9 = true;
        for (File file2 : listFiles) {
            z9 = deleteFilesRecursively(file2) && z9;
        }
        return z9;
    }

    public static void dropShaderCache(@NonNull Context context, @NonNull ProfileInstallReceiver.ResultDiagnostics resultDiagnostics) {
        int i = Build.VERSION.SDK_INT;
        if (deleteFilesRecursively(i >= 34 ? Api24ContextHelper.createDeviceProtectedStorageContext(context).getCacheDir() : i >= 24 ? Api21ContextHelper.getCodeCacheDir(Api24ContextHelper.createDeviceProtectedStorageContext(context)) : i == 23 ? Api21ContextHelper.getCodeCacheDir(context) : context.getCacheDir())) {
            resultDiagnostics.onResultReceived(14, null);
        } else {
            resultDiagnostics.onResultReceived(15, null);
        }
    }
}
