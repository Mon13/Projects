#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <sys/time.h>
void *IOPS_function(void *ptr);
void *FLOPS_function(void *ptr);


struct timeval starttime, endtime;
int main()
{
pthread_t threads[50];

int iret1,iret2,i,j;
printf("CPU performance benchmark:\n");
for(i=1;i<10;i=i*2)
{
	long int filesize=(100000)/i;
	
gettimeofday(&starttime,NULL);
double start_time = 1000000 * starttime.tv_sec + starttime.tv_usec;
double sec1 = start_time / 1000000.0;

long int *param = (long int *)malloc(100000* sizeof(int));
	param[0] = filesize;
for(j=0;j<i;j++)
{
iret1 =	pthread_create(	&threads[j],	NULL,	IOPS_function,	param);
sleep(0);
}

for(j=0;j<i;j++)
{
iret1 =	pthread_join(threads[j],NULL);
}
gettimeofday(&endtime,NULL);
double end_time = 1000000 * endtime.tv_sec + endtime.tv_usec;
double sec2 = end_time / 1000000.0;
double total_duration=(double)sec2-sec1;
double result=(double)((100000/total_duration)*14)/1000000000;
printf("The processor speed in terms of GigaIOPS with %d  threads is %1f\n",i,result );
free(param);
}

printf("\n\n");
for(i=1;i<10;i=i*2)
{
	
	long int fsize=(100000)/i;
	
gettimeofday(&starttime,NULL);
double start_time = 1000000 * starttime.tv_sec + starttime.tv_usec;
double sec1 = start_time / 1000000.0;

long int *param1 = (long int *)malloc(100000* sizeof(int));
	param1[0] = fsize;

for(j=0;j<i;j++)
{
iret1 =	pthread_create(	&threads[j],	NULL,	FLOPS_function,	param1);
sleep(0);
}

for(j=0;j<i;j++)
{
iret1 =	pthread_join(threads[j],NULL);
}
gettimeofday(&endtime,NULL);
double end_time = 1000000 * endtime.tv_sec + endtime.tv_usec;
double sec2 = end_time / 1000000.0;
double total_duration=(double)sec2-sec1;
double result=(double)((100000/total_duration)*14)/1000000000;
printf("The processor speed in terms of GigaFLOPS with %d  threads is %1f\n",i,result );
free(param1);
}


}



void *IOPS_function(void *parm )
{
long int *param = (long int *)parm;
    long int fsize = param[0];
long int i,sum;
for	(i=0;i<fsize;i++)
{
sum=100+200+500*500+80*90+71+69+411+987+654+321*458*125;
}
}

void *FLOPS_function(void *parm )
{
long int *param = (long int *)parm;
    long int fsize = param[0];
long int i;
double sum;
for	(i=0;i<fsize;i++)
{
sum=10.225+20.669+50.587*50.17+80.698*90.89+71.12+69.13+41.2+98.025+65.6+21.45*458.12*12.789;
}

}

