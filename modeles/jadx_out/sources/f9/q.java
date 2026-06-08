package f9;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static UUID f5065a = UUID.randomUUID();

    /* renamed from: b, reason: collision with root package name */
    public static final h f5066b = (h) m9.c.f7875y.getValue();

    static {
        new LinkedHashMap();
        new LinkedHashMap();
    }

    public static LiveData a(int i) {
        String H;
        Boolean bool;
        if (i == 0) {
            throw null;
        }
        int c9 = c.j.c(i);
        if (c9 == 4) {
            H = androidx.lifecycle.l.H(5);
            bool = null;
        } else if (c9 == 5) {
            bool = Boolean.TRUE;
            H = androidx.lifecycle.l.H(6);
        } else if (c9 != 6) {
            bool = Boolean.FALSE;
            H = androidx.lifecycle.l.H(4);
        } else {
            bool = Boolean.FALSE;
            H = androidx.lifecycle.l.H(7);
        }
        p6.m mVar = m9.c.v;
        String j = ((l9.a) mVar.getValue()).j(8);
        String j6 = ((l9.a) mVar.getValue()).j(63);
        f5066b.h(H, "click");
        return CoroutineLiveDataKt.liveData$default((t6.h) null, 0L, new b.m(j, j6, bool, (t6.c) null), 3, (Object) null);
    }

    public static LiveData b(int i, int i6) {
        int i10;
        if (i == 0) {
            throw null;
        }
        if (i6 == 0) {
            throw null;
        }
        int c9 = c.j.c(i);
        String H = c9 != 4 ? c9 != 5 ? c9 != 6 ? androidx.lifecycle.l.H(4) : androidx.lifecycle.l.H(7) : androidx.lifecycle.l.H(6) : androidx.lifecycle.l.H(5);
        int c10 = c.j.c(i6);
        if (c10 != 0) {
            i10 = 2;
            if (c10 != 2) {
                i10 = 3;
            }
        } else {
            i10 = 1;
        }
        f5066b.h(H, "click");
        return CoroutineLiveDataKt.liveData$default((t6.h) null, 0L, new o(((l9.a) m9.c.v.getValue()).j(69), i6, i10, null), 3, (Object) null);
    }

    public static Object c(d dVar, int i, v6.i iVar) {
        Object b7;
        String valueOf = String.valueOf(i);
        h hVar = f5066b;
        hVar.h("goToPage", valueOf);
        ArrayList arrayList = hVar.h;
        if (arrayList.size() < 2) {
            b7 = "";
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            l lVar = new l(arrayList2);
            arrayList.clear();
            b7 = hVar.b(2, lVar, dVar, iVar);
        }
        return b7 == u6.a.f10762a ? b7 : x.f8463a;
    }

    public static LiveData d(int i) {
        String str;
        t6.c cVar = null;
        if (i == 0) {
            throw null;
        }
        switch (i) {
            case 1:
                str = "goToPage";
                break;
            case 2:
                str = "purpose";
                break;
            case 3:
                str = "specialFeature";
                break;
            case 4:
                str = "partial";
                break;
            case 5:
                str = "saveAndExit";
                break;
            case 6:
                str = "acceptAll";
                break;
            case 7:
                str = "rejectAll";
                break;
            case 8:
                str = "acceptAllLegitimate";
                break;
            case 9:
                str = "objectAllLegitimate";
                break;
            case 10:
                str = "startOnPage";
                break;
            case 11:
                str = "expandElement";
                break;
            case 12:
                str = "collapseElement";
                break;
            case 13:
                str = "Action1";
                break;
            case 14:
                str = "Action2";
                break;
            case 15:
                str = "Confirm";
                break;
            default:
                throw null;
        }
        f5066b.h(str, "click");
        return CoroutineLiveDataKt.liveData$default((t6.h) null, 0L, new b.j(2, cVar, 1), 3, (Object) null);
    }
}
