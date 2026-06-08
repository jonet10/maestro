package v1;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import b2.c2;
import b2.y0;
import b2.z0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.l;
import q6.n;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f10792a = new d();

    public static ArrayList a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> list;
        context.getClass();
        int i = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (list = activityManager.getRunningAppProcesses()) == null) {
            list = t.f8724a;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i6 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            if (((ActivityManager.RunningAppProcessInfo) obj2).uid == i) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(n.i0(arrayList2, 10));
        int size2 = arrayList2.size();
        while (i6 < size2) {
            Object obj3 = arrayList2.get(i6);
            i6++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj3;
            y0 y0Var = new y0();
            String str2 = runningAppProcessInfo.processName;
            if (str2 == null) {
                com.google.gson.internal.a.i("Null processName");
                return null;
            }
            y0Var.f981a = str2;
            y0Var.f982b = runningAppProcessInfo.pid;
            byte b7 = (byte) (y0Var.f985e | 1);
            y0Var.f983c = runningAppProcessInfo.importance;
            y0Var.f985e = (byte) (b7 | 2);
            y0Var.f984d = l.a(str2, str);
            y0Var.f985e = (byte) (y0Var.f985e | 4);
            arrayList3.add(y0Var.a());
        }
        return arrayList3;
    }

    public final c2 b(Context context) {
        Object obj;
        String str;
        context.getClass();
        int myPid = Process.myPid();
        ArrayList a8 = a(context);
        int size = a8.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = a8.get(i);
            i++;
            if (((z0) ((c2) obj)).f989b == myPid) {
                break;
            }
        }
        c2 c2Var = (c2) obj;
        if (c2Var != null) {
            return c2Var;
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 > 33) {
            str = Process.myProcessName();
            str.getClass();
        } else if (i6 < 28 || (str = Application.getProcessName()) == null) {
            str = "";
        }
        y0 y0Var = new y0();
        y0Var.f981a = str;
        y0Var.f982b = myPid;
        byte b7 = (byte) (y0Var.f985e | 1);
        y0Var.f983c = 0;
        y0Var.f984d = false;
        y0Var.f985e = (byte) (((byte) (b7 | 2)) | 4);
        return y0Var.a();
    }
}
