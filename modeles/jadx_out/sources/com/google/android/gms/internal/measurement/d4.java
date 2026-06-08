package com.google.android.gms.internal.measurement;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d4 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2537a;

    /* renamed from: b, reason: collision with root package name */
    public final k1.d f2538b;

    public d4(Context context, k1.d dVar) {
        this.f2537a = context;
        this.f2538b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d4)) {
            return false;
        }
        d4 d4Var = (d4) obj;
        return this.f2537a.equals(d4Var.f2537a) && this.f2538b.equals(d4Var.f2538b);
    }

    public final int hashCode() {
        return ((this.f2537a.hashCode() ^ 1000003) * 1000003) ^ this.f2538b.hashCode();
    }

    public final String toString() {
        String obj = this.f2537a.toString();
        int length = obj.length();
        String valueOf = String.valueOf(this.f2538b);
        StringBuilder sb = new StringBuilder(length + 45 + valueOf.length() + 1);
        a4.x.B(sb, "FlagsContext{context=", obj, ", hermeticFileOverrides=", valueOf);
        sb.append("}");
        return sb.toString();
    }
}
