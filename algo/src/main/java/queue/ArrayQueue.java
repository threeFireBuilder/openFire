import java.util.Scanner;

/**
 * Created by wangzheng on 2018/10/9.
 */
// 用数组实现的队列
public class ArrayQueue {
  // 数组：items，数组大小：n
  private Integer[] items;
  private int n = 0;
  // head表示队头下标，tail表示队尾下标
  private int head = 0;
  private int tail = 0;

  // 申请一个大小为capacity的数组
  public ArrayQueue(int capacity) {
    items = new Integer[capacity];
    n = capacity;
  }

  // 入队
  public boolean enqueue(Integer item) {
    // 如果tail == n 表示队列已经满了
    if (tail == n) {
      if (head==0){
        return false;
      }
      // 满了要进行数据迁移
      for (int i= head;i< tail;i++){
        items[i-head] = items[i];
      }

      tail = tail-head;
      items[tail] = item;
      head = 0;
    }

    items[tail] = item;
    ++tail;
    return true;
  }

  // 出队
  public Integer dequeue() {
    // 如果head == tail 表示队列为空
    if (head == tail) return null;
    // 为了让其他语言的同学看的更加明确，把--操作放到单独一行来写了
    Integer ret = items[head];
    ++head;
    return ret;
  }

  public void printAll() {
    for (int i = head; i < tail; ++i) {
      System.out.print(items[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    ArrayQueue queue = new ArrayQueue(5);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.enqueue(5);
    queue.dequeue();
    queue.enqueue(567);
    queue.dequeue();

    queue.enqueue(567);
    queue.dequeue();

    queue.enqueue(567);
    queue.dequeue();

    queue.enqueue(777);

    queue.printAll();
  }
}
