package androidx.datastore.preferences.core;

import d7.a;
import java.io.File;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferenceDataStoreFactory$create$delegate$1 extends m implements a {
    final /* synthetic */ a $produceFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreFactory$create$delegate$1(a aVar) {
        super(0);
        this.$produceFile = aVar;
    }

    @Override // d7.a
    public final File invoke() {
        File file = (File) this.$produceFile.invoke();
        file.getClass();
        String name = file.getName();
        name.getClass();
        int lastIndexOf = name.lastIndexOf(46, l7.m.u0(name));
        if ((lastIndexOf == -1 ? "" : name.substring(lastIndexOf + 1, name.length())).equals("preferences_pb")) {
            File absoluteFile = file.getAbsoluteFile();
            absoluteFile.getClass();
            return absoluteFile;
        }
        throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
    }
}
