#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <Windows.h>

#define A "\u2554" //start
#define B "\u2550"
#define C "\u2564"
#define D "\u2557" //finish
#define E "\u2566" //middle

#define F "\u2551"
#define G "\u2560"
#define H "\u2500" // -
#define I "\u256C"
#define J "\u256A" // +
#define K "\u2563"

#define L "\u255A"
#define M "\u2569"
#define N "\u255D"
#define O "\u2567"


#define Z B B B C B B B C B B B
#define Y B B B J B B B J B B B
#define X B B B O B B B O B B B

#define SIZE 9


struct random{
	int array[SIZE];
};


int getFirstRand (int array2, int array3, int array4, int array5, int array6, int array7, int array8, int array9){
	int checker = 0;
	int array1;
	
	array1 = (rand() % SIZE) + 1;
	
	while (checker < 1){
		if (array1 != array2 && array1 != array3 && array1 != array4 && array1 != array5 && array1 != array6 && array1 != array7 && array1 != array8 && array1 != array9)
			checker++;
		else{
			array1 = (rand() % SIZE) + 1;	
		}
	}
	
	return array1;
}

int lastNumber (int a, int b, int c, int d, int e, int f, int g, int h){
	int z;
	z = 45 - (a+b+c+d+e+f+g+h);
	return z;
}

int main(){
	
	int whileCtr = 0;
	char userInput;
	
		printf("                _       _          ");
		printf("\n");
		printf("               | |     | |         ");
		printf("\n");
		printf("  ___ _   _  __| | ___ | | ___   _ ");
		printf("\n");
		printf(" / __| | | |/ _` |/ _ \ | |/ / | | |");
		printf("\n");
		printf(" \__ \ |_| |   (_| | (_) |   <| |_| |");
		printf("\n");
		printf(" |___/\__,_|\__,_|  \___/ |_|\_\\__,_|");
		
		printf("\n");
		printf("\n");
			
		printf("Press ENTER to Generate!\n");
		
	while (!whileCtr){
		
		scanf("%c", &userInput);
		if (userInput == 10){
			whileCtr++;
			system("cls");	
		}
	}
	
	
	SetConsoleOutputCP(CP_UTF8);
	
	struct random r;
	struct random r2;
	struct random r3;
	struct random r4;
	struct random r5;
	struct random r6;
	struct random r7;
	struct random r8;
	struct random r9;
	
	int x;
	for (x=0; x<SIZE; x++){

	r.array[x] = -1;
	r2.array[x] = -2;
	r3.array[x] = -3;
	r4.array[x] = -4;
	r5.array[x] = -5;
	r6.array[x] = -6;
	r7.array[x] = -7;
	r8.array[x] = -8;
	r9.array[x] = -9;
}
	int i=0;
	int j=0;
	time_t t;
	srand((unsigned) time(&t)); //random number generator
	
	int flag;
	int good;
	int dupChecker;
	int rNum;
	int reallyGood = 0;
	
	while (reallyGood == 0){
	
	flag = 1;
	rNum = 0;
	r.array[0] = (rand() % SIZE) + 1; //gets random number from 1 to SIZE 
									  //+1 so that 0 is excluded							  
	
	dupChecker = 0;
	
	r.array[0] = rNum = (rand() % SIZE) + 1;
	flag = 1;
	good = 0;
	
	while(good == 0)
	{
		rNum = (rand() % SIZE) + 1;
		for (i=0; i<flag; i++)
			{
				if (rNum == r.array[i])
					dupChecker++;		
			}
		if (dupChecker == 0)
			{		
				r.array[flag] = rNum;
				flag++;	
			}
		else 
			dupChecker = 0;
		
		if (flag == 9)
			good++;
	}

	
	flag = 1;
	good = 0;
	
	r2.array[0] = getFirstRand(r.array[0], r3.array[0], r4.array[0], r5.array[0], r6.array[0], r7.array[0], r8.array[0], r9.array[0]);
	
	while(good == 0)
	{
		rNum = (rand() % SIZE) + 1;
		for (i=0; i<flag; i++)
			{
				if (rNum == r2.array[i])
					dupChecker++;		
			}
		if (rNum != r.array[flag] && dupChecker == 0)
			{		
				r2.array[flag] = rNum;
				flag++;	
			}
			
		else if (flag == 8  || flag == 7 && r2.array[8] == -2)
			flag = 1;
		else 
			dupChecker = 0;
		if (flag == 9)
			good++;
	}
	
	
	r3.array[0] = getFirstRand(r.array[0], r2.array[0], r4.array[0], r5.array[0], r6.array[0], r7.array[0], r8.array[0], r9.array[0]);
	flag = 1;
	good = 0;
	
	while(good == 0)
	{
		rNum = (rand() % SIZE) + 1;
		for (i=0; i<flag; i++)	{
			if (rNum == r3.array[i])
				dupChecker++;		
			}
			
		if (rNum != r.array[flag] && rNum != r2.array[flag] && dupChecker == 0){		
				r3.array[flag] = rNum;
				flag++;	
			}
			
		else if (flag == 8 || flag == 7 && r3.array[8] == -3)
			flag = 1;
			
		else 
			dupChecker = 0;
		
		if (flag == 9)
			good++;	
	}
		
		int cubeDupe = 0;
		
		int placeHolder[9];
		int placeHolder2[9];
		
		placeHolder[0] = r.array[0];
		placeHolder[1] = r.array[1];
		placeHolder[2] = r.array[2];
		placeHolder[3] = r2.array[0];
		placeHolder[4] = r2.array[1];
		placeHolder[5] = r2.array[2];
		placeHolder[6] = r3.array[0];
		placeHolder[7] = r3.array[1];
		placeHolder[8] = r3.array[2];

		placeHolder2[0] = r.array[3];
		placeHolder2[1] = r.array[4];
		placeHolder2[2] = r.array[5];
		placeHolder2[3] = r2.array[3];
		placeHolder2[4] = r2.array[4];
		placeHolder2[5] = r2.array[5];
		placeHolder2[6] = r3.array[3];
		placeHolder2[7] = r3.array[4];
		placeHolder2[8] = r3.array[5];
		
		for (i=0; i<8; i++){
			for (j=i+1; j<9; j++){
				if (placeHolder[i] == placeHolder[j] && i!=j)
					cubeDupe++;
				if (placeHolder2[i] == placeHolder2[j] && i!=j)
					cubeDupe++;
			}
		}
		
		if (cubeDupe == 0)
			reallyGood = 1;
		else
		{
			for (i=0; i<9; i++)
			{
				r.array[i] = -1;
				r2.array[i] = -2;
				r3.array[i] = -3;
			}
		}
	
}

	reallyGood = 0;
	
	while (reallyGood == 0){
	
	r4.array[0] = getFirstRand(r.array[0], r2.array[0], r3.array[0], r5.array[0], r6.array[0], r7.array[0], r8.array[0], r9.array[0]);		
	flag = 1;
	good = 0;
	
	while(good == 0)
	{
		rNum = (rand() % SIZE) + 1;
		for (i=0; i<flag; i++)	{
			if (rNum == r4.array[i])
				dupChecker++;		
			}
			
		if (rNum != r.array[flag] && rNum != r2.array[flag] && rNum != r3.array[flag] && dupChecker == 0){		
				r4.array[flag] = rNum;
				flag++;	
			}
			
		else if (flag == 8 || flag == 7  || flag == 6 && r4.array[8] == -4)
			flag = 1;
			
		else 
			dupChecker = 0;
		
		if (flag == 9)
			good++;	
	}
	
	r5.array[0] = getFirstRand(r.array[0], r2.array[0], r3.array[0], r4.array[0], r6.array[0], r7.array[0], r8.array[0], r9.array[0]);		
	flag = 1;
	good = 0;
	
	while(good == 0)
	{
		rNum = (rand() % SIZE) + 1;
		for (i=0; i<flag; i++)	{
			if (rNum == r5.array[i])
				dupChecker++;		
			}
			
		if (rNum != r.array[flag] && rNum != r2.array[flag] && rNum != r3.array[flag] && rNum != r4.array[flag] && dupChecker == 0){		
				r5.array[flag] = rNum;
				flag++;	
			}
			
		else if (flag == 8 || flag == 7  || flag == 6 || flag == 5 && r5.array[8] == -5)
			flag = 1;
			
		else 
			dupChecker = 0;
		
		if (flag == 9)
			good++;	
	}
		
	r6.array[0] = getFirstRand(r.array[0], r2.array[0], r3.array[0], r4.array[0], r5.array[0], r7.array[0], r8.array[0], r9.array[0]);		
	flag = 1;
	good = 0;
	
	while(good == 0)
	{
		rNum = (rand() % SIZE) + 1;
		for (i=0; i<flag; i++)	{
			if (rNum == r6.array[i])
				dupChecker++;		
			}
			
		if (rNum != r.array[flag] && rNum != r2.array[flag] && rNum != r3.array[flag] && rNum != r4.array[flag] && rNum != r5.array[flag] && dupChecker == 0){		
				r6.array[flag] = rNum;
				flag++;	
			}
			
		else if (flag == 8 || flag == 7  || flag == 6 || flag == 5 || flag == 4 && r6.array[8] == -6)
			flag = 1;
			
		else 
			dupChecker = 0;
		
		if (flag == 9)
			good++;	
	}
	
	int cubeDupe = 0;
		
		int placeHolder[9];
		int placeHolder2[9];
		
		placeHolder[0] = r4.array[0];
		placeHolder[1] = r4.array[1];
		placeHolder[2] = r4.array[2];
		placeHolder[3] = r5.array[0];
		placeHolder[4] = r5.array[1];
		placeHolder[5] = r5.array[2];
		placeHolder[6] = r6.array[0];
		placeHolder[7] = r6.array[1];
		placeHolder[8] = r6.array[2];

		placeHolder2[0] = r4.array[3];
		placeHolder2[1] = r4.array[4];
		placeHolder2[2] = r4.array[5];
		placeHolder2[3] = r5.array[3];
		placeHolder2[4] = r5.array[4];
		placeHolder2[5] = r5.array[5];
		placeHolder2[6] = r6.array[3];
		placeHolder2[7] = r6.array[4];
		placeHolder2[8] = r6.array[5];
		
		for (i=0; i<8; i++){
			for (j=i+1; j<9; j++){
				if (placeHolder[i] == placeHolder[j] && i!=j)
					cubeDupe++;
				if (placeHolder2[i] == placeHolder2[j] && i!=j)
					cubeDupe++;
			}
		}
		
		if (cubeDupe == 0)
			reallyGood = 1;
		else
		{
			for (i=0; i<9; i++)
			{
				r4.array[i] = -4;
				r5.array[i] = -5;
				r6.array[i] = -6;
			}
		}

	
}
	r7.array[0] = getFirstRand(r.array[0], r2.array[0], r3.array[0], r4.array[0], r5.array[0], r6.array[0], r8.array[0], r9.array[0]);		
	flag = 1;
	good = 0;
	
	while(good == 0)
	{
		rNum = (rand() % SIZE) + 1;
		for (i=0; i<flag; i++)	{
			if (rNum == r7.array[i])
				dupChecker++;		
			}
			
		if (rNum != r.array[flag] && rNum != r2.array[flag] && rNum != r3.array[flag] && rNum != r4.array[flag] && rNum != r5.array[flag] && rNum != r6.array[flag] && dupChecker == 0){		
				r7.array[flag] = rNum;
				flag++;	
			}
			
		else if (flag == 8 || flag == 7  || flag == 6 || flag == 5 || flag == 4 || flag == 3 && r7.array[8] == -7)
			flag = 1;
			
		else 
			dupChecker = 0;
		
		if (flag == 9)
			good++;	
	}
	
	r8.array[0] = getFirstRand(r.array[0], r2.array[0], r3.array[0], r4.array[0], r5.array[0], r6.array[0], r7.array[0], r9.array[0]);		
	flag = 1;
	good = 0;
	
	while(good == 0)
	{
		rNum = (rand() % SIZE) + 1;
		for (i=0; i<flag; i++)	{
			if (rNum == r8.array[i])
				dupChecker++;		
			}
			
		if (rNum != r.array[flag] && rNum != r2.array[flag] && rNum != r3.array[flag] && rNum != r4.array[flag] && rNum != r5.array[flag] && rNum != r6.array[flag] && rNum != r7.array[flag] && dupChecker == 0){		
				r8.array[flag] = rNum;
				flag++;	
			}
			
		else if (flag == 8 || flag == 7  || flag == 6 || flag == 5 || flag == 4 || flag == 3  || flag == 2 && r8.array[8] == -8)
			flag = 1;
			
		else 
			dupChecker = 0;
		
		if (flag == 9)
			good++;	
	}

	r9.array[0] = lastNumber(r.array[0], r2.array[0], r3.array[0], r4.array[0], r5.array[0], r6.array[0], r7.array[0], r8.array[0]);
	r9.array[1] = lastNumber(r.array[1], r2.array[1], r3.array[1], r4.array[1], r5.array[1], r6.array[1], r7.array[1], r8.array[1]);
	r9.array[2] = lastNumber(r.array[2], r2.array[2], r3.array[2], r4.array[2], r5.array[2], r6.array[2], r7.array[2], r8.array[2]);
	r9.array[3] = lastNumber(r.array[3], r2.array[3], r3.array[3], r4.array[3], r5.array[3], r6.array[3], r7.array[3], r8.array[3]);
	r9.array[4] = lastNumber(r.array[4], r2.array[4], r3.array[4], r4.array[4], r5.array[4], r6.array[4], r7.array[4], r8.array[4]);
	r9.array[5] = lastNumber(r.array[5], r2.array[5], r3.array[5], r4.array[5], r5.array[5], r6.array[5], r7.array[5], r8.array[5]);
	r9.array[6] = lastNumber(r.array[6], r2.array[6], r3.array[6], r4.array[6], r5.array[6], r6.array[6], r7.array[6], r8.array[6]);
	r9.array[7] = lastNumber(r.array[7], r2.array[7], r3.array[7], r4.array[7], r5.array[7], r6.array[7], r7.array[7], r8.array[7]);
	r9.array[8] = lastNumber(r.array[8], r2.array[8], r3.array[8], r4.array[8], r5.array[8], r6.array[8], r7.array[8], r8.array[8]);
	
	
	printf(A Z E Z E Z D);
    printf("\n" F" %d | %d | %d " F" %d | %d | %d " F" %d | %d | %d "F, r.array[0],r.array[1],r.array[2],r.array[3],r.array[4],r.array[5],r.array[6],r.array[7],r.array[8]);
    printf("\n" G Y I Y I Y K);
    printf("\n" F" %d | %d | %d " F" %d | %d | %d " F" %d | %d | %d "F, r2.array[0],r2.array[1],r2.array[2],r2.array[3],r2.array[4],r2.array[5],r2.array[6],r2.array[7],r2.array[8]);
    printf("\n" G Y I Y I Y K);
    printf("\n" F" %d | %d | %d " F" %d | %d | %d " F" %d | %d | %d "F, r3.array[0],r3.array[1],r3.array[2],r3.array[3],r3.array[4],r3.array[5],r3.array[6],r3.array[7],r3.array[8]);
    printf("\n" G Y I Y I Y K);
    printf("\n" F" %d | %d | %d " F" %d | %d | %d " F" %d | %d | %d "F, r4.array[0],r4.array[1],r4.array[2],r4.array[3],r4.array[4],r4.array[5],r4.array[6],r4.array[7],r4.array[8]);
    printf("\n" G Y I Y I Y K);
    printf("\n" F" %d | %d | %d " F" %d | %d | %d " F" %d | %d | %d "F, r5.array[0],r5.array[1],r5.array[2],r5.array[3],r5.array[4],r5.array[5],r5.array[6],r5.array[7],r5.array[8]);
    printf("\n" G Y I Y I Y K);
    printf("\n" F" %d | %d | %d " F" %d | %d | %d " F" %d | %d | %d "F, r6.array[0],r6.array[1],r6.array[2],r6.array[3],r6.array[4],r6.array[5],r6.array[6],r6.array[7],r6.array[8]);
    printf("\n" G Y I Y I Y K);
    printf("\n" F" %d | %d | %d " F" %d | %d | %d " F" %d | %d | %d "F, r7.array[0],r7.array[1],r7.array[2],r7.array[3],r7.array[4],r7.array[5],r7.array[6],r7.array[7],r7.array[8]);
    printf("\n" G Y I Y I Y K);
    printf("\n" F" %d | %d | %d " F" %d | %d | %d " F" %d | %d | %d "F, r8.array[0],r8.array[1],r8.array[2],r8.array[3],r8.array[4],r8.array[5],r8.array[6],r8.array[7],r8.array[8]);
    printf("\n" G Y I Y I Y K);
    printf("\n" F" %d | %d | %d " F" %d | %d | %d " F" %d | %d | %d "F, r9.array[0],r9.array[1],r9.array[2],r9.array[3],r9.array[4],r9.array[5],r9.array[6],r9.array[7],r9.array[8]);
   	printf("\n" L X M X M X N);
	return 0;
}
