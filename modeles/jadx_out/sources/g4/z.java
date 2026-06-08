package g4;

import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.util.Comparator;
import x4.b3;
import x4.q2;
import x4.y2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5286a;

    public /* synthetic */ z(int i) {
        this.f5286a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f5286a) {
            case 0:
                return t0.f.l(Boolean.valueOf(((DocumentFile) obj).isFile()), Boolean.valueOf(((DocumentFile) obj2).isFile()));
            case 1:
                return t0.f.l(Long.valueOf(((File) obj).length()), Long.valueOf(((File) obj2).length()));
            case 2:
                return t0.f.l(Boolean.valueOf(((File) obj).isFile()), Boolean.valueOf(((File) obj2).isFile()));
            case 3:
                return t0.f.l(Long.valueOf(((DocumentFile) obj2).length()), Long.valueOf(((DocumentFile) obj).length()));
            case 4:
                return t0.f.l(Boolean.valueOf(((DocumentFile) obj2).isDirectory()), Boolean.valueOf(((DocumentFile) obj).isDirectory()));
            case 5:
                return t0.f.l(Long.valueOf(((File) obj2).length()), Long.valueOf(((File) obj).length()));
            case 6:
                return t0.f.l(Boolean.valueOf(((File) obj2).isDirectory()), Boolean.valueOf(((File) obj).isDirectory()));
            case 7:
                x4.d dVar = ((x4.e) obj).f11127p;
                x4.d dVar2 = x4.d.f11087a;
                return t0.f.l(Boolean.valueOf(dVar != dVar2), Boolean.valueOf(((x4.e) obj2).f11127p != dVar2));
            case 8:
                return t0.f.l(Long.valueOf(((File) obj2).lastModified()), Long.valueOf(((File) obj).lastModified()));
            case 9:
                return ((String) obj).compareTo((String) obj2);
            case 10:
                return t0.f.l(Integer.valueOf(((q2) obj).f11351r), Integer.valueOf(((q2) obj2).f11351r));
            case 11:
                return t0.f.l(Integer.valueOf(((b3) obj2).f11067l), Integer.valueOf(((b3) obj).f11067l));
            case 12:
                return t0.f.l(Integer.valueOf(((x4.o) obj).f11300a), Integer.valueOf(((x4.o) obj2).f11300a));
            case 13:
                return t0.f.l(Long.valueOf(((y2) obj2).f11474c), Long.valueOf(((y2) obj).f11474c));
            case 14:
                return t0.f.l(Long.valueOf(((y2) obj2).f11474c), Long.valueOf(((y2) obj).f11474c));
            default:
                return t0.f.l(((x8.g) obj).f11559a, ((x8.g) obj2).f11559a);
        }
    }
}
