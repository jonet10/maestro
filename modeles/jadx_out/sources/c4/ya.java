package c4;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.DetailsOverviewRow;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.activity.TvMainActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ya extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2362a;

    /* renamed from: b, reason: collision with root package name */
    public int f2363b;

    /* renamed from: l, reason: collision with root package name */
    public Object f2364l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f2365m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ya(int i, j4.o oVar, Object obj, t6.c cVar) {
        super(2, cVar);
        this.f2362a = 18;
        this.f2363b = i;
        this.f2364l = oVar;
        this.f2365m = obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
    
        if (o7.c0.C(new j4.j(r0, null), v7.d.f10884a, r8) == r5) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object a(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f2365m
            j4.o r0 = (j4.o) r0
            int r1 = r8.f2363b
            r2 = 2
            r3 = 1
            r4 = 0
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L15
            p6.a.e(r9)
            goto L58
        L15:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r9)
            return r4
        L1b:
            java.lang.Object r1 = r8.f2364l
            j4.o r1 = (j4.o) r1
            p6.a.e(r9)
            goto L3c
        L23:
            p6.a.e(r9)
            r8.f2364l = r0
            r8.f2363b = r3
            v7.e r9 = o7.m0.f8288a
            v7.d r9 = v7.d.f10884a
            j4.f r1 = new j4.f
            r3 = 0
            r1.<init>(r0, r4, r3)
            java.lang.Object r9 = o7.c0.C(r1, r9, r8)
            if (r9 != r5) goto L3b
            goto L57
        L3b:
            r1 = r0
        L3c:
            java.lang.Number r9 = (java.lang.Number) r9
            long r6 = r9.longValue()
            r1.g = r6
            r8.f2364l = r4
            r8.f2363b = r2
            v7.e r9 = o7.m0.f8288a
            v7.d r9 = v7.d.f10884a
            j4.j r1 = new j4.j
            r1.<init>(r0, r4)
            java.lang.Object r9 = o7.c0.C(r1, r9, r8)
            if (r9 != r5) goto L58
        L57:
            return r5
        L58:
            p6.x r9 = p6.x.f8463a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.ya.a(java.lang.Object):java.lang.Object");
    }

    private final Object b(Object obj) {
        p6.a.e(obj);
        j4.o oVar = (j4.o) this.f2364l;
        k4.a aVar = oVar.f6652c;
        if (aVar == null) {
            return null;
        }
        aVar.o(this.f2363b, (String) this.f2365m, oVar.f, oVar.g);
        return p6.x.f8463a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b6, code lost:
    
        if (o7.c0.C(new n4.q(r11, r12, r13, r14, null), v7.d.f10884a, r16) == r3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e0, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00cc, code lost:
    
        if (o7.c0.C(r4, r1, r16) == r3) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00de, code lost:
    
        if (o7.c0.C(r4, r1, r16) == r3) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object c(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = r0.f2365m
            kotlin.jvm.internal.u r1 = (kotlin.jvm.internal.u) r1
            java.lang.Object r2 = r0.f2364l
            a2.t r2 = (a2.t) r2
            java.lang.Object r3 = r2.f54c
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r2.f53b
            android.content.Context r4 = (android.content.Context) r4
            int r5 = r0.f2363b
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L2c
            if (r5 == r8) goto L27
            if (r5 == r7) goto L27
            if (r5 != r6) goto L21
            goto L27
        L21:
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r1)
            return r9
        L27:
            p6.a.e(r17)
            goto Le1
        L2c:
            p6.a.e(r17)
            android.app.Activity r5 = f4.c.f4875o
            t0.f.f(r4, r3)
            java.io.File r5 = new java.io.File
            java.io.File r4 = r4.getExternalFilesDir(r9)
            java.lang.String r10 = "tmp"
            r5.<init>(r4, r10)
            boolean r4 = r5.exists()
            if (r4 != 0) goto L48
            r5.mkdirs()
        L48:
            java.io.File r11 = new java.io.File
            r11.<init>(r3)
            java.io.File r13 = new java.io.File
            java.lang.String r3 = r11.getName()
            r3.getClass()
            java.lang.String r4 = r11.getName()
            r4.getClass()
            java.lang.String r10 = "."
            r12 = 6
            int r4 = l7.m.A0(r10, r4, r12)
            r10 = 0
            java.lang.String r3 = r3.substring(r10, r4)
            r13.<init>(r5, r3)
            boolean r3 = r13.exists()
            if (r3 != 0) goto L75
            r13.mkdirs()
        L75:
            e1.c0 r12 = new e1.c0
            r3 = 25
            r12.<init>(r3)
            boolean r3 = e1.c0.g(r11)
            if (r3 == 0) goto L9b
            java.io.File r3 = new java.io.File
            java.io.File r4 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r4 = r4.getAbsolutePath()
            java.lang.String r5 = "/Android/obb/"
            java.lang.String r4 = a4.x.C(r4, r5)
            r3.<init>(r4)
            boolean r3 = r3.canWrite()
            r1.f7021a = r3
        L9b:
            boolean r1 = r1.f7021a
            u6.a r3 = u6.a.f10762a
            if (r1 == 0) goto Lb9
            java.lang.Object r1 = r2.f55d
            r14 = r1
            k4.c r14 = (k4.c) r14
            r0.f2363b = r8
            v7.e r1 = o7.m0.f8288a
            v7.d r1 = v7.d.f10884a
            n4.q r10 = new n4.q
            r15 = 0
            r10.<init>(r11, r12, r13, r14, r15)
            java.lang.Object r1 = o7.c0.C(r10, r1, r0)
            if (r1 != r3) goto Le1
            goto Le0
        Lb9:
            boolean r1 = r2.f52a
            if (r1 == 0) goto Lcf
            v7.e r1 = o7.m0.f8288a
            p7.c r1 = t7.n.f10348a
            j4.p r4 = new j4.p
            r4.<init>(r2, r9, r10)
            r0.f2363b = r7
            java.lang.Object r1 = o7.c0.C(r4, r1, r0)
            if (r1 != r3) goto Le1
            goto Le0
        Lcf:
            v7.e r1 = o7.m0.f8288a
            p7.c r1 = t7.n.f10348a
            j4.p r4 = new j4.p
            r4.<init>(r2, r9, r8)
            r0.f2363b = r6
            java.lang.Object r1 = o7.c0.C(r4, r1, r0)
            if (r1 != r3) goto Le1
        Le0:
            return r3
        Le1:
            p6.x r1 = p6.x.f8463a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.ya.c(java.lang.Object):java.lang.Object");
    }

    private final Object d(Object obj) {
        int i = this.f2363b;
        if (i == 0) {
            p6.a.e(obj);
            n4.h hVar = (n4.h) this.f2364l;
            ArrayList arrayList = (ArrayList) this.f2365m;
            this.f2363b = 1;
            ConcurrentHashMap concurrentHashMap = n4.h.f7966c;
            v7.e eVar = o7.m0.f8288a;
            Object C = o7.c0.C(new n4.g(hVar, arrayList, null), v7.d.f10884a, this);
            u6.a aVar = u6.a.f10762a;
            if (C == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return p6.x.f8463a;
    }

    private final Object e(Object obj) {
        int i = this.f2363b;
        t6.c cVar = null;
        if (i == 0) {
            p6.a.e(obj);
            m8.q qVar = (m8.q) this.f2364l;
            File file = (File) this.f2365m;
            this.f2363b = 1;
            v7.e eVar = o7.m0.f8288a;
            Object C = o7.c0.C(new sc(qVar, file, cVar, 22), v7.d.f10884a, this);
            u6.a aVar = u6.a.f10762a;
            if (C == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return p6.x.f8463a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0045, code lost:
    
        if (r12 == r8) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
    
        if (r12 == r8) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object f(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f2365m
            c4.k0 r0 = (c4.k0) r0
            java.lang.Object r1 = r11.f2364l
            n5.d r1 = (n5.d) r1
            android.widget.RelativeLayout r2 = r1.f8070b
            int r3 = r11.f2363b
            r4 = 0
            r5 = 2
            r6 = 1
            if (r3 == 0) goto L2c
            if (r3 == r6) goto L24
            if (r3 != r5) goto L1d
            p6.a.e(r12)
            p6.k r12 = (p6.k) r12
            java.lang.Object r12 = r12.f8444a
            goto L86
        L1d:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r12)
            r12 = 0
            return r12
        L24:
            p6.a.e(r12)
            p6.k r12 = (p6.k) r12
            java.lang.Object r12 = r12.f8444a
            goto L48
        L2c:
            p6.a.e(r12)
            x4.g r12 = r1.f8069a
            int r3 = r12.B0
            r7 = 4
            u6.a r8 = u6.a.f10762a
            if (r3 != r6) goto L76
            e1.v4 r3 = new e1.v4
            r3.<init>(r0, r7, r4)
            long r9 = r12.f11158a
            r11.f2363b = r6
            java.lang.Object r12 = r3.b(r9, r11)
            if (r12 != r8) goto L48
            goto L85
        L48:
            boolean r3 = r12 instanceof p6.j
            if (r3 != 0) goto Lb3
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            r12.getClass()
            boolean r12 = r0.isFinishing()
            if (r12 != 0) goto Lb3
            int r12 = r2.getVisibility()
            if (r12 != 0) goto L60
            n5.d.a(r0, r1)
        L60:
            x4.g r12 = r1.f8069a
            java.lang.String r12 = r12.f11159b
            java.lang.Object[] r1 = new java.lang.Object[r6]
            r1[r4] = r12
            r12 = 2131951656(0x7f130028, float:1.9539733E38)
            java.lang.String r12 = r0.getString(r12, r1)
            r12.getClass()
            r0.A(r12)
            goto Lb3
        L76:
            e1.v4 r3 = new e1.v4
            r3.<init>(r0, r7, r4)
            long r9 = r12.f11158a
            r11.f2363b = r5
            java.lang.Object r12 = r3.a(r9, r11)
            if (r12 != r8) goto L86
        L85:
            return r8
        L86:
            boolean r3 = r12 instanceof p6.j
            if (r3 != 0) goto Lb3
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            r12.getClass()
            boolean r12 = r0.isFinishing()
            if (r12 != 0) goto Lb3
            int r12 = r2.getVisibility()
            if (r12 != 0) goto Lb3
            r1.h(r0)
            x4.g r12 = r1.f8069a
            java.lang.String r12 = r12.f11159b
            java.lang.Object[] r1 = new java.lang.Object[r6]
            r1[r4] = r12
            r12 = 2131951650(0x7f130022, float:1.953972E38)
            java.lang.String r12 = r0.getString(r12, r1)
            r12.getClass()
            r0.A(r12)
        Lb3:
            p6.x r12 = p6.x.f8463a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.ya.f(java.lang.Object):java.lang.Object");
    }

    private final Object h(Object obj) {
        Object jVar;
        int i = this.f2363b;
        Object obj2 = p6.x.f8463a;
        try {
            if (i == 0) {
                p6.a.e(obj);
                q7.u uVar = (q7.u) this.f2365m;
                this.f2363b = 1;
                Object e10 = uVar.e(obj2, this);
                u6.a aVar = u6.a.f10762a;
                if (e10 == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
            }
            jVar = obj2;
        } catch (Throwable th) {
            jVar = new p6.j(th);
        }
        if (jVar instanceof p6.j) {
            obj2 = new q7.j(p6.k.a(jVar));
        }
        return new q7.l(obj2);
    }

    private final Object j(Object obj) {
        int i = this.f2363b;
        t6.c cVar = null;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return obj;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        v7.e eVar = o7.m0.f8288a;
        v7.d dVar = v7.d.f10884a;
        sc scVar = new sc((r.k) this.f2364l, (x4.x1) this.f2365m, cVar, 29);
        this.f2363b = 1;
        Object C = o7.c0.C(scVar, dVar, this);
        u6.a aVar = u6.a.f10762a;
        return C == aVar ? aVar : C;
    }

    private final Object k(Object obj) {
        int i = this.f2363b;
        if (i == 0) {
            p6.a.e(obj);
            q7.s sVar = (q7.s) this.f2364l;
            r7.d dVar = (r7.d) this.f2365m;
            this.f2363b = 1;
            Object c9 = dVar.c(sVar, this);
            u6.a aVar = u6.a.f10762a;
            if (c9 == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return p6.x.f8463a;
    }

    private final Object l(Object obj) {
        int i = this.f2363b;
        p6.x xVar = p6.x.f8463a;
        if (i == 0) {
            p6.a.e(obj);
            r7.i iVar = (r7.i) this.f2364l;
            r7.d dVar = (r7.d) this.f2365m;
            this.f2363b = 1;
            Object collect = ((r7.h) dVar.f8967n).collect(iVar, this);
            u6.a aVar = u6.a.f10762a;
            if (collect != aVar) {
                collect = xVar;
            }
            if (collect == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return xVar;
    }

    private final Object m(Object obj) {
        int i = this.f2363b;
        if (i == 0) {
            p6.a.e(obj);
            r7.h hVar = (r7.h) this.f2364l;
            s7.o oVar = (s7.o) this.f2365m;
            this.f2363b = 1;
            Object collect = hVar.collect(oVar, this);
            u6.a aVar = u6.a.f10762a;
            if (collect == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return p6.x.f8463a;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2362a) {
            case 0:
                return new ya((Updates) this.f2364l, (String) this.f2365m, this.f2363b, cVar, 0);
            case 1:
                return new ya((UserActivity) this.f2364l, (x4.w2) this.f2365m, cVar, 1);
            case 2:
                return new ya((Context) this.f2364l, (vd) this.f2365m, cVar, 2);
            case 3:
                ya yaVar = new ya((f3.c) this.f2365m, cVar, 3);
                yaVar.f2364l = obj;
                return yaVar;
            case 4:
                return new ya((TvMainActivity) this.f2364l, (String) this.f2365m, cVar, 4);
            case 5:
                ya yaVar2 = new ya((FileExplorerActivity) this.f2365m, cVar, 5);
                yaVar2.f2364l = obj;
                return yaVar2;
            case 6:
                return new ya((InstallerActivity) this.f2364l, this.f2363b, (kotlin.jvm.internal.x) this.f2365m, cVar, 6);
            case 7:
                return new ya((TvAppDetailFragment) this.f2364l, (x4.g) this.f2365m, cVar, 7);
            case 8:
                return new ya((TvAppDetailFragment) this.f2364l, (x4.r) this.f2365m, cVar, 8);
            case 9:
                return new ya((TvAppDetailFragment) this.f2365m, cVar, 9);
            case 10:
                return new ya((TvAppDetailFragment) this.f2364l, (DetailsOverviewRow) this.f2365m, cVar, 10);
            case 11:
                return new ya((FragmentActivity) this.f2364l, (TvAppDetailFragment) this.f2365m, cVar, 11);
            case 12:
                return new ya((TvMyAppsFragment) this.f2364l, (x4.e) this.f2365m, cVar, 12);
            case 13:
                return new ya((TvMyDownloadsFragment) this.f2364l, (ArrayList) this.f2365m, cVar, 13);
            case 14:
                return new ya((i2.f) this.f2364l, (d7.l) this.f2365m, cVar, 14);
            case 15:
                return new ya((a2.t) this.f2364l, (l4.b) this.f2365m, this.f2363b, cVar, 15);
            case 16:
                return new ya((a2.t) this.f2364l, (ArrayList) this.f2365m, cVar, 16);
            case 17:
                return new ya((j4.o) this.f2365m, cVar, 17);
            case 18:
                return new ya(this.f2363b, (j4.o) this.f2364l, this.f2365m, cVar);
            case 19:
                return new ya((j4.o) this.f2364l, this.f2363b, (String) this.f2365m, cVar, 19);
            case 20:
                return new ya((a2.t) this.f2364l, (kotlin.jvm.internal.u) this.f2365m, cVar, 20);
            case 21:
                return new ya((n4.h) this.f2364l, (ArrayList) this.f2365m, cVar, 21);
            case 22:
                return new ya((m8.q) this.f2364l, (File) this.f2365m, cVar, 22);
            case 23:
                return new ya((n5.d) this.f2364l, (k0) this.f2365m, cVar, 23);
            case 24:
                ya yaVar3 = new ya((q7.u) this.f2365m, cVar, 24);
                yaVar3.f2364l = obj;
                return yaVar3;
            case 25:
                return new ya((r.k) this.f2364l, (x4.x1) this.f2365m, cVar, 25);
            case 26:
                ya yaVar4 = new ya((r7.d) this.f2365m, cVar, 26);
                yaVar4.f2364l = obj;
                return yaVar4;
            case 27:
                ya yaVar5 = new ya((r7.d) this.f2365m, cVar, 27);
                yaVar5.f2364l = obj;
                return yaVar5;
            case 28:
                return new ya((r7.h) this.f2364l, (s7.o) this.f2365m, cVar, 28);
            default:
                ya yaVar6 = new ya((r7.i) this.f2365m, cVar, 29);
                yaVar6.f2364l = obj;
                return yaVar6;
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f2362a) {
            case 0:
                ya yaVar = (ya) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar = p6.x.f8463a;
                yaVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 2:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 3:
                return ((ya) create((JSONObject) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 4:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 5:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 6:
                ya yaVar2 = (ya) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar2 = p6.x.f8463a;
                yaVar2.invokeSuspend(xVar2);
                return xVar2;
            case 7:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 8:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 9:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 10:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 11:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 12:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 13:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 14:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 15:
                ya yaVar3 = (ya) create((o7.a0) obj, (t6.c) obj2);
                p6.x xVar3 = p6.x.f8463a;
                yaVar3.invokeSuspend(xVar3);
                return xVar3;
            case 16:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 17:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 18:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 19:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 20:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 21:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 22:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 23:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 24:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 25:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 26:
                return ((ya) create((q7.s) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 27:
                return ((ya) create((r7.i) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            case 28:
                return ((ya) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
            default:
                return ((ya) create(obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x014d, code lost:
    
        if (r3.exists() != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0167, code lost:
    
        if (r0.exists() != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fa, code lost:
    
        if (r3.exists() != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00fc, code lost:
    
        r3.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0117, code lost:
    
        if (r0.exists() != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0119, code lost:
    
        r0.delete();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:320:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x05fd  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:484:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:485:0x08d5  */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.String] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 2832
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.ya.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ya(Object obj, int i, Serializable serializable, t6.c cVar, int i6) {
        super(2, cVar);
        this.f2362a = i6;
        this.f2364l = obj;
        this.f2363b = i;
        this.f2365m = serializable;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ya(Object obj, Object obj2, int i, t6.c cVar, int i6) {
        super(2, cVar);
        this.f2362a = i6;
        this.f2364l = obj;
        this.f2365m = obj2;
        this.f2363b = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ya(Object obj, Object obj2, t6.c cVar, int i) {
        super(2, cVar);
        this.f2362a = i;
        this.f2364l = obj;
        this.f2365m = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ya(Object obj, t6.c cVar, int i) {
        super(2, cVar);
        this.f2362a = i;
        this.f2365m = obj;
    }
}
