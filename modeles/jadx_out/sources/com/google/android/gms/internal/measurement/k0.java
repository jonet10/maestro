package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface k0 extends IInterface {
    void beginAdUnitExposure(String str, long j);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j);

    void endAdUnitExposure(String str, long j);

    void generateEventId(m0 m0Var);

    void getAppInstanceId(m0 m0Var);

    void getCachedAppInstanceId(m0 m0Var);

    void getConditionalUserProperties(String str, String str2, m0 m0Var);

    void getCurrentScreenClass(m0 m0Var);

    void getCurrentScreenName(m0 m0Var);

    void getGmpAppId(m0 m0Var);

    void getMaxUserProperties(String str, m0 m0Var);

    void getSessionId(m0 m0Var);

    void getTestFlag(m0 m0Var, int i);

    void getUserProperties(String str, String str2, boolean z9, m0 m0Var);

    void initForTests(Map map);

    void initialize(s0.a aVar, u0 u0Var, long j);

    void isDataCollectionEnabled(m0 m0Var);

    void logEvent(String str, String str2, Bundle bundle, boolean z9, boolean z10, long j);

    void logEventAndBundle(String str, String str2, Bundle bundle, m0 m0Var, long j);

    void logHealthData(int i, String str, s0.a aVar, s0.a aVar2, s0.a aVar3);

    void onActivityCreated(s0.a aVar, Bundle bundle, long j);

    void onActivityCreatedByScionActivityInfo(w0 w0Var, Bundle bundle, long j);

    void onActivityDestroyed(s0.a aVar, long j);

    void onActivityDestroyedByScionActivityInfo(w0 w0Var, long j);

    void onActivityPaused(s0.a aVar, long j);

    void onActivityPausedByScionActivityInfo(w0 w0Var, long j);

    void onActivityResumed(s0.a aVar, long j);

    void onActivityResumedByScionActivityInfo(w0 w0Var, long j);

    void onActivitySaveInstanceState(s0.a aVar, m0 m0Var, long j);

    void onActivitySaveInstanceStateByScionActivityInfo(w0 w0Var, m0 m0Var, long j);

    void onActivityStarted(s0.a aVar, long j);

    void onActivityStartedByScionActivityInfo(w0 w0Var, long j);

    void onActivityStopped(s0.a aVar, long j);

    void onActivityStoppedByScionActivityInfo(w0 w0Var, long j);

    void performAction(Bundle bundle, m0 m0Var, long j);

    void registerOnMeasurementEventListener(r0 r0Var);

    void resetAnalyticsData(long j);

    void retrieveAndUploadBatches(o0 o0Var);

    void setConditionalUserProperty(Bundle bundle, long j);

    void setConsent(Bundle bundle, long j);

    void setConsentThirdParty(Bundle bundle, long j);

    void setCurrentScreen(s0.a aVar, String str, String str2, long j);

    void setCurrentScreenByScionActivityInfo(w0 w0Var, String str, String str2, long j);

    void setDataCollectionEnabled(boolean z9);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(r0 r0Var);

    void setInstanceIdProvider(t0 t0Var);

    void setMeasurementEnabled(boolean z9, long j);

    void setMinimumSessionDuration(long j);

    void setSessionTimeoutDuration(long j);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j);

    void setUserProperty(String str, String str2, s0.a aVar, boolean z9, long j);

    void unregisterOnMeasurementEventListener(r0 r0Var);
}
