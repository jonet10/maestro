package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class f implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2989a;

    public /* synthetic */ f(int i) {
        this.f2989a = i;
    }

    public /* synthetic */ Function andThen(Function function) {
        int i = this.f2989a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Double lambda$secondaryFixed$118;
        TonalPalette tonalPalette;
        Double lambda$onPrimaryFixedVariant$114;
        TonalPalette tonalPalette2;
        Double lambda$tertiaryFixedDim$135;
        TonalPalette tonalPalette3;
        Double lambda$onError$95;
        TonalPalette tonalPalette4;
        Double lambda$textPrimaryInverseDisableOnly$157;
        TonalPalette tonalPalette5;
        TonalPalette tonalPalette6;
        Double lambda$secondaryFixedDim$121;
        TonalPalette tonalPalette7;
        TonalPalette tonalPalette8;
        Double lambda$surfaceVariant$34;
        TonalPalette tonalPalette9;
        Double lambda$neutralVariantPaletteKeyColor$9;
        TonalPalette tonalPalette10;
        Double lambda$textHintInverse$161;
        TonalPalette tonalPalette11;
        Double lambda$shadow$47;
        TonalPalette tonalPalette12;
        Double lambda$onSurface$32;
        Double lambda$surfaceContainerHighest$30;
        TonalPalette tonalPalette13;
        Double lambda$primaryFixed$104;
        TonalPalette tonalPalette14;
        Double lambda$primaryFixedDim$107;
        TonalPalette tonalPalette15;
        switch (this.f2989a) {
            case 0:
                lambda$secondaryFixed$118 = MaterialDynamicColors.lambda$secondaryFixed$118((DynamicScheme) obj);
                return lambda$secondaryFixed$118;
            case 1:
                tonalPalette = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette;
            case 2:
                lambda$onPrimaryFixedVariant$114 = MaterialDynamicColors.lambda$onPrimaryFixedVariant$114((DynamicScheme) obj);
                return lambda$onPrimaryFixedVariant$114;
            case 3:
                tonalPalette2 = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette2;
            case 4:
                lambda$tertiaryFixedDim$135 = MaterialDynamicColors.lambda$tertiaryFixedDim$135((DynamicScheme) obj);
                return lambda$tertiaryFixedDim$135;
            case 5:
                tonalPalette3 = ((DynamicScheme) obj).errorPalette;
                return tonalPalette3;
            case 6:
                lambda$onError$95 = MaterialDynamicColors.lambda$onError$95((DynamicScheme) obj);
                return lambda$onError$95;
            case 7:
                tonalPalette4 = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette4;
            case 8:
                lambda$textPrimaryInverseDisableOnly$157 = MaterialDynamicColors.lambda$textPrimaryInverseDisableOnly$157((DynamicScheme) obj);
                return lambda$textPrimaryInverseDisableOnly$157;
            case 9:
                tonalPalette5 = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette5;
            case 10:
                tonalPalette6 = ((DynamicScheme) obj).secondaryPalette;
                return tonalPalette6;
            case 11:
                lambda$secondaryFixedDim$121 = MaterialDynamicColors.lambda$secondaryFixedDim$121((DynamicScheme) obj);
                return lambda$secondaryFixedDim$121;
            case 12:
                tonalPalette7 = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette7;
            case 13:
                tonalPalette8 = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette8;
            case 14:
                lambda$surfaceVariant$34 = MaterialDynamicColors.lambda$surfaceVariant$34((DynamicScheme) obj);
                return lambda$surfaceVariant$34;
            case 15:
                tonalPalette9 = ((DynamicScheme) obj).neutralVariantPalette;
                return tonalPalette9;
            case 16:
                lambda$neutralVariantPaletteKeyColor$9 = MaterialDynamicColors.lambda$neutralVariantPaletteKeyColor$9((DynamicScheme) obj);
                return lambda$neutralVariantPaletteKeyColor$9;
            case 17:
                tonalPalette10 = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette10;
            case 18:
                lambda$textHintInverse$161 = MaterialDynamicColors.lambda$textHintInverse$161((DynamicScheme) obj);
                return lambda$textHintInverse$161;
            case 19:
                tonalPalette11 = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette11;
            case 20:
                lambda$shadow$47 = MaterialDynamicColors.lambda$shadow$47((DynamicScheme) obj);
                return lambda$shadow$47;
            case 21:
                tonalPalette12 = ((DynamicScheme) obj).neutralPalette;
                return tonalPalette12;
            case 22:
                lambda$onSurface$32 = MaterialDynamicColors.lambda$onSurface$32((DynamicScheme) obj);
                return lambda$onSurface$32;
            case 23:
                lambda$surfaceContainerHighest$30 = MaterialDynamicColors.lambda$surfaceContainerHighest$30((DynamicScheme) obj);
                return lambda$surfaceContainerHighest$30;
            case 24:
                tonalPalette13 = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette13;
            case 25:
                lambda$primaryFixed$104 = MaterialDynamicColors.lambda$primaryFixed$104((DynamicScheme) obj);
                return lambda$primaryFixed$104;
            case 26:
                tonalPalette14 = ((DynamicScheme) obj).primaryPalette;
                return tonalPalette14;
            case 27:
                lambda$primaryFixedDim$107 = MaterialDynamicColors.lambda$primaryFixedDim$107((DynamicScheme) obj);
                return lambda$primaryFixedDim$107;
            case 28:
                tonalPalette15 = ((DynamicScheme) obj).tertiaryPalette;
                return tonalPalette15;
            default:
                return (Character) ((Object[]) obj)[0];
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i = this.f2989a;
        return Function$CC.$default$compose(this, function);
    }
}
