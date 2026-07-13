import java.util.ArrayList;

public class QuestionBank {

    public static ArrayList<Question> getQuestions() {

        ArrayList<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "1. Which keyword is used to inherit a class in Java?",
                new String[]{"implements", "extends", "import", "package"},
                1
        ));

        questions.add(new Question(
                "2. Which method is the entry point of a Java program?",
                new String[]{"start()", "main()", "run()", "execute()"},
                1
        ));

        questions.add(new Question(
                "3. Which package contains the Scanner class?",
                new String[]{"java.io", "java.util", "java.lang", "java.awt"},
                1
        ));

        questions.add(new Question(
                "4. Which operator compares two values?",
                new String[]{"=", "==", "!=", "++"},
                1
        ));

        questions.add(new Question(
                "5. Which collection allows duplicate elements?",
                new String[]{"Set", "Map", "List", "TreeSet"},
                2
        ));

        questions.add(new Question(
                "6. Which loop executes at least once?",
                new String[]{"for", "while", "do-while", "enhanced for"},
                2
        ));

        questions.add(new Question(
                "7. Which keyword creates an object?",
                new String[]{"class", "new", "create", "this"},
                1
        ));

        questions.add(new Question(
                "8. Which exception occurs when dividing by zero?",
                new String[]{"IOException", "ArithmeticException", "NullPointerException", "SQLException"},
                1
        ));

        questions.add(new Question(
                "9. Which access modifier makes members accessible everywhere?",
                new String[]{"private", "protected", "default", "public"},
                3
        ));

        questions.add(new Question(
                "10. Java is a ______ language.",
                new String[]{"Procedural", "Object-Oriented", "Assembly", "Machine"},
                1
        ));

        questions.add(new Question(
                "11. Which method is used to start a thread?",
                new String[]{"start()", "run()", "execute()", "init()"},
                0
        ));
        questions.add(new Question(
                "12. Which keyword is used to define a constant in Java?",
                new String[]{"final", "const", "static", "immutable"},
                0
        ));
        questions.add(new Question(
                "13. Which operator is used for logical AND in Java?",
                new String[]{"&", "&&", "|", "||"},
                1
        ));
        questions.add(new Question(
                "14. Which method is used to compare two strings in Java?",
                new String[]{"equals()", "compareTo()", "==", "compare()"},
                0
        ));
        questions.add(new Question(
                "15. Which keyword is used to handle exceptions in Java?",
                new String[]{"try", "catch", "throw", "finally"},
                0
        ));
        questions.add(new Question(
                "16. Which class is the superclass of all classes in Java?",
                new String[]{"Object", "Class", "String", "Exception"},
                0
        ));
        questions.add(new Question(
                "17. Which method is used to get the length of an array in Java?",
                new String[]{"length()", "size()", "length", "count()"},
                2
        ));
        questions.add(new Question(
                "18. Which keyword is used to create a subclass in Java?",
                new String[]{"extends", "implements", "inherits", "subclass"},
                0
        ));
        questions.add(new Question(
                "19. Which method is used to convert a string to an integer in Java?",
                new String[]{"parseInt()", "toInt()", "convertToInt()", "stringToInt()"},
                0
        ));
        questions.add(new Question(
                "20. Which keyword is used to define an interface in Java?",
                new String[]{"interface", "class", "implements", "abstract"},
                0
        ));
        questions.add(new Question(
                "21. Which method is used to read input from the console in Java?",
                new String[]{"read()", "input()", "nextLine()", "getInput()"},
                2
        ));
        questions.add(new Question(
                "22. Which keyword is used to create a thread in Java?",
                new String[]{"thread", "new", "extends", "implements"},
                1
        ));
        questions.add(new Question(
                "23. Which method is used to convert an integer to a string in Java?",
                new String[]{"toString()", "stringValue()", "convertToString()", "intToString()"},
                0
        ));
        questions.add(new Question(
                "24. Which keyword is used to define a package in Java?",
                new String[]{"package", "import", "namespace", "module"},
                0
        ));
        questions.add(new Question(
                "25. Which method is used to check if a string contains a specific sequence of characters in Java?",
                new String[]{"contains()", "indexOf()", "matches()", "find()"},
                0
        ));
        questions.add(new Question(
                "26. Which keyword is used to define a class in Java?",
                new String[]{"class", "object", "define", "new"},
                0
        ));
        questions.add(new Question(
                "27. Which method is used to convert a string to uppercase in Java?",
                new String[]{"toUpperCase()", "upperCase()", "convertToUpper()", "stringToUpper()"},
                0
        ));
        questions.add(new Question(
                "28. Which keyword is used to define a method in Java?",
                new String[]{"method", "function", "def", "void"},
                3
        ));
        questions.add(new Question(
                "29. Which method is used to check if a string starts with a specific prefix in Java?",
                new String[]{"startsWith()", "indexOf()", "matches()", "find()"},
                0
        ));
        questions.add(new Question(
                "30. Which keyword is used to define a constructor in Java?",
                new String[]{"constructor", "init", "new", "this"},
                3
        ));
        return questions;
    }

}