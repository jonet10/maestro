package k0;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract /* synthetic */ class k {
    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "N";
        }
        if (i == 2) {
            return "Y";
        }
        throw null;
    }

    public static /* synthetic */ String b(int i) {
        switch (i) {
            case 1:
                return "IABTCF_CmpSdkID";
            case 2:
                return "IABTCF_CmpSdkVersion";
            case 3:
                return "IABTCF_PolicyVersion";
            case 4:
                return "IABTCF_gdprApplies";
            case 5:
                return "IABTCF_PublisherCC";
            case 6:
                return "IABTCF_PurposeOneTreatment";
            case 7:
                return "IABTCF_UseNonStandardStacks";
            case 8:
                return "IABTCF_TCString";
            case 9:
                return "IABTCF_VendorConsents";
            case 10:
                return "IABTCF_VendorLegitimateInterests";
            case 11:
                return "IABTCF_PurposeConsents";
            case 12:
                return "IABTCF_PurposeLegitimateInterests";
            case 13:
                return "IABTCF_SpecialFeaturesOptIns";
            case 14:
                return "IABTCF_PublisherRestrictions";
            case 15:
                return "IABTCF_PublisherConsent";
            case 16:
                return "IABTCF_PublisherLegitimateInterests";
            case 17:
                return "IABTCF_PublisherCustomPurposesConsents";
            case 18:
                return "IABTCF_PublisherCustomPurposesLegitimateInterests";
            case 19:
                return "GVL";
            case 20:
                return "Cmp";
            case 21:
                return "portal_config";
            case 22:
                return "option_hash";
            case 23:
                return "non_IAB_vendor_hash";
            case 24:
                return "portal_config_hash";
            case 25:
                return "gvl_version";
            case 26:
                return "gvl_last_updated";
            case 27:
                return "portal_non_hash";
            case 28:
                return "translations_text";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                return "googleVendorList";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                return "googleVendorLastUpdate";
            case 31:
                return "IABTCF_AddtlConsent";
            case 32:
                return "google_enabled";
            case 33:
                return "lang_";
            case 34:
                return "IABTCF_NonIABConsentEncoded";
            case 35:
                return "IABTCF_NonIABConsent";
            case 36:
                return "IABTCF_NonIABLegInterests";
            case 37:
                return "IABUSPrivacy_String";
            case 38:
                return "IABUSSavedPrivacyString";
            case 39:
                return "GBCPurposeHash";
            case 40:
                return "GBCConsentString";
            case 41:
                return "GBCResponse";
            case 42:
                return "MSPAPurposes";
            case 43:
                return "IABGPP_TCFEU2_CmpSdkID";
            case 44:
                return "IABGPP_TCFEU2_CmpSdkVersion";
            case 45:
                return "IABGPP_TCFEU2_PolicyVersion";
            case 46:
                return "IABGPP_TCFEU2_gdprApplies";
            case 47:
                return "IABGPP_TCFEU2_PublisherCC";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                return "IABGPP_TCFEU2_PurposeOneTreatment";
            case 49:
                return "IABGPP_TCFEU2_UseNonStandardStacks";
            case 50:
                return "IABGPP_2_TCString";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                return "IABGPP_TCFEU2_VendorConsents";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                return "IABGPP_TCFEU2_VendorLegitimateInterests";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                return "IABGPP_TCFEU2_PurposeConsents";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                return "IABGPP_TCFEU2_PurposeLegitimateInterests";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                return "IABGPP_TCFEU2_SpecialFeaturesOptIns";
            case 56:
                return "IABGPP_TCFEU2_PublisherRestrictions";
            case 57:
                return "IABGPP_TCFEU2_PublisherConsent";
            case 58:
                return "IABGPP_TCFEU2_PublisherLegitimateInterests";
            case 59:
                return "IABGPP_TCFEU2_PublisherCustomPurposesConsents";
            case 60:
                return "IABGPP_TCFEU2_PublisherCustomPurposesLegitimateInterests";
            case 61:
                return "IABGPP_HDR_Version";
            case 62:
                return "IABGPP_HDR_Sections";
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                return "IABGPP_HDR_GppString";
            case 64:
                return "IABGPP_GppSID";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                return "IABGPP_[SectionID]_String";
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                return "MSPAPurposeHash";
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                return "MSPAShown";
            case 68:
                return "SavedSectionId";
            case 69:
                return "MSPAJurisdiction";
            case 70:
                return "SavedRegion";
            case 71:
                return "MSPAPurposesConsent";
            case 72:
                return "MSPASensitivePurposeConsent";
            case 73:
                return "MSPAStatus";
            case 74:
                return "MSPAConsentGivenExplicitly";
            case 75:
                return "GDPRShown";
            case 76:
                return "GDPRStatus";
            case 77:
                return "CCPAShown";
            case 78:
                return "CCPAConsentGivenExplicitly";
            case 79:
                return "LastVisitTime";
            case 80:
                return "GDPR_Consent_LastStoredTimeStamp";
            case 81:
                return "ConfigThemeUUID";
            case 82:
                return "ConfigLanguage";
            case 83:
                return "ConfigCOPApplicable";
            case 84:
                return "ConfigADVApplicable";
            case 85:
                return "ConfigGBCApplicable";
            case 86:
                return "MSPAConfigThemeUUID";
            case 87:
                return "MSPAConfigLanguage";
            case 88:
                return "MSPAConfigGBCApplicable";
            case 89:
                return "CCPAConfigThemeUUID";
            case SubsamplingScaleImageView.ORIENTATION_90 /* 90 */:
                return "CCPAConfigLanguage";
            case 91:
                return "CCPAConfigGBCApplicable";
            case 92:
                return "GBCShown";
            case 93:
                return "GBCStatus";
            default:
                throw null;
        }
    }

    public static /* synthetic */ int c(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 7;
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
                return 10;
            case 9:
                return 11;
            case 10:
                return 12;
            case 11:
                return 13;
            default:
                throw null;
        }
    }

    public static /* synthetic */ int d(int i) {
        int i6 = 1;
        if (i != 1) {
            i6 = 2;
            if (i != 2) {
                i6 = 3;
                if (i != 3) {
                    if (i == 4) {
                        return 4;
                    }
                    throw null;
                }
            }
        }
        return i6;
    }

    public static Bundle e(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    public static Bundle f(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        bundle.putString(str3, str4);
        return bundle;
    }

    public static String g(long j, String str, String str2) {
        return str + j + str2;
    }

    public static String h(String str, StringBuilder sb) {
        return str + ((Object) sb);
    }

    public static HashMap i(Class cls, o2.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(cls, aVar);
        return hashMap;
    }

    public static Map j(HashMap hashMap) {
        return DesugarCollections.unmodifiableMap(new HashMap(hashMap));
    }

    public static o3.d k(r3.a aVar, String str, o3.d dVar, int i, Integer num) {
        aVar.b(str, dVar);
        return new o3.d(i, num);
    }

    public static void l(u4.f0 f0Var, int i, ImageView imageView) {
        imageView.setImageDrawable(ContextCompat.getDrawable(f0Var.requireContext(), i));
    }

    public static /* synthetic */ String m(int i) {
        switch (i) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case 4:
                return "END_OBJECT";
            case 5:
                return "NAME";
            case 6:
                return "STRING";
            case 7:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String n(int i) {
        switch (i) {
            case 1:
                return "NORMAL";
            case 2:
                return "SHELL";
            case 3:
                return "SYSTEM_SERVER";
            case 4:
                return "SYSTEM_APP";
            case 5:
                return "PLATFORM_APP";
            case 6:
                return "UNTRUSTED_APP";
            case 7:
                return "RECOVERY";
            default:
                return "null";
        }
    }
}
