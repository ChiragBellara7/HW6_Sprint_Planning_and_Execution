import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Feature A
        System.out.print("Enter the number of previous sprints: ");
        int sprintNum = sc.nextInt();
        System.out
                .print("\nEnter the story points of the previous " + sprintNum + " sprints (comma separated values): ");
        String storyPointsString = sc.next();
        List<String> sprintPoints = new ArrayList<>(Arrays.asList(storyPointsString.split(",")));

        sc.close();
    }
}