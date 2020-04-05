public class Data {
    private String nama;
    private int freq;
    public LinkedList ll = new LinkedList();

    public Data(String nama) {
        this.nama = nama;
        this.freq = 1;
    }

    public Data(String nama, String artikel) {
        this.nama = nama;
        this.setArtikel(artikel);
        this.freq = 1;
    }

    public String getNama() {
        return this.nama;
    }

    public int getFreq() {
        return this.freq;
    }

    public void setFreq() {
        this.freq++;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void getArtikel() {
        System.out.println("Judul artikel:");
        ll.display(ll.getHead());
    }

    public void setArtikel(String artikel) {
        ll.add(artikel);
    }
}