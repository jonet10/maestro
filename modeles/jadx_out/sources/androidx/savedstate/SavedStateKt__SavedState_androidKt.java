package androidx.savedstate;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import d7.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import p6.i;
import p6.x;
import q6.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class SavedStateKt__SavedState_androidKt {
    public static final Bundle savedState(Map<String, ? extends Object> map, l lVar) {
        i[] iVarArr;
        map.getClass();
        lVar.getClass();
        if (map.isEmpty()) {
            iVarArr = new i[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                arrayList.add(new i(entry.getKey(), entry.getValue()));
            }
            iVarArr = (i[]) arrayList.toArray(new i[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        lVar.invoke(SavedStateWriter.m181boximpl(SavedStateWriter.m183constructorimpl(bundleOf)));
        return bundleOf;
    }

    public static Bundle savedState$default(Map map, l lVar, int i, Object obj) {
        i[] iVarArr;
        if ((i & 1) != 0) {
            map = u.f8725a;
        }
        if ((i & 2) != 0) {
            lVar = new l() { // from class: androidx.savedstate.SavedStateKt__SavedState_androidKt$savedState$1
                @Override // d7.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m94invokexApjlu4(((SavedStateWriter) obj2).m221unboximpl());
                    return x.f8463a;
                }

                /* renamed from: invoke-xApjlu4, reason: not valid java name */
                public final void m94invokexApjlu4(Bundle bundle) {
                    bundle.getClass();
                }
            };
        }
        map.getClass();
        lVar.getClass();
        if (map.isEmpty()) {
            iVarArr = new i[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new i((String) entry.getKey(), entry.getValue()));
            }
            iVarArr = (i[]) arrayList.toArray(new i[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        lVar.invoke(SavedStateWriter.m181boximpl(SavedStateWriter.m183constructorimpl(bundleOf)));
        return bundleOf;
    }

    public static final Bundle savedState(Bundle bundle, l lVar) {
        bundle.getClass();
        lVar.getClass();
        Bundle bundle2 = new Bundle(bundle);
        lVar.invoke(SavedStateWriter.m181boximpl(SavedStateWriter.m183constructorimpl(bundle2)));
        return bundle2;
    }

    public static /* synthetic */ Bundle savedState$default(Bundle bundle, l lVar, int i, Object obj) {
        if ((i & 2) != 0) {
            lVar = new l() { // from class: androidx.savedstate.SavedStateKt__SavedState_androidKt$savedState$3
                @Override // d7.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    m95invokexApjlu4(((SavedStateWriter) obj2).m221unboximpl());
                    return x.f8463a;
                }

                /* renamed from: invoke-xApjlu4, reason: not valid java name */
                public final void m95invokexApjlu4(Bundle bundle2) {
                    bundle2.getClass();
                }
            };
        }
        bundle.getClass();
        lVar.getClass();
        Bundle bundle2 = new Bundle(bundle);
        lVar.invoke(SavedStateWriter.m181boximpl(SavedStateWriter.m183constructorimpl(bundle2)));
        return bundle2;
    }
}
