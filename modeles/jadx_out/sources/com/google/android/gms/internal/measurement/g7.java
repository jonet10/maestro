package com.google.android.gms.internal.measurement;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.WorkRequest;
import androidx.work.multiprocess.RemoteWorkManager;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g7 {
    public static final n4 A;
    public static final n4 B;
    public static final n4 C;
    public static final n4 D;
    public static final n4 E;
    public static final n4 F;
    public static final n4 G;
    public static final n4 H;
    public static final n4 I;
    public static final n4 J;
    public static final n4 K;
    public static final n4 L;
    public static final n4 M;
    public static final n4 N;
    public static final n4 O;
    public static final n4 P;
    public static final n4 Q;
    public static final n4 R;
    public static final n4 S;
    public static final n4 T;
    public static final n4 U;
    public static final n4 V;
    public static final n4 W;
    public static final n4 X;
    public static final n4 Y;
    public static final n4 Z;

    /* renamed from: a, reason: collision with root package name */
    public static final n4 f2604a;
    public static final n4 a0;

    /* renamed from: b, reason: collision with root package name */
    public static final n4 f2605b;

    /* renamed from: b0, reason: collision with root package name */
    public static final n4 f2606b0;

    /* renamed from: c, reason: collision with root package name */
    public static final n4 f2607c;

    /* renamed from: c0, reason: collision with root package name */
    public static final n4 f2608c0;

    /* renamed from: d, reason: collision with root package name */
    public static final n4 f2609d;

    /* renamed from: d0, reason: collision with root package name */
    public static final n4 f2610d0;

    /* renamed from: e, reason: collision with root package name */
    public static final n4 f2611e;

    /* renamed from: e0, reason: collision with root package name */
    public static final n4 f2612e0;
    public static final n4 f;

    /* renamed from: f0, reason: collision with root package name */
    public static final n4 f2613f0;
    public static final n4 g;

    /* renamed from: g0, reason: collision with root package name */
    public static final n4 f2614g0;
    public static final n4 h;

    /* renamed from: h0, reason: collision with root package name */
    public static final n4 f2615h0;
    public static final n4 i;

    /* renamed from: i0, reason: collision with root package name */
    public static final n4 f2616i0;
    public static final n4 j;

    /* renamed from: j0, reason: collision with root package name */
    public static final n4 f2617j0;

    /* renamed from: k, reason: collision with root package name */
    public static final n4 f2618k;

    /* renamed from: k0, reason: collision with root package name */
    public static final n4 f2619k0;

    /* renamed from: l, reason: collision with root package name */
    public static final n4 f2620l;

    /* renamed from: l0, reason: collision with root package name */
    public static final n4 f2621l0;

    /* renamed from: m, reason: collision with root package name */
    public static final n4 f2622m;

    /* renamed from: m0, reason: collision with root package name */
    public static final n4 f2623m0;

    /* renamed from: n, reason: collision with root package name */
    public static final n4 f2624n;
    public static final n4 n0;

    /* renamed from: o, reason: collision with root package name */
    public static final n4 f2625o;

    /* renamed from: o0, reason: collision with root package name */
    public static final n4 f2626o0;

    /* renamed from: p, reason: collision with root package name */
    public static final n4 f2627p;

    /* renamed from: p0, reason: collision with root package name */
    public static final n4 f2628p0;

    /* renamed from: q, reason: collision with root package name */
    public static final n4 f2629q;

    /* renamed from: q0, reason: collision with root package name */
    public static final n4 f2630q0;

    /* renamed from: r, reason: collision with root package name */
    public static final n4 f2631r;

    /* renamed from: r0, reason: collision with root package name */
    public static final n4 f2632r0;

    /* renamed from: s, reason: collision with root package name */
    public static final n4 f2633s;

    /* renamed from: s0, reason: collision with root package name */
    public static final n4 f2634s0;

    /* renamed from: t, reason: collision with root package name */
    public static final n4 f2635t;

    /* renamed from: t0, reason: collision with root package name */
    public static final n4 f2636t0;

    /* renamed from: u, reason: collision with root package name */
    public static final n4 f2637u;

    /* renamed from: u0, reason: collision with root package name */
    public static final n4 f2638u0;
    public static final n4 v;

    /* renamed from: v0, reason: collision with root package name */
    public static final n4 f2639v0;

    /* renamed from: w, reason: collision with root package name */
    public static final n4 f2640w;

    /* renamed from: w0, reason: collision with root package name */
    public static final n4 f2641w0;

    /* renamed from: x, reason: collision with root package name */
    public static final n4 f2642x;

    /* renamed from: y, reason: collision with root package name */
    public static final n4 f2643y;

    /* renamed from: z, reason: collision with root package name */
    public static final n4 f2644z;

    static {
        a2.i iVar = new a2.i(m4.a(), true, true);
        f2604a = iVar.k(WorkRequest.MIN_BACKOFF_MILLIS, "measurement.ad_id_cache_time");
        f2605b = iVar.k(3600000L, "measurement.app_uninstalled_additional_ad_id_cache_time");
        f2607c = iVar.l("measurement.config.bundle_for_all_apps_on_backgrounded", true);
        f2609d = iVar.k(100L, "measurement.max_bundles_per_iteration");
        f2611e = iVar.m("measurement.gbraid_campaign.campaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid");
        f = iVar.k(86400000L, "measurement.config.cache_time");
        iVar.m("measurement.log_tag", "FA");
        g = iVar.m("measurement.config.url_authority", "app-measurement.com");
        h = iVar.m("measurement.config.url_scheme", "https");
        i = iVar.k(1000L, "measurement.upload.debug_upload_interval");
        iVar.l("measurement.config.default_flag_values", true);
        j = iVar.k(3600000L, "measurement.session.engagement_interval");
        f2618k = iVar.m("measurement.rb.attribution.event_params", "value|currency");
        f2620l = iVar.m("measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp");
        f2622m = iVar.k(605000L, "measurement.upload.google_signal_max_queue_time");
        f2624n = iVar.m("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d");
        iVar.k(0L, "measurement.id.upload.max_conversions_per_day");
        f2625o = iVar.k(4L, "measurement.lifetimevalue.max_currency_tracked");
        f2627p = iVar.k(1L, "measurement.dma_consent.max_daily_dcu_realtime_events");
        f2629q = iVar.k(500L, "measurement.upload.max_event_parameter_value_length");
        f2631r = iVar.k(100000L, "measurement.store.max_stored_events_per_app");
        f2633s = iVar.k(50L, "measurement.experiment.max_ids");
        f2635t = iVar.k(200L, "measurement.audience.filter_result_max_count");
        f2637u = iVar.k(27L, "measurement.upload.max_item_scoped_custom_parameters");
        v = iVar.k(1000L, "measurement.rb.max_trigger_registrations_per_day");
        f2640w = iVar.k(0L, "measurement.rb.attribution.max_trigger_uris_queried_at_once");
        f2642x = iVar.k(7L, "measurement.rb.attribution.client.min_ad_services_version");
        f2643y = iVar.k(60000L, "measurement.alarm_manager.minimum_interval");
        f2644z = iVar.k(500L, "measurement.upload.minimum_delay");
        A = iVar.k(86400000L, "measurement.monitoring.sample_period_millis");
        B = iVar.k(3000L, "measurement.rb.attribution.notify_app_delay_millis");
        C = iVar.l("measurement.config.notify_trigger_uris_on_backgrounded", true);
        D = iVar.m("measurement.rb.attribution.app_allowlist", "");
        E = iVar.k(WorkRequest.MIN_BACKOFF_MILLIS, "measurement.upload.realtime_upload_interval");
        F = iVar.k(604800000L, "measurement.upload.refresh_blacklisted_config_interval");
        iVar.k(3600000L, "measurement.config.cache_time.service");
        G = iVar.k(CoroutineLiveDataKt.DEFAULT_TIMEOUT, "measurement.service_client.idle_disconnect_millis");
        iVar.m("measurement.log_tag.service", "FA-SVC");
        H = iVar.k(1000L, "measurement.service_client.reconnect_millis");
        iVar.m("measurement.sgtm.app_allowlist", "*");
        I = iVar.k(240000L, "measurement.sgtm.batch.long_queuing_threshold");
        J = iVar.k(1800000L, "measurement.sgtm.batch.retry_interval");
        K = iVar.k(10L, "measurement.sgtm.batch.retry_max_count");
        L = iVar.k(21600000L, "measurement.sgtm.batch.retry_max_wait");
        M = iVar.m("measurement.sgtm.service_upload_apps_list", "");
        N = iVar.m("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504");
        O = iVar.k(5L, "measurement.sgtm.upload.batches_retrieval_limit");
        P = iVar.k(CoroutineLiveDataKt.DEFAULT_TIMEOUT, "measurement.sgtm.upload.max_queued_batches");
        Q = iVar.k(RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS, "measurement.sgtm.upload.min_delay_after_background");
        R = iVar.k(1000L, "measurement.sgtm.upload.min_delay_after_broadcast");
        S = iVar.k(CoroutineLiveDataKt.DEFAULT_TIMEOUT, "measurement.sgtm.upload.min_delay_after_startup");
        T = iVar.k(RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS, "measurement.sgtm.upload.retry_interval");
        U = iVar.k(21600000L, "measurement.sgtm.upload.retry_max_wait");
        V = iVar.k(86400000L, "measurement.upload.stale_data_deletion_interval");
        W = iVar.k(16L, "measurement.rb.attribution.max_retry_delay_seconds");
        X = iVar.k(90L, "measurement.rb.attribution.client.min_time_after_boot_seconds");
        Y = iVar.m("measurement.rb.attribution.uri_authority", "google-analytics.com");
        Z = iVar.k(864000000L, "measurement.rb.attribution.max_queue_time");
        a0 = iVar.m("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion");
        f2606b0 = iVar.m("measurement.rb.attribution.query_parameters_to_remove", "");
        f2608c0 = iVar.m("measurement.rb.attribution.uri_scheme", "https");
        f2610d0 = iVar.k(604800000L, "measurement.sdk.attribution.cache.ttl");
        f2612e0 = iVar.k(7200000L, "measurement.redaction.app_instance_id.ttl");
        f2613f0 = iVar.k(43200000L, "measurement.upload.backoff_period");
        f2614g0 = iVar.k(15000L, "measurement.upload.initial_upload_delay_time");
        f2615h0 = iVar.k(3600000L, "measurement.upload.interval");
        f2616i0 = iVar.k(65536L, "measurement.upload.max_bundle_size");
        f2617j0 = iVar.k(100L, "measurement.upload.max_bundles");
        f2619k0 = iVar.k(500L, "measurement.upload.max_conversions_per_day");
        f2621l0 = iVar.k(1000L, "measurement.upload.max_error_events_per_day");
        f2623m0 = iVar.k(1000L, "measurement.upload.max_events_per_bundle");
        n0 = iVar.k(100000L, "measurement.upload.max_events_per_day");
        f2626o0 = iVar.k(50000L, "measurement.upload.max_public_events_per_day");
        f2628p0 = iVar.k(518400000L, "measurement.upload.max_queue_time");
        f2630q0 = iVar.k(10L, "measurement.upload.max_realtime_events_per_day");
        f2632r0 = iVar.k(65536L, "measurement.upload.max_batch_size");
        f2634s0 = iVar.k(6L, "measurement.upload.retry_count");
        f2636t0 = iVar.k(1800000L, "measurement.upload.retry_time");
        f2638u0 = iVar.m("measurement.upload.url", "https://app-measurement.com/a");
        f2639v0 = iVar.k(3600000L, "measurement.upload.window_interval");
        f2641w0 = iVar.m("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot");
    }
}
