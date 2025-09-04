// Interface definitions

// SLList interface

// DLList interface that extends SLList

// SEList interface that extends SLList

// SLListNode interface

// DLListNode interface that extends SLListNode

// SEListNode interface that extends SLListNode

// Stub class implementations

// SLList implementation

// DLList implementation

// SEList implementation

// SLListNode implementation

// DLListNode implementation

// SEListNode implementation

// Main.java to create instances
public class Main {
    public static SLList<Integer> createSLList() {
        return new SLListImpl<>();
    }

    public static DLList<Integer> createDLList() {
        return new DLListImpl<>();
    }

    public static SEList<Integer> createSEList() {
        return new SEListImpl<>();
    }

    public static void main(String[] args) {
        SLList<Integer> slList = createSLList();
        DLList<Integer> dlList = createDLList();
        SEList<Integer> seList = createSEList();

        System.out.println("SLList, DLList, and SEList instances created.");
    }
}
