package c4;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.views.InstantAutoCompleteTextView;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class k2 implements TextView.OnEditorActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1780a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f1781b;

    public /* synthetic */ k2(k0 k0Var, int i) {
        this.f1780a = i;
        this.f1781b = k0Var;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        int i6 = this.f1780a;
        k0 k0Var = this.f1781b;
        switch (i6) {
            case 0:
                LoginActivity loginActivity = (LoginActivity) k0Var;
                int i10 = LoginActivity.W;
                if (i == 6) {
                    loginActivity.J0();
                    break;
                }
                break;
            case 1:
                RepliesActivity repliesActivity = (RepliesActivity) k0Var;
                int i11 = RepliesActivity.S;
                if (i != 6) {
                    break;
                } else {
                    repliesActivity.A0();
                    break;
                }
            default:
                SearchActivity searchActivity = (SearchActivity) k0Var;
                int i12 = SearchActivity.Y;
                textView.getClass();
                if (i != 3) {
                    break;
                } else {
                    String obj = textView.getText().toString();
                    if (obj.length() > 0) {
                        searchActivity.B0();
                        searchActivity.C0(0, obj);
                        Bundle bundle = new Bundle();
                        bundle.putString("text", obj);
                        android.support.v4.media.g gVar = searchActivity.E;
                        if (gVar != null) {
                            gVar.E(bundle, "search");
                        }
                        Pattern compile = Pattern.compile("[^a-zA-Z0-9 ]+");
                        compile.getClass();
                        String replaceAll = compile.matcher(obj).replaceAll("");
                        replaceAll.getClass();
                        String valueOf = String.valueOf(System.currentTimeMillis());
                        j5.g l10 = j5.g.D.l(searchActivity);
                        l10.b();
                        Iterator it = l10.V().iterator();
                        it.getClass();
                        while (true) {
                            if (it.hasNext()) {
                                Object next = it.next();
                                next.getClass();
                                if (l7.u.m0(((x4.z1) next).f11479a, obj, true)) {
                                }
                            } else {
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("search", replaceAll);
                                contentValues.put("timestamp", valueOf);
                                SQLiteDatabase sQLiteDatabase = l10.f6673a;
                                sQLiteDatabase.getClass();
                                sQLiteDatabase.insert("recent_searches", null, contentValues);
                            }
                        }
                        l10.c();
                        ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).dismissDropDown();
                        break;
                    }
                }
                break;
        }
        return false;
    }
}
