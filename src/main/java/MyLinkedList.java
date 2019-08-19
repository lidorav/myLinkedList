public class MyLinkedList<T> implements I_MyLinkedList<T>{
    private Link head;
    private Link tail;
    private int size;

    public MyLinkedList(T data) {
        Link firstLink = new Link(data);
        this.head = firstLink;
        this.tail = firstLink;
        this.size = 1;
    }

    public Link getHead() {
        return head;
    }

    public Link getTail() {
        return tail;
    }

    public Link getLink(int index){
        Link res = head;
        int k = 0;
        while (k!=index){
            k++;
            res=res.next;
        }
        return res;
    }

    public int getSize() {
        return size;
    }

    public void setHead(Link head) {
        this.head = head;
    }

    public void setTail(Link tail) {
        this.tail = tail;
    }

    public void setSize(int size) {
        this.size = size;
    }



    public void addAfter(int i, Object data) {
        Link before = getLink(i);
        Link after = getLink(i + 1);
            Link toAdd = new Link(after,before, data);
            before.next = toAdd;
            if (after != null) {
                after.prev = toAdd;
            }
        }
    public int getIndex(Object data) {
        int res = 0;
        Link pointer = head;
        while (pointer.next !=null){
            if(pointer.data.equals(data)) {
                return res;
            }
            else {
                pointer=pointer.next;
                res++;
            }
        }
        return res;
    }

    public T getData(int index) {

        Link temp = getLink(index);
        if (temp != null){
            return (T)temp.data;
        }
        return null;
    }

    public void remove(int index) {
        Link toRemove = getLink(index);
        if ( toRemove ==head){
            head = head.next;
            head.next.prev = null;
        }
        if (toRemove.next == null){
            Link before=getLink(index-1);
            before.next = null;
            tail.prev = null;
        }
        //knui
        else {
            Link before=getLink(index-1);
            Link after=getLink(index+1);
            before.next = toRemove.next;
            after.prev = toRemove.prev;
            toRemove.next=null;
            toRemove.prev=null;
        }


    }

    public String printList() {
        return null;
    }

    private class Link<T>{
        Link next;
        Link prev;
        T data;

        public Link(T data){
            this.next = null;
            this.prev = null;
            this.data = data;
        }

        public Link(Link next,T data){
            this.next = next;
            this.prev = null;
            this.data = data;
        }

        public Link(Link next, Link prev, T data) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }




}
