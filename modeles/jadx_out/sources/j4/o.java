package j4;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import c4.ya;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import l7.u;
import o7.c0;
import o7.m0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f6650a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6651b;

    /* renamed from: c, reason: collision with root package name */
    public final k4.a f6652c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6653d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f6654e;
    public long f;
    public long g;
    public int h;

    public o(ArrayList arrayList, Object obj, k4.a aVar, boolean z9, Context context) {
        arrayList.getClass();
        obj.getClass();
        context.getClass();
        this.f6650a = arrayList;
        this.f6651b = obj;
        this.f6652c = aVar;
        this.f6653d = z9;
        this.f6654e = context;
        v7.e eVar = m0.f8288a;
        c0.s(c0.b(v7.d.f10884a), null, null, new ya(this, null, 17), 3);
    }

    public static DocumentFile e(DocumentFile documentFile, DocumentFile documentFile2) {
        if (documentFile.isDirectory()) {
            throw new Exception("Trying copying a directory into a file");
        }
        if (documentFile.getName() == null) {
            throw new Exception("Source name unknown");
        }
        if (documentFile.getType() == null) {
            throw new Exception("Source mimetype unknown");
        }
        String type = documentFile.getType();
        type.getClass();
        String name = documentFile.getName();
        name.getClass();
        String name2 = documentFile.getName();
        name2.getClass();
        if (u.k0(name2, ".xapk", false)) {
            type = "application/vnd.android.package-archive";
        } else if (l7.m.q0(name, ".", false)) {
            name = name.substring(0, l7.m.A0(".", name, 6));
        }
        return documentFile2.createFile(type, name);
    }

    public static void f(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            int i = 0;
            while (true) {
                if (!(i < listFiles.length)) {
                    break;
                }
                int i6 = i + 1;
                try {
                    File file2 = listFiles[i];
                    file2.getClass();
                    f(file2);
                    i = i6;
                } catch (ArrayIndexOutOfBoundsException e10) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.s(e10.getMessage());
                    return;
                }
            }
        }
        file.delete();
    }

    public static long g(DocumentFile documentFile) {
        if (documentFile.isFile()) {
            return documentFile.length();
        }
        long j = 0;
        if (documentFile.isDirectory()) {
            DocumentFile[] listFiles = documentFile.listFiles();
            listFiles.getClass();
            for (DocumentFile documentFile2 : listFiles) {
                documentFile2.getClass();
                j += g(documentFile2);
            }
        }
        return j;
    }

    public static long h(File file) {
        File[] listFiles;
        if (file.isFile()) {
            return file.length();
        }
        long j = 0;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            int i = 0;
            while (true) {
                if (!(i < listFiles.length)) {
                    break;
                }
                int i6 = i + 1;
                try {
                    File file2 = listFiles[i];
                    file2.getClass();
                    j += h(file2);
                    i = i6;
                } catch (ArrayIndexOutOfBoundsException e10) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.s(e10.getMessage());
                    return 0L;
                }
            }
        }
        return j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00a5 -> B:16:0x00a7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(androidx.documentfile.provider.DocumentFile r9, androidx.documentfile.provider.DocumentFile r10, v6.c r11) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.o.a(androidx.documentfile.provider.DocumentFile, androidx.documentfile.provider.DocumentFile, v6.c):java.lang.Object");
    }

    public final Object b(InputStream inputStream, OutputStream outputStream, String str, v6.c cVar) {
        v7.e eVar = m0.f8288a;
        Object C = c0.C(new k(this, inputStream, outputStream, str, null), v7.d.f10884a, cVar);
        return C == u6.a.f10762a ? C : x.f8463a;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0111 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.io.File r16, androidx.documentfile.provider.DocumentFile r17, v6.c r18) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.o.c(java.io.File, androidx.documentfile.provider.DocumentFile, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(java.io.File r10, java.io.File r11, v6.c r12) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.o.d(java.io.File, java.io.File, v6.c):java.lang.Object");
    }
}
