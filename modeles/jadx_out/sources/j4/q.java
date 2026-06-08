package j4;

import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.x;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6657a;

    /* renamed from: b, reason: collision with root package name */
    public int f6658b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ s f6659l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(s sVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f6657a = i;
        this.f6659l = sVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f6657a) {
            case 0:
                return new q(this.f6659l, cVar, 0);
            default:
                return new q(this.f6659l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f6657a) {
        }
        return ((q) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f6657a;
        x xVar = x.f8463a;
        u6.a aVar = u6.a.f10762a;
        s sVar = this.f6659l;
        t6.c cVar = null;
        int i6 = 1;
        switch (i) {
            case 0:
                int i10 = this.f6658b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        p6.a.e(obj);
                        return xVar;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                this.f6658b = 1;
                v7.e eVar = m0.f8288a;
                Object C = c0.C(new q(sVar, cVar, i6), v7.d.f10884a, this);
                if (C != aVar) {
                    C = xVar;
                }
                return C == aVar ? aVar : xVar;
            default:
                int i11 = this.f6658b;
                try {
                    if (i11 != 0) {
                        if (i11 == 1 || i11 == 2) {
                            p6.a.e(obj);
                            return xVar;
                        }
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                    DocumentFile documentFile = (DocumentFile) sVar.f11755b;
                    int i12 = 0;
                    if (documentFile != null) {
                        DocumentFile[] listFiles = documentFile.listFiles();
                        listFiles.getClass();
                        ArrayList arrayList = new ArrayList();
                        for (DocumentFile documentFile2 : listFiles) {
                            if (documentFile2.getName() != null) {
                                arrayList.add(documentFile2);
                                String path = documentFile2.getUri().getPath();
                                if (path != null) {
                                    String name = documentFile2.getName();
                                    name.getClass();
                                    s.j(sVar, path, name);
                                }
                            }
                        }
                        v7.e eVar2 = m0.f8288a;
                        p7.c cVar2 = t7.n.f10348a;
                        r rVar = new r(sVar, arrayList, cVar, i12);
                        this.f6658b = 1;
                        if (c0.C(rVar, cVar2, this) != aVar) {
                            return xVar;
                        }
                    } else {
                        File file = (File) sVar.f11756l;
                        if (file == null) {
                            return xVar;
                        }
                        File[] listFiles2 = file.listFiles();
                        ArrayList arrayList2 = new ArrayList();
                        if (listFiles2 != null) {
                            while (i12 < listFiles2.length) {
                                int i13 = i12 + 1;
                                try {
                                    File file2 = listFiles2[i12];
                                    arrayList2.add(file2);
                                    String path2 = file2.getPath();
                                    path2.getClass();
                                    String name2 = file2.getName();
                                    name2.getClass();
                                    s.j(sVar, path2, name2);
                                    i12 = i13;
                                } catch (ArrayIndexOutOfBoundsException e10) {
                                    throw new NoSuchElementException(e10.getMessage());
                                }
                            }
                        }
                        v7.e eVar3 = m0.f8288a;
                        p7.c cVar3 = t7.n.f10348a;
                        r rVar2 = new r(sVar, arrayList2, cVar, i6);
                        this.f6658b = 2;
                        if (c0.C(rVar2, cVar3, this) != aVar) {
                            return xVar;
                        }
                    }
                    return aVar;
                } catch (Error e11) {
                    e11.printStackTrace();
                    return xVar;
                } catch (Exception e12) {
                    e12.printStackTrace();
                    return xVar;
                }
        }
    }
}
