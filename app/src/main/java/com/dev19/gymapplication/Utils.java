package com.dev19.gymapplication;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.material.shadow.ShadowRenderer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Type;
import java.util.ArrayList;

 public class Utils {
    private Utils(Context context) {
        sharedPreferences=context.getSharedPreferences("alternate_db",Context.MODE_PRIVATE);
    }

    public static final String ALL_TRAININGS_KEY="all_trainings";
     private static final String ALL_PLANS_KEY="all_plans";
    private static Utils instance;
    private SharedPreferences sharedPreferences;
    private static ArrayList<Training> trainings;
    private static ArrayList<Plan> plans;
    public void initTrainings() {
        if (null == getTrainings()) {
            initdata();


        }
    }


        public void initdata(){
            ArrayList<Training> trainings = new ArrayList<>();

            Training pushUp = new Training(1, "Push up", "An exercise in which a person lying face down, with the hands under the shoulders, raises the body by pushing down with the palms: push-ups are usually done in series by alternately straightening and bending the arms",
                    "Pushups are an exercise in which a person, keeping a prone position, with the hands palms down under the shoulders, the balls of the feet on the ground, and the back straight, pushes the body up and lets it down by an alternate straightening and bending of the arms\n" +
                            "\n" +
                            "Traditional pushups are beneficial for building upper body strength. They work the triceps, pectoral muscles, and shoulders. Using proper form, they can also strengthen the lower back and core by engaging (pulling in) the abdominal muscles.Pushups are a fast and effective exercise for building strength. They can be done from virtually anywhere and don’t require any equipment" + "The push-up exercise can be used in shoulder rehabilitation as it strengths the muscles around the shoulder, performing the push-up exercise with a push up bar increases the activation of shoulder stabilization muscles more than doing it on a flat surface.[4]\n" +
                            "\n" +
                            "Push-ups strengthen the core muscles, mainly the rectus abdominus and transversus abdominis.\n" +
                            "\n" +
                            "Push-ups activate a large number of muscles together, increasing the demand on the heart muscle and the respiratory rate. Also, push-ups increase the metabolic rate so they can help with weight loss.",
                    "https://www.istreetwatch.co.uk/wp-content/uploads/2019/01/push-ups.jpg");
            trainings.add(pushUp);
            Training squat = new Training(2, "Squat", "A squat is a strength exercise in which the trainee lowers their hips from a standing position and then stands back up. During the descent of a squat, the hip and knee joints flex while the ankle joint dorsiflexes; conversely the hip and knee joints extend and the ankle joint plantarflexes when standing up.",
                    "The squat is one of the most debated exercises in the fitness and sports community, but it is hard to argue its effectiveness. There is ample evidence describing its use for improving lower body muscular endurance, strength and power. There are several variations of the squat exercise including the bodyweight squat, barbell back squat, barbell front squat, dumbbell squat, sumo squat, split squat, box squat, plie squat, squat jump, overhead squat, and single-leg squat, to name a few.\n" +
                            "\n" +
                            "For the sake of this article we will discuss the barbell back squat from a fitness perspective. We will not discuss the squat as it relates to performance, such as powerlifting. Instead, we will discuss the safest variation of the squat exercise for a fitness enthusiast seeking to improve technique and minimize faulty movement patterns and potential injury.\n" +
                            "\n" +
                            "It is important to note variations of the squat exercise exist to maximize 1 repetition maximum (1RM) potential, such as using an excessively wide stance with a toe out posture. This posture reduces the amount of hip and knee flexion and ankle dorsiflexion needed to reach full depth.",
                    "https://www.invigormedical.com/wp-content/uploads/shutterstock_1045041430-768x512.jpg");
            trainings.add(squat);

            Training legPress = new Training(3, "Leg Press", "The leg press is a compound weight training exercise in which the individual pushes a weight or resistance away from them using their legs. The term leg press machine refers to the apparatus used to perform this exercise. It can help to build squat strength.",
                    "A leg press is an isolation exercise that targets muscle groups throughout your lower body, including your quadriceps, hamstrings, and glutes. Practice leg presses by sitting against the backrest of a leg press machine. Place your feet against the footplate with your knees bent at a 90-degree angle. Slowly push against the footplate to move a pulley attached to weight plates. Return the footplate to its original position and repeat for the desired amount of repetitions." + "" +
                            "There are two main types of leg presses you can practice:\n" +
                            "\n" +
                            "1. Horizontal leg press: Perform this variation by using a horizontal leg press machine, sitting upright, and pushing the footplate away from your body.\n" +
                            "2. Incline leg press: Practice this variation by using a leg press machine at a 45-degree angle. You can generally press more weight in this position, but it puts slightly more strain on your lower back." + "For the leg press, begin by using a weight that you can control for 2–3 sets of 8–15 repetitions. Choose a weight that allows you to maintain good technique throughout all sets and repetitions.\n" +
                            "\n" +
                            "1. Sit on the leg press machine with your back against the back pad and your head rested on the head pad.\n" +
                            "2. Place your feet on the resistance plate. Your feet should be hip-width or slightly wider than hip-width apart. Your entire foot should be in contact with the resistance plate, with emphasis on maintaining heel contact. Your legs should be at a 90-degree angle.\n" +
                            "3. Grab the handles with a light grip to stabilize your upper body.\n" +
                            "4. Engage your core and unrack the weight.\n" +
                            "5. Straighten your legs to move the weight off of the weight stack. Your legs should be outstretched with a slight bend in your knees, and your shoulders should be over your hips.\n" +
                            "6. While maintaining your alignment, begin the downward movement by slowly bending your hips and knees.\n" +
                            "7. Lower until your legs form a 90-degree angle. The weight on your feet should be evenly distributed, with emphasis on your heels to keep your feet flat.\n" +
                            "8. Pause for a second at the bottom position.\n" +
                            "9. To begin the upward movement, push your feet into the resistance plate. Place emphasis on pushing through your midfoot and heels while keeping your toes engaged.\n" +
                            "10. At the end of each repetition, your legs should be outstretched with a slight bend in your knees.",
                    "https://images.ctfassets.net/3s5io6mnxfqz/3s3onYQu4fAZbWkCyYkj2F/219d60fa2eeaa6f68c0a30eadbe3e866/AdobeStock_68205554.jpeg");
            trainings.add(legPress);
            Training pullups = new Training(4, "Pull Ups", "A pull-up is an upper-body strength exercise. The pull-up is a closed-chain movement where the body is suspended by the hands and pulls up. As this happens, the elbows flex and the shoulders adduct and extend to bring the elbows to the torso.",
                    "The pullup exercise is one of the most overlooked exercises for building upper body, back, and core strength. It requires a chin-up bar, which can be freestanding or you can purchase a simple doorway bar. The traditional pullup uses an overhand grip on the bar, while the chin-up is a variation that generally uses an underhand grip. If you are new to pullups, there are many modified versions that can be used to build the strength needed to perform them. Pullups can be part of an upper body strength workout or a circuit training workout." + "The pullup primarily targets the latissimus dorsi (lats) which is the large back muscle behind your arms, but it also works most of your chest, upper back, and shoulder muscles. Your abs are involved in stabilizing you as well. Strengthening your upper body will help you everyday tasks and in achieving good posture.\n" +
                            "\n" + "\nThe pullup bar should be at a height that requires you to jump up to grab it; your feet should hang free. Stand below the bar with your feet shoulder width apart. Jump up and grip the bar with an overhand grip about shoulder width apart. Fully extend your arms so you are in a dead hang. Bend your knees and cross your ankles for a balanced position. Take a breath at the bottom.\n" +
                            "\n" +
                            "Exhale while pulling yourself up so your chin is level with the bar. Pause at the top.\n" +
                            "Lower yourself (inhaling as you go down) until your elbows are straight.\n" +
                            "Repeat the movement without touching the floor.\n" +
                            "Complete the number of repetitions your workout requires.\n",
                    "https://www.sinburpeesenmiwod.com/wp-content/uploads/2021/08/Pull-ups-con-kipping-estrictas-SBEMW.jpg");
            trainings.add(pullups);


            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();
            editor.putString(ALL_TRAININGS_KEY,gson.toJson(trainings));
            editor.apply();


        }


    public ArrayList<Training> getTrainings() {
        Gson gson= new Gson();
        Type type=new TypeToken<ArrayList<Training>>(){}.getType();
        ArrayList<Training> training = gson.fromJson(sharedPreferences.getString(ALL_TRAININGS_KEY,null),type);
        return training;
    }

    public  ArrayList<Plan> getPlans() {
        Gson gson= new Gson();
        Type type=new TypeToken<ArrayList<Plan>>(){}.getType();
        ArrayList<Plan> plans = gson.fromJson(sharedPreferences.getString(ALL_PLANS_KEY,null),type);
        return plans;
    }

    public  boolean addPlan(Plan plan){

        if(null==getPlans()){
            SharedPreferences.Editor editor= sharedPreferences.edit();
            Gson gson= new Gson();
            editor.putString(ALL_PLANS_KEY,gson.toJson(new ArrayList<Plan>()));
            editor.apply();
        }
        ArrayList<Plan> plans = getPlans();
        if(null!=plans){
            if(plans.add(plan)){
                Gson gson= new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALL_PLANS_KEY);
                editor.putString(ALL_PLANS_KEY,gson.toJson(plans));
                editor.apply();
                return true;
            }
        }
        return false;
    }



    public boolean removePlan(Plan plan){

        ArrayList<Plan> plans = getPlans();
        if(null!=plans){
            for(Plan p:plans){

                if(p.getTraining().getId()==plan.getTraining().getId()){
                    if(plans.remove(p)){
                        Gson gson= new Gson();
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.remove(ALL_PLANS_KEY);
                        editor.putString(ALL_PLANS_KEY,gson.toJson(plans));
                        editor.apply();
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static Utils getInstance(Context context){
        if (null == instance) {
            instance = new Utils(context);
        }
        return instance;
    }


}
