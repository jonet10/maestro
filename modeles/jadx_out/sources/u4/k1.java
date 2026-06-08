package u4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k1 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f10517a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10518b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ m1 f10519l;

    /* renamed from: m, reason: collision with root package name */
    public int f10520m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(m1 m1Var, v6.c cVar) {
        super(cVar);
        this.f10519l = m1Var;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f10518b = obj;
        this.f10520m |= Integer.MIN_VALUE;
        return m1.a(this.f10519l, this);
    }
}
