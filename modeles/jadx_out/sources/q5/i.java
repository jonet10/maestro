package q5;

import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import j9.j;
import java.util.ArrayList;
import l8.n;
import p6.m;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final j8.a f8709a;

    /* renamed from: b, reason: collision with root package name */
    public final j f8710b;

    /* renamed from: c, reason: collision with root package name */
    public final ChoiceCmpCallback f8711c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8712d;

    public i(j8.a aVar, j jVar, ChoiceCmpCallback choiceCmpCallback) {
        jVar.getClass();
        this.f8709a = aVar;
        this.f8710b = jVar;
        this.f8711c = choiceCmpCallback;
        this.f8712d = 2;
    }

    public static void c() {
        n e10 = m9.c.e();
        String str = e10.h;
        if (str != null) {
            ((l9.a) m9.c.v.getValue()).f(86, str);
        }
        m mVar = m9.c.v;
        ((l9.a) mVar.getValue()).f(87, e10.f);
        ((l9.a) mVar.getValue()).g(88, l.g.f7044a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList a(int[] iArr) {
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        ?? r12 = this.f8709a.f6719d;
        if (r12 == 0) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : r12) {
                if (q6.j.T(iArr, ((j8.b) obj).f6720a.intValue())) {
                    arrayList3.add(obj);
                }
            }
            arrayList = arrayList3;
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                j8.b bVar = (j8.b) obj2;
                Integer num = bVar.f6720a;
                k6.a aVar = bVar.f6723d;
                int intValue = num.intValue();
                String str = aVar.f6978c;
                h8.d dVar = new h8.d(intValue, str == null ? "" : str);
                Boolean bool = bVar.f6722c;
                boolean z9 = bVar.g;
                arrayList2.add(new c.i(dVar, bool, z9 ? 4 : 1, 11, (!z9 || str == null) ? "" : str, null, 80));
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.List] */
    public final void b() {
        ?? r02 = this.f8709a.f6719d;
        if (r02 == 0) {
            return;
        }
        h hVar = new h(this, 2);
        s sVar = j8.e.g;
        if (sVar != 0) {
            sVar.h(r02, true, new b6.b(hVar));
        } else {
            a.a.h(null, ChoiceError.UNEXPECTED_ERROR_OCCURRED.getMessage(), null, 5);
            hVar.invoke(null);
        }
    }
}
