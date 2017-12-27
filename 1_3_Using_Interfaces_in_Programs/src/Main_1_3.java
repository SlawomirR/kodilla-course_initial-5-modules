public class Main_1_3 {
    public static void main(String[] args) {
        DeadIslandQuest chosenQuest = new DeadIslandQuest();
        Knight knight = new Knight(chosenQuest);
        knight.runningInfo();
        System.out.println("You've finished the quest named: ... \"" + chosenQuest + "\"");
    }
}

class Knight {
    private Quest quest;

    Knight(Quest quest) {
        this.quest = quest;
        System.out.println("You choose special quest named: \"" + quest + "\"\n");
    }

    public void runningInfo() {
        System.out.println("INFO: I'm going to start \"(Quest)process\" method for you ...\n");
        System.out.println("Listen to the story ...\n");
        this.quest.process();
        System.out.println("INFO: \"(Quest)process\" method done properly.\n");
    }
}

class DeadIslandQuest implements Quest {
    private String questName = "DeadIslandQuest";

    @Override
    public void process() {
        System.out.println("You are on Dead Island. It's a very dangerous place! You are not welcome there! ...\n");
    }

    @Override
    public String toString() {
        return questName;
    }
}

class EliteKnightQuest implements Quest {
    private String questName = "EliteKnightQuest";

    @Override
    public void process() {
        System.out.println("You are with friends. They are the best in all kingdoms. ...\n");
    }

    @Override
    public String toString() {
        return questName;
    }
}

interface Quest {
    void process();
}

