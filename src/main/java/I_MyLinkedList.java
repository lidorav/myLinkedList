public interface I_MyLinkedList<T> {

    void addAfter(int i, Object data);
    int getIndex(Object data);
    T getData(int index);
    void remove(int index);
    String printList();

}
