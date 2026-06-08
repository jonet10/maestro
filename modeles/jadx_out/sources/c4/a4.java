package c4;

import com.uptodown.activities.MoreInfo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a4 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public kotlin.jvm.internal.v f1372a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1373b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f1374l;

    /* renamed from: m, reason: collision with root package name */
    public int f1375m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a4(MoreInfo moreInfo, v6.c cVar) {
        super(cVar);
        this.f1374l = moreInfo;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f1373b = obj;
        this.f1375m |= Integer.MIN_VALUE;
        return MoreInfo.z0(this.f1374l, this);
    }
}
