package i2;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import d7.p;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f5641a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Preferences.Key f5642b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Long f5643l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Preferences.Key key, Long l10, t6.c cVar) {
        super(2, cVar);
        this.f5642b = key;
        this.f5643l = l10;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        d dVar = new d(this.f5642b, this.f5643l, cVar);
        dVar.f5641a = obj;
        return dVar;
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        d dVar = (d) create((MutablePreferences) obj, (t6.c) obj2);
        x xVar = x.f8463a;
        dVar.invokeSuspend(xVar);
        return xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        p6.a.e(obj);
        ((MutablePreferences) this.f5641a).set(this.f5642b, this.f5643l);
        return x.f8463a;
    }
}
