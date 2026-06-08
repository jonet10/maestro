package c4;

import com.uptodown.activities.Updates;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class db extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f1522a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f1523b;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f1524l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f1525m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f1526n;

    /* renamed from: o, reason: collision with root package name */
    public int f1527o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1528p;

    /* renamed from: q, reason: collision with root package name */
    public int f1529q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ boolean f1530r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ eb f1531s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ Updates f1532t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public db(boolean z9, eb ebVar, Updates updates, t6.c cVar) {
        super(2, cVar);
        this.f1530r = z9;
        this.f1531s = ebVar;
        this.f1532t = updates;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new db(this.f1530r, this.f1531s, this.f1532t, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((db) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        int i;
        ArrayList arrayList2;
        Object C;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        Iterator it;
        boolean booleanValue;
        Object a8;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        eb ebVar = this.f1531s;
        r7.o0 o0Var = ebVar.f1566a;
        int i6 = this.f1529q;
        Updates updates = this.f1532t;
        u6.a aVar = u6.a.f10762a;
        if (i6 == 0) {
            p6.a.e(obj);
            if (this.f1530r) {
                o0Var.getClass();
                o0Var.g(null, j5.p.f6705a);
            }
            ArrayList i10 = j5.a.i(updates);
            j5.g l10 = j5.g.D.l(updates);
            l10.b();
            ArrayList arrayList11 = new ArrayList();
            ArrayList arrayList12 = new ArrayList();
            ArrayList arrayList13 = new ArrayList();
            ArrayList arrayList14 = new ArrayList();
            Iterator it2 = i10.iterator();
            it2.getClass();
            while (it2.hasNext()) {
                Object next = it2.next();
                next.getClass();
                x4.e eVar = (x4.e) next;
                if (eVar.F > 0 && eVar.b(updates)) {
                    int i11 = eVar.v;
                    x4.d dVar = x4.d.f11087a;
                    if (i11 == 1) {
                        eVar.f11127p = dVar;
                        arrayList13.add(eVar);
                    } else {
                        String str = eVar.f11123l;
                        str.getClass();
                        x4.q2 Y = l10.Y(str);
                        if (Y == null) {
                            it = it2;
                            long j = eVar.f11134x;
                            long j6 = eVar.A;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (j6 != j && currentTimeMillis - j < 604800000) {
                                eVar.f11127p = x4.d.f11088b;
                                arrayList14.add(eVar);
                            }
                        } else {
                            it = it2;
                            if (Y.f11348o == 1) {
                                arrayList13.add(eVar);
                            } else {
                                eVar.f11127p = dVar;
                                String str2 = eVar.f11123l;
                                str2.getClass();
                                try {
                                    int applicationEnabledSetting = updates.getPackageManager().getApplicationEnabledSetting(str2);
                                    if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
                                        arrayList12.add(eVar);
                                    }
                                } catch (Error e10) {
                                    e10.printStackTrace();
                                } catch (Exception e11) {
                                    e11.printStackTrace();
                                }
                                if (Y.f11348o == 0) {
                                    arrayList11.add(eVar);
                                }
                            }
                        }
                        if (Y != null && Y.f11347n == 0) {
                            Y.f11347n = 1;
                            l10.p0(Y);
                        }
                        it2 = it;
                    }
                }
            }
            com.google.android.gms.internal.measurement.i5.J(arrayList11, updates);
            q6.q.j0(arrayList14, new k1(new j1(4), 5));
            com.google.android.gms.internal.measurement.i5.J(arrayList13, updates);
            com.google.android.gms.internal.measurement.i5.J(arrayList12, updates);
            ArrayList a0 = l10.a0();
            l10.c();
            ArrayList arrayList15 = new ArrayList();
            arrayList = new ArrayList();
            int size = a0.size();
            int i12 = 0;
            while (i12 < size) {
                Object obj2 = a0.get(i12);
                i12++;
                x4.q2 q2Var = (x4.q2) obj2;
                int size2 = arrayList11.size();
                int i13 = size;
                int i14 = 0;
                while (i14 < size2) {
                    Object obj3 = arrayList11.get(i14);
                    int i15 = i14 + 1;
                    x4.e eVar2 = (x4.e) obj3;
                    int i16 = size2;
                    int i17 = i12;
                    if (kotlin.jvm.internal.l.a(q2Var.f11344b, eVar2.f11123l)) {
                        arrayList.add(q2Var);
                        arrayList15.add(new e4.v0(eVar2, q2Var));
                    }
                    size2 = i16;
                    i14 = i15;
                    i12 = i17;
                }
                size = i13;
            }
            q6.q.j0(arrayList15, new k1(new d4(updates, 2), 6));
            Iterator it3 = arrayList15.iterator();
            it3.getClass();
            while (true) {
                if (!it3.hasNext()) {
                    i = -1;
                    break;
                }
                Object next2 = it3.next();
                next2.getClass();
                e4.v0 v0Var = (e4.v0) next2;
                if (kotlin.jvm.internal.l.a(v0Var.f4708a.f11123l, updates.getPackageName())) {
                    i = arrayList15.indexOf(v0Var);
                    break;
                }
            }
            if (i > 0) {
                arrayList15.add(0, arrayList15.remove(i));
            }
            this.f1522a = arrayList12;
            this.f1523b = arrayList13;
            this.f1524l = arrayList14;
            this.f1525m = arrayList15;
            this.f1526n = arrayList;
            this.f1527o = i;
            this.f1529q = 1;
            v7.e eVar3 = o7.m0.f8288a;
            arrayList2 = null;
            C = o7.c0.C(new b6.a(a0, arrayList11, 0 == true ? 1 : 0, 26), v7.d.f10884a, this);
            if (C != aVar) {
                arrayList3 = arrayList12;
                arrayList4 = arrayList13;
                arrayList5 = arrayList15;
                arrayList6 = arrayList14;
            }
            return aVar;
        }
        if (i6 != 1) {
            if (i6 != 2) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            booleanValue = this.f1528p;
            ArrayList arrayList16 = this.f1525m;
            ArrayList arrayList17 = this.f1524l;
            ArrayList arrayList18 = this.f1523b;
            arrayList10 = this.f1522a;
            p6.a.e(obj);
            arrayList8 = arrayList17;
            arrayList9 = arrayList18;
            arrayList7 = arrayList16;
            a8 = obj;
            j5.r rVar = new j5.r(new ab(arrayList7, arrayList10, arrayList9, arrayList8, new za(booleanValue, ((Boolean) a8).booleanValue())));
            o0Var.getClass();
            o0Var.g(null, rVar);
            return p6.x.f8463a;
        }
        int i18 = this.f1527o;
        arrayList = this.f1526n;
        arrayList5 = this.f1525m;
        arrayList6 = this.f1524l;
        arrayList4 = this.f1523b;
        arrayList3 = this.f1522a;
        p6.a.e(obj);
        arrayList2 = null;
        i = i18;
        C = obj;
        booleanValue = ((Boolean) C).booleanValue();
        this.f1522a = arrayList3;
        this.f1523b = arrayList4;
        this.f1524l = arrayList6;
        this.f1525m = arrayList5;
        this.f1526n = arrayList2;
        this.f1527o = i;
        this.f1528p = booleanValue;
        this.f1529q = 2;
        a8 = eb.a(ebVar, updates, arrayList, booleanValue, this);
        if (a8 != aVar) {
            arrayList7 = arrayList5;
            arrayList8 = arrayList6;
            arrayList9 = arrayList4;
            arrayList10 = arrayList3;
            j5.r rVar2 = new j5.r(new ab(arrayList7, arrayList10, arrayList9, arrayList8, new za(booleanValue, ((Boolean) a8).booleanValue())));
            o0Var.getClass();
            o0Var.g(null, rVar2);
            return p6.x.f8463a;
        }
        return aVar;
    }
}
