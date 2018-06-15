import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class RoboResumeApp {

    public static void main(String[] args) {

        //the array list will store all of the output
        ArrayList<String> storage = new ArrayList();

        //variables
        String name;
        String email;

        //create a scanner object
        Scanner in = new Scanner (System.in);

        //prompt for and read in name
        System.out.print("Enter your name:");
        name = in.nextLine();

        //validate name
        while(name.contains("0") ||
              name.contains("1") ||
              name.contains("2") ||
              name.contains("3") ||
              name.contains("5") ||
              name.contains("6") ||
              name.contains("7") ||
              name.contains("8") ||
              name.contains("9")) {
            System.out.println("This is not a valid input. Please enter your name in words");
            System.out.print("Please enter your name:");
            name = in.nextLine();
        }

        //add the name to storage
        storage.add(name);

        //prompt for and read in e-mail
        System.out.print("Enter your e-mail: ");
        email = in.nextLine();

        //validate input
        while (!email.contains("@")){
            System.out.println("This is not a valid e-mail");
            System.out.print("Enter your e-mail");
            email = in.nextLine();
        }

        //add the e-mail to storage
        storage.add ("\n");
        storage.add(email);
        storage.add("\n");
        storage.add("\n");

        //add section name to the storage array
        storage.add ("Education");
        storage.add ("\n");

        //prompt for and read in educational achievements
        System.out.println("Now, we will ask you about your educational achievements (1-10)");

        //create the first educational achievement
        EducationalAchievement ed1 = new EducationalAchievement();
        System.out.print("Enter the name of your degree: ");
        ed1.setDegreeName(in.nextLine());
        while  (ed1.getDegreeName ().contains("0") ||
                                name.contains("1") ||
                                name.contains("2") ||
                                name.contains("3") ||
                                name.contains("5") ||
                                name.contains("6") ||
                                name.contains("7") ||
                                name.contains("8") ||
                                name.contains("9")) {
            System.out.println("This is not a valid degree name. Please enter the degree name in words");
            System.out.print("Please enter your degree: ");
            ed1.setDegreeName(in.nextLine());
        }

        System.out.print("Please enter the name of the school: ");
        ed1.setSchoolName(in.nextLine());

        System.out.print("Please enter the year of graduation: " );
        boolean correctYear = false;
        while (!correctYear) {
            try {
                ed1.setYear(in.nextInt());
                correctYear = true;
            } catch (InputMismatchException e) {
                System.out.print("Please enter a year in numeric digits: ");
            }
        }

        // add the first educational achievement to the storage array
        storage.add(ed1.toString());
        //create a boolean to see if there are more educational achievement fields to enter
        boolean moreEducation = false;
        //prompt to see if there are more educational achievements to enter
        System.out.print("Do you have more educational achievements to enter?(y/n) ");
        in.next();
        String response = in.nextLine();
        if (response.equalsIgnoreCase("y")){
            moreEducation = true;
        }
        // create a loop to ask for additional educational achievements up to 10
        while (moreEducation && EducationalAchievement.numberOfAchievements <=10 ){
            EducationalAchievement ed = new EducationalAchievement();
            System.out.print("Enter the name of your degree: ");
            ed.setDegreeName(in.nextLine());
            while   (ed.getDegreeName ().contains("0") ||
                                    name.contains("1") ||
                                    name.contains("2") ||
                                    name.contains("3") ||
                                    name.contains("5") ||
                                    name.contains("6") ||
                                    name.contains("7") ||
                                    name.contains("8") ||
                                    name.contains("9")) {
                System.out.println("This is not a valid degree name. Please enter the degree name in words");
                System.out.print("Please enter your degree: ");
                ed.setDegreeName(in.nextLine());
            }

            System.out.print("Please enter the name of the school: ");
            ed.setSchoolName(in.nextLine());

            System.out.print("Please enter the year of graduation: " );
                correctYear = false;
            while (!correctYear) {
                try {
                    ed.setYear(in.nextInt());
                    correctYear = true;
                } catch (InputMismatchException e) {
                    System.out.print("Please enter a year in numeric digits: ");
                }
            }
            //add the educational achievement to the storage array
            storage.add(ed.toString());
            //prompt to see if there are more educational achievements to enter
            System.out.print("Do you have more educational achievements to enter?(y/n) ");
            response = in.nextLine();
            if (!response.equalsIgnoreCase("y")){
                moreEducation = false;
            }
        }
        if (EducationalAchievement.numberOfAchievements > 10) {
            System.out.println("You may only enter 10 achievements");
        }
        //add a space after the section to the storage array
        storage.add("\n");
        storage.add("\n");
        //prompt for and read in work experience?
        System.out.println("Now, we will ask you about your work experience (0-10)");

        //use a boolean value to test if they have any work experiences
        boolean hasWorkExperience = false;
        System.out.print("Do you have any work experiences to enter? (y/n)");
        response = in.nextLine();
        if (response.equalsIgnoreCase("y")){
            hasWorkExperience = true;
        }
        if (hasWorkExperience) {
            //add work experience section to the storage array list
            storage.add("Experience");
            storage.add ("\n");
            //create a boolean to see if there are more work experience fields to enter
            boolean moreExperience = true;
            while (moreExperience && WorkExperience.numberOfExperiences <= 10) {
                //create a new work experience
                WorkExperience w = new WorkExperience();
                //prompt for the job title
                System.out.print("Enter the job title: ");
                //assume that job title can contain numbers, so no validation here
                w.setJobTitle(in.nextLine());
                //prompt for the company name
                System.out.print("Please enter the name of the company: ");
                //name of the company may also include numbers
                w.setCompany(in.nextLine());
                //prompt for the start date
                System.out.print("Please enter the start date: ");
                //the start date may contain words, but needs to contain at least some numbers
                w.setStartDate(in.nextLine());
                while (!(w.getStartDate().contains("0") ||
                        w.getStartDate().contains("1") ||
                        w.getStartDate().contains("2") ||
                        w.getStartDate().contains("3") ||
                        w.getStartDate().contains("5") ||
                        w.getStartDate().contains("6") ||
                        w.getStartDate().contains("7") ||
                        w.getStartDate().contains("8") ||
                        w.getStartDate().contains("9"))) {
                    System.out.println("This is not a valid start date. Please enter the start date with digits");
                    System.out.print("Please enter the start date: ");
                    w.setStartDate(in.nextLine());
                }
                //prompt for the end date
                System.out.print("Please enter the end date: ");
                //the end date need to either contain a number or the word present
                w.setEndDate(in.nextLine());
                while (!(w.getEndDate().contains("0") ||
                        w.getEndDate().contains("1") ||
                        w.getEndDate().contains("2") ||
                        w.getEndDate().contains("3") ||
                        w.getEndDate().contains("5") ||
                        w.getEndDate().contains("6") ||
                        w.getEndDate().contains("7") ||
                        w.getEndDate().contains("8") ||
                        w.getEndDate().contains("9")) ||
                        w.getEndDate().trim().equalsIgnoreCase("present")) {
                    System.out.println("This is not a valid end date. Please enter the end date with digits or the word \"present\"");
                    System.out.print("Please enter the end date: ");
                    w.setEndDate(in.nextLine());
                }
                //prompt for the number of duties performed
                int numberOfDuties;
                System.out.print("How many duties do you wish to enter for this job? ");
                numberOfDuties = Integer.valueOf(in.nextLine());
                ArrayList<String> duties = new ArrayList<>();
                for (int i = 1; i <=numberOfDuties; i++) {
                    System.out.print("Please enter duty number " + i + ": ");
                    duties.add(in.nextLine());
                }
                //pass the duties list to the set function of the work experience
                w.setDuties(duties);

                //add the work experience to the storage array list
                storage.add(w.toString());
                //prompt to see if there are more work experience to enter
                System.out.print("Do you have more jobs to enter?(y/n) ");
                response = in.nextLine();
                if (!response.equalsIgnoreCase("y")) {
                    moreExperience = false;
                }
            }
            if (WorkExperience.numberOfExperiences > 10) {
                System.out.println("You many only enter 10 work experiences.");
            }
        }
            //add a space and a new section name to the storage array
            storage.add("\n");
            storage.add ("Skills");
            storage.add("\n");

            //move to the skills section
            System.out.println("We will now ask you about your skills (1-20) and proficiency rating in those skills (" +
                    "\"highly-skilled\", \"proficient\", or \"familiar\")");
            //create and gather information for the first skill
            Skill s1 = new Skill ();
            System.out.print("Enter the first skill: ");
            //skill names should not contain numbers;
            s1.setSkill(in.nextLine());
            while (s1.getSkill().contains("0") ||
                   s1.getSkill().contains("1") ||
                   s1.getSkill().contains("2") ||
                   s1.getSkill().contains("3") ||
                   s1.getSkill().contains("4") ||
                   s1.getSkill().contains("5") ||
                   s1.getSkill().contains("5") ||
                   s1.getSkill().contains("6") ||
                   s1.getSkill().contains("7") ||
                   s1.getSkill().contains("8") ||
                   s1.getSkill().contains("9")) {
                System.out.println("The skill name should not contain any digits.");
                System.out.println("Enter the first skill: ");
                s1.setSkill(in.nextLine());
            }

            //prompt for the proficiency level for the first skill
            System.out.print("Enter the proficiency level for the skill: ");
            //proficiency level may only be "highly-skilled", "proficient", or "familiar"
            s1.setProficiency(in.nextLine());
            while (!(s1.getProficiency().trim().equalsIgnoreCase("proficient")||
                     s1.getProficiency().trim().equalsIgnoreCase("highly-skilled")||
                     s1.getProficiency().trim().equalsIgnoreCase("familiar"))){
                System.out.println("The proficiency level should be \"highly-skilled\", \"proficient\", or \"familiar\"");
                System.out.print("Enter the proficiency level for the skill: ");
                s1.setProficiency(in.nextLine());
            }
            //add the first skill to the storage array list
            storage.add(s1.toString());
            //create a boolean to test if the user has more skills to enter
            boolean moreSkills = false;
            //ask the user if they have more skills to enter
            System.out.print("Do you have more skills to enter(y/n)?  ");
            response = in.nextLine();
            if (response.equalsIgnoreCase("y")){
                moreSkills = true;
            }
            //create a loop to ask for skills up to 20
            while (moreSkills && Skill.numberOfSkills <= 20){
                //create and gather information for the first skill
                Skill s = new Skill ();
                System.out.print("Enter the first skill: ");
                //skill names should not contain numbers;
                s.setSkill(in.nextLine());
                while  (s.getSkill().contains("0") ||
                        s.getSkill().contains("1") ||
                        s.getSkill().contains("2") ||
                        s.getSkill().contains("3") ||
                        s.getSkill().contains("4") ||
                        s.getSkill().contains("5") ||
                        s.getSkill().contains("5") ||
                        s.getSkill().contains("6") ||
                        s.getSkill().contains("7") ||
                        s.getSkill().contains("8") ||
                        s.getSkill().contains("9")) {
                    System.out.println("The skill name should not contain any digits.");
                    System.out.println("Enter the first skill: ");
                    s.setSkill(in.nextLine());
                }

                //prompt for the proficiency level for the skill
                System.out.print("Enter the proficiency level for the skill: ");
                //proficiency level may only be "highly-skilled", "proficient", or "familiar"
                s.setProficiency(in.nextLine());
                while (!s.getProficiency().trim().equalsIgnoreCase("proficient")||
                       !s.getProficiency().trim().equalsIgnoreCase("highly-skilled")||
                       !s.getProficiency().trim().equalsIgnoreCase("familiar")){
                    System.out.println("The proficiency level should be \"highly-skilled\", \"proficient\", or \"familiar\"");
                    System.out.print("Enter the proficiency level for the skill: ");
                    s.setProficiency(in.nextLine());
                }
                //add the skill to the storage array
                storage.add(s.toString());
                //ask the user if they have more skills to enter
                System.out.print("Do you have more skills to enter(y/n)?  ");
                response=in.nextLine ();
                if (response.equalsIgnoreCase("y")){
                    moreSkills = true;
                }
            }
            if (Skill.numberOfSkills > 20) {
                System.out.println("You may only enter up to 20 skills.");
            }

            //output all of the information to the screen
            System.out.println("=======================================================");
            for (String item: storage){
                System.out.print(item);
            }

            System.out.println("*******outputting your resume to resume.txt********");

            //create a new file
            File file = new File ("resume.txt");
            PrintWriter out = null;
            try {
                out = new PrintWriter(file);
                out.println("=======================================================");
                for (String item: storage){
                    out.print(item);
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                if (out != null) {
                    out.close();
                }
            }



    }
}

