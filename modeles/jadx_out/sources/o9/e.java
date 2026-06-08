package o9;

import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.ChoiceCmpCallback;
import f9.h;
import l8.n;
import l8.r;
import q6.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final l9.a f8380a;

    /* renamed from: b, reason: collision with root package name */
    public final ChoiceCmpCallback f8381b;

    /* renamed from: c, reason: collision with root package name */
    public final h9.b f8382c;

    /* renamed from: d, reason: collision with root package name */
    public final n f8383d;

    /* renamed from: e, reason: collision with root package name */
    public final h f8384e;
    public final k6.c f;

    public e(l9.a aVar, ChoiceCmpCallback choiceCmpCallback, h9.b bVar, n nVar, h hVar, k6.c cVar) {
        aVar.getClass();
        hVar.getClass();
        this.f8380a = aVar;
        this.f8381b = choiceCmpCallback;
        this.f8382c = bVar;
        this.f8383d = nVar;
        this.f8384e = hVar;
        this.f = cVar;
    }

    public final String a() {
        r rVar;
        n nVar = this.f8383d;
        return (nVar == null || (rVar = nVar.f7243r) == null) ? "" : rVar.f7260d;
    }

    public final String b() {
        h9.b bVar = this.f8382c;
        return !bVar.f5489b.isEmpty() ? (String) l.q0(bVar.f5489b) : "";
    }

    public final String c() {
        r rVar;
        n nVar = this.f8383d;
        return (nVar == null || (rVar = nVar.f7243r) == null) ? "" : rVar.f7259c;
    }

    public final String d() {
        r rVar;
        n nVar = this.f8383d;
        return (nVar == null || (rVar = nVar.f7243r) == null) ? "" : rVar.f7258b;
    }
}
