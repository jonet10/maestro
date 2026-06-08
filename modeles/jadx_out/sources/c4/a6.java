package c4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.uptodown.UptodownApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a6 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1378a;

    /* renamed from: b, reason: collision with root package name */
    public int f1379b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Context f1380l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a6(Context context, int i, t6.c cVar) {
        super(2, cVar);
        this.f1378a = 0;
        this.f1380l = context;
        this.f1379b = i;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1378a) {
            case 0:
                return new a6(this.f1380l, this.f1379b, cVar);
            case 1:
                return new a6(this.f1380l, cVar, 1);
            case 2:
                return new a6(this.f1380l, cVar, 2);
            default:
                return new a6(this.f1380l, cVar, 3);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1378a) {
            case 0:
                a6 a6Var = (a6) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                a6Var.invokeSuspend(xVar);
                return xVar;
            case 1:
                return ((a6) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            case 2:
                return ((a6) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            default:
                ((a6) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                return u6.a.f10762a;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1378a;
        p6.x xVar = p6.x.f8463a;
        u6.a aVar = u6.a.f10762a;
        Context context = this.f1380l;
        switch (i) {
            case 0:
                p6.a.e(obj);
                j5.g l10 = j5.g.D.l(context);
                l10.b();
                String[] strArr = {String.valueOf(this.f1379b)};
                SQLiteDatabase sQLiteDatabase = l10.f6673a;
                sQLiteDatabase.getClass();
                sQLiteDatabase.delete("notifications", "id=?", strArr);
                l10.c();
                return xVar;
            case 1:
                int i6 = this.f1379b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        p6.a.e(obj);
                        return xVar;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                ArrayList i10 = j5.a.i(context);
                j5.a aVar2 = new j5.a();
                this.f1379b = 1;
                v7.e eVar = o7.m0.f8288a;
                Object C = o7.c0.C(new b5.j(context, i10, aVar2, (t6.c) null), v7.d.f10884a, this);
                if (C != aVar) {
                    C = xVar;
                }
                return C == aVar ? aVar : xVar;
            case 2:
                int i11 = this.f1379b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        p6.a.e(obj);
                        return xVar;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                float f = UptodownApp.I;
                this.f1379b = 1;
                v7.e eVar2 = o7.m0.f8288a;
                Object C2 = o7.c0.C(new b4.b(context, null), v7.d.f10884a, this);
                if (C2 != aVar) {
                    C2 = xVar;
                }
                return C2 == aVar ? aVar : xVar;
            default:
                int i12 = this.f1379b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                r7.d0 d0Var = f4.a.f4873e;
                c3.y0 y0Var = new c3.y0(context, 21);
                this.f1379b = 1;
                d0Var.f8968a.collect(y0Var, this);
                return aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a6(Context context, t6.c cVar, int i) {
        super(2, cVar);
        this.f1378a = i;
        this.f1380l = context;
    }
}
