package androidx.datastore.preferences.protobuf;

import a3.b;
import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.LazyField;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import com.google.gson.internal.a;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class FieldSet<T extends FieldDescriptorLite<T>> {
    private static final FieldSet<?> DEFAULT_INSTANCE = new FieldSet<>(true);
    private final SmallSortedMap<T, Object> fields;
    private boolean hasLazyField;
    private boolean isImmutable;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.datastore.preferences.protobuf.FieldSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    private FieldSet(boolean z9) {
        this(SmallSortedMap.newFieldMap());
        makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> SmallSortedMap<T, Object> cloneAllFieldsMap(SmallSortedMap<T, Object> smallSortedMap, boolean z9, boolean z10) {
        SmallSortedMap<T, Object> newFieldMap = SmallSortedMap.newFieldMap();
        int numArrayEntries = smallSortedMap.getNumArrayEntries();
        for (int i = 0; i < numArrayEntries; i++) {
            cloneFieldEntry(newFieldMap, smallSortedMap.getArrayEntryAt(i), z9, z10);
        }
        Iterator<Map.Entry<T, Object>> it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            cloneFieldEntry(newFieldMap, it.next(), z9, z10);
        }
        return newFieldMap;
    }

    private static <T extends FieldDescriptorLite<T>> void cloneFieldEntry(Map<T, Object> map, Map.Entry<T, Object> entry, boolean z9, boolean z10) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (z10 && (value instanceof LazyField)) {
            map.put(key, ((LazyField) value).getValue());
        } else if (z9 && (value instanceof List)) {
            map.put(key, new ArrayList((List) value));
        } else {
            map.put(key, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object cloneIfMutable(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int computeElementSize(WireFormat.FieldType fieldType, int i, Object obj) {
        int computeTagSize = CodedOutputStream.computeTagSize(i);
        if (fieldType == WireFormat.FieldType.GROUP) {
            computeTagSize *= 2;
        }
        return computeTagSize + computeElementSizeNoTag(fieldType, obj);
    }

    public static int computeElementSizeNoTag(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
            case 10:
                return obj instanceof LazyField ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            case 11:
                return obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 12:
                return obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 13:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            case 18:
                return obj instanceof Internal.EnumLite ? CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber()) : CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            default:
                b.n("There is no way to get here, but the compiler thinks otherwise.");
                return 0;
        }
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            return computeElementSize(liteType, number, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!fieldDescriptorLite.isPacked()) {
            int i6 = 0;
            while (i < size) {
                i6 += computeElementSize(liteType, number, list.get(i));
                i++;
            }
            return i6;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int i10 = 0;
        while (i < size) {
            i10 += computeElementSizeNoTag(liteType, list.get(i));
            i++;
        }
        return CodedOutputStream.computeUInt32SizeNoTag(i10) + CodedOutputStream.computeTagSize(number) + i10;
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        return (FieldSet<T>) DEFAULT_INSTANCE;
    }

    private int getMessageSetSerializedSize(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        return (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) ? computeFieldSize(key, value) : value instanceof LazyField ? CodedOutputStream.computeLazyFieldMessageSetExtensionSize(entry.getKey().getNumber(), (LazyField) value) : CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite) value);
    }

    public static int getWireFormatForFieldType(WireFormat.FieldType fieldType, boolean z9) {
        if (z9) {
            return 2;
        }
        return fieldType.getWireType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends FieldDescriptorLite<T>> boolean isInitialized(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        if (!key.isRepeated()) {
            return isMessageFieldValueInitialized(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!isMessageFieldValueInitialized(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMessageFieldValueInitialized(Object obj) {
        if (obj instanceof MessageLiteOrBuilder) {
            return ((MessageLiteOrBuilder) obj).isInitialized();
        }
        if (obj instanceof LazyField) {
            return true;
        }
        a.p("Wrong object type used with protocol message reflection.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidType(WireFormat.FieldType fieldType, Object obj) {
        Internal.checkNotNull(obj);
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[fieldType.getJavaType().ordinal()]) {
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof Internal.EnumLite)) {
                }
                break;
            case 9:
                if ((obj instanceof MessageLite) || (obj instanceof LazyField)) {
                }
                break;
        }
        return false;
    }

    private void mergeFromField(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        boolean z9 = value instanceof LazyField;
        if (key.isRepeated()) {
            if (z9) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Lazy fields can not be repeated");
                return;
            }
            Object field = getField(key);
            if (field == null) {
                field = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) field).add(cloneIfMutable(it.next()));
            }
            this.fields.put((SmallSortedMap<T, Object>) key, (T) field);
            return;
        }
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
            if (z9) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Lazy fields must be message-valued");
                return;
            } else {
                this.fields.put((SmallSortedMap<T, Object>) key, (T) cloneIfMutable(value));
                return;
            }
        }
        Object field2 = getField(key);
        if (field2 == null) {
            this.fields.put((SmallSortedMap<T, Object>) key, (T) cloneIfMutable(value));
            if (z9) {
                this.hasLazyField = true;
                return;
            }
            return;
        }
        if (z9) {
            value = ((LazyField) value).getValue();
        }
        this.fields.put((SmallSortedMap<T, Object>) key, (T) key.internalMergeFrom(((MessageLite) field2).toBuilder(), (MessageLite) value).build());
    }

    public static <T extends FieldDescriptorLite<T>> Builder<T> newBuilder() {
        return new Builder<>((AnonymousClass1) null);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        return new FieldSet<>();
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z9) throws IOException {
        return z9 ? WireFormat.readPrimitiveField(codedInputStream, fieldType, WireFormat.Utf8Validation.STRICT) : WireFormat.readPrimitiveField(codedInputStream, fieldType, WireFormat.Utf8Validation.LOOSE);
    }

    private void verifyType(T t9, Object obj) {
        if (isValidType(t9.getLiteType(), obj)) {
            return;
        }
        androidx.core.view.contentcapture.a.o("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t9.getNumber()), t9.getLiteType().getJavaType(), obj.getClass().getName()});
    }

    public static void writeElement(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.writeGroup(i, (MessageLite) obj);
        } else {
            codedOutputStream.writeTag(i, getWireFormatForFieldType(fieldType, false));
            writeElementNoTag(codedOutputStream, fieldType, obj);
        }
    }

    public static void writeElementNoTag(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.writeGroupNoTag((MessageLite) obj);
                break;
            case 10:
                codedOutputStream.writeMessageNoTag((MessageLite) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.writeStringNoTag((String) obj);
                    break;
                } else {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    break;
                }
            case 12:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                    break;
                } else {
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    break;
                }
            case 13:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                break;
            case 14:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof Internal.EnumLite)) {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                    break;
                } else {
                    codedOutputStream.writeEnumNoTag(((Internal.EnumLite) obj).getNumber());
                    break;
                }
        }
    }

    public static void writeField(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
        int number = fieldDescriptorLite.getNumber();
        if (!fieldDescriptorLite.isRepeated()) {
            if (obj instanceof LazyField) {
                writeElement(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
                return;
            } else {
                writeElement(codedOutputStream, liteType, number, obj);
                return;
            }
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!fieldDescriptorLite.isPacked()) {
            while (i < size) {
                writeElement(codedOutputStream, liteType, number, list.get(i));
                i++;
            }
        } else {
            if (list.isEmpty()) {
                return;
            }
            codedOutputStream.writeTag(number, 2);
            int i6 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                i6 += computeElementSizeNoTag(liteType, list.get(i10));
            }
            codedOutputStream.writeUInt32NoTag(i6);
            while (i < size) {
                writeElementNoTag(codedOutputStream, liteType, list.get(i));
                i++;
            }
        }
    }

    private void writeMessageSetTo(Map.Entry<T, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        T key = entry.getKey();
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) {
            writeField(key, entry.getValue(), codedOutputStream);
            return;
        }
        Object value = entry.getValue();
        if (!(value instanceof LazyField)) {
            codedOutputStream.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite) value);
        } else {
            codedOutputStream.writeRawMessageSetExtension(entry.getKey().getNumber(), ((LazyField) value).toByteString());
        }
    }

    public void addRepeatedField(T t9, Object obj) {
        List list;
        if (!t9.isRepeated()) {
            a.p("addRepeatedField() can only be called on repeated fields.");
            return;
        }
        verifyType(t9, obj);
        Object field = getField(t9);
        if (field == null) {
            list = new ArrayList();
            this.fields.put((SmallSortedMap<T, Object>) t9, (T) list);
        } else {
            list = (List) field;
        }
        list.add(obj);
    }

    public void clear() {
        this.fields.clear();
        this.hasLazyField = false;
    }

    public void clearField(T t9) {
        this.fields.remove(t9);
        if (this.fields.isEmpty()) {
            this.hasLazyField = false;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FieldSet<T> m44clone() {
        SmallSortedMap<T, Object> smallSortedMap;
        FieldSet<T> newFieldSet = newFieldSet();
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (i >= numArrayEntries) {
                break;
            }
            Map.Entry<T, Object> arrayEntryAt = smallSortedMap.getArrayEntryAt(i);
            newFieldSet.setField(arrayEntryAt.getKey(), arrayEntryAt.getValue());
            i++;
        }
        for (Map.Entry<T, Object> entry : smallSortedMap.getOverflowEntries()) {
            newFieldSet.setField(entry.getKey(), entry.getValue());
        }
        newFieldSet.hasLazyField = this.hasLazyField;
        return newFieldSet;
    }

    public Iterator<Map.Entry<T, Object>> descendingIterator() {
        if (isEmpty()) {
            return Collections.emptyIterator();
        }
        boolean z9 = this.hasLazyField;
        SmallSortedMap<T, Object> smallSortedMap = this.fields;
        return z9 ? new LazyField.LazyIterator(smallSortedMap.descendingEntrySet().iterator()) : smallSortedMap.descendingEntrySet().iterator();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldSet) {
            return this.fields.equals(((FieldSet) obj).fields);
        }
        return false;
    }

    public Map<T, Object> getAllFields() {
        boolean z9 = this.hasLazyField;
        SmallSortedMap<T, Object> smallSortedMap = this.fields;
        if (!z9) {
            boolean isImmutable = smallSortedMap.isImmutable();
            SmallSortedMap<T, Object> smallSortedMap2 = this.fields;
            return isImmutable ? smallSortedMap2 : DesugarCollections.unmodifiableMap(smallSortedMap2);
        }
        SmallSortedMap cloneAllFieldsMap = cloneAllFieldsMap(smallSortedMap, false, true);
        if (this.fields.isImmutable()) {
            cloneAllFieldsMap.makeImmutable();
        }
        return cloneAllFieldsMap;
    }

    public Object getField(T t9) {
        Object obj = this.fields.get(t9);
        return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
    }

    public Object getRepeatedField(T t9, int i) {
        if (!t9.isRepeated()) {
            a.p("getRepeatedField() can only be called on repeated fields.");
            return null;
        }
        Object field = getField(t9);
        if (field != null) {
            return ((List) field).get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getRepeatedFieldCount(T t9) {
        if (!t9.isRepeated()) {
            a.p("getRepeatedField() can only be called on repeated fields.");
            return 0;
        }
        Object field = getField(t9);
        if (field == null) {
            return 0;
        }
        return ((List) field).size();
    }

    public int getSerializedSize() {
        SmallSortedMap<T, Object> smallSortedMap;
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i = 0;
        int i6 = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (i >= numArrayEntries) {
                break;
            }
            Map.Entry<T, Object> arrayEntryAt = smallSortedMap.getArrayEntryAt(i);
            i6 += computeFieldSize(arrayEntryAt.getKey(), arrayEntryAt.getValue());
            i++;
        }
        for (Map.Entry<T, Object> entry : smallSortedMap.getOverflowEntries()) {
            i6 += computeFieldSize(entry.getKey(), entry.getValue());
        }
        return i6;
    }

    public boolean hasField(T t9) {
        if (!t9.isRepeated()) {
            return this.fields.get(t9) != null;
        }
        a.p("hasField() can only be called on non-repeated fields.");
        return false;
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    public boolean isImmutable() {
        return this.isImmutable;
    }

    public Iterator<Map.Entry<T, Object>> iterator() {
        if (isEmpty()) {
            return Collections.emptyIterator();
        }
        boolean z9 = this.hasLazyField;
        SmallSortedMap<T, Object> smallSortedMap = this.fields;
        return z9 ? new LazyField.LazyIterator(smallSortedMap.entrySet().iterator()) : smallSortedMap.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.isImmutable) {
            return;
        }
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i = 0;
        while (true) {
            SmallSortedMap<T, Object> smallSortedMap = this.fields;
            if (i >= numArrayEntries) {
                smallSortedMap.makeImmutable();
                this.isImmutable = true;
                return;
            } else {
                Map.Entry<T, Object> arrayEntryAt = smallSortedMap.getArrayEntryAt(i);
                if (arrayEntryAt.getValue() instanceof GeneratedMessageLite) {
                    ((GeneratedMessageLite) arrayEntryAt.getValue()).makeImmutable();
                }
                i++;
            }
        }
    }

    public void mergeFrom(FieldSet<T> fieldSet) {
        SmallSortedMap<T, Object> smallSortedMap;
        int numArrayEntries = fieldSet.fields.getNumArrayEntries();
        int i = 0;
        while (true) {
            smallSortedMap = fieldSet.fields;
            if (i >= numArrayEntries) {
                break;
            }
            mergeFromField(smallSortedMap.getArrayEntryAt(i));
            i++;
        }
        Iterator<Map.Entry<T, Object>> it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            mergeFromField(it.next());
        }
    }

    public void setField(T t9, Object obj) {
        if (!t9.isRepeated()) {
            verifyType(t9, obj);
        } else {
            if (!(obj instanceof List)) {
                a.p("Wrong object type used with protocol message reflection.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                verifyType(t9, obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof LazyField) {
            this.hasLazyField = true;
        }
        this.fields.put((SmallSortedMap<T, Object>) t9, (T) obj);
    }

    public void setRepeatedField(T t9, int i, Object obj) {
        if (!t9.isRepeated()) {
            a.p("getRepeatedField() can only be called on repeated fields.");
            return;
        }
        Object field = getField(t9);
        if (field == null) {
            throw new IndexOutOfBoundsException();
        }
        verifyType(t9, obj);
        ((List) field).set(i, obj);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        SmallSortedMap<T, Object> smallSortedMap;
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (i >= numArrayEntries) {
                break;
            }
            Map.Entry<T, Object> arrayEntryAt = smallSortedMap.getArrayEntryAt(i);
            writeField(arrayEntryAt.getKey(), arrayEntryAt.getValue(), codedOutputStream);
            i++;
        }
        for (Map.Entry<T, Object> entry : smallSortedMap.getOverflowEntries()) {
            writeField(entry.getKey(), entry.getValue(), codedOutputStream);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Builder<T extends FieldDescriptorLite<T>> {
        private SmallSortedMap<T, Object> fields;
        private boolean hasLazyField;
        private boolean hasNestedBuilders;
        private boolean isMutable;

        private Builder(SmallSortedMap<T, Object> smallSortedMap) {
            this.fields = smallSortedMap;
            this.isMutable = true;
        }

        private FieldSet<T> buildImpl(boolean z9) {
            if (this.fields.isEmpty()) {
                return FieldSet.emptySet();
            }
            this.isMutable = false;
            SmallSortedMap<T, Object> smallSortedMap = this.fields;
            if (this.hasNestedBuilders) {
                smallSortedMap = FieldSet.cloneAllFieldsMap(smallSortedMap, false, false);
                replaceBuilders(smallSortedMap, z9);
            }
            FieldSet<T> fieldSet = new FieldSet<>(smallSortedMap, null);
            ((FieldSet) fieldSet).hasLazyField = this.hasLazyField;
            return fieldSet;
        }

        private void ensureIsMutable() {
            if (this.isMutable) {
                return;
            }
            this.fields = FieldSet.cloneAllFieldsMap(this.fields, true, false);
            this.isMutable = true;
        }

        public static <T extends FieldDescriptorLite<T>> Builder<T> fromFieldSet(FieldSet<T> fieldSet) {
            Builder<T> builder = new Builder<>(FieldSet.cloneAllFieldsMap(((FieldSet) fieldSet).fields, true, false));
            ((Builder) builder).hasLazyField = ((FieldSet) fieldSet).hasLazyField;
            return builder;
        }

        private void mergeFromField(Map.Entry<T, Object> entry) {
            T key = entry.getKey();
            Object value = entry.getValue();
            boolean z9 = value instanceof LazyField;
            if (key.isRepeated()) {
                if (z9) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Lazy fields can not be repeated");
                    return;
                }
                List list = (List) getFieldAllowBuilders(key);
                List list2 = (List) value;
                int size = list2.size();
                if (list == null) {
                    list = new ArrayList(size);
                    this.fields.put((SmallSortedMap<T, Object>) key, (T) list);
                }
                for (int i = 0; i < size; i++) {
                    list.add(FieldSet.cloneIfMutable(list2.get(i)));
                }
                return;
            }
            if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
                if (z9) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("Lazy fields must be message-valued");
                    return;
                } else {
                    this.fields.put((SmallSortedMap<T, Object>) key, (T) FieldSet.cloneIfMutable(value));
                    return;
                }
            }
            Object fieldAllowBuilders = getFieldAllowBuilders(key);
            if (fieldAllowBuilders == null) {
                this.fields.put((SmallSortedMap<T, Object>) key, (T) FieldSet.cloneIfMutable(value));
                if (z9) {
                    this.hasLazyField = true;
                    return;
                }
                return;
            }
            if (z9) {
                value = ((LazyField) value).getValue();
            }
            if (fieldAllowBuilders instanceof MessageLite.Builder) {
                key.internalMergeFrom((MessageLite.Builder) fieldAllowBuilders, (MessageLite) value);
            } else {
                this.fields.put((SmallSortedMap<T, Object>) key, (T) key.internalMergeFrom(((MessageLite) fieldAllowBuilders).toBuilder(), (MessageLite) value).build());
            }
        }

        private static Object replaceBuilder(Object obj, boolean z9) {
            if (!(obj instanceof MessageLite.Builder)) {
                return obj;
            }
            MessageLite.Builder builder = (MessageLite.Builder) obj;
            return z9 ? builder.buildPartial() : builder.build();
        }

        private static <T extends FieldDescriptorLite<T>> Object replaceBuilders(T t9, Object obj, boolean z9) {
            if (obj == null) {
                return obj;
            }
            if (t9.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
                return obj;
            }
            if (!t9.isRepeated()) {
                return replaceBuilder(obj, z9);
            }
            if (!(obj instanceof List)) {
                a.h(obj.getClass(), "Repeated field should contains a List but actually contains type: ");
                return null;
            }
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                Object obj2 = list.get(i);
                Object replaceBuilder = replaceBuilder(obj2, z9);
                if (replaceBuilder != obj2) {
                    if (list == obj) {
                        list = new ArrayList(list);
                    }
                    list.set(i, replaceBuilder);
                }
            }
            return list;
        }

        private void verifyType(T t9, Object obj) {
            if (FieldSet.isValidType(t9.getLiteType(), obj)) {
                return;
            }
            if (t9.getLiteType().getJavaType() == WireFormat.JavaType.MESSAGE && (obj instanceof MessageLite.Builder)) {
                return;
            }
            androidx.core.view.contentcapture.a.o("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t9.getNumber()), t9.getLiteType().getJavaType(), obj.getClass().getName()});
        }

        public void addRepeatedField(T t9, Object obj) {
            List list;
            ensureIsMutable();
            if (!t9.isRepeated()) {
                a.p("addRepeatedField() can only be called on repeated fields.");
                return;
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            verifyType(t9, obj);
            Object fieldAllowBuilders = getFieldAllowBuilders(t9);
            if (fieldAllowBuilders == null) {
                list = new ArrayList();
                this.fields.put((SmallSortedMap<T, Object>) t9, (T) list);
            } else {
                list = (List) fieldAllowBuilders;
            }
            list.add(obj);
        }

        public FieldSet<T> build() {
            return buildImpl(false);
        }

        public FieldSet<T> buildPartial() {
            return buildImpl(true);
        }

        public void clearField(T t9) {
            ensureIsMutable();
            this.fields.remove(t9);
            if (this.fields.isEmpty()) {
                this.hasLazyField = false;
            }
        }

        public Map<T, Object> getAllFields() {
            boolean z9 = this.hasLazyField;
            SmallSortedMap<T, Object> smallSortedMap = this.fields;
            if (!z9) {
                boolean isImmutable = smallSortedMap.isImmutable();
                SmallSortedMap<T, Object> smallSortedMap2 = this.fields;
                return isImmutable ? smallSortedMap2 : DesugarCollections.unmodifiableMap(smallSortedMap2);
            }
            SmallSortedMap cloneAllFieldsMap = FieldSet.cloneAllFieldsMap(smallSortedMap, false, true);
            if (this.fields.isImmutable()) {
                cloneAllFieldsMap.makeImmutable();
                return cloneAllFieldsMap;
            }
            replaceBuilders(cloneAllFieldsMap, true);
            return cloneAllFieldsMap;
        }

        public Object getField(T t9) {
            return replaceBuilders(t9, getFieldAllowBuilders(t9), true);
        }

        public Object getFieldAllowBuilders(T t9) {
            Object obj = this.fields.get(t9);
            return obj instanceof LazyField ? ((LazyField) obj).getValue() : obj;
        }

        public Object getRepeatedField(T t9, int i) {
            if (this.hasNestedBuilders) {
                ensureIsMutable();
            }
            return replaceBuilder(getRepeatedFieldAllowBuilders(t9, i), true);
        }

        public Object getRepeatedFieldAllowBuilders(T t9, int i) {
            if (!t9.isRepeated()) {
                a.p("getRepeatedField() can only be called on repeated fields.");
                return null;
            }
            Object fieldAllowBuilders = getFieldAllowBuilders(t9);
            if (fieldAllowBuilders != null) {
                return ((List) fieldAllowBuilders).get(i);
            }
            throw new IndexOutOfBoundsException();
        }

        public int getRepeatedFieldCount(T t9) {
            if (!t9.isRepeated()) {
                a.p("getRepeatedFieldCount() can only be called on repeated fields.");
                return 0;
            }
            Object fieldAllowBuilders = getFieldAllowBuilders(t9);
            if (fieldAllowBuilders == null) {
                return 0;
            }
            return ((List) fieldAllowBuilders).size();
        }

        public boolean hasField(T t9) {
            if (!t9.isRepeated()) {
                return this.fields.get(t9) != null;
            }
            a.p("hasField() can only be called on non-repeated fields.");
            return false;
        }

        public boolean isInitialized() {
            int numArrayEntries = this.fields.getNumArrayEntries();
            int i = 0;
            while (true) {
                SmallSortedMap<T, Object> smallSortedMap = this.fields;
                if (i >= numArrayEntries) {
                    Iterator<Map.Entry<T, Object>> it = smallSortedMap.getOverflowEntries().iterator();
                    while (it.hasNext()) {
                        if (!FieldSet.isInitialized(it.next())) {
                            return false;
                        }
                    }
                    return true;
                }
                if (!FieldSet.isInitialized(smallSortedMap.getArrayEntryAt(i))) {
                    return false;
                }
                i++;
            }
        }

        public void mergeFrom(FieldSet<T> fieldSet) {
            ensureIsMutable();
            int numArrayEntries = ((FieldSet) fieldSet).fields.getNumArrayEntries();
            for (int i = 0; i < numArrayEntries; i++) {
                mergeFromField(((FieldSet) fieldSet).fields.getArrayEntryAt(i));
            }
            Iterator it = ((FieldSet) fieldSet).fields.getOverflowEntries().iterator();
            while (it.hasNext()) {
                mergeFromField((Map.Entry) it.next());
            }
        }

        public void setField(T t9, Object obj) {
            ensureIsMutable();
            if (!t9.isRepeated()) {
                verifyType(t9, obj);
            } else {
                if (!(obj instanceof List)) {
                    a.p("Wrong object type used with protocol message reflection.");
                    return;
                }
                ArrayList arrayList = new ArrayList((List) obj);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    Object obj2 = arrayList.get(i);
                    verifyType(t9, obj2);
                    this.hasNestedBuilders = this.hasNestedBuilders || (obj2 instanceof MessageLite.Builder);
                }
                obj = arrayList;
            }
            if (obj instanceof LazyField) {
                this.hasLazyField = true;
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            this.fields.put((SmallSortedMap<T, Object>) t9, (T) obj);
        }

        public void setRepeatedField(T t9, int i, Object obj) {
            ensureIsMutable();
            if (!t9.isRepeated()) {
                a.p("getRepeatedField() can only be called on repeated fields.");
                return;
            }
            this.hasNestedBuilders = this.hasNestedBuilders || (obj instanceof MessageLite.Builder);
            Object fieldAllowBuilders = getFieldAllowBuilders(t9);
            if (fieldAllowBuilders == null) {
                throw new IndexOutOfBoundsException();
            }
            verifyType(t9, obj);
            ((List) fieldAllowBuilders).set(i, obj);
        }

        private Builder() {
            this(SmallSortedMap.newFieldMap());
        }

        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(Map.Entry<T, Object> entry, boolean z9) {
            entry.setValue(replaceBuilders(entry.getKey(), entry.getValue(), z9));
        }

        private static <T extends FieldDescriptorLite<T>> void replaceBuilders(SmallSortedMap<T, Object> smallSortedMap, boolean z9) {
            int numArrayEntries = smallSortedMap.getNumArrayEntries();
            for (int i = 0; i < numArrayEntries; i++) {
                replaceBuilders(smallSortedMap.getArrayEntryAt(i), z9);
            }
            Iterator<Map.Entry<T, Object>> it = smallSortedMap.getOverflowEntries().iterator();
            while (it.hasNext()) {
                replaceBuilders(it.next(), z9);
            }
        }
    }

    private FieldSet() {
        this.fields = SmallSortedMap.newFieldMap();
    }

    public /* synthetic */ FieldSet(SmallSortedMap smallSortedMap, AnonymousClass1 anonymousClass1) {
        this(smallSortedMap);
    }

    private FieldSet(SmallSortedMap<T, Object> smallSortedMap) {
        this.fields = smallSortedMap;
        makeImmutable();
    }

    public boolean isInitialized() {
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i = 0;
        while (true) {
            SmallSortedMap<T, Object> smallSortedMap = this.fields;
            if (i < numArrayEntries) {
                if (!isInitialized(smallSortedMap.getArrayEntryAt(i))) {
                    return false;
                }
                i++;
            } else {
                Iterator<Map.Entry<T, Object>> it = smallSortedMap.getOverflowEntries().iterator();
                while (it.hasNext()) {
                    if (!isInitialized(it.next())) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    public int getMessageSetSerializedSize() {
        SmallSortedMap<T, Object> smallSortedMap;
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i = 0;
        int i6 = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (i >= numArrayEntries) {
                break;
            }
            i6 += getMessageSetSerializedSize(smallSortedMap.getArrayEntryAt(i));
            i++;
        }
        Iterator<Map.Entry<T, Object>> it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            i6 += getMessageSetSerializedSize(it.next());
        }
        return i6;
    }

    public void writeMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        SmallSortedMap<T, Object> smallSortedMap;
        int numArrayEntries = this.fields.getNumArrayEntries();
        int i = 0;
        while (true) {
            smallSortedMap = this.fields;
            if (i >= numArrayEntries) {
                break;
            }
            writeMessageSetTo(smallSortedMap.getArrayEntryAt(i), codedOutputStream);
            i++;
        }
        Iterator<Map.Entry<T, Object>> it = smallSortedMap.getOverflowEntries().iterator();
        while (it.hasNext()) {
            writeMessageSetTo(it.next(), codedOutputStream);
        }
    }
}
