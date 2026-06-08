package a7;

import com.google.android.gms.internal.measurement.i5;
import d7.p;
import java.util.Iterator;
import k7.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f211a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f212b;

    public /* synthetic */ e(Object obj, int i) {
        this.f211a = i;
        this.f212b = obj;
    }

    @Override // k7.f
    public final Iterator iterator() {
        switch (this.f211a) {
            case 0:
                return new d(this);
            case 1:
                return i5.z((p) this.f212b);
            default:
                return (Iterator) this.f212b;
        }
    }
}
