package y1;

import android.util.Log;
import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h {

    /* renamed from: d, reason: collision with root package name */
    public static final e2.a f11620d = new e2.a(2);

    /* renamed from: e, reason: collision with root package name */
    public static final androidx.constraintlayout.core.utils.a f11621e = new androidx.constraintlayout.core.utils.a(12);

    /* renamed from: a, reason: collision with root package name */
    public final e2.d f11622a;

    /* renamed from: b, reason: collision with root package name */
    public String f11623b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f11624c = null;

    public h(e2.d dVar) {
        this.f11622a = dVar;
    }

    public static void a(e2.d dVar, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            dVar.h(str, "aqs.".concat(str2)).createNewFile();
        } catch (IOException e10) {
            Log.w("FirebaseCrashlytics", "Failed to persist App Quality Sessions session id.", e10);
        }
    }
}
