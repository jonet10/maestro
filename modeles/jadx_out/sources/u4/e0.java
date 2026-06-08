package u4;

import androidx.fragment.app.FragmentActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10465a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10466b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ f0 f10467l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(String str, f0 f0Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f10465a = i;
        this.f10466b = str;
        this.f10467l = f0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10465a) {
            case 0:
                return new e0(this.f10466b, this.f10467l, cVar, 0);
            default:
                return new e0(this.f10466b, this.f10467l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10465a) {
            case 0:
                e0 e0Var = (e0) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                e0Var.invokeSuspend(xVar);
                return xVar;
            default:
                e0 e0Var2 = (e0) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                e0Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        Object obj4;
        FragmentActivity activity;
        switch (this.f10465a) {
            case 0:
                f0 f0Var = this.f10467l;
                ArrayList arrayList = f0Var.f10482t;
                p6.a.e(obj);
                String str = this.f10466b;
                if (str != null && str.length() != 0) {
                    e4.u0 u0Var = f0Var.f10480r;
                    if (u0Var != null) {
                        ArrayList arrayList2 = u0Var.f4704c;
                        int size = arrayList2.size();
                        int i = 0;
                        while (true) {
                            if (i < size) {
                                obj4 = arrayList2.get(i);
                                i++;
                                if (kotlin.jvm.internal.l.a(((x4.g) obj4).F, str)) {
                                }
                            } else {
                                obj4 = null;
                            }
                        }
                        e4.u0 u0Var2 = f0Var.f10480r;
                        u0Var2.getClass();
                        int u02 = q6.l.u0(u0Var2.f4704c, (x4.g) obj4);
                        e4.u0 u0Var3 = f0Var.f10480r;
                        u0Var3.getClass();
                        u0Var3.notifyItemChanged(u02);
                    }
                    e4.u0 u0Var4 = f0Var.f10481s;
                    if (u0Var4 != null) {
                        ArrayList arrayList3 = u0Var4.f4704c;
                        int size2 = arrayList3.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 < size2) {
                                obj3 = arrayList3.get(i6);
                                i6++;
                                if (kotlin.jvm.internal.l.a(((x4.g) obj3).F, str)) {
                                }
                            } else {
                                obj3 = null;
                            }
                        }
                        e4.u0 u0Var5 = f0Var.f10481s;
                        u0Var5.getClass();
                        int u03 = q6.l.u0(u0Var5.f4704c, (x4.g) obj3);
                        e4.u0 u0Var6 = f0Var.f10481s;
                        u0Var6.getClass();
                        u0Var6.notifyItemChanged(u03);
                    }
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        it.getClass();
                        while (it.hasNext()) {
                            Object next = it.next();
                            next.getClass();
                            e4.u0 u0Var7 = (e4.u0) next;
                            ArrayList arrayList4 = u0Var7.f4704c;
                            int size3 = arrayList4.size();
                            int i10 = 0;
                            while (true) {
                                if (i10 < size3) {
                                    obj2 = arrayList4.get(i10);
                                    i10++;
                                    if (kotlin.jvm.internal.l.a(((x4.g) obj2).F, str)) {
                                        break;
                                    }
                                } else {
                                    obj2 = null;
                                }
                            }
                            u0Var7.notifyItemChanged(arrayList4.indexOf((x4.g) obj2));
                        }
                    }
                }
                break;
            default:
                p6.a.e(obj);
                f0 f0Var2 = this.f10467l;
                if (l7.u.m0(this.f10466b, f0Var2.B().F, true) && (activity = f0Var2.getActivity()) != null) {
                    f0Var2.p0(activity);
                }
                break;
        }
        return p6.x.f8463a;
    }
}
