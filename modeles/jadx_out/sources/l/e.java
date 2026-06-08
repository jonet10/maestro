package l;

import com.inmobi.cmp.core.model.Vector;
import d7.p;
import kotlin.jvm.internal.m;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class e extends m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7040a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Vector f7041b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i, Vector vector) {
        super(2);
        this.f7040a = i;
        this.f7041b = vector;
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f7040a) {
            case 0:
                int intValue = ((Number) obj).intValue();
                boolean booleanValue = ((Boolean) obj2).booleanValue();
                Vector vector = this.f7041b;
                if (!vector.contains(intValue)) {
                    if (booleanValue) {
                        vector.set(intValue);
                    } else {
                        vector.unset(intValue);
                    }
                }
                break;
            case 1:
                int intValue2 = ((Number) obj).intValue();
                boolean booleanValue2 = ((Boolean) obj2).booleanValue();
                Vector vector2 = this.f7041b;
                if (booleanValue2) {
                    vector2.set(intValue2);
                } else {
                    vector2.unset(intValue2);
                }
                break;
            default:
                int intValue3 = ((Number) obj).intValue();
                boolean booleanValue3 = ((Boolean) obj2).booleanValue();
                Vector vector3 = this.f7041b;
                if (vector3.getMap().containsKey(Integer.valueOf(intValue3))) {
                    if (booleanValue3) {
                        vector3.set(intValue3);
                    } else {
                        vector3.unset(intValue3);
                    }
                }
                break;
        }
        return x.f8463a;
    }
}
