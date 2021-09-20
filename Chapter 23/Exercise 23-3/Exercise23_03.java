import java.util.Comparator;

public class Exercise23_03 {
  public static void main(String[] args) {
    Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    quickSort(list, 0, list.length - 1);
    for (int i = 0; i < list.length; i++) {
      System.out.print(list[i] + " ");
    }

    System.out.println();
    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                     new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                     new Circle(3), new Circle(14), new Circle(12)};
    quickSort(list1, new GeometricObjectComparator(), 0, list1.length - 1);
    for (int i = 0; i < list1.length; i++) {
      System.out.println(list1[i] + " ");
    }
  }
  public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
    if(last > first) {
      int pivotI = partition(list, first, last);
      quickSort(list, first, pivotI);
      quickSort(list, pivotI + 1, last);
    }
  }
  public static <E> void quickSort(E[] list, Comparator<? super E> comparator, int first, int last) {
    if(last > first) {
      int pivotI = partition(list, comparator, first, last);
      quickSort(list, comparator, first, pivotI);
      quickSort(list, comparator, pivotI + 1, last);
    }
  }
  public static <E> int partition(E[] list, Comparator<? super E> comparator, int first, int last) {
    E pivot = list[(first + last) / 2];
    first--;
    last++;
    while(true) {
      do {
        first++;
      } while(comparator.compare(list[first], pivot) < 0);
      do {
        last--;
      } while(comparator.compare(list[last], pivot) > 0);
      if(first >= last) {
        return last;
      }
      E temp = list[first];
      list[first] = list[last];
      list[last] = temp;
    }
  }
  public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
    E pivot = list[(first + last) / 2];
    first--;
    last++;
    while(true) {
      do {
        first++;
      } while(list[first].compareTo(pivot) < 0);
      do {
        last--;
      } while(list[last].compareTo(pivot) > 0);
      if(first >= last) {
        return last;
      }
      E temp = list[first];
      list[first] = list[last];
      list[last] = temp;
    }
  }
}