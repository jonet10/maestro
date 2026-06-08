package k7;

import d7.p;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6991a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6992b;

    /* renamed from: c, reason: collision with root package name */
    public final p6.c f6993c;

    public d(f fVar, d7.l lVar) {
        lVar.getClass();
        this.f6992b = fVar;
        this.f6993c = lVar;
    }

    @Override // k7.f
    public final Iterator iterator() {
        switch (this.f6991a) {
            case 0:
                return new c(this);
            case 1:
                return new e(this);
            case 2:
                return new l(this);
            default:
                return new l7.b(this);
        }
    }

    public d(d dVar, androidx.room.f fVar) {
        this.f6992b = dVar;
        this.f6993c = fVar;
    }

    public d(d7.a aVar, d7.l lVar) {
        lVar.getClass();
        this.f6992b = aVar;
        this.f6993c = lVar;
    }

    public d(CharSequence charSequence, p pVar) {
        charSequence.getClass();
        this.f6992b = charSequence;
        this.f6993c = pVar;
    }
}
