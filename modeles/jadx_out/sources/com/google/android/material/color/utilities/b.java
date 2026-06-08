package com.google.android.material.color.utilities;

import j$.util.function.Function$CC;
import java.util.function.Function;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class b implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2984a;

    public /* synthetic */ b(int i) {
        this.f2984a = i;
    }

    public /* synthetic */ Function andThen(Function function) {
        int i = this.f2984a;
        return Function$CC.$default$andThen(this, function);
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        TonalPalette tonalPalette;
        TonalPalette tonalPalette2;
        Double lambda$onSecondary$71;
        TonalPalette tonalPalette3;
        Double lambda$secondary$68;
        TonalPalette tonalPalette4;
        Double lambda$surfaceContainerLowest$22;
        TonalPalette tonalPalette5;
        Double lambda$outline$43;
        TonalPalette tonalPalette6;
        TonalPalette tonalPalette7;
        Double lambda$surfaceTint$51;
        TonalPalette tonalPalette8;
        Double lambda$onSecondaryFixed$124;
        TonalPalette tonalPalette9;
        Double lambda$inverseOnSurface$40;
        TonalPalette tonalPalette10;
        Double lambda$neutralPaletteKeyColor$7;
        TonalPalette tonalPalette11;
        TonalPalette tonalPalette12;
        Double lambda$onPrimaryFixed$110;
        TonalPalette tonalPalette13;
        TonalPalette tonalPalette14;
        Double lambda$error$92;
        TonalPalette tonalPalette15;
        Double lambda$textPrimaryInverse$153;
        TonalPalette tonalPalette16;
        Double lambda$surfaceContainer$26;
        TonalPalette tonalPalette17;
        Double lambda$onSurfaceVariant$36;
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (this.f2984a) {
            case 0:
                tonalPalette = dynamicScheme.neutralPalette;
                return tonalPalette;
            case 1:
                tonalPalette2 = dynamicScheme.secondaryPalette;
                return tonalPalette2;
            case 2:
                lambda$onSecondary$71 = MaterialDynamicColors.lambda$onSecondary$71(dynamicScheme);
                return lambda$onSecondary$71;
            case 3:
                tonalPalette3 = dynamicScheme.secondaryPalette;
                return tonalPalette3;
            case 4:
                lambda$secondary$68 = MaterialDynamicColors.lambda$secondary$68(dynamicScheme);
                return lambda$secondary$68;
            case 5:
                tonalPalette4 = dynamicScheme.neutralPalette;
                return tonalPalette4;
            case 6:
                lambda$surfaceContainerLowest$22 = MaterialDynamicColors.lambda$surfaceContainerLowest$22(dynamicScheme);
                return lambda$surfaceContainerLowest$22;
            case 7:
                tonalPalette5 = dynamicScheme.neutralVariantPalette;
                return tonalPalette5;
            case 8:
                lambda$outline$43 = MaterialDynamicColors.lambda$outline$43(dynamicScheme);
                return lambda$outline$43;
            case 9:
                tonalPalette6 = dynamicScheme.neutralPalette;
                return tonalPalette6;
            case 10:
                tonalPalette7 = dynamicScheme.primaryPalette;
                return tonalPalette7;
            case 11:
                lambda$surfaceTint$51 = MaterialDynamicColors.lambda$surfaceTint$51(dynamicScheme);
                return lambda$surfaceTint$51;
            case 12:
                tonalPalette8 = dynamicScheme.secondaryPalette;
                return tonalPalette8;
            case 13:
                lambda$onSecondaryFixed$124 = MaterialDynamicColors.lambda$onSecondaryFixed$124(dynamicScheme);
                return lambda$onSecondaryFixed$124;
            case 14:
                tonalPalette9 = dynamicScheme.neutralPalette;
                return tonalPalette9;
            case 15:
                lambda$inverseOnSurface$40 = MaterialDynamicColors.lambda$inverseOnSurface$40(dynamicScheme);
                return lambda$inverseOnSurface$40;
            case 16:
                tonalPalette10 = dynamicScheme.tertiaryPalette;
                return tonalPalette10;
            case 17:
                lambda$neutralPaletteKeyColor$7 = MaterialDynamicColors.lambda$neutralPaletteKeyColor$7(dynamicScheme);
                return lambda$neutralPaletteKeyColor$7;
            case 18:
                tonalPalette11 = dynamicScheme.secondaryPalette;
                return tonalPalette11;
            case 19:
                tonalPalette12 = dynamicScheme.primaryPalette;
                return tonalPalette12;
            case 20:
                lambda$onPrimaryFixed$110 = MaterialDynamicColors.lambda$onPrimaryFixed$110(dynamicScheme);
                return lambda$onPrimaryFixed$110;
            case 21:
                tonalPalette13 = dynamicScheme.errorPalette;
                return tonalPalette13;
            case 22:
                tonalPalette14 = dynamicScheme.neutralPalette;
                return tonalPalette14;
            case 23:
                lambda$error$92 = MaterialDynamicColors.lambda$error$92(dynamicScheme);
                return lambda$error$92;
            case 24:
                tonalPalette15 = dynamicScheme.neutralPalette;
                return tonalPalette15;
            case 25:
                lambda$textPrimaryInverse$153 = MaterialDynamicColors.lambda$textPrimaryInverse$153(dynamicScheme);
                return lambda$textPrimaryInverse$153;
            case 26:
                tonalPalette16 = dynamicScheme.neutralPalette;
                return tonalPalette16;
            case 27:
                lambda$surfaceContainer$26 = MaterialDynamicColors.lambda$surfaceContainer$26(dynamicScheme);
                return lambda$surfaceContainer$26;
            case 28:
                tonalPalette17 = dynamicScheme.neutralVariantPalette;
                return tonalPalette17;
            default:
                lambda$onSurfaceVariant$36 = MaterialDynamicColors.lambda$onSurfaceVariant$36(dynamicScheme);
                return lambda$onSurfaceVariant$36;
        }
    }

    public /* synthetic */ Function compose(Function function) {
        int i = this.f2984a;
        return Function$CC.$default$compose(this, function);
    }
}
