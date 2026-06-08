package androidx.room;

import f8.w;
import java.util.Set;
import r7.c0;
import r7.k0;
import r7.o0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ObservedTableVersions {
    private final c0 versions;

    public ObservedTableVersions(int i) {
        this.versions = k0.b(new int[i]);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(r7.i r5, t6.c r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.room.ObservedTableVersions$collect$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.ObservedTableVersions$collect$1 r0 = (androidx.room.ObservedTableVersions$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.ObservedTableVersions$collect$1 r0 = new androidx.room.ObservedTableVersions$collect$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2d
            if (r1 == r2) goto L28
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L28:
            a1.b r5 = androidx.lifecycle.l.q(r6)
            throw r5
        L2d:
            p6.a.e(r6)
            r7.c0 r6 = r4.versions
            r0.label = r2
            r7.o0 r6 = (r7.o0) r6
            r6.collect(r5, r0)
            u6.a r5 = u6.a.f10762a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableVersions.collect(r7.i, t6.c):java.lang.Object");
    }

    public final void increment(Set<Integer> set) {
        o0 o0Var;
        Object value;
        int[] iArr;
        set.getClass();
        if (set.isEmpty()) {
            return;
        }
        c0 c0Var = this.versions;
        do {
            o0Var = (o0) c0Var;
            value = o0Var.getValue();
            int[] iArr2 = (int[]) value;
            int length = iArr2.length;
            iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = set.contains(Integer.valueOf(i)) ? iArr2[i] + 1 : iArr2[i];
            }
            w wVar = s7.c.f9349b;
            if (value == null) {
                value = wVar;
            }
        } while (!o0Var.g(value, iArr));
    }
}
