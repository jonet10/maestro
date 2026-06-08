package c4;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.StatusRunnable;
import com.uptodown.activities.Updates;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class ma implements d7.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1875a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1876b;

    public /* synthetic */ ma(String str, int i) {
        this.f1875a = i;
        this.f1876b = str;
    }

    @Override // d7.l
    public final Object invoke(Object obj) {
        List forTag$lambda$2;
        int i = this.f1875a;
        String str = this.f1876b;
        switch (i) {
            case 0:
                e4.v0 v0Var = (e4.v0) obj;
                int i6 = Updates.n0;
                v0Var.getClass();
                return Boolean.valueOf(kotlin.jvm.internal.l.a(v0Var.f4708a.f11123l, str));
            default:
                forTag$lambda$2 = StatusRunnable.forTag$lambda$2(str, (WorkDatabase) obj);
                return forTag$lambda$2;
        }
    }
}
