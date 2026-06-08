package s;

import a4.x;
import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9106a;

    /* renamed from: b, reason: collision with root package name */
    public final q2.e f9107b;

    /* renamed from: c, reason: collision with root package name */
    public final q2.e f9108c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9109d;

    public b(Context context, q2.e eVar, q2.e eVar2, String str) {
        if (context == null) {
            com.google.gson.internal.a.i("Null applicationContext");
            throw null;
        }
        this.f9106a = context;
        if (eVar == null) {
            com.google.gson.internal.a.i("Null wallClock");
            throw null;
        }
        this.f9107b = eVar;
        if (eVar2 == null) {
            com.google.gson.internal.a.i("Null monotonicClock");
            throw null;
        }
        this.f9108c = eVar2;
        if (str != null) {
            this.f9109d = str;
        } else {
            com.google.gson.internal.a.i("Null backendName");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            b bVar = (b) ((c) obj);
            if (this.f9106a.equals(bVar.f9106a) && this.f9107b.equals(bVar.f9107b) && this.f9108c.equals(bVar.f9108c) && this.f9109d.equals(bVar.f9109d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f9106a.hashCode() ^ 1000003) * 1000003) ^ this.f9107b.hashCode()) * 1000003) ^ this.f9108c.hashCode()) * 1000003) ^ this.f9109d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f9106a);
        sb.append(", wallClock=");
        sb.append(this.f9107b);
        sb.append(", monotonicClock=");
        sb.append(this.f9108c);
        sb.append(", backendName=");
        return x.n(sb, this.f9109d, "}");
    }
}
