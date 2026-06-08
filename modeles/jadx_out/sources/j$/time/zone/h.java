package j$.time.zone;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class h implements PrivilegedAction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f5955a;

    public h(List list) {
        this.f5955a = list;
    }

    @Override // java.security.PrivilegedAction
    public final Object run() {
        String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
        if (property != null) {
            try {
                i iVar = (i) i.class.cast(Class.forName(property, true, i.class.getClassLoader()).newInstance());
                i.b(iVar);
                ((ArrayList) this.f5955a).add(iVar);
                return null;
            } catch (Exception e10) {
                throw new Error(e10);
            }
        }
        i.b(new i());
        return null;
    }
}
