package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0031, code lost:
    
        if (r8 == 2) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x0035, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0047, code lost:
    
        if (r8 == 2) goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0257 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x049f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x04dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02ab A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0385 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:245:0x038f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x048f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ac  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r4v40, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.core.LinearSystem r38, int r39, int r40, androidx.constraintlayout.core.widgets.ChainHead r41) {
        /*
            Method dump skipped, instructions count: 1277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Chain.applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead):void");
    }

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int i6;
        ChainHead[] chainHeadArr;
        int i10;
        if (i == 0) {
            i6 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i10 = 0;
        } else {
            i6 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i10 = 2;
        }
        for (int i11 = 0; i11 < i6; i11++) {
            ChainHead chainHead = chainHeadArr[i11];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i10, chainHead);
            }
        }
    }
}
