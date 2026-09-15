class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {

        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {

        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastIndex = list.size() - 1;
        int lastValue = list.get(lastIndex);

        // Last element ko deleted element ki jagah rakho
        list.set(index, lastValue);

        // Last element ka index update karo
        map.put(lastValue, index);

        // Last element remove karo
        list.remove(lastIndex);

        // Deleted value map se remove karo
        map.remove(val);

        return true;
    }

    public int getRandom() {

        int index = random.nextInt(list.size());

        return list.get(index);
    }
}