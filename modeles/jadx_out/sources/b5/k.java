package b5;

import android.content.Context;
import com.uptodown.UptodownApp;
import d7.p;
import j5.v;
import java.util.ArrayList;
import o7.a0;
import p6.x;
import x4.g2;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends v6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1052a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f1053b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ v f1054l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(m mVar, v vVar, t6.c cVar) {
        super(2, cVar);
        this.f1053b = mVar;
        this.f1054l = vVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1052a) {
            case 0:
                return new k(this.f1054l, this.f1053b, cVar);
            default:
                return new k(this.f1053b, this.f1054l, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1052a) {
        }
        return ((k) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        int i = this.f1052a;
        p2 p2Var = null;
        boolean z9 = true;
        m mVar = this.f1053b;
        v vVar = this.f1054l;
        switch (i) {
            case 0:
                p6.a.e(obj);
                x4.j jVar = (x4.j) mVar.f1063m;
                g2 p10 = vVar.p(jVar.f11224a, 10, 0);
                if (p10.b() || (str = p10.f11203a) == null || str.length() == 0) {
                    z9 = false;
                } else {
                    ArrayList E = v.E(p10);
                    try {
                        str2 = ((Context) mVar.f1061b).getString(2131952639);
                        str2.getClass();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        str2 = "The latest";
                    }
                    x4.j jVar2 = new x4.j(-2, str2, 4);
                    jVar2.f11229o = jVar.f11224a;
                    p2Var = new p2(jVar2, E, 4);
                    p2Var.f11331c = 1;
                }
                return new d(p2Var, z9);
            default:
                p6.a.e(obj);
                x4.j jVar3 = (x4.j) mVar.f1063m;
                int i6 = jVar3.f11224a;
                g2 t9 = vVar.t(i6, i6 == 523 ? 8 : 10, 0);
                if (t9.b() || t9.f11206d == null) {
                    z9 = false;
                } else {
                    ArrayList E2 = v.E(t9);
                    try {
                        str3 = ((Context) mVar.f1061b).getString(2131952657);
                        str3.getClass();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        str3 = "Top Downloads";
                    }
                    x4.j jVar4 = new x4.j(-1, str3, 4);
                    jVar4.f11229o = jVar3.f11224a;
                    p2Var = new p2(jVar4, E2, 4);
                    if (jVar3.f11224a == 523) {
                        float f = UptodownApp.I;
                        p2Var.f11331c = 4;
                    } else {
                        p2Var.f11331c = 5;
                    }
                }
                return new d(p2Var, z9);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(v vVar, m mVar, t6.c cVar) {
        super(2, cVar);
        this.f1054l = vVar;
        this.f1053b = mVar;
    }
}
