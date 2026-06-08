package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.core.graphics.ColorUtils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    public CamColor(float f, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        this.mHue = f;
        this.mChroma = f10;
        this.mJ = f11;
        this.mQ = f12;
        this.mM = f13;
        this.mS = f14;
        this.mJstar = f15;
        this.mAstar = f16;
        this.mBstar = f17;
    }

    @Nullable
    private static CamColor findCamByJ(@FloatRange(from = 0.0d, to = 360.0d) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = 100.0d) float f11) {
        float f12 = 100.0f;
        float f13 = 1000.0f;
        float f14 = 0.0f;
        CamColor camColor = null;
        float f15 = 1000.0f;
        while (Math.abs(f14 - f12) > LIGHTNESS_SEARCH_ENDPOINT) {
            float f16 = ((f12 - f14) / 2.0f) + f14;
            int viewedInSrgb = fromJch(f16, f10, f).viewedInSrgb();
            float lStarFromInt = CamUtils.lStarFromInt(viewedInSrgb);
            float abs = Math.abs(f11 - lStarFromInt);
            if (abs < 0.2f) {
                CamColor fromColor = fromColor(viewedInSrgb);
                float distance = fromColor.distance(fromJch(fromColor.getJ(), fromColor.getChroma(), f));
                if (distance <= 1.0f) {
                    camColor = fromColor;
                    f13 = abs;
                    f15 = distance;
                }
            }
            if (f13 == 0.0f && f15 == 0.0f) {
                return camColor;
            }
            if (lStarFromInt < f11) {
                f14 = f16;
            } else {
                f12 = f16;
            }
        }
        return camColor;
    }

    @NonNull
    public static CamColor fromColor(@ColorInt int i) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        fromColorInViewingConditions(i, ViewingConditions.DEFAULT, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static void fromColorInViewingConditions(@ColorInt int i, @NonNull ViewingConditions viewingConditions, @Nullable @Size(7) float[] fArr, @NonNull @Size(3) float[] fArr2) {
        CamUtils.xyzFromInt(i, fArr2);
        float[][] fArr3 = CamUtils.XYZ_TO_CAM16RGB;
        float f = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f10 = fArr4[0] * f;
        float f11 = fArr2[1];
        float f12 = (fArr4[1] * f11) + f10;
        float f13 = fArr2[2];
        float f14 = (fArr4[2] * f13) + f12;
        float[] fArr5 = fArr3[1];
        float f15 = (fArr5[2] * f13) + (fArr5[1] * f11) + (fArr5[0] * f);
        float[] fArr6 = fArr3[2];
        float f16 = (f13 * fArr6[2]) + (f11 * fArr6[1]) + (f * fArr6[0]);
        float f17 = viewingConditions.getRgbD()[0] * f14;
        float f18 = viewingConditions.getRgbD()[1] * f15;
        float f19 = viewingConditions.getRgbD()[2] * f16;
        float pow = (float) Math.pow((Math.abs(f17) * viewingConditions.getFl()) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow((Math.abs(f18) * viewingConditions.getFl()) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((Math.abs(f19) * viewingConditions.getFl()) / 100.0d, 0.42d);
        float signum = ((Math.signum(f17) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f18) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f19) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d10 = signum3;
        float f20 = ((float) (((signum2 * (-12.0d)) + (signum * 11.0d)) + d10)) / 11.0f;
        float f21 = ((float) ((signum + signum2) - (d10 * 2.0d))) / 9.0f;
        float f22 = signum2 * 20.0f;
        float f23 = ((21.0f * signum3) + ((signum * 20.0f) + f22)) / 20.0f;
        float f24 = (((signum * 40.0f) + f22) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f21, f20)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f25 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((f24 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float aw = (viewingConditions.getAw() + 4.0f) * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(pow4 / 100.0f)) * viewingConditions.getFlRoot();
        float sqrt = ((float) Math.sqrt(pow4 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) atan2) < 20.14d ? atan2 + 360.0f : atan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((f21 * f21) + (f20 * f20)))) / (f23 + 0.305f), 0.9d));
        float flRoot = viewingConditions.getFlRoot() * sqrt;
        float sqrt2 = ((float) Math.sqrt((r6 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f26 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((0.0228f * flRoot) + 1.0f)) * 43.85965f;
        double d11 = f25;
        float cos = ((float) Math.cos(d11)) * log;
        float sin = log * ((float) Math.sin(d11));
        fArr2[0] = atan2;
        fArr2[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow4;
            fArr[1] = aw;
            fArr[2] = flRoot;
            fArr[3] = sqrt2;
            fArr[4] = f26;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    @NonNull
    private static CamColor fromJch(@FloatRange(from = 0.0d, to = 100.0d) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = 360.0d) float f11) {
        return fromJchInFrame(f, f10, f11, ViewingConditions.DEFAULT);
    }

    @NonNull
    private static CamColor fromJchInFrame(@FloatRange(from = 0.0d, to = 100.0d) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = 360.0d) float f11, ViewingConditions viewingConditions) {
        float aw = (viewingConditions.getAw() + 4.0f) * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(f / 100.0d)) * viewingConditions.getFlRoot();
        float flRoot = viewingConditions.getFlRoot() * f10;
        float sqrt = ((float) Math.sqrt(((f10 / ((float) Math.sqrt(r4))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f12 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float log = ((float) Math.log((flRoot * 0.0228d) + 1.0d)) * 43.85965f;
        double d10 = (3.1415927f * f11) / 180.0f;
        return new CamColor(f11, f10, f, aw, flRoot, sqrt, f12, ((float) Math.cos(d10)) * log, log * ((float) Math.sin(d10)));
    }

    public static void getM3HCTfromColor(@ColorInt int i, @NonNull @Size(3) float[] fArr) {
        fromColorInViewingConditions(i, ViewingConditions.DEFAULT, null, fArr);
        fArr[2] = CamUtils.lStarFromInt(i);
    }

    @ColorInt
    public static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = 100.0d) float f11, @NonNull ViewingConditions viewingConditions) {
        if (f10 < 1.0d || Math.round(f11) <= 0.0d || Math.round(f11) >= 100.0d) {
            return CamUtils.intFromLStar(f11);
        }
        float min = f < 0.0f ? 0.0f : Math.min(360.0f, f);
        CamColor camColor = null;
        boolean z9 = true;
        float f12 = 0.0f;
        float f13 = f10;
        while (Math.abs(f12 - f10) >= CHROMA_SEARCH_ENDPOINT) {
            CamColor findCamByJ = findCamByJ(min, f13, f11);
            if (!z9) {
                if (findCamByJ == null) {
                    f10 = f13;
                } else {
                    f12 = f13;
                    camColor = findCamByJ;
                }
                f13 = ((f10 - f12) / 2.0f) + f12;
            } else {
                if (findCamByJ != null) {
                    return findCamByJ.viewed(viewingConditions);
                }
                f13 = ((f10 - f12) / 2.0f) + f12;
                z9 = false;
            }
        }
        return camColor == null ? CamUtils.intFromLStar(f11) : camColor.viewed(viewingConditions);
    }

    public float distance(@NonNull CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((bStar * bStar) + (aStar * aStar) + (jStar * jStar)), 0.63d) * 1.41d);
    }

    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getAStar() {
        return this.mAstar;
    }

    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getBStar() {
        return this.mBstar;
    }

    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getChroma() {
        return this.mChroma;
    }

    @FloatRange(from = 0.0d, to = 360.0d, toInclusive = false)
    public float getHue() {
        return this.mHue;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    public float getJ() {
        return this.mJ;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    public float getJStar() {
        return this.mJstar;
    }

    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getM() {
        return this.mM;
    }

    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getQ() {
        return this.mQ;
    }

    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getS() {
        return this.mS;
    }

    @ColorInt
    public int viewed(@NonNull ViewingConditions viewingConditions) {
        float pow = (float) Math.pow(((((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) ? 0.0f : getChroma() / ((float) Math.sqrt(getJ() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        float cos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f;
        float aw = viewingConditions.getAw() * ((float) Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()));
        float nc = cos * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw / viewingConditions.getNbb();
        float sin = (float) Math.sin(hue);
        float cos2 = (float) Math.cos(hue);
        float f = (((0.305f + nbb) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (((11.0f * pow) * cos2) + (nc * 23.0f)));
        float f10 = cos2 * f;
        float f11 = f * sin;
        float f12 = nbb * 460.0f;
        float f13 = ((288.0f * f11) + ((451.0f * f10) + f12)) / 1403.0f;
        float f14 = ((f12 - (891.0f * f10)) - (261.0f * f11)) / 1403.0f;
        float f15 = ((f12 - (f10 * 220.0f)) - (f11 * 6300.0f)) / 1403.0f;
        float fl = (100.0f / viewingConditions.getFl()) * Math.signum(f13) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f13) * 27.13d) / (400.0d - Math.abs(f13))), 2.380952380952381d));
        float fl2 = (100.0f / viewingConditions.getFl()) * Math.signum(f14) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f14) * 27.13d) / (400.0d - Math.abs(f14))), 2.380952380952381d));
        float fl3 = (100.0f / viewingConditions.getFl()) * Math.signum(f15) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f15) * 27.13d) / (400.0d - Math.abs(f15))), 2.380952380952381d));
        float f16 = fl / viewingConditions.getRgbD()[0];
        float f17 = fl2 / viewingConditions.getRgbD()[1];
        float f18 = fl3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f19 = (fArr2[2] * f18) + (fArr2[1] * f17) + (fArr2[0] * f16);
        float[] fArr3 = fArr[1];
        float f20 = (fArr3[2] * f18) + (fArr3[1] * f17) + (fArr3[0] * f16);
        float[] fArr4 = fArr[2];
        return ColorUtils.XYZToColor(f19, f20, (f18 * fArr4[2]) + (f17 * fArr4[1]) + (f16 * fArr4[0]));
    }

    @ColorInt
    public int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    public static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = 100.0d) float f11) {
        return toColor(f, f10, f11, ViewingConditions.DEFAULT);
    }
}
