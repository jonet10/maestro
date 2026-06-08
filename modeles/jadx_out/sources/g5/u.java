package g5;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.tv.ui.activity.TvMyAppsActivity;
import com.uptodown.tv.ui.activity.TvMyDownloadsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class u implements ActivityResultCallback, OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f5358a;

    public /* synthetic */ u(v vVar) {
        this.f5358a = vVar;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        if (((ActivityResult) obj).getResultCode() == 1003) {
            e1.c0 c0Var = j5.g.D;
            v vVar = this.f5358a;
            Context requireContext = vVar.requireContext();
            requireContext.getClass();
            j5.g l10 = c0Var.l(requireContext);
            l10.b();
            SQLiteDatabase sQLiteDatabase = l10.f6673a;
            sQLiteDatabase.getClass();
            sQLiteDatabase.delete("responses", null, null);
            l10.c();
            String string = vVar.getString(2131952539);
            string.getClass();
            AlertDialog.Builder builder = new AlertDialog.Builder(vVar.getContext());
            builder.setMessage(string);
            builder.setPositiveButton(R.string.ok, new f5.b(7));
            builder.setCancelable(true);
            AlertDialog create = builder.create();
            if (create != null) {
                create.show();
            }
        }
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof c5.b) {
            int i = ((c5.b) obj).f2414a;
            v vVar = this.f5358a;
            if (i == 0) {
                Intent intent = new Intent(vVar.getContext(), (Class<?>) TvMyAppsActivity.class);
                intent.putExtra("updates", true);
                vVar.startActivity(intent);
                return;
            }
            if (i == 1) {
                vVar.startActivity(new Intent(vVar.getContext(), (Class<?>) TvMyAppsActivity.class));
                return;
            }
            if (i == 2) {
                Intent intent2 = new Intent(vVar.getContext(), (Class<?>) TvMyAppsActivity.class);
                intent2.putExtra("rollback", true);
                vVar.startActivity(intent2);
            } else if (i == 3) {
                vVar.startActivity(new Intent(vVar.getContext(), (Class<?>) TvMyDownloadsActivity.class));
            } else {
                if (i != 4) {
                    return;
                }
                vVar.f5360b.launch(new Intent(vVar.getContext(), (Class<?>) PreferencesActivity.class));
            }
        }
    }
}
