package g4;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Environment;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5169a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f5170b;

    public /* synthetic */ g(FileExplorerActivity fileExplorerActivity, int i) {
        this.f5169a = i;
        this.f5170b = fileExplorerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f5169a;
        t6.c cVar = null;
        FileExplorerActivity fileExplorerActivity = this.f5170b;
        switch (i) {
            case 0:
                AlertDialog alertDialog = fileExplorerActivity.f5176a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                fileExplorerActivity.z();
                break;
            case 1:
                SearchView searchView = fileExplorerActivity.N;
                if (searchView != null) {
                    searchView.setIconified(false);
                    break;
                }
                break;
            case 2:
                RelativeLayout relativeLayout = fileExplorerActivity.O;
                relativeLayout.getClass();
                if (relativeLayout.getVisibility() != 0) {
                    view.animate().rotation(180.0f).start();
                    RelativeLayout relativeLayout2 = fileExplorerActivity.O;
                    relativeLayout2.getClass();
                    relativeLayout2.setVisibility(0);
                    break;
                } else {
                    view.animate().rotation(0.0f).start();
                    RelativeLayout relativeLayout3 = fileExplorerActivity.O;
                    relativeLayout3.getClass();
                    relativeLayout3.setVisibility(8);
                    break;
                }
            case 3:
                fileExplorerActivity.f3382d0 = !fileExplorerActivity.f3382d0;
                fileExplorerActivity.X();
                fileExplorerActivity.Z();
                break;
            case 4:
                fileExplorerActivity.f3382d0 = !fileExplorerActivity.f3382d0;
                fileExplorerActivity.X();
                boolean z9 = fileExplorerActivity.f3382d0;
                RadioButton radioButton = fileExplorerActivity.Q;
                if (!z9) {
                    radioButton.getClass();
                    radioButton.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230962));
                    RadioButton radioButton2 = fileExplorerActivity.P;
                    radioButton2.getClass();
                    radioButton2.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230953));
                    RadioButton radioButton3 = fileExplorerActivity.R;
                    radioButton3.getClass();
                    radioButton3.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230957));
                    break;
                } else {
                    radioButton.getClass();
                    radioButton.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230964));
                    RadioButton radioButton4 = fileExplorerActivity.P;
                    radioButton4.getClass();
                    radioButton4.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230955));
                    RadioButton radioButton5 = fileExplorerActivity.R;
                    radioButton5.getClass();
                    radioButton5.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230959));
                    break;
                }
            case 5:
                fileExplorerActivity.f3382d0 = !fileExplorerActivity.f3382d0;
                fileExplorerActivity.X();
                boolean z10 = fileExplorerActivity.f3382d0;
                RadioButton radioButton6 = fileExplorerActivity.R;
                if (!z10) {
                    radioButton6.getClass();
                    radioButton6.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230958));
                    RadioButton radioButton7 = fileExplorerActivity.Q;
                    radioButton7.getClass();
                    radioButton7.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230961));
                    RadioButton radioButton8 = fileExplorerActivity.P;
                    radioButton8.getClass();
                    radioButton8.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230953));
                    break;
                } else {
                    radioButton6.getClass();
                    radioButton6.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230960));
                    RadioButton radioButton9 = fileExplorerActivity.Q;
                    radioButton9.getClass();
                    radioButton9.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230963));
                    RadioButton radioButton10 = fileExplorerActivity.P;
                    radioButton10.getClass();
                    radioButton10.setBackground(ContextCompat.getDrawable(fileExplorerActivity, 2131230955));
                    break;
                }
            case 6:
                AlertDialog alertDialog2 = fileExplorerActivity.S;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
            case 7:
                fileExplorerActivity.f3382d0 = !fileExplorerActivity.f3382d0;
                fileExplorerActivity.X();
                fileExplorerActivity.Z();
                break;
            case 8:
                AlertDialog alertDialog3 = fileExplorerActivity.S;
                alertDialog3.getClass();
                alertDialog3.dismiss();
                fileExplorerActivity.finish();
                break;
            case 9:
                AlertDialog alertDialog4 = fileExplorerActivity.S;
                alertDialog4.getClass();
                alertDialog4.dismiss();
                break;
            case 10:
                int i6 = FileExplorerActivity.f3379q0;
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
                intent.addFlags(195);
                intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
                intent.putExtra("android.content.extra.FANCY", true);
                intent.putExtra("android.content.extra.SHOW_FILESIZE", true);
                fileExplorerActivity.v.launch(intent);
                break;
            case 11:
                int i10 = FileExplorerActivity.f3379q0;
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new o(fileExplorerActivity, cVar, 2), 3);
                AlertDialog alertDialog5 = fileExplorerActivity.S;
                alertDialog5.getClass();
                alertDialog5.dismiss();
                break;
            case 12:
                AlertDialog alertDialog6 = fileExplorerActivity.S;
                alertDialog6.getClass();
                alertDialog6.dismiss();
                break;
            case 13:
                int i11 = FileExplorerActivity.f3379q0;
                Intent intent2 = new Intent(fileExplorerActivity.getApplicationContext(), (Class<?>) FileExplorerActivity.class);
                intent2.putExtra("select_path", 1);
                fileExplorerActivity.f3393p0.launch(intent2);
                break;
            case 14:
                AlertDialog alertDialog7 = fileExplorerActivity.S;
                alertDialog7.getClass();
                alertDialog7.dismiss();
                break;
            case 15:
                int i12 = FileExplorerActivity.f3379q0;
                Intent intent3 = new Intent();
                DocumentFile documentFile = fileExplorerActivity.Y;
                if (documentFile == null) {
                    File file = fileExplorerActivity.f3381c0;
                    file.getClass();
                    if (!file.canWrite()) {
                        String string = fileExplorerActivity.getString(2131951877);
                        string.getClass();
                        fileExplorerActivity.A(string);
                        break;
                    } else {
                        File file2 = fileExplorerActivity.f3381c0;
                        file2.getClass();
                        intent3.putExtra("path_selected", file2.getAbsolutePath()).getClass();
                    }
                } else if (!documentFile.canWrite()) {
                    String string2 = fileExplorerActivity.getString(2131951877);
                    string2.getClass();
                    fileExplorerActivity.A(string2);
                    break;
                } else {
                    DocumentFile documentFile2 = fileExplorerActivity.Y;
                    documentFile2.getClass();
                    intent3.setData(documentFile2.getUri());
                }
                intent3.putExtra("sdcard_selected", fileExplorerActivity.f3383e0);
                fileExplorerActivity.setResult(145, intent3);
                fileExplorerActivity.finish();
                break;
            case 16:
                int i13 = FileExplorerActivity.f3379q0;
                fileExplorerActivity.finish();
                break;
            case 17:
                int i14 = FileExplorerActivity.f3379q0;
                fileExplorerActivity.finish();
                break;
            default:
                int i15 = FileExplorerActivity.f3379q0;
                fileExplorerActivity.Y();
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalStorageDirectory != null) {
                    fileExplorerActivity.f3381c0 = externalStorageDirectory;
                    fileExplorerActivity.Y = null;
                }
                fileExplorerActivity.W(true);
                break;
        }
    }
}
