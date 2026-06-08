package androidx.room;

import android.content.SharedPreferences;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.room.BaseRoomConnectionManager;
import androidx.sqlite.SQLiteConnection;
import androidx.work.Data;
import androidx.work.WorkRequest;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import c4.k0;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.preferences.PreferencesActivity;
import g4.u;
import java.io.File;
import java.util.UUID;
import kotlin.jvm.internal.v;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f477a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f478b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f479l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f480m;

    public /* synthetic */ c(WorkRequest workRequest, WorkManagerImpl workManagerImpl, String str) {
        this.f477a = 1;
        this.f479l = workManagerImpl;
        this.f478b = str;
        this.f480m = workRequest;
    }

    @Override // d7.a
    public final Object invoke() {
        SQLiteConnection openLocked$lambda$1;
        x enqueueUniquelyNamedPeriodic$lambda$6;
        Void lambda$updateProgress$0;
        int i = this.f477a;
        x xVar = x.f8463a;
        Object obj = this.f478b;
        Object obj2 = this.f480m;
        Object obj3 = this.f479l;
        switch (i) {
            case 0:
                openLocked$lambda$1 = BaseRoomConnectionManager.DriverWrapper.openLocked$lambda$1((BaseRoomConnectionManager) obj3, (BaseRoomConnectionManager.DriverWrapper) obj2, (String) obj);
                break;
            case 1:
                enqueueUniquelyNamedPeriodic$lambda$6 = WorkerUpdater.enqueueUniquelyNamedPeriodic$lambda$6((WorkManagerImpl) obj3, (String) obj, (WorkRequest) obj2);
                break;
            case 2:
                lambda$updateProgress$0 = ((WorkProgressUpdater) obj3).lambda$updateProgress$0((UUID) obj2, (Data) obj);
                break;
            case 3:
                int i6 = k0.N;
                ((k0) obj3).U((File) obj2, (String) obj);
                break;
            case 4:
                TextView textView = (TextView) obj3;
                MainActivity mainActivity = (MainActivity) obj2;
                int i10 = MainActivity.G0;
                textView.setEnabled(false);
                textView.setText(mainActivity.getString(2131952493));
                ((ProgressBar) ((RelativeLayout) obj).findViewById(2131363025)).setVisibility(0);
                mainActivity.G0();
                if (!mainActivity.m()) {
                    mainActivity.y();
                    break;
                }
                break;
            default:
                int i11 = PreferencesActivity.T;
                SharedPreferences sharedPreferences = ((PreferencesActivity) obj3).getSharedPreferences("SettingsPreferences", 0);
                sharedPreferences.getClass();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("ageVerificationYear", -1);
                edit.apply();
                ((v) obj2).f7022a = -1;
                ((u) obj).f5267l.setText("");
                break;
        }
        return xVar;
    }

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, int i) {
        this.f477a = i;
        this.f479l = obj;
        this.f480m = obj2;
        this.f478b = obj3;
    }
}
