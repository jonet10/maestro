package c3;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class f0 {
    public static ArrayList a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> list;
        context.getClass();
        int i = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (list = activityManager.getRunningAppProcesses()) == null) {
            list = q6.t.f8724a;
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
        ArrayList arrayList3 = new ArrayList(q6.n.i0(arrayList2, 10));
        int size2 = arrayList2.size();
        while (i6 < size2) {
            Object obj3 = arrayList2.get(i6);
            i6++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj3;
            String str2 = runningAppProcessInfo.processName;
            str2.getClass();
            arrayList3.add(new e0(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, kotlin.jvm.internal.l.a(runningAppProcessInfo.processName, str)));
        }
        return arrayList3;
    }

    public static e0 b(Context context) {
        Object obj;
        String a8;
        context.getClass();
        int myPid = Process.myPid();
        ArrayList a10 = a(context);
        int size = a10.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                obj = null;
                break;
            }
            obj = a10.get(i);
            i++;
            if (((e0) obj).f1233b == myPid) {
                break;
            }
        }
        e0 e0Var = (e0) obj;
        if (e0Var != null) {
            return e0Var;
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 > 33) {
            a8 = Process.myProcessName();
            a8.getClass();
        } else if ((i6 < 28 || (a8 = Application.getProcessName()) == null) && (a8 = p0.c.a()) == null) {
            a8 = "";
        }
        return new e0(a8, myPid, 0, false);
    }
}
