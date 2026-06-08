package i2;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import d7.p;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f5644a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f5645b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Preferences.Key f5646l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Long f5647m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, Preferences.Key key, Long l10, t6.c cVar) {
        super(2, cVar);
        this.f5645b = fVar;
        this.f5646l = key;
        this.f5647m = l10;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new e(this.f5645b, this.f5646l, this.f5647m, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((e) create((a0) obj, (t6.c) obj2)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f5644a;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return obj;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        DataStore dataStore = this.f5645b.f5651c;
        d dVar = new d(this.f5646l, this.f5647m, null);
        this.f5644a = 1;
        Object edit = PreferencesKt.edit(dataStore, dVar, this);
        u6.a aVar = u6.a.f10762a;
        return edit == aVar ? aVar : edit;
    }
}
