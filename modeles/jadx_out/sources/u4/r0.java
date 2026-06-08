package u4;

import android.content.Context;
import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import e1.v4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10586a;

    /* renamed from: b, reason: collision with root package name */
    public int f10587b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ v0 f10588l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Context f10589m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f10590n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r0(int i, long j, Context context, t6.c cVar, v0 v0Var) {
        super(2, cVar);
        this.f10586a = i;
        this.f10588l = v0Var;
        this.f10589m = context;
        this.f10590n = j;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10586a) {
            case 0:
                return new r0(0, this.f10590n, this.f10589m, cVar, this.f10588l);
            case 1:
                return new r0(1, this.f10590n, this.f10589m, cVar, this.f10588l);
            case 2:
                return new r0(2, this.f10590n, this.f10589m, cVar, this.f10588l);
            default:
                return new r0(3, this.f10590n, this.f10589m, cVar, this.f10588l);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10586a) {
        }
        return ((r0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object a8;
        Object b7;
        Object a10;
        Object b10;
        switch (this.f10586a) {
            case 0:
                v0 v0Var = this.f10588l;
                r7.o0 o0Var = v0Var.W;
                int i = this.f10587b;
                Context context = this.f10589m;
                if (i == 0) {
                    p6.a.e(obj);
                    if (!((Boolean) o0Var.getValue()).booleanValue()) {
                        Boolean bool = Boolean.TRUE;
                        o0Var.getClass();
                        o0Var.g(null, bool);
                        v4 v4Var = new v4(context, 3, false);
                        this.f10587b = 1;
                        a8 = v4Var.a(this.f10590n, this);
                        u6.a aVar = u6.a.f10762a;
                        if (a8 == aVar) {
                            break;
                        }
                    }
                    break;
                } else if (i != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a8 = ((p6.k) obj).f8444a;
                }
                if (!(a8 instanceof p6.j)) {
                    ((Boolean) a8).getClass();
                    Bundle bundle = new Bundle();
                    bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "added");
                    new android.support.v4.media.g(context, 20).E(bundle, "recommended");
                    r7.o0 o0Var2 = v0Var.F;
                    Integer num = new Integer(1);
                    o0Var2.getClass();
                    o0Var2.g(null, num);
                    Boolean bool2 = Boolean.FALSE;
                    o0Var.getClass();
                    o0Var.g(null, bool2);
                }
                if (p6.k.a(a8) != null) {
                    r7.o0 o0Var3 = v0Var.F;
                    Integer num2 = new Integer(0);
                    o0Var3.getClass();
                    o0Var3.g(null, num2);
                    Boolean bool3 = Boolean.FALSE;
                    o0Var.getClass();
                    o0Var.g(null, bool3);
                }
            case 1:
                v0 v0Var2 = this.f10588l;
                r7.o0 o0Var4 = v0Var2.W;
                int i6 = this.f10587b;
                Context context2 = this.f10589m;
                if (i6 == 0) {
                    p6.a.e(obj);
                    if (!((Boolean) o0Var4.getValue()).booleanValue()) {
                        Boolean bool4 = Boolean.TRUE;
                        o0Var4.getClass();
                        o0Var4.g(null, bool4);
                        v4 v4Var2 = new v4(context2, 3, false);
                        this.f10587b = 1;
                        b7 = v4Var2.b(this.f10590n, this);
                        u6.a aVar2 = u6.a.f10762a;
                        if (b7 == aVar2) {
                            break;
                        }
                    }
                    break;
                } else if (i6 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    b7 = ((p6.k) obj).f8444a;
                }
                if (!(b7 instanceof p6.j)) {
                    ((Boolean) b7).getClass();
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "removed");
                    new android.support.v4.media.g(context2, 20).E(bundle2, "recommended");
                    r7.o0 o0Var5 = v0Var2.F;
                    Integer num3 = new Integer(0);
                    o0Var5.getClass();
                    o0Var5.g(null, num3);
                    Boolean bool5 = Boolean.FALSE;
                    o0Var4.getClass();
                    o0Var4.g(null, bool5);
                }
                if (p6.k.a(b7) != null) {
                    r7.o0 o0Var6 = v0Var2.F;
                    Integer num4 = new Integer(1);
                    o0Var6.getClass();
                    o0Var6.g(null, num4);
                    Boolean bool6 = Boolean.FALSE;
                    o0Var4.getClass();
                    o0Var4.g(null, bool6);
                }
            case 2:
                v0 v0Var3 = this.f10588l;
                r7.o0 o0Var7 = v0Var3.V;
                int i10 = this.f10587b;
                Context context3 = this.f10589m;
                if (i10 == 0) {
                    p6.a.e(obj);
                    if (!((Boolean) o0Var7.getValue()).booleanValue()) {
                        Boolean bool7 = Boolean.TRUE;
                        o0Var7.getClass();
                        o0Var7.g(null, bool7);
                        v4 v4Var3 = new v4(context3, 4, false);
                        this.f10587b = 1;
                        a10 = v4Var3.a(this.f10590n, this);
                        u6.a aVar3 = u6.a.f10762a;
                        if (a10 == aVar3) {
                            break;
                        }
                    }
                    break;
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    a10 = ((p6.k) obj).f8444a;
                }
                if (!(a10 instanceof p6.j)) {
                    ((Boolean) a10).getClass();
                    Bundle bundle3 = new Bundle();
                    bundle3.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "added");
                    new android.support.v4.media.g(context3, 20).E(bundle3, "wishlist");
                    r7.o0 o0Var8 = v0Var3.E;
                    Integer num5 = new Integer(1);
                    o0Var8.getClass();
                    o0Var8.g(null, num5);
                    Boolean bool8 = Boolean.FALSE;
                    o0Var7.getClass();
                    o0Var7.g(null, bool8);
                }
                if (p6.k.a(a10) != null) {
                    r7.o0 o0Var9 = v0Var3.E;
                    Integer num6 = new Integer(0);
                    o0Var9.getClass();
                    o0Var9.g(null, num6);
                    Boolean bool9 = Boolean.FALSE;
                    o0Var7.getClass();
                    o0Var7.g(null, bool9);
                }
            default:
                v0 v0Var4 = this.f10588l;
                r7.o0 o0Var10 = v0Var4.V;
                int i11 = this.f10587b;
                Context context4 = this.f10589m;
                if (i11 == 0) {
                    p6.a.e(obj);
                    if (!((Boolean) o0Var10.getValue()).booleanValue()) {
                        Boolean bool10 = Boolean.TRUE;
                        o0Var10.getClass();
                        o0Var10.g(null, bool10);
                        v4 v4Var4 = new v4(context4, 4, false);
                        this.f10587b = 1;
                        b10 = v4Var4.b(this.f10590n, this);
                        u6.a aVar4 = u6.a.f10762a;
                        if (b10 == aVar4) {
                            break;
                        }
                    }
                    break;
                } else if (i11 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    b10 = ((p6.k) obj).f8444a;
                }
                if (!(b10 instanceof p6.j)) {
                    ((Boolean) b10).getClass();
                    Bundle bundle4 = new Bundle();
                    bundle4.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "removed");
                    new android.support.v4.media.g(context4, 20).E(bundle4, "wishlist");
                    r7.o0 o0Var11 = v0Var4.E;
                    Integer num7 = new Integer(0);
                    o0Var11.getClass();
                    o0Var11.g(null, num7);
                    Boolean bool11 = Boolean.FALSE;
                    o0Var10.getClass();
                    o0Var10.g(null, bool11);
                }
                if (p6.k.a(b10) != null) {
                    r7.o0 o0Var12 = v0Var4.E;
                    Integer num8 = new Integer(1);
                    o0Var12.getClass();
                    o0Var12.g(null, num8);
                    Boolean bool12 = Boolean.FALSE;
                    o0Var10.getClass();
                    o0Var10.g(null, bool12);
                }
        }
        return p6.x.f8463a;
    }
}
