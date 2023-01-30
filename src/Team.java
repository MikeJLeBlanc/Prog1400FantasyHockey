public class Team {
    private String name;
    private float budget = 0;

    protected Team(String name) {
        this.name = name;
        this.budget = randBudget();
    }

    protected String teamRating(int totalPoints) {
        String rating;

        if (totalPoints >= 20){
            rating = "Rating: * * *";
        } else if (totalPoints >= 10 && totalPoints < 19) {
            rating = "Rating: * *";
        } else if (totalPoints > 0 && totalPoints < 9) {
            rating = "Rating: * ";
        } else {
            rating = "Rating: 0 stars";
        }
        return rating;
    }

    private float randBudget(){
        int min = 0;
        int max = 100000;

        return (float)Math.floor(Math.random() * (max - min + 1) + min);
    }

    protected float getBudget() {
        return this.budget;
    }

    public String getName() {
        return name;
    }

}