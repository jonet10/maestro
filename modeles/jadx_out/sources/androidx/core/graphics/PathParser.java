package androidx.core.graphics;

import a4.x;
import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.l;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c9, float[] fArr) {
        arrayList.add(new PathDataNode(c9, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i, int i6) {
        if (i > i6) {
            o.n();
            return null;
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i10 = i6 - i;
        int min = Math.min(i10, length - i);
        float[] fArr2 = new float[i10];
        System.arraycopy(fArr, i, fArr2, 0, min);
        return fArr2;
    }

    @NonNull
    public static PathDataNode[] createNodesFromPathData(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i6 = 1;
        while (i6 < str.length()) {
            int nextStart = nextStart(str, i6);
            String trim = str.substring(i, nextStart).trim();
            if (!trim.isEmpty()) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i = nextStart;
            i6 = nextStart + 1;
        }
        if (i6 - i == 1 && i < str.length()) {
            addNode(arrayList, str.charAt(i), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    @NonNull
    public static Path createPathFromPathData(@NonNull String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e10) {
            a.m(x.j("Error in parsing ", str), e10);
            return null;
        }
    }

    @NonNull
    public static PathDataNode[] deepCopyNodes(@NonNull PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039 A[LOOP:0: B:2:0x0007->B:14:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L36
        L27:
            r10.mEndWithNegOrDot = r7
        L29:
            r2 = r0
            r4 = r7
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.mEndWithNegOrDot = r7
            goto L29
        L33:
            r2 = r0
            goto L36
        L35:
            r2 = r7
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i6 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i10 = extractFloatResult.mEndPosition;
                if (i < i10) {
                    fArr[i6] = Float.parseFloat(str.substring(i, i10));
                    i6++;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i10 : i10 + 1;
            }
            return copyOfRange(fArr, 0, i6);
        } catch (NumberFormatException e10) {
            a.m(l.w("error in parsing \"", str, "\""), e10);
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static boolean interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr.length != pathDataNodeArr2.length || pathDataNodeArr2.length != pathDataNodeArr3.length) {
            com.google.gson.internal.a.p("The nodes to be interpolated and resulting nodes must have the same length");
            return false;
        }
        if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
        }
        return true;
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if ((charAt - 'Z') * (charAt - 'A') > 0) {
                if ((charAt - 'z') * (charAt - 'a') > 0) {
                    continue;
                    i++;
                }
            }
            if (charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
        float[] fArr = new float[6];
        char c9 = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c9, pathDataNode.mType, pathDataNode.mParams);
            c9 = pathDataNode.mType;
        }
    }

    public static void updateNodes(@NonNull PathDataNode[] pathDataNodeArr, @NonNull PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i6 = 0; i6 < pathDataNodeArr2[i].mParams.length; i6++) {
                pathDataNodeArr[i].mParams[i6] = pathDataNodeArr2[i].mParams[i6];
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c9, char c10, float[] fArr2) {
            int i;
            int i6;
            boolean z9;
            boolean z10;
            char c11;
            char c12;
            int i10;
            float f;
            boolean z11;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            boolean z12;
            float f15;
            float f16;
            float f17;
            float f18;
            float f19;
            float f20;
            float f21;
            float f22;
            float f23;
            float f24;
            Path path2 = path;
            boolean z13 = false;
            float f25 = fArr[0];
            boolean z14 = true;
            float f26 = fArr[1];
            char c13 = 2;
            float f27 = fArr[2];
            char c14 = 3;
            float f28 = fArr[3];
            float f29 = fArr[4];
            float f30 = fArr[5];
            switch (c10) {
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case 'a':
                    i = 7;
                    i6 = i;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                case 'c':
                    i = 6;
                    i6 = i;
                    break;
                case 'H':
                case 'V':
                case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                case 'v':
                    i6 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                case 't':
                default:
                    i6 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i6 = 4;
                    break;
                case SubsamplingScaleImageView.ORIENTATION_90 /* 90 */:
                case 'z':
                    path2.close();
                    path2.moveTo(f29, f30);
                    f25 = f29;
                    f27 = f25;
                    f26 = f30;
                    f28 = f26;
                    i6 = 2;
                    break;
            }
            float f31 = f25;
            float f32 = f26;
            float f33 = f29;
            float f34 = f30;
            int i11 = 0;
            char c15 = c9;
            while (i11 < fArr2.length) {
                if (c10 == 'A') {
                    float f35 = f31;
                    float f36 = f32;
                    z9 = z13;
                    z10 = z14;
                    c11 = c13;
                    c12 = c14;
                    i10 = i11;
                    int i12 = i10 + 5;
                    float f37 = fArr2[i12];
                    int i13 = i10 + 6;
                    float f38 = fArr2[i13];
                    float f39 = fArr2[i10];
                    float f40 = fArr2[i10 + 1];
                    float f41 = fArr2[i10 + 2];
                    if (fArr2[i10 + 3] != 0.0f) {
                        f = 0.0f;
                        z11 = z10;
                    } else {
                        f = 0.0f;
                        z11 = z9;
                    }
                    drawArc(path, f35, f36, f37, f38, f39, f40, f41, z11, fArr2[i10 + 4] != f ? z10 : z9);
                    f27 = fArr2[i12];
                    f31 = f27;
                    f28 = fArr2[i13];
                    f32 = f28;
                } else if (c10 == 'C') {
                    z9 = z13;
                    z10 = z14;
                    c11 = c13;
                    c12 = c14;
                    i10 = i11;
                    int i14 = i10 + 2;
                    int i15 = i10 + 3;
                    int i16 = i10 + 4;
                    int i17 = i10 + 5;
                    path2.cubicTo(fArr2[i10], fArr2[i10 + 1], fArr2[i14], fArr2[i15], fArr2[i16], fArr2[i17]);
                    float f42 = fArr2[i16];
                    float f43 = fArr2[i17];
                    float f44 = fArr2[i14];
                    float f45 = fArr2[i15];
                    f31 = f42;
                    f32 = f43;
                    f28 = f45;
                    f27 = f44;
                } else if (c10 != 'H') {
                    if (c10 != 'Q') {
                        z9 = z13;
                        if (c10 == 'V') {
                            z10 = z14;
                            c11 = c13;
                            c12 = c14;
                            i10 = i11;
                            path2.lineTo(f31, fArr2[i10]);
                            f12 = fArr2[i10];
                        } else if (c10 != 'a') {
                            if (c10 != 'c') {
                                z10 = z14;
                                if (c10 != 'h') {
                                    if (c10 != 'q') {
                                        c11 = c13;
                                        if (c10 != 'v') {
                                            if (c10 != 'L') {
                                                if (c10 != 'M') {
                                                    c12 = c14;
                                                    if (c10 == 'S') {
                                                        if (c15 == 'c' || c15 == 's' || c15 == 'C' || c15 == 'S') {
                                                            f31 = (f31 * 2.0f) - f27;
                                                            f32 = (f32 * 2.0f) - f28;
                                                        }
                                                        float f46 = f31;
                                                        float f47 = f32;
                                                        int i18 = i11 + 1;
                                                        int i19 = i11 + 2;
                                                        int i20 = i11 + 3;
                                                        path2.cubicTo(f46, f47, fArr2[i11], fArr2[i18], fArr2[i19], fArr2[i20]);
                                                        f10 = fArr2[i11];
                                                        f11 = fArr2[i18];
                                                        f31 = fArr2[i19];
                                                        f32 = fArr2[i20];
                                                        i10 = i11;
                                                    } else if (c10 == 'T') {
                                                        if (c15 == 'q' || c15 == 't' || c15 == 'Q' || c15 == 'T') {
                                                            f31 = (f31 * 2.0f) - f27;
                                                            f32 = (f32 * 2.0f) - f28;
                                                        }
                                                        int i21 = i11 + 1;
                                                        path2.quadTo(f31, f32, fArr2[i11], fArr2[i21]);
                                                        float f48 = fArr2[i11];
                                                        f12 = fArr2[i21];
                                                        f27 = f31;
                                                        f28 = f32;
                                                        i10 = i11;
                                                        f31 = f48;
                                                    } else if (c10 == 'l') {
                                                        int i22 = i11 + 1;
                                                        path2.rLineTo(fArr2[i11], fArr2[i22]);
                                                        f31 += fArr2[i11];
                                                        f18 = fArr2[i22];
                                                    } else if (c10 == 'm') {
                                                        float f49 = fArr2[i11];
                                                        f31 += f49;
                                                        float f50 = fArr2[i11 + 1];
                                                        f32 += f50;
                                                        if (i11 > 0) {
                                                            path2.rLineTo(f49, f50);
                                                        } else {
                                                            path2.rMoveTo(f49, f50);
                                                            f33 = f31;
                                                        }
                                                    } else if (c10 == 's') {
                                                        if (c15 == 'c' || c15 == 's' || c15 == 'C' || c15 == 'S') {
                                                            f21 = f32 - f28;
                                                            f22 = f31 - f27;
                                                        } else {
                                                            f22 = 0.0f;
                                                            f21 = 0.0f;
                                                        }
                                                        int i23 = i11 + 1;
                                                        int i24 = i11 + 2;
                                                        int i25 = i11 + 3;
                                                        path2.rCubicTo(f22, f21, fArr2[i11], fArr2[i23], fArr2[i24], fArr2[i25]);
                                                        f15 = fArr2[i11] + f31;
                                                        f16 = fArr2[i23] + f32;
                                                        f31 += fArr2[i24];
                                                        f17 = fArr2[i25];
                                                    } else if (c10 == 't') {
                                                        if (c15 == 'q' || c15 == 't' || c15 == 'Q' || c15 == 'T') {
                                                            f23 = f31 - f27;
                                                            f24 = f32 - f28;
                                                        } else {
                                                            f24 = 0.0f;
                                                            f23 = 0.0f;
                                                        }
                                                        int i26 = i11 + 1;
                                                        path2.rQuadTo(f23, f24, fArr2[i11], fArr2[i26]);
                                                        float f51 = f23 + f31;
                                                        float f52 = f24 + f32;
                                                        f31 += fArr2[i11];
                                                        f32 += fArr2[i26];
                                                        f28 = f52;
                                                        f27 = f51;
                                                    }
                                                } else {
                                                    c12 = c14;
                                                    f19 = fArr2[i11];
                                                    f20 = fArr2[i11 + 1];
                                                    if (i11 > 0) {
                                                        path2.lineTo(f19, f20);
                                                    } else {
                                                        path2.moveTo(f19, f20);
                                                        f31 = f19;
                                                        f33 = f31;
                                                        f32 = f20;
                                                    }
                                                }
                                                f34 = f32;
                                            } else {
                                                c12 = c14;
                                                int i27 = i11 + 1;
                                                path2.lineTo(fArr2[i11], fArr2[i27]);
                                                f19 = fArr2[i11];
                                                f20 = fArr2[i27];
                                            }
                                            f31 = f19;
                                            f32 = f20;
                                        } else {
                                            c12 = c14;
                                            path2.rLineTo(0.0f, fArr2[i11]);
                                            f18 = fArr2[i11];
                                        }
                                        f32 += f18;
                                    } else {
                                        c11 = c13;
                                        c12 = c14;
                                        int i28 = i11 + 1;
                                        int i29 = i11 + 2;
                                        int i30 = i11 + 3;
                                        path2.rQuadTo(fArr2[i11], fArr2[i28], fArr2[i29], fArr2[i30]);
                                        f15 = fArr2[i11] + f31;
                                        f16 = fArr2[i28] + f32;
                                        f31 += fArr2[i29];
                                        f17 = fArr2[i30];
                                    }
                                    f32 += f17;
                                    f27 = f15;
                                    f28 = f16;
                                } else {
                                    c11 = c13;
                                    c12 = c14;
                                    path2.rLineTo(fArr2[i11], 0.0f);
                                    f31 += fArr2[i11];
                                }
                            } else {
                                z10 = z14;
                                c11 = c13;
                                c12 = c14;
                                int i31 = i11 + 2;
                                int i32 = i11 + 3;
                                int i33 = i11 + 4;
                                int i34 = i11 + 5;
                                path2.rCubicTo(fArr2[i11], fArr2[i11 + 1], fArr2[i31], fArr2[i32], fArr2[i33], fArr2[i34]);
                                float f53 = fArr2[i31] + f31;
                                float f54 = fArr2[i32] + f32;
                                f31 += fArr2[i33];
                                f32 += fArr2[i34];
                                f27 = f53;
                                f28 = f54;
                            }
                            i10 = i11;
                        } else {
                            z10 = z14;
                            c11 = c13;
                            c12 = c14;
                            int i35 = i11 + 5;
                            float f55 = fArr2[i35] + f31;
                            int i36 = i11 + 6;
                            float f56 = fArr2[i36] + f32;
                            float f57 = fArr2[i11];
                            float f58 = fArr2[i11 + 1];
                            float f59 = fArr2[i11 + 2];
                            if (fArr2[i11 + 3] != 0.0f) {
                                f13 = 0.0f;
                                f14 = f32;
                                z12 = z10;
                            } else {
                                f13 = 0.0f;
                                f14 = f32;
                                z12 = z9;
                            }
                            i10 = i11;
                            boolean z15 = fArr2[i11 + 4] != f13 ? z10 : z9;
                            float f60 = f31;
                            drawArc(path, f60, f14, f55, f56, f57, f58, f59, z12, z15);
                            f31 = f60 + fArr2[i35];
                            f32 = f14 + fArr2[i36];
                            f27 = f31;
                            f28 = f32;
                        }
                        f32 = f12;
                    } else {
                        z9 = z13;
                        z10 = z14;
                        c11 = c13;
                        c12 = c14;
                        i10 = i11;
                        int i37 = i10 + 1;
                        int i38 = i10 + 2;
                        int i39 = i10 + 3;
                        path2.quadTo(fArr2[i10], fArr2[i37], fArr2[i38], fArr2[i39]);
                        f10 = fArr2[i10];
                        f11 = fArr2[i37];
                        f31 = fArr2[i38];
                        f32 = fArr2[i39];
                    }
                    f27 = f10;
                    f28 = f11;
                } else {
                    z9 = z13;
                    z10 = z14;
                    c11 = c13;
                    c12 = c14;
                    i10 = i11;
                    path2.lineTo(fArr2[i10], f32);
                    f31 = fArr2[i10];
                }
                i11 = i10 + i6;
                path2 = path;
                c15 = c10;
                z13 = z9;
                z14 = z10;
                c13 = c11;
                c14 = c12;
            }
            fArr[z13 ? 1 : 0] = f31;
            fArr[z14 ? 1 : 0] = f32;
            fArr[c13] = f27;
            fArr[c14] = f28;
            fArr[4] = f33;
            fArr[5] = f34;
        }

        private static void arcToBezier(Path path, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
            double d19 = d12;
            int ceil = (int) Math.ceil(Math.abs((d18 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d16);
            double sin = Math.sin(d16);
            double cos2 = Math.cos(d17);
            double sin2 = Math.sin(d17);
            double d20 = -d19;
            double d21 = d20 * cos;
            double d22 = d13 * sin;
            double d23 = (d21 * sin2) - (d22 * cos2);
            double d24 = d20 * sin;
            double d25 = d13 * cos;
            double d26 = (cos2 * d25) + (sin2 * d24);
            double d27 = d18 / ceil;
            double d28 = d26;
            double d29 = d23;
            int i = 0;
            double d30 = d14;
            double d31 = d15;
            double d32 = d17;
            while (i < ceil) {
                double d33 = d32 + d27;
                double sin3 = Math.sin(d33);
                double cos3 = Math.cos(d33);
                double d34 = (((d19 * cos) * cos3) + d10) - (d22 * sin3);
                int i6 = i;
                double d35 = (d25 * sin3) + (d12 * sin * cos3) + d11;
                double d36 = (d21 * sin3) - (d22 * cos3);
                double d37 = (cos3 * d25) + (sin3 * d24);
                double d38 = d33 - d32;
                double tan = Math.tan(d38 / 2.0d);
                double sqrt = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d38)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d29 * sqrt) + d30), (float) ((d28 * sqrt) + d31), (float) (d34 - (sqrt * d36)), (float) (d35 - (sqrt * d37)), (float) d34, (float) d35);
                sin = sin;
                d27 = d27;
                d30 = d34;
                d24 = d24;
                cos = cos;
                d28 = d37;
                d29 = d36;
                d19 = d12;
                d31 = d35;
                i = i6 + 1;
                ceil = ceil;
                d32 = d33;
            }
        }

        private static void drawArc(Path path, float f, float f10, float f11, float f12, float f13, float f14, float f15, boolean z9, boolean z10) {
            double d10;
            double d11;
            double radians = Math.toRadians(f15);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d12 = f;
            double d13 = f10;
            double d14 = f13;
            double d15 = ((d13 * sin) + (d12 * cos)) / d14;
            double d16 = f14;
            double d17 = ((d13 * cos) + ((-f) * sin)) / d16;
            double d18 = f12;
            double d19 = ((d18 * sin) + (f11 * cos)) / d14;
            double d20 = ((d18 * cos) + ((-f11) * sin)) / d16;
            double d21 = d15 - d19;
            double d22 = d17 - d20;
            double d23 = (d15 + d19) / 2.0d;
            double d24 = (d17 + d20) / 2.0d;
            double d25 = (d22 * d22) + (d21 * d21);
            if (d25 == 0.0d) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d26 = (1.0d / d25) - 0.25d;
            if (d26 < 0.0d) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d25);
                float sqrt = (float) (Math.sqrt(d25) / 1.99999d);
                drawArc(path, f, f10, f11, f12, f13 * sqrt, sqrt * f14, f15, z9, z10);
                return;
            }
            double sqrt2 = Math.sqrt(d26);
            double d27 = sqrt2 * d21;
            double d28 = sqrt2 * d22;
            if (z9 == z10) {
                d10 = d23 - d28;
                d11 = d24 + d27;
            } else {
                d10 = d23 + d28;
                d11 = d24 - d27;
            }
            double atan2 = Math.atan2(d17 - d11, d15 - d10);
            double atan22 = Math.atan2(d20 - d11, d19 - d10) - atan2;
            if (z10 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d29 = d10 * d14;
            double d30 = d11 * d16;
            arcToBezier(path, (d29 * cos) - (d30 * sin), (d30 * cos) + (d29 * sin), d14, d16, d12, d13, radians, atan2, atan22);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static void nodesToPath(@NonNull PathDataNode[] pathDataNodeArr, @NonNull Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        @NonNull
        public float[] getParams() {
            return this.mParams;
        }

        public char getType() {
            return this.mType;
        }

        public void interpolatePathDataNode(@NonNull PathDataNode pathDataNode, @NonNull PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i >= fArr.length) {
                    return;
                }
                this.mParams[i] = (pathDataNode2.mParams[i] * f) + ((1.0f - f) * fArr[i]);
                i++;
            }
        }

        public PathDataNode(char c9, float[] fArr) {
            this.mType = c9;
            this.mParams = fArr;
        }
    }

    public static void interpolatePathDataNodes(@NonNull PathDataNode[] pathDataNodeArr, float f, @NonNull PathDataNode[] pathDataNodeArr2, @NonNull PathDataNode[] pathDataNodeArr3) {
        if (interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f)) {
            return;
        }
        com.google.gson.internal.a.p("Can't interpolate between two incompatible pathData");
    }
}
