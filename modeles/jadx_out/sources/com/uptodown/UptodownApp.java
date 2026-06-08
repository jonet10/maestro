package com.uptodown;

import a.a;
import a4.p;
import android.net.ConnectivityManager;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.ACData;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ActionButton;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.DisplayInfo;
import com.inmobi.cmp.model.NonIABData;
import com.inmobi.cmp.model.PingReturn;
import f4.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import n5.g;
import o7.c0;
import o7.m0;
import v3.e;
import x4.k;
import z4.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class UptodownApp extends c implements ChoiceCmpCallback {
    public static float I = 1.0f;
    public static String J;
    public static String K;
    public static String L;
    public static String M;
    public static String N;
    public static String O;
    public static String P;
    public static String Q;
    public static String R;
    public static int S;
    public static int T;
    public static int U;
    public static int V;
    public static g W;
    public static g X;
    public static int Y;
    public static e Z;
    public static e a0;

    /* renamed from: d0, reason: collision with root package name */
    public static boolean f3290d0;

    /* renamed from: e0, reason: collision with root package name */
    public static boolean f3291e0;

    /* renamed from: f0, reason: collision with root package name */
    public static boolean f3292f0;

    /* renamed from: g0, reason: collision with root package name */
    public static k f3293g0;

    /* renamed from: i0, reason: collision with root package name */
    public static ArrayList f3295i0;

    /* renamed from: j0, reason: collision with root package name */
    public static long f3296j0;

    /* renamed from: k0, reason: collision with root package name */
    public static ArrayList f3297k0;
    public p F;
    public b G;
    public final t7.c H;

    /* renamed from: b0, reason: collision with root package name */
    public static final HashMap f3288b0 = new HashMap();

    /* renamed from: c0, reason: collision with root package name */
    public static final z4.e f3289c0 = new z4.e(null);

    /* renamed from: h0, reason: collision with root package name */
    public static final Object f3294h0 = new Object();

    /* renamed from: l0, reason: collision with root package name */
    public static final Object f3298l0 = new Object();

    /* renamed from: m0, reason: collision with root package name */
    public static final Object f3299m0 = new Object();
    public static final ArrayList n0 = new ArrayList();

    public UptodownApp() {
        this.f4886a = new AtomicBoolean(false);
        this.f4887b = new AtomicBoolean(false);
        this.f4888l = new AtomicBoolean(false);
        this.f4889m = new b4.g(this);
        this.f4890n = new f4.b(this);
        this.H = c0.b(a.L(c0.d(), m0.f8288a));
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onActionButtonClicked(ActionButton actionButton) {
        actionButton.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onCCPAConsentGiven(String str) {
        str.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onCMPUIStatusChanged(DisplayInfo displayInfo) {
        displayInfo.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onCmpError(ChoiceError choiceError) {
        choiceError.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onCmpLoaded(PingReturn pingReturn) {
        pingReturn.getClass();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(40:6|99|13|(2:15|(1:17))|18|(1:20)(1:193)|21|(2:23|(1:25))(2:187|(2:189|(1:191))(1:192))|26|(2:28|(1:30)(1:183))(2:184|(1:186))|31|(2:33|(1:35))|36|(1:38)|39|(26:174|175|176|(1:178)|180|(1:173)(1:46)|47|(1:49)|50|(1:172)|54|(1:58)|59|(11:61|62|63|64|65|(3:67|(2:70|68)|71)|72|73|(5:76|(2:77|(1:106)(2:79|(2:81|82)(1:105)))|(3:84|85|(3:101|102|103)(3:87|88|(3:98|99|100)(3:90|91|(3:93|94|95)(1:97))))(1:104)|96|74)|107|108)|120|121|122|(8:124|(1:130)|131|(3:133|134|144)|145|(3:147|(1:(1:(1:151))(1:153))(1:154)|152)|155|(4:157|(1:(2:160|(1:162))(1:166))(1:167)|163|164)(1:168))|170|(2:126|130)|131|(0)|145|(0)|155|(0)(0))|42|(1:44)|173|47|(0)|50|(1:52)|172|54|(2:56|58)|59|(0)|120|121|122|(0)|170|(0)|131|(0)|145|(0)|155|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x02b4, code lost:
    
        if ((r4.flags & 129) != 0) goto L54;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0444 A[Catch: Exception -> 0x0449, TRY_LEAVE, TryCatch #2 {Exception -> 0x0449, blocks: (B:122:0x0438, B:124:0x0444), top: B:121:0x0438 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03b4  */
    @Override // f4.c, android.app.Application
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate() {
        /*
            Method dump skipped, instructions count: 1364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.onCreate():void");
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onGoogleBasicConsentChange(GoogleBasicConsents googleBasicConsents) {
        googleBasicConsents.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onGoogleVendorConsentGiven(ACData aCData) {
        aCData.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onIABVendorConsentGiven(GDPRData gDPRData) {
        gDPRData.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onNonIABVendorConsentGiven(NonIABData nonIABData) {
        nonIABData.getClass();
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onReceiveUSRegulationsConsent(USRegulationData uSRegulationData) {
        uSRegulationData.getClass();
    }

    @Override // android.app.Application
    public final void onTerminate() {
        super.onTerminate();
        c0.h(this.H);
        new android.support.v4.media.g(this);
        Object systemService = getSystemService("connectivity");
        systemService.getClass();
        ((ConnectivityManager) systemService).unregisterNetworkCallback(new ConnectivityManager.NetworkCallback());
        try {
            p pVar = this.F;
            if (pVar != null) {
                unregisterReceiver(pVar);
                this.F = null;
            }
            b bVar = this.G;
            if (bVar != null) {
                unregisterReceiver(bVar);
                this.G = null;
            }
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.inmobi.cmp.ChoiceCmpCallback
    public final void onUserMovedToOtherState() {
    }
}
