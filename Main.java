import java.util.*;

class TeamMember {
    int memberId;
    double daysOff;
    double ceremonyHours;
    double minDailyHours;
    double maxDailyHours;

    public TeamMember() {
    }

    public TeamMember(int id, double minDailyHours, double maxDailyHours, double ceremonyHours, double daysOff) {
        this.memberId = id;
        this.minDailyHours = minDailyHours;
        this.maxDailyHours = maxDailyHours;
        this.ceremonyHours = ceremonyHours;
        this.daysOff = daysOff;
    }

    public Map<String, double[]> calculateIndividualCapacity(List<TeamMember> members, int sprintLength) {
        double[] minCapacities = new double[members.size()];
        double[] maxCapacities = new double[members.size()];
        for (int i = 0; i < members.size(); i++) {
            double availableDays = sprintLength - members.get(i).daysOff;
            double minAvailableHours = availableDays * (members.get(i).minDailyHours - members.get(i).ceremonyHours);
            double maxAvailableHours = availableDays * (members.get(i).maxDailyHours - members.get(i).ceremonyHours);
            minCapacities[i] = minAvailableHours;
            maxCapacities[i] = maxAvailableHours;
        }
        System.out.println("Sprint Length: " + sprintLength);
        System.out.println("Team Size: " + members.size());
        Map<String, double[]> capacities = new HashMap<>();
        capacities.put("minimum", minCapacities);
        capacities.put("maximum", maxCapacities);
        printIndividualCapacities(members, capacities);
        return capacities;
    }

    public static void printIndividualCapacities(List<TeamMember> members, Map<String, double[]> capacityMap) {
        if (members == null || members.isEmpty()) {
            return;
        }
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-30s |\n", "Member ID", "Daily Hours", "Ceremony Hours",
                "Days Off", "Available Effort-Hours range");
        System.out.println(
                "|----------------------|----------------------|----------------------|----------------------|--------------------------------|");
        int i = 0;
        double[] minCapacities = capacityMap.get("minimum");
        double[] maxCapacities = capacityMap.get("maximum");

        for (TeamMember entry : members) {
            String effortHoursRange = minCapacities[i] + " - " + maxCapacities[i];
            String dailyHourRange = entry.minDailyHours + " - " + entry.maxDailyHours;
            System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-30s |\n", entry.memberId, dailyHourRange,
                    entry.ceremonyHours, entry.daysOff, effortHoursRange);
            i += 1;
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