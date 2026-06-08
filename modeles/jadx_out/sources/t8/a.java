package t8;

import java.io.File;
import java.io.IOException;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f10368a = new a();

    public final void a(File file) {
        if (file.delete() || !file.exists()) {
            return;
        }
        o.k(file, "failed to delete ");
    }

    public final void b(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            o.k(file, "not a readable directory: ");
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                b(file2);
            }
            if (!file2.delete()) {
                o.k(file2, "failed to delete ");
                return;
            }
        }
    }

    public final void c(File file, File file2) {
        a(file2);
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException("failed to rename " + file + " to " + file2);
    }
}
