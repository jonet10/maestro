package e0;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class d implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ d f3736b = new d(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3737a;

    public /* synthetic */ d(int i) {
        this.f3737a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f3737a) {
        }
        return ((Scope) obj).f2468b.compareTo(((Scope) obj2).f2468b);
    }
}
