package l;

import androidx.lifecycle.ViewModel;
import c.i;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.l;
import l8.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class c extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final l9.a f7029a;

    /* renamed from: b, reason: collision with root package name */
    public final ChoiceCmpCallback f7030b;

    /* renamed from: c, reason: collision with root package name */
    public final k6.c f7031c;

    /* renamed from: d, reason: collision with root package name */
    public final n f7032d;

    public c(l9.a aVar, ChoiceCmpCallback choiceCmpCallback, k6.c cVar, n nVar) {
        aVar.getClass();
        this.f7029a = aVar;
        this.f7030b = choiceCmpCallback;
        this.f7031c = cVar;
        this.f7032d = nVar;
    }

    public static GBCConsentValue a(String str, List list) {
        Object obj;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((i) obj).f1160a.f5465a == g.d(str)) {
                break;
            }
        }
        i iVar = (i) obj;
        return iVar == null ? GBCConsentValue.DENIED : l.a(iVar.f1161b, Boolean.TRUE) ? GBCConsentValue.GRANTED : GBCConsentValue.DENIED;
    }
}
