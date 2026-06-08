package c3;

import android.os.Build;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f1193a;

    /* renamed from: b, reason: collision with root package name */
    public final a f1194b;

    public b(String str, a aVar) {
        String str2 = Build.MODEL;
        String str3 = Build.VERSION.RELEASE;
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.f1193a = str;
        this.f1194b = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!kotlin.jvm.internal.l.a(this.f1193a, bVar.f1193a)) {
            return false;
        }
        String str = Build.MODEL;
        if (!kotlin.jvm.internal.l.a(str, str)) {
            return false;
        }
        String str2 = Build.VERSION.RELEASE;
        return kotlin.jvm.internal.l.a(str2, str2) && this.f1194b.equals(bVar.f1194b);
    }

    public final int hashCode() {
        return this.f1194b.hashCode() + ((y.LOG_ENVIRONMENT_PROD.hashCode() + androidx.lifecycle.l.o((((Build.MODEL.hashCode() + (this.f1193a.hashCode() * 31)) * 31) + 48517563) * 31, 31, Build.VERSION.RELEASE)) * 31);
    }

    public final String toString() {
        return "ApplicationInfo(appId=" + this.f1193a + ", deviceModel=" + Build.MODEL + ", sessionSdkVersion=3.0.4, osVersion=" + Build.VERSION.RELEASE + ", logEnvironment=" + y.LOG_ENVIRONMENT_PROD + ", androidAppInfo=" + this.f1194b + ')';
    }
}
