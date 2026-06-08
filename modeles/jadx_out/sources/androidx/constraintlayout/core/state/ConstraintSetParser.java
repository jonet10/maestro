package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.lifecycle.l;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ConstraintSetParser {
    private static final boolean PARSER_DEBUG = false;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class DesignElement {
        String mId;
        HashMap<String, String> mParams;
        String mType;

        public DesignElement(String str, String str2, HashMap<String, String> hashMap) {
            this.mId = str;
            this.mType = str2;
            this.mParams = hashMap;
        }

        public String getId() {
            return this.mId;
        }

        public HashMap<String, String> getParams() {
            return this.mParams;
        }

        public String getType() {
            return this.mType;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class FiniteGenerator implements GeneratedValue {
        float mFrom;
        float mInitial;
        float mMax;
        String mPostfix;
        String mPrefix;
        float mStep;
        float mTo;
        boolean mStop = false;
        float mCurrent = 0.0f;

        public FiniteGenerator(float f, float f10, float f11, String str, String str2) {
            this.mFrom = f;
            this.mTo = f10;
            this.mStep = f11;
            this.mPrefix = str == null ? "" : str;
            this.mPostfix = str2 == null ? "" : str2;
            this.mMax = f10;
            this.mInitial = f;
        }

        public ArrayList<String> array() {
            ArrayList<String> arrayList = new ArrayList<>();
            int i = (int) this.mInitial;
            int i6 = (int) this.mMax;
            int i10 = i;
            while (i <= i6) {
                arrayList.add(this.mPrefix + i10 + this.mPostfix);
                i10 += (int) this.mStep;
                i++;
            }
            return arrayList;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            float f = this.mCurrent;
            if (f >= this.mMax) {
                this.mStop = true;
            }
            if (!this.mStop) {
                this.mCurrent = f + this.mStep;
            }
            return this.mCurrent;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface GeneratedValue {
        float value();
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Generator implements GeneratedValue {
        float mCurrent;
        float mIncrementBy;
        float mStart;
        boolean mStop = false;

        public Generator(float f, float f10) {
            this.mStart = f;
            this.mIncrementBy = f10;
            this.mCurrent = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            if (!this.mStop) {
                this.mCurrent += this.mIncrementBy;
            }
            return this.mCurrent;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public enum MotionLayoutDebugFlags {
        NONE,
        SHOW_ALL,
        UNKNOWN
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class OverrideValue implements GeneratedValue {
        float mValue;

        public OverrideValue(float f) {
            this.mValue = f;
        }

        @Override // androidx.constraintlayout.core.state.ConstraintSetParser.GeneratedValue
        public float value() {
            return this.mValue;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0168, code lost:
    
        if (r8.equals("visible") == false) goto L107;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void applyAttribute(androidx.constraintlayout.core.state.State r8, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r9, androidx.constraintlayout.core.state.ConstraintReference r10, androidx.constraintlayout.core.parser.CLObject r11, java.lang.String r12) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 908
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.applyAttribute(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.parser.CLObject, java.lang.String):void");
    }

    private static int indexOf(String str, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static String lookForType(CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        int size = names.size();
        int i = 0;
        while (i < size) {
            String str = names.get(i);
            i++;
            if (str.equals(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                return cLObject.getString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            }
        }
        return null;
    }

    public static void override(CLObject cLObject, String str, CLObject cLObject2) throws CLParsingException {
        if (!cLObject.has(str)) {
            cLObject.put(str, cLObject2);
            return;
        }
        CLObject object = cLObject.getObject(str);
        ArrayList<String> names = cLObject2.names();
        int size = names.size();
        int i = 0;
        while (i < size) {
            String str2 = names.get(i);
            i++;
            String str3 = str2;
            if (str3.equals("clear")) {
                CLArray array = cLObject2.getArray("clear");
                for (int i6 = 0; i6 < array.size(); i6++) {
                    String stringOrNull = array.getStringOrNull(i6);
                    if (stringOrNull != null) {
                        switch (stringOrNull) {
                            case "transforms":
                                object.remove("visibility");
                                object.remove("alpha");
                                object.remove("pivotX");
                                object.remove("pivotY");
                                object.remove("rotationX");
                                object.remove("rotationY");
                                object.remove("rotationZ");
                                object.remove("scaleX");
                                object.remove("scaleY");
                                object.remove("translationX");
                                object.remove("translationY");
                                break;
                            case "constraints":
                                object.remove("start");
                                object.remove("end");
                                object.remove("top");
                                object.remove("bottom");
                                object.remove("baseline");
                                object.remove("center");
                                object.remove("centerHorizontally");
                                object.remove("centerVertically");
                                break;
                            case "dimensions":
                                object.remove("width");
                                object.remove("height");
                                break;
                            default:
                                object.remove(stringOrNull);
                                break;
                        }
                    }
                }
            } else {
                object.put(str3, cLObject2.get(str3));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00af, code lost:
    
        if (r5.equals("top") == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void parseBarrier(androidx.constraintlayout.core.state.State r10, java.lang.String r11, androidx.constraintlayout.core.parser.CLObject r12) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseBarrier(androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void parseChain(int r8, androidx.constraintlayout.core.state.State r9, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r10, androidx.constraintlayout.core.parser.CLArray r11) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            if (r8 != 0) goto L7
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r8 = r9.horizontalChain()
            goto Lb
        L7:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r8 = r9.verticalChain()
        Lb:
            r0 = 1
            androidx.constraintlayout.core.parser.CLElement r1 = r11.get(r0)
            boolean r2 = r1 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r2 == 0) goto Lae
            androidx.constraintlayout.core.parser.CLArray r1 = (androidx.constraintlayout.core.parser.CLArray) r1
            int r2 = r1.size()
            if (r2 >= r0) goto L1e
            goto Lae
        L1e:
            r2 = 0
            r3 = r2
        L20:
            int r4 = r1.size()
            if (r3 >= r4) goto L34
            java.lang.String r4 = r1.getString(r3)
            java.lang.Object[] r5 = new java.lang.Object[r0]
            r5[r2] = r4
            r8.add(r5)
            int r3 = r3 + 1
            goto L20
        L34:
            int r1 = r11.size()
            r3 = 2
            if (r1 <= r3) goto Lae
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get(r3)
            boolean r1 = r11 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r1 != 0) goto L44
            goto Lae
        L44:
            androidx.constraintlayout.core.parser.CLObject r11 = (androidx.constraintlayout.core.parser.CLObject) r11
            java.util.ArrayList r1 = r11.names()
            int r3 = r1.size()
            r4 = r2
        L4f:
            if (r4 >= r3) goto Lae
            java.lang.Object r5 = r1.get(r4)
            int r4 = r4 + 1
            java.lang.String r5 = (java.lang.String) r5
            r5.getClass()
            java.lang.String r6 = "style"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L68
            parseConstraint(r9, r10, r11, r8, r5)
            goto L4f
        L68:
            androidx.constraintlayout.core.parser.CLElement r5 = r11.get(r5)
            boolean r6 = r5 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r6 == 0) goto L85
            r6 = r5
            androidx.constraintlayout.core.parser.CLArray r6 = (androidx.constraintlayout.core.parser.CLArray) r6
            int r7 = r6.size()
            if (r7 <= r0) goto L85
            java.lang.String r5 = r6.getString(r2)
            float r6 = r6.getFloat(r0)
            r8.bias(r6)
            goto L89
        L85:
            java.lang.String r5 = r5.content()
        L89:
            r5.getClass()
            java.lang.String r6 = "packed"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto La8
            java.lang.String r6 = "spread_inside"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto La2
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r8.style(r5)
            goto L4f
        La2:
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r8.style(r5)
            goto L4f
        La8:
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r8.style(r5)
            goto L4f
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChain(int, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLArray):void");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseChainType(java.lang.String r21, androidx.constraintlayout.core.state.State r22, java.lang.String r23, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r24, androidx.constraintlayout.core.parser.CLObject r25) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChainType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    public static long parseColorString(String str) {
        if (!str.startsWith("#")) {
            return -1L;
        }
        String substring = str.substring(1);
        if (substring.length() == 6) {
            substring = "FF".concat(substring);
        }
        return Long.parseLong(substring, 16);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x00d0. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    public static void parseConstraint(State state, LayoutVariables layoutVariables, CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ConstraintReference constraints;
        char c9;
        boolean z9;
        char c10;
        boolean z10;
        boolean z11;
        ?? r16;
        boolean z12;
        boolean isRtl = state.isRtl();
        boolean z13 = !isRtl;
        CLArray arrayOrNull = cLObject.getArrayOrNull(str);
        if (arrayOrNull == null || arrayOrNull.size() <= 1) {
            String stringOrNull = cLObject.getStringOrNull(str);
            if (stringOrNull != null) {
                constraints = stringOrNull.equals("parent") ? state.constraints(State.PARENT) : state.constraints(stringOrNull);
                str.getClass();
                switch (str) {
                    case "baseline":
                        state.baselineNeededFor(constraintReference.getKey());
                        state.baselineNeededFor(constraints.getKey());
                        constraintReference.baselineToBaseline(constraints);
                        break;
                    case "bottom":
                        constraintReference.bottomToBottom(constraints);
                        break;
                    case "end":
                        if (!isRtl) {
                            constraintReference.rightToRight(constraints);
                            break;
                        } else {
                            constraintReference.leftToLeft(constraints);
                            break;
                        }
                    case "top":
                        constraintReference.topToTop(constraints);
                        break;
                    case "start":
                        if (!isRtl) {
                            constraintReference.leftToLeft(constraints);
                            break;
                        } else {
                            constraintReference.rightToRight(constraints);
                            break;
                        }
                }
            }
            return;
        }
        String string = arrayOrNull.getString(0);
        String stringOrNull2 = arrayOrNull.getStringOrNull(1);
        float pix = arrayOrNull.size() > 2 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(2))) : 0.0f;
        float pix2 = arrayOrNull.size() > 3 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(3))) : 0.0f;
        ConstraintReference constraints2 = string.equals("parent") ? state.constraints(State.PARENT) : state.constraints(string);
        str.getClass();
        float f = pix;
        switch (str.hashCode()) {
            case -1720785339:
                if (str.equals("baseline")) {
                    c9 = 0;
                    break;
                }
                c9 = 65535;
                break;
            case -1498085729:
                if (str.equals("circular")) {
                    c9 = 1;
                    break;
                }
                c9 = 65535;
                break;
            case -1383228885:
                if (str.equals("bottom")) {
                    c9 = 2;
                    break;
                }
                c9 = 65535;
                break;
            case 100571:
                if (str.equals("end")) {
                    c9 = 3;
                    break;
                }
                c9 = 65535;
                break;
            case 115029:
                if (str.equals("top")) {
                    c9 = 4;
                    break;
                }
                c9 = 65535;
                break;
            case 3317767:
                if (str.equals("left")) {
                    c9 = 5;
                    break;
                }
                c9 = 65535;
                break;
            case 108511772:
                if (str.equals("right")) {
                    c9 = 6;
                    break;
                }
                c9 = 65535;
                break;
            case 109757538:
                if (str.equals("start")) {
                    c9 = 7;
                    break;
                }
                c9 = 65535;
                break;
            default:
                c9 = 65535;
                break;
        }
        switch (c9) {
            case 0:
                z9 = true;
                c10 = 2;
                stringOrNull2.getClass();
                switch (stringOrNull2) {
                    case "baseline":
                        state.baselineNeededFor(constraintReference.getKey());
                        state.baselineNeededFor(constraints2.getKey());
                        constraintReference.baselineToBaseline(constraints2);
                        break;
                    case "bottom":
                        state.baselineNeededFor(constraintReference.getKey());
                        constraintReference.baselineToBottom(constraints2);
                        break;
                    case "top":
                        state.baselineNeededFor(constraintReference.getKey());
                        constraintReference.baselineToTop(constraints2);
                        break;
                }
                z10 = z9;
                z11 = false;
                break;
            case 1:
                z9 = true;
                c10 = 2;
                constraintReference.circularConstraint(constraints2, layoutVariables.get(arrayOrNull.get(1)), arrayOrNull.size() > 2 ? toPix(state, layoutVariables.get(arrayOrNull.getOrNull(2))) : 0.0f);
                z10 = z9;
                z11 = false;
                break;
            case 2:
                stringOrNull2.getClass();
                switch (stringOrNull2) {
                    case "baseline":
                        state.baselineNeededFor(constraints2.getKey());
                        constraintReference.bottomToBaseline(constraints2);
                        break;
                    case "bottom":
                        constraintReference.bottomToBottom(constraints2);
                        break;
                    case "top":
                        constraintReference.bottomToTop(constraints2);
                        break;
                }
                z9 = true;
                c10 = 2;
                z10 = z9;
                z11 = false;
                break;
            case 3:
                z10 = isRtl;
                z9 = true;
                c10 = 2;
                z11 = true;
                break;
            case 4:
                stringOrNull2.getClass();
                switch (stringOrNull2) {
                    case "baseline":
                        state.baselineNeededFor(constraints2.getKey());
                        constraintReference.topToBaseline(constraints2);
                        break;
                    case "bottom":
                        constraintReference.topToBottom(constraints2);
                        break;
                    case "top":
                        constraintReference.topToTop(constraints2);
                        break;
                }
                z9 = true;
                c10 = 2;
                z10 = z9;
                z11 = false;
                break;
            case 5:
                z10 = true;
                z9 = true;
                c10 = 2;
                z11 = true;
                break;
            case 6:
                z10 = false;
                z9 = true;
                c10 = 2;
                z11 = true;
                break;
            case 7:
                z10 = z13;
                z9 = true;
                c10 = 2;
                z11 = true;
                break;
            default:
                z9 = true;
                c10 = 2;
                z10 = z9;
                z11 = false;
                break;
        }
        if (z11) {
            stringOrNull2.getClass();
            switch (stringOrNull2.hashCode()) {
                case 100571:
                    if (stringOrNull2.equals("end")) {
                        r16 = 0;
                        break;
                    }
                    r16 = -1;
                    break;
                case 3317767:
                    if (stringOrNull2.equals("left")) {
                        r16 = z9;
                        break;
                    }
                    r16 = -1;
                    break;
                case 108511772:
                    if (stringOrNull2.equals("right")) {
                        r16 = c10;
                        break;
                    }
                    r16 = -1;
                    break;
                case 109757538:
                    if (stringOrNull2.equals("start")) {
                        r16 = 3;
                        break;
                    }
                    r16 = -1;
                    break;
                default:
                    r16 = -1;
                    break;
            }
            switch (r16) {
                case 0:
                    z12 = isRtl;
                    break;
                case 1:
                default:
                    z12 = z9;
                    break;
                case 2:
                    z12 = false;
                    break;
                case 3:
                    z12 = z13;
                    break;
            }
            if (z10) {
                if (z12) {
                    constraintReference.leftToLeft(constraints2);
                } else {
                    constraintReference.leftToRight(constraints2);
                }
            } else if (z12) {
                constraintReference.rightToLeft(constraints2);
            } else {
                constraintReference.rightToRight(constraints2);
            }
        }
        constraintReference.margin(Float.valueOf(f)).marginGone(Float.valueOf(pix2));
    }

    public static void parseConstraintSets(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        int size = names.size();
        int i = 0;
        while (i < size) {
            String str = names.get(i);
            i++;
            String str2 = str;
            CLObject object = cLObject.getObject(str2);
            String stringOrNull = object.getStringOrNull("Extends");
            if (stringOrNull == null || stringOrNull.isEmpty()) {
                coreMotionScene.setConstraintSetContent(str2, object.toJSON());
            } else {
                String constraintSet = coreMotionScene.getConstraintSet(stringOrNull);
                if (constraintSet != null) {
                    CLObject parse = CLParser.parse(constraintSet);
                    ArrayList<String> names2 = object.names();
                    if (names2 != null) {
                        int size2 = names2.size();
                        int i6 = 0;
                        while (i6 < size2) {
                            String str3 = names2.get(i6);
                            i6++;
                            String str4 = str3;
                            CLElement cLElement = object.get(str4);
                            if (cLElement instanceof CLObject) {
                                override(parse, str4, (CLObject) cLElement);
                            }
                        }
                        coreMotionScene.setConstraintSetContent(str2, parse.toJSON());
                    }
                }
            }
        }
    }

    public static void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ArrayList<String> names;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull == null || (names = objectOrNull.names()) == null) {
            return;
        }
        int size = names.size();
        int i = 0;
        while (i < size) {
            String str2 = names.get(i);
            i++;
            String str3 = str2;
            CLElement cLElement = objectOrNull.get(str3);
            if (cLElement instanceof CLNumber) {
                constraintReference.addCustomFloat(str3, cLElement.getFloat());
            } else if (cLElement instanceof CLString) {
                long parseColorString = parseColorString(cLElement.content());
                if (parseColorString != -1) {
                    constraintReference.addCustomColor(str3, (int) parseColorString);
                }
            }
        }
    }

    public static void parseDesignElementsJSON(String str, ArrayList<DesignElement> arrayList) throws CLParsingException {
        CLObject parse = CLParser.parse(str);
        ArrayList<String> names = parse.names();
        if (names != null && names.size() > 0) {
            String str2 = names.get(0);
            CLElement cLElement = parse.get(str2);
            str2.getClass();
            if (str2.equals("Design") && (cLElement instanceof CLObject)) {
                CLObject cLObject = (CLObject) cLElement;
                ArrayList<String> names2 = cLObject.names();
                for (int i = 0; i < names2.size(); i++) {
                    String str3 = names2.get(i);
                    CLObject cLObject2 = (CLObject) cLObject.get(str3);
                    System.out.printf(l.w("element found ", str3, ""), new Object[0]);
                    String stringOrNull = cLObject2.getStringOrNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    if (stringOrNull != null) {
                        HashMap hashMap = new HashMap();
                        int size = cLObject2.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            CLKey cLKey = (CLKey) cLObject2.get(i);
                            String content = cLKey.content();
                            String content2 = cLKey.getValue().content();
                            if (content2 != null) {
                                hashMap.put(content, content2);
                            }
                        }
                        arrayList.add(new DesignElement(str2, stringOrNull, hashMap));
                    }
                }
            }
        }
    }

    public static Dimension parseDimension(CLObject cLObject, String str, State state, CorePixelDp corePixelDp) throws CLParsingException {
        CLElement cLElement = cLObject.get(str);
        Dimension createFixed = Dimension.createFixed(0);
        if (cLElement instanceof CLString) {
            return parseDimensionMode(cLElement.content());
        }
        if (cLElement instanceof CLNumber) {
            return Dimension.createFixed(state.convertDimension(Float.valueOf(corePixelDp.toPixels(cLObject.getFloat(str)))));
        }
        if (cLElement instanceof CLObject) {
            CLObject cLObject2 = (CLObject) cLElement;
            String stringOrNull = cLObject2.getStringOrNull("value");
            if (stringOrNull != null) {
                createFixed = parseDimensionMode(stringOrNull);
            }
            CLElement orNull = cLObject2.getOrNull("min");
            if (orNull != null) {
                if (orNull instanceof CLNumber) {
                    createFixed.min(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull).getFloat()))));
                } else if (orNull instanceof CLString) {
                    createFixed.min(Dimension.WRAP_DIMENSION);
                }
            }
            CLElement orNull2 = cLObject2.getOrNull("max");
            if (orNull2 != null) {
                if (orNull2 instanceof CLNumber) {
                    createFixed.max(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull2).getFloat()))));
                    return createFixed;
                }
                if (orNull2 instanceof CLString) {
                    createFixed.max(Dimension.WRAP_DIMENSION);
                }
            }
        }
        return createFixed;
    }

    public static Dimension parseDimensionMode(String str) {
        Dimension createFixed;
        createFixed = Dimension.createFixed(0);
        str.getClass();
        switch (str) {
            case "preferWrap":
                return Dimension.createSuggested(Dimension.WRAP_DIMENSION);
            case "parent":
                return Dimension.createParent();
            case "spread":
                return Dimension.createSuggested(Dimension.SPREAD_DIMENSION);
            case "wrap":
                return Dimension.createWrap();
            default:
                return str.endsWith("%") ? Dimension.createPercent(0, Float.parseFloat(str.substring(0, str.indexOf(37))) / 100.0f).suggested(0) : str.contains(":") ? Dimension.createRatio(str).suggested(Dimension.SPREAD_DIMENSION) : createFixed;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(12:57|(2:59|(11:61|(1:63)(1:76)|64|65|(1:67)|68|(1:70)|71|72|73|14))|77|64|65|(0)|68|(0)|71|72|73|14) */
    /* JADX WARN: Removed duplicated region for block: B:102:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03d4 A[Catch: NumberFormatException -> 0x0266, TryCatch #0 {NumberFormatException -> 0x0266, blocks: (B:65:0x0241, B:67:0x0250, B:68:0x0257, B:70:0x025f, B:138:0x03c5, B:140:0x03d4, B:141:0x03db, B:143:0x03e3), top: B:64:0x0241 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03e3 A[Catch: NumberFormatException -> 0x0266, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0266, blocks: (B:65:0x0241, B:67:0x0250, B:68:0x0257, B:70:0x025f, B:138:0x03c5, B:140:0x03d4, B:141:0x03db, B:143:0x03e3), top: B:64:0x0241 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0250 A[Catch: NumberFormatException -> 0x0266, TryCatch #0 {NumberFormatException -> 0x0266, blocks: (B:65:0x0241, B:67:0x0250, B:68:0x0257, B:70:0x025f, B:138:0x03c5, B:140:0x03d4, B:141:0x03db, B:143:0x03e3), top: B:64:0x0241 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x025f A[Catch: NumberFormatException -> 0x0266, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0266, blocks: (B:65:0x0241, B:67:0x0250, B:68:0x0257, B:70:0x025f, B:138:0x03c5, B:140:0x03d4, B:141:0x03db, B:143:0x03e3), top: B:64:0x0241 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseFlowType(java.lang.String r19, androidx.constraintlayout.core.state.State r20, java.lang.String r21, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r22, androidx.constraintlayout.core.parser.CLObject r23) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 1256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseFlowType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    public static void parseGenerate(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        int size = names.size();
        int i = 0;
        while (i < size) {
            String str = names.get(i);
            i++;
            String str2 = str;
            CLElement cLElement = cLObject.get(str2);
            ArrayList<String> list = layoutVariables.getList(str2);
            if (list != null && (cLElement instanceof CLObject)) {
                int size2 = list.size();
                int i6 = 0;
                while (i6 < size2) {
                    String str3 = list.get(i6);
                    i6++;
                    parseWidget(state, layoutVariables, str3, (CLObject) cLElement);
                }
            }
        }
    }

    private static void parseGridType(String str, State state, String str2, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        String str3;
        float f;
        float f10;
        float f11;
        float f12;
        int i;
        CLElement cLElement;
        GridReference grid = state.getGrid(str2, str);
        ArrayList<String> names = cLObject.names();
        int size = names.size();
        int i6 = 0;
        while (i6 < size) {
            String str4 = names.get(i6);
            i6++;
            str3 = str4;
            str3.getClass();
            switch (str3) {
                case "orientation":
                    grid.setOrientation(cLObject.get(str3).getInt());
                    break;
                case "padding":
                    CLElement cLElement2 = cLObject.get(str3);
                    if (cLElement2 instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLElement2;
                        if (cLArray.size() > 1) {
                            f = cLArray.getInt(0);
                            f12 = cLArray.getInt(1);
                            if (cLArray.size() > 2) {
                                f11 = cLArray.getInt(2);
                                try {
                                    f10 = ((CLArray) cLElement2).getInt(3);
                                } catch (ArrayIndexOutOfBoundsException unused) {
                                    f10 = 0.0f;
                                }
                            } else {
                                f10 = f12;
                                f11 = f;
                            }
                            grid.setPaddingStart(Math.round(toPix(state, f)));
                            grid.setPaddingTop(Math.round(toPix(state, f12)));
                            grid.setPaddingEnd(Math.round(toPix(state, f11)));
                            grid.setPaddingBottom(Math.round(toPix(state, f10)));
                            break;
                        }
                    }
                    f = cLElement2.getInt();
                    f10 = f;
                    f11 = f10;
                    f12 = f11;
                    grid.setPaddingStart(Math.round(toPix(state, f)));
                    grid.setPaddingTop(Math.round(toPix(state, f12)));
                    grid.setPaddingEnd(Math.round(toPix(state, f11)));
                    grid.setPaddingBottom(Math.round(toPix(state, f10)));
                case "contains":
                    CLArray arrayOrNull = cLObject.getArrayOrNull(str3);
                    if (arrayOrNull != null) {
                        for (int i10 = 0; i10 < arrayOrNull.size(); i10++) {
                            grid.add(state.constraints(arrayOrNull.get(i10).content()));
                        }
                        break;
                    } else {
                        break;
                    }
                case "hGap":
                    grid.setHorizontalGaps(toPix(state, cLObject.get(str3).getFloat()));
                    break;
                case "rows":
                    int i11 = cLObject.get(str3).getInt();
                    if (i11 > 0) {
                        grid.setRowsSet(i11);
                        break;
                    } else {
                        break;
                    }
                case "vGap":
                    grid.setVerticalGaps(toPix(state, cLObject.get(str3).getFloat()));
                    break;
                case "flags":
                    String str5 = "";
                    try {
                        cLElement = cLObject.get(str3);
                    } catch (Exception e10) {
                        System.err.println("Error parsing grid flags " + e10);
                    }
                    if (cLElement instanceof CLNumber) {
                        i = cLElement.getInt();
                        if (str5 != null || str5.isEmpty()) {
                            grid.setFlags(i);
                            break;
                        } else {
                            grid.setFlags(str5);
                            break;
                        }
                    } else {
                        str5 = cLElement.content();
                        i = 0;
                        if (str5 != null) {
                        }
                        grid.setFlags(i);
                    }
                case "skips":
                    String content = cLObject.get(str3).content();
                    if (content != null && content.contains(":")) {
                        grid.setSkips(content);
                        break;
                    }
                    break;
                case "spans":
                    String content2 = cLObject.get(str3).content();
                    if (content2 != null && content2.contains(":")) {
                        grid.setSpans(content2);
                        break;
                    }
                    break;
                case "rowWeights":
                    String content3 = cLObject.get(str3).content();
                    if (content3 != null && content3.contains(",")) {
                        grid.setRowWeights(content3);
                        break;
                    }
                    break;
                case "columns":
                    int i12 = cLObject.get(str3).getInt();
                    if (i12 > 0) {
                        grid.setColumnsSet(i12);
                        break;
                    } else {
                        break;
                    }
                case "columnWeights":
                    String content4 = cLObject.get(str3).content();
                    if (content4 != null && content4.contains(",")) {
                        grid.setColumnWeights(content4);
                        break;
                    }
                    break;
                default:
                    applyAttribute(state, layoutVariables, state.constraints(str2), cLObject, str3);
                    break;
            }
        }
    }

    public static void parseGuideline(int i, State state, CLArray cLArray) throws CLParsingException {
        CLObject cLObject;
        String stringOrNull;
        CLElement cLElement = cLArray.get(1);
        if ((cLElement instanceof CLObject) && (stringOrNull = (cLObject = (CLObject) cLElement).getStringOrNull("id")) != null) {
            parseGuidelineParams(i, state, stringOrNull, cLObject);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void parseGuidelineParams(int i, State state, String str, CLObject cLObject) throws CLParsingException {
        char c9;
        float pix;
        char c10;
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        ConstraintReference constraints = state.constraints(str);
        if (i == 0) {
            state.horizontalGuideline(str);
        } else {
            state.verticalGuideline(str);
        }
        boolean z9 = !state.isRtl() || i == 0;
        GuidelineReference guidelineReference = (GuidelineReference) constraints.getFacade();
        int size = names.size();
        float f = 0.0f;
        boolean z10 = false;
        boolean z11 = true;
        int i6 = 0;
        while (i6 < size) {
            String str2 = names.get(i6);
            i6++;
            String str3 = str2;
            str3.getClass();
            switch (str3.hashCode()) {
                case -678927291:
                    if (str3.equals("percent")) {
                        c9 = 0;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 100571:
                    if (str3.equals("end")) {
                        c9 = 1;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 3317767:
                    if (str3.equals("left")) {
                        c9 = 2;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 108511772:
                    if (str3.equals("right")) {
                        c9 = 3;
                        break;
                    }
                    c9 = 65535;
                    break;
                case 109757538:
                    if (str3.equals("start")) {
                        c9 = 4;
                        break;
                    }
                    c9 = 65535;
                    break;
                default:
                    c9 = 65535;
                    break;
            }
            switch (c9) {
                case 0:
                    CLArray arrayOrNull = cLObject.getArrayOrNull(str3);
                    if (arrayOrNull != null) {
                        if (arrayOrNull.size() > 1) {
                            String string = arrayOrNull.getString(0);
                            float f10 = arrayOrNull.getFloat(1);
                            string.getClass();
                            switch (string.hashCode()) {
                                case 100571:
                                    if (string.equals("end")) {
                                        c10 = 0;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 3317767:
                                    if (string.equals("left")) {
                                        c10 = 1;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 108511772:
                                    if (string.equals("right")) {
                                        c10 = 2;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 109757538:
                                    if (string.equals("start")) {
                                        c10 = 3;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                default:
                                    c10 = 65535;
                                    break;
                            }
                            switch (c10) {
                                case 0:
                                    z11 = !z9;
                                    f = f10;
                                    break;
                                case 1:
                                    f = f10;
                                    z10 = true;
                                    z11 = true;
                                    break;
                                case 2:
                                    f = f10;
                                    z11 = false;
                                    break;
                                case 3:
                                    z11 = z9;
                                    f = f10;
                                    break;
                                default:
                                    f = f10;
                                    break;
                            }
                        }
                        z10 = true;
                        break;
                    } else {
                        f = cLObject.getFloat(str3);
                        z10 = true;
                        z11 = true;
                        break;
                    }
                case 1:
                    pix = toPix(state, cLObject.getFloat(str3));
                    z11 = !z9;
                    f = pix;
                    break;
                case 2:
                    f = toPix(state, cLObject.getFloat(str3));
                    z11 = true;
                    break;
                case 3:
                    f = toPix(state, cLObject.getFloat(str3));
                    z11 = false;
                    break;
                case 4:
                    pix = toPix(state, cLObject.getFloat(str3));
                    z11 = z9;
                    f = pix;
                    break;
            }
        }
        if (z10) {
            if (z11) {
                guidelineReference.percent(f);
                return;
            } else {
                guidelineReference.percent(1.0f - f);
                return;
            }
        }
        if (z11) {
            guidelineReference.start(Float.valueOf(f));
        } else {
            guidelineReference.end(Float.valueOf(f));
        }
    }

    public static void parseHeader(CoreMotionScene coreMotionScene, CLObject cLObject) {
        String stringOrNull = cLObject.getStringOrNull("export");
        if (stringOrNull != null) {
            coreMotionScene.setDebugName(stringOrNull);
        }
    }

    public static void parseHelpers(State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        for (int i = 0; i < cLArray.size(); i++) {
            CLElement cLElement = cLArray.get(i);
            if (cLElement instanceof CLArray) {
                CLArray cLArray2 = (CLArray) cLElement;
                if (cLArray2.size() > 1) {
                    String string = cLArray2.getString(0);
                    string.getClass();
                    switch (string) {
                        case "vGuideline":
                            parseGuideline(1, state, cLArray2);
                            break;
                        case "hChain":
                            parseChain(0, state, layoutVariables, cLArray2);
                            break;
                        case "vChain":
                            parseChain(1, state, layoutVariables, cLArray2);
                            break;
                        case "hGuideline":
                            parseGuideline(0, state, cLArray2);
                            break;
                    }
                }
            }
        }
    }

    public static void parseJSON(String str, Transition transition, int i) {
        CLObject objectOrNull;
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            int size = names.size();
            int i6 = 0;
            while (i6 < size) {
                String str2 = names.get(i6);
                i6++;
                String str3 = str2;
                CLElement cLElement = parse.get(str3);
                if ((cLElement instanceof CLObject) && (objectOrNull = ((CLObject) cLElement).getObjectOrNull("custom")) != null) {
                    ArrayList<String> names2 = objectOrNull.names();
                    int size2 = names2.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        String str4 = names2.get(i10);
                        i10++;
                        String str5 = str4;
                        CLElement cLElement2 = objectOrNull.get(str5);
                        if (cLElement2 instanceof CLNumber) {
                            transition.addCustomFloat(i, str3, str5, cLElement2.getFloat());
                        } else if (cLElement2 instanceof CLString) {
                            long parseColorString = parseColorString(cLElement2.content());
                            if (parseColorString != -1) {
                                transition.addCustomColor(i, str3, str5, (int) parseColorString);
                            }
                        }
                    }
                }
            }
        } catch (CLParsingException e10) {
            System.err.println("Error parsing JSON " + e10);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void parseMotionProperties(CLElement cLElement, ConstraintReference constraintReference) throws CLParsingException {
        char c9;
        if (cLElement instanceof CLObject) {
            CLObject cLObject = (CLObject) cLElement;
            TypedBundle typedBundle = new TypedBundle();
            ArrayList<String> names = cLObject.names();
            if (names == null) {
                return;
            }
            int size = names.size();
            int i = 0;
            while (i < size) {
                String str = names.get(i);
                i++;
                String str2 = str;
                str2.getClass();
                switch (str2.hashCode()) {
                    case -1897525331:
                        if (str2.equals("stagger")) {
                            c9 = 0;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case -1310311125:
                        if (str2.equals("easing")) {
                            c9 = 1;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case -1285003983:
                        if (str2.equals("quantize")) {
                            c9 = 2;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case -791482387:
                        if (str2.equals("pathArc")) {
                            c9 = 3;
                            break;
                        }
                        c9 = 65535;
                        break;
                    case -236944793:
                        if (str2.equals("relativeTo")) {
                            c9 = 4;
                            break;
                        }
                        c9 = 65535;
                        break;
                    default:
                        c9 = 65535;
                        break;
                }
                switch (c9) {
                    case 0:
                        typedBundle.add(600, cLObject.getFloat(str2));
                        break;
                    case 1:
                        typedBundle.add(TypedValues.MotionType.TYPE_EASING, cLObject.getString(str2));
                        break;
                    case 2:
                        CLElement cLElement2 = cLObject.get(str2);
                        if (!(cLElement2 instanceof CLArray)) {
                            typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLObject.getInt(str2));
                            break;
                        } else {
                            CLArray cLArray = (CLArray) cLElement2;
                            int size2 = cLArray.size();
                            if (size2 <= 0) {
                                break;
                            } else {
                                typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, cLArray.getInt(0));
                                if (size2 <= 1) {
                                    break;
                                } else {
                                    typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE, cLArray.getString(1));
                                    if (size2 <= 2) {
                                        break;
                                    } else {
                                        typedBundle.add(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, cLArray.getFloat(2));
                                        break;
                                    }
                                }
                            }
                        }
                    case 3:
                        String string = cLObject.getString(str2);
                        int indexOf = indexOf(string, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                        if (indexOf != -1) {
                            typedBundle.add(TypedValues.MotionType.TYPE_PATHMOTION_ARC, indexOf);
                            break;
                        } else {
                            System.err.println(cLObject.getLine() + " pathArc = '" + string + "'");
                            break;
                        }
                    case 4:
                        typedBundle.add(TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, cLObject.getString(str2));
                        break;
                }
            }
            constraintReference.mMotionProperties = typedBundle;
        }
    }

    public static void parseMotionSceneJSON(CoreMotionScene coreMotionScene, String str) {
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names == null) {
                return;
            }
            int size = names.size();
            int i = 0;
            while (i < size) {
                String str2 = names.get(i);
                i++;
                String str3 = str2;
                CLElement cLElement = parse.get(str3);
                if (cLElement instanceof CLObject) {
                    CLObject cLObject = (CLObject) cLElement;
                    int hashCode = str3.hashCode();
                    if (hashCode != -2137403731) {
                        if (hashCode != -241441378) {
                            if (hashCode == 1101852654 && str3.equals("ConstraintSets")) {
                                parseConstraintSets(coreMotionScene, cLObject);
                            }
                        } else if (str3.equals(TypedValues.TransitionType.NAME)) {
                            parseTransitions(coreMotionScene, cLObject);
                        }
                    } else if (str3.equals("Header")) {
                        parseHeader(coreMotionScene, cLObject);
                    }
                }
            }
        } catch (CLParsingException e10) {
            System.err.println("Error parsing JSON " + e10);
        }
    }

    public static void parseTransitions(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        int size = names.size();
        int i = 0;
        while (i < size) {
            String str = names.get(i);
            i++;
            String str2 = str;
            coreMotionScene.setTransitionContent(str2, cLObject.getObject(str2).toJSON());
        }
    }

    private static void parseVariables(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        int size = names.size();
        int i = 0;
        while (i < size) {
            String str = names.get(i);
            i++;
            String str2 = str;
            CLElement cLElement = cLObject.get(str2);
            if (cLElement instanceof CLNumber) {
                layoutVariables.put(str2, cLElement.getInt());
            } else if (cLElement instanceof CLObject) {
                CLObject cLObject2 = (CLObject) cLElement;
                if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has(TypedValues.TransitionType.S_TO)) {
                    layoutVariables.put(str2, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_TO)), 1.0f, cLObject2.getStringOrNull("prefix"), cLObject2.getStringOrNull("postfix"));
                } else if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("step")) {
                    layoutVariables.put(str2, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get("step")));
                } else if (cLObject2.has("ids")) {
                    CLArray array = cLObject2.getArray("ids");
                    ArrayList<String> arrayList = new ArrayList<>();
                    for (int i6 = 0; i6 < array.size(); i6++) {
                        arrayList.add(array.getString(i6));
                    }
                    layoutVariables.put(str2, arrayList);
                } else if (cLObject2.has("tag")) {
                    layoutVariables.put(str2, state.getIdsForTag(cLObject2.getString("tag")));
                }
            }
        }
    }

    public static void parseWidget(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject) throws CLParsingException {
        if (constraintReference.getWidth() == null) {
            constraintReference.setWidth(Dimension.createWrap());
        }
        if (constraintReference.getHeight() == null) {
            constraintReference.setHeight(Dimension.createWrap());
        }
        ArrayList<String> names = cLObject.names();
        if (names == null) {
            return;
        }
        int size = names.size();
        int i = 0;
        while (i < size) {
            String str = names.get(i);
            i++;
            applyAttribute(state, layoutVariables, constraintReference, cLObject, str);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00bb, code lost:
    
        if (r6.equals("hChain") == false) goto L29;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void populateState(@androidx.annotation.NonNull androidx.constraintlayout.core.parser.CLObject r11, @androidx.annotation.NonNull androidx.constraintlayout.core.state.State r12, @androidx.annotation.NonNull androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r13) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.populateState(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables):void");
    }

    private static float toPix(State state, float f) {
        return state.getDpToPixel().toPixels(f);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class LayoutVariables {
        HashMap<String, Integer> mMargins = new HashMap<>();
        HashMap<String, GeneratedValue> mGenerators = new HashMap<>();
        HashMap<String, ArrayList<String>> mArrayIds = new HashMap<>();

        public float get(Object obj) {
            if (!(obj instanceof CLString)) {
                if (obj instanceof CLNumber) {
                    return ((CLNumber) obj).getFloat();
                }
                return 0.0f;
            }
            String content = ((CLString) obj).content();
            if (this.mGenerators.containsKey(content)) {
                return this.mGenerators.get(content).value();
            }
            if (this.mMargins.containsKey(content)) {
                return this.mMargins.get(content).floatValue();
            }
            return 0.0f;
        }

        public ArrayList<String> getList(String str) {
            if (this.mArrayIds.containsKey(str)) {
                return this.mArrayIds.get(str);
            }
            return null;
        }

        public void put(String str, float f, float f10, float f11, String str2, String str3) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            FiniteGenerator finiteGenerator = new FiniteGenerator(f, f10, f11, str2, str3);
            this.mGenerators.put(str, finiteGenerator);
            this.mArrayIds.put(str, finiteGenerator.array());
        }

        public void putOverride(String str, float f) {
            this.mGenerators.put(str, new OverrideValue(f));
        }

        public void put(String str, float f, float f10) {
            if (this.mGenerators.containsKey(str) && (this.mGenerators.get(str) instanceof OverrideValue)) {
                return;
            }
            this.mGenerators.put(str, new Generator(f, f10));
        }

        public void put(String str, int i) {
            this.mMargins.put(str, Integer.valueOf(i));
        }

        public void put(String str, ArrayList<String> arrayList) {
            this.mArrayIds.put(str, arrayList);
        }
    }

    public static void parseWidget(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) throws CLParsingException {
        parseWidget(state, layoutVariables, state.constraints(str), cLObject);
    }

    public static void parseJSON(String str, State state, LayoutVariables layoutVariables) throws CLParsingException {
        try {
            populateState(CLParser.parse(str), state, layoutVariables);
        } catch (CLParsingException e10) {
            System.err.println("Error parsing JSON " + e10);
        }
    }
}
