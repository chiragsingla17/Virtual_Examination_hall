package com.example.fliplearn.model;


import com.example.fliplearn.R;

import java.util.ArrayList;

public class Constants {
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String youtubeAPIKEY = "AIzaSyDThXbICMAUi2aVsdfxKDx9R3OyO66HZ1c";

    public static final String[] coursesAvailable = {
            "Mathematics","English","Physics", "Chemistry", "Biology" ,"Computers" , "Accountancy","History", "Business Studies"
    };

    public static final String description = "In this video There is discussion on all the important topics of DBMS syllabus which will be useful for all compititve exams like GATE, NTA NET, NIELIT, DSSSB, IT Officer, PSUs etc as well as College/ University exams. Students will get tips for how to prepare DBMS in best way.  So Please Like, Subscribe the channel and give your valuable feedback. Need your Support..";

    public static final String[] mathsVideos = {
            "kBdlM6hNDAE",
            "3EJlovevfcA",
            "ZtVw2iuFI2w",
            "VyvTabQHevw",
            "pDX4NR4eY3A",
            "5fs1ldO6B5c",
            "upUSGUSK5k0",
            "mMxjKFiIKxs",
            "Tp37HXfekNo",
            "UyqpQ3D2yCw",
            "DM2lAomoDrg",
            "KknAgz0xGSU"
    };

    public static final String[] mathsTitle = {
            "Lec-1: DBMS Syllabus for GATE, UGCNET, NIELIT, DSSSB etc.| Full DBMS for College/University Students",
            "Lec-2: Introduction to Relational Database Management System (RDBMS) With Real life examples",
            "Lec-3: File System vs DBMS | Disadvantages of File System | DBMS Advantages",
            "Lec-4: 2 tier and 3 tier Architecture with real life examples | Database Management System",
            "Lec-5: What is Schema | How to define Schema | Database management system in Hindi",
            "Lec-6: Three Schema Architecture | Three Level of Abstraction | Database Management System",
            "Lec-7: What is Data Independence | Database Management System in Hindi",
            "Lec-8: What is CANDIDATE KEY and PRIMARY key | Full Concept | Most suitable examples | DBMS",
            "Lec-9: What is Primary Key in DBMS | Primary Key with Examples in Hindi",
            "Lec-10: Foreign Key in DBMS | Full Concept with examples | DBMS in Hindi",
            "Lec-11: Insert, Update & Delete from Foreign Key table | Referential Integrity",
            "Lec-12: Question on Foreign Key | ये Question Competition Exams में अक्सर पूछा गया है"
    };

    public static final String[] mathsDesc = {
            "In this video There is discussion on all the important topics of DBMS syllabus which will be useful for all compititve exams like GATE, NTA NET, NIELIT, DSSSB, IT Officer, PSUs etc as well as College/ University exams. Students will get tips for how to prepare DBMS in best way.  So Please Like, Subscribe the channel and give your valuable feedback. Need your Support..",
            "In this video, You will get Best introduction to DBMS or RDBMS with Real Life exmples. These examples will help you to understand DBMS in easiest and simplest way. Whether you are engineering student or class 8th student, You will get clear and best explanation of DBMS. " +
                    "Please Like, Subscribe the channel and give your valuable feedback. Need your Support..",
            "In this video, Difference between File system and DBMS discussed with real life examples and all the facts. Students will easily understand the problems in file system and advantages in DBMS.",
            "In this video, I have explained The 2 tier and # tier architecture of DBMS with real life examples. These architectures will help you to understand How DBMS works and where we actually use in real world. How companies like Amazon, Flipkart, IRCTC etc build there Online systems through DBMS architectures.",
            "In the video you will get knowledge about Schema in DBMS, What is Schema, Why we use it, Schema Kya hota. All the points explained with real life examples.",
            "In this video, 3 schema architecture is explained with examples.Complete discussion on Physical layer, Conceptual layer and View level with examples.",
            "In this video, Logical data independence and physical data independence is explained with examples in Three schema architecture. ",
            "No Description ..",
            "Primary key is one of the most important concept of DBMS. In this video you will be able to understand Primary Key with most suitable examples. ",
            "In this video You will be able to understand foreign key from scratch. Also What is referential integrity and how we maintain it in database. All points are explained with most suitable examples. Student always find this topic difficult but after watching this video all the doubts will be clear.",
            "How Insertion, deletion and updation is done in foreign key table. How insertion, deletion and updation is done in Reference table and referencing table.",
            "Numerical Question on Foreign Key Discussed in this video. This question is already asked in many competitive exams like GATE, UGC NET, NIELIT, PSUs and College/University exams."
    };

    public static ArrayList<doubtsModel> getDoubts(){
        ArrayList<doubtsModel> doubts = new ArrayList<>();
        doubts.add(new doubtsModel("100","Liam Beiber","Chemistry",null, R.drawable.question_one,R.drawable.person_one,null));
        doubts.add(new doubtsModel("50","James Pattinson","Physics","Calculate the force of attraction between two bodies with their mass 100kg each and they are 1m apart on the surface of the earth . Will the force of attraction be different Ir the same bodies are taken on the moon, their separation remaining constant?",null,R.drawable.person_two,null));
        doubts.add(new doubtsModel("20","Emma Sharma","Mathematics","Three normals to the parabola y^2 = x are drawn through a point (C, 0), then minimum value of C is 1/k. Find k",null,R.drawable.girl_two,null));
        doubts.add(new doubtsModel("150","Isabella karra","General",null,R.drawable.question_two,R.drawable.girl_one,null));
        doubts.add(new doubtsModel("100","Liam Beiber","Chemistry","Can someone explain how to test the presence of sulphates in hard water?",null,R.drawable.person_one,null));
        doubts.add(new doubtsModel("80","James Pattinson","Physics","A wire of length 3 m and area of cross-section 1.7 × 10-6 m2 has a resistance 3 × 10-2 ohm.\n" +
                "a. What is the formula for resistivity of the wire and what is the unit of it\n" +
                "b. Calculate the resistivity of the wire",null,R.drawable.person_two,null));
        return doubts;
    }

    public static String[] botAnswers = {
            "Hey how may I help?",
            "I want to learn coding",
            "You can try these courses present on platform…\n" +
                    "1. Basic Coding using C++\n" +
                    "2. Coding for babies\n",
            "Ok, Cool...",
            "Is there something else I can help you with ?",
            "What test should I attempt next?",
            "These are the recommended tests based on your recent performance (provided on home)\n" +
                    "Friction Test 1.2\n" +
                    "Kinematics Test 1.3 \n" +
                    "Work Energy, Test 2.1",
            "Great. Thanks",
            "Glad to help...\n" +
                    "Is there something else I can help you with ?",
            "Can I get some feedback on my recent performance?",
            "Your recent test scores are\n" +
                    "Physics - 84%\n" +
                    "Mathematics - 80%\n" +
                    "Your strong topics are\n" +
                    "Physics - Electrostatics, Magnetism, Gravitation\n" +
                    "Mathematics - \n" +
                    "Your weak topics\n" +
                    "Physics - Kinematics, Friction\n" +
                    "Maths - Quadratic Equation",
            "Thank you\n",
            "Is there something else I can help you with ?"
    };

}