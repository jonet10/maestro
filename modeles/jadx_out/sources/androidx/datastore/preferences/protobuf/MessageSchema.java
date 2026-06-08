package androidx.datastore.preferences.protobuf;

import a3.b;
import a4.x;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import c2.a;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s1.o;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@CheckReturnValue
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final ProtoSyntax syntax;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i6, MessageLite messageLite, ProtoSyntax protoSyntax, boolean z9, int[] iArr2, int i10, int i11, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i6;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.syntax = protoSyntax;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z9;
        this.intArray = iArr2;
        this.checkInitializedCount = i10;
        this.repeatedFieldOffsetStart = i11;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t9, T t10, int i) {
        return isFieldPresent(t9, i) == isFieldPresent(t10, i);
    }

    private static <T> boolean booleanAt(T t9, long j) {
        return UnsafeUtil.getBoolean(t9, j);
    }

    private static void checkMutable(Object obj) {
        if (isMutable(obj)) {
            return;
        }
        a.h(obj, "Mutating immutable message: ");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i6, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i10 = registers.int1;
        if (i10 < 0 || i10 > i6 - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i11 = decodeVarint32 + i10;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (decodeVarint32 < i11) {
            int i12 = decodeVarint32 + 1;
            int i13 = bArr[decodeVarint32];
            if (i13 < 0) {
                i12 = ArrayDecoders.decodeVarint32(i13, bArr, i12, registers);
                i13 = registers.int1;
            }
            int i14 = i12;
            int i15 = i13 >>> 3;
            int i16 = i13 & 7;
            if (i15 != 1) {
                if (i15 == 2 && i16 == metadata.valueType.getWireType()) {
                    decodeVarint32 = decodeMapEntryValue(bArr, i14, i6, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                }
                decodeVarint32 = ArrayDecoders.skipField(i13, bArr, i14, i6, registers);
            } else if (i16 == metadata.keyType.getWireType()) {
                decodeVarint32 = decodeMapEntryValue(bArr, i14, i6, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                decodeVarint32 = ArrayDecoders.skipField(i13, bArr, i14, i6, registers);
            }
        }
        if (decodeVarint32 != i11) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i11;
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i6, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return decodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return decodeVarint32;
            case 12:
            case 13:
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return decodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i6, registers);
            case 15:
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return decodeVarint322;
            case 16:
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return decodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                b.n("unsupported field type.");
                return 0;
        }
    }

    private static <T> double doubleAt(T t9, long j) {
        return UnsafeUtil.getDouble(t9, j);
    }

    private boolean equals(T t9, T t10, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (!arePresentForEquals(t9, t10, i) || Double.doubleToLongBits(UnsafeUtil.getDouble(t9, offset)) != Double.doubleToLongBits(UnsafeUtil.getDouble(t10, offset))) {
                }
                break;
            case 1:
                if (!arePresentForEquals(t9, t10, i) || Float.floatToIntBits(UnsafeUtil.getFloat(t9, offset)) != Float.floatToIntBits(UnsafeUtil.getFloat(t10, offset))) {
                }
                break;
            case 2:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getLong(t9, offset) != UnsafeUtil.getLong(t10, offset)) {
                }
                break;
            case 3:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getLong(t9, offset) != UnsafeUtil.getLong(t10, offset)) {
                }
                break;
            case 4:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, offset) != UnsafeUtil.getInt(t10, offset)) {
                }
                break;
            case 5:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getLong(t9, offset) != UnsafeUtil.getLong(t10, offset)) {
                }
                break;
            case 6:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, offset) != UnsafeUtil.getInt(t10, offset)) {
                }
                break;
            case 7:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getBoolean(t9, offset) != UnsafeUtil.getBoolean(t10, offset)) {
                }
                break;
            case 8:
                if (!arePresentForEquals(t9, t10, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t9, offset), UnsafeUtil.getObject(t10, offset))) {
                }
                break;
            case 9:
                if (!arePresentForEquals(t9, t10, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t9, offset), UnsafeUtil.getObject(t10, offset))) {
                }
                break;
            case 10:
                if (!arePresentForEquals(t9, t10, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t9, offset), UnsafeUtil.getObject(t10, offset))) {
                }
                break;
            case 11:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, offset) != UnsafeUtil.getInt(t10, offset)) {
                }
                break;
            case 12:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, offset) != UnsafeUtil.getInt(t10, offset)) {
                }
                break;
            case 13:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, offset) != UnsafeUtil.getInt(t10, offset)) {
                }
                break;
            case 14:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getLong(t9, offset) != UnsafeUtil.getLong(t10, offset)) {
                }
                break;
            case 15:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getInt(t9, offset) != UnsafeUtil.getInt(t10, offset)) {
                }
                break;
            case 16:
                if (!arePresentForEquals(t9, t10, i) || UnsafeUtil.getLong(t9, offset) != UnsafeUtil.getLong(t10, offset)) {
                }
                break;
            case 17:
                if (!arePresentForEquals(t9, t10, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t9, offset), UnsafeUtil.getObject(t10, offset))) {
                }
                break;
            case 51:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
            case 68:
                if (!isOneofCaseEqual(t9, t10, i) || !SchemaUtil.safeEquals(UnsafeUtil.getObject(t9, offset), UnsafeUtil.getObject(t10, offset))) {
                }
                break;
        }
        return true;
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i6, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i6, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e10) {
                    com.google.gson.internal.a.k(e10);
                    return null;
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t9, long j) {
        return UnsafeUtil.getFloat(t9, j);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.objects[((i / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.objects[(i / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i) {
        int i6 = (i / 3) * 2;
        Schema schema = (Schema) this.objects[i6];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i6 + 1]);
        this.objects[i6] = schemaFor;
        return schemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t9) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t9));
    }

    private static <T> int intAt(T t9, long j) {
        return UnsafeUtil.getInt(t9, j);
    }

    private static boolean isEnforceUtf8(int i) {
        return (i & ENFORCE_UTF8_MASK) != 0;
    }

    private boolean isFieldPresent(T t9, int i) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & presenceMaskAndOffsetAt;
        if (j != 1048575) {
            return (UnsafeUtil.getInt(t9, j) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t9, offset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t9, offset)) != 0;
            case 2:
                return UnsafeUtil.getLong(t9, offset) != 0;
            case 3:
                return UnsafeUtil.getLong(t9, offset) != 0;
            case 4:
                return UnsafeUtil.getInt(t9, offset) != 0;
            case 5:
                return UnsafeUtil.getLong(t9, offset) != 0;
            case 6:
                return UnsafeUtil.getInt(t9, offset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t9, offset);
            case 8:
                Object object = UnsafeUtil.getObject(t9, offset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                o.n();
                return false;
            case 9:
                return UnsafeUtil.getObject(t9, offset) != null;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t9, offset));
            case 11:
                return UnsafeUtil.getInt(t9, offset) != 0;
            case 12:
                return UnsafeUtil.getInt(t9, offset) != 0;
            case 13:
                return UnsafeUtil.getInt(t9, offset) != 0;
            case 14:
                return UnsafeUtil.getLong(t9, offset) != 0;
            case 15:
                return UnsafeUtil.getInt(t9, offset) != 0;
            case 16:
                return UnsafeUtil.getLong(t9, offset) != 0;
            case 17:
                return UnsafeUtil.getObject(t9, offset) != null;
            default:
                o.n();
                return false;
        }
    }

    private static boolean isLegacyEnumIsClosed(int i) {
        return (i & Integer.MIN_VALUE) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i6) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i6);
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!messageFieldSchema.isInitialized(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [androidx.datastore.preferences.protobuf.Schema] */
    private boolean isMapInitialized(T t9, int i, int i6) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t9, offset(i)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i6)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? r52 = 0;
        for (Object obj : forMapData.values()) {
            r52 = r52;
            if (r52 == 0) {
                r52 = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!r52.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t9, T t10, int i) {
        long presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & 1048575;
        return UnsafeUtil.getInt(t9, presenceMaskAndOffsetAt) == UnsafeUtil.getInt(t10, presenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t9, int i, int i6) {
        return UnsafeUtil.getInt(t9, (long) (presenceMaskAndOffsetAt(i6) & 1048575)) == i;
    }

    private static boolean isRequired(int i) {
        return (i & REQUIRED_MASK) != 0;
    }

    private static <T> long longAt(T t9, long j) {
        return UnsafeUtil.getLong(t9, j);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private <UT, UB, ET extends androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB> r18, androidx.datastore.preferences.protobuf.ExtensionSchema<ET> r19, T r20, androidx.datastore.preferences.protobuf.Reader r21, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2040
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, java.lang.Object, androidx.datastore.preferences.protobuf.Reader, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, offset);
        MapFieldSchema mapFieldSchema = this.mapFieldSchema;
        if (object == null) {
            object = mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, object);
        } else if (mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T t9, T t10, int i) {
        if (isFieldPresent(t10, i)) {
            long offset = offset(typeAndOffsetAt(i));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t10, offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t10);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isFieldPresent(t9, i)) {
                if (isMutable(object)) {
                    Object newInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance, object);
                    unsafe.putObject(t9, offset, newInstance);
                } else {
                    unsafe.putObject(t9, offset, object);
                }
                setFieldPresent(t9, i);
                return;
            }
            Object object2 = unsafe.getObject(t9, offset);
            if (!isMutable(object2)) {
                Object newInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(newInstance2, object2);
                unsafe.putObject(t9, offset, newInstance2);
                object2 = newInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T t9, T t10, int i) {
        int numberAt = numberAt(i);
        if (isOneofPresent(t10, numberAt, i)) {
            long offset = offset(typeAndOffsetAt(i));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t10, offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t10);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isOneofPresent(t9, numberAt, i)) {
                if (isMutable(object)) {
                    Object newInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance, object);
                    unsafe.putObject(t9, offset, newInstance);
                } else {
                    unsafe.putObject(t9, offset, object);
                }
                setOneofPresent(t9, numberAt, i);
                return;
            }
            Object object2 = unsafe.getObject(t9, offset);
            if (!isMutable(object2)) {
                Object newInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(newInstance2, object2);
                unsafe.putObject(t9, offset, newInstance2);
                object2 = newInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(T t9, T t10, int i) {
        int typeAndOffsetAt = typeAndOffsetAt(i);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putDouble(t9, offset, UnsafeUtil.getDouble(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 1:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putFloat(t9, offset, UnsafeUtil.getFloat(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 2:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putLong(t9, offset, UnsafeUtil.getLong(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 3:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putLong(t9, offset, UnsafeUtil.getLong(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 4:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, offset, UnsafeUtil.getInt(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 5:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putLong(t9, offset, UnsafeUtil.getLong(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 6:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, offset, UnsafeUtil.getInt(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 7:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putBoolean(t9, offset, UnsafeUtil.getBoolean(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 8:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putObject(t9, offset, UnsafeUtil.getObject(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 9:
                mergeMessage(t9, t10, i);
                break;
            case 10:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putObject(t9, offset, UnsafeUtil.getObject(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 11:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, offset, UnsafeUtil.getInt(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 12:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, offset, UnsafeUtil.getInt(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 13:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, offset, UnsafeUtil.getInt(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 14:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putLong(t9, offset, UnsafeUtil.getLong(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 15:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putInt(t9, offset, UnsafeUtil.getInt(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 16:
                if (isFieldPresent(t10, i)) {
                    UnsafeUtil.putLong(t9, offset, UnsafeUtil.getLong(t10, offset));
                    setFieldPresent(t9, i);
                    break;
                }
                break;
            case 17:
                mergeMessage(t9, t10, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
            case 49:
                this.listFieldSchema.mergeListsAt(t9, t10, offset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t9, t10, offset);
                break;
            case 51:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t10, numberAt, i)) {
                    UnsafeUtil.putObject(t9, offset, UnsafeUtil.getObject(t10, offset));
                    setOneofPresent(t9, numberAt, i);
                    break;
                }
                break;
            case 60:
                mergeOneofMessage(t9, t10, i);
                break;
            case 61:
            case 62:
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
            case 64:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (isOneofPresent(t10, numberAt, i)) {
                    UnsafeUtil.putObject(t9, offset, UnsafeUtil.getObject(t10, offset));
                    setOneofPresent(t9, numberAt, i);
                    break;
                }
                break;
            case 68:
                mergeOneofMessage(t9, t10, i);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T t9, int i) {
        Schema messageFieldSchema = getMessageFieldSchema(i);
        long offset = offset(typeAndOffsetAt(i));
        if (!isFieldPresent(t9, i)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t9, offset);
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T t9, int i, int i6) {
        Schema messageFieldSchema = getMessageFieldSchema(i6);
        if (!isOneofPresent(t9, i, i6)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t9, offset(typeAndOffsetAt(i6)));
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i6 = 0;
        int i10 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i6++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i10++;
            }
        }
        int[] iArr2 = i6 > 0 ? new int[i6] : null;
        int[] iArr3 = i10 > 0 ? new int[i10] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i11 < fields.length) {
            FieldInfo fieldInfo2 = fields[i11];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i12, objArr);
            if (i13 < checkInitialized.length && checkInitialized[i13] == fieldNumber3) {
                checkInitialized[i13] = i12;
                i13++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i14] = i12;
                i14++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i = i12;
                iArr3[i15] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                i15++;
                i11++;
                i12 = i + 3;
            }
            i = i12;
            i11++;
            i12 = i + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), structuralMessageInfo.getSyntax(), true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0254  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> androidx.datastore.preferences.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(androidx.datastore.preferences.protobuf.RawMessageInfo r32, androidx.datastore.preferences.protobuf.NewInstanceSchema r33, androidx.datastore.preferences.protobuf.ListFieldSchema r34, androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r35, androidx.datastore.preferences.protobuf.ExtensionSchema<?> r36, androidx.datastore.preferences.protobuf.MapFieldSchema r37) {
        /*
            Method dump skipped, instructions count: 1009
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.newSchemaForRawMessageInfo(androidx.datastore.preferences.protobuf.RawMessageInfo, androidx.datastore.preferences.protobuf.NewInstanceSchema, androidx.datastore.preferences.protobuf.ListFieldSchema, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, androidx.datastore.preferences.protobuf.MapFieldSchema):androidx.datastore.preferences.protobuf.MessageSchema");
    }

    private int numberAt(int i) {
        return this.buffer[i];
    }

    private static long offset(int i) {
        return i & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t9, long j) {
        return ((Boolean) UnsafeUtil.getObject(t9, j)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t9, long j) {
        return ((Double) UnsafeUtil.getObject(t9, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t9, long j) {
        return ((Float) UnsafeUtil.getObject(t9, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t9, long j) {
        return ((Integer) UnsafeUtil.getObject(t9, j)).intValue();
    }

    private static <T> long oneofLongAt(T t9, long j) {
        return ((Long) UnsafeUtil.getObject(t9, j)).longValue();
    }

    private <K, V> int parseMapField(T t9, byte[] bArr, int i, int i6, int i10, long j, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i10);
        Object object = unsafe.getObject(t9, j);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(t9, j, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(bArr, i, i6, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t9, byte[] bArr, int i, int i6, int i10, int i11, int i12, int i13, int i14, long j, int i15, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        long j6 = this.buffer[i15 + 2] & 1048575;
        switch (i14) {
            case 51:
                if (i12 != 1) {
                    return i;
                }
                unsafe.putObject(t9, j, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                int i16 = i + 8;
                unsafe.putInt(t9, j6, i11);
                return i16;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                if (i12 != 5) {
                    return i;
                }
                unsafe.putObject(t9, j, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                int i17 = i + 4;
                unsafe.putInt(t9, j6, i11);
                return i17;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                if (i12 != 0) {
                    return i;
                }
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t9, j, Long.valueOf(registers.long1));
                unsafe.putInt(t9, j6, i11);
                return decodeVarint64;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 62:
                if (i12 != 0) {
                    return i;
                }
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t9, j, Integer.valueOf(registers.int1));
                unsafe.putInt(t9, j6, i11);
                return decodeVarint32;
            case 56:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                if (i12 != 1) {
                    return i;
                }
                unsafe.putObject(t9, j, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                int i18 = i + 8;
                unsafe.putInt(t9, j6, i11);
                return i18;
            case 57:
            case 64:
                if (i12 != 5) {
                    return i;
                }
                unsafe.putObject(t9, j, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                int i19 = i + 4;
                unsafe.putInt(t9, j6, i11);
                return i19;
            case 58:
                if (i12 != 0) {
                    return i;
                }
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t9, j, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t9, j6, i11);
                return decodeVarint642;
            case 59:
                if (i12 != 2) {
                    return i;
                }
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i20 = registers.int1;
                if (i20 == 0) {
                    unsafe.putObject(t9, j, "");
                } else {
                    if ((i13 & ENFORCE_UTF8_MASK) != 0 && !Utf8.isValidUtf8(bArr, decodeVarint322, decodeVarint322 + i20)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t9, j, new String(bArr, decodeVarint322, i20, Internal.UTF_8));
                    decodeVarint322 += i20;
                }
                unsafe.putInt(t9, j6, i11);
                return decodeVarint322;
            case 60:
                if (i12 != 2) {
                    return i;
                }
                Object mutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t9, i11, i15);
                int mergeMessageField = ArrayDecoders.mergeMessageField(mutableOneofMessageFieldForMerge, getMessageFieldSchema(i15), bArr, i, i6, registers);
                storeOneofMessageField(t9, i11, i15, mutableOneofMessageFieldForMerge);
                return mergeMessageField;
            case 61:
                if (i12 != 2) {
                    return i;
                }
                int decodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                unsafe.putObject(t9, j, registers.object1);
                unsafe.putInt(t9, j6, i11);
                return decodeBytes;
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                if (i12 != 0) {
                    return i;
                }
                int decodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                int i21 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i15);
                if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i21)) {
                    getMutableUnknownFields(t9).storeField(i10, Long.valueOf(i21));
                    return decodeVarint323;
                }
                unsafe.putObject(t9, j, Integer.valueOf(i21));
                unsafe.putInt(t9, j6, i11);
                return decodeVarint323;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                if (i12 != 0) {
                    return i;
                }
                int decodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                unsafe.putObject(t9, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t9, j6, i11);
                return decodeVarint324;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                if (i12 != 0) {
                    return i;
                }
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                unsafe.putObject(t9, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t9, j6, i11);
                return decodeVarint643;
            case 68:
                if (i12 == 3) {
                    Object mutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t9, i11, i15);
                    int mergeGroupField = ArrayDecoders.mergeGroupField(mutableOneofMessageFieldForMerge2, getMessageFieldSchema(i15), bArr, i, i6, (i10 & (-8)) | 4, registers);
                    storeOneofMessageField(t9, i11, i15, mutableOneofMessageFieldForMerge2);
                    return mergeGroupField;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int parseRepeatedField(T t9, byte[] bArr, int i, int i6, int i10, int i11, int i12, int i13, long j, int i14, long j6, ArrayDecoders.Registers registers) throws IOException {
        int decodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t9, j6);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t9, j6, protobufList);
        }
        Internal.ProtobufList protobufList2 = protobufList;
        switch (i14) {
            case 18:
            case 35:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufList2, registers);
                }
                if (i12 == 1) {
                    return ArrayDecoders.decodeDoubleList(i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case 19:
            case 36:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufList2, registers);
                }
                if (i12 == 5) {
                    return ArrayDecoders.decodeFloatList(i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufList2, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.decodeVarint64List(i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case 22:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
            case 39:
            case 43:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList2, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.decodeVarint32List(i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufList2, registers);
                }
                if (i12 == 1) {
                    return ArrayDecoders.decodeFixed64List(i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufList2, registers);
                }
                if (i12 == 5) {
                    return ArrayDecoders.decodeFixed32List(i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case 25:
            case 42:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufList2, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.decodeBoolList(i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case 26:
                if (i12 == 2) {
                    return (j & 536870912) == 0 ? ArrayDecoders.decodeStringList(i10, bArr, i, i6, protobufList2, registers) : ArrayDecoders.decodeStringListRequireUtf8(i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case 27:
                if (i12 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i13), i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case 28:
                if (i12 == 2) {
                    return ArrayDecoders.decodeBytesList(i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
            case 44:
                if (i12 != 2) {
                    if (i12 == 0) {
                        decodeVarint32List = ArrayDecoders.decodeVarint32List(i10, bArr, i, i6, protobufList2, registers);
                    }
                    return i;
                }
                decodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufList2, registers);
                SchemaUtil.filterUnknownEnumList((Object) t9, i11, (List<Integer>) protobufList2, getEnumFieldVerifier(i13), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return decodeVarint32List;
            case 33:
            case 47:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufList2, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.decodeSInt32List(i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case 34:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                if (i12 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufList2, registers);
                }
                if (i12 == 0) {
                    return ArrayDecoders.decodeSInt64List(i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            case 49:
                if (i12 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i13), i10, bArr, i, i6, protobufList2, registers);
                }
                return i;
            default:
                return i;
        }
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.buffer[i + 2];
    }

    private <E> void readGroupList(Object obj, long j, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i, Reader reader) throws IOException {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, offset(i), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, Reader reader) throws IOException {
        boolean isEnforceUtf8 = isEnforceUtf8(i);
        ListFieldSchema listFieldSchema = this.listFieldSchema;
        if (isEnforceUtf8) {
            reader.readStringListRequireUtf8(listFieldSchema.mutableListAt(obj, offset(i)));
        } else {
            reader.readStringList(listFieldSchema.mutableListAt(obj, offset(i)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder v = x.v("Field ", str, " for ");
            v.append(cls.getName());
            v.append(" not found. Known fields are ");
            v.append(Arrays.toString(declaredFields));
            throw new RuntimeException(v.toString());
        }
    }

    private void setFieldPresent(T t9, int i) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & presenceMaskAndOffsetAt;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t9, j, (1 << (presenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t9, j));
    }

    private void setOneofPresent(T t9, int i, int i6) {
        UnsafeUtil.putInt(t9, presenceMaskAndOffsetAt(i6) & 1048575, i);
    }

    private int slowPositionForFieldNumber(int i, int i6) {
        int length = (this.buffer.length / 3) - 1;
        while (i6 <= length) {
            int i10 = (length + i6) >>> 1;
            int i11 = i10 * 3;
            int numberAt = numberAt(i11);
            if (i == numberAt) {
                return i11;
            }
            if (i < numberAt) {
                length = i10 - 1;
            } else {
                i6 = i10 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            androidx.datastore.preferences.protobuf.OneofInfo r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L25
            androidx.datastore.preferences.protobuf.FieldType r2 = r8.getType()
            int r2 = r2.id()
            int r2 = r2 + 51
            java.lang.reflect.Field r3 = r0.getValueField()
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r3)
            int r3 = (int) r3
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
        L22:
            int r0 = (int) r4
            r4 = r1
            goto L6c
        L25:
            androidx.datastore.preferences.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r3 = (int) r2
            int r2 = r0.id()
            boolean r4 = r0.isList()
            if (r4 != 0) goto L5a
            boolean r0 = r0.isMap()
            if (r0 != 0) goto L5a
            java.lang.reflect.Field r0 = r8.getPresenceField()
            if (r0 != 0) goto L4c
            r0 = 1048575(0xfffff, float:1.469367E-39)
            goto L51
        L4c:
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r4
        L51:
            int r4 = r8.getPresenceMask()
            int r4 = java.lang.Integer.numberOfTrailingZeros(r4)
            goto L6c
        L5a:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            if (r0 != 0) goto L63
            r0 = r1
            r4 = r0
            goto L6c
        L63:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            long r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
            goto L22
        L6c:
            int r5 = r8.getFieldNumber()
            r9[r10] = r5
            int r5 = r10 + 1
            boolean r6 = r8.isEnforceUtf8()
            if (r6 == 0) goto L7d
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L7e
        L7d:
            r6 = r1
        L7e:
            boolean r7 = r8.isRequired()
            if (r7 == 0) goto L86
            r1 = 268435456(0x10000000, float:2.524355E-29)
        L86:
            r1 = r1 | r6
            int r2 = r2 << 20
            r1 = r1 | r2
            r1 = r1 | r3
            r9[r5] = r1
            int r1 = r10 + 2
            int r2 = r4 << 20
            r0 = r0 | r2
            r9[r1] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r0 = r8.getMapDefaultEntry()
            if (r0 == 0) goto Lbe
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r0 = r8.getMapDefaultEntry()
            r11[r10] = r0
            if (r9 == 0) goto Laf
            int r10 = r10 + 1
            r11[r10] = r9
            return
        Laf:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Ldb
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
            return
        Lbe:
            if (r9 == 0) goto Lc9
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r11[r10] = r9
            return
        Lc9:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto Ldb
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private void storeMessageField(T t9, int i, Object obj) {
        UNSAFE.putObject(t9, offset(typeAndOffsetAt(i)), obj);
        setFieldPresent(t9, i);
    }

    private void storeOneofMessageField(T t9, int i, int i6, Object obj) {
        UNSAFE.putObject(t9, offset(typeAndOffsetAt(i6)), obj);
        setOneofPresent(t9, i, i6);
    }

    private static int type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i) {
        return this.buffer[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrder(T r19, androidx.datastore.preferences.protobuf.Writer r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInAscendingOrder(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInDescendingOrder(T r11, androidx.datastore.preferences.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i, Object obj, int i6) throws IOException {
        if (obj != null) {
            writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i6)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i, (String) obj);
        } else {
            writer.writeBytes(i, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t9, Writer writer) throws IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t9), writer);
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public int getSerializedSize(T t9) {
        int i;
        int computeDoubleSize;
        int computeFloatSize;
        int computeInt64Size;
        int computeSizeMessage;
        int computeSizeFixed64ListNoTag;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        MessageSchema<T> messageSchema = this;
        T t10 = t9;
        Unsafe unsafe = UNSAFE;
        int i6 = 1048575;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 1048575;
        while (i10 < messageSchema.buffer.length) {
            int typeAndOffsetAt = messageSchema.typeAndOffsetAt(i10);
            int type = type(typeAndOffsetAt);
            int numberAt = messageSchema.numberAt(i10);
            int i14 = messageSchema.buffer[i10 + 2];
            int i15 = i14 & i6;
            if (type <= 17) {
                if (i15 != i13) {
                    i11 = i15 == i6 ? 0 : unsafe.getInt(t10, i15);
                    i13 = i15;
                }
                i = 1 << (i14 >>> 20);
            } else {
                i = 0;
            }
            int i16 = i12;
            long offset = offset(typeAndOffsetAt);
            if (type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) {
                i15 = 0;
            }
            switch (type) {
                case 0:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 1:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeFloatSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i12 = computeFloatSize + i16;
                        messageSchema = this;
                        t10 = t9;
                        break;
                    }
                    messageSchema = this;
                    t10 = t9;
                    i12 = i16;
                    break;
                case 2:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeInt64Size = CodedOutputStream.computeInt64Size(numberAt, unsafe.getLong(t10, offset));
                        i12 = computeInt64Size + i16;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i12 = i16;
                    break;
                case 3:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeInt64Size = CodedOutputStream.computeUInt64Size(numberAt, unsafe.getLong(t10, offset));
                        i12 = computeInt64Size + i16;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i12 = i16;
                    break;
                case 4:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeInt64Size = CodedOutputStream.computeInt32Size(numberAt, unsafe.getInt(t10, offset));
                        i12 = computeInt64Size + i16;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i12 = i16;
                    break;
                case 5:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeFloatSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i12 = computeFloatSize + i16;
                        messageSchema = this;
                        t10 = t9;
                        break;
                    }
                    messageSchema = this;
                    t10 = t9;
                    i12 = i16;
                    break;
                case 6:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeFloatSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i12 = computeFloatSize + i16;
                        messageSchema = this;
                        t10 = t9;
                        break;
                    }
                    messageSchema = this;
                    t10 = t9;
                    i12 = i16;
                    break;
                case 7:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeFloatSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i12 = computeFloatSize + i16;
                        messageSchema = this;
                        t10 = t9;
                        break;
                    }
                    messageSchema = this;
                    t10 = t9;
                    i12 = i16;
                    break;
                case 8:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        Object object = unsafe.getObject(t10, offset);
                        i12 = (object instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object) : CodedOutputStream.computeStringSize(numberAt, (String) object)) + i16;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i12 = i16;
                    break;
                case 9:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeSizeMessage = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t10, offset), messageSchema.getMessageFieldSchema(i10));
                        i12 = i16 + computeSizeMessage;
                        break;
                    }
                    i12 = i16;
                    break;
                case 10:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeInt64Size = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t10, offset));
                        i12 = computeInt64Size + i16;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i12 = i16;
                    break;
                case 11:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeInt64Size = CodedOutputStream.computeUInt32Size(numberAt, unsafe.getInt(t10, offset));
                        i12 = computeInt64Size + i16;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i12 = i16;
                    break;
                case 12:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeInt64Size = CodedOutputStream.computeEnumSize(numberAt, unsafe.getInt(t10, offset));
                        i12 = computeInt64Size + i16;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i12 = i16;
                    break;
                case 13:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeFloatSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i12 = computeFloatSize + i16;
                        messageSchema = this;
                        t10 = t9;
                        break;
                    }
                    messageSchema = this;
                    t10 = t9;
                    i12 = i16;
                    break;
                case 14:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeFloatSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i12 = computeFloatSize + i16;
                        messageSchema = this;
                        t10 = t9;
                        break;
                    }
                    messageSchema = this;
                    t10 = t9;
                    i12 = i16;
                    break;
                case 15:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeInt64Size = CodedOutputStream.computeSInt32Size(numberAt, unsafe.getInt(t10, offset));
                        i12 = computeInt64Size + i16;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i12 = i16;
                    break;
                case 16:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeInt64Size = CodedOutputStream.computeSInt64Size(numberAt, unsafe.getLong(t10, offset));
                        i12 = computeInt64Size + i16;
                        messageSchema = this;
                        break;
                    }
                    messageSchema = this;
                    i12 = i16;
                    break;
                case 17:
                    if (messageSchema.isFieldPresent(t10, i10, i13, i11, i)) {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t10, offset), messageSchema.getMessageFieldSchema(i10));
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 18:
                    computeSizeMessage = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 19:
                    computeSizeMessage = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 20:
                    computeSizeMessage = SchemaUtil.computeSizeInt64List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 21:
                    computeSizeMessage = SchemaUtil.computeSizeUInt64List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 22:
                    computeSizeMessage = SchemaUtil.computeSizeInt32List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 23:
                    computeSizeMessage = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 24:
                    computeSizeMessage = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 25:
                    computeSizeMessage = SchemaUtil.computeSizeBoolList(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 26:
                    computeSizeMessage = SchemaUtil.computeSizeStringList(numberAt, (List) unsafe.getObject(t10, offset));
                    i12 = i16 + computeSizeMessage;
                    break;
                case 27:
                    computeSizeMessage = SchemaUtil.computeSizeMessageList(numberAt, (List) unsafe.getObject(t10, offset), messageSchema.getMessageFieldSchema(i10));
                    i12 = i16 + computeSizeMessage;
                    break;
                case 28:
                    computeSizeMessage = SchemaUtil.computeSizeByteStringList(numberAt, (List) unsafe.getObject(t10, offset));
                    i12 = i16 + computeSizeMessage;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                    computeSizeMessage = SchemaUtil.computeSizeUInt32List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                    computeSizeMessage = SchemaUtil.computeSizeEnumList(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 31:
                    computeSizeMessage = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 32:
                    computeSizeMessage = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 33:
                    computeSizeMessage = SchemaUtil.computeSizeSInt32List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 34:
                    computeSizeMessage = SchemaUtil.computeSizeSInt64List(numberAt, (List) unsafe.getObject(t10, offset), false);
                    i12 = i16 + computeSizeMessage;
                    break;
                case 35:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 36:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 37:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 38:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 39:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 40:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 41:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 42:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 43:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 44:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 45:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 46:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 47:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t10, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t10, i15, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        i12 = computeUInt32SizeNoTag + computeTagSize + computeSizeFixed64ListNoTag + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 49:
                    computeSizeMessage = SchemaUtil.computeSizeGroupList(numberAt, (List) unsafe.getObject(t10, offset), messageSchema.getMessageFieldSchema(i10));
                    i12 = i16 + computeSizeMessage;
                    break;
                case 50:
                    computeSizeMessage = messageSchema.mapFieldSchema.getSerializedSize(numberAt, unsafe.getObject(t10, offset), messageSchema.getMapFieldDefaultEntry(i10));
                    i12 = i16 + computeSizeMessage;
                    break;
                case 51:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(t10, offset));
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(t10, offset));
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(t10, offset));
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 56:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 57:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 58:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 59:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        Object object2 = unsafe.getObject(t10, offset);
                        i12 = (object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(numberAt, (String) object2)) + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 60:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeSizeMessage = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t10, offset), messageSchema.getMessageFieldSchema(i10));
                        i12 = i16 + computeSizeMessage;
                        break;
                    }
                    i12 = i16;
                    break;
                case 61:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t10, offset));
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 62:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(t10, offset));
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(t10, offset));
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 64:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(t10, offset));
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(t10, offset));
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                case 68:
                    if (messageSchema.isOneofPresent(t10, numberAt, i10)) {
                        computeDoubleSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t10, offset), messageSchema.getMessageFieldSchema(i10));
                        i12 = computeDoubleSize + i16;
                        break;
                    }
                    i12 = i16;
                    break;
                default:
                    i12 = i16;
                    break;
            }
            i10 += 3;
            i6 = 1048575;
        }
        int unknownFieldsSerializedSize = i12 + messageSchema.getUnknownFieldsSerializedSize(messageSchema.unknownFieldSchema, t10);
        return messageSchema.hasExtensions ? unknownFieldsSerializedSize + messageSchema.extensionSchema.getExtensions(t10).getSerializedSize() : unknownFieldsSerializedSize;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public int hashCode(T t9) {
        int i;
        int hashLong;
        int i6;
        int i10;
        int length = this.buffer.length;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12 += 3) {
            int typeAndOffsetAt = typeAndOffsetAt(i12);
            int numberAt = numberAt(i12);
            long offset = offset(typeAndOffsetAt);
            int i13 = 37;
            switch (type(typeAndOffsetAt)) {
                case 0:
                    i = i11 * 53;
                    hashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t9, offset)));
                    i11 = hashLong + i;
                    break;
                case 1:
                    i = i11 * 53;
                    hashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t9, offset));
                    i11 = hashLong + i;
                    break;
                case 2:
                    i = i11 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t9, offset));
                    i11 = hashLong + i;
                    break;
                case 3:
                    i = i11 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t9, offset));
                    i11 = hashLong + i;
                    break;
                case 4:
                    i6 = i11 * 53;
                    i10 = UnsafeUtil.getInt(t9, offset);
                    i11 = i6 + i10;
                    break;
                case 5:
                    i = i11 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t9, offset));
                    i11 = hashLong + i;
                    break;
                case 6:
                    i6 = i11 * 53;
                    i10 = UnsafeUtil.getInt(t9, offset);
                    i11 = i6 + i10;
                    break;
                case 7:
                    i = i11 * 53;
                    hashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t9, offset));
                    i11 = hashLong + i;
                    break;
                case 8:
                    i = i11 * 53;
                    hashLong = ((String) UnsafeUtil.getObject(t9, offset)).hashCode();
                    i11 = hashLong + i;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t9, offset);
                    if (object != null) {
                        i13 = object.hashCode();
                    }
                    i11 = (i11 * 53) + i13;
                    break;
                case 10:
                    i = i11 * 53;
                    hashLong = UnsafeUtil.getObject(t9, offset).hashCode();
                    i11 = hashLong + i;
                    break;
                case 11:
                    i6 = i11 * 53;
                    i10 = UnsafeUtil.getInt(t9, offset);
                    i11 = i6 + i10;
                    break;
                case 12:
                    i6 = i11 * 53;
                    i10 = UnsafeUtil.getInt(t9, offset);
                    i11 = i6 + i10;
                    break;
                case 13:
                    i6 = i11 * 53;
                    i10 = UnsafeUtil.getInt(t9, offset);
                    i11 = i6 + i10;
                    break;
                case 14:
                    i = i11 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t9, offset));
                    i11 = hashLong + i;
                    break;
                case 15:
                    i6 = i11 * 53;
                    i10 = UnsafeUtil.getInt(t9, offset);
                    i11 = i6 + i10;
                    break;
                case 16:
                    i = i11 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t9, offset));
                    i11 = hashLong + i;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t9, offset);
                    if (object2 != null) {
                        i13 = object2.hashCode();
                    }
                    i11 = (i11 * 53) + i13;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case 49:
                    i = i11 * 53;
                    hashLong = UnsafeUtil.getObject(t9, offset).hashCode();
                    i11 = hashLong + i;
                    break;
                case 50:
                    i = i11 * 53;
                    hashLong = UnsafeUtil.getObject(t9, offset).hashCode();
                    i11 = hashLong + i;
                    break;
                case 51:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t9, offset)));
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = Float.floatToIntBits(oneofFloatAt(t9, offset));
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t9, offset));
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t9, offset));
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i6 = i11 * 53;
                        i10 = oneofIntAt(t9, offset);
                        i11 = i6 + i10;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t9, offset));
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i6 = i11 * 53;
                        i10 = oneofIntAt(t9, offset);
                        i11 = i6 + i10;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = Internal.hashBoolean(oneofBooleanAt(t9, offset));
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = ((String) UnsafeUtil.getObject(t9, offset)).hashCode();
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = UnsafeUtil.getObject(t9, offset).hashCode();
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = UnsafeUtil.getObject(t9, offset).hashCode();
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i6 = i11 * 53;
                        i10 = oneofIntAt(t9, offset);
                        i11 = i6 + i10;
                        break;
                    } else {
                        break;
                    }
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i6 = i11 * 53;
                        i10 = oneofIntAt(t9, offset);
                        i11 = i6 + i10;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i6 = i11 * 53;
                        i10 = oneofIntAt(t9, offset);
                        i11 = i6 + i10;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t9, offset));
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i6 = i11 * 53;
                        i10 = oneofIntAt(t9, offset);
                        i11 = i6 + i10;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t9, offset));
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t9, numberAt, i12)) {
                        i = i11 * 53;
                        hashLong = UnsafeUtil.getObject(t9, offset).hashCode();
                        i11 = hashLong + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = this.unknownFieldSchema.getFromMessage(t9).hashCode() + (i11 * 53);
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(t9).hashCode() : hashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean isInitialized(T t9) {
        int i;
        int i6;
        int i10 = 1048575;
        int i11 = 0;
        int i12 = 0;
        while (i11 < this.checkInitializedCount) {
            int i13 = this.intArray[i11];
            int numberAt = numberAt(i13);
            int typeAndOffsetAt = typeAndOffsetAt(i13);
            int i14 = this.buffer[i13 + 2];
            int i15 = i14 & 1048575;
            int i16 = 1 << (i14 >>> 20);
            if (i15 != i10) {
                if (i15 != 1048575) {
                    i12 = UNSAFE.getInt(t9, i15);
                }
                i6 = i12;
                i = i15;
            } else {
                i = i10;
                i6 = i12;
            }
            T t10 = t9;
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t10, i13, i, i6, i16)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t10, numberAt, i13) && !isInitialized(t10, typeAndOffsetAt, getMessageFieldSchema(i13))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t10, typeAndOffsetAt, i13)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t10, typeAndOffsetAt, i13)) {
                    return false;
                }
            } else if (isFieldPresent(t10, i13, i, i6, i16) && !isInitialized(t10, typeAndOffsetAt, getMessageFieldSchema(i13))) {
                return false;
            }
            i11++;
            t9 = t10;
            i10 = i;
            i12 = i6;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t9).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public void makeImmutable(T t9) {
        if (isMutable(t9)) {
            if (t9 instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t9;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i = 0; i < length; i += 3) {
                int typeAndOffsetAt = typeAndOffsetAt(i);
                long offset = offset(typeAndOffsetAt);
                int type = type(typeAndOffsetAt);
                if (type != 9) {
                    if (type != 60 && type != 68) {
                        switch (type) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HORIZONTAL_BIAS /* 29 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS /* 30 */:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                            case 49:
                                this.listFieldSchema.makeImmutableListAt(t9, offset);
                                break;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(t9, offset);
                                if (object != null) {
                                    unsafe.putObject(t9, offset, this.mapFieldSchema.toImmutable(object));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (isOneofPresent(t9, numberAt(i), i)) {
                        getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t9, offset));
                    }
                }
                if (isFieldPresent(t9, i)) {
                    getMessageFieldSchema(i).makeImmutable(UNSAFE.getObject(t9, offset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t9);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t9);
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t9, T t10) {
        checkMutable(t9);
        t10.getClass();
        for (int i = 0; i < this.buffer.length; i += 3) {
            mergeSingleField(t9, t10, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t9, t10);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t9, t10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:106:0x009d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0410 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0422  */
    @androidx.datastore.preferences.protobuf.CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int parseMessage(T r27, byte[] r28, int r29, int r30, int r31, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.parseMessage(java.lang.Object, byte[], int, int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void writeTo(T t9, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t9, writer);
        } else {
            writeFieldsInAscendingOrder(t9, writer);
        }
    }

    private int positionForFieldNumber(int i, int i6) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t9, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        checkMutable(t9);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t9, reader, extensionRegistryLite);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t9, byte[] bArr, int i, int i6, ArrayDecoders.Registers registers) throws IOException {
        parseMessage(t9, bArr, i, i6, 0, registers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i)));
    }

    private boolean isFieldPresent(T t9, int i, int i6, int i10, int i11) {
        if (i6 == 1048575) {
            return isFieldPresent(t9, i);
        }
        return (i10 & i11) != 0;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public boolean equals(T t9, T t10) {
        int length = this.buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!equals(t9, t10, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t9).equals(this.unknownFieldSchema.getFromMessage(t10))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t9).equals(this.extensionSchema.getExtensions(t10));
        }
        return true;
    }
}
