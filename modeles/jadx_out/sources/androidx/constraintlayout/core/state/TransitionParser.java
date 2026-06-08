package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLContainer;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import androidx.lifecycle.l;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.lang.reflect.Array;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class TransitionParser {
    private static void map(TypedBundle typedBundle, int i, String str, String... strArr) {
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (strArr[i6].equals(str)) {
                typedBundle.add(i, i6);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void parse(@NonNull CLObject cLObject, @NonNull Transition transition) throws CLParsingException {
        transition.resetProperties();
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        TypedBundle typedBundle = new TypedBundle();
        boolean z9 = true;
        boolean z10 = false;
        if (stringOrNull != null) {
            switch (stringOrNull) {
                case "startVertical":
                    typedBundle.add(509, 1);
                    break;
                case "startHorizontal":
                    typedBundle.add(509, 2);
                    break;
                case "flip":
                    typedBundle.add(509, 3);
                    break;
                case "none":
                    typedBundle.add(509, 0);
                    break;
                case "above":
                    typedBundle.add(509, 5);
                    break;
                case "below":
                    typedBundle.add(509, 4);
                    break;
            }
            z10 = true;
        }
        String stringOrNull2 = cLObject.getStringOrNull("interpolator");
        if (stringOrNull2 != null) {
            typedBundle.add(TypedValues.TransitionType.TYPE_INTERPOLATOR, stringOrNull2);
            z10 = true;
        }
        float floatOrNaN = cLObject.getFloatOrNaN(TypedValues.TransitionType.S_STAGGERED);
        if (Float.isNaN(floatOrNaN)) {
            z9 = z10;
        } else {
            typedBundle.add(TypedValues.TransitionType.TYPE_STAGGERED, floatOrNaN);
        }
        if (z9) {
            transition.setTransitionProperties(typedBundle);
        }
        CLObject objectOrNull = cLObject.getObjectOrNull("onSwipe");
        if (objectOrNull != null) {
            parseOnSwipe(objectOrNull, transition);
        }
        parseKeyFrames(cLObject, transition);
    }

    private static void parseKeyAttribute(CLObject cLObject, Transition transition) throws CLParsingException {
        CLArray arrayOrNull;
        CustomVariable[][] customVariableArr;
        CLObject cLObject2;
        int i;
        String[] strArr;
        CLArray arrayOrNull2 = cLObject.getArrayOrNull(TypedValues.AttributesType.S_TARGET);
        if (arrayOrNull2 == null || (arrayOrNull = cLObject.getArrayOrNull("frames")) == null) {
            return;
        }
        String stringOrNull = cLObject.getStringOrNull("transitionEasing");
        String[] strArr2 = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"};
        int[] iArr = {311, 312, 304, 305, 306, 308, 309, 310, 303};
        boolean[] zArr = {false, false, true, true, true, false, false, false, false};
        int size = arrayOrNull.size();
        TypedBundle[] typedBundleArr = new TypedBundle[size];
        for (int i6 = 0; i6 < arrayOrNull.size(); i6++) {
            typedBundleArr[i6] = new TypedBundle();
        }
        int i10 = 0;
        for (int i11 = 9; i10 < i11; i11 = 9) {
            String str = strArr2[i10];
            int i12 = iArr[i10];
            boolean z9 = zArr[i10];
            CLArray arrayOrNull3 = cLObject.getArrayOrNull(str);
            if (arrayOrNull3 != null && arrayOrNull3.size() != size) {
                throw new CLParsingException(l.w("incorrect size for ", str, " array, not matching targets array!"), cLObject);
            }
            if (arrayOrNull3 != null) {
                int i13 = 0;
                while (i13 < size) {
                    float f = arrayOrNull3.getFloat(i13);
                    String[] strArr3 = strArr2;
                    if (z9) {
                        f = transition.mToPixel.toPixels(f);
                    }
                    typedBundleArr[i13].add(i12, f);
                    i13++;
                    strArr2 = strArr3;
                }
                strArr = strArr2;
            } else {
                strArr = strArr2;
                float floatOrNaN = cLObject.getFloatOrNaN(str);
                if (!Float.isNaN(floatOrNaN)) {
                    if (z9) {
                        floatOrNaN = transition.mToPixel.toPixels(floatOrNaN);
                    }
                    for (int i14 = 0; i14 < size; i14++) {
                        typedBundleArr[i14].add(i12, floatOrNaN);
                    }
                }
            }
            i10++;
            strArr2 = strArr;
        }
        int i15 = 0;
        CLElement orNull = cLObject.getOrNull("custom");
        if (orNull == null || !(orNull instanceof CLObject)) {
            customVariableArr = null;
        } else {
            CLObject cLObject3 = (CLObject) orNull;
            int size2 = cLObject3.size();
            customVariableArr = (CustomVariable[][]) Array.newInstance((Class<?>) CustomVariable.class, arrayOrNull.size(), size2);
            int i16 = 0;
            while (i16 < size2) {
                CLKey cLKey = (CLKey) cLObject3.get(i16);
                String content = cLKey.content();
                if (cLKey.getValue() instanceof CLArray) {
                    CLArray cLArray = (CLArray) cLKey.getValue();
                    int size3 = cLArray.size();
                    if (size3 == size && size3 > 0) {
                        int i17 = i15;
                        if (cLArray.get(i17) instanceof CLNumber) {
                            int i18 = i17;
                            while (i18 < size) {
                                customVariableArr[i18][i16] = new CustomVariable(content, TypedValues.Custom.TYPE_FLOAT, cLArray.get(i18).getFloat());
                                i18++;
                                cLObject3 = cLObject3;
                            }
                        } else {
                            cLObject2 = cLObject3;
                            int i19 = 0;
                            while (i19 < size) {
                                long parseColorString = ConstraintSetParser.parseColorString(cLArray.get(i19).content());
                                if (parseColorString != -1) {
                                    i = i19;
                                    customVariableArr[i19][i16] = new CustomVariable(content, TypedValues.Custom.TYPE_COLOR, (int) parseColorString);
                                } else {
                                    i = i19;
                                }
                                i19 = i + 1;
                            }
                        }
                    }
                    cLObject2 = cLObject3;
                } else {
                    cLObject2 = cLObject3;
                    CLElement value = cLKey.getValue();
                    if (value instanceof CLNumber) {
                        float f10 = value.getFloat();
                        for (int i20 = 0; i20 < size; i20++) {
                            customVariableArr[i20][i16] = new CustomVariable(content, TypedValues.Custom.TYPE_FLOAT, f10);
                        }
                    } else {
                        long parseColorString2 = ConstraintSetParser.parseColorString(value.content());
                        if (parseColorString2 != -1) {
                            int i21 = 0;
                            while (i21 < size) {
                                customVariableArr[i21][i16] = new CustomVariable(content, TypedValues.Custom.TYPE_COLOR, (int) parseColorString2);
                                i21++;
                                size2 = size2;
                                parseColorString2 = parseColorString2;
                            }
                        }
                    }
                }
                i16++;
                size2 = size2;
                cLObject3 = cLObject2;
                i15 = 0;
            }
        }
        String stringOrNull2 = cLObject.getStringOrNull("curveFit");
        for (int i22 = 0; i22 < arrayOrNull2.size(); i22++) {
            for (int i23 = 0; i23 < size; i23++) {
                String string = arrayOrNull2.getString(i22);
                TypedBundle typedBundle = typedBundleArr[i23];
                if (stringOrNull2 != null) {
                    typedBundle.add(TypedValues.PositionType.TYPE_CURVE_FIT, map(stringOrNull2, "spline", "linear"));
                }
                typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                typedBundle.add(100, arrayOrNull.getInt(i23));
                transition.addKeyAttribute(string, typedBundle, customVariableArr != null ? customVariableArr[i23] : null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseKeyCycle(androidx.constraintlayout.core.parser.CLObject r19, androidx.constraintlayout.core.state.Transition r20) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.TransitionParser.parseKeyCycle(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.Transition):void");
    }

    public static void parseKeyFrames(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject objectOrNull = cLObject.getObjectOrNull("KeyFrames");
        if (objectOrNull == null) {
            return;
        }
        CLArray arrayOrNull = objectOrNull.getArrayOrNull("KeyPositions");
        if (arrayOrNull != null) {
            for (int i = 0; i < arrayOrNull.size(); i++) {
                CLElement cLElement = arrayOrNull.get(i);
                if (cLElement instanceof CLObject) {
                    parseKeyPosition((CLObject) cLElement, transition);
                }
            }
        }
        CLArray arrayOrNull2 = objectOrNull.getArrayOrNull(TypedValues.AttributesType.NAME);
        if (arrayOrNull2 != null) {
            for (int i6 = 0; i6 < arrayOrNull2.size(); i6++) {
                CLElement cLElement2 = arrayOrNull2.get(i6);
                if (cLElement2 instanceof CLObject) {
                    parseKeyAttribute((CLObject) cLElement2, transition);
                }
            }
        }
        CLArray arrayOrNull3 = objectOrNull.getArrayOrNull("KeyCycles");
        if (arrayOrNull3 != null) {
            for (int i10 = 0; i10 < arrayOrNull3.size(); i10++) {
                CLElement cLElement3 = arrayOrNull3.get(i10);
                if (cLElement3 instanceof CLObject) {
                    parseKeyCycle((CLObject) cLElement3, transition);
                }
            }
        }
    }

    private static void parseKeyPosition(CLObject cLObject, Transition transition) throws CLParsingException {
        TypedBundle typedBundle = new TypedBundle();
        CLArray array = cLObject.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject.getArray("frames");
        CLArray arrayOrNull = cLObject.getArrayOrNull("percentX");
        CLArray arrayOrNull2 = cLObject.getArrayOrNull("percentY");
        CLArray arrayOrNull3 = cLObject.getArrayOrNull("percentWidth");
        CLArray arrayOrNull4 = cLObject.getArrayOrNull("percentHeight");
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        String stringOrNull2 = cLObject.getStringOrNull("transitionEasing");
        String stringOrNull3 = cLObject.getStringOrNull("curveFit");
        String stringOrNull4 = cLObject.getStringOrNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        if (stringOrNull4 == null) {
            stringOrNull4 = "parentRelative";
        }
        if (arrayOrNull == null || array2.size() == arrayOrNull.size()) {
            if (arrayOrNull2 == null || array2.size() == arrayOrNull2.size()) {
                int i = 0;
                while (i < array.size()) {
                    String string = array.getString(i);
                    int map = map(stringOrNull4, "deltaRelative", "pathRelative", "parentRelative");
                    typedBundle.clear();
                    typedBundle.add(TypedValues.PositionType.TYPE_POSITION_TYPE, map);
                    if (stringOrNull3 != null) {
                        map(typedBundle, TypedValues.PositionType.TYPE_CURVE_FIT, stringOrNull3, "spline", "linear");
                    }
                    typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull2);
                    if (stringOrNull != null) {
                        map(typedBundle, 509, stringOrNull, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                    }
                    int i6 = 0;
                    while (i6 < array2.size()) {
                        typedBundle.add(100, array2.getInt(i6));
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_X, arrayOrNull, i6);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_Y, arrayOrNull2, i6);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_WIDTH, arrayOrNull3, i6);
                        set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, arrayOrNull4, i6);
                        transition.addKeyPosition(string, typedBundle);
                        i6++;
                        stringOrNull4 = stringOrNull4;
                    }
                    i++;
                    stringOrNull4 = stringOrNull4;
                }
            }
        }
    }

    private static void parseOnSwipe(CLContainer cLContainer, Transition transition) {
        String stringOrNull = cLContainer.getStringOrNull("anchor");
        int map = map(cLContainer.getStringOrNull("side"), Transition.OnSwipe.SIDES);
        int map2 = map(cLContainer.getStringOrNull("direction"), Transition.OnSwipe.DIRECTIONS);
        float floatOrNaN = cLContainer.getFloatOrNaN("scale");
        float floatOrNaN2 = cLContainer.getFloatOrNaN("threshold");
        float floatOrNaN3 = cLContainer.getFloatOrNaN("maxVelocity");
        float floatOrNaN4 = cLContainer.getFloatOrNaN("maxAccel");
        String stringOrNull2 = cLContainer.getStringOrNull("limitBounds");
        int map3 = map(cLContainer.getStringOrNull("mode"), Transition.OnSwipe.MODE);
        int map4 = map(cLContainer.getStringOrNull("touchUp"), Transition.OnSwipe.TOUCH_UP);
        float floatOrNaN5 = cLContainer.getFloatOrNaN("springMass");
        float floatOrNaN6 = cLContainer.getFloatOrNaN("springStiffness");
        float floatOrNaN7 = cLContainer.getFloatOrNaN("springDamping");
        float floatOrNaN8 = cLContainer.getFloatOrNaN("stopThreshold");
        int map5 = map(cLContainer.getStringOrNull("springBoundary"), Transition.OnSwipe.BOUNDARY);
        String stringOrNull3 = cLContainer.getStringOrNull("around");
        Transition.OnSwipe createOnSwipe = transition.createOnSwipe();
        createOnSwipe.setAnchorId(stringOrNull);
        createOnSwipe.setAnchorSide(map);
        createOnSwipe.setDragDirection(map2);
        createOnSwipe.setDragScale(floatOrNaN);
        createOnSwipe.setDragThreshold(floatOrNaN2);
        createOnSwipe.setMaxVelocity(floatOrNaN3);
        createOnSwipe.setMaxAcceleration(floatOrNaN4);
        createOnSwipe.setLimitBoundsTo(stringOrNull2);
        createOnSwipe.setAutoCompleteMode(map3);
        createOnSwipe.setOnTouchUp(map4);
        createOnSwipe.setSpringMass(floatOrNaN5);
        createOnSwipe.setSpringStiffness(floatOrNaN6);
        createOnSwipe.setSpringDamping(floatOrNaN7);
        createOnSwipe.setSpringStopThreshold(floatOrNaN8);
        createOnSwipe.setSpringBoundary(map5);
        createOnSwipe.setRotationCenterId(stringOrNull3);
    }

    private static void set(TypedBundle typedBundle, int i, CLArray cLArray, int i6) throws CLParsingException {
        if (cLArray != null) {
            typedBundle.add(i, cLArray.getFloat(i6));
        }
    }

    private static int map(String str, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return 0;
    }

    @Deprecated
    public static void parse(CLObject cLObject, Transition transition, CorePixelDp corePixelDp) throws CLParsingException {
        parse(cLObject, transition);
    }
}
