package androidx.core.os;

import android.os.Trace;
import d7.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TraceKt {
    public static final <T> T trace(String str, a aVar) {
        Trace.beginSection(str);
        try {
            return (T) aVar.invoke();
        } finally {
            Trace.endSection();
        }
    }
}
