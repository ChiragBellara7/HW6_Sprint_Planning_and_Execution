class Sprint {
    int lengthOfSprint;
    int totalStoryPoints;

    public int getLengthOfSprint() {
        return lengthOfSprint;
    }

    public int getTotalStoryPoints() {
        return totalStoryPoints;
    }

    public void setLengthOfSprint(int lengthOfSprint) {
        this.lengthOfSprint = lengthOfSprint;
    }

    public void setTotalStoryPoints(int totalStoryPoints) {
        this.totalStoryPoints = totalStoryPoints;
    }
}

class TeamMember {
    int memberID;
    String memberName;
    int offDaysCount;
    int timeForSprintCeremoniesCount;
    int minNumOfAvailableDays;
    int maxNumOfAvailableDays;

    // Getters
    public int getMemberID() {
        return memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getOffDaysCount() {
        return offDaysCount;
    }

    public int getTimeForSprintCeremoniesCount() {
        return timeForSprintCeremoniesCount;
    }

    public int getMinNumOfAvailableDays() {
        return minNumOfAvailableDays;
    }

    public int getMaxNumOfAvailableDays() {
        return maxNumOfAvailableDays;
    }

    // Setters
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setOffDaysCount(int offDaysCount) {
        this.offDaysCount = offDaysCount;
    }

    public void setTimeForSprintCeremoniesCount(int timeForSprintCeremoniesCount) {
        this.timeForSprintCeremoniesCount = timeForSprintCeremoniesCount;
    }

    public void setMinNumOfAvailableDays(int minNumOfAvailableDays) {
        this.minNumOfAvailableDays = minNumOfAvailableDays;
    }

    public void setMaxNumOfAvailableDays(int maxNumOfAvailableDays) {
        this.maxNumOfAvailableDays = maxNumOfAvailableDays;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}