package linkedlist;


import java.util.Scanner;

/**
 * @author zhangyan
 * @date 2022/1/27 2:18 PM
 * @version 1.0
 * 基于单链表LRU算法（java）
 */
public class LRUBaseLinkedList<T> {


    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;


    /**
     * 链表容量
     */
    private Integer capacity;


    public LRUBaseLinkedList() {
        this.headNode = new SNode<T>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }


    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<T>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data){
        SNode preNode = findPreNode(data);
        // 表中存在，删除原有节点，盖节点插入头部
        if (preNode!=null){
            deleteElemOptim(preNode);
            insertNodeAtHead(data);
        }else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteElemAtEnd();
            }
            insertNodeAtHead(data);
        }
    }


    /**
     * 删除最后一个节点
     */
    private void deleteElemAtEnd(){
        SNode pre = headNode;
        if (pre.next ==null){
            return;
        }

        while (pre.getNext().getNext() !=null){
            pre = pre.getNext();
        }

        SNode temp = pre.getNext();
        pre.setNext(null);
        temp = null;
        length--;
    }

    private void deleteElemOptim(SNode preNode){
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }


    /**
     * 链表头部插入
     * @param data
     */
    private void insertNodeAtHead(T data){
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data,next));
        length++;
    }


    private void printAll(){
        SNode node = headNode.getNext();
        while (node!=null){
            System.out.print(node.getElement()+", ");
            node = node.getNext();
        }
        System.out.println();
    }


    private SNode findPreNode(T data){
        SNode node = headNode;
        while (node.next != null){
            if (data.equals(node.getNext().getElement())){
                return node;
            }
            node = node.getNext();
        }

        return null;
    }


    public class SNode<T> {

        private T element;

        private SNode next;

        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }
        public SNode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }

    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList(3);
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}

