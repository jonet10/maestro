package androidx.core.net;

import android.net.Uri;
import androidx.core.content.pm.a;
import java.io.File;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class UriKt {
    public static final File toFile(Uri uri) {
        if (!l.a(uri.getScheme(), "file")) {
            a.i(uri, "Uri lacks 'file' scheme: ");
            return null;
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        a.i(uri, "Uri path is null: ");
        return null;
    }

    public static final Uri toUri(String str) {
        return Uri.parse(str);
    }

    public static final Uri toUri(File file) {
        return Uri.fromFile(file);
    }
}
