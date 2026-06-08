package androidx.constraintlayout.core.utils;

import b2.f0;
import b2.q1;
import e2.b;
import java.io.File;
import java.util.Comparator;
import l4.n;
import x4.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f329a;

    public /* synthetic */ a(int i) {
        this.f329a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int lambda$parseSpans$0;
        switch (this.f329a) {
            case 0:
                lambda$parseSpans$0 = GridCore.lambda$parseSpans$0((String) obj, (String) obj2);
                return lambda$parseSpans$0;
            case 1:
                return ((Double) obj).compareTo((Double) obj2);
            case 2:
                return ((File) obj2).getName().compareTo(((File) obj).getName());
            case 3:
                String name = ((File) obj).getName();
                int i = b.f;
                return name.substring(0, i).compareTo(((File) obj2).getName().substring(0, i));
            case 4:
                e eVar = (e) obj;
                e eVar2 = (e) obj2;
                eVar.getClass();
                eVar2.getClass();
                String str = eVar.f11122b;
                if (str == null) {
                    return 1;
                }
                String str2 = eVar2.f11122b;
                if (str2 == null) {
                    return -1;
                }
                return str.compareToIgnoreCase(str2);
            case 5:
                e eVar3 = (e) obj;
                e eVar4 = (e) obj2;
                eVar3.getClass();
                eVar4.getClass();
                String str3 = eVar3.f11122b;
                if (str3 == null) {
                    return 1;
                }
                String str4 = eVar4.f11122b;
                if (str4 == null) {
                    return -1;
                }
                return str3.compareToIgnoreCase(str4);
            case 6:
                n nVar = (n) obj;
                n nVar2 = (n) obj2;
                nVar.getClass();
                nVar2.getClass();
                File file = nVar.f7120a;
                if (file == null) {
                    return 1;
                }
                if (nVar2.f7120a == null) {
                    return -1;
                }
                String name2 = file.getName();
                name2.getClass();
                File file2 = nVar2.f7120a;
                file2.getClass();
                String name3 = file2.getName();
                name3.getClass();
                return name2.compareToIgnoreCase(name3);
            case 7:
                n nVar3 = (n) obj;
                n nVar4 = (n) obj2;
                nVar3.getClass();
                nVar4.getClass();
                if (nVar3.f7120a == null) {
                    return 1;
                }
                if (nVar4.f7120a == null) {
                    return -1;
                }
                return Boolean.compare(!nVar3.f7121b, !nVar4.f7121b);
            case 8:
                n nVar5 = (n) obj;
                n nVar6 = (n) obj2;
                nVar5.getClass();
                nVar6.getClass();
                File file3 = nVar5.f7120a;
                if (file3 == null) {
                    return 1;
                }
                if (nVar6.f7120a == null) {
                    return -1;
                }
                String name4 = file3.getName();
                name4.getClass();
                File file4 = nVar6.f7120a;
                file4.getClass();
                String name5 = file4.getName();
                name5.getClass();
                return name4.compareToIgnoreCase(name5);
            case 9:
                n nVar7 = (n) obj;
                n nVar8 = (n) obj2;
                nVar7.getClass();
                nVar8.getClass();
                File file5 = nVar7.f7120a;
                if (file5 == null) {
                    return 1;
                }
                if (nVar8.f7120a == null) {
                    return -1;
                }
                String name6 = file5.getName();
                name6.getClass();
                File file6 = nVar8.f7120a;
                file6.getClass();
                String name7 = file6.getName();
                name7.getClass();
                return name6.compareToIgnoreCase(name7);
            case 10:
                n nVar9 = (n) obj;
                n nVar10 = (n) obj2;
                nVar9.getClass();
                nVar10.getClass();
                File file7 = nVar9.f7120a;
                if (file7 == null) {
                    return 1;
                }
                if (nVar10.f7120a == null) {
                    return -1;
                }
                String name8 = file7.getName();
                name8.getClass();
                File file8 = nVar10.f7120a;
                file8.getClass();
                String name9 = file8.getName();
                name9.getClass();
                return name8.compareToIgnoreCase(name9);
            case 11:
                e eVar5 = (e) obj;
                e eVar6 = (e) obj2;
                eVar5.getClass();
                eVar6.getClass();
                String str5 = eVar5.f11122b;
                if (str5 == null) {
                    return 1;
                }
                String str6 = eVar6.f11122b;
                if (str6 == null) {
                    return -1;
                }
                return str5.compareToIgnoreCase(str6);
            case 12:
                return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
            default:
                return ((f0) ((q1) obj)).f785a.compareTo(((f0) ((q1) obj2)).f785a);
        }
    }
}
