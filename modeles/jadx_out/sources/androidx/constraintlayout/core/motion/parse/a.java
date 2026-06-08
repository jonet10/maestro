package androidx.constraintlayout.core.motion.parse;

import a4.x;
import androidx.constraintlayout.core.motion.parse.KeyParser;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements KeyParser.Ids, KeyParser.DataType {
    @Override // androidx.constraintlayout.core.motion.parse.KeyParser.DataType
    public int get(int i) {
        if (i == 100) {
            return 2;
        }
        if (i == 101) {
            return 8;
        }
        switch (i) {
            case 301:
            case 302:
                return 2;
            case 303:
            case 304:
            case 305:
            case 306:
            case 307:
            case 308:
            case 309:
            case 310:
            case 311:
            case 312:
            case 313:
            case 314:
            case 315:
            case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                return 4;
            case TypedValues.AttributesType.TYPE_EASING /* 317 */:
            case TypedValues.AttributesType.TYPE_PIVOT_TARGET /* 318 */:
                return 8;
            default:
                return -1;
        }
    }

    @Override // androidx.constraintlayout.core.motion.parse.KeyParser.Ids
    public int get(String str) {
        return x.c(str);
    }
}
