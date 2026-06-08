package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k7 {

    /* renamed from: a, reason: collision with root package name */
    public static final n4 f2692a;

    /* renamed from: b, reason: collision with root package name */
    public static final n4 f2693b;

    static {
        a2.i iVar = new a2.i(m4.a(), true, true);
        iVar.l("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        iVar.l("measurement.set_default_event_parameters_with_backfill.service", true);
        iVar.k(0L, "measurement.id.set_default_event_parameters.fix_service_request_ordering");
        f2692a = iVar.l("measurement.set_default_event_parameters.fix_app_update_logging", true);
        f2693b = iVar.l("measurement.set_default_event_parameters.fix_service_request_ordering", false);
        iVar.l("measurement.set_default_event_parameters.fix_subsequent_launches", true);
    }
}
