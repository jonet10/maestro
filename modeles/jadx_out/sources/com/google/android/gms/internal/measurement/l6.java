package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l6 {

    /* renamed from: a, reason: collision with root package name */
    public final s4 f2697a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2698b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f2699c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2700d;

    public l6(s4 s4Var, String str, Object[] objArr) {
        this.f2697a = s4Var;
        this.f2698b = str;
        this.f2699c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f2700d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i6 = 1;
        int i10 = 13;
        while (true) {
            int i11 = i6 + 1;
            char charAt2 = str.charAt(i6);
            if (charAt2 < 55296) {
                this.f2700d = i | (charAt2 << i10);
                return;
            } else {
                i |= (charAt2 & 8191) << i10;
                i10 += 13;
                i6 = i11;
            }
        }
    }

    public final int a() {
        int i = this.f2700d;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }
}
