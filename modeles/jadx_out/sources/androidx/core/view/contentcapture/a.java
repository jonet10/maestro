package androidx.core.view.contentcapture;

import android.adservices.adselection.AdSelectionManager;
import android.adservices.adselection.AdSelectionOutcome;
import android.view.contentcapture.ContentCaptureSession;
import androidx.fragment.app.Fragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ AdSelectionManager a(Object obj) {
        return (AdSelectionManager) obj;
    }

    public static /* bridge */ /* synthetic */ AdSelectionOutcome b(Object obj) {
        return (AdSelectionOutcome) obj;
    }

    public static /* bridge */ /* synthetic */ ContentCaptureSession c(Object obj) {
        return (ContentCaptureSession) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(int i, int i6) {
        throw new ArrayIndexOutOfBoundsException("Failed writing " + ((char) i) + ((Object) " at index ") + i6);
    }

    public static /* synthetic */ void f(int i, String str) {
        throw new IllegalArgumentException(str + i);
    }

    public static /* synthetic */ void g(Fragment fragment, String str) {
        throw new IllegalStateException(str + ((Object) fragment.toString()) + ((Object) " is already attached to a FragmentManager."));
    }

    public static /* synthetic */ void h(Object obj, String str, Object obj2) {
        throw new IllegalArgumentException(str + obj + obj2);
    }

    public static /* synthetic */ void i(String str, int i, Object obj, int i6, Object obj2) {
        throw new IllegalStateException(str + i + obj + i6 + obj2);
    }

    public static /* synthetic */ void j(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalStateException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void k(String str, Object obj, Throwable th) {
        throw new RuntimeException(str + obj, th);
    }

    public static /* synthetic */ void l(String str, Object[] objArr) {
        throw new ArrayIndexOutOfBoundsException(String.format(str, objArr));
    }

    public static /* synthetic */ void n(Object obj, String str, Object obj2) {
        throw new IllegalStateException(str + obj + obj2);
    }

    public static /* synthetic */ void o(String str, Object[] objArr) {
        throw new IllegalArgumentException(String.format(str, objArr));
    }

    public static /* synthetic */ void p(Object obj, String str, Object obj2) {
        throw new IllegalStateException(str + obj + obj2);
    }

    public static /* synthetic */ void q(Object obj, String str, Object obj2) {
        throw new IllegalArgumentException((str + obj + obj2).toString());
    }
}
