package lineardatastructures.Arrays.BitArray;

public class BitArray {
    private byte[] bits;
    private int size;

    public BitArray(int size) {
        this.size = size;
        int arraySize = (size + 7) / 8;
        bits = new byte[arraySize];
    }

    public void set(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        int i = index / 8;
        int bitPosition = index % 8;
        bits[i] |= (1 << bitPosition);
    }

    public void clear(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        int i = index / 8;
        int bitPosition = index % 8;
        bits[i] &= ~(1 << bitPosition);
    }

    public boolean get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        int i = index / 8;
        int bitPosition = index % 8;
        return ((bits[i] & (1 << bitPosition)) != 0);
    }

    public static void main(String[] args) {
        // Create a BitArray with a size of 64 bits
        BitArray bitArray = new BitArray(64);

        // Set some bits
        bitArray.set(4);
        bitArray.set(10);
        bitArray.set(30);

        // Clear a bit
        bitArray.clear(10);

        // Print the values of the bits
        for (int i = 0; i < 64; i++) {
            System.out.println("Bit at index " + i + ": " + bitArray.get(i));
        }
    }
}
