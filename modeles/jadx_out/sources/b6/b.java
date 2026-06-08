package b6;

import android.graphics.Bitmap;
import b.n;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import d7.l;
import kotlin.jvm.internal.m;
import o7.c0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends m implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1067a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1068b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(l lVar) {
        super(1);
        this.f1067a = 3;
        this.f1068b = (m) lVar;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [d7.l, kotlin.jvm.internal.m] */
    @Override // d7.l
    public final Object invoke(Object obj) {
        switch (this.f1067a) {
            case 0:
                c0.w(t6.i.f10314a, new n((Bitmap) obj, (f) this.f1068b, (t6.c) null, 4));
                break;
            case 1:
                ((q5.h) this.f1068b).invoke((USRegulationData) obj);
                break;
            case 2:
                ((q5.h) this.f1068b).invoke((USRegulationData) obj);
                break;
            default:
                ((m) this.f1068b).invoke((USRegulationData) obj);
                break;
        }
        return x.f8463a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj, int i) {
        super(1);
        this.f1067a = i;
        this.f1068b = obj;
    }
}
