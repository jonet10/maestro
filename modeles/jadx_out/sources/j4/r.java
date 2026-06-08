package j4;

import android.os.Environment;
import androidx.appcompat.widget.SearchView;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;
import java.util.ArrayList;
import o7.a0;
import p6.x;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6660a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f6661b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ArrayList f6662l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(s sVar, ArrayList arrayList, t6.c cVar, int i) {
        super(2, cVar);
        this.f6660a = i;
        this.f6661b = sVar;
        this.f6662l = arrayList;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f6660a) {
            case 0:
                return new r(this.f6661b, this.f6662l, cVar, 0);
            default:
                return new r(this.f6661b, this.f6662l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f6660a) {
            case 0:
                r rVar = (r) create(a0Var, cVar);
                x xVar = x.f8463a;
                rVar.invokeSuspend(xVar);
                return xVar;
            default:
                r rVar2 = (r) create(a0Var, cVar);
                x xVar2 = x.f8463a;
                rVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f6660a) {
            case 0:
                p6.a.e(obj);
                android.support.v4.media.g gVar = (android.support.v4.media.g) this.f6661b.f11758n;
                FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) gVar.f247b;
                ArrayList arrayList = this.f6662l;
                fileExplorerActivity.X = arrayList;
                fileExplorerActivity.W = arrayList;
                fileExplorerActivity.f3380b0 = null;
                fileExplorerActivity.a0 = null;
                SearchView searchView = fileExplorerActivity.N;
                searchView.getClass();
                fileExplorerActivity.S(searchView.getQuery().toString(), (String) gVar.f248l);
                break;
            default:
                p6.a.e(obj);
                android.support.v4.media.g gVar2 = (android.support.v4.media.g) this.f6661b.f11758n;
                FileExplorerActivity fileExplorerActivity2 = (FileExplorerActivity) gVar2.f247b;
                ArrayList arrayList2 = this.f6662l;
                fileExplorerActivity2.f3380b0 = arrayList2;
                fileExplorerActivity2.a0 = arrayList2;
                fileExplorerActivity2.X = null;
                fileExplorerActivity2.W = null;
                File file = fileExplorerActivity2.f3381c0;
                if (file != null && !file.canRead()) {
                    ArrayList arrayList3 = fileExplorerActivity2.f3380b0;
                    arrayList3.getClass();
                    if (arrayList3.isEmpty()) {
                        File externalStorageDirectory = Environment.getExternalStorageDirectory();
                        File file2 = fileExplorerActivity2.f3381c0;
                        file2.getClass();
                        if (file2.getAbsolutePath().equals(externalStorageDirectory.getAbsolutePath() + "/Android/data")) {
                            File file3 = new File(fileExplorerActivity2.f3381c0, fileExplorerActivity2.getPackageName());
                            if (file3.exists() && file3.canRead()) {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(new File(fileExplorerActivity2.f3381c0, fileExplorerActivity2.getPackageName()));
                                fileExplorerActivity2.f3380b0 = arrayList4;
                                fileExplorerActivity2.a0 = arrayList4;
                            }
                        }
                    }
                }
                SearchView searchView2 = fileExplorerActivity2.N;
                searchView2.getClass();
                fileExplorerActivity2.S(searchView2.getQuery().toString(), (String) gVar2.f248l);
                break;
        }
        return x.f8463a;
    }
}
