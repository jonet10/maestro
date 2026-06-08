package l;

import d7.p;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.u;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class f extends m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7042a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f7043b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(u uVar, int i) {
        super(2);
        this.f7042a = i;
        this.f7043b = uVar;
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f7042a) {
            case 0:
                ((Number) obj).intValue();
                if (!((Boolean) obj2).booleanValue()) {
                    this.f7043b.f7021a = false;
                }
                break;
            default:
                ((Number) obj).intValue();
                if (((Boolean) obj2).booleanValue()) {
                    this.f7043b.f7021a = false;
                }
                break;
        }
        return x.f8463a;
    }
}
