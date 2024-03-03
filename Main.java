import java.util.*;

class TeamMember {
    int memberId;
    double daysOff;
    double ceremonyHours;
    double minDailyHours;
    double maxDailyHours;

    public TeamMember(int id, double minDailyHours, double maxDailyHours, double ceremonyHours, double daysOff) {
        this.memberId = id;
        this.minDailyHours = minDailyHours;
        this.maxDailyHours = maxDailyHours;
        this.ceremonyHours = ceremonyHours;
        this.daysOff = daysOff;
    }
}

public class Main {
    public static double calculateAverageVelocity(List<String> sprintPoints) {
        if (sprintPoints == null || sprintPoints.isEmpty()) {
            return 0.0;
        }

        int totalPoints = 0;
        for (String points : sprintPoints) {
            totalPoints += Integer.parseInt(points);
        }

        return (double) totalPoints / sprintPoints.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Feature A
        System.out.print("Enter the number of previous sprints: ");
        int sprintNum = sc.nextInt();
        System.out
                .print("\nEnter the story points of the previous " + sprintNum + " sprints (comma separated values): ");
        String storyPointsString = sc.next();
        List<String> sprintPoints = new ArrayList<>(Arrays.asList(storyPointsString.split(",")));
        double averageVelocity = calculateAverageVelocity(sprintPoints);
        System.out.println("Average Velocity: " + averageVelocity);

        // Feature B
        sc.nextLine();
        System.err.print("Enter the length of the sprint: ");
        int sprintDays = sc.nextInt();
        System.out.print("Enter the number of team members: ");
        int memberNum = sc.nextInt();
        System.out.println(
                "Enter the range of hours per day availability, days off and time spent in sprint ceremonies of each team member: ");

        List<TeamMember> teamMemberDetails = new ArrayList<>();
        for (int i = 1; i <= memberNum; i++) {
            System.out.println("\nMember " + i);
            System.out.print("Member Id: ");
            int id = sc.nextInt();
            System.out.print("Hours Per Day Availability as a range (separated by '-' eg. 4-7): ");
            String hoursPerDay = sc.next();
            System.out.print("Hours spent in Sprint Ceremonies daily: ");
            double sprintCeremonyTime = sc.nextDouble();
            System.out.print("Days Off through the entire sprint: ");
            double daysOff = sc.nextDouble();

            double minHours = (double) Double.parseDouble(hoursPerDay.split("-")[0].strip());
            double maxHours = (double) Double.parseDouble(hoursPerDay.split("-")[1].strip());
            TeamMember member = new TeamMember(id, minHours, maxHours, sprintCeremonyTime, daysOff);
            teamMemberDetails.add(member);
        }

        sc.close();
    }
}