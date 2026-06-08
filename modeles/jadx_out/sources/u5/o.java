package u5;

import com.inmobi.cmp.core.model.Vector;
import d7.p;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends kotlin.jvm.internal.m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Vector f10760a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Vector f10761b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Vector vector, Vector vector2) {
        super(2);
        this.f10760a = vector;
        this.f10761b = vector2;
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        int intValue = ((Number) obj).intValue();
        ((Boolean) obj2).getClass();
        Vector vector = this.f10760a;
        if (vector != null && !vector.contains(intValue)) {
            this.f10761b.unset(intValue);
        }
        return x.f8463a;
    }
}
