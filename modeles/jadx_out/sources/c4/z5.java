package c4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z5 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2393a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f2394b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ b6 f2395l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z5(Context context, b6 b6Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f2393a = i;
        this.f2394b = context;
        this.f2395l = b6Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2393a) {
            case 0:
                return new z5(this.f2394b, this.f2395l, cVar, 0);
            default:
                return new z5(this.f2394b, this.f2395l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2393a) {
            case 0:
                z5 z5Var = (z5) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                z5Var.invokeSuspend(xVar);
                return xVar;
            default:
                z5 z5Var2 = (z5) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                z5Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Cursor cursor;
        int i = this.f2393a;
        p6.x xVar = p6.x.f8463a;
        b6 b6Var = this.f2395l;
        t6.c cVar = null;
        Context context = this.f2394b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                j5.g l10 = j5.g.D.l(context);
                l10.b();
                SQLiteDatabase sQLiteDatabase = l10.f6673a;
                sQLiteDatabase.getClass();
                sQLiteDatabase.delete("notifications", null, null);
                l10.c();
                o7.a0 viewModelScope = ViewModelKt.getViewModelScope(b6Var);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(viewModelScope, v7.d.f10884a, null, new z5(context, b6Var, cVar, 1), 2);
                break;
            default:
                p6.a.e(obj);
                j5.g l11 = j5.g.D.l(context);
                l11.b();
                ArrayList arrayList = new ArrayList();
                try {
                    SQLiteDatabase sQLiteDatabase2 = l11.f6673a;
                    sQLiteDatabase2.getClass();
                    cursor = sQLiteDatabase2.query("notifications", l11.f6682s, null, null, null, null, "id DESC");
                } catch (Exception e10) {
                    e = e10;
                    cursor = null;
                }
                try {
                    if (cursor.moveToFirst()) {
                        x4.s1 s1Var = new x4.s1();
                        s1Var.a(cursor);
                        arrayList.add(s1Var);
                    }
                    while (cursor.moveToNext()) {
                        x4.s1 s1Var2 = new x4.s1();
                        s1Var2.a(cursor);
                        arrayList.add(s1Var2);
                    }
                    cursor.close();
                } catch (Exception e11) {
                    e = e11;
                    e.printStackTrace();
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                    l11.c();
                    r7.o0 o0Var = b6Var.f1420a;
                    j5.r rVar = new j5.r(new y5(arrayList));
                    o0Var.getClass();
                    o0Var.g(null, rVar);
                    return xVar;
                }
                l11.c();
                r7.o0 o0Var2 = b6Var.f1420a;
                j5.r rVar2 = new j5.r(new y5(arrayList));
                o0Var2.getClass();
                o0Var2.g(null, rVar2);
                break;
        }
        return xVar;
    }
}
