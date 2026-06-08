package androidx.datastore.core;

import androidx.datastore.core.FileStorage;
import java.io.File;
import kotlin.jvm.internal.m;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FileStorage$createConnection$2 extends m implements d7.a {
    final /* synthetic */ File $file;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileStorage$createConnection$2(File file) {
        super(0);
        this.$file = file;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m40invoke() {
        FileStorage.Companion companion = FileStorage.Companion;
        Object activeFilesLock$datastore_core_release = companion.getActiveFilesLock$datastore_core_release();
        File file = this.$file;
        synchronized (activeFilesLock$datastore_core_release) {
            companion.getActiveFiles$datastore_core_release().remove(file.getAbsolutePath());
        }
    }

    @Override // d7.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m40invoke();
        return x.f8463a;
    }
}
