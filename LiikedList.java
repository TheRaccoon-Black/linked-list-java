/*author: muhammad fachrurrozi*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*npm: G1A021018*/
class IntSLLNode {
	public int info;
	public IntSLLNode next;

	public IntSLLNode(int i) {
		this(i, null);
	}

	public IntSLLNode(int i, IntSLLNode n) {
		info = i;
		next = n;
	}
}

class IntSLList {
	protected IntSLLNode head, tail;

	public IntSLList() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addToHead(int el) {
		head = new IntSLLNode(el, head);
		if (tail == null)
			tail = head;
	}

	public boolean isInList(int el) {
		IntSLLNode temp;
		for (temp = head; temp != null && temp.info != el; temp = temp.next)
			;
		return temp != null;
	}

	public void printAll() {
		for (IntSLLNode temp = head; temp != null; temp = temp.next)
			System.out.print(temp.info + " ");
		System.out.println();
	}

	public int deleteFromHead() {
		int el = head.info;
		if (head == tail)
			head = tail = null;
		else
			head = head.next;
		return el;
	}


	public boolean delete(int el) {
		if (head == tail && el == head.info) {
			head = tail = null;
			return true;
		} else if (el == head.info) {
			head = head.next;
			return true;
		} else {
			IntSLLNode pred, temp;
			for (pred = head, temp = head.next; temp != null && temp.info != el; pred = pred.next, temp = temp.next)
				;
			if (temp != null) {
				pred.next = temp.next;
				if (temp == tail)
					tail = pred;
				return true;
			}
		}
		return false;
	}
}

public class SinglyLinkedList {
	public static void main(String args[]) throws IOException {
		IntSLList list = new IntSLList();

		int choice;
		int el;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("Masukkan pilihanmu");
			System.out
					.println("1.TAMBAHKAN \t2.HAPUS \t3.PRINT SEMUA \t4.KEMBALI");
			choice = Integer.parseInt(br.readLine());
			switch (choice) {
			case 1:
				System.out.println("\t\tMasukkan elemen:");
				el = Integer.parseInt(br.readLine());
				list.addToHead(el);
				break;
				
				
			case 2:
				if (list.isEmpty())
					System.out.println("\t\tList Kosong");
				else {
					System.out.println("\t\tMasukkan Pilihanmu: ");
					System.out
							.println("\t\t1.HAPUS DARI KEPALA(HEAD) \t2.HAPUS SEBUAH ELEMEN TERTENTU");
					System.out.print("\t\t");
					choice = Integer.parseInt(br.readLine());
					switch (choice) {
					case 1:
						el = list.deleteFromHead();
						System.out.println("\t\tElemen yang di hapus adalah:" + el);
						break;
					case 2:
						System.out.println("\t\tMasukkan sebuah elemen yang ingin di hapus");
						System.out.print("\t\t");
						el = Integer.parseInt(br.readLine());
						if (list.delete(el))
							System.out.println("\t\tElemen telah berhasil di hapus");
						else
							System.out.println("\t\tTidak ditemukan");
						break;
					default:
						System.out
								.println("\t\tArgumen tidak valid kembali ke menu utama");
						break;
					}
				}
				break;
			case 3:
				if (list.isEmpty())
					System.out.println("\t\tList masih kosong");
				else {
					System.out.println("\t\tElemen di dalam list adalah:");
					System.out.print("\t\t");
					list.printAll();
				}
				break;
			case 4:
				break;
			}
		} while (choice != 4);
	}
}
