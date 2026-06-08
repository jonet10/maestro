package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.WireFormat;
import com.google.gson.internal.a;
import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@CheckReturnValue
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class ArrayDecoders {
    static final int DEFAULT_RECURSION_LIMIT = 100;
    private static volatile int recursionLimit = 100;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.datastore.preferences.protobuf.ArrayDecoders$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    private ArrayDecoders() {
    }

    private static void checkRecursionLimit(int i) throws InvalidProtocolBufferException {
        if (i >= recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public static int decodeBoolList(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i6, registers);
        booleanArrayList.addBoolean(registers.long1 != 0);
        while (decodeVarint64 < i10) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        return decodeVarint64;
    }

    public static int decodeBytes(byte[] bArr, int i, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i6 > bArr.length - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i6 == 0) {
            registers.object1 = ByteString.EMPTY;
            return decodeVarint32;
        }
        registers.object1 = ByteString.copyFrom(bArr, decodeVarint32, i6);
        return decodeVarint32 + i6;
    }

    public static int decodeBytesList(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i6, registers);
        int i11 = registers.int1;
        if (i11 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i11 > bArr.length - decodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i11 == 0) {
            protobufList.add(ByteString.EMPTY);
        } else {
            protobufList.add(ByteString.copyFrom(bArr, decodeVarint32, i11));
            decodeVarint32 += i11;
        }
        while (decodeVarint32 < i10) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            int i12 = registers.int1;
            if (i12 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i12 > bArr.length - decodeVarint32) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i12 == 0) {
                protobufList.add(ByteString.EMPTY);
            } else {
                protobufList.add(ByteString.copyFrom(bArr, decodeVarint32, i12));
                decodeVarint32 += i12;
            }
        }
        return decodeVarint32;
    }

    public static double decodeDouble(byte[] bArr, int i) {
        return Double.longBitsToDouble(decodeFixed64(bArr, i));
    }

    public static int decodeDoubleList(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        doubleArrayList.addDouble(decodeDouble(bArr, i6));
        int i11 = i6 + 8;
        while (i11 < i10) {
            int decodeVarint32 = decodeVarint32(bArr, i11, registers);
            if (i != registers.int1) {
                break;
            }
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            i11 = decodeVarint32 + 8;
        }
        return i11;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int decodeExtension(int i, byte[] bArr, int i6, int i10, GeneratedMessageLite.ExtendableMessage<?, ?> extendableMessage, GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        int i11;
        int i12;
        FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = extendableMessage.extensions;
        int i13 = i >>> 3;
        if (generatedExtension.descriptor.isRepeated() && generatedExtension.descriptor.isPacked()) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    DoubleArrayList doubleArrayList = new DoubleArrayList();
                    int decodePackedDoubleList = decodePackedDoubleList(bArr, i6, doubleArrayList, registers);
                    fieldSet.setField(generatedExtension.descriptor, doubleArrayList);
                    return decodePackedDoubleList;
                case 2:
                    FloatArrayList floatArrayList = new FloatArrayList();
                    int decodePackedFloatList = decodePackedFloatList(bArr, i6, floatArrayList, registers);
                    fieldSet.setField(generatedExtension.descriptor, floatArrayList);
                    return decodePackedFloatList;
                case 3:
                case 4:
                    LongArrayList longArrayList = new LongArrayList();
                    int decodePackedVarint64List = decodePackedVarint64List(bArr, i6, longArrayList, registers);
                    fieldSet.setField(generatedExtension.descriptor, longArrayList);
                    return decodePackedVarint64List;
                case 5:
                case 6:
                    IntArrayList intArrayList = new IntArrayList();
                    int decodePackedVarint32List = decodePackedVarint32List(bArr, i6, intArrayList, registers);
                    fieldSet.setField(generatedExtension.descriptor, intArrayList);
                    return decodePackedVarint32List;
                case 7:
                case 8:
                    LongArrayList longArrayList2 = new LongArrayList();
                    int decodePackedFixed64List = decodePackedFixed64List(bArr, i6, longArrayList2, registers);
                    fieldSet.setField(generatedExtension.descriptor, longArrayList2);
                    return decodePackedFixed64List;
                case 9:
                case 10:
                    IntArrayList intArrayList2 = new IntArrayList();
                    int decodePackedFixed32List = decodePackedFixed32List(bArr, i6, intArrayList2, registers);
                    fieldSet.setField(generatedExtension.descriptor, intArrayList2);
                    return decodePackedFixed32List;
                case 11:
                    BooleanArrayList booleanArrayList = new BooleanArrayList();
                    int decodePackedBoolList = decodePackedBoolList(bArr, i6, booleanArrayList, registers);
                    fieldSet.setField(generatedExtension.descriptor, booleanArrayList);
                    return decodePackedBoolList;
                case 12:
                    IntArrayList intArrayList3 = new IntArrayList();
                    int decodePackedSInt32List = decodePackedSInt32List(bArr, i6, intArrayList3, registers);
                    fieldSet.setField(generatedExtension.descriptor, intArrayList3);
                    return decodePackedSInt32List;
                case 13:
                    LongArrayList longArrayList3 = new LongArrayList();
                    int decodePackedSInt64List = decodePackedSInt64List(bArr, i6, longArrayList3, registers);
                    fieldSet.setField(generatedExtension.descriptor, longArrayList3);
                    return decodePackedSInt64List;
                case 14:
                    IntArrayList intArrayList4 = new IntArrayList();
                    int decodePackedVarint32List2 = decodePackedVarint32List(bArr, i6, intArrayList4, registers);
                    SchemaUtil.filterUnknownEnumList((Object) extendableMessage, i13, (List<Integer>) intArrayList4, generatedExtension.descriptor.getEnumType(), (Object) null, (UnknownFieldSchema<UT, Object>) unknownFieldSchema);
                    fieldSet.setField(generatedExtension.descriptor, intArrayList4);
                    return decodePackedVarint32List2;
                default:
                    a.h(generatedExtension.descriptor.getLiteType(), "Type cannot be packed: ");
                    return 0;
            }
        }
        Object obj = null;
        if (generatedExtension.getLiteType() == WireFormat.FieldType.ENUM) {
            i6 = decodeVarint32(bArr, i6, registers);
            Object findValueByNumber = generatedExtension.descriptor.getEnumType().findValueByNumber(registers.int1);
            int i14 = registers.int1;
            if (findValueByNumber == null) {
                SchemaUtil.storeUnknownEnum(extendableMessage, i13, i14, null, unknownFieldSchema);
                return i6;
            }
            obj = Integer.valueOf(i14);
        } else {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    i11 = i6;
                    obj = Double.valueOf(decodeDouble(bArr, i11));
                    i6 = i11 + 8;
                    break;
                case 2:
                    i12 = i6;
                    obj = Float.valueOf(decodeFloat(bArr, i12));
                    i6 = i12 + 4;
                    break;
                case 3:
                case 4:
                    i6 = decodeVarint64(bArr, i6, registers);
                    obj = Long.valueOf(registers.long1);
                    break;
                case 5:
                case 6:
                    i6 = decodeVarint32(bArr, i6, registers);
                    obj = Integer.valueOf(registers.int1);
                    break;
                case 7:
                case 8:
                    i11 = i6;
                    obj = Long.valueOf(decodeFixed64(bArr, i11));
                    i6 = i11 + 8;
                    break;
                case 9:
                case 10:
                    i12 = i6;
                    obj = Integer.valueOf(decodeFixed32(bArr, i12));
                    i6 = i12 + 4;
                    break;
                case 11:
                    i6 = decodeVarint64(bArr, i6, registers);
                    obj = Boolean.valueOf(registers.long1 != 0);
                    break;
                case 12:
                    i6 = decodeVarint32(bArr, i6, registers);
                    obj = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                    break;
                case 13:
                    i6 = decodeVarint64(bArr, i6, registers);
                    obj = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                    break;
                case 14:
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Shouldn't reach here.");
                    return 0;
                case 15:
                    i6 = decodeBytes(bArr, i6, registers);
                    obj = registers.object1;
                    break;
                case 16:
                    i6 = decodeString(bArr, i6, registers);
                    obj = registers.object1;
                    break;
                case 17:
                    int i15 = (i13 << 3) | 4;
                    Schema schemaFor = Protobuf.getInstance().schemaFor((Class) generatedExtension.getMessageDefaultInstance().getClass());
                    if (generatedExtension.isRepeated()) {
                        int decodeGroupField = decodeGroupField(schemaFor, bArr, i6, i10, i15, registers);
                        fieldSet.addRepeatedField(generatedExtension.descriptor, registers.object1);
                        return decodeGroupField;
                    }
                    Object field = fieldSet.getField(generatedExtension.descriptor);
                    if (field == null) {
                        field = schemaFor.newInstance();
                        fieldSet.setField(generatedExtension.descriptor, field);
                    }
                    return mergeGroupField(field, schemaFor, bArr, i6, i10, i15, registers);
                case 18:
                    Schema schemaFor2 = Protobuf.getInstance().schemaFor((Class) generatedExtension.getMessageDefaultInstance().getClass());
                    if (generatedExtension.isRepeated()) {
                        int decodeMessageField = decodeMessageField(schemaFor2, bArr, i6, i10, registers);
                        fieldSet.addRepeatedField(generatedExtension.descriptor, registers.object1);
                        return decodeMessageField;
                    }
                    Object field2 = fieldSet.getField(generatedExtension.descriptor);
                    if (field2 == null) {
                        field2 = schemaFor2.newInstance();
                        fieldSet.setField(generatedExtension.descriptor, field2);
                    }
                    return mergeMessageField(field2, schemaFor2, bArr, i6, i10, registers);
            }
        }
        boolean isRepeated = generatedExtension.isRepeated();
        GeneratedMessageLite.ExtensionDescriptor extensionDescriptor = generatedExtension.descriptor;
        if (isRepeated) {
            fieldSet.addRepeatedField(extensionDescriptor, obj);
            return i6;
        }
        fieldSet.setField(extensionDescriptor, obj);
        return i6;
    }

    public static int decodeExtensionOrUnknownField(int i, byte[] bArr, int i6, int i10, Object obj, MessageLite messageLite, UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> unknownFieldSchema, Registers registers) throws IOException {
        GeneratedMessageLite.GeneratedExtension findLiteExtensionByNumber = registers.extensionRegistry.findLiteExtensionByNumber(messageLite, i >>> 3);
        if (findLiteExtensionByNumber == null) {
            return decodeUnknownField(i, bArr, i6, i10, MessageSchema.getMutableUnknownFields(obj), registers);
        }
        GeneratedMessageLite.ExtendableMessage extendableMessage = (GeneratedMessageLite.ExtendableMessage) obj;
        extendableMessage.ensureExtensionsAreMutable();
        return decodeExtension(i, bArr, i6, i10, extendableMessage, findLiteExtensionByNumber, unknownFieldSchema, registers);
    }

    public static int decodeFixed32(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int decodeFixed32List(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        intArrayList.addInt(decodeFixed32(bArr, i6));
        int i11 = i6 + 4;
        while (i11 < i10) {
            int decodeVarint32 = decodeVarint32(bArr, i11, registers);
            if (i != registers.int1) {
                break;
            }
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            i11 = decodeVarint32 + 4;
        }
        return i11;
    }

    public static long decodeFixed64(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public static int decodeFixed64List(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        longArrayList.addLong(decodeFixed64(bArr, i6));
        int i11 = i6 + 8;
        while (i11 < i10) {
            int decodeVarint32 = decodeVarint32(bArr, i11, registers);
            if (i != registers.int1) {
                break;
            }
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            i11 = decodeVarint32 + 8;
        }
        return i11;
    }

    public static float decodeFloat(byte[] bArr, int i) {
        return Float.intBitsToFloat(decodeFixed32(bArr, i));
    }

    public static int decodeFloatList(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        floatArrayList.addFloat(decodeFloat(bArr, i6));
        int i11 = i6 + 4;
        while (i11 < i10) {
            int decodeVarint32 = decodeVarint32(bArr, i11, registers);
            if (i != registers.int1) {
                break;
            }
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            i11 = decodeVarint32 + 4;
        }
        return i11;
    }

    public static int decodeGroupField(Schema schema, byte[] bArr, int i, int i6, int i10, Registers registers) throws IOException {
        Object newInstance = schema.newInstance();
        int mergeGroupField = mergeGroupField(newInstance, schema, bArr, i, i6, i10, registers);
        schema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return mergeGroupField;
    }

    public static int decodeGroupList(Schema schema, int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int i11 = (i & (-8)) | 4;
        int decodeGroupField = decodeGroupField(schema, bArr, i6, i10, i11, registers);
        protobufList.add(registers.object1);
        while (decodeGroupField < i10) {
            int decodeVarint32 = decodeVarint32(bArr, decodeGroupField, registers);
            if (i != registers.int1) {
                break;
            }
            decodeGroupField = decodeGroupField(schema, bArr, decodeVarint32, i10, i11, registers);
            protobufList.add(registers.object1);
        }
        return decodeGroupField;
    }

    public static int decodeMessageField(Schema schema, byte[] bArr, int i, int i6, Registers registers) throws IOException {
        Object newInstance = schema.newInstance();
        int mergeMessageField = mergeMessageField(newInstance, schema, bArr, i, i6, registers);
        schema.makeImmutable(newInstance);
        registers.object1 = newInstance;
        return mergeMessageField;
    }

    public static int decodeMessageList(Schema<?> schema, int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        int decodeMessageField = decodeMessageField(schema, bArr, i6, i10, registers);
        protobufList.add(registers.object1);
        while (decodeMessageField < i10) {
            int decodeVarint32 = decodeVarint32(bArr, decodeMessageField, registers);
            if (i != registers.int1) {
                break;
            }
            decodeMessageField = decodeMessageField(schema, bArr, decodeVarint32, i10, registers);
            protobufList.add(registers.object1);
        }
        return decodeMessageField;
    }

    public static int decodePackedBoolList(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        BooleanArrayList booleanArrayList = (BooleanArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            booleanArrayList.addBoolean(registers.long1 != 0);
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedDoubleList(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        DoubleArrayList doubleArrayList = (DoubleArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            doubleArrayList.addDouble(decodeDouble(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed32List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            intArrayList.addInt(decodeFixed32(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFixed64List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            longArrayList.addLong(decodeFixed64(bArr, decodeVarint32));
            decodeVarint32 += 8;
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedFloatList(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        FloatArrayList floatArrayList = (FloatArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            floatArrayList.addFloat(decodeFloat(bArr, decodeVarint32));
            decodeVarint32 += 4;
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt32List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedSInt64List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint32List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            decodeVarint32 = decodeVarint32(bArr, decodeVarint32, registers);
            intArrayList.addInt(registers.int1);
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodePackedVarint64List(byte[] bArr, int i, Internal.ProtobufList<?> protobufList, Registers registers) throws IOException {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1 + decodeVarint32;
        while (decodeVarint32 < i6) {
            decodeVarint32 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        if (decodeVarint32 == i6) {
            return decodeVarint32;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static int decodeSInt32List(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i6, registers);
        intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        while (decodeVarint32 < i10) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(CodedInputStream.decodeZigZag32(registers.int1));
        }
        return decodeVarint32;
    }

    public static int decodeSInt64List(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i6, registers);
        longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        while (decodeVarint64 < i10) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(CodedInputStream.decodeZigZag64(registers.long1));
        }
        return decodeVarint64;
    }

    public static int decodeString(byte[] bArr, int i, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i6 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        }
        registers.object1 = new String(bArr, decodeVarint32, i6, Internal.UTF_8);
        return decodeVarint32 + i6;
    }

    public static int decodeStringList(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i6, registers);
        int i11 = registers.int1;
        if (i11 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i11 == 0) {
            protobufList.add("");
        } else {
            protobufList.add(new String(bArr, decodeVarint32, i11, Internal.UTF_8));
            decodeVarint32 += i11;
        }
        while (decodeVarint32 < i10) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            int i12 = registers.int1;
            if (i12 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i12 == 0) {
                protobufList.add("");
            } else {
                protobufList.add(new String(bArr, decodeVarint32, i12, Internal.UTF_8));
                decodeVarint32 += i12;
            }
        }
        return decodeVarint32;
    }

    public static int decodeStringListRequireUtf8(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i6, registers);
        int i11 = registers.int1;
        if (i11 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i11 == 0) {
            protobufList.add("");
        } else {
            int i12 = decodeVarint32 + i11;
            if (!Utf8.isValidUtf8(bArr, decodeVarint32, i12)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            protobufList.add(new String(bArr, decodeVarint32, i11, Internal.UTF_8));
            decodeVarint32 = i12;
        }
        while (decodeVarint32 < i10) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            int i13 = registers.int1;
            if (i13 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i13 == 0) {
                protobufList.add("");
            } else {
                int i14 = decodeVarint32 + i13;
                if (!Utf8.isValidUtf8(bArr, decodeVarint32, i14)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                protobufList.add(new String(bArr, decodeVarint32, i13, Internal.UTF_8));
                decodeVarint32 = i14;
            }
        }
        return decodeVarint32;
    }

    public static int decodeStringRequireUtf8(byte[] bArr, int i, Registers registers) throws InvalidProtocolBufferException {
        int decodeVarint32 = decodeVarint32(bArr, i, registers);
        int i6 = registers.int1;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        if (i6 == 0) {
            registers.object1 = "";
            return decodeVarint32;
        }
        registers.object1 = Utf8.decodeUtf8(bArr, decodeVarint32, i6);
        return decodeVarint32 + i6;
    }

    public static int decodeUnknownField(int i, byte[] bArr, int i6, int i10, UnknownFieldSetLite unknownFieldSetLite, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            int decodeVarint64 = decodeVarint64(bArr, i6, registers);
            unknownFieldSetLite.storeField(i, Long.valueOf(registers.long1));
            return decodeVarint64;
        }
        if (tagWireType == 1) {
            unknownFieldSetLite.storeField(i, Long.valueOf(decodeFixed64(bArr, i6)));
            return i6 + 8;
        }
        if (tagWireType == 2) {
            int decodeVarint32 = decodeVarint32(bArr, i6, registers);
            int i11 = registers.int1;
            if (i11 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (i11 > bArr.length - decodeVarint32) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i11 == 0) {
                unknownFieldSetLite.storeField(i, ByteString.EMPTY);
            } else {
                unknownFieldSetLite.storeField(i, ByteString.copyFrom(bArr, decodeVarint32, i11));
            }
            return decodeVarint32 + i11;
        }
        if (tagWireType != 3) {
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidTag();
            }
            unknownFieldSetLite.storeField(i, Integer.valueOf(decodeFixed32(bArr, i6)));
            return i6 + 4;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        int i12 = (i & (-8)) | 4;
        int i13 = registers.recursionDepth + 1;
        registers.recursionDepth = i13;
        checkRecursionLimit(i13);
        int i14 = 0;
        while (true) {
            if (i6 >= i10) {
                break;
            }
            int decodeVarint322 = decodeVarint32(bArr, i6, registers);
            i14 = registers.int1;
            if (i14 == i12) {
                i6 = decodeVarint322;
                break;
            }
            i6 = decodeUnknownField(i14, bArr, decodeVarint322, i10, newInstance, registers);
        }
        registers.recursionDepth--;
        if (i6 > i10 || i14 != i12) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        unknownFieldSetLite.storeField(i, newInstance);
        return i6;
    }

    public static int decodeVarint32(int i, byte[] bArr, int i6, Registers registers) {
        int i10 = i & 127;
        int i11 = i6 + 1;
        byte b7 = bArr[i6];
        if (b7 >= 0) {
            registers.int1 = i10 | (b7 << 7);
            return i11;
        }
        int i12 = i10 | ((b7 & Byte.MAX_VALUE) << 7);
        int i13 = i6 + 2;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            registers.int1 = i12 | (b10 << 14);
            return i13;
        }
        int i14 = i12 | ((b10 & Byte.MAX_VALUE) << 14);
        int i15 = i6 + 3;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            registers.int1 = i14 | (b11 << 21);
            return i15;
        }
        int i16 = i14 | ((b11 & Byte.MAX_VALUE) << 21);
        int i17 = i6 + 4;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            registers.int1 = i16 | (b12 << 28);
            return i17;
        }
        int i18 = i16 | ((b12 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i19 = i17 + 1;
            if (bArr[i17] >= 0) {
                registers.int1 = i18;
                return i19;
            }
            i17 = i19;
        }
    }

    public static int decodeVarint32List(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        IntArrayList intArrayList = (IntArrayList) protobufList;
        int decodeVarint32 = decodeVarint32(bArr, i6, registers);
        intArrayList.addInt(registers.int1);
        while (decodeVarint32 < i10) {
            int decodeVarint322 = decodeVarint32(bArr, decodeVarint32, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint32 = decodeVarint32(bArr, decodeVarint322, registers);
            intArrayList.addInt(registers.int1);
        }
        return decodeVarint32;
    }

    public static int decodeVarint64(long j, byte[] bArr, int i, Registers registers) {
        int i6 = i + 1;
        byte b7 = bArr[i];
        long j6 = (j & 127) | ((b7 & Byte.MAX_VALUE) << 7);
        int i10 = 7;
        while (b7 < 0) {
            int i11 = i6 + 1;
            byte b10 = bArr[i6];
            i10 += 7;
            j6 |= (b10 & Byte.MAX_VALUE) << i10;
            i6 = i11;
            b7 = b10;
        }
        registers.long1 = j6;
        return i6;
    }

    public static int decodeVarint64List(int i, byte[] bArr, int i6, int i10, Internal.ProtobufList<?> protobufList, Registers registers) {
        LongArrayList longArrayList = (LongArrayList) protobufList;
        int decodeVarint64 = decodeVarint64(bArr, i6, registers);
        longArrayList.addLong(registers.long1);
        while (decodeVarint64 < i10) {
            int decodeVarint32 = decodeVarint32(bArr, decodeVarint64, registers);
            if (i != registers.int1) {
                break;
            }
            decodeVarint64 = decodeVarint64(bArr, decodeVarint32, registers);
            longArrayList.addLong(registers.long1);
        }
        return decodeVarint64;
    }

    public static int mergeGroupField(Object obj, Schema schema, byte[] bArr, int i, int i6, int i10, Registers registers) throws IOException {
        int i11 = registers.recursionDepth + 1;
        registers.recursionDepth = i11;
        checkRecursionLimit(i11);
        int parseMessage = ((MessageSchema) schema).parseMessage(obj, bArr, i, i6, i10, registers);
        registers.recursionDepth--;
        registers.object1 = obj;
        return parseMessage;
    }

    public static int mergeMessageField(Object obj, Schema schema, byte[] bArr, int i, int i6, Registers registers) throws IOException {
        int i10 = i + 1;
        int i11 = bArr[i];
        if (i11 < 0) {
            i10 = decodeVarint32(i11, bArr, i10, registers);
            i11 = registers.int1;
        }
        int i12 = i10;
        if (i11 < 0 || i11 > i6 - i12) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i13 = registers.recursionDepth + 1;
        registers.recursionDepth = i13;
        checkRecursionLimit(i13);
        int i14 = i12 + i11;
        schema.mergeFrom(obj, bArr, i12, i14, registers);
        registers.recursionDepth--;
        registers.object1 = obj;
        return i14;
    }

    public static void setRecursionLimit(int i) {
        recursionLimit = i;
    }

    public static int skipField(int i, byte[] bArr, int i6, int i10, Registers registers) throws InvalidProtocolBufferException {
        if (WireFormat.getTagFieldNumber(i) == 0) {
            throw InvalidProtocolBufferException.invalidTag();
        }
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            return decodeVarint64(bArr, i6, registers);
        }
        if (tagWireType == 1) {
            return i6 + 8;
        }
        if (tagWireType == 2) {
            return decodeVarint32(bArr, i6, registers) + registers.int1;
        }
        if (tagWireType != 3) {
            if (tagWireType == 5) {
                return i6 + 4;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        int i11 = (i & (-8)) | 4;
        int i12 = 0;
        while (i6 < i10) {
            i6 = decodeVarint32(bArr, i6, registers);
            i12 = registers.int1;
            if (i12 == i11) {
                break;
            }
            i6 = skipField(i12, bArr, i6, i10, registers);
        }
        if (i6 > i10 || i12 != i11) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i6;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Registers {
        public final ExtensionRegistryLite extensionRegistry;
        public int int1;
        public long long1;
        public Object object1;
        public int recursionDepth;

        public Registers() {
            this.extensionRegistry = ExtensionRegistryLite.getEmptyRegistry();
        }

        public Registers(ExtensionRegistryLite extensionRegistryLite) {
            extensionRegistryLite.getClass();
            this.extensionRegistry = extensionRegistryLite;
        }
    }

    public static int decodeVarint64(byte[] bArr, int i, Registers registers) {
        int i6 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            registers.long1 = j;
            return i6;
        }
        return decodeVarint64(j, bArr, i6, registers);
    }

    public static int decodeVarint32(byte[] bArr, int i, Registers registers) {
        int i6 = i + 1;
        byte b7 = bArr[i];
        if (b7 >= 0) {
            registers.int1 = b7;
            return i6;
        }
        return decodeVarint32(b7, bArr, i6, registers);
    }
}
