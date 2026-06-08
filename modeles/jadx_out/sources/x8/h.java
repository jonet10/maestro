package x8;

import d7.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.w;
import p6.x;
import w8.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f11564a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f11565b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ w f11566l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ a0 f11567m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ w f11568n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ w f11569o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(u uVar, long j, w wVar, a0 a0Var, w wVar2, w wVar3) {
        super(2);
        this.f11564a = uVar;
        this.f11565b = j;
        this.f11566l = wVar;
        this.f11567m = a0Var;
        this.f11568n = wVar2;
        this.f11569o = wVar3;
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        long longValue = ((Number) obj2).longValue();
        if (intValue == 1) {
            u uVar = this.f11564a;
            if (uVar.f7021a) {
                com.google.gson.internal.a.n("bad zip: zip64 extra repeated");
                return null;
            }
            uVar.f7021a = true;
            if (longValue < this.f11565b) {
                com.google.gson.internal.a.n("bad zip: zip64 extra too short");
                return null;
            }
            w wVar = this.f11566l;
            long j = wVar.f7023a;
            a0 a0Var = this.f11567m;
            if (j == 4294967295L) {
                j = a0Var.h();
            }
            wVar.f7023a = j;
            w wVar2 = this.f11568n;
            wVar2.f7023a = wVar2.f7023a == 4294967295L ? a0Var.h() : 0L;
            w wVar3 = this.f11569o;
            wVar3.f7023a = wVar3.f7023a == 4294967295L ? a0Var.h() : 0L;
        }
        return x.f8463a;
    }
}
