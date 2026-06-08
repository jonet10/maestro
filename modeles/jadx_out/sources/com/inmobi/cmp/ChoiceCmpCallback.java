package com.inmobi.cmp;

import com.inmobi.cmp.core.model.ACData;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ActionButton;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.DisplayInfo;
import com.inmobi.cmp.model.NonIABData;
import com.inmobi.cmp.model.PingReturn;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface ChoiceCmpCallback {
    void onActionButtonClicked(ActionButton actionButton);

    void onCCPAConsentGiven(String str);

    void onCMPUIStatusChanged(DisplayInfo displayInfo);

    void onCmpError(ChoiceError choiceError);

    void onCmpLoaded(PingReturn pingReturn);

    void onGoogleBasicConsentChange(GoogleBasicConsents googleBasicConsents);

    void onGoogleVendorConsentGiven(ACData aCData);

    void onIABVendorConsentGiven(GDPRData gDPRData);

    void onNonIABVendorConsentGiven(NonIABData nonIABData);

    void onReceiveUSRegulationsConsent(USRegulationData uSRegulationData);

    void onUserMovedToOtherState();
}
