package k9;

import h9.g;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {
    public static g a(String str) {
        str.getClass();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("coreUiLabels");
            String optString = jSONObject.optString("initScreenTitle");
            optString.getClass();
            String optString2 = jSONObject.optString("agreeButton");
            optString2.getClass();
            String optString3 = jSONObject.optString("agreeAllButton");
            optString3.getClass();
            String optString4 = jSONObject.optString("initScreenRejectButton");
            optString4.getClass();
            String optString5 = jSONObject.optString("initScreenSettingsButton");
            optString5.getClass();
            ArrayList q9 = d0.b.q(jSONObject, "summaryScreenBodyNoRejectService");
            ArrayList q10 = d0.b.q(jSONObject, "summaryScreenBodyNoRejectGlobal");
            ArrayList q11 = d0.b.q(jSONObject, "summaryScreenBodyNoRejectGroup");
            ArrayList q12 = d0.b.q(jSONObject, "summaryScreenBodyRejectService");
            ArrayList q13 = d0.b.q(jSONObject, "summaryScreenBodyRejectGlobal");
            ArrayList q14 = d0.b.q(jSONObject, "summaryScreenBodyRejectGroup");
            String optString6 = jSONObject.optString("initScreenBodyGlobal");
            optString6.getClass();
            String optString7 = jSONObject.optString("initScreenBodyService");
            optString7.getClass();
            String optString8 = jSONObject.optString("initScreenBodyGroup");
            optString8.getClass();
            String optString9 = jSONObject.optString("specialPurposesAndFeatures");
            optString9.getClass();
            String optString10 = jSONObject.optString("saveAndExitButton");
            optString10.getClass();
            String optString11 = jSONObject.optString("purposeScreenVendorLink");
            optString11.getClass();
            String optString12 = jSONObject.optString("legitimateInterestLink");
            optString12.getClass();
            String optString13 = jSONObject.optString("specialPurposesLabel");
            optString13.getClass();
            String optString14 = jSONObject.optString("specialFeaturesLabel");
            optString14.getClass();
            String optString15 = jSONObject.optString("featuresLabel");
            optString15.getClass();
            String optString16 = jSONObject.optString("dataDeclarationLabel");
            optString16.getClass();
            String optString17 = jSONObject.optString("back");
            optString17.getClass();
            String optString18 = jSONObject.optString("onLabel");
            optString18.getClass();
            String optString19 = jSONObject.optString("offLabel");
            optString19.getClass();
            String optString20 = jSONObject.optString("multiLabel");
            optString20.getClass();
            String optString21 = jSONObject.optString("legalDescription");
            optString21.getClass();
            String optString22 = jSONObject.optString("showPartners");
            optString22.getClass();
            String optString23 = jSONObject.optString("hidePartners");
            optString23.getClass();
            String optString24 = jSONObject.optString("vendorScreenBody");
            optString24.getClass();
            String optString25 = jSONObject.optString("privacyPolicyLabel");
            optString25.getClass();
            String optString26 = jSONObject.optString("descriptionLabel");
            optString26.getClass();
            String optString27 = jSONObject.optString("legitimateScreenBody");
            optString27.getClass();
            String optString28 = jSONObject.optString("legitimateInterestPurposesLabel");
            optString28.getClass();
            String optString29 = jSONObject.optString("legitimateInterestVendorLabel");
            optString29.getClass();
            String optString30 = jSONObject.optString("legitimateScreenObject");
            optString30.getClass();
            String optString31 = jSONObject.optString("legitimateScreenObjected");
            optString31.getClass();
            String optString32 = jSONObject.optString("legitimateScreenAccept");
            optString32.getClass();
            String optString33 = jSONObject.optString("objectAllButton");
            optString33.getClass();
            String optString34 = jSONObject.optString("persistentConsentLinkLabel");
            optString34.getClass();
            String optString35 = jSONObject.optString("nonIabVendorsNotice");
            optString35.getClass();
            String optString36 = jSONObject.optString("googlePartners");
            optString36.getClass();
            String optString37 = jSONObject.optString("purposesLabel");
            optString37.getClass();
            String optString38 = jSONObject.optString("cookieMaxAgeLabel");
            optString38.getClass();
            String optString39 = jSONObject.optString("daysLabel");
            optString39.getClass();
            String optString40 = jSONObject.optString("secondsLabel");
            optString40.getClass();
            String optString41 = jSONObject.optString("cookieAccessLabel");
            optString41.getClass();
            String optString42 = jSONObject.optString("yesLabel");
            optString42.getClass();
            String optString43 = jSONObject.optString("noLabel");
            optString43.getClass();
            String optString44 = jSONObject.optString("storageDisclosureLabel");
            optString44.getClass();
            String optString45 = jSONObject.optString("dataRetentionDays");
            optString45.getClass();
            String optString46 = jSONObject.optString("legitimateInterestPrivacyLink");
            optString46.getClass();
            return new g(optString, optString2, optString3, optString4, optString5, q9, q10, q11, q12, q13, q14, optString6, optString7, optString8, optString9, optString10, optString11, optString12, optString13, optString14, optString15, optString16, optString17, optString18, optString19, optString20, optString21, optString22, optString23, optString24, optString25, optString26, optString27, optString28, optString29, optString30, optString31, optString32, optString33, optString34, optString35, optString36, optString37, optString38, optString39, optString40, optString41, optString42, optString43, optString44, optString45, optString46);
        } catch (JSONException unused) {
            return new g();
        }
    }
}
