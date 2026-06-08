package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class e implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2988a;

    public /* synthetic */ e(int i) {
        this.f2988a = i;
    }

    public /* synthetic */ Function andThen(Function function) {
        int i = this.f2988a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        TonalPalette tonalPalette;
        Double lambda$surfaceContainerLow$24;
        TonalPalette tonalPalette2;
        TonalPalette tonalPalette3;
        TonalPalette tonalPalette4;
        Double lambda$onTertiaryFixed$138;
        TonalPalette tonalPalette5;
        Double lambda$tertiaryPaletteKeyColor$5;
        TonalPalette tonalPalette6;
        Double lambda$controlHighlight$150;
        Double lambda$controlHighlight$151;
        Double lambda$textSecondaryAndTertiaryInverseDisabled$159;
        TonalPalette tonalPalette7;
        TonalPalette tonalPalette8;
        Double lambda$background$11;
        TonalPalette tonalPalette9;
        Double lambda$surfaceContainerHigh$28;
        TonalPalette tonalPalette10;
        Double lambda$onBackground$13;
        TonalPalette tonalPalette11;
        TonalPalette tonalPalette12;
        Double lambda$outlineVariant$45;
        TonalPalette tonalPalette13;
        Double lambda$surfaceBright$20;
        TonalPalette tonalPalette14;
        Double lambda$onPrimary$56;
        TonalPalette tonalPalette15;
        Double lambda$inversePrimary$65;
        Double lambda$onTertiary$83;
        TonalPalette tonalPalette16;
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f2988a) {
            case 0:
                tonalPalette = dynamicScheme.neutralPalette;
                return tonalPalette;
            case 1:
                lambda$surfaceContainerLow$24 = MaterialDynamicColors.lambda$surfaceContainerLow$24(dynamicScheme);
                return lambda$surfaceContainerLow$24;
            case 2:
                tonalPalette2 = dynamicScheme.secondaryPalette;
                return tonalPalette2;
            case 3:
                tonalPalette3 = dynamicScheme.neutralPalette;
                return tonalPalette3;
            case 4:
                tonalPalette4 = dynamicScheme.tertiaryPalette;
                return tonalPalette4;
            case 5:
                lambda$onTertiaryFixed$138 = MaterialDynamicColors.lambda$onTertiaryFixed$138(dynamicScheme);
                return lambda$onTertiaryFixed$138;
            case 6:
                tonalPalette5 = dynamicScheme.tertiaryPalette;
                return tonalPalette5;
            case 7:
                lambda$tertiaryPaletteKeyColor$5 = MaterialDynamicColors.lambda$tertiaryPaletteKeyColor$5(dynamicScheme);
                return lambda$tertiaryPaletteKeyColor$5;
            case 8:
                tonalPalette6 = dynamicScheme.neutralPalette;
                return tonalPalette6;
            case 9:
                lambda$controlHighlight$150 = MaterialDynamicColors.lambda$controlHighlight$150(dynamicScheme);
                return lambda$controlHighlight$150;
            case 10:
                lambda$controlHighlight$151 = MaterialDynamicColors.lambda$controlHighlight$151(dynamicScheme);
                return lambda$controlHighlight$151;
            case 11:
                lambda$textSecondaryAndTertiaryInverseDisabled$159 = MaterialDynamicColors.lambda$textSecondaryAndTertiaryInverseDisabled$159(dynamicScheme);
                return lambda$textSecondaryAndTertiaryInverseDisabled$159;
            case 12:
                tonalPalette7 = dynamicScheme.primaryPalette;
                return tonalPalette7;
            case 13:
                tonalPalette8 = dynamicScheme.neutralPalette;
                return tonalPalette8;
            case 14:
                lambda$background$11 = MaterialDynamicColors.lambda$background$11(dynamicScheme);
                return lambda$background$11;
            case 15:
                tonalPalette9 = dynamicScheme.neutralPalette;
                return tonalPalette9;
            case 16:
                lambda$surfaceContainerHigh$28 = MaterialDynamicColors.lambda$surfaceContainerHigh$28(dynamicScheme);
                return lambda$surfaceContainerHigh$28;
            case 17:
                tonalPalette10 = dynamicScheme.neutralPalette;
                return tonalPalette10;
            case 18:
                lambda$onBackground$13 = MaterialDynamicColors.lambda$onBackground$13(dynamicScheme);
                return lambda$onBackground$13;
            case 19:
                tonalPalette11 = dynamicScheme.tertiaryPalette;
                return tonalPalette11;
            case 20:
                tonalPalette12 = dynamicScheme.neutralVariantPalette;
                return tonalPalette12;
            case 21:
                lambda$outlineVariant$45 = MaterialDynamicColors.lambda$outlineVariant$45(dynamicScheme);
                return lambda$outlineVariant$45;
            case 22:
                tonalPalette13 = dynamicScheme.neutralPalette;
                return tonalPalette13;
            case 23:
                lambda$surfaceBright$20 = MaterialDynamicColors.lambda$surfaceBright$20(dynamicScheme);
                return lambda$surfaceBright$20;
            case 24:
                tonalPalette14 = dynamicScheme.primaryPalette;
                return tonalPalette14;
            case 25:
                lambda$onPrimary$56 = MaterialDynamicColors.lambda$onPrimary$56(dynamicScheme);
                return lambda$onPrimary$56;
            case 26:
                tonalPalette15 = dynamicScheme.primaryPalette;
                return tonalPalette15;
            case 27:
                lambda$inversePrimary$65 = MaterialDynamicColors.lambda$inversePrimary$65(dynamicScheme);
                return lambda$inversePrimary$65;
            case 28:
                lambda$onTertiary$83 = MaterialDynamicColors.lambda$onTertiary$83(dynamicScheme);
                return lambda$onTertiary$83;
            default:
                tonalPalette16 = dynamicScheme.secondaryPalette;
                return tonalPalette16;
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i = this.f2988a;
        return Function$CC.$default$compose(this, function);
    }
}
