package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class j0 extends y implements k0 {
    public static k0 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof k0 ? (k0) queryLocalInterface : new i0(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService", 0);
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        boolean z9;
        m0 m0Var = null;
        o0 o0Var = null;
        m0 m0Var2 = null;
        m0 m0Var3 = null;
        m0 m0Var4 = null;
        m0 m0Var5 = null;
        r0 r0Var = null;
        r0 r0Var2 = null;
        r0 r0Var3 = null;
        m0 m0Var6 = null;
        m0 m0Var7 = null;
        m0 m0Var8 = null;
        m0 m0Var9 = null;
        m0 m0Var10 = null;
        m0 m0Var11 = null;
        t0 t0Var = null;
        m0 m0Var12 = null;
        m0 m0Var13 = null;
        m0 m0Var14 = null;
        m0 m0Var15 = null;
        m0 m0Var16 = null;
        switch (i) {
            case 1:
                s0.a I = s0.b.I(parcel.readStrongBinder());
                u0 u0Var = (u0) z.a(parcel, u0.CREATOR);
                long readLong = parcel.readLong();
                z.d(parcel);
                initialize(I, u0Var, readLong);
                break;
            case 2:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) z.a(parcel, Bundle.CREATOR);
                boolean z10 = parcel.readInt() != 0;
                boolean z11 = parcel.readInt() != 0;
                long readLong2 = parcel.readLong();
                z.d(parcel);
                logEvent(readString, readString2, bundle, z10, z11, readLong2);
                break;
            case 3:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                Bundle bundle2 = (Bundle) z.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var = queryLocalInterface instanceof m0 ? (m0) queryLocalInterface : new l0(readStrongBinder);
                }
                m0 m0Var17 = m0Var;
                long readLong3 = parcel.readLong();
                z.d(parcel);
                logEventAndBundle(readString3, readString4, bundle2, m0Var17, readLong3);
                break;
            case 4:
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                s0.a I2 = s0.b.I(parcel.readStrongBinder());
                ClassLoader classLoader = z.f2922a;
                z9 = parcel.readInt() != 0;
                long readLong4 = parcel.readLong();
                z.d(parcel);
                setUserProperty(readString5, readString6, I2, z9, readLong4);
                break;
            case 5:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                ClassLoader classLoader2 = z.f2922a;
                z9 = parcel.readInt() != 0;
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var16 = queryLocalInterface2 instanceof m0 ? (m0) queryLocalInterface2 : new l0(readStrongBinder2);
                }
                z.d(parcel);
                getUserProperties(readString7, readString8, z9, m0Var16);
                break;
            case 6:
                String readString9 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var15 = queryLocalInterface3 instanceof m0 ? (m0) queryLocalInterface3 : new l0(readStrongBinder3);
                }
                z.d(parcel);
                getMaxUserProperties(readString9, m0Var15);
                break;
            case 7:
                String readString10 = parcel.readString();
                long readLong5 = parcel.readLong();
                z.d(parcel);
                setUserId(readString10, readLong5);
                break;
            case 8:
                Bundle bundle3 = (Bundle) z.a(parcel, Bundle.CREATOR);
                long readLong6 = parcel.readLong();
                z.d(parcel);
                setConditionalUserProperty(bundle3, readLong6);
                break;
            case 9:
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                Bundle bundle4 = (Bundle) z.a(parcel, Bundle.CREATOR);
                z.d(parcel);
                clearConditionalUserProperty(readString11, readString12, bundle4);
                break;
            case 10:
                String readString13 = parcel.readString();
                String readString14 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var14 = queryLocalInterface4 instanceof m0 ? (m0) queryLocalInterface4 : new l0(readStrongBinder4);
                }
                z.d(parcel);
                getConditionalUserProperties(readString13, readString14, m0Var14);
                break;
            case 11:
                ClassLoader classLoader3 = z.f2922a;
                z9 = parcel.readInt() != 0;
                long readLong7 = parcel.readLong();
                z.d(parcel);
                setMeasurementEnabled(z9, readLong7);
                break;
            case 12:
                long readLong8 = parcel.readLong();
                z.d(parcel);
                resetAnalyticsData(readLong8);
                break;
            case 13:
                long readLong9 = parcel.readLong();
                z.d(parcel);
                setMinimumSessionDuration(readLong9);
                break;
            case 14:
                long readLong10 = parcel.readLong();
                z.d(parcel);
                setSessionTimeoutDuration(readLong10);
                break;
            case 15:
                s0.a I3 = s0.b.I(parcel.readStrongBinder());
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                long readLong11 = parcel.readLong();
                z.d(parcel);
                setCurrentScreen(I3, readString15, readString16, readLong11);
                break;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var13 = queryLocalInterface5 instanceof m0 ? (m0) queryLocalInterface5 : new l0(readStrongBinder5);
                }
                z.d(parcel);
                getCurrentScreenName(m0Var13);
                break;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var12 = queryLocalInterface6 instanceof m0 ? (m0) queryLocalInterface6 : new l0(readStrongBinder6);
                }
                z.d(parcel);
                getCurrentScreenClass(m0Var12);
                break;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    t0Var = queryLocalInterface7 instanceof t0 ? (t0) queryLocalInterface7 : new s0(readStrongBinder7, "com.google.android.gms.measurement.api.internal.IStringProvider", 0);
                }
                z.d(parcel);
                setInstanceIdProvider(t0Var);
                break;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var11 = queryLocalInterface8 instanceof m0 ? (m0) queryLocalInterface8 : new l0(readStrongBinder8);
                }
                z.d(parcel);
                getCachedAppInstanceId(m0Var11);
                break;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var10 = queryLocalInterface9 instanceof m0 ? (m0) queryLocalInterface9 : new l0(readStrongBinder9);
                }
                z.d(parcel);
                getAppInstanceId(m0Var10);
                break;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var9 = queryLocalInterface10 instanceof m0 ? (m0) queryLocalInterface10 : new l0(readStrongBinder10);
                }
                z.d(parcel);
                getGmpAppId(m0Var9);
                break;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var8 = queryLocalInterface11 instanceof m0 ? (m0) queryLocalInterface11 : new l0(readStrongBinder11);
                }
                z.d(parcel);
                generateEventId(m0Var8);
                break;
            case 23:
                String readString17 = parcel.readString();
                long readLong12 = parcel.readLong();
                z.d(parcel);
                beginAdUnitExposure(readString17, readLong12);
                break;
            case 24:
                String readString18 = parcel.readString();
                long readLong13 = parcel.readLong();
                z.d(parcel);
                endAdUnitExposure(readString18, readLong13);
                break;
            case 25:
                s0.a I4 = s0.b.I(parcel.readStrongBinder());
                long readLong14 = parcel.readLong();
                z.d(parcel);
                onActivityStarted(I4, readLong14);
                break;
            case 26:
                s0.a I5 = s0.b.I(parcel.readStrongBinder());
                long readLong15 = parcel.readLong();
                z.d(parcel);
                onActivityStopped(I5, readLong15);
                break;
            case 27:
                s0.a I6 = s0.b.I(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) z.a(parcel, Bundle.CREATOR);
                long readLong16 = parcel.readLong();
                z.d(parcel);
                onActivityCreated(I6, bundle5, readLong16);
                break;
            case 28:
                s0.a I7 = s0.b.I(parcel.readStrongBinder());
                long readLong17 = parcel.readLong();
                z.d(parcel);
                onActivityDestroyed(I7, readLong17);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                s0.a I8 = s0.b.I(parcel.readStrongBinder());
                long readLong18 = parcel.readLong();
                z.d(parcel);
                onActivityPaused(I8, readLong18);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                s0.a I9 = s0.b.I(parcel.readStrongBinder());
                long readLong19 = parcel.readLong();
                z.d(parcel);
                onActivityResumed(I9, readLong19);
                break;
            case 31:
                s0.a I10 = s0.b.I(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var7 = queryLocalInterface12 instanceof m0 ? (m0) queryLocalInterface12 : new l0(readStrongBinder12);
                }
                long readLong20 = parcel.readLong();
                z.d(parcel);
                onActivitySaveInstanceState(I10, m0Var7, readLong20);
                break;
            case 32:
                Bundle bundle6 = (Bundle) z.a(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var6 = queryLocalInterface13 instanceof m0 ? (m0) queryLocalInterface13 : new l0(readStrongBinder13);
                }
                long readLong21 = parcel.readLong();
                z.d(parcel);
                performAction(bundle6, m0Var6, readLong21);
                break;
            case 33:
                int readInt = parcel.readInt();
                String readString19 = parcel.readString();
                s0.a I11 = s0.b.I(parcel.readStrongBinder());
                s0.a I12 = s0.b.I(parcel.readStrongBinder());
                s0.a I13 = s0.b.I(parcel.readStrongBinder());
                z.d(parcel);
                logHealthData(readInt, readString19, I11, I12, I13);
                break;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    r0Var3 = queryLocalInterface14 instanceof r0 ? (r0) queryLocalInterface14 : new p0(readStrongBinder14);
                }
                z.d(parcel);
                setEventInterceptor(r0Var3);
                break;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    r0Var2 = queryLocalInterface15 instanceof r0 ? (r0) queryLocalInterface15 : new p0(readStrongBinder15);
                }
                z.d(parcel);
                registerOnMeasurementEventListener(r0Var2);
                break;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    r0Var = queryLocalInterface16 instanceof r0 ? (r0) queryLocalInterface16 : new p0(readStrongBinder16);
                }
                z.d(parcel);
                unregisterOnMeasurementEventListener(r0Var);
                break;
            case 37:
                HashMap readHashMap = parcel.readHashMap(z.f2922a);
                z.d(parcel);
                initForTests(readHashMap);
                break;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var5 = queryLocalInterface17 instanceof m0 ? (m0) queryLocalInterface17 : new l0(readStrongBinder17);
                }
                int readInt2 = parcel.readInt();
                z.d(parcel);
                getTestFlag(m0Var5, readInt2);
                break;
            case 39:
                ClassLoader classLoader4 = z.f2922a;
                z9 = parcel.readInt() != 0;
                z.d(parcel);
                setDataCollectionEnabled(z9);
                break;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var4 = queryLocalInterface18 instanceof m0 ? (m0) queryLocalInterface18 : new l0(readStrongBinder18);
                }
                z.d(parcel);
                isDataCollectionEnabled(m0Var4);
                break;
            case 41:
            case 47:
            case 49:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) z.a(parcel, Bundle.CREATOR);
                z.d(parcel);
                setDefaultEventParameters(bundle7);
                break;
            case 43:
                long readLong22 = parcel.readLong();
                z.d(parcel);
                clearMeasurementEnabled(readLong22);
                break;
            case 44:
                Bundle bundle8 = (Bundle) z.a(parcel, Bundle.CREATOR);
                long readLong23 = parcel.readLong();
                z.d(parcel);
                setConsent(bundle8, readLong23);
                break;
            case 45:
                Bundle bundle9 = (Bundle) z.a(parcel, Bundle.CREATOR);
                long readLong24 = parcel.readLong();
                z.d(parcel);
                setConsentThirdParty(bundle9, readLong24);
                break;
            case 46:
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var3 = queryLocalInterface19 instanceof m0 ? (m0) queryLocalInterface19 : new l0(readStrongBinder19);
                }
                z.d(parcel);
                getSessionId(m0Var3);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                Intent intent = (Intent) z.a(parcel, Intent.CREATOR);
                z.d(parcel);
                setSgtmDebugInfo(intent);
                break;
            case 50:
                w0 w0Var = (w0) z.a(parcel, w0.CREATOR);
                String readString20 = parcel.readString();
                String readString21 = parcel.readString();
                long readLong25 = parcel.readLong();
                z.d(parcel);
                setCurrentScreenByScionActivityInfo(w0Var, readString20, readString21, readLong25);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                w0 w0Var2 = (w0) z.a(parcel, w0.CREATOR);
                long readLong26 = parcel.readLong();
                z.d(parcel);
                onActivityStartedByScionActivityInfo(w0Var2, readLong26);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                w0 w0Var3 = (w0) z.a(parcel, w0.CREATOR);
                long readLong27 = parcel.readLong();
                z.d(parcel);
                onActivityStoppedByScionActivityInfo(w0Var3, readLong27);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                w0 w0Var4 = (w0) z.a(parcel, w0.CREATOR);
                Bundle bundle10 = (Bundle) z.a(parcel, Bundle.CREATOR);
                long readLong28 = parcel.readLong();
                z.d(parcel);
                onActivityCreatedByScionActivityInfo(w0Var4, bundle10, readLong28);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                w0 w0Var5 = (w0) z.a(parcel, w0.CREATOR);
                long readLong29 = parcel.readLong();
                z.d(parcel);
                onActivityDestroyedByScionActivityInfo(w0Var5, readLong29);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                w0 w0Var6 = (w0) z.a(parcel, w0.CREATOR);
                long readLong30 = parcel.readLong();
                z.d(parcel);
                onActivityPausedByScionActivityInfo(w0Var6, readLong30);
                break;
            case 56:
                w0 w0Var7 = (w0) z.a(parcel, w0.CREATOR);
                long readLong31 = parcel.readLong();
                z.d(parcel);
                onActivityResumedByScionActivityInfo(w0Var7, readLong31);
                break;
            case 57:
                w0 w0Var8 = (w0) z.a(parcel, w0.CREATOR);
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    m0Var2 = queryLocalInterface20 instanceof m0 ? (m0) queryLocalInterface20 : new l0(readStrongBinder20);
                }
                long readLong32 = parcel.readLong();
                z.d(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(w0Var8, m0Var2, readLong32);
                break;
            case 58:
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    o0Var = queryLocalInterface21 instanceof o0 ? (o0) queryLocalInterface21 : new n0(readStrongBinder21, "com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback", 0);
                }
                z.d(parcel);
                retrieveAndUploadBatches(o0Var);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
