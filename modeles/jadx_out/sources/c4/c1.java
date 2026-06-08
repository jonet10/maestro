package c4;

import android.content.Context;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1452a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1453b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f1454l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1455m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(String str, String str2, long j, t6.c cVar) {
        super(2, cVar);
        this.f1452a = 4;
        this.f1453b = str;
        this.f1455m = str2;
        this.f1454l = j;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1452a) {
            case 0:
                return new c1((FreeUpSpaceActivity) this.f1455m, this.f1453b, this.f1454l, cVar, 0);
            case 1:
                return new c1((MyApps) this.f1455m, this.f1453b, this.f1454l, cVar, 1);
            case 2:
                return new c1((Updates) this.f1455m, this.f1453b, this.f1454l, cVar, 2);
            case 3:
                return new c1((Context) this.f1455m, this.f1453b, this.f1454l, cVar, 3);
            default:
                return new c1(this.f1453b, (String) this.f1455m, this.f1454l, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1452a) {
            case 0:
                c1 c1Var = (c1) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                c1Var.invokeSuspend(xVar);
                return xVar;
            case 1:
                c1 c1Var2 = (c1) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                c1Var2.invokeSuspend(xVar2);
                return xVar2;
            case 2:
                c1 c1Var3 = (c1) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                c1Var3.invokeSuspend(xVar3);
                return xVar3;
            case 3:
                c1 c1Var4 = (c1) create(a0Var, cVar);
                p6.x xVar4 = p6.x.f8463a;
                c1Var4.invokeSuspend(xVar4);
                return xVar4;
            default:
                c1 c1Var5 = (c1) create(a0Var, cVar);
                p6.x xVar5 = p6.x.f8463a;
                c1Var5.invokeSuspend(xVar5);
                return xVar5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0128  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.c1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c1(Context context, String str, long j, t6.c cVar, int i) {
        super(2, cVar);
        this.f1452a = i;
        this.f1455m = context;
        this.f1453b = str;
        this.f1454l = j;
    }
}
