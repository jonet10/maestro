package i2;

import androidx.datastore.preferences.core.Preferences;
import d7.p;
import java.util.Map;
import o7.a0;
import p6.x;
import q6.u;
import r7.h;
import r7.k0;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f5636a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f5637b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, t6.c cVar) {
        super(2, cVar);
        this.f5637b = fVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new b(this.f5637b, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((b) create((a0) obj, (t6.c) obj2)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Map<Preferences.Key<?>, Object> asMap;
        int i = this.f5636a;
        if (i == 0) {
            p6.a.e(obj);
            h data = this.f5637b.f5651c.getData();
            this.f5636a = 1;
            obj = k0.k(data, this);
            u6.a aVar = u6.a.f10762a;
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        Preferences preferences = (Preferences) obj;
        return (preferences == null || (asMap = preferences.asMap()) == null) ? u.f8725a : asMap;
    }
}
