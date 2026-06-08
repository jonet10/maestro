package androidx.datastore.core;

import android.os.Build;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FileMoves_androidKt {
    public static final boolean atomicMoveTo(File file, File file2) {
        file.getClass();
        file2.getClass();
        return Build.VERSION.SDK_INT >= 26 ? Api26Impl.INSTANCE.move(file, file2) : file.renameTo(file2);
    }
}
