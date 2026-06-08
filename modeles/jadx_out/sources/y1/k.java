package y1;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f11632a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f11633b;

    public k(l lVar, long j) {
        this.f11633b = lVar;
        this.f11632a = j;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", 1);
        bundle.putLong("timestamp", this.f11632a);
        this.f11633b.f11641k.i(bundle);
        return null;
    }
}
