class Router {

    record Packet(int source, int destination, int timestamp) {}

    Queue<Packet> queue;
    HashSet<Packet> set;

    HashMap<Integer, ArrayList<Integer>> map;
    HashMap<Integer, Integer> head;

    int memoryLimit;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;

        queue = new LinkedList<>();
        set = new HashSet<>();

        map = new HashMap<>();
        head = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {

        Packet packet = new Packet(source, destination, timestamp);

        if (set.contains(packet)) {
            return false;
        }

        if (queue.size() == memoryLimit) {
            forwardPacket();
        }

        queue.offer(packet);
        set.add(packet);

        map.computeIfAbsent(destination, k -> new ArrayList<>())
           .add(timestamp);

        return true;
    }

    public int[] forwardPacket() {

        if (queue.isEmpty()) {
            return new int[0];
        }

        Packet packet = queue.poll();
        set.remove(packet);

        int destination = packet.destination();

        head.put(destination, head.getOrDefault(destination, 0) + 1);

        return new int[]{
            packet.source(),
            packet.destination(),
            packet.timestamp()
        };
    }

    public int getCount(int destination, int startTime, int endTime) {

        if (!map.containsKey(destination)) {
            return 0;
        }

        ArrayList<Integer> list = map.get(destination);

        int start = head.getOrDefault(destination, 0);
        int end = list.size();

        int left = lowerBound(list, start, end, startTime);
        int right = upperBound(list, start, end, endTime);

        return right - left;
    }

    private int lowerBound(ArrayList<Integer> list, int low, int high, int target) {

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int upperBound(ArrayList<Integer> list, int low, int high, int target) {

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}


/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */