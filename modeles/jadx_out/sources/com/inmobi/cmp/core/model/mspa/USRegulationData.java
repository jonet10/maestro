package com.inmobi.cmp.core.model.mspa;

import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.i5;
import j8.e;
import java.util.List;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Keep
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class USRegulationData {
    private int additionalProcessingDataConsent;
    private String gppString;
    private List<Integer> knownChildSensitiveDataConsents;
    private int mspaCoveredTransaction;
    private int mspaOptOutOptionMode;
    private int mspaServiceProviderMode;
    private int personalDataConsents;
    private int processingNotice;
    private int saleOptOut;
    private int saleOptOutNotice;
    private int sensitiveDataLimitUseNotice;
    private List<Integer> sensitiveDataProcessing;
    private int sensitiveDataProcessingOptOutNotice;
    private int sharingNotice;
    private int sharingOptOut;
    private int sharingOptOutNotice;
    private int targetedAdvertisingOptOut;
    private int targetedAdvertisingOptOutNotice;
    private int version;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ USRegulationData(int r21, java.lang.String r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, java.util.List r33, java.util.List r34, int r35, int r36, int r37, int r38, int r39, int r40, kotlin.jvm.internal.g r41) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.core.model.mspa.USRegulationData.<init>(int, java.lang.String, int, int, int, int, int, int, int, int, int, int, java.util.List, java.util.List, int, int, int, int, int, int, kotlin.jvm.internal.g):void");
    }

    public static /* synthetic */ USRegulationData copy$default(USRegulationData uSRegulationData, int i, String str, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, List list, List list2, int i19, int i20, int i21, int i22, int i23, int i24, Object obj) {
        int i25;
        int i26;
        int i27 = (i24 & 1) != 0 ? uSRegulationData.version : i;
        String str2 = (i24 & 2) != 0 ? uSRegulationData.gppString : str;
        int i28 = (i24 & 4) != 0 ? uSRegulationData.sharingNotice : i6;
        int i29 = (i24 & 8) != 0 ? uSRegulationData.saleOptOutNotice : i10;
        int i30 = (i24 & 16) != 0 ? uSRegulationData.sharingOptOutNotice : i11;
        int i31 = (i24 & 32) != 0 ? uSRegulationData.targetedAdvertisingOptOutNotice : i12;
        int i32 = (i24 & 64) != 0 ? uSRegulationData.sensitiveDataProcessingOptOutNotice : i13;
        int i33 = (i24 & 128) != 0 ? uSRegulationData.sensitiveDataLimitUseNotice : i14;
        int i34 = (i24 & 256) != 0 ? uSRegulationData.processingNotice : i15;
        int i35 = (i24 & 512) != 0 ? uSRegulationData.saleOptOut : i16;
        int i36 = (i24 & 1024) != 0 ? uSRegulationData.sharingOptOut : i17;
        int i37 = (i24 & 2048) != 0 ? uSRegulationData.targetedAdvertisingOptOut : i18;
        List list3 = (i24 & 4096) != 0 ? uSRegulationData.sensitiveDataProcessing : list;
        List list4 = (i24 & 8192) != 0 ? uSRegulationData.knownChildSensitiveDataConsents : list2;
        int i38 = i27;
        int i39 = (i24 & 16384) != 0 ? uSRegulationData.personalDataConsents : i19;
        int i40 = (i24 & 32768) != 0 ? uSRegulationData.additionalProcessingDataConsent : i20;
        int i41 = (i24 & 65536) != 0 ? uSRegulationData.mspaCoveredTransaction : i21;
        int i42 = (i24 & 131072) != 0 ? uSRegulationData.mspaOptOutOptionMode : i22;
        if ((i24 & 262144) != 0) {
            i26 = i42;
            i25 = uSRegulationData.mspaServiceProviderMode;
        } else {
            i25 = i23;
            i26 = i42;
        }
        return uSRegulationData.copy(i38, str2, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, list3, list4, i39, i40, i41, i26, i25);
    }

    public final int component1() {
        return this.version;
    }

    public final int component10() {
        return this.saleOptOut;
    }

    public final int component11() {
        return this.sharingOptOut;
    }

    public final int component12() {
        return this.targetedAdvertisingOptOut;
    }

    public final List<Integer> component13() {
        return this.sensitiveDataProcessing;
    }

    public final List<Integer> component14() {
        return this.knownChildSensitiveDataConsents;
    }

    public final int component15() {
        return this.personalDataConsents;
    }

    public final int component16() {
        return this.additionalProcessingDataConsent;
    }

    public final int component17() {
        return this.mspaCoveredTransaction;
    }

    public final int component18() {
        return this.mspaOptOutOptionMode;
    }

    public final int component19() {
        return this.mspaServiceProviderMode;
    }

    public final String component2() {
        return this.gppString;
    }

    public final int component3() {
        return this.sharingNotice;
    }

    public final int component4() {
        return this.saleOptOutNotice;
    }

    public final int component5() {
        return this.sharingOptOutNotice;
    }

    public final int component6() {
        return this.targetedAdvertisingOptOutNotice;
    }

    public final int component7() {
        return this.sensitiveDataProcessingOptOutNotice;
    }

    public final int component8() {
        return this.sensitiveDataLimitUseNotice;
    }

    public final int component9() {
        return this.processingNotice;
    }

    public final USRegulationData copy(int i, String str, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, List<Integer> list, List<Integer> list2, int i19, int i20, int i21, int i22, int i23) {
        str.getClass();
        list.getClass();
        list2.getClass();
        return new USRegulationData(i, str, i6, i10, i11, i12, i13, i14, i15, i16, i17, i18, list, list2, i19, i20, i21, i22, i23);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof USRegulationData)) {
            return false;
        }
        USRegulationData uSRegulationData = (USRegulationData) obj;
        return this.version == uSRegulationData.version && l.a(this.gppString, uSRegulationData.gppString) && this.sharingNotice == uSRegulationData.sharingNotice && this.saleOptOutNotice == uSRegulationData.saleOptOutNotice && this.sharingOptOutNotice == uSRegulationData.sharingOptOutNotice && this.targetedAdvertisingOptOutNotice == uSRegulationData.targetedAdvertisingOptOutNotice && this.sensitiveDataProcessingOptOutNotice == uSRegulationData.sensitiveDataProcessingOptOutNotice && this.sensitiveDataLimitUseNotice == uSRegulationData.sensitiveDataLimitUseNotice && this.processingNotice == uSRegulationData.processingNotice && this.saleOptOut == uSRegulationData.saleOptOut && this.sharingOptOut == uSRegulationData.sharingOptOut && this.targetedAdvertisingOptOut == uSRegulationData.targetedAdvertisingOptOut && l.a(this.sensitiveDataProcessing, uSRegulationData.sensitiveDataProcessing) && l.a(this.knownChildSensitiveDataConsents, uSRegulationData.knownChildSensitiveDataConsents) && this.personalDataConsents == uSRegulationData.personalDataConsents && this.additionalProcessingDataConsent == uSRegulationData.additionalProcessingDataConsent && this.mspaCoveredTransaction == uSRegulationData.mspaCoveredTransaction && this.mspaOptOutOptionMode == uSRegulationData.mspaOptOutOptionMode && this.mspaServiceProviderMode == uSRegulationData.mspaServiceProviderMode;
    }

    public final int getAdditionalProcessingDataConsent() {
        return this.additionalProcessingDataConsent;
    }

    public final String getGppString() {
        return this.gppString;
    }

    public final List<Integer> getKnownChildSensitiveDataConsents() {
        return this.knownChildSensitiveDataConsents;
    }

    public final int getMspaCoveredTransaction() {
        return this.mspaCoveredTransaction;
    }

    public final int getMspaOptOutOptionMode() {
        return this.mspaOptOutOptionMode;
    }

    public final int getMspaServiceProviderMode() {
        return this.mspaServiceProviderMode;
    }

    public final int getPersonalDataConsents() {
        return this.personalDataConsents;
    }

    public final int getProcessingNotice() {
        return this.processingNotice;
    }

    public final int getSaleOptOut() {
        return this.saleOptOut;
    }

    public final int getSaleOptOutNotice() {
        return this.saleOptOutNotice;
    }

    public final int getSensitiveDataLimitUseNotice() {
        return this.sensitiveDataLimitUseNotice;
    }

    public final List<Integer> getSensitiveDataProcessing() {
        return this.sensitiveDataProcessing;
    }

    public final int getSensitiveDataProcessingOptOutNotice() {
        return this.sensitiveDataProcessingOptOutNotice;
    }

    public final int getSharingNotice() {
        return this.sharingNotice;
    }

    public final int getSharingOptOut() {
        return this.sharingOptOut;
    }

    public final int getSharingOptOutNotice() {
        return this.sharingOptOutNotice;
    }

    public final int getTargetedAdvertisingOptOut() {
        return this.targetedAdvertisingOptOut;
    }

    public final int getTargetedAdvertisingOptOutNotice() {
        return this.targetedAdvertisingOptOutNotice;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.mspaServiceProviderMode + ((this.mspaOptOutOptionMode + ((this.mspaCoveredTransaction + ((this.additionalProcessingDataConsent + ((this.personalDataConsents + e.a(e.a((this.targetedAdvertisingOptOut + ((this.sharingOptOut + ((this.saleOptOut + ((this.processingNotice + ((this.sensitiveDataLimitUseNotice + ((this.sensitiveDataProcessingOptOutNotice + ((this.targetedAdvertisingOptOutNotice + ((this.sharingOptOutNotice + ((this.saleOptOutNotice + ((this.sharingNotice + i5.b(this.version * 31, this.gppString)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31, this.sensitiveDataProcessing), this.knownChildSensitiveDataConsents)) * 31)) * 31)) * 31)) * 31);
    }

    public final void setAdditionalProcessingDataConsent(int i) {
        this.additionalProcessingDataConsent = i;
    }

    public final void setGppString(String str) {
        str.getClass();
        this.gppString = str;
    }

    public final void setKnownChildSensitiveDataConsents(List<Integer> list) {
        list.getClass();
        this.knownChildSensitiveDataConsents = list;
    }

    public final void setMspaCoveredTransaction(int i) {
        this.mspaCoveredTransaction = i;
    }

    public final void setMspaOptOutOptionMode(int i) {
        this.mspaOptOutOptionMode = i;
    }

    public final void setMspaServiceProviderMode(int i) {
        this.mspaServiceProviderMode = i;
    }

    public final void setPersonalDataConsents(int i) {
        this.personalDataConsents = i;
    }

    public final void setProcessingNotice(int i) {
        this.processingNotice = i;
    }

    public final void setSaleOptOut(int i) {
        this.saleOptOut = i;
    }

    public final void setSaleOptOutNotice(int i) {
        this.saleOptOutNotice = i;
    }

    public final void setSensitiveDataLimitUseNotice(int i) {
        this.sensitiveDataLimitUseNotice = i;
    }

    public final void setSensitiveDataProcessing(List<Integer> list) {
        list.getClass();
        this.sensitiveDataProcessing = list;
    }

    public final void setSensitiveDataProcessingOptOutNotice(int i) {
        this.sensitiveDataProcessingOptOutNotice = i;
    }

    public final void setSharingNotice(int i) {
        this.sharingNotice = i;
    }

    public final void setSharingOptOut(int i) {
        this.sharingOptOut = i;
    }

    public final void setSharingOptOutNotice(int i) {
        this.sharingOptOutNotice = i;
    }

    public final void setTargetedAdvertisingOptOut(int i) {
        this.targetedAdvertisingOptOut = i;
    }

    public final void setTargetedAdvertisingOptOutNotice(int i) {
        this.targetedAdvertisingOptOutNotice = i;
    }

    public final void setVersion(int i) {
        this.version = i;
    }

    public String toString() {
        return "USRegulationData(version=" + this.version + ", gppString=" + this.gppString + ", sharingNotice=" + this.sharingNotice + ", saleOptOutNotice=" + this.saleOptOutNotice + ", sharingOptOutNotice=" + this.sharingOptOutNotice + ", targetedAdvertisingOptOutNotice=" + this.targetedAdvertisingOptOutNotice + ", sensitiveDataProcessingOptOutNotice=" + this.sensitiveDataProcessingOptOutNotice + ", sensitiveDataLimitUseNotice=" + this.sensitiveDataLimitUseNotice + ", processingNotice=" + this.processingNotice + ", saleOptOut=" + this.saleOptOut + ", sharingOptOut=" + this.sharingOptOut + ", targetedAdvertisingOptOut=" + this.targetedAdvertisingOptOut + ", sensitiveDataProcessing=" + this.sensitiveDataProcessing + ", knownChildSensitiveDataConsents=" + this.knownChildSensitiveDataConsents + ", personalDataConsents=" + this.personalDataConsents + ", additionalProcessingDataConsent=" + this.additionalProcessingDataConsent + ", mspaCoveredTransaction=" + this.mspaCoveredTransaction + ", mspaOptOutOptionMode=" + this.mspaOptOutOptionMode + ", mspaServiceProviderMode=" + this.mspaServiceProviderMode + ')';
    }

    public USRegulationData(int i, String str, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, List<Integer> list, List<Integer> list2, int i19, int i20, int i21, int i22, int i23) {
        str.getClass();
        list.getClass();
        list2.getClass();
        this.version = i;
        this.gppString = str;
        this.sharingNotice = i6;
        this.saleOptOutNotice = i10;
        this.sharingOptOutNotice = i11;
        this.targetedAdvertisingOptOutNotice = i12;
        this.sensitiveDataProcessingOptOutNotice = i13;
        this.sensitiveDataLimitUseNotice = i14;
        this.processingNotice = i15;
        this.saleOptOut = i16;
        this.sharingOptOut = i17;
        this.targetedAdvertisingOptOut = i18;
        this.sensitiveDataProcessing = list;
        this.knownChildSensitiveDataConsents = list2;
        this.personalDataConsents = i19;
        this.additionalProcessingDataConsent = i20;
        this.mspaCoveredTransaction = i21;
        this.mspaOptOutOptionMode = i22;
        this.mspaServiceProviderMode = i23;
    }

    public USRegulationData() {
        this(0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 524287, null);
    }
}
