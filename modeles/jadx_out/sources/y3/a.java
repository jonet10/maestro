package y3;

import java.util.ArrayList;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11791a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f11792b;

    public /* synthetic */ a(d dVar, int i) {
        this.f11791a = i;
        this.f11792b = dVar;
    }

    @Override // d7.a
    public final Object invoke() {
        switch (this.f11791a) {
            case 0:
                ArrayList arrayList = this.f11792b.f11798b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((z3.b) obj).a();
                }
                break;
            default:
                ArrayList arrayList2 = this.f11792b.f11798b;
                int size2 = arrayList2.size();
                int i6 = 0;
                while (i6 < size2) {
                    Object obj2 = arrayList2.get(i6);
                    i6++;
                    ((z3.b) obj2).getClass();
                }
                break;
        }
        return x.f8463a;
    }
}
