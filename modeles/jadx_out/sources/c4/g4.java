package c4;

import com.uptodown.UptodownApp;
import com.uptodown.activities.MyApps;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g4 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1624a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyApps f1625b;

    public /* synthetic */ g4(MyApps myApps, int i) {
        this.f1624a = i;
        this.f1625b = myApps;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x009f, code lost:
    
        if (r11 == r8) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
    
        if (o7.c0.C(r1, r12, r0) == r8) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(j5.s r11, t6.c r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof c4.k4
            if (r0 == 0) goto L13
            r0 = r12
            c4.k4 r0 = (c4.k4) r0
            int r1 = r0.f1788l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1788l = r1
            goto L18
        L13:
            c4.k4 r0 = new c4.k4
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.f1786a
            int r1 = r0.f1788l
            r2 = 3
            r3 = 2
            r4 = 1
            p6.x r5 = p6.x.f8463a
            com.uptodown.activities.MyApps r6 = r10.f1625b
            r7 = 0
            u6.a r8 = u6.a.f10762a
            if (r1 == 0) goto L41
            if (r1 == r4) goto L3d
            if (r1 == r3) goto L39
            if (r1 != r2) goto L33
            p6.a.e(r12)
            goto La2
        L33:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r11)
            return r7
        L39:
            p6.a.e(r12)
            goto L73
        L3d:
            p6.a.e(r12)
            return r5
        L41:
            p6.a.e(r12)
            boolean r12 = r11 instanceof j5.p
            if (r12 == 0) goto L5b
            v7.e r11 = o7.m0.f8288a
            p7.c r11 = t7.n.f10348a
            c4.j4 r12 = new c4.j4
            r1 = 0
            r12.<init>(r6, r7, r1)
            r0.f1788l = r4
            java.lang.Object r11 = o7.c0.C(r12, r11, r0)
            if (r11 != r8) goto Lb2
            goto La1
        L5b:
            boolean r12 = r11 instanceof j5.r
            if (r12 == 0) goto Lb3
            v7.e r12 = o7.m0.f8288a
            p7.c r12 = t7.n.f10348a
            b6.a r1 = new b6.a
            r9 = 12
            r1.<init>(r6, r11, r7, r9)
            r0.f1788l = r3
            java.lang.Object r11 = o7.c0.C(r1, r12, r0)
            if (r11 != r8) goto L73
            goto La1
        L73:
            int r11 = com.uptodown.activities.MyApps.f3328g0
            c4.y4 r11 = r6.R0()
            r7.o0 r11 = r11.f2343c
            java.lang.Object r11 = r11.getValue()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto Lb2
            c4.d1 r11 = new c4.d1
            r11.<init>(r6, r7, r4)
            r0.f1788l = r2
            v7.e r12 = o7.m0.f8288a
            v7.d r12 = v7.d.f10884a
            s4.a r1 = new s4.a
            r1.<init>(r6, r11, r7)
            java.lang.Object r11 = o7.c0.C(r1, r12, r0)
            if (r11 != r8) goto L9e
            goto L9f
        L9e:
            r11 = r5
        L9f:
            if (r11 != r8) goto La2
        La1:
            return r8
        La2:
            int r11 = com.uptodown.activities.MyApps.f3328g0
            c4.y4 r11 = r6.R0()
            r7.o0 r11 = r11.f2343c
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r11.getClass()
            r11.g(r7, r12)
        Lb2:
            return r5
        Lb3:
            boolean r11 = r11 instanceof j5.q
            if (r11 == 0) goto Lb8
            return r5
        Lb8:
            com.google.gson.internal.a.b()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.g4.a(j5.s, t6.c):java.lang.Object");
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        switch (this.f1624a) {
            case 0:
                float f = UptodownApp.I;
                b4.d.F(this.f1625b);
                return p6.x.f8463a;
            default:
                return a((j5.s) obj, cVar);
        }
    }
}
