package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class KeyFrames {
    private static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    private static final String CUSTOM_METHOD = "CustomMethod";
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    static HashMap<String, Constructor<? extends Key>> sKeyMakers;
    private HashMap<Integer, ArrayList<Key>> mFramesMap = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        sKeyMakers = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor(null));
            sKeyMakers.put(TypedValues.PositionType.NAME, KeyPosition.class.getConstructor(null));
            sKeyMakers.put(TypedValues.CycleType.NAME, KeyCycle.class.getConstructor(null));
            sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(null));
            sKeyMakers.put(TypedValues.TriggerType.NAME, KeyTrigger.class.getConstructor(null));
        } catch (NoSuchMethodException e10) {
            Log.e(TAG, "unable to load", e10);
        }
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        int eventType;
        Key key;
        HashMap<String, ConstraintAttribute> hashMap;
        HashMap<String, ConstraintAttribute> hashMap2;
        Key keyTimeCycle;
        try {
            eventType = xmlPullParser.getEventType();
            key = null;
        } catch (IOException e10) {
            Log.e(TAG, "Error parsing XML resource", e10);
            return;
        } catch (XmlPullParserException e11) {
            Log.e(TAG, "Error parsing XML resource", e11);
            return;
        }
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (sKeyMakers.containsKey(name)) {
                    switch (name.hashCode()) {
                        case -300573030:
                            if (!name.equals("KeyTimeCycle")) {
                                throw new NullPointerException("Key " + name + " not found");
                            }
                            keyTimeCycle = new KeyTimeCycle();
                            keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                            addKey(keyTimeCycle);
                            key = keyTimeCycle;
                            break;
                        case -298435811:
                            if (!name.equals("KeyAttribute")) {
                                throw new NullPointerException("Key " + name + " not found");
                            }
                            keyTimeCycle = new KeyAttributes();
                            keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                            addKey(keyTimeCycle);
                            key = keyTimeCycle;
                            break;
                        case 540053991:
                            if (!name.equals(TypedValues.CycleType.NAME)) {
                                throw new NullPointerException("Key " + name + " not found");
                            }
                            keyTimeCycle = new KeyCycle();
                            keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                            addKey(keyTimeCycle);
                            key = keyTimeCycle;
                            break;
                        case 1153397896:
                            if (!name.equals(TypedValues.PositionType.NAME)) {
                                throw new NullPointerException("Key " + name + " not found");
                            }
                            keyTimeCycle = new KeyPosition();
                            keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                            addKey(keyTimeCycle);
                            key = keyTimeCycle;
                            break;
                        case 1308496505:
                            if (!name.equals(TypedValues.TriggerType.NAME)) {
                                throw new NullPointerException("Key " + name + " not found");
                            }
                            keyTimeCycle = new KeyTrigger();
                            keyTimeCycle.load(context, Xml.asAttributeSet(xmlPullParser));
                            addKey(keyTimeCycle);
                            key = keyTimeCycle;
                            break;
                        default:
                            throw new NullPointerException("Key " + name + " not found");
                    }
                    return;
                }
                if (name.equalsIgnoreCase("CustomAttribute")) {
                    if (key != null && (hashMap2 = key.mCustomConstraints) != null) {
                        ConstraintAttribute.parse(context, xmlPullParser, hashMap2);
                    }
                } else if (name.equalsIgnoreCase("CustomMethod") && key != null && (hashMap = key.mCustomConstraints) != null) {
                    ConstraintAttribute.parse(context, xmlPullParser, hashMap);
                }
            } else if (eventType == 3 && ViewTransition.KEY_FRAME_SET_TAG.equals(xmlPullParser.getName())) {
                return;
            }
            eventType = xmlPullParser.next();
        }
    }

    public static String name(int i, Context context) {
        return context.getResources().getResourceEntryName(i);
    }

    public void addAllFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.mFramesMap.get(-1);
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
    }

    public void addFrames(MotionController motionController) {
        ArrayList<Key> arrayList = this.mFramesMap.get(Integer.valueOf(motionController.mId));
        if (arrayList != null) {
            motionController.addKeys(arrayList);
        }
        ArrayList<Key> arrayList2 = this.mFramesMap.get(-1);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Key key = arrayList2.get(i);
                i++;
                Key key2 = key;
                if (key2.matches(((ConstraintLayout.LayoutParams) motionController.mView.getLayoutParams()).constraintTag)) {
                    motionController.addKey(key2);
                }
            }
        }
    }

    public void addKey(Key key) {
        if (!this.mFramesMap.containsKey(Integer.valueOf(key.mTargetId))) {
            this.mFramesMap.put(Integer.valueOf(key.mTargetId), new ArrayList<>());
        }
        ArrayList<Key> arrayList = this.mFramesMap.get(Integer.valueOf(key.mTargetId));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i) {
        return this.mFramesMap.get(Integer.valueOf(i));
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }

    public KeyFrames() {
    }
}
