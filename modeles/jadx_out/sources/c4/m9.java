package c4;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.uptodown.UptodownApp;
import com.uptodown.activities.SearchActivity;
import com.uptodown.views.InstantAutoCompleteTextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class m9 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1873a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f1874b;

    public /* synthetic */ m9(SearchActivity searchActivity, int i) {
        this.f1873a = i;
        this.f1874b = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1873a;
        SearchActivity searchActivity = this.f1874b;
        switch (i) {
            case 0:
                int i6 = SearchActivity.Y;
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    searchActivity.finish();
                    break;
                }
                break;
            case 1:
                int i10 = SearchActivity.Y;
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).setText("");
                    break;
                }
                break;
            case 2:
                int i11 = SearchActivity.Y;
                float f11 = UptodownApp.I;
                if (b4.d.t()) {
                    try {
                        searchActivity.X.launch(new Intent("android.speech.action.RECOGNIZE_SPEECH"));
                        break;
                    } catch (ActivityNotFoundException e10) {
                        e10.printStackTrace();
                        String string = searchActivity.getString(2131952025);
                        string.getClass();
                        searchActivity.A(string);
                        return;
                    }
                }
                break;
            case 3:
                int i12 = SearchActivity.Y;
                Object value = searchActivity.A0().f.getValue();
                ba baVar = ba.f1426a;
                if (value != baVar) {
                    r7.o0 o0Var = searchActivity.A0().f;
                    o0Var.getClass();
                    o0Var.g(null, baVar);
                    ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).setHint(searchActivity.getString(2131952564));
                    searchActivity.z0().f10139m.setAdapter(searchActivity.R);
                    TextView textView = searchActivity.z0().f10140n;
                    TextView textView2 = searchActivity.z0().f10141o;
                    textView.setTextColor(ContextCompat.getColor(searchActivity, 2131100824));
                    textView.setBackground(ContextCompat.getDrawable(searchActivity, 2131231197));
                    textView2.setTextColor(ContextCompat.getColor(searchActivity, 2131100789));
                    textView2.setBackground(null);
                    if (!kotlin.jvm.internal.l.a(searchActivity.A0().h.getValue(), ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString())) {
                        searchActivity.C0(0, ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString());
                        break;
                    }
                }
                break;
            case 4:
                int i13 = SearchActivity.Y;
                Object value2 = searchActivity.A0().f.getValue();
                ba baVar2 = ba.f1427b;
                if (value2 != baVar2) {
                    r7.o0 o0Var2 = searchActivity.A0().f;
                    o0Var2.getClass();
                    o0Var2.g(null, baVar2);
                    ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).setHint(searchActivity.getString(2131952565));
                    searchActivity.z0().f10139m.setAdapter(searchActivity.S);
                    TextView textView3 = searchActivity.z0().f10141o;
                    TextView textView4 = searchActivity.z0().f10140n;
                    textView3.setTextColor(ContextCompat.getColor(searchActivity, 2131100824));
                    textView3.setBackground(ContextCompat.getDrawable(searchActivity, 2131231197));
                    textView4.setTextColor(ContextCompat.getColor(searchActivity, 2131100789));
                    textView4.setBackground(null);
                    if (!kotlin.jvm.internal.l.a(searchActivity.A0().j.getValue(), ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString())) {
                        searchActivity.C0(0, ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString());
                        break;
                    }
                }
                break;
            default:
                view.getClass();
                float f12 = UptodownApp.I;
                if (b4.d.t()) {
                    Object tag = view.getTag();
                    tag.getClass();
                    e1.c0 c0Var = j5.g.D;
                    Context applicationContext = searchActivity.getApplicationContext();
                    applicationContext.getClass();
                    j5.g l10 = c0Var.l(applicationContext);
                    l10.b();
                    SQLiteDatabase sQLiteDatabase = l10.f6673a;
                    sQLiteDatabase.getClass();
                    int delete = sQLiteDatabase.delete("recent_searches", "search=?", new String[]{(String) tag});
                    l10.c();
                    if (delete > 0) {
                        p9 p9Var = searchActivity.T;
                        p9Var.getClass();
                        p9Var.getFilter().filter(((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString());
                        break;
                    }
                }
                break;
        }
    }
}
