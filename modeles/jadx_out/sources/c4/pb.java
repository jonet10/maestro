package c4;

import com.uptodown.activities.UserAvatarActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class pb extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1996a;

    /* renamed from: b, reason: collision with root package name */
    public int f1997b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ UserAvatarActivity f1998l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ pb(UserAvatarActivity userAvatarActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1996a = i;
        this.f1998l = userAvatarActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1996a) {
            case 0:
                return new pb(this.f1998l, cVar, 0);
            case 1:
                return new pb(this.f1998l, cVar, 1);
            default:
                return new pb(this.f1998l, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1996a) {
            case 0:
                break;
            case 1:
                ((pb) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((pb) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cb  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            int r0 = r13.f1996a
            r1 = 0
            com.uptodown.activities.UserAvatarActivity r2 = r13.f1998l
            r3 = 0
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            u6.a r5 = u6.a.f10762a
            r6 = 1
            switch(r0) {
                case 0: goto L5a;
                case 1: goto L34;
                default: goto Le;
            }
        Le:
            int r0 = r13.f1997b
            if (r0 == 0) goto L1d
            if (r0 == r6) goto L18
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            goto L33
        L18:
            a1.b r14 = androidx.lifecycle.l.q(r14)
            throw r14
        L1d:
            p6.a.e(r14)
            int r14 = com.uptodown.activities.UserAvatarActivity.V
            c4.ub r14 = r2.z0()
            r7.o0 r14 = r14.f2183d
            c4.qb r0 = new c4.qb
            r0.<init>(r2, r6)
            r13.f1997b = r6
            r14.collect(r0, r13)
            r3 = r5
        L33:
            return r3
        L34:
            int r0 = r13.f1997b
            if (r0 == 0) goto L43
            if (r0 == r6) goto L3e
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            goto L59
        L3e:
            a1.b r14 = androidx.lifecycle.l.q(r14)
            throw r14
        L43:
            p6.a.e(r14)
            int r14 = com.uptodown.activities.UserAvatarActivity.V
            c4.ub r14 = r2.z0()
            r7.o0 r14 = r14.f2181b
            c4.qb r0 = new c4.qb
            r0.<init>(r2, r1)
            r13.f1997b = r6
            r14.collect(r0, r13)
            r3 = r5
        L59:
            return r3
        L5a:
            com.uptodown.activities.UserAvatarActivity r8 = r13.f1998l
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.T
            int r2 = r13.f1997b
            p6.x r12 = p6.x.f8463a
            if (r2 == 0) goto L6e
            if (r2 != r6) goto L6a
            p6.a.e(r14)
            goto Lcd
        L6a:
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            goto Ld1
        L6e:
            p6.a.e(r14)
            boolean r14 = r0.compareAndSet(r1, r6)
            if (r14 == 0) goto Ld0
            r13.f1997b = r6
            androidx.lifecycle.LifecycleCoroutineScope r14 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r8)
            v7.e r2 = o7.m0.f8288a
            p7.c r2 = t7.n.f10348a
            c4.pb r3 = new c4.pb
            r10 = 0
            r4 = 2
            r3.<init>(r8, r10, r4)
            o7.c0.s(r14, r2, r10, r3, r4)
            e4.a1 r14 = r8.Q
            r2 = -1
            if (r14 == 0) goto L9e
            int r3 = r14.f
            if (r3 == r2) goto L9e
            java.util.ArrayList r14 = r14.f4479a
            java.lang.Object r14 = r14.get(r3)
            x4.i r14 = (x4.i) r14
        L9c:
            r9 = r14
            goto Lb0
        L9e:
            e4.a1 r14 = r8.R
            if (r14 == 0) goto Laf
            int r3 = r14.f
            if (r3 == r2) goto Laf
            java.util.ArrayList r14 = r14.f4479a
            java.lang.Object r14 = r14.get(r3)
            x4.i r14 = (x4.i) r14
            goto L9c
        Laf:
            r9 = r10
        Lb0:
            if (r9 == 0) goto Lc9
            c4.ub r7 = r8.z0()
            r7.getClass()
            o7.a0 r14 = androidx.lifecycle.ViewModelKt.getViewModelScope(r7)
            v7.d r2 = v7.d.f10884a
            b5.l r6 = new b5.l
            r11 = 12
            r6.<init>(r7, r8, r9, r10, r11)
            o7.c0.s(r14, r2, r10, r6, r4)
        Lc9:
            if (r12 != r5) goto Lcd
            r3 = r5
            goto Ld1
        Lcd:
            r0.set(r1)
        Ld0:
            r3 = r12
        Ld1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.pb.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
