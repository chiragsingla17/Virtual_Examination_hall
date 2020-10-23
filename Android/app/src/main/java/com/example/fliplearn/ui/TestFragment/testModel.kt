package com.example.fliplearn.ui.TestFragment

import android.graphics.Color
import com.example.fliplearn.R
import com.example.fliplearn.model.onlineTest
import com.github.mikephil.charting.data.BarEntry
import lecho.lib.hellocharts.model.SliceValue

data class testModel(
    val res : Int,
    val testName : String
)

object myObj {
    fun getMathsList() : ArrayList<testModel>{
        val mathsTest  = ArrayList<testModel>()
        mathsTest.add(testModel(R.drawable.mathematics_algebra,"Algebra"))
        mathsTest.add(testModel(R.drawable.mathematics_conic,"Conic Section"))
        mathsTest.add(testModel(R.drawable.mathematics_construction,"Construction"))
        mathsTest.add(testModel(R.drawable.mathematics_graphs,"Graphs"))
        mathsTest.add(testModel(R.drawable.mathematics_surface_area_and_volumes,"Surface, Area and Volumes"))
        return mathsTest
    }


    fun getPhysicsList() : ArrayList<testModel>{
        val mathsTest  = ArrayList<testModel>()
        mathsTest.add(testModel(R.drawable.physics_electrostatics,"Electrostatics"))
        mathsTest.add(testModel(R.drawable.physics_energy_momentum,"Energy and Momentum"))
        mathsTest.add(testModel(R.drawable.physics_force_rotation,"Force and Rotation"))
        mathsTest.add(testModel(R.drawable.physics_magnetics,"Magnetism"))
        return mathsTest
    }


    fun getComputerList() : ArrayList<testModel>{
        val mathsTest  = ArrayList<testModel>()
        mathsTest.add(testModel(R.drawable.computer_android,"Android"))
        mathsTest.add(testModel(R.drawable.computer_js,"Java Scripts"))
        mathsTest.add(testModel(R.drawable.computer_machine_learning,"Machine Learning"))
        mathsTest.add(testModel(R.drawable.computer_networks,"Computer Networks"))
        mathsTest.add(testModel(R.drawable.computer_sql,"SQL"))
        return mathsTest
    }


    fun getChemistryList() : ArrayList<testModel>{
        val mathsTest  = ArrayList<testModel>()
        mathsTest.add(testModel(R.drawable.chem_compounds_test,"Compounds Test"))
        mathsTest.add(testModel(R.drawable.chem_inorganic,"Inorganic Chemistry"))
        mathsTest.add(testModel(R.drawable.chem_organic,"Organic Chemistry"))
        return mathsTest
    }

    fun getRandomTest() : ArrayList<testModel>{
        val mathsTest  = ArrayList<testModel>()
        mathsTest.add(testModel(R.drawable.mathematics_graphs,"Graphs"))
        mathsTest.add(testModel(R.drawable.computer_networks,"Computer Networks"))
        mathsTest.add(testModel(R.drawable.physics_energy_momentum,"Energy and Momentum"))
        mathsTest.add(testModel(R.drawable.mathematics_conic,"Conic Section"))
        mathsTest.add(testModel(R.drawable.computer_sql,"SQL"))
        mathsTest.add(testModel(R.drawable.chem_organic,"Organic Chemistry"))
        return mathsTest
    }

    fun getDataForTest() : ArrayList<onlineTest>{
        val list = ArrayList<onlineTest>()
        list.add(onlineTest("The section contains questions on physical layer, data link layer, transport layer and network layer.","Physical Layer","Network Layer","Data Link Layer","Transport Layer",3))
        list.add(onlineTest("he section contains questions and answers on tcp, udp, ah and esp protocols.","TCP – 1","TCP – 2","UDP","AH and ESP Protocols",2))
        list.add(onlineTest("The IETF standards documents are called ________","RFC --","RCF","ID","DFC",1))
        list.add(onlineTest("In the layer hierarchy as the data packet moves from the upper to the lower layers, headers are ___________","Added --","Removed","Rearranged","Modified",1))
        list.add(onlineTest("The structure or format of data is called ___________","Syntax","Semantics"," Struct","Formatting",1))
        list.add(onlineTest("Communication between a computer and a keyboard involves ______________ transmission.","Automatic","Half-duplex","Full-duplex","Simplex",4))
        return list
    }


    var pieChartIndex = 0
    fun getPieChar_Values(): ArrayList<SliceValue> {
        val pieData1: ArrayList<SliceValue> = ArrayList()
        pieData1.add(SliceValue(15f, Color.BLUE).setLabel("Arrays"))
        pieData1.add(SliceValue(25f, Color.GRAY).setLabel("Sorting"))
        pieData1.add(SliceValue(30f, Color.MAGENTA).setLabel("Linked List"))
        pieData1.add(SliceValue(10f, Color.RED).setLabel("Stacks"))
        pieData1.trimToSize()

        val pieData2: ArrayList<SliceValue> = ArrayList()
        pieData2.add(SliceValue(15f, Color.BLUE).setLabel("BST"))
        pieData2.add(SliceValue(25f, Color.GRAY).setLabel("Heap"))
        pieData2.add(SliceValue(10f, Color.RED).setLabel("DP"))
        pieData2.add(SliceValue(60f, Color.MAGENTA).setLabel("Linked List"))
        pieData2.trimToSize()


        val pieData3: ArrayList<SliceValue> = ArrayList()
        pieData3.add(SliceValue(15f, Color.BLUE).setLabel("Greedy Algorithms"))
        pieData3.add(SliceValue(25f, Color.GRAY).setLabel("Graphs"))
        pieData3.add(SliceValue(60f, Color.RED).setLabel("Stacks"))
        pieData3.add(SliceValue(30f, Color.MAGENTA).setLabel("Bitmasking"))
        pieData3.trimToSize()

        pieChartIndex++
        if(pieChartIndex==1){
            return pieData1
        }
        else if(pieChartIndex==2){
            return pieData2
        }
        else if(pieChartIndex==3){
            return pieData1
        }
        else{
            return pieData3
        }
    }

    var index_number = 0
    fun getDataForChats() : Pair<ArrayList<String>,ArrayList<BarEntry>> {

        val labels1 = ArrayList<String>()
        labels1.add("Test1")
        labels1.add("Test2")
        labels1.add("Test3")


        val labels2 = ArrayList<String>()
        labels2.add("Test1")
        labels2.add("Test2")
        labels2.add("Test3")
        labels2.add("Test4")


        val labels3 = ArrayList<String>()
        labels3.add("Test1")
        labels3.add("Test2")
        labels3.add("Test3")
        labels3.add("Test4")
        labels3.add("Test5")

        val labels4 = ArrayList<String>()
        labels4.add("Test1")
        labels4.add("Test2")
        labels4.add("Test3")
        labels4.add("Test4")
        labels4.add("Test5")
        labels4.add("Test6")


        val barEntries1 = ArrayList<BarEntry>()
        barEntries1.add(BarEntry(2f, 0))
        barEntries1.add(BarEntry(4f, 1))
        barEntries1.add(BarEntry(6f, 2))


        val barEntries2 = ArrayList<BarEntry>()
        barEntries2.add(BarEntry(2f, 0))
        barEntries2.add(BarEntry(4f, 1))
        barEntries2.add(BarEntry(6f, 2))
        barEntries2.add(BarEntry(8f, 3))


        index_number++

        if(index_number==1){
            return Pair<ArrayList<String>,ArrayList<BarEntry>>(labels1,barEntries1)
        }
        else if(index_number==2){
            return Pair<ArrayList<String>,ArrayList<BarEntry>>(labels2,barEntries2)
        }
        else if(index_number==3){
            return Pair<ArrayList<String>,ArrayList<BarEntry>>(labels3,barEntries2)
        }
        else{
            return Pair<ArrayList<String>,ArrayList<BarEntry>>(labels4,barEntries2)
        }
    }



    var currentQuiz = 0
    fun getDataForDataStructures() : ArrayList<onlineTest> {
        val finalList = ArrayList<ArrayList<onlineTest>>()


        /**
         * -------------------------------------
         */
        val list1 = ArrayList<onlineTest>()
        list1.add(
            onlineTest(
            "In a min-heap: ",
            "parent nodes have values greater than or equal to their childs",
            "parent nodes have values less than or equal to their childs",
            "both statements are true",
            "both statements are wrong",
            1
            )
        )
        list1.add(
            onlineTest(
                "Stack is used for ",
                "CPU Resource Allocation",
                "Breadth First Traversal",
                "Recursion",
                "None of the above",
                3
            )
        )
        list1.add(
            onlineTest(
                "Which of the following is an example of dynamic programming approach?",
                "Fibonacci Series",
                "Tower of Hanoi",
                "Dijkstra Shortest Path",
                " All of the above",
                4
            )
        )
        list1.add(
            onlineTest(
                "Which of the following sorting algorithms can be used to sort a random linked list with minimum time complexity?",
                "Merge Sort",
                "Insertion Sort",
                "Quick Sort",
                "Heap Sort",
                1
            )
        )
        finalList.add(list1)

        /**
         * --------------------------------------------------
         */
        val list2 = ArrayList<onlineTest>()
        list2.add(
            onlineTest(
                "Which of the following is example of in-place algorithm?",
                "Bubble Sort",
                "Merge Sort",
                "Insertion Sort",
                "All of the above",
                2
            )
        )
        list2.add(
            onlineTest(
                "What should be added in place of \"/*ADD A STATEMENT HERE*/\", so that the function correctly reverses a linked list.",
                "*head_ref = prev;",
                "*head_ref = current;",
                "*head_ref = next;",
                "*head_ref = NULL;",
                1
            )
        )
        list2.add(
            onlineTest(
                "Which of the following uses memoization?",
                "Greedy approach",
                "Divide and conquer approach",
                "Dynamic programming approach",
                "None of the above!",
                3
            )
        )
        list2.add(
            onlineTest(
                "Heap is an example of",
                "complete binary tree",
                "spanning tree",
                "sparse tree",
                "binary search tree",
                1
            )
        )
        finalList.add(list2)


        /***
         * ----------------------------
         */

        val list3 = ArrayList<onlineTest>()
        list3.add(
            onlineTest(
                "The postfix form of the expression (A+ B)*(C*D- E)*F / G is?",
                "AB+ CD*E - FG /**",
                "AB + CD* E - F **G /",
                "AB + CD* E - *F *G /",
                "AB + CDE * - * F *G /",
                1
            )
        )
        list3.add(
            onlineTest(
                "Which of the following statements for a simple graph is correct?",
                "Every path is a trail",
                "Every trail is a path",
                "Every trail is a path as well as every path is a trail",
                "Path and trail have no relation",
                1
            )
        )
        list3.add(
            onlineTest(
                "What data structure would you mostly likely see in a non recursive implementation of a recursive algorithm?",
                "LinkList",
                "Stack",
                "Queue",
                "Tree",
                2
            )
        )
        list3.add(
            onlineTest(
                "Heap is an example of",
                "complete binary tree",
                "spanning tree",
                "sparse tree",
                "binary search tree",
                1
            )
        )



        if(currentQuiz%2==0){
            currentQuiz++
            return list1
        }
        else if(currentQuiz==1){
            currentQuiz++
            return list2
        }
        else{
            currentQuiz++
            return list3
        }
    }

}