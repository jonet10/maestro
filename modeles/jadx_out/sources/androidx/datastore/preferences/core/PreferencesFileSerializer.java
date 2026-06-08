package androidx.datastore.preferences.core;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.Serializer;
import androidx.datastore.preferences.PreferencesMapCompat;
import androidx.datastore.preferences.PreferencesProto;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.protobuf.ByteString;
import com.google.gson.internal.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p6.x;
import q6.l;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PreferencesFileSerializer implements Serializer<Preferences> {
    public static final PreferencesFileSerializer INSTANCE = new PreferencesFileSerializer();
    public static final String fileExtension = "preferences_pb";

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreferencesProto.Value.ValueCase.values().length];
            try {
                iArr[PreferencesProto.Value.ValueCase.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.INTEGER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.STRING_SET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.BYTES.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PreferencesProto.Value.ValueCase.VALUE_NOT_SET.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private PreferencesFileSerializer() {
    }

    private final void addProtoEntryToPreferences(String str, PreferencesProto.Value value, MutablePreferences mutablePreferences) {
        PreferencesProto.Value.ValueCase valueCase = value.getValueCase();
        switch (valueCase == null ? -1 : WhenMappings.$EnumSwitchMapping$0[valueCase.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", null, 2, null);
            case 0:
            default:
                a.b();
                return;
            case 1:
                mutablePreferences.set(PreferencesKeys.booleanKey(str), Boolean.valueOf(value.getBoolean()));
                return;
            case 2:
                mutablePreferences.set(PreferencesKeys.floatKey(str), Float.valueOf(value.getFloat()));
                return;
            case 3:
                mutablePreferences.set(PreferencesKeys.doubleKey(str), Double.valueOf(value.getDouble()));
                return;
            case 4:
                mutablePreferences.set(PreferencesKeys.intKey(str), Integer.valueOf(value.getInteger()));
                return;
            case 5:
                mutablePreferences.set(PreferencesKeys.longKey(str), Long.valueOf(value.getLong()));
                return;
            case 6:
                Preferences.Key<String> stringKey = PreferencesKeys.stringKey(str);
                String string = value.getString();
                string.getClass();
                mutablePreferences.set(stringKey, string);
                return;
            case 7:
                Preferences.Key<Set<String>> stringSetKey = PreferencesKeys.stringSetKey(str);
                List<String> stringsList = value.getStringSet().getStringsList();
                stringsList.getClass();
                mutablePreferences.set(stringSetKey, l.J0(stringsList));
                return;
            case 8:
                Preferences.Key<byte[]> byteArrayKey = PreferencesKeys.byteArrayKey(str);
                byte[] byteArray = value.getBytes().toByteArray();
                byteArray.getClass();
                mutablePreferences.set(byteArrayKey, byteArray);
                return;
            case 9:
                throw new CorruptionException("Value not set.", null, 2, null);
        }
    }

    private final PreferencesProto.Value getValueProto(Object obj) {
        if (obj instanceof Boolean) {
            PreferencesProto.Value build = PreferencesProto.Value.newBuilder().setBoolean(((Boolean) obj).booleanValue()).build();
            build.getClass();
            return build;
        }
        if (obj instanceof Float) {
            PreferencesProto.Value build2 = PreferencesProto.Value.newBuilder().setFloat(((Number) obj).floatValue()).build();
            build2.getClass();
            return build2;
        }
        if (obj instanceof Double) {
            PreferencesProto.Value build3 = PreferencesProto.Value.newBuilder().setDouble(((Number) obj).doubleValue()).build();
            build3.getClass();
            return build3;
        }
        if (obj instanceof Integer) {
            PreferencesProto.Value build4 = PreferencesProto.Value.newBuilder().setInteger(((Number) obj).intValue()).build();
            build4.getClass();
            return build4;
        }
        if (obj instanceof Long) {
            PreferencesProto.Value build5 = PreferencesProto.Value.newBuilder().setLong(((Number) obj).longValue()).build();
            build5.getClass();
            return build5;
        }
        if (obj instanceof String) {
            PreferencesProto.Value build6 = PreferencesProto.Value.newBuilder().setString((String) obj).build();
            build6.getClass();
            return build6;
        }
        if (obj instanceof Set) {
            PreferencesProto.Value build7 = PreferencesProto.Value.newBuilder().setStringSet(PreferencesProto.StringSet.newBuilder().addAllStrings((Set) obj)).build();
            build7.getClass();
            return build7;
        }
        if (!(obj instanceof byte[])) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("PreferencesSerializer does not support type: ".concat(obj.getClass().getName()));
            return null;
        }
        PreferencesProto.Value build8 = PreferencesProto.Value.newBuilder().setBytes(ByteString.copyFrom((byte[]) obj)).build();
        build8.getClass();
        return build8;
    }

    @Override // androidx.datastore.core.Serializer
    public Object readFrom(InputStream inputStream, c cVar) throws IOException, CorruptionException {
        PreferencesProto.PreferenceMap readFrom = PreferencesMapCompat.Companion.readFrom(inputStream);
        MutablePreferences createMutable = PreferencesFactory.createMutable(new Preferences.Pair[0]);
        Map<String, PreferencesProto.Value> preferencesMap = readFrom.getPreferencesMap();
        preferencesMap.getClass();
        for (Map.Entry<String, PreferencesProto.Value> entry : preferencesMap.entrySet()) {
            String key = entry.getKey();
            PreferencesProto.Value value = entry.getValue();
            PreferencesFileSerializer preferencesFileSerializer = INSTANCE;
            key.getClass();
            value.getClass();
            preferencesFileSerializer.addProtoEntryToPreferences(key, value, createMutable);
        }
        return createMutable.toPreferences();
    }

    @Override // androidx.datastore.core.Serializer
    public Object writeTo(Preferences preferences, OutputStream outputStream, c cVar) throws IOException, CorruptionException {
        Map<Preferences.Key<?>, Object> asMap = preferences.asMap();
        PreferencesProto.PreferenceMap.Builder newBuilder = PreferencesProto.PreferenceMap.newBuilder();
        for (Map.Entry<Preferences.Key<?>, Object> entry : asMap.entrySet()) {
            newBuilder.putPreferences(entry.getKey().getName(), getValueProto(entry.getValue()));
        }
        newBuilder.build().writeTo(outputStream);
        return x.f8463a;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.datastore.core.Serializer
    public Preferences getDefaultValue() {
        return PreferencesFactory.createEmpty();
    }
}
