package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.jvm.internal.u;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class j implements d7.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f455a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f456b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f457l;

    public /* synthetic */ j(MediatorLiveData mediatorLiveData, Object obj, int i) {
        this.f455a = i;
        this.f456b = mediatorLiveData;
        this.f457l = obj;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        x map$lambda$0;
        x distinctUntilChanged$lambda$0;
        x map$lambda$1;
        switch (this.f455a) {
            case 0:
                map$lambda$0 = Transformations.map$lambda$0(this.f456b, (d7.l) this.f457l, obj);
                return map$lambda$0;
            case 1:
                distinctUntilChanged$lambda$0 = Transformations.distinctUntilChanged$lambda$0(this.f456b, (u) this.f457l, obj);
                return distinctUntilChanged$lambda$0;
            default:
                map$lambda$1 = Transformations.map$lambda$1(this.f456b, (Function) this.f457l, obj);
                return map$lambda$1;
        }
    }
}
