package l1;

import j$.util.Objects;
import java.util.AbstractMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends d {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k f7067l;

    public j(k kVar) {
        this.f7067l = kVar;
    }

    @Override // java.util.List
    public final Object get(int i) {
        k kVar = this.f7067l;
        a.a.n(i, kVar.f7070o);
        Object[] objArr = kVar.f7069n;
        int i6 = i * 2;
        Object obj = objArr[i6];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i6 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7067l.f7070o;
    }
}
