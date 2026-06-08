package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.room.TriggerBasedInvalidationTracker;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import c4.k0;
import com.uptodown.activities.MyDownloads;
import d8.n0;
import e8.o;
import e8.r;
import e8.v;
import e8.y;
import java.lang.reflect.Method;
import java.util.Calendar;
import l7.m;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class k implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f458a;

    public /* synthetic */ k(n0 n0Var) {
        this.f458a = 12;
    }

    @Override // d7.a
    public final Object invoke() {
        CreationExtras.Empty empty;
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        boolean onAllowRefresh$lambda$0;
        x xVar5;
        Method threadSessionMethod_delegate$lambda$7;
        Method beginTransactionMethod_delegate$lambda$8;
        int i = this.f458a;
        x xVar6 = x.f8463a;
        switch (i) {
            case 0:
                empty = CreationExtras.Empty.INSTANCE;
                return empty;
            case 1:
                xVar = x.f8463a;
                return xVar;
            case 2:
                xVar2 = x.f8463a;
                return xVar2;
            case 3:
                xVar3 = x.f8463a;
                return xVar3;
            case 4:
                xVar4 = x.f8463a;
                return xVar4;
            case 5:
                onAllowRefresh$lambda$0 = TriggerBasedInvalidationTracker.onAllowRefresh$lambda$0();
                return Boolean.valueOf(onAllowRefresh$lambda$0);
            case 6:
                xVar5 = x.f8463a;
                return xVar5;
            case 7:
                threadSessionMethod_delegate$lambda$7 = FrameworkSQLiteDatabase.getThreadSessionMethod_delegate$lambda$7();
                return threadSessionMethod_delegate$lambda$7;
            case 8:
                beginTransactionMethod_delegate$lambda$8 = FrameworkSQLiteDatabase.beginTransactionMethod_delegate$lambda$8();
                return beginTransactionMethod_delegate$lambda$8;
            case 9:
                int i6 = k0.N;
                return xVar6;
            case 10:
                int i10 = MyDownloads.V;
                a5.b.h();
                return xVar6;
            case 11:
                return Calendar.getInstance();
            case 12:
                b8.i iVar = b8.i.f1118k;
                b8.e[] eVarArr = new b8.e[0];
                if (m.z0("kotlin.Unit")) {
                    com.google.gson.internal.a.p("Blank serial names are prohibited");
                    return null;
                }
                if (iVar.equals(b8.i.h)) {
                    com.google.gson.internal.a.p("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
                    return null;
                }
                b8.a aVar = new b8.a("kotlin.Unit");
                return new b8.f("kotlin.Unit", iVar, aVar.f1099b.size(), q6.j.m0(eVarArr), aVar);
            case 13:
                return y.f4791b;
            case 14:
                return r.f4783b;
            case 15:
                return o.f4781b;
            case 16:
                return v.f4789b;
            case 17:
                return e8.f.f4769b;
            case 19:
                if (a5.b.d()) {
                    a5.b.h();
                }
            case 18:
                return xVar6;
            case 20:
                if (a5.b.d()) {
                    a5.b.h();
                }
                return xVar6;
            default:
                int i11 = z3.c.f11931q;
                return xVar6;
        }
    }

    public /* synthetic */ k(int i) {
        this.f458a = i;
    }
}
