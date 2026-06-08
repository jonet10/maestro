package f9;

import android.app.UiModeManager;
import android.content.Context;
import b2.t1;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.Vector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import q6.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final u5.m f5023a;

    /* renamed from: b, reason: collision with root package name */
    public final l8.n f5024b;

    /* renamed from: c, reason: collision with root package name */
    public final i9.b f5025c;

    /* renamed from: d, reason: collision with root package name */
    public final i9.i f5026d;

    /* renamed from: e, reason: collision with root package name */
    public final ChoiceCmpCallback f5027e;
    public final l9.a f;
    public final String g;
    public final ArrayList h;

    public h(u5.m mVar, l8.n nVar, i9.b bVar, i9.i iVar, ChoiceCmpCallback choiceCmpCallback, l9.a aVar, String str) {
        bVar.getClass();
        iVar.getClass();
        aVar.getClass();
        str.getClass();
        this.f5023a = mVar;
        this.f5024b = nVar;
        this.f5025c = bVar;
        this.f5026d = iVar;
        this.f5027e = choiceCmpCallback;
        this.f = aVar;
        this.g = str;
        this.h = new ArrayList();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static f9.b a(f9.d r12) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.h.a(f9.d):f9.b");
    }

    public static Object e(h hVar, Boolean bool, String str, String str2, String str3, v6.i iVar, int i) {
        boolean z9 = (i & 64) == 0;
        hVar.getClass();
        l9.a aVar = hVar.f;
        ArrayList arrayList = hVar.h;
        Boolean bool2 = Boolean.TRUE;
        ArrayList arrayList2 = null;
        String f = kotlin.jvm.internal.l.a(bool, bool2) ? "All" : hVar.f(null);
        String f10 = kotlin.jvm.internal.l.a(bool, bool2) ? "none" : hVar.f("legitimate");
        String e10 = l.g.e();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(arrayList);
        if (l.g.f7044a) {
            arrayList2 = new ArrayList();
            l.g.f7045b.forEach(new j8.f(arrayList2, 1));
        }
        k kVar = new k(arrayList3, f, f10, str, str2, null, null, str3, null, e10, arrayList2, Boolean.valueOf(z9), 96);
        arrayList.clear();
        aVar.f(76, f);
        if (e10 == null) {
            e10 = "";
        }
        aVar.f(93, e10);
        return hVar.b(3, kVar, d.GDPR, iVar);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:3|(6:5|6|7|(1:(1:10)(2:14|15))(3:16|17|(3:19|20|(1:22))(3:23|(1:25)(1:27)|26))|11|12))|29|6|7|(0)(0)|11|12) */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(int r5, f9.i r6, f9.d r7, v6.c r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof f9.e
            if (r0 == 0) goto L13
            r0 = r8
            f9.e r0 = (f9.e) r0
            int r1 = r0.f5016l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5016l = r1
            goto L18
        L13:
            f9.e r0 = new f9.e
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f5014a
            int r1 = r0.f5016l
            java.lang.String r2 = ""
            r3 = 1
            if (r1 == 0) goto L2e
            if (r1 != r3) goto L27
            p6.a.e(r8)     // Catch: r5.a -> L7c
            goto L6f
        L27:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L2e:
            p6.a.e(r8)
            r4.g(r5, r6, r7)
            java.lang.String r5 = "https://api.cmp.inmobi.com/"
            android.net.Uri r5 = android.net.Uri.parse(r5)
            android.net.Uri$Builder r5 = r5.buildUpon()
            java.lang.String r6 = r6.d()
            java.lang.String r7 = "\\"
            r8 = 0
            java.lang.String r6 = l7.u.o0(r6, r7, r2, r8)
            java.lang.String r7 = "log"
            android.net.Uri$Builder r5 = r5.appendQueryParameter(r7, r6)
            android.net.Uri r5 = r5.build()
            java.lang.String r5 = r5.toString()
            r5.getClass()
            i9.b r6 = r4.f5025c     // Catch: r5.a -> L7c
            boolean r6 = r6.a()     // Catch: r5.a -> L7c
            if (r6 == 0) goto L72
            i9.i r6 = r4.f5026d     // Catch: r5.a -> L7c
            r0.f5016l = r3     // Catch: r5.a -> L7c
            java.lang.Object r8 = r6.b(r5, r0)     // Catch: r5.a -> L7c
            u6.a r5 = u6.a.f10762a
            if (r8 != r5) goto L6f
            return r5
        L6f:
            java.lang.String r8 = (java.lang.String) r8     // Catch: r5.a -> L7c
            return r8
        L72:
            com.inmobi.cmp.ChoiceCmpCallback r5 = r4.f5027e     // Catch: r5.a -> L7c
            if (r5 != 0) goto L77
            goto L7c
        L77:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: r5.a -> L7c
            r5.onCmpError(r6)     // Catch: r5.a -> L7c
        L7c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.h.b(int, f9.i, f9.d, v6.c):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(3:21|22|(1:24))(2:25|(1:27)(1:28)))|11|12|13))|30|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(int r5, f9.n r6, f9.d r7, v6.c r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof f9.f
            if (r0 == 0) goto L13
            r0 = r8
            f9.f r0 = (f9.f) r0
            int r1 = r0.f5019l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5019l = r1
            goto L18
        L13:
            f9.f r0 = new f9.f
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f5017a
            int r1 = r0.f5019l
            r2 = 1
            if (r1 == 0) goto L2c
            if (r1 != r2) goto L25
            p6.a.e(r8)     // Catch: r5.a -> L60
            goto L60
        L25:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L2c:
            p6.a.e(r8)
            r4.g(r5, r6, r7)
            java.lang.String r5 = "https://visit-server.inmobi-choice.io/visit-event"
            i9.b r7 = r4.f5025c     // Catch: r5.a -> L60
            boolean r7 = r7.a()     // Catch: r5.a -> L60
            if (r7 == 0) goto L56
            i9.i r7 = r4.f5026d     // Catch: r5.a -> L60
            java.lang.String r6 = r6.d()     // Catch: r5.a -> L60
            java.lang.String r8 = "\\"
            java.lang.String r1 = ""
            r3 = 0
            java.lang.String r6 = l7.u.o0(r6, r8, r1, r3)     // Catch: r5.a -> L60
            r0.f5019l = r2     // Catch: r5.a -> L60
            java.lang.Object r5 = r7.a(r5, r6, r0)     // Catch: r5.a -> L60
            u6.a r6 = u6.a.f10762a
            if (r5 != r6) goto L60
            return r6
        L56:
            com.inmobi.cmp.ChoiceCmpCallback r5 = r4.f5027e     // Catch: r5.a -> L60
            if (r5 != 0) goto L5b
            goto L60
        L5b:
            com.inmobi.cmp.model.ChoiceError r6 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch: r5.a -> L60
            r5.onCmpError(r6)     // Catch: r5.a -> L60
        L60:
            p6.x r5 = p6.x.f8463a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.h.c(int, f9.n, f9.d, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b9 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00bc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(f9.d r18, f9.c r19, java.lang.String r20, boolean r21, v6.c r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r22
            boolean r3 = r2 instanceof f9.g
            if (r3 == 0) goto L19
            r3 = r2
            f9.g r3 = (f9.g) r3
            int r4 = r3.f5022l
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.f5022l = r4
            goto L1e
        L19:
            f9.g r3 = new f9.g
            r3.<init>(r0, r2)
        L1e:
            java.lang.Object r2 = r3.f5020a
            int r4 = r3.f5022l
            r5 = 1
            if (r4 == 0) goto L33
            if (r4 != r5) goto L2c
            p6.a.e(r2)
            goto Lb5
        L2c:
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r1)
            r1 = 0
            return r1
        L33:
            p6.a.e(r2)
            r2 = 0
            if (r21 == 0) goto L3f
            f9.b r4 = a(r1)
            r13 = r4
            goto L40
        L3f:
            r13 = r2
        L40:
            f9.b r12 = new f9.b
            l8.n r4 = r0.f5024b
            if (r4 != 0) goto L47
            goto L4b
        L47:
            java.lang.String r6 = r4.h
            if (r6 != 0) goto L4d
        L4b:
            java.lang.String r6 = ""
        L4d:
            r7 = r6
            p6.m r6 = m9.c.v
            java.lang.Object r6 = r6.getValue()
            l9.a r6 = (l9.a) r6
            r8 = 33
            java.lang.String r8 = r6.j(r8)
            r1.getClass()
            f9.d r6 = f9.d.GDPR
            if (r1 != r6) goto L6c
            boolean r9 = d0.b.C()
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            goto L6d
        L6c:
            r9 = r2
        L6d:
            if (r1 != r6) goto L79
            boolean r6 = d0.b.s()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r10 = r6
            goto L7a
        L79:
            r10 = r2
        L7a:
            boolean r11 = l.g.f7044a
            r6 = r12
            r6.<init>(r7, r8, r9, r10, r11)
            if (r4 != 0) goto L83
            goto Lb9
        L83:
            java.lang.String r7 = r4.f7232b
            java.lang.String r8 = r4.f7235e
            u5.m r6 = r0.f5023a
            int r9 = r6.f10744m
            r6 = r19
            java.lang.String r10 = r6.f5007a
            java.lang.String r11 = r4.f7233c
            if (r21 == 0) goto L98
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r16 = r4
            goto L9a
        L98:
            r16 = r2
        L9a:
            if (r21 == 0) goto La2
            l9.a r2 = r0.f
            java.lang.String r2 = l.g.c(r2)
        La2:
            r15 = r2
            f9.j r6 = new f9.j
            r14 = r20
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r3.f5022l = r5
            java.lang.Object r2 = r0.b(r5, r6, r1, r3)
            u6.a r1 = u6.a.f10762a
            if (r2 != r1) goto Lb5
            return r1
        Lb5:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto Lbc
        Lb9:
            java.lang.String r1 = "Error sending init log: CMP configuration have not been initialized yet"
            return r1
        Lbc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.h.d(f9.d, f9.c, java.lang.String, boolean, v6.c):java.lang.Object");
    }

    public final String f(String str) {
        ArrayList arrayList;
        LinkedHashMap linkedHashMap;
        boolean a8 = kotlin.jvm.internal.l.a(str, "legitimate");
        int i = 0;
        u5.m mVar = this.f5023a;
        if (a8) {
            List d02 = q6.m.d0(mVar.D.getMap().values(), mVar.C.getMap().values(), mVar.f10750s.getMap().values());
            arrayList = new ArrayList();
            Iterator it = d02.iterator();
            while (it.hasNext()) {
                r.k0((Iterable) it.next(), arrayList);
            }
        } else {
            Collection<Boolean> values = mVar.f10749r.getMap().values();
            Vector vector = new Vector(null, 1, null);
            for (Map.Entry<Integer, Boolean> entry : mVar.f10756z.getMap().entrySet()) {
                h8.c cVar = mVar.f10737a;
                h8.i iVar = (cVar == null || (linkedHashMap = cVar.h) == null) ? null : (h8.i) linkedHashMap.get(String.valueOf(entry.getKey().intValue()));
                if (iVar != null && u5.m.b(iVar)) {
                    vector.getMap().put(entry.getKey(), entry.getValue());
                }
            }
            List d03 = q6.m.d0(values, vector.getMap().values(), mVar.A.getMap().values());
            arrayList = new ArrayList();
            Iterator it2 = d03.iterator();
            while (it2.hasNext()) {
                r.k0((Iterable) it2.next(), arrayList);
            }
        }
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList.get(i6);
                i6++;
                if (!((Boolean) obj).booleanValue()) {
                    if (!arrayList.isEmpty()) {
                        int size2 = arrayList.size();
                        while (i < size2) {
                            Object obj2 = arrayList.get(i);
                            i++;
                            if (((Boolean) obj2).booleanValue()) {
                                return "Partial";
                            }
                        }
                    }
                    return a8 ? "all" : "Reject";
                }
            }
        }
        return a8 ? "none" : "All";
    }

    public final void g(int i, i iVar, d dVar) {
        iVar.b(Calendar.getInstance().getTimeInMillis());
        if (i == 0) {
            throw null;
        }
        iVar.f5029b = i;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f5013a);
        sb.append('-');
        String uuid = q.f5065a.toString();
        uuid.getClass();
        sb.append(uuid);
        iVar.f5030c = sb.toString();
        String str = this.g;
        str.getClass();
        iVar.f5031d = str;
        iVar.f5032e = t1.f947c;
        Context applicationContext = m9.c.b().getApplicationContext();
        applicationContext.getClass();
        Object systemService = applicationContext.getSystemService("uimode");
        if (systemService == null) {
            com.google.gson.internal.a.i("null cannot be cast to non-null type android.app.UiModeManager");
            return;
        }
        UiModeManager uiModeManager = (UiModeManager) systemService;
        iVar.f = uiModeManager.getCurrentModeType() == 4 ? "TV" : uiModeManager.getCurrentModeType() == 3 ? "automotive" : applicationContext.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "wearable" : (applicationContext.getResources().getConfiguration().screenLayout & 15) >= 3 ? "tablet" : "mobile";
        l8.n nVar = this.f5024b;
        iVar.g = nVar != null ? nVar.g : null;
    }

    public final void h(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.h.add(new a(Calendar.getInstance().getTimeInMillis(), str + ':' + str2));
    }
}
