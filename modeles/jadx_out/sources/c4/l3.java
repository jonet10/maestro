package c4;

import com.uptodown.activities.MainActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l3 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f1819a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1820b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1821l;

    /* renamed from: m, reason: collision with root package name */
    public int f1822m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l3(MainActivity mainActivity, v6.c cVar) {
        super(cVar);
        this.f1821l = mainActivity;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f1820b = obj;
        this.f1822m |= Integer.MIN_VALUE;
        return MainActivity.J0(this.f1821l, this);
    }
}
