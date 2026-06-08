package androidx.lifecycle;

import a4.x;
import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.SavedStateReaderKt;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteStatement;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao;
import b2.t1;
import com.google.android.gms.internal.measurement.b5;
import com.google.android.gms.internal.measurement.n;
import com.google.android.gms.internal.measurement.q;
import com.google.android.gms.internal.measurement.t;
import com.uptodown.activities.preferences.PreferencesActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import s1.o;
import t4.i0;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract /* synthetic */ class l {
    public static void A(View view, int i, ImageView imageView) {
        imageView.setImageDrawable(ContextCompat.getDrawable(view.getContext(), i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void B(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement instanceof AutoCloseable) {
            sQLiteStatement.close();
            return;
        }
        if (sQLiteStatement instanceof ExecutorService) {
            androidx.core.provider.b.d((ExecutorService) sQLiteStatement);
            return;
        }
        if (sQLiteStatement instanceof TypedArray) {
            ((TypedArray) sQLiteStatement).recycle();
            return;
        }
        if (sQLiteStatement instanceof MediaMetadataRetriever) {
            ((MediaMetadataRetriever) sQLiteStatement).release();
            return;
        }
        if (sQLiteStatement instanceof MediaDrm) {
            ((MediaDrm) sQLiteStatement).release();
            return;
        }
        if (sQLiteStatement instanceof DrmManagerClient) {
            ((DrmManagerClient) sQLiteStatement).release();
        } else if (sQLiteStatement instanceof ContentProviderClient) {
            ((ContentProviderClient) sQLiteStatement).release();
        } else {
            o.n();
        }
    }

    public static /* synthetic */ void C(Object obj) {
        if (obj == null) {
            return;
        }
        com.google.gson.internal.a.o();
    }

    public static /* synthetic */ boolean D(Object obj) {
        return obj != null;
    }

    public static View E(ViewGroup viewGroup, int i, ViewGroup viewGroup2, boolean z9) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup2, z9);
        inflate.getClass();
        return inflate;
    }

    public static /* synthetic */ String F(int i) {
        switch (i) {
            case 1:
                return "CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN";
            case 2:
                return "CLIENT_UPLOAD_ELIGIBLE";
            case 3:
                return "MEASUREMENT_SERVICE_NOT_ENABLED";
            case 4:
                return "ANDROID_TOO_OLD";
            case 5:
                return "NON_PLAY_MODE";
            case 6:
                return "SDK_TOO_OLD";
            case 7:
                return "MISSING_JOB_SCHEDULER";
            case 8:
                return "NOT_ENABLED_IN_MANIFEST";
            case 9:
                return "CLIENT_FLAG_OFF";
            case 10:
                return "SERVICE_FLAG_OFF";
            case 11:
                return "PINNED_TO_SERVICE_UPLOAD";
            case 12:
                return "MISSING_SGTM_SERVER_URL";
            default:
                throw null;
        }
    }

    public static void G(EditText... editTextArr) {
        if (editTextArr.length == 0) {
            return;
        }
        com.google.android.material.datepicker.c cVar = new com.google.android.material.datepicker.c(editTextArr, 0);
        for (EditText editText : editTextArr) {
            editText.setOnFocusChangeListener(cVar);
        }
        EditText editText2 = editTextArr[0];
        editText2.postDelayed(new com.google.android.material.bottomappbar.a(editText2, 1), 100L);
    }

    public static /* synthetic */ String H(int i) {
        switch (i) {
            case 1:
                return "GO_TO_PAGE";
            case 2:
                return "PURPOSE";
            case 3:
                return "SPECIAL_FEATURE";
            case 4:
                return "PARTIAL_CONSENT";
            case 5:
                return "SAVE_AND_EXIT";
            case 6:
                return "ACCEPT_ALL";
            case 7:
                return "REJECT_ALL";
            case 8:
                return "ACCEPT_ALL_LEGITIMATE";
            case 9:
                return "OBJECT_ALL_LEGITIMATE";
            case 10:
                return "START_ON_PAGE";
            case 11:
                return "EXPAND_ELEMENT";
            case 12:
                return "COLLAPSE_ELEMENT";
            case 13:
                return "ACTION1";
            case 14:
                return "ACTION2";
            case 15:
                return "CONFIRM";
            default:
                return "null";
        }
    }

    public static n I(com.google.android.gms.internal.measurement.j jVar, q qVar, s sVar, ArrayList arrayList) {
        String str = qVar.f2753a;
        if (jVar.h(str)) {
            n c9 = jVar.c(str);
            if (c9 instanceof com.google.android.gms.internal.measurement.h) {
                return ((com.google.android.gms.internal.measurement.h) c9).a(sVar, arrayList);
            }
            com.google.gson.internal.a.p(x.C(str, " is not a function"));
            return null;
        }
        if ("hasOwnProperty".equals(str)) {
            t1.S("hasOwnProperty", 1, arrayList);
            return jVar.h(((t) sVar.f11756l).c(sVar, (n) arrayList.get(0)).f()) ? n.h : n.i;
        }
        com.google.gson.internal.a.p(x.j("Object has no function ", str));
        return null;
    }

    public static ViewModel a(ViewModelProvider.Factory factory, j7.c cVar, CreationExtras creationExtras) {
        cVar.getClass();
        creationExtras.getClass();
        return factory.create(d0.b.F(cVar), creationExtras);
    }

    public static ViewModel b(ViewModelProvider.Factory factory, Class cls, CreationExtras creationExtras) {
        cls.getClass();
        creationExtras.getClass();
        return factory.create(cls);
    }

    public static boolean c(SQLiteStatement sQLiteStatement, int i) {
        return sQLiteStatement.getLong(i) != 0;
    }

    public static ArrayList d(SQLiteStatement sQLiteStatement) {
        int columnCount = sQLiteStatement.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i = 0; i < columnCount; i++) {
            arrayList.add(sQLiteStatement.getColumnName(i));
        }
        return arrayList;
    }

    public static void e(WorkTagDao workTagDao, String str, Set set) {
        str.getClass();
        set.getClass();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            workTagDao.insert(new WorkTag((String) it.next(), str));
        }
    }

    public static Number f(int i, k3.a aVar) {
        if (i == 1) {
            return Double.valueOf(aVar.y());
        }
        if (i == 2) {
            return new com.google.gson.internal.h(aVar.F());
        }
        if (i == 3) {
            String F = aVar.F();
            if (F.indexOf(46) >= 0) {
                return g(F, aVar);
            }
            try {
                return Long.valueOf(Long.parseLong(F));
            } catch (NumberFormatException unused) {
                return g(F, aVar);
            }
        }
        String F2 = aVar.F();
        try {
            return com.google.gson.internal.f.i(F2);
        } catch (NumberFormatException e10) {
            StringBuilder v = x.v("Cannot parse ", F2, "; at path ");
            v.append(aVar.j(true));
            throw new a1.b(v.toString(), e10);
        }
    }

    public static Double g(String str, k3.a aVar) {
        try {
            Double valueOf = Double.valueOf(str);
            if (!valueOf.isInfinite()) {
                if (valueOf.isNaN()) {
                }
                return valueOf;
            }
            if (aVar.f6962x != 1) {
                throw new k3.c("JSON forbids NaN and infinities: " + valueOf + "; at path " + aVar.j(true));
            }
            return valueOf;
        } catch (NumberFormatException e10) {
            StringBuilder v = x.v("Cannot parse ", str, "; at path ");
            v.append(aVar.j(true));
            throw new a1.b(v.toString(), e10);
        }
    }

    public static String h(String str, char c9) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(c9);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static String i(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char charAt = str.charAt(i);
            if (!Character.isLetter(charAt)) {
                i++;
            } else if (!Character.isUpperCase(charAt)) {
                char upperCase = Character.toUpperCase(charAt);
                if (i == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i) + upperCase + str.substring(i + 1);
            }
        }
        return str;
    }

    public static int j(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            default:
                switch (i) {
                    case 20:
                        return 10;
                    case 21:
                        return 11;
                    case 22:
                        return 12;
                    default:
                        return 0;
                }
        }
    }

    public static /* synthetic */ String k(int i) {
        if (i == 1) {
            return "All";
        }
        if (i == 2) {
            return "Partial";
        }
        if (i == 3) {
            return "Reject";
        }
        if (i == 4) {
            return "NA";
        }
        throw null;
    }

    public static /* synthetic */ int l(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 20;
            case 11:
                return 21;
            case 12:
                return 22;
            default:
                throw null;
        }
    }

    public static int m(int i, int i6, int i10) {
        return b5.s(i) + i6 + i10;
    }

    public static int n(int i, int i6, int i10, int i11) {
        return b5.s(i) + i6 + i10 + i11;
    }

    public static int o(int i, int i6, String str) {
        return (str.hashCode() + i) * i6;
    }

    public static a1.b p(int i, String str) {
        SQLite.throwSQLiteException(i, str);
        return new a1.b();
    }

    public static a1.b q(Object obj) {
        p6.a.e(obj);
        return new a1.b();
    }

    public static a1.b r(String str) {
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        return new a1.b();
    }

    public static View s(ViewGroup viewGroup, int i, ViewGroup viewGroup2, boolean z9) {
        viewGroup.getClass();
        return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup2, z9);
    }

    public static WorkRequest.Builder t(Class cls, String str) {
        return new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) cls).addTag(str);
    }

    public static String u(int i, String str) {
        return str + i;
    }

    public static String v(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String w(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String x(StringBuilder sb, String str, int i) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static i0 y(PreferencesActivity preferencesActivity, int i, TextView textView) {
        textView.setText(preferencesActivity.getString(i));
        return preferencesActivity.z0();
    }

    public static void z(int i, String str, String str2) {
        Log.w(str2, str + i);
    }
}
