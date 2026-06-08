package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i0 extends x implements k0 {
    @Override // com.google.android.gms.internal.measurement.k0
    public final void beginAdUnitExposure(String str, long j) {
        Parcel G = G();
        G.writeString(str);
        G.writeLong(j);
        H(G, 23);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel G = G();
        G.writeString(str);
        G.writeString(str2);
        z.b(G, bundle);
        H(G, 9);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void endAdUnitExposure(String str, long j) {
        Parcel G = G();
        G.writeString(str);
        G.writeLong(j);
        H(G, 24);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void generateEventId(m0 m0Var) {
        Parcel G = G();
        z.c(G, m0Var);
        H(G, 22);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void getCachedAppInstanceId(m0 m0Var) {
        Parcel G = G();
        z.c(G, m0Var);
        H(G, 19);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void getConditionalUserProperties(String str, String str2, m0 m0Var) {
        Parcel G = G();
        G.writeString(str);
        G.writeString(str2);
        z.c(G, m0Var);
        H(G, 10);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void getCurrentScreenClass(m0 m0Var) {
        Parcel G = G();
        z.c(G, m0Var);
        H(G, 17);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void getCurrentScreenName(m0 m0Var) {
        Parcel G = G();
        z.c(G, m0Var);
        H(G, 16);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void getGmpAppId(m0 m0Var) {
        Parcel G = G();
        z.c(G, m0Var);
        H(G, 21);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void getMaxUserProperties(String str, m0 m0Var) {
        Parcel G = G();
        G.writeString(str);
        z.c(G, m0Var);
        H(G, 6);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void getUserProperties(String str, String str2, boolean z9, m0 m0Var) {
        Parcel G = G();
        G.writeString(str);
        G.writeString(str2);
        ClassLoader classLoader = z.f2922a;
        G.writeInt(z9 ? 1 : 0);
        z.c(G, m0Var);
        H(G, 5);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void initialize(s0.a aVar, u0 u0Var, long j) {
        Parcel G = G();
        z.c(G, aVar);
        z.b(G, u0Var);
        G.writeLong(j);
        H(G, 1);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void logEvent(String str, String str2, Bundle bundle, boolean z9, boolean z10, long j) {
        Parcel G = G();
        G.writeString(str);
        G.writeString(str2);
        z.b(G, bundle);
        G.writeInt(z9 ? 1 : 0);
        G.writeInt(1);
        G.writeLong(j);
        H(G, 2);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void logHealthData(int i, String str, s0.a aVar, s0.a aVar2, s0.a aVar3) {
        Parcel G = G();
        G.writeInt(5);
        G.writeString("Error with data collection. Data lost.");
        z.c(G, aVar);
        z.c(G, aVar2);
        z.c(G, aVar3);
        H(G, 33);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void onActivityCreatedByScionActivityInfo(w0 w0Var, Bundle bundle, long j) {
        Parcel G = G();
        z.b(G, w0Var);
        z.b(G, bundle);
        G.writeLong(j);
        H(G, 53);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void onActivityDestroyedByScionActivityInfo(w0 w0Var, long j) {
        Parcel G = G();
        z.b(G, w0Var);
        G.writeLong(j);
        H(G, 54);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void onActivityPausedByScionActivityInfo(w0 w0Var, long j) {
        Parcel G = G();
        z.b(G, w0Var);
        G.writeLong(j);
        H(G, 55);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void onActivityResumedByScionActivityInfo(w0 w0Var, long j) {
        Parcel G = G();
        z.b(G, w0Var);
        G.writeLong(j);
        H(G, 56);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void onActivitySaveInstanceStateByScionActivityInfo(w0 w0Var, m0 m0Var, long j) {
        Parcel G = G();
        z.b(G, w0Var);
        z.c(G, m0Var);
        G.writeLong(j);
        H(G, 57);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void onActivityStartedByScionActivityInfo(w0 w0Var, long j) {
        Parcel G = G();
        z.b(G, w0Var);
        G.writeLong(j);
        H(G, 51);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void onActivityStoppedByScionActivityInfo(w0 w0Var, long j) {
        Parcel G = G();
        z.b(G, w0Var);
        G.writeLong(j);
        H(G, 52);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void registerOnMeasurementEventListener(r0 r0Var) {
        Parcel G = G();
        z.c(G, r0Var);
        H(G, 35);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void retrieveAndUploadBatches(o0 o0Var) {
        Parcel G = G();
        z.c(G, o0Var);
        H(G, 58);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Parcel G = G();
        z.b(G, bundle);
        G.writeLong(j);
        H(G, 8);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void setCurrentScreenByScionActivityInfo(w0 w0Var, String str, String str2, long j) {
        Parcel G = G();
        z.b(G, w0Var);
        G.writeString(str);
        G.writeString(str2);
        G.writeLong(j);
        H(G, 50);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void setDataCollectionEnabled(boolean z9) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void setMeasurementEnabled(boolean z9, long j) {
        Parcel G = G();
        ClassLoader classLoader = z.f2922a;
        G.writeInt(z9 ? 1 : 0);
        G.writeLong(j);
        H(G, 11);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public final void setUserProperty(String str, String str2, s0.a aVar, boolean z9, long j) {
        Parcel G = G();
        G.writeString("fcm");
        G.writeString("_ln");
        z.c(G, aVar);
        G.writeInt(1);
        G.writeLong(j);
        H(G, 4);
    }
}
