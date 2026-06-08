package g4;

import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f5238a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f5239b;

    /* renamed from: l, reason: collision with root package name */
    public int f5240l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(FileExplorerActivity fileExplorerActivity, v6.c cVar) {
        super(cVar);
        this.f5239b = fileExplorerActivity;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f5238a = obj;
        this.f5240l |= Integer.MIN_VALUE;
        return FileExplorerActivity.I(this.f5239b, this);
    }
}
