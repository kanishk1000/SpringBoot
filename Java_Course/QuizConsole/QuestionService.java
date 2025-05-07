package QuizConsole;

import java.util.Scanner;

public class QuestionService {

    Question questions[] = new Question[5];
    String selection[] = new String[5];

    public QuestionService(){

        questions[0] = new Question(1, "Size of int", "1", "4", "8", "16", "4");
        questions[1] = new Question(2, "Size of float", "1", "4", "8", "16", "4");
        questions[2] = new Question(3, "Size of char", "1", "2", "4", "8", "2");
        questions[3] = new Question(4, "Size of long", "1", "2", "4", "8", "8");
        questions[4] = new Question(5, "Size of double", "1", "2", "4", "8", "8");

    }


    public void playQuiz(){

        int i=0;

        for(Question q : questions){

            System.out.println("Question " + q.getId() + ". " + q.getQuestion() + "_____ ?");
            System.out.println(q.getOpt1());
            System.out.println(q.getOpt2());
            System.out.println(q.getOpt3());
            System.out.println(q.getOpt4());

            Scanner s = new Scanner(System.in);
            selection[i++] = s.nextLine();
            s.close();
        }

        System.out.println("------------------------");

        for(String str : selection){
            System.out.println(str);
        }

        System.out.println("------------------------");
    }


    public void getScore() {
        
        int score = 0;

        for(int i=0; i<questions.length; i++){

            String ans = questions[i].getAnswer();
            String resp = selection[i];

            if(ans.equals(resp)){
                score++;
            }
        }

        System.out.println("Your score is " + score);
        System.out.println("------------------------");
    }
}
