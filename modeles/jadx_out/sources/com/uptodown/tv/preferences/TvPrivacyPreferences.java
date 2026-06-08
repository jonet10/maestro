package com.uptodown.tv.preferences;

import android.R;
import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.tv.preferences.TvPrivacyPreferences;
import d4.e;
import j5.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TvPrivacyPreferences extends e {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class a extends PreferenceFragmentCompat {
        @Override // androidx.preference.PreferenceFragmentCompat
        public final void onCreatePreferences(Bundle bundle, String str) {
            getPreferenceManager().setSharedPreferencesName("SettingsPreferences");
            addPreferencesFromResource(2132213771);
            Preference findPreference = findPreference("right_to_be_forgotten");
            findPreference.getClass();
            final int i = 0;
            findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: d5.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ TvPrivacyPreferences.a f3599b;

                {
                    this.f3599b = this;
                }

                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i6 = i;
                    TvPrivacyPreferences.a aVar = this.f3599b;
                    switch (i6) {
                        case 0:
                            preference.getClass();
                            FragmentActivity requireActivity = aVar.requireActivity();
                            requireActivity.getClass();
                            String string = aVar.getString(2131952726);
                            string.getClass();
                            c.e(requireActivity, string, null);
                            break;
                        case 1:
                            preference.getClass();
                            Context requireContext = aVar.requireContext();
                            requireContext.getClass();
                            z3.M(requireContext, "gdpr_requested", true);
                            Context requireContext2 = aVar.requireContext();
                            requireContext2.getClass();
                            z3.M(requireContext2, "gdpr_analytics_allowed", true);
                            Context requireContext3 = aVar.requireContext();
                            requireContext3.getClass();
                            z3.M(requireContext3, "gdpr_crashlytics_allowed", true);
                            Context requireContext4 = aVar.requireContext();
                            requireContext4.getClass();
                            z3.M(requireContext4, "gdpr_tracking_allowed", true);
                            aVar.requireActivity().finish();
                            break;
                        default:
                            preference.getClass();
                            Context requireContext5 = aVar.requireContext();
                            requireContext5.getClass();
                            z3.M(requireContext5, "gdpr_requested", false);
                            Context requireContext6 = aVar.requireContext();
                            requireContext6.getClass();
                            z3.M(requireContext6, "gdpr_analytics_allowed", false);
                            Context requireContext7 = aVar.requireContext();
                            requireContext7.getClass();
                            z3.M(requireContext7, "gdpr_crashlytics_allowed", false);
                            Context requireContext8 = aVar.requireContext();
                            requireContext8.getClass();
                            z3.M(requireContext8, "gdpr_tracking_allowed", false);
                            aVar.requireActivity().finish();
                            break;
                    }
                    return true;
                }
            });
            Preference findPreference2 = findPreference("privacy_accept_all");
            findPreference2.getClass();
            final int i6 = 1;
            findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: d5.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ TvPrivacyPreferences.a f3599b;

                {
                    this.f3599b = this;
                }

                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i62 = i6;
                    TvPrivacyPreferences.a aVar = this.f3599b;
                    switch (i62) {
                        case 0:
                            preference.getClass();
                            FragmentActivity requireActivity = aVar.requireActivity();
                            requireActivity.getClass();
                            String string = aVar.getString(2131952726);
                            string.getClass();
                            c.e(requireActivity, string, null);
                            break;
                        case 1:
                            preference.getClass();
                            Context requireContext = aVar.requireContext();
                            requireContext.getClass();
                            z3.M(requireContext, "gdpr_requested", true);
                            Context requireContext2 = aVar.requireContext();
                            requireContext2.getClass();
                            z3.M(requireContext2, "gdpr_analytics_allowed", true);
                            Context requireContext3 = aVar.requireContext();
                            requireContext3.getClass();
                            z3.M(requireContext3, "gdpr_crashlytics_allowed", true);
                            Context requireContext4 = aVar.requireContext();
                            requireContext4.getClass();
                            z3.M(requireContext4, "gdpr_tracking_allowed", true);
                            aVar.requireActivity().finish();
                            break;
                        default:
                            preference.getClass();
                            Context requireContext5 = aVar.requireContext();
                            requireContext5.getClass();
                            z3.M(requireContext5, "gdpr_requested", false);
                            Context requireContext6 = aVar.requireContext();
                            requireContext6.getClass();
                            z3.M(requireContext6, "gdpr_analytics_allowed", false);
                            Context requireContext7 = aVar.requireContext();
                            requireContext7.getClass();
                            z3.M(requireContext7, "gdpr_crashlytics_allowed", false);
                            Context requireContext8 = aVar.requireContext();
                            requireContext8.getClass();
                            z3.M(requireContext8, "gdpr_tracking_allowed", false);
                            aVar.requireActivity().finish();
                            break;
                    }
                    return true;
                }
            });
            Preference findPreference3 = findPreference("privacy_decline_all");
            findPreference3.getClass();
            final int i10 = 2;
            findPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(this) { // from class: d5.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ TvPrivacyPreferences.a f3599b;

                {
                    this.f3599b = this;
                }

                @Override // androidx.preference.Preference.OnPreferenceClickListener
                public final boolean onPreferenceClick(Preference preference) {
                    int i62 = i10;
                    TvPrivacyPreferences.a aVar = this.f3599b;
                    switch (i62) {
                        case 0:
                            preference.getClass();
                            FragmentActivity requireActivity = aVar.requireActivity();
                            requireActivity.getClass();
                            String string = aVar.getString(2131952726);
                            string.getClass();
                            c.e(requireActivity, string, null);
                            break;
                        case 1:
                            preference.getClass();
                            Context requireContext = aVar.requireContext();
                            requireContext.getClass();
                            z3.M(requireContext, "gdpr_requested", true);
                            Context requireContext2 = aVar.requireContext();
                            requireContext2.getClass();
                            z3.M(requireContext2, "gdpr_analytics_allowed", true);
                            Context requireContext3 = aVar.requireContext();
                            requireContext3.getClass();
                            z3.M(requireContext3, "gdpr_crashlytics_allowed", true);
                            Context requireContext4 = aVar.requireContext();
                            requireContext4.getClass();
                            z3.M(requireContext4, "gdpr_tracking_allowed", true);
                            aVar.requireActivity().finish();
                            break;
                        default:
                            preference.getClass();
                            Context requireContext5 = aVar.requireContext();
                            requireContext5.getClass();
                            z3.M(requireContext5, "gdpr_requested", false);
                            Context requireContext6 = aVar.requireContext();
                            requireContext6.getClass();
                            z3.M(requireContext6, "gdpr_analytics_allowed", false);
                            Context requireContext7 = aVar.requireContext();
                            requireContext7.getClass();
                            z3.M(requireContext7, "gdpr_crashlytics_allowed", false);
                            Context requireContext8 = aVar.requireContext();
                            requireContext8.getClass();
                            z3.M(requireContext8, "gdpr_tracking_allowed", false);
                            aVar.requireActivity().finish();
                            break;
                    }
                    return true;
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new a()).commit();
    }
}
