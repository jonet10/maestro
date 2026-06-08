package l7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends q6.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f7171a;

    public h(i iVar) {
        this.f7171a = iVar;
    }

    @Override // q6.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return super.contains((String) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i) {
        String group = this.f7171a.f7172a.group(i);
        return group == null ? "" : group;
    }

    @Override // q6.a
    public final int getSize() {
        return this.f7171a.f7172a.groupCount() + 1;
    }

    @Override // q6.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof String) {
            return super.indexOf((String) obj);
        }
        return -1;
    }

    @Override // q6.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof String) {
            return super.lastIndexOf((String) obj);
        }
        return -1;
    }
}
