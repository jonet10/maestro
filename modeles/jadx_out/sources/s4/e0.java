package s4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.fragment.app.Fragment;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.Iterator;
import org.json.JSONObject;
import u4.m1;
import u4.s1;
import u4.z0;
import u4.z1;
import x4.g2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9192a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f9193b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f9194l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(u4.d dVar, x4.g gVar, t6.c cVar) {
        super(2, cVar);
        this.f9192a = 2;
        this.f9194l = dVar;
        this.f9193b = gVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9192a) {
            case 0:
                return new e0((x4.g) this.f9193b, (r.k) this.f9194l, cVar, 0);
            case 1:
                return new e0((String) this.f9193b, (u4.d) this.f9194l, cVar, 1);
            case 2:
                return new e0((u4.d) this.f9194l, (x4.g) this.f9193b, cVar);
            case 3:
                return new e0((Context) this.f9193b, (u4.f0) this.f9194l, cVar, 3);
            case 4:
                e0 e0Var = new e0((u4.f0) this.f9194l, cVar, 4);
                e0Var.f9193b = obj;
                return e0Var;
            case 5:
                return new e0((String) this.f9193b, (z0) this.f9194l, cVar, 5);
            case 6:
                return new e0((String) this.f9193b, (m1) this.f9194l, cVar, 6);
            case 7:
                e0 e0Var2 = new e0((z1) this.f9194l, cVar, 7);
                e0Var2.f9193b = obj;
                return e0Var2;
            default:
                return new e0((z1) this.f9193b, (String) this.f9194l, cVar, 8);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9192a) {
            case 0:
                return ((e0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 1:
                e0 e0Var = (e0) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                e0Var.invokeSuspend(xVar);
                return xVar;
            case 2:
                return ((e0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 3:
                e0 e0Var2 = (e0) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                e0Var2.invokeSuspend(xVar2);
                return xVar2;
            case 4:
                e0 e0Var3 = (e0) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                e0Var3.invokeSuspend(xVar3);
                return xVar3;
            case 5:
                e0 e0Var4 = (e0) create(a0Var, cVar);
                p6.x xVar4 = p6.x.f8463a;
                e0Var4.invokeSuspend(xVar4);
                return xVar4;
            case 6:
                e0 e0Var5 = (e0) create(a0Var, cVar);
                p6.x xVar5 = p6.x.f8463a;
                e0Var5.invokeSuspend(xVar5);
                return xVar5;
            case 7:
                e0 e0Var6 = (e0) create(a0Var, cVar);
                p6.x xVar6 = p6.x.f8463a;
                e0Var6.invokeSuspend(xVar6);
                return xVar6;
            default:
                e0 e0Var7 = (e0) create(a0Var, cVar);
                p6.x xVar7 = p6.x.f8463a;
                e0Var7.invokeSuspend(xVar7);
                return xVar7;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        p6.j jVar;
        Object obj2;
        JSONObject jSONObject;
        e4.q0 q0Var;
        String str;
        z0 z0Var;
        e4.h hVar;
        m1 m1Var;
        e4.h hVar2;
        switch (this.f9192a) {
            case 0:
                p6.a.e(obj);
                x4.g gVar = (x4.g) this.f9193b;
                long j = gVar.f11158a;
                gVar.f11159b.getClass();
                gVar.h();
                Context context = ((r.k) this.f9194l).f8834a;
                g2 a8 = new j5.v(context).a(gVar.f11158a);
                if (a8.b() || (jSONObject = a8.f11206d) == null) {
                    jVar = new p6.j(new Exception());
                } else {
                    if (jSONObject.optInt("success") == 1) {
                        new android.support.v4.media.g(context, 20).E(k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "added"), "preregister");
                        j5.g l10 = j5.g.D.l(context);
                        l10.b();
                        if (l10.U(j) == null) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("appId", Long.valueOf(j));
                            contentValues.put("automaticDownload", (Integer) 1);
                            SQLiteDatabase sQLiteDatabase = l10.f6673a;
                            sQLiteDatabase.getClass();
                            sQLiteDatabase.insert("preregistrations", null, contentValues);
                        }
                        l10.c();
                        obj2 = Boolean.TRUE;
                        return new p6.k(obj2);
                    }
                    jVar = new p6.j(new Exception());
                }
                obj2 = jVar;
                return new p6.k(obj2);
            case 1:
                u4.d dVar = (u4.d) this.f9194l;
                p6.a.e(obj);
                String str2 = (String) this.f9193b;
                if (str2 != null && str2.length() != 0 && (q0Var = dVar.f10448l) != null) {
                    Iterator it = q0Var.f4666l.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        int i6 = i + 1;
                        Object obj3 = ((e4.o0) it.next()).f4648a;
                        if ((obj3 instanceof x4.g) && (str = ((x4.g) obj3).F) != null && str.equals(str2)) {
                            e4.q0 q0Var2 = dVar.f10448l;
                            q0Var2.getClass();
                            q0Var2.notifyItemChanged(i);
                        }
                        i = i6;
                    }
                }
                return p6.x.f8463a;
            case 2:
                p6.a.e(obj);
                u4.d dVar2 = (u4.d) this.f9194l;
                Context requireContext = dVar2.requireContext();
                requireContext.getClass();
                j5.v vVar = new j5.v(requireContext);
                x4.c cVar = dVar2.f10447b;
                if (cVar == null) {
                    kotlin.jvm.internal.l.i("alternatives");
                    throw null;
                }
                x4.g gVar2 = cVar.f11074d;
                String valueOf = String.valueOf(gVar2 != null ? new Long(gVar2.f11158a) : null);
                String valueOf2 = String.valueOf(((x4.g) this.f9193b).f11158a);
                valueOf2.getClass();
                String str3 = "/eapi/v2/comparison/" + valueOf + "/insight-data/" + valueOf2;
                g2 k5 = vVar.k("https://www.uptodown.app:443".concat(str3), null, ShareTarget.METHOD_GET, false);
                k5.f11206d = vVar.i(k5, str3);
                return k5;
            case 3:
                p6.a.e(obj);
                e1.c0 c0Var = j5.g.D;
                Context context2 = (Context) this.f9193b;
                j5.g l11 = c0Var.l(context2);
                l11.b();
                u4.f0 f0Var = (u4.f0) this.f9194l;
                x4.r I = l11.I(String.valueOf(f0Var.B().J));
                if (I == null) {
                    String str4 = f0Var.B().F;
                    str4.getClass();
                    I = l11.L(f0Var.B().K, str4);
                }
                if (I != null) {
                    if (I.p()) {
                        if (I.m()) {
                            f0Var.p0(context2);
                        }
                        v6.f.a(l11.j(I));
                    } else {
                        Iterator it2 = I.F.iterator();
                        it2.getClass();
                        while (it2.hasNext()) {
                            Object next = it2.next();
                            next.getClass();
                            x4.j0 j0Var = (x4.j0) next;
                            j0Var.f11238o = 0L;
                            j0Var.f11241r = 0;
                            l11.r0(j0Var);
                        }
                    }
                }
                l11.c();
                return p6.x.f8463a;
            case 4:
                o7.a0 a0Var = (o7.a0) this.f9193b;
                p6.a.e(obj);
                u4.f0 f0Var2 = (u4.f0) this.f9194l;
                t6.c cVar2 = null;
                o7.c0.s(a0Var, null, null, new u4.w(f0Var2, cVar2, 5), 3);
                o7.c0.s(a0Var, null, null, new u4.w(f0Var2, cVar2, 6), 3);
                o7.c0.s(a0Var, null, null, new u4.w(f0Var2, cVar2, 7), 3);
                o7.c0.s(a0Var, null, null, new u4.w(f0Var2, cVar2, 8), 3);
                return p6.x.f8463a;
            case 5:
                p6.a.e(obj);
                String str5 = (String) this.f9193b;
                if (str5 != null && str5.length() != 0 && (hVar = (z0Var = (z0) this.f9194l).f10670b) != null) {
                    hVar.d(str5, z0Var.h());
                }
                return p6.x.f8463a;
            case 6:
                p6.a.e(obj);
                String str6 = (String) this.f9193b;
                if (str6 != null && str6.length() != 0 && (hVar2 = (m1Var = (m1) this.f9194l).f10538b) != null) {
                    hVar2.d(str6, m1Var.b().f10040m);
                }
                return p6.x.f8463a;
            case 7:
                o7.a0 a0Var2 = (o7.a0) this.f9193b;
                p6.a.e(obj);
                z1 z1Var = (z1) this.f9194l;
                t6.c cVar3 = null;
                o7.c0.s(a0Var2, null, null, new s1(z1Var, cVar3, 0), 3);
                o7.c0.s(a0Var2, null, null, new s1(z1Var, cVar3, 1), 3);
                o7.c0.s(a0Var2, null, null, new s1(z1Var, cVar3, 2), 3);
                o7.c0.s(a0Var2, null, null, new s1(z1Var, cVar3, 3), 3);
                return p6.x.f8463a;
            default:
                p6.a.e(obj);
                z1 z1Var2 = (z1) this.f9193b;
                String str7 = (String) this.f9194l;
                int c9 = z1Var2.c(str7);
                e4.q0 q0Var3 = z1Var2.f10685o;
                if (c9 > -1) {
                    if (q0Var3 != null) {
                        q0Var3.notifyItemChanged(z1Var2.c(str7));
                    }
                } else if (q0Var3 != null) {
                    q0Var3.notifyDataSetChanged();
                }
                return p6.x.f8463a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(Object obj, Object obj2, t6.c cVar, int i) {
        super(2, cVar);
        this.f9192a = i;
        this.f9193b = obj;
        this.f9194l = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(Fragment fragment, t6.c cVar, int i) {
        super(2, cVar);
        this.f9192a = i;
        this.f9194l = fragment;
    }
}
