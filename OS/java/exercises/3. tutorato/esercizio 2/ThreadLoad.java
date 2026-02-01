import java.util.LinkedList;

class CpuLoad {

    private int id;
    private double cpuLoad;

    public CpuLoad(int id, double cpuLoad) {
        this.id = id;
        this.cpuLoad = cpuLoad;
    }

    public int getId() {
        return id;
    }

    public double getCpuLoad() {
        return cpuLoad;
    }
}

public class ThreadLoad {

    LinkedList<CpuLoad> list = new LinkedList<>();

    public synchronized void add(Integer id, Double cpuLoad) {
        list.add(new CpuLoad(id, cpuLoad));
    }
}
