package wit.comp1050;

public enum Difficulty {
    NOVICE(5, 4, 12, "novice"),
    BEGINNER(6, 4, 10, "beginner"),
    INTERMEDIATE(7, 5, 10, "intermediate"),
    EXPERT(8, 6, 8, "expert");

    private final int numofColors;
    private final int codeSize;
    private final int numofGuesses;
    private String name;

    Difficulty(int numofColors, int codeSize, int numofGuesses, String name) {
        this.numofColors = numofColors;

        this.codeSize = codeSize;

        this.numofGuesses = numofGuesses;
    }


    public int getNumofColors() {

        return numofColors;
    }

    public int getCodeSize() {

        return codeSize;
    }

    public int getNumofGuesses() {

        return numofGuesses;
    }

    public String getName() {
        return name;
    }

    Difficulty(int[] val) {

        code = String.valueOf(val);
    }

    private String code;


    public String getCode() {

        return code;
    }
}

