package com.example.fliplearn.ui.TestFragment

import com.example.fliplearn.R
import com.example.fliplearn.model.onlineTest

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

}