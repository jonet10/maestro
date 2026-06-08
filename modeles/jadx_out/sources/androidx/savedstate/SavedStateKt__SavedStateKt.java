package androidx.savedstate;

import android.os.Bundle;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class SavedStateKt__SavedStateKt {
    public static final <T> T read(Bundle bundle, l lVar) {
        bundle.getClass();
        lVar.getClass();
        return (T) lVar.invoke(SavedStateReader.m96boximpl(SavedStateReader.m97constructorimpl(bundle)));
    }

    public static final <T> T write(Bundle bundle, l lVar) {
        bundle.getClass();
        lVar.getClass();
        return (T) lVar.invoke(SavedStateWriter.m181boximpl(SavedStateWriter.m183constructorimpl(bundle)));
    }
}
