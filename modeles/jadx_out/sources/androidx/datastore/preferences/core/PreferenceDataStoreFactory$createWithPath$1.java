package androidx.datastore.preferences.core;

import d7.a;
import java.io.File;
import kotlin.jvm.internal.m;
import w8.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferenceDataStoreFactory$createWithPath$1 extends m implements a {
    final /* synthetic */ a $produceFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreFactory$createWithPath$1(a aVar) {
        super(0);
        this.$produceFile = aVar;
    }

    @Override // d7.a
    public final File invoke() {
        return ((y) this.$produceFile.invoke()).toFile();
    }
}
