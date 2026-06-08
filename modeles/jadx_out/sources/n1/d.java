package n1;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements j0.b {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReference f7903a = new AtomicReference();

    @Override // j0.b
    public final void a(boolean z9) {
        synchronized (f.f7906k) {
            try {
                ArrayList arrayList = new ArrayList(f.f7907l.values());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    f fVar = (f) obj;
                    if (fVar.f7912e.get()) {
                        Log.d("FirebaseApp", "Notifying background state change listeners.");
                        Iterator it = fVar.i.iterator();
                        while (it.hasNext()) {
                            f fVar2 = ((c) it.next()).f7902a;
                            if (!z9) {
                                ((q2.d) fVar2.h.get()).c();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
