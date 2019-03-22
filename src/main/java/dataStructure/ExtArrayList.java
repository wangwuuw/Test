package dataStructure;

import java.util.ArrayList;

public class ExtArrayList {
    transient Object[] elementData;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    protected transient int modCount = 0;
    public ExtArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.get(2);
        arrayList.add("a");
        int size =0;
        System.out.println(size++);
        System.out.println(size);
    }

}
