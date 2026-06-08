package c4;

import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.LanguageSettingsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LanguageSettingsActivity f2288a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(LanguageSettingsActivity languageSettingsActivity, t6.c cVar) {
        super(2, cVar);
        this.f2288a = languageSettingsActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new x1(this.f2288a, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        x1 x1Var = (x1) create((o7.a0) obj, (t6.c) obj2);
        p6.x xVar = p6.x.f8463a;
        x1Var.invokeSuspend(xVar);
        return xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        p6.a.e(obj);
        int i = LanguageSettingsActivity.S;
        LanguageSettingsActivity languageSettingsActivity = this.f2288a;
        RecyclerView recyclerView = languageSettingsActivity.z0().f10105l;
        e4.o oVar = languageSettingsActivity.O;
        if (oVar == null) {
            kotlin.jvm.internal.l.i("adapter");
            throw null;
        }
        recyclerView.setAdapter(oVar);
        languageSettingsActivity.z0().f10104b.setVisibility(8);
        return p6.x.f8463a;
    }
}
