package androidx.transition;

import a4.x;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.TypedArrayUtils;
import androidx.lifecycle.l;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class TransitionInflater {
    private final Context mContext;
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE = {Context.class, AttributeSet.class};
    private static final ArrayMap<String, Constructor<?>> CONSTRUCTORS = new ArrayMap<>();

    private TransitionInflater(@NonNull Context context) {
        this.mContext = context;
    }

    private Object createCustom(AttributeSet attributeSet, Class<?> cls, String str) {
        Object newInstance;
        Class<? extends U> asSubclass;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        if (attributeValue == null) {
            throw new InflateException(x.C(str, " tag must have a 'class' attribute"));
        }
        try {
            ArrayMap<String, Constructor<?>> arrayMap = CONSTRUCTORS;
            synchronized (arrayMap) {
                try {
                    Constructor<?> constructor = arrayMap.get(attributeValue);
                    if (constructor == null && (asSubclass = Class.forName(attributeValue, false, this.mContext.getClassLoader()).asSubclass(cls)) != 0) {
                        constructor = asSubclass.getConstructor(CONSTRUCTOR_SIGNATURE);
                        constructor.setAccessible(true);
                        arrayMap.put(attributeValue, constructor);
                    }
                    newInstance = constructor.newInstance(this.mContext, attributeSet);
                } finally {
                }
            }
            return newInstance;
        } catch (Exception e10) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0167, code lost:
    
        return r3;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private androidx.transition.Transition createTransitionFromXml(org.xmlpull.v1.XmlPullParser r8, android.util.AttributeSet r9, androidx.transition.Transition r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionInflater.createTransitionFromXml(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, androidx.transition.Transition):androidx.transition.Transition");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0044, code lost:
    
        return r1;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private androidx.transition.TransitionManager createTransitionManagerFromXml(org.xmlpull.v1.XmlPullParser r5, android.util.AttributeSet r6, @androidx.annotation.NonNull android.view.ViewGroup r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r4 = this;
            int r0 = r5.getDepth()
            r1 = 0
        L5:
            int r2 = r5.next()
            r3 = 3
            if (r2 != r3) goto L12
            int r3 = r5.getDepth()
            if (r3 <= r0) goto L44
        L12:
            r3 = 1
            if (r2 == r3) goto L44
            r3 = 2
            if (r2 == r3) goto L19
            goto L5
        L19:
            java.lang.String r2 = r5.getName()
            java.lang.String r3 = "transitionManager"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L2b
            androidx.transition.TransitionManager r1 = new androidx.transition.TransitionManager
            r1.<init>()
            goto L5
        L2b:
            java.lang.String r3 = "transition"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L39
            if (r1 == 0) goto L39
            r4.loadTransition(r6, r5, r7, r1)
            goto L5
        L39:
            java.lang.String r6 = "Unknown scene name: "
            java.lang.String r5 = r5.getName()
            androidx.transition.c.a(r5, r6)
            r5 = 0
            return r5
        L44:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionInflater.createTransitionManagerFromXml(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.ViewGroup):androidx.transition.TransitionManager");
    }

    @NonNull
    public static TransitionInflater from(@NonNull Context context) {
        return new TransitionInflater(context);
    }

    private void getTargetIds(XmlPullParser xmlPullParser, AttributeSet attributeSet, @NonNull Transition transition) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (!xmlPullParser.getName().equals(TypedValues.AttributesType.S_TARGET)) {
                    c.a(xmlPullParser.getName(), "Unknown scene name: ");
                    return;
                }
                TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_TARGET);
                int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                if (namedResourceId != 0) {
                    transition.addTarget(namedResourceId);
                } else {
                    int namedResourceId2 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                    if (namedResourceId2 != 0) {
                        transition.excludeTarget(namedResourceId2, true);
                    } else {
                        String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetName", 4);
                        if (namedString != null) {
                            transition.addTarget(namedString);
                        } else {
                            String namedString2 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeName", 5);
                            if (namedString2 != null) {
                                transition.excludeTarget(namedString2, true);
                            } else {
                                String namedString3 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                if (namedString3 != null) {
                                    try {
                                        transition.excludeTarget(Class.forName(namedString3), true);
                                    } catch (ClassNotFoundException e10) {
                                        obtainStyledAttributes.recycle();
                                        androidx.privacysandbox.ads.adservices.customaudience.a.m(x.j("Could not create ", namedString3), e10);
                                        return;
                                    }
                                } else {
                                    String namedString4 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                    if (namedString4 != null) {
                                        transition.addTarget(Class.forName(namedString4));
                                    }
                                }
                            }
                        }
                    }
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void loadTransition(AttributeSet attributeSet, XmlPullParser xmlPullParser, @NonNull ViewGroup viewGroup, TransitionManager transitionManager) throws Resources.NotFoundException {
        Transition inflateTransition;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_MANAGER);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "transition", 2, -1);
        int namedResourceId2 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "fromScene", 0, -1);
        Scene sceneForLayout = namedResourceId2 < 0 ? null : Scene.getSceneForLayout(viewGroup, namedResourceId2, this.mContext);
        int namedResourceId3 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "toScene", 1, -1);
        Scene sceneForLayout2 = namedResourceId3 >= 0 ? Scene.getSceneForLayout(viewGroup, namedResourceId3, this.mContext) : null;
        if (namedResourceId >= 0 && (inflateTransition = inflateTransition(namedResourceId)) != null) {
            if (sceneForLayout2 == null) {
                a3.b.n(l.u(namedResourceId, "No toScene for transition ID "));
                return;
            } else if (sceneForLayout == null) {
                transitionManager.setTransition(sceneForLayout2, inflateTransition);
            } else {
                transitionManager.setTransition(sceneForLayout, sceneForLayout2, inflateTransition);
            }
        }
        obtainStyledAttributes.recycle();
    }

    @Nullable
    public Transition inflateTransition(int i) {
        XmlResourceParser xml = this.mContext.getResources().getXml(i);
        try {
            try {
                return createTransitionFromXml(xml, Xml.asAttributeSet(xml), null);
            } catch (IOException e10) {
                throw new InflateException(xml.getPositionDescription() + ": " + e10.getMessage(), e10);
            } catch (XmlPullParserException e11) {
                throw new InflateException(e11.getMessage(), e11);
            }
        } finally {
            xml.close();
        }
    }

    @Nullable
    public TransitionManager inflateTransitionManager(int i, @NonNull ViewGroup viewGroup) {
        XmlResourceParser xml = this.mContext.getResources().getXml(i);
        try {
            try {
                return createTransitionManagerFromXml(xml, Xml.asAttributeSet(xml), viewGroup);
            } catch (IOException e10) {
                InflateException inflateException = new InflateException(xml.getPositionDescription() + ": " + e10.getMessage());
                inflateException.initCause(e10);
                throw inflateException;
            } catch (XmlPullParserException e11) {
                InflateException inflateException2 = new InflateException(e11.getMessage());
                inflateException2.initCause(e11);
                throw inflateException2;
            }
        } finally {
            xml.close();
        }
    }
}
