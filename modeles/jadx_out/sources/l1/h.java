package l1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends q {

    /* renamed from: b, reason: collision with root package name */
    public boolean f7062b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f7063l;

    public h(Object obj) {
        super(0);
        this.f7063l = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f7062b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f7062b) {
            com.google.gson.internal.a.l();
            return null;
        }
        this.f7062b = true;
        return this.f7063l;
    }
}
