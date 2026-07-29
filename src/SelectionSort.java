import java.util.ArrayList;

class SelectionSort {

    public static void sortByFare(ArrayList<Bus> buses) {

        int n = buses.size();

        for (int i = 0; i < n - 1; i++) {

            int min = i;

            for (int j = i + 1; j < n; j++) {

                if (buses.get(j).fare < buses.get(min).fare) {
                    min = j;
                }
            }

            Bus temp = buses.get(i);
            buses.set(i, buses.get(min));
            buses.set(min, temp);
        }
    }
}