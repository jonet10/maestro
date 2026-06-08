package c4;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.uptodown.activities.preferences.PreferencesActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class s4 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2075a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2076b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f2077l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f2078m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f2079n;

    public /* synthetic */ s4(g4.u uVar, int i, PreferencesActivity preferencesActivity, kotlin.jvm.internal.x xVar) {
        this.f2075a = 2;
        this.f2076b = uVar;
        this.f2079n = i;
        this.f2077l = preferencesActivity;
        this.f2078m = xVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f2075a;
        Object obj = this.f2078m;
        Object obj2 = this.f2077l;
        int i6 = this.f2079n;
        Object obj3 = this.f2076b;
        switch (i) {
            case 0:
                ((w4) obj3).E0((j5.g) obj2, (x4.e) obj, i6);
                break;
            case 1:
                ((w4) obj3).E0((j5.g) obj2, (x4.e) obj, i6);
                break;
            default:
                PreferencesActivity preferencesActivity = (PreferencesActivity) obj2;
                kotlin.jvm.internal.x xVar = (kotlin.jvm.internal.x) obj;
                int i10 = PreferencesActivity.T;
                EditText editText = ((g4.u) obj3).f5267l;
                Integer h02 = l7.t.h0(editText.getText().toString());
                Editable text = editText.getText();
                text.getClass();
                if (text.length() > 0 && h02 != null) {
                    String obj4 = editText.getText().toString();
                    int intValue = h02.intValue();
                    obj4.getClass();
                    if (intValue < i6 && obj4.length() == 4 && intValue > 1900) {
                        Object systemService = preferencesActivity.getSystemService("input_method");
                        systemService.getClass();
                        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        AlertDialog alertDialog = (AlertDialog) xVar.f7024a;
                        if (alertDialog != null) {
                            alertDialog.dismiss();
                        }
                        int intValue2 = h02.intValue();
                        SharedPreferences sharedPreferences = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                        sharedPreferences.getClass();
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putInt("ageVerificationYear", intValue2);
                        edit.apply();
                        break;
                    } else {
                        String string = preferencesActivity.getString(2131951667);
                        string.getClass();
                        preferencesActivity.A(string);
                        break;
                    }
                } else {
                    String string2 = preferencesActivity.getString(2131951667);
                    string2.getClass();
                    preferencesActivity.A(string2);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ s4(w4 w4Var, j5.g gVar, x4.e eVar, int i, int i6) {
        this.f2075a = i6;
        this.f2076b = w4Var;
        this.f2077l = gVar;
        this.f2078m = eVar;
        this.f2079n = i;
    }
}
