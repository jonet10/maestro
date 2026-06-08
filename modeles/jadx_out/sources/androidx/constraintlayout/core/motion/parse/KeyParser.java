package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class KeyParser {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface DataType {
        int get(int i);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface Ids {
        int get(String str);
    }

    public static void main(String[] strArr) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle parse(String str, Ids ids, DataType dataType) {
        TypedBundle typedBundle = new TypedBundle();
        try {
            CLObject parse = CLParser.parse(str);
            int size = parse.size();
            for (int i = 0; i < size; i++) {
                CLKey cLKey = (CLKey) parse.get(i);
                String content = cLKey.content();
                CLElement value = cLKey.getValue();
                int i6 = ids.get(content);
                if (i6 == -1) {
                    System.err.println("unknown type " + content);
                } else {
                    int i10 = dataType.get(i6);
                    if (i10 == 1) {
                        typedBundle.add(i6, parse.getBoolean(i));
                    } else if (i10 == 2) {
                        typedBundle.add(i6, value.getInt());
                        System.out.println("parse " + content + " INT_MASK > " + value.getInt());
                    } else if (i10 == 4) {
                        typedBundle.add(i6, value.getFloat());
                        System.out.println("parse " + content + " FLOAT_MASK > " + value.getFloat());
                    } else if (i10 == 8) {
                        typedBundle.add(i6, value.content());
                        System.out.println("parse " + content + " STRING_MASK > " + value.content());
                    }
                }
            }
            return typedBundle;
        } catch (CLParsingException e10) {
            System.err.println(e10.toString() + "\n" + Arrays.toString(e10.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
            return typedBundle;
        }
    }

    public static TypedBundle parseAttributes(String str) {
        return parse(str, new a(), new a());
    }
}
