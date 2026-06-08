package y2;

import android.content.res.Resources;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f11727a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* JADX WARN: Can't wrap try/catch for region: R(66:0|1|2|3|(1:5)|191|7|(3:167|168|(63:170|(56:172|(1:174)|10|(1:12)|13|(1:15)|16|(47:18|(1:152)|22|(1:24)|25|(1:27)(2:142|(1:147)(1:146))|(1:29)|30|(1:32)(5:130|(1:132)|133|(1:135)(1:141)|(1:137)(2:138|(1:140)))|33|(1:35)(6:109|(4:112|(2:119|120)(1:122)|121|110)|125|126|(1:128)|129)|36|(1:38)(1:108)|(1:40)|41|(30:104|105|(1:47)|48|(1:50)|51|(24:95|(1:99)|(1:55)|56|(20:90|(1:94)|(1:60)|61|(2:63|(1:65)(1:66))|(1:68)|69|(1:71)|72|(1:74)|75|(1:77)|78|(1:80)|81|(1:83)|84|(1:86)|87|88)|58|(0)|61|(0)|(0)|69|(0)|72|(0)|75|(0)|78|(0)|81|(0)|84|(0)|87|88)|53|(0)|56|(0)|58|(0)|61|(0)|(0)|69|(0)|72|(0)|75|(0)|78|(0)|81|(0)|84|(0)|87|88)|43|(30:100|101|(0)|48|(0)|51|(0)|53|(0)|56|(0)|58|(0)|61|(0)|(0)|69|(0)|72|(0)|75|(0)|78|(0)|81|(0)|84|(0)|87|88)|45|(0)|48|(0)|51|(0)|53|(0)|56|(0)|58|(0)|61|(0)|(0)|69|(0)|72|(0)|75|(0)|78|(0)|81|(0)|84|(0)|87|88)|153|(2:162|163)|(1:161)(1:160)|22|(0)|25|(0)(0)|(0)|30|(0)(0)|33|(0)(0)|36|(0)(0)|(0)|41|(0)|43|(0)|45|(0)|48|(0)|51|(0)|53|(0)|56|(0)|58|(0)|61|(0)|(0)|69|(0)|72|(0)|75|(0)|78|(0)|81|(0)|84|(0)|87|88)|175|(59:177|(1:179)|10|(0)|13|(0)|16|(0)|153|(1:155)|162|163|(1:158)|161|22|(0)|25|(0)(0)|(0)|30|(0)(0)|33|(0)(0)|36|(0)(0)|(0)|41|(0)|43|(0)|45|(0)|48|(0)|51|(0)|53|(0)|56|(0)|58|(0)|61|(0)|(0)|69|(0)|72|(0)|75|(0)|78|(0)|81|(0)|84|(0)|87|88)(1:187)|180|(3:182|(1:184)(1:186)|185)|10|(0)|13|(0)|16|(0)|153|(0)|162|163|(0)|161|22|(0)|25|(0)(0)|(0)|30|(0)(0)|33|(0)(0)|36|(0)(0)|(0)|41|(0)|43|(0)|45|(0)|48|(0)|51|(0)|53|(0)|56|(0)|58|(0)|61|(0)|(0)|69|(0)|72|(0)|75|(0)|78|(0)|81|(0)|84|(0)|87|88))|9|10|(0)|13|(0)|16|(0)|153|(0)|162|163|(0)|161|22|(0)|25|(0)(0)|(0)|30|(0)(0)|33|(0)(0)|36|(0)(0)|(0)|41|(0)|43|(0)|45|(0)|48|(0)|51|(0)|53|(0)|56|(0)|58|(0)|61|(0)|(0)|69|(0)|72|(0)|75|(0)|78|(0)|81|(0)|84|(0)|87|88) */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0155, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0156, code lost:
    
        android.util.Log.w("FirebaseMessaging", "Couldn't get own application info: " + r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r2 != null) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x032b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static y2.e a(com.google.firebase.messaging.FirebaseMessagingService r14, g5.f r15) {
        /*
            Method dump skipped, instructions count: 1067
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.f.a(com.google.firebase.messaging.FirebaseMessagingService, g5.f):y2.e");
    }

    public static boolean b(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            Log.e("FirebaseMessaging", "Adaptive icons cannot be used in notifications. Ignoring icon id: " + i);
            return false;
        } catch (Resources.NotFoundException unused) {
            Log.e("FirebaseMessaging", "Couldn't find resource " + i + ", treating it as an invalid icon");
            return false;
        }
    }
}
