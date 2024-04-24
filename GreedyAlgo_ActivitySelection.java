import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

public class GreedyAlgo_ActivitySelection {

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 8, 9 };

        // if end is not sorted
        int activities[][] = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function -> shortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // end time basis sorted
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // 1st Activity
        maxAct = 1;
        ans.add(0); // activities[0][0]
        int lastEnd = end[0]; // activities[0][2]

        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                // activity selected
                maxAct++;
                ans.add(i); // activities[i][0]
                lastEnd = end[i]; // activities[i][2]
            }
        }

        System.out.println("Max Activities = " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
    }
}