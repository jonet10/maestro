package c3;

import android.os.Build;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f1185a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1186b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1187c;

    /* renamed from: d, reason: collision with root package name */
    public final e0 f1188d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f1189e;

    public a(String str, String str2, String str3, e0 e0Var, ArrayList arrayList) {
        String str4 = Build.MANUFACTURER;
        str2.getClass();
        str3.getClass();
        str4.getClass();
        this.f1185a = str;
        this.f1186b = str2;
        this.f1187c = str3;
        this.f1188d = e0Var;
        this.f1189e = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!this.f1185a.equals(aVar.f1185a) || !kotlin.jvm.internal.l.a(this.f1186b, aVar.f1186b) || !kotlin.jvm.internal.l.a(this.f1187c, aVar.f1187c)) {
            return false;
        }
        String str = Build.MANUFACTURER;
        return kotlin.jvm.internal.l.a(str, str) && this.f1188d.equals(aVar.f1188d) && this.f1189e.equals(aVar.f1189e);
    }

    public final int hashCode() {
        return this.f1189e.hashCode() + ((this.f1188d.hashCode() + androidx.lifecycle.l.o(androidx.lifecycle.l.o(androidx.lifecycle.l.o(this.f1185a.hashCode() * 31, 31, this.f1186b), 31, this.f1187c), 31, Build.MANUFACTURER)) * 31);
    }

    public final String toString() {
        return "AndroidApplicationInfo(packageName=" + this.f1185a + ", versionName=" + this.f1186b + ", appBuildVersion=" + this.f1187c + ", deviceManufacturer=" + Build.MANUFACTURER + ", currentProcessDetails=" + this.f1188d + ", appProcessDetails=" + this.f1189e + ')';
    }
}
