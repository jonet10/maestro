package c4;

import com.uptodown.activities.AppFilesActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f1574a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1575b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ AppFilesActivity f1576l;

    /* renamed from: m, reason: collision with root package name */
    public int f1577m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(AppFilesActivity appFilesActivity, v6.c cVar) {
        super(cVar);
        this.f1576l = appFilesActivity;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f1575b = obj;
        this.f1577m |= Integer.MIN_VALUE;
        return AppFilesActivity.y0(this.f1576l, this);
    }
}
