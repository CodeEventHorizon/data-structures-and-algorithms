package lineardatastructures.Arrays.BitField;

public class BitField {
    private byte[] bits;
    private int size;

    public BitField(int size) {
        this.size = size;
        int arraySize = (size + 7) / 8;
        bits = new byte[arraySize];
    }

    public void set(int index, boolean value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        int byteIndex = index / 8;
        int bitPosition = index % 8;

        if (value) {
            bits[byteIndex] |= (1 << bitPosition);
        } else {
            bits[byteIndex] &= ~(1 << bitPosition);
        }
    }

    public boolean get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        int byteIndex = index / 8;
        int bitPosition = index % 8;

        return ((bits[byteIndex] & (1 << bitPosition)) != 0);
    }

    public static void main(String[] args) {
        // Create a BitField with size 16
        BitField bitField = new BitField(16);

        // Set some bits to true
        bitField.set(0, true);
        bitField.set(1, false);
        bitField.set(2, true);

        // Get the value of specific bits
        boolean bit0 = bitField.get(0); // true
        boolean bit1 = bitField.get(1); // false
        boolean bit2 = bitField.get(2); // true

        // Print the values of the bits
        System.out.println("Bit at index 0: " + bit0); // Bit at index 0: true
        System.out.println("Bit at index 1: " + bit1); // Bit at index 1: false
        System.out.println("Bit at index 2: " + bit2); // Bit at index 2: true
    }
}
