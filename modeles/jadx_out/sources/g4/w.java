package g4;

import android.content.UriPermission;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w implements TabLayout.OnTabSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f5281a;

    public w(FileExplorerActivity fileExplorerActivity) {
        this.f5281a = fileExplorerActivity;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab tab) {
        Uri uri;
        boolean z9;
        FileExplorerActivity fileExplorerActivity = this.f5281a;
        if (tab != null && tab.getId() == 0) {
            fileExplorerActivity.f3383e0 = false;
            RecyclerView recyclerView = fileExplorerActivity.F;
            if (recyclerView == null) {
                kotlin.jvm.internal.l.i("rvFiles");
                throw null;
            }
            recyclerView.setVisibility(0);
            LinearLayout linearLayout = fileExplorerActivity.H;
            if (linearLayout == null) {
                kotlin.jvm.internal.l.i("llPermissionExplanation");
                throw null;
            }
            linearLayout.setVisibility(8);
            RecyclerView recyclerView2 = fileExplorerActivity.F;
            if (recyclerView2 == null) {
                kotlin.jvm.internal.l.i("rvFiles");
                throw null;
            }
            recyclerView2.setVisibility(0);
            fileExplorerActivity.Y();
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                fileExplorerActivity.f3381c0 = externalStorageDirectory;
                fileExplorerActivity.Y = null;
            }
            fileExplorerActivity.W(true);
            return;
        }
        fileExplorerActivity.f3383e0 = true;
        ArrayList arrayList = fileExplorerActivity.Z;
        arrayList.getClass();
        if (arrayList.size() > 0) {
            fileExplorerActivity.Y();
            List<UriPermission> persistedUriPermissions = fileExplorerActivity.getContentResolver().getPersistedUriPermissions();
            persistedUriPermissions.getClass();
            Iterator<UriPermission> it = persistedUriPermissions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    uri = null;
                    break;
                }
                UriPermission next = it.next();
                Uri uri2 = next.getUri();
                uri2.getClass();
                String path = uri2.getPath();
                if (path != null) {
                    Pattern compile = Pattern.compile(".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*");
                    compile.getClass();
                    z9 = compile.matcher(path).matches();
                } else {
                    z9 = false;
                }
                if (z9) {
                    uri = next.getUri();
                    break;
                }
            }
            if (uri != null) {
                fileExplorerActivity.Y = DocumentFile.fromTreeUri(fileExplorerActivity, uri);
                fileExplorerActivity.f3381c0 = null;
                fileExplorerActivity.W(true);
                return;
            }
            LinearLayout linearLayout2 = fileExplorerActivity.H;
            if (linearLayout2 == null) {
                kotlin.jvm.internal.l.i("llPermissionExplanation");
                throw null;
            }
            linearLayout2.setVisibility(0);
            RecyclerView recyclerView3 = fileExplorerActivity.F;
            if (recyclerView3 == null) {
                kotlin.jvm.internal.l.i("rvFiles");
                throw null;
            }
            recyclerView3.setVisibility(8);
            LinearLayout linearLayout3 = fileExplorerActivity.H;
            if (linearLayout3 == null) {
                kotlin.jvm.internal.l.i("llPermissionExplanation");
                throw null;
            }
            View findViewById = linearLayout3.findViewById(2131363895);
            findViewById.getClass();
            TextView textView = (TextView) findViewById;
            textView.setTypeface(f4.c.f4883x);
            textView.setOnClickListener(new g(fileExplorerActivity, 10));
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab tab) {
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab tab) {
    }
}
