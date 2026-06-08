package b;

import androidx.lifecycle.LiveDataScope;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class j extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f682a;

    /* renamed from: b, reason: collision with root package name */
    public int f683b;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f684l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(int i, t6.c cVar, int i6) {
        super(i, cVar);
        this.f682a = i6;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f682a) {
            case 0:
                j jVar = new j(2, cVar, 0);
                jVar.f684l = obj;
                return jVar;
            default:
                j jVar2 = new j(2, cVar, 1);
                jVar2.f684l = obj;
                return jVar2;
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f682a) {
            case 0:
                j jVar = new j(2, (t6.c) obj2, 0);
                jVar.f684l = (a0) obj;
                return jVar.invokeSuspend(x.f8463a);
            default:
                j jVar2 = new j(2, (t6.c) obj2, 1);
                jVar2.f684l = (LiveDataScope) obj;
                return jVar2.invokeSuspend(x.f8463a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
    
        if (r7 == r0) goto L31;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            int r0 = r6.f682a
            switch(r0) {
                case 0: goto L62;
                default: goto L5;
            }
        L5:
            int r0 = r6.f683b
            r1 = 2
            r2 = 1
            u6.a r3 = u6.a.f10762a
            if (r0 == 0) goto L24
            if (r0 == r2) goto L1c
            if (r0 != r1) goto L15
            p6.a.e(r7)
            goto L5f
        L15:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            r3 = 0
            goto L61
        L1c:
            java.lang.Object r0 = r6.f684l
            androidx.lifecycle.LiveDataScope r0 = (androidx.lifecycle.LiveDataScope) r0
            p6.a.e(r7)
            goto L51
        L24:
            p6.a.e(r7)
            java.lang.Object r7 = r6.f684l
            r0 = r7
            androidx.lifecycle.LiveDataScope r0 = (androidx.lifecycle.LiveDataScope) r0
            f9.h r7 = f9.q.f5066b
            r6.f684l = r0
            r6.f683b = r2
            r7.getClass()
            java.util.ArrayList r2 = r7.h
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r4.addAll(r2)
            f9.l r5 = new f9.l
            r5.<init>(r4)
            r2.clear()
            r2 = 6
            f9.d r4 = f9.d.GDPR
            java.lang.Object r7 = r7.b(r2, r5, r4, r6)
            if (r7 != r3) goto L51
            goto L61
        L51:
            java.lang.String r7 = (java.lang.String) r7
            r2 = 0
            r6.f684l = r2
            r6.f683b = r1
            java.lang.Object r7 = r0.emit(r7, r6)
            if (r7 != r3) goto L5f
            goto L61
        L5f:
            p6.x r3 = p6.x.f8463a
        L61:
            return r3
        L62:
            int r0 = r6.f683b
            r1 = 1
            if (r0 == 0) goto L76
            if (r0 != r1) goto L6f
            p6.a.e(r7)     // Catch: java.lang.Throwable -> L6d
            goto L8b
        L6d:
            r7 = move-exception
            goto L8e
        L6f:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            r7 = 0
            goto L9a
        L76:
            p6.a.e(r7)
            java.lang.Object r7 = r6.f684l
            o7.a0 r7 = (o7.a0) r7
            com.inmobi.cmp.ChoiceCmp r7 = com.inmobi.cmp.ChoiceCmp.INSTANCE     // Catch: java.lang.Throwable -> L6d
            r6.f683b = r1     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r7 = com.inmobi.cmp.ChoiceCmp.access$handleBrandingLogo(r7, r6)     // Catch: java.lang.Throwable -> L6d
            u6.a r0 = u6.a.f10762a
            if (r7 != r0) goto L8b
        L89:
            r7 = r0
            goto L9a
        L8b:
            p6.x r7 = p6.x.f8463a     // Catch: java.lang.Throwable -> L6d
            goto L94
        L8e:
            p6.j r0 = new p6.j
            r0.<init>(r7)
            r7 = r0
        L94:
            p6.k r0 = new p6.k
            r0.<init>(r7)
            goto L89
        L9a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: b.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
