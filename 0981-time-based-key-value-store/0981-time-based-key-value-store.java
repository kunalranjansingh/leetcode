class TimeMap {

    class Data {
        String value;
        int timestamp;

        Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    HashMap<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        map.putIfAbsent(key, new ArrayList<>());

        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {

        String res = "";

        if (map.containsKey(key)) {

            List<Data> temp = map.get(key);

            int left = 0;
            int right = temp.size() - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (temp.get(mid).timestamp <= timestamp) {

                    res = temp.get(mid).value;

                    left = mid + 1;
                } 
                else {
                    right = mid - 1;
                }
            }
        }

        return res;
    }
}