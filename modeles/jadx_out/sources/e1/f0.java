package e1;

import androidx.leanback.media.MediaPlayerGlue;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.multiprocess.RemoteWorkManager;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class f0 {
    public static final e0 A;
    public static final e0 A0;
    public static final e0 B;
    public static final e0 B0;
    public static final e0 C;
    public static final e0 C0;
    public static final e0 D;
    public static final e0 D0;
    public static final e0 E;
    public static final e0 E0;
    public static final e0 F;
    public static final e0 F0;
    public static final e0 G;
    public static final e0 G0;
    public static final e0 H;
    public static final e0 H0;
    public static final e0 I;
    public static final e0 I0;
    public static final e0 J;
    public static final e0 J0;
    public static final e0 K;
    public static final e0 K0;
    public static final e0 L;
    public static final e0 L0;
    public static final e0 M;
    public static final e0 M0;
    public static final e0 N;
    public static final e0 N0;
    public static final e0 O;
    public static final e0 O0;
    public static final e0 P;
    public static final e0 P0;
    public static final e0 Q;
    public static final e0 Q0;
    public static final e0 R;
    public static final e0 R0;
    public static final e0 S;
    public static final e0 S0;
    public static final e0 T;
    public static final e0 T0;
    public static final e0 U;
    public static final e0 U0;
    public static final e0 V;
    public static final e0 V0;
    public static final e0 W;
    public static final e0 W0;
    public static final e0 X;
    public static final e0 X0;
    public static final e0 Y;
    public static final e0 Y0;
    public static final e0 Z;
    public static final e0 Z0;

    /* renamed from: a, reason: collision with root package name */
    public static final List f3913a = DesugarCollections.synchronizedList(new ArrayList());
    public static final e0 a0;

    /* renamed from: a1, reason: collision with root package name */
    public static final e0 f3914a1;

    /* renamed from: b, reason: collision with root package name */
    public static final e0 f3915b;

    /* renamed from: b0, reason: collision with root package name */
    public static final e0 f3916b0;
    public static final e0 b1;

    /* renamed from: c, reason: collision with root package name */
    public static final e0 f3917c;

    /* renamed from: c0, reason: collision with root package name */
    public static final e0 f3918c0;

    /* renamed from: c1, reason: collision with root package name */
    public static final e0 f3919c1;

    /* renamed from: d, reason: collision with root package name */
    public static final e0 f3920d;

    /* renamed from: d0, reason: collision with root package name */
    public static final e0 f3921d0;
    public static final e0 d1;

    /* renamed from: e, reason: collision with root package name */
    public static final e0 f3922e;

    /* renamed from: e0, reason: collision with root package name */
    public static final e0 f3923e0;

    /* renamed from: e1, reason: collision with root package name */
    public static final e0 f3924e1;
    public static final e0 f;

    /* renamed from: f0, reason: collision with root package name */
    public static final e0 f3925f0;

    /* renamed from: f1, reason: collision with root package name */
    public static final e0 f3926f1;
    public static final e0 g;

    /* renamed from: g0, reason: collision with root package name */
    public static final e0 f3927g0;

    /* renamed from: g1, reason: collision with root package name */
    public static final e0 f3928g1;
    public static final e0 h;

    /* renamed from: h0, reason: collision with root package name */
    public static final e0 f3929h0;

    /* renamed from: h1, reason: collision with root package name */
    public static final e0 f3930h1;
    public static final e0 i;

    /* renamed from: i0, reason: collision with root package name */
    public static final e0 f3931i0;

    /* renamed from: i1, reason: collision with root package name */
    public static final e0 f3932i1;
    public static final e0 j;

    /* renamed from: j0, reason: collision with root package name */
    public static final e0 f3933j0;

    /* renamed from: j1, reason: collision with root package name */
    public static final e0 f3934j1;

    /* renamed from: k, reason: collision with root package name */
    public static final e0 f3935k;

    /* renamed from: k0, reason: collision with root package name */
    public static final e0 f3936k0;

    /* renamed from: k1, reason: collision with root package name */
    public static final e0 f3937k1;

    /* renamed from: l, reason: collision with root package name */
    public static final e0 f3938l;

    /* renamed from: l0, reason: collision with root package name */
    public static final e0 f3939l0;

    /* renamed from: l1, reason: collision with root package name */
    public static final e0 f3940l1;

    /* renamed from: m, reason: collision with root package name */
    public static final e0 f3941m;

    /* renamed from: m0, reason: collision with root package name */
    public static final e0 f3942m0;

    /* renamed from: n, reason: collision with root package name */
    public static final e0 f3943n;
    public static final e0 n0;

    /* renamed from: o, reason: collision with root package name */
    public static final e0 f3944o;

    /* renamed from: o0, reason: collision with root package name */
    public static final e0 f3945o0;

    /* renamed from: p, reason: collision with root package name */
    public static final e0 f3946p;

    /* renamed from: p0, reason: collision with root package name */
    public static final e0 f3947p0;

    /* renamed from: q, reason: collision with root package name */
    public static final e0 f3948q;

    /* renamed from: q0, reason: collision with root package name */
    public static final e0 f3949q0;

    /* renamed from: r, reason: collision with root package name */
    public static final e0 f3950r;

    /* renamed from: r0, reason: collision with root package name */
    public static final e0 f3951r0;

    /* renamed from: s, reason: collision with root package name */
    public static final e0 f3952s;

    /* renamed from: s0, reason: collision with root package name */
    public static final e0 f3953s0;

    /* renamed from: t, reason: collision with root package name */
    public static final e0 f3954t;

    /* renamed from: t0, reason: collision with root package name */
    public static final e0 f3955t0;

    /* renamed from: u, reason: collision with root package name */
    public static final e0 f3956u;

    /* renamed from: u0, reason: collision with root package name */
    public static final e0 f3957u0;
    public static final e0 v;

    /* renamed from: v0, reason: collision with root package name */
    public static final e0 f3958v0;

    /* renamed from: w, reason: collision with root package name */
    public static final e0 f3959w;

    /* renamed from: w0, reason: collision with root package name */
    public static final e0 f3960w0;

    /* renamed from: x, reason: collision with root package name */
    public static final e0 f3961x;

    /* renamed from: x0, reason: collision with root package name */
    public static final e0 f3962x0;

    /* renamed from: y, reason: collision with root package name */
    public static final e0 f3963y;

    /* renamed from: y0, reason: collision with root package name */
    public static final e0 f3964y0;

    /* renamed from: z, reason: collision with root package name */
    public static final e0 f3965z;

    /* renamed from: z0, reason: collision with root package name */
    public static final e0 f3966z0;

    static {
        DesugarCollections.synchronizedSet(new HashSet());
        Long valueOf = Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS);
        f3915b = a("measurement.ad_id_cache_time", valueOf, c0.f3835m, false);
        f3917c = a("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L, q2.e.f8659q, false);
        f3920d = a("measurement.monitoring.sample_period_millis", 86400000L, x.f4374n, false);
        f3922e = a("measurement.config.cache_time", 86400000L, x.f4384y, false);
        f = a("measurement.config.url_scheme", "https", x.J, false);
        g = a("measurement.config.url_authority", "app-measurement.com", z.f4436q, false);
        h = a("measurement.upload.max_bundles", 100, z.B, false);
        i = a("measurement.upload.max_batch_size", 65536, z.M, false);
        j = a("measurement.upload.max_bundle_size", 65536, a0.f3752t, false);
        f3935k = a("measurement.upload.max_events_per_bundle", 1000, a0.E, false);
        f3938l = a("measurement.upload.max_events_per_day", 100000, c0.f3834l, false);
        f3941m = a("measurement.upload.max_error_events_per_day", 1000, q2.e.f8665x, false);
        f3943n = a("measurement.upload.max_public_events_per_day", 50000, q2.e.f8666y, false);
        f3944o = a("measurement.upload.max_conversions_per_day", Integer.valueOf(MediaPlayerGlue.FAST_FORWARD_REWIND_STEP), q2.e.f8667z, false);
        f3946p = a("measurement.upload.max_realtime_events_per_day", 10, q2.e.A, false);
        f3948q = a("measurement.store.max_stored_events_per_app", 100000, q2.e.B, false);
        f3950r = a("measurement.upload.url", "https://app-measurement.com/a", q2.e.C, false);
        f3952s = a("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d", q2.e.D, false);
        f3954t = a("measurement.sgtm.service_upload_apps_list", "", x.f4371b, false);
        f3956u = a("measurement.sgtm.upload.backoff_http_codes", "404,429,503,504", x.f4372l, false);
        Long valueOf2 = Long.valueOf(RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS);
        v = a("measurement.sgtm.upload.retry_interval", valueOf2, x.f4373m, false);
        f3959w = a("measurement.sgtm.upload.retry_max_wait", 21600000L, x.f4375o, false);
        f3961x = a("measurement.sgtm.batch.retry_interval", 1800000L, x.f4376p, false);
        f3963y = a("measurement.sgtm.batch.retry_max_wait", 21600000L, x.f4377q, false);
        f3965z = a("measurement.sgtm.batch.retry_max_count", 10, x.f4378r, false);
        A = a("measurement.sgtm.upload.max_queued_batches", 5000, x.f4379s, false);
        B = a("measurement.sgtm.upload.batches_retrieval_limit", 5, x.f4380t, false);
        Long valueOf3 = Long.valueOf(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
        C = a("measurement.sgtm.upload.min_delay_after_startup", valueOf3, x.f4381u, false);
        D = a("measurement.sgtm.upload.min_delay_after_broadcast", 1000L, x.v, false);
        E = a("measurement.sgtm.upload.min_delay_after_background", valueOf2, x.f4382w, false);
        F = a("measurement.sgtm.batch.long_queuing_threshold", 14400000L, x.f4383x, false);
        G = a("measurement.upload.backoff_period", 43200000L, x.f4385z, false);
        H = a("measurement.upload.window_interval", 3600000L, x.A, false);
        I = a("measurement.upload.interval", 3600000L, x.B, false);
        J = a("measurement.upload.realtime_upload_interval", valueOf, x.C, false);
        K = a("measurement.upload.debug_upload_interval", 1000L, x.D, false);
        L = a("measurement.upload.minimum_delay", 500L, x.E, false);
        M = a("measurement.alarm_manager.minimum_interval", 60000L, x.F, false);
        N = a("measurement.upload.stale_data_deletion_interval", 86400000L, x.G, false);
        O = a("measurement.upload.refresh_blacklisted_config_interval", 604800000L, x.H, false);
        P = a("measurement.upload.initial_upload_delay_time", 15000L, x.I, false);
        Q = a("measurement.upload.retry_time", 1800000L, x.K, false);
        R = a("measurement.upload.retry_count", 6, x.L, false);
        S = a("measurement.upload.max_queue_time", 518400000L, x.M, false);
        T = a("measurement.upload.google_signal_max_queue_time", Long.valueOf(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS), x.N, false);
        U = a("measurement.lifetimevalue.max_currency_tracked", 4, z.f4430b, false);
        V = a("measurement.audience.filter_result_max_count", 200, z.f4431l, false);
        W = a("measurement.upload.max_public_user_properties", 100, null, false);
        X = a("measurement.upload.max_event_name_cardinality", 2000, null, false);
        Y = a("measurement.upload.max_public_event_params", 100, null, false);
        Z = a("measurement.service_client.idle_disconnect_millis", valueOf3, z.f4432m, false);
        a0 = a("measurement.service_client.reconnect_millis", 1000L, z.f4433n, false);
        Boolean bool = Boolean.FALSE;
        f3916b0 = a("measurement.test.boolean_flag", bool, z.f4434o, false);
        f3918c0 = a("measurement.test.string_flag", "---", z.f4435p, false);
        f3921d0 = a("measurement.test.long_flag", -1L, z.f4437r, false);
        a("measurement.test.cached_long_flag", -1L, z.f4438s, true);
        f3923e0 = a("measurement.test.int_flag", -2, z.f4439t, false);
        f3925f0 = a("measurement.test.double_flag", Double.valueOf(-3.0d), z.f4440u, false);
        f3927g0 = a("measurement.experiment.max_ids", 50, z.v, false);
        f3929h0 = a("measurement.upload.max_item_scoped_custom_parameters", 27, z.f4441w, false);
        f3931i0 = a("measurement.upload.max_event_parameter_value_length", 500, z.f4442x, true);
        f3933j0 = a("measurement.max_bundles_per_iteration", 100, z.f4443y, false);
        f3936k0 = a("measurement.sdk.attribution.cache.ttl", 604800000L, z.f4444z, false);
        f3939l0 = a("measurement.redaction.app_instance_id.ttl", 7200000L, z.A, false);
        f3942m0 = a("measurement.rb.attribution.client.min_ad_services_version", 7, z.C, false);
        n0 = a("measurement.dma_consent.max_daily_dcu_realtime_events", 1, z.D, false);
        f3945o0 = a("measurement.rb.attribution.uri_scheme", "https", z.E, false);
        f3947p0 = a("measurement.rb.attribution.uri_authority", "google-analytics.com", z.F, false);
        f3949q0 = a("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", z.G, false);
        f3951r0 = a("measurement.session.engagement_interval", 3600000L, z.H, false);
        f3953s0 = a("measurement.rb.attribution.app_allowlist", "", z.I, false);
        f3955t0 = a("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot", z.J, false);
        f3957u0 = a("measurement.rb.attribution.event_params", "value|currency", z.K, false);
        f3958v0 = a("measurement.rb.attribution.query_parameters_to_remove", "", z.L, false);
        f3960w0 = a("measurement.rb.attribution.max_queue_time", 864000000L, z.N, false);
        f3962x0 = a("measurement.rb.attribution.max_retry_delay_seconds", 16, a0.f3743b, false);
        f3964y0 = a("measurement.rb.attribution.client.min_time_after_boot_seconds", 90, a0.f3744l, false);
        a("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0, a0.f3745m, false);
        f3966z0 = a("measurement.rb.max_trigger_registrations_per_day", 1000, a0.f3746n, false);
        Boolean bool2 = Boolean.TRUE;
        A0 = a("measurement.config.bundle_for_all_apps_on_backgrounded", bool2, a0.f3747o, false);
        B0 = a("measurement.config.notify_trigger_uris_on_backgrounded", bool2, a0.f3748p, false);
        C0 = a("measurement.rb.attribution.notify_app_delay_millis", 3000, a0.f3749q, false);
        D0 = a("measurement.quality.checksum", bool, null, false);
        E0 = a("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, a0.f3750r, false);
        F0 = a("measurement.audience.refresh_event_count_filters_timestamp", bool, a0.f3751s, false);
        G0 = a("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, a0.f3753u, true);
        H0 = a("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, a0.v, false);
        I0 = a("measurement.integration.disable_firebase_instance_id", bool, a0.f3754w, false);
        J0 = a("measurement.collection.service.update_with_analytics_fix", bool, a0.f3755x, false);
        K0 = a("measurement.service.storage_consent_support_version", 203600, a0.f3756y, false);
        L0 = a("measurement.service.store_null_safelist", bool2, a0.f3757z, false);
        M0 = a("measurement.service.store_safelist", bool2, a0.A, false);
        N0 = a("measurement.session_stitching_token_enabled", bool, a0.B, false);
        O0 = a("measurement.sgtm.client.upload_on_backgrounded.dev", bool, a0.C, true);
        P0 = a("measurement.gmscore_client_telemetry", bool, c0.f3837o, false);
        Q0 = a("measurement.rb.attribution.service", bool2, a0.D, true);
        R0 = a("measurement.rb.attribution.client2", bool2, a0.F, true);
        S0 = a("measurement.rb.attribution.uuid_generation", bool2, a0.G, false);
        T0 = a("measurement.rb.attribution.enable_trigger_redaction", bool2, a0.H, false);
        a("measurement.rb.attribution.followup1.service", bool, a0.I, false);
        U0 = a("measurement.rb.attribution.retry_disposition", bool, a0.J, false);
        V0 = a("measurement.client.sessions.enable_fix_background_engagement", bool, c0.f3839q, false);
        W0 = a("measurement.set_default_event_parameters_propagate_clear.service.dev", bool2, a0.K, false);
        X0 = a("measurement.set_default_event_parameters_propagate_clear.client.dev", bool2, a0.L, false);
        Y0 = a("measurement.service.ad_impression.convert_value_to_double", bool2, a0.M, false);
        a("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", bool2, a0.N, false);
        a("measurement.remove_conflicting_first_party_apis.dev", bool, c0.f3833b, false);
        Z0 = a("measurement.rb.attribution.service.trigger_uris_high_priority", bool2, q2.e.f8660r, false);
        f3914a1 = a("measurement.tcf.consent_fix", bool2, q2.e.f8661s, false);
        b1 = a("measurement.experiment.enable_phenotype_experiment_reporting", bool2, q2.e.f8662t, false);
        f3919c1 = a("measurement.set_default_event_parameters.fix_service_request_ordering", bool, q2.e.f8655m, false);
        d1 = a("measurement.set_default_event_parameters.fix_app_update_logging", bool2, q2.e.f8654l, false);
        f3924e1 = a("measurement.service.fix_stop_bundling_bug", bool2, q2.e.f8658p, false);
        f3926f1 = a("measurement.fix_params_logcat_spam", bool2, q2.e.f8657o, false);
        f3928g1 = a("measurement.gbraid_campaign.stop_lgclid", bool, c0.f3836n, false);
        f3930h1 = a("measurement.gbraid_compaign.compaign_params_triggering_info_update", "gclid,gbraid,gad_campaignid", q2.e.f8663u, false);
        f3932i1 = a("measurement.edpb.service", bool, q2.e.f8656n, false);
        f3934j1 = a("measurement.edpb.events_cached_in_no_data_mode", "_f,_v,_cmp", q2.e.v, false);
        f3937k1 = a("measurement.add_first_launch_logging_timestamp.service", bool, c0.f3838p, false);
        f3940l1 = a("measurement.overlapping_bundles_fix", bool, q2.e.f8664w, false);
    }

    public static e0 a(String str, Object obj, v vVar, boolean z9) {
        e0 e0Var = new e0(str, obj, vVar);
        if (z9) {
            f3913a.add(e0Var);
        }
        return e0Var;
    }
}
