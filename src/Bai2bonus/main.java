package Bai2bonus;
import java.util.LinkedList;
import java.util.Stack;
import java.time.LocalDateTime;

class Customer {
    int id;
    String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

//yeu cau ho tro
class Ticket {
    int id;
    String content;
    LocalDateTime timestamp;
    public Ticket(int id, String content, LocalDateTime timestamp) {
        this.id = id;
        this.content = content;
        this.timestamp = timestamp;
    }
}

class Message {
    int id;
    String content;
    public Message(int id, String content) {
        this.id = id;
        this.content = content;
    }
    @Override
    public String toString() {
        return id + ": " + content;
    }
}
 //FIFO
class CustomerQueue {
    private LinkedList<Customer> queue = new LinkedList<>();

    public void addCustomer(Customer c) {// them khach hang vo
        queue.offer(c); // giong push, dua dlieu vao cuoi hang doi
        System.out.println(c.name + " da vao hang doi.");
    }
    public Customer processCustomer() {// su li khach hang hien tai
        Customer c = queue.poll(); //lay va xoa phan tu dau hang doi

        if (c == null) {
            System.out.println("Không còn khách đợi");
            return null;
        }

        System.out.println("Dang xu ly khach: " + c.name);
        return c;
    }
}
 //LIFO
class MessageHistory {
    private Stack<Message> stack = new Stack<>();
    public void addMessage(Message m) {
        stack.push(m); // day vo dau
        System.out.println("Da gui: " + m.content);
    }
    public void undo() {
        if (stack.empty()) {
            System.out.println("Khong co tin nhan de Undo.");
            return;
        }
        Message m = stack.pop();
        System.out.println("Da Undo: " + m.content); // in ra cai vua pop
    }

    public void viewLast() {
        if (stack.empty()) {
            System.out.println("Chua co tin nhan.");
            return;
        }

        System.out.println("Tin nhan gan nhat: " + stack.peek()); //xem ma ko xoa phan tu tren cung
    }

    public void showHistory() {
        System.out.println("Lich su tin nhan:");
        for (Message m : stack) {
            System.out.println(m);
        }
    }
}
public class main {
    public static void main(String[] args) {
        CustomerQueue cq = new CustomerQueue();
        Customer a = new Customer(1, "Nguyen Ngoc Duc");
        Customer b = new Customer(2, "Nguyen Van Sang");
        cq.addCustomer(a);
        cq.addCustomer(b);
        Customer current = cq.processCustomer();

        if (current != null) {
            Ticket ticket = new Ticket(
                    1,"Yeu cau ho tro don hang cua " + current.name,
                    LocalDateTime.now()
            );
            System.out.println("Ticket: " + ticket.content);
            System.out.println("Thoi gian: " + ticket.timestamp);
            MessageHistory history = new MessageHistory();
            history.addMessage(new Message(1, "Xin chao quy khach."));
            history.addMessage(new Message(2, "Vui long cung cap ma don hang."));
            history.addMessage(new Message(3, "Cam on quy khach da cho doi."));
            history.viewLast();
            history.undo();
            history.showHistory();
        }

        System.out.println("----");

        current = cq.processCustomer();

        if (current != null) {
            Ticket ticket = new Ticket(
                    2,
                    "Yeu cau ho tro don hang cua " + current.name,
                    LocalDateTime.now()
            );

            System.out.println("Ticket: " + ticket.content);
            System.out.println("Thoi gian: " + ticket.timestamp);
        }

        // Thu xu ly khi hang doi rong
        cq.processCustomer();
    }
}
