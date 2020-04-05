public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head) {
        this.head = head;
        this.incSize();
    }

    public void incSize() {
        this.size++;
    }

    public void decSize() {
        this.size--;
    }

    public int getSize() {
        return this.size;
    }

    public Node getHead() {
        return this.head;
    }

    public void add(String nama, String artikel) {
        Node current = this.search(nama);

        if (current == null) {
            this.setHead(new Node(new Data(nama, artikel), this.getHead()));
        } else {
            current.getData().setFreq();
            current.getData().setArtikel(artikel);
        }
    }

    public void add(String artikel) {
        this.setHead(new Node(new Data(artikel), this.getHead()));
    }

    public void display() {
        Node current = this.getHead();
        int i = 1;

        while (current != null) {
            System.out.println(i + ". " + current.getData().getNama() + " -> mengedit " + current.getData().getFreq()
                    + " artikel");
            if (current.getNext() == null)
                break;
            current = current.getNext();
            i++;
        }
    }

    public void display(Node head) {
        Node current = this.getHead();
        int i = 1;

        while (current != null) {
            System.out.println(i + ". " + current.getData().getNama());
            if (current.getNext() == null)
                break;
            current = current.getNext();
            i++;
        }
    }

    public Node search(String nama) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getNama().compareToIgnoreCase(nama) == 0) {
                return current;
            }

            if (current.getNext() == null)
                break;
            current = current.getNext();
        }
        return null;
    }

    public void containsSearch(String nama) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getNama().contains(nama)
                    && current.getData().getNama().compareToIgnoreCase(nama) != 0) {
                System.out.println("\n-> " + current.getData().getNama() + " mengedit sebanyak "
                        + current.getData().getFreq() + " artikel");
                current.getData().getArtikel();
            }

            if (current.getNext() == null)
                break;
            current = current.getNext();
        }
        System.out.println("\n[!] Data dengan nama '" + nama + "' saja tidak ditemukan");
    }

    public void result(String nama) {
        Node current = this.search(nama);

        if (current != null) {
            System.out.println("\n-> " + current.getData().getNama() + " mengedit sebanyak "
                    + current.getData().getFreq() + " artikel");
            current.getData().getArtikel();
        } else {
            containsSearch(nama);
        }
    }

    public void insertionSort() {
        Node sorted = null;
        Node current = this.getHead();

        while (current != null) {
            Node next = current.getNext();
            if (sorted == null || sorted.getData().getNama().compareTo(current.getData().getNama()) > 0) {
                current.setNext(sorted);
                sorted = current;
            } else {
                Node search = sorted;
                while (search.getNext() != null
                        && search.getNext().getData().getNama().compareTo(current.getData().getNama()) < 0) {
                    search = search.getNext();
                }
                current.setNext(search.getNext());
                search.setNext(current);
            }
            current = next;
        }
        head = sorted;
    }
}