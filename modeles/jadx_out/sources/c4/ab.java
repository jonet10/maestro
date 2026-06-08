package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ab {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1390a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1391b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1392c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1393d;

    /* renamed from: e, reason: collision with root package name */
    public final za f1394e;

    public ab(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, za zaVar) {
        arrayList.getClass();
        arrayList2.getClass();
        arrayList3.getClass();
        arrayList4.getClass();
        this.f1390a = arrayList;
        this.f1391b = arrayList2;
        this.f1392c = arrayList3;
        this.f1393d = arrayList4;
        this.f1394e = zaVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        return kotlin.jvm.internal.l.a(this.f1390a, abVar.f1390a) && kotlin.jvm.internal.l.a(this.f1391b, abVar.f1391b) && kotlin.jvm.internal.l.a(this.f1392c, abVar.f1392c) && kotlin.jvm.internal.l.a(this.f1393d, abVar.f1393d) && this.f1394e.equals(abVar.f1394e);
    }

    public final int hashCode() {
        return this.f1394e.hashCode() + ((this.f1393d.hashCode() + ((this.f1392c.hashCode() + ((this.f1391b.hashCode() + (this.f1390a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "UpdatesData(updates=" + this.f1390a + ", disabled=" + this.f1391b + ", ignored=" + this.f1392c + ", recentlyUpdated=" + this.f1393d + ", downloadAllButtonData=" + this.f1394e + ")";
    }
}
