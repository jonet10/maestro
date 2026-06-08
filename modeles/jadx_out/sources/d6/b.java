package d6;

import b9.q;
import b9.v;
import java.util.ArrayList;
import java.util.Iterator;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements c6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f3601a;

    public b(c cVar) {
        this.f3601a = cVar;
    }

    @Override // c6.a
    public final void a(s sVar, q qVar) {
        String str = ((v) qVar).f;
        ((c6.e) sVar.f11757m).f2423a.append(str);
        ArrayList arrayList = this.f3601a.f3602a;
        if (arrayList.isEmpty()) {
            return;
        }
        sVar.z();
        str.getClass();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            com.google.gson.internal.a.o();
        }
    }
}
