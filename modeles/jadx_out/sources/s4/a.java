package s4;

import android.content.Context;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public j5.g f9159a;

    /* renamed from: b, reason: collision with root package name */
    public Context f9160b;

    /* renamed from: l, reason: collision with root package name */
    public d7.q f9161l;

    /* renamed from: m, reason: collision with root package name */
    public Iterator f9162m;

    /* renamed from: n, reason: collision with root package name */
    public int f9163n;

    /* renamed from: o, reason: collision with root package name */
    public int f9164o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Context f9165p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ v6.i f9166q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(Context context, d7.q qVar, t6.c cVar) {
        super(2, cVar);
        this.f9165p = context;
        this.f9166q = (v6.i) qVar;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [d7.q, v6.i] */
    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new a(this.f9165p, this.f9166q, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((a) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:19:0x003f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // v6.a
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            int r0 = r11.f9164o
            r1 = 1
            android.content.Context r2 = r11.f9165p
            if (r0 == 0) goto L24
            if (r0 != r1) goto L1d
            int r0 = r11.f9163n
            java.util.Iterator r3 = r11.f9162m
            d7.q r4 = r11.f9161l
            android.content.Context r5 = r11.f9160b
            j5.g r6 = r11.f9159a
            p6.a.e(r12)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            goto L3f
        L17:
            r12 = move-exception
            goto Lb0
        L1a:
            r12 = move-exception
            goto L9d
        L1d:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r12)
            r12 = 0
            return r12
        L24:
            p6.a.e(r12)
            e1.c0 r12 = j5.g.D
            j5.g r6 = r12.l(r2)
            java.util.ArrayList r12 = j5.a.i(r2)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            r6.b()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            v6.i r0 = r11.f9166q     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            r3 = 0
            r4 = r0
            r5 = r2
            r0 = r3
            r3 = r12
        L3f:
            boolean r12 = r3.hasNext()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            if (r12 == 0) goto L99
            java.lang.Object r12 = r3.next()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            x4.e r12 = (x4.e) r12     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            java.lang.String r7 = r12.f11123l     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            if (r7 == 0) goto L3f
            int r7 = r7.length()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a
            if (r7 != 0) goto L56
            goto L3f
        L56:
            android.content.pm.PackageManager r7 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r7.getClass()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            java.lang.String r8 = r12.f11123l     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r8.getClass()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r9 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r7 = n4.i.b(r7, r8, r9)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            long r7 = j5.a.a(r7)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            long r9 = r12.f11133w     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 == 0) goto L3f
            r12.f11133w = r7     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r6.n0(r12)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            java.lang.String r12 = r12.f11123l     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r12.getClass()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            java.lang.Long r9 = new java.lang.Long     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r9.<init>(r7)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.f9159a = r6     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.f9160b = r5     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r7 = r4
            d7.q r7 = (d7.q) r7     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.f9161l = r7     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.f9162m = r3     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.f9163n = r0     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            r11.f9164o = r1     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            java.lang.Object r12 = r4.invoke(r12, r9, r11)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1a android.content.pm.PackageManager.NameNotFoundException -> L3f
            u6.a r7 = u6.a.f10762a
            if (r12 != r7) goto L3f
            return r7
        L99:
            r6.c()
            goto Lad
        L9d:
            r12.printStackTrace()     // Catch: java.lang.Throwable -> L17
            android.support.v4.media.g r0 = new android.support.v4.media.g     // Catch: java.lang.Throwable -> L17
            r1 = 20
            r0.<init>(r2, r1)     // Catch: java.lang.Throwable -> L17
            java.lang.String r1 = "CoroutineCalculateAppSize"
            r0.F(r1, r12)     // Catch: java.lang.Throwable -> L17
            goto L99
        Lad:
            p6.x r12 = p6.x.f8463a
            return r12
        Lb0:
            r6.c()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.a.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
