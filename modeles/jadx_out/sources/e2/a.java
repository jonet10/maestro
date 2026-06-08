package e2;

import androidx.core.app.NotificationCompat;
import java.io.File;
import java.io.FilenameFilter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4458a;

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f4458a) {
            case 0:
                return str.startsWith(NotificationCompat.CATEGORY_EVENT);
            case 1:
                return str.startsWith(NotificationCompat.CATEGORY_EVENT) && !str.endsWith("_");
            case 2:
                return str.startsWith("aqs.");
            default:
                return str.startsWith(".ae");
        }
    }
}
