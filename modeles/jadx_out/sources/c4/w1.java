package c4;

import android.content.SharedPreferences;
import com.uptodown.activities.LanguageSettingsActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2248a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LanguageSettingsActivity f2249b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w1(LanguageSettingsActivity languageSettingsActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f2248a = i;
        this.f2249b = languageSettingsActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2248a) {
            case 0:
                return new w1(this.f2249b, cVar, 0);
            default:
                return new w1(this.f2249b, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2248a) {
            case 0:
                w1 w1Var = (w1) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                w1Var.invokeSuspend(xVar);
                return xVar;
            default:
                w1 w1Var2 = (w1) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                w1Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f2248a;
        p6.x xVar = p6.x.f8463a;
        LanguageSettingsActivity languageSettingsActivity = this.f2249b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                int i6 = LanguageSettingsActivity.S;
                languageSettingsActivity.z0().f10104b.setVisibility(0);
                break;
            default:
                ArrayList w2 = a4.x.w(obj);
                String[] stringArray = languageSettingsActivity.getResources().getStringArray(2130903044);
                stringArray.getClass();
                String[] stringArray2 = languageSettingsActivity.getResources().getStringArray(2130903043);
                stringArray2.getClass();
                String[] stringArray3 = languageSettingsActivity.getResources().getStringArray(2130903045);
                stringArray3.getClass();
                int length = stringArray.length;
                for (int i10 = 0; i10 < length; i10++) {
                    String str = stringArray[i10];
                    x4.q1 q1Var = new x4.q1();
                    q1Var.f11340a = str;
                    q1Var.f11341b = stringArray3[i10];
                    q1Var.f11342c = stringArray2[i10];
                    w2.add(q1Var);
                }
                String str2 = null;
                try {
                    SharedPreferences sharedPreferences = languageSettingsActivity.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences.contains("Language")) {
                        str2 = sharedPreferences.getString("Language", null);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (str2 == null) {
                    str2 = "en";
                }
                languageSettingsActivity.O = new e4.o(w2, languageSettingsActivity.P, str2);
                break;
        }
        return xVar;
    }
}
