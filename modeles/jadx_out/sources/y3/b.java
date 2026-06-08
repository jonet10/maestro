package y3;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11793a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f11794b;

    public /* synthetic */ b(d dVar, int i) {
        this.f11793a = i;
        this.f11794b = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11793a) {
            case 0:
                ArrayList arrayList = this.f11794b.f11798b;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((z3.b) obj).a();
                }
                break;
            default:
                ArrayList arrayList2 = this.f11794b.f11798b;
                int size2 = arrayList2.size();
                int i6 = 0;
                while (i6 < size2) {
                    Object obj2 = arrayList2.get(i6);
                    i6++;
                    ((z3.b) obj2).getClass();
                }
                break;
        }
    }
}
