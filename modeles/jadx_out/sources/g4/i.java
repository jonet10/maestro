package g4;

import android.content.SharedPreferences;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class i implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5191a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f5192b;

    public /* synthetic */ i(FileExplorerActivity fileExplorerActivity, int i) {
        this.f5191a = i;
        this.f5192b = fileExplorerActivity;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
        int i = this.f5191a;
        FileExplorerActivity fileExplorerActivity = this.f5192b;
        switch (i) {
            case 0:
                if (!z9) {
                    int i6 = FileExplorerActivity.f3379q0;
                    return;
                }
                fileExplorerActivity.f3382d0 = !fileExplorerActivity.f3382d0;
                RadioButton radioButton = fileExplorerActivity.P;
                radioButton.getClass();
                radioButton.setOnClickListener(new g(fileExplorerActivity, 7));
                RadioButton radioButton2 = fileExplorerActivity.Q;
                radioButton2.getClass();
                radioButton2.setOnClickListener(new c4.e(27));
                RadioButton radioButton3 = fileExplorerActivity.R;
                radioButton3.getClass();
                radioButton3.setOnClickListener(new c4.e(27));
                return;
            case 1:
                if (!z9) {
                    int i10 = FileExplorerActivity.f3379q0;
                    return;
                }
                fileExplorerActivity.f3382d0 = !fileExplorerActivity.f3382d0;
                RadioButton radioButton4 = fileExplorerActivity.Q;
                radioButton4.getClass();
                radioButton4.setOnClickListener(new g(fileExplorerActivity, 4));
                RadioButton radioButton5 = fileExplorerActivity.P;
                radioButton5.getClass();
                radioButton5.setOnClickListener(new c4.e(27));
                RadioButton radioButton6 = fileExplorerActivity.R;
                radioButton6.getClass();
                radioButton6.setOnClickListener(new c4.e(27));
                return;
            case 2:
                if (!z9) {
                    int i11 = FileExplorerActivity.f3379q0;
                    return;
                }
                fileExplorerActivity.f3382d0 = !fileExplorerActivity.f3382d0;
                RadioButton radioButton7 = fileExplorerActivity.R;
                radioButton7.getClass();
                radioButton7.setOnClickListener(new g(fileExplorerActivity, 5));
                RadioButton radioButton8 = fileExplorerActivity.P;
                radioButton8.getClass();
                radioButton8.setOnClickListener(new c4.e(27));
                RadioButton radioButton9 = fileExplorerActivity.Q;
                radioButton9.getClass();
                radioButton9.setOnClickListener(new c4.e(27));
                return;
            case 3:
                if (!z9) {
                    int i12 = FileExplorerActivity.f3379q0;
                    return;
                }
                TextView textView = fileExplorerActivity.L;
                if (textView != null) {
                    textView.setVisibility(0);
                    return;
                } else {
                    kotlin.jvm.internal.l.i("tvSelectedPath");
                    throw null;
                }
            default:
                int i13 = FileExplorerActivity.f3379q0;
                try {
                    SharedPreferences.Editor edit = fileExplorerActivity.getSharedPreferences("CoreSettings", 0).edit();
                    edit.putBoolean("show_hidden_files", z9);
                    edit.apply();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                SearchView searchView = fileExplorerActivity.N;
                searchView.getClass();
                fileExplorerActivity.S(searchView.getQuery().toString(), null);
                return;
        }
    }
}
