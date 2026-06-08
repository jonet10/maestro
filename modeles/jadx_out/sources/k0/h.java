package k0;

import android.accounts.Account;
import java.util.Collections;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class h extends e implements i0.b {
    public final Set H;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(android.content.Context r10, android.os.Looper r11, int r12, g4.v r13, i0.e r14, i0.f r15, int r16) {
        /*
            r9 = this;
            k0.k0 r3 = k0.k0.a(r10)
            h0.e r4 = h0.e.f5407d
            k0.y.g(r14)
            k0.y.g(r15)
            k0.l r6 = new k0.l
            r6.<init>(r14)
            k0.l r7 = new k0.l
            r7.<init>(r15)
            java.lang.Object r14 = r13.f5278n
            r8 = r14
            java.lang.String r8 = (java.lang.String) r8
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            java.lang.Object r10 = r13.f5276l
            java.util.Set r10 = (java.util.Set) r10
            java.util.Iterator r11 = r10.iterator()
        L2a:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L44
            java.lang.Object r12 = r11.next()
            com.google.android.gms.common.api.Scope r12 = (com.google.android.gms.common.api.Scope) r12
            boolean r12 = r10.contains(r12)
            if (r12 == 0) goto L3d
            goto L2a
        L3d:
            java.lang.String r10 = "Expanding scopes is not permitted, use implied scopes instead"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r10)
            r10 = 0
            throw r10
        L44:
            r9.H = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.h.<init>(android.content.Context, android.os.Looper, int, g4.v, i0.e, i0.f, int):void");
    }

    @Override // i0.b
    public final Set a() {
        return l() ? this.H : Collections.EMPTY_SET;
    }

    @Override // k0.e
    public final Account p() {
        return null;
    }

    @Override // k0.e
    public final Set s() {
        return this.H;
    }
}
