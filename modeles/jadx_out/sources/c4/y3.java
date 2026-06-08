package c4;

import com.uptodown.activities.MoreInfo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y3 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.x f2337a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f2338b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f2339l;

    /* renamed from: m, reason: collision with root package name */
    public int f2340m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y3(MoreInfo moreInfo, v6.c cVar) {
        super(cVar);
        this.f2339l = moreInfo;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f2338b = obj;
        this.f2340m |= Integer.MIN_VALUE;
        return MoreInfo.y0(this.f2339l, this);
    }
}
