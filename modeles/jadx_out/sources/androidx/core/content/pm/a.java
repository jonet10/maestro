package androidx.core.content.pm;

import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.location.GnssStatus;
import android.os.LocaleList;
import android.text.PrecomputedText;
import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ ShortcutInfo a(Object obj) {
        return (ShortcutInfo) obj;
    }

    public static /* bridge */ /* synthetic */ ShortcutManager b(Object obj) {
        return (ShortcutManager) obj;
    }

    public static /* bridge */ /* synthetic */ GnssStatus c(Object obj) {
        return (GnssStatus) obj;
    }

    public static /* bridge */ /* synthetic */ LocaleList d(Object obj) {
        return (LocaleList) obj;
    }

    public static /* bridge */ /* synthetic */ Class e() {
        return ShortcutManager.class;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(int i, Object obj, Object obj2, Object obj3, String str) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + ((char) i));
    }

    public static /* synthetic */ void i(Object obj, String str) {
        throw new IllegalArgumentException((str + obj).toString());
    }

    public static /* bridge */ /* synthetic */ boolean j(Object obj) {
        return obj instanceof PrecomputedText;
    }

    public static /* synthetic */ void k(Object obj, String str) {
        throw new IOException(str + obj);
    }
}
