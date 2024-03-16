# Computer Architecture Simulation Project 

PARK, Sehyun  

4-Way BSA LRU

****************To Run the Program****************    

1. We have provided a run.bat file for simple launch of the application
2. Also included a walkthrough video on how the application works  

****************Analysis of the Program****************   

Test Case 1) Requires the program to iterate from 0 to input - 1, then repeat the same sequence totaling 4 times. Each main memory block will be assigned to corresponding cache memory block with LRU aspects.  

Test Case 2) Has a fixed block number of 64, but the order of the block will be randomly generated from numbers between 0 to input - 1  

Test Case 3) Start from 0, then iterate numbers from 1 to input - 2 two times, followed by succeeding number until the number reaches input*2 - 1. Repeat the process totaling 4 times  
Example) input = 8, 0 | 1,2,3,4,5,6 | 1,2,3,4,5,6 | 7 ~ 15 {x4}  


****************Logic of the Program****************  

The program first generates a sequence depending on the test case selected and the user input. It then loops through the code until each term of the sequence has run through the code.  

For each sequence term, the program first checks whether the corresponding memory block already exists in any of the cache memory blocks:  

• If it does exist      -> Increase the counter for that cache block and move to next memory block  
• If it doesn't exist   -> Calculate the cache memory set to be assigned into using (4 % block num), after which the program looks for the block in the corresponding set with the lowest counter. Finally, the program assigns the block number to the cache block with the lowest counter, and increase it.
